package crm_mgr_test.com.apis;

import java.util.UUID;
import crm_mgr_test.com.apis.ComStatus.LoginStatus;
import crm_mgr_test.com.apis.ComStatus.ResetPwStatus;

//mResetPw	0x8009	{requestid, sessionid,managerid,passwords,repasswords,token}	HTTP
public class MResetPw {
	
	private String	messageid;
	private UUID	requestid;
	private int 	managerid;
	private String 	password;
	private String 	repassword;
	private UUID 	token;
	


	public MResetPw() {
		this.messageid = "8009";
	}
	
	public MResetPw(UUID requestid) {
		this.messageid = "8009";
		this.requestid = requestid;
	}
	
	public ResetPwStatus reviewdata() {
		
		// general checking
		if(!this.messageid.equals("8009"))
			return ResetPwStatus.WRONG_MSGID;
		if(this.requestid == null)
			return ResetPwStatus.REQID_ERROR;
		if(this.requestid.toString().length()!=36)			
			return ResetPwStatus.REQID_ERROR;
		if(this.managerid==0)
			return ResetPwStatus.ILLEGAL_USER;
		if(this.token == null)
			return ResetPwStatus.TOKEN_ERROR;
		
		// length checking	
		if((this.password!=null)&&(this.password.length()>ComStatus.INPUT_NORMSG_LENGTH))
			return ResetPwStatus.PASSWD_LENGTH_ERR;				
		if((this.repassword!=null)&&(this.repassword.length()>ComStatus.INPUT_NORMSG_LENGTH))
			return ResetPwStatus.REPASSWD_LENGTH_ERR;
		
		// format checking 
		if(!ComStatus.useridFormatCheck(this.managerid))
			return ResetPwStatus.USERID_FORMAT_ERR;
		if(!ComStatus.passwdFormatCheck(this.password))
			return ResetPwStatus.PASSWD_FORMAT_ERR;
		if(!ComStatus.passwdFormatCheck(this.repassword))
			return ResetPwStatus.REPASSWD_FORMAT_ERR;

		// logic checks		
		if(!this.getPassword().equals(this.getRepassword()))
			return ResetPwStatus.PASSWD_REPASSWD_UNMATCH;
		
		return ResetPwStatus.SUCCESS;
	}
	
	// getters and setters
	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public UUID getRequestid() {
		return requestid;
	}

	public void setRequestid(UUID requestid) {
		this.requestid = requestid;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepasswords(String repassword) {
		this.repassword = repassword;
	}	
	
	public UUID getToken() {
		return token;
	}

	public void setToken(UUID token) {
		this.token = token;
	}
	
}
