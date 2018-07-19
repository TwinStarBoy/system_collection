package crm_mgr_test.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import crm_mgr_test.com.apis.ComStatus;
import crm_mgr_test.com.apis.MChangePw;
import crm_mgr_test.com.apis.MChangePwAns;
import crm_mgr_test.com.apis.MForgotPw;
import crm_mgr_test.com.apis.MForgotPwAns;
import crm_mgr_test.com.apis.MLogin;
import crm_mgr_test.com.apis.MLoginAns;
import crm_mgr_test.com.apis.MResetPw;
import crm_mgr_test.com.apis.MResetPwAns;
import crm_mgr_test.dao.ManagerDao;
import crm_mgr_test.domain.Manager;
import crm_mgr_test.domain.MgrToken;
import crm_mgr_test.repository.RedisRepository;


@RestController
public class ManagerController {

	@Autowired
    private RedisRepository redisRepository;

	@Autowired
    private ManagerDao managerDao;
		
	// POST method 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public MLoginAns login(MLogin mlg) {
		
		// check if input are legal
		ComStatus.LoginStatus st = mlg.reviewData();
		
		// construct ans message
		MLoginAns ans = new MLoginAns(mlg.getRequestid());
		
		//#define debug
		ans.setEmail(mlg.getEmail());
		ans.setLoginname(mlg.getLoginname());
		ans.setManagerid(mlg.getManagerid());
		//#####
		
		if(st!=ComStatus.LoginStatus.SUCCESS) {
			ans.setStatus(st);
			return ans;
		}
		
		// code verification check
		
		// database email and passwd check
		
		Manager manager = new Manager();
		
		if((mlg.getEmail()!=null)&&(!mlg.getEmail().equals(""))) {
			
			manager = managerDao.getEmailFromEmailPW(mlg.getEmail(), mlg.getPassword());
			
			if(manager != null){
				ans.setStatus(ComStatus.LoginStatus.SUCCESS);
				ans.setManagerid(manager.getManagerid());
				ans.setEmail(manager.getEmail());
				ans.setPermissionCode(manager.getPermissionCode());
			} else
				ans.setStatus(ComStatus.LoginStatus.PASSWD_USER_NO_MATCH);
			
			return ans;
		}
		
		// database loginname and passwd check
		if((mlg.getLoginname()!=null)&&(!mlg.getLoginname().equals(""))) {
			
			manager = managerDao.getUserFromUserPW(mlg.getLoginname(),mlg.getPassword());
			
			if(manager != null){
				ans.setStatus(ComStatus.LoginStatus.SUCCESS);
				ans.setManagerid(manager.getManagerid());
				ans.setLoginname(manager.getLoginname());
				ans.setPermissionCode(manager.getPermissionCode());
			}else 
				ans.setStatus(ComStatus.LoginStatus.PASSWD_USER_NO_MATCH);
			
			return ans;
		}
		
		// database managerid and passwd check
		if(mlg.getManagerid()!=0) {
			
			manager = managerDao.getMidFromMidPW(mlg.getManagerid(), mlg.getPassword());
			
			if(manager != null){
				ans.setStatus(ComStatus.LoginStatus.SUCCESS);
				ans.setManagerid(manager.getManagerid());
				ans.setPermissionCode(manager.getPermissionCode());
			}
			else 
				ans.setStatus(ComStatus.LoginStatus.PASSWD_USER_NO_MATCH);
			
			return ans;
		}
		
		ans.setStatus(ComStatus.LoginStatus.UNKNOWN);
	
		return ans;//java class convert to json
	}

	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	@ResponseBody
	public MForgotPwAns forgotPasswords(MForgotPw fgpw, HttpServletRequest req) {		
		
		// check if input legal
		ComStatus.ForgotPwStatus st = fgpw.reviewdata();

		// contruct return message
		MForgotPwAns ans = new MForgotPwAns(fgpw.getRequestid());
		ans.setEmail(fgpw.getEmail());
		
		if(st!=ComStatus.ForgotPwStatus.SUCCESS) {
			ans.setStatus(st);
			return ans;
		}
		
		// check verification code
		
		// implement verification code
		
		// Business Logic
		
		// 0 step: get manager from managerid
		Manager mgr = this.managerDao.getManagerFromEmail(fgpw.getEmail());
		if(mgr==null) {
			ans.setStatus(ComStatus.ForgotPwStatus.EMAIL_INVALID);
			return ans;
		}
			
		// 1 step: provide a token with email in redis (managerid + token(UUID))
		MgrToken mt = new MgrToken(mgr.getManagerid(), UUID.randomUUID());
		this.redisRepository.add(mt);
		
		// 2 step: trigger an email sent to target email include (managerid + token)		
		
		
		// 3 step: if everything ok, return success
		ans.setStatus(ComStatus.ForgotPwStatus.SUCCESS);
	
		return ans;
	}
	
	@RequestMapping(value = "/resetpw", method = RequestMethod.POST)
	@ResponseBody
	public MResetPwAns resetPasswords(MResetPw rspw, HttpServletRequest req) {
		
		// check if input legal
		ComStatus.ResetPwStatus st = rspw.reviewdata();
				
		// construct return message
		MResetPwAns ans = new MResetPwAns(rspw.getRequestid());
		ans.setStatus(st);
		
		if(st!=ComStatus.ResetPwStatus.SUCCESS) {
			ans.setStatus(st);
			return ans;
		}
		
		// check if token match redis's token
		if(rspw.getToken()==null) {
			ans.setStatus(ComStatus.ResetPwStatus.TOKEN_ERROR);
			return ans;
		}				
		
		if(!rspw.getToken().equals(this.redisRepository.findToken(rspw.getManagerid()))){
			ans.setStatus(ComStatus.ResetPwStatus.TOKEN_ERROR);
			return ans;
		}
		
		// reset user's passwords database value
		if(managerDao.updatePassword(rspw.getManagerid(), rspw.getPassword())==0) {
			ans.setStatus(ComStatus.ResetPwStatus.UPDATEPW_FAILED);
			return ans;
		}
		
		return ans;
	}
	
	@RequestMapping(value = "/changepw", method = RequestMethod.POST)
	@ResponseBody
	public MChangePwAns changePasswords(MChangePw cgpw, HttpServletRequest req)	{
		// check if input legal
		ComStatus.ChangePwStatus st = cgpw.reviewdata();
		
		// construct answer object
		MChangePwAns ans = new MChangePwAns(cgpw.getRequestid());
		ans.setManagerid(cgpw.getManagerid());
		
		if(st!=ComStatus.ChangePwStatus.SUCCESS) {
			ans.setStatus(st);
			return ans;
		}
						
		// check if old password is valid
		if(managerDao.getMidFromMidPW(cgpw.getManagerid(), cgpw.getOldpw())==null) {
			ans.setStatus(ComStatus.ChangePwStatus.OLDPW_INVALID);
			return ans;
		}
		
		// if it is valid change it to be new password
		if(managerDao.updatePassword(cgpw.getManagerid(), cgpw.getNewpw())==0){
			ans.setStatus(ComStatus.ChangePwStatus.PWUPDATE_FAILED);
			return ans;
		}
		
		ans.setStatus(ComStatus.ChangePwStatus.SUCCESS);
		
		return ans;
	}
	
}

  
/*
 * 	// testing methods
	//----------------------------------
	private static int counter = 0;
	
	@RequestMapping("/getRedis")
	@ResponseBody
	public MgrToken getRedis() {
		//insert something  
		MgrToken token = new MgrToken(this.counter++, UUID.randomUUID());
		//token.setManagerid(this.counter++);
		//token.setToken(UUID.randomUUID());
		this.redisRepository.add(token);
				
		// get token from the map
		MgrToken retToken = new MgrToken(this.counter-1,this.redisRepository.findToken(this.counter -1));
		
		// and return token
		
		//this.redisRepository.delete(mangerid);
		return retToken;
		//return this.redisRepository.findAllTokens();
	}
	
	//----------------------------------
 * 
 * */