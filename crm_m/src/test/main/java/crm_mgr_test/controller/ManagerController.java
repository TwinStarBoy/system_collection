package crm_mgr_test.controller;

import javax.servlet.http.HttpServletRequest;

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


@RestController
public class ManagerController {

// POST method 
	@RequestMapping(value="/", method = RequestMethod.POST)
	@ResponseBody
	public MLoginAns login(MLogin mlg, HttpServletRequest req) {
		
		System.out.println(mlg.getRequestid().toString());
		//System.out.println(.toHexString(mlg.getMessageid()));

		// process login staff here		
		MLoginAns ans = new MLoginAns(mlg.requestid());
		
		System.out.println(req.getParameter("passwords"));
		
		// code verification check
		
		// database username and passwd check
		
		ans.loginst(ComStatus.LoginStatus.SUCCESS);
		//java class convert to json
		return ans;
	}

	@RequestMapping("/forgot")
	@ResponseBody
	public MForgotPwAns forgotPasswords(MForgotPw fgpw, HttpServletRequest req) {		
		// check if input legal
		MForgotPwAns ans = new MForgotPwAns();
		// contruct return message
		ans.requestid(fgpw.requestid()).email(fgpw.email()).status(fgpw.reviewdata());
		
		// perform business logic
		if(ans.status()!= ComStatus.ForgotPwStatus.SUCCESS) {
			return ans;
		}
		
		// request id		
		// message id
		
		return ans;
	}
	
//	mResetPw	0x8009	{requestid, sessionid,managerid,passwords,repasswords}	HTTP
//	mResetPwAns	0x800A	{requestid, sessionid,managerid,status,comment}	HTTP
	@RequestMapping("/reset")
	@ResponseBody
	public MResetPwAns resetPasswords(MResetPw rspw, HttpServletRequest req) {
		// check if input legal
		MResetPwAns ans = new MResetPwAns();
		
		ans.requestid(rspw.requestid()).status(rspw.reviewdata());
		return ans;
	}
	
//	mChangePw	0x8011	{requestid, sessionid, managerid, oldpw, newpw, repw }	HTTP
//	mChangePwAns	0x8012	{requestid, sessionid, managerid, status, comment}	HTTP
	@RequestMapping("/changepw")
	@ResponseBody
	public MChangePwAns changePasswords(MChangePw cgpw, HttpServletRequest req)	{
		// check if input legal construct answer object
		MChangePwAns ans = new MChangePwAns();
		
		return ans;
	}
	
	
	
	
	
}

  