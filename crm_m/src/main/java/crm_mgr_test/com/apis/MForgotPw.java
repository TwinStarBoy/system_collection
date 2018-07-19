package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.ForgotPwStatus;
import crm_mgr_test.com.apis.ComStatus.LoginStatus;

//	mForgotPw	0x8007	{requestid, sessionid,managerid,email,verificationcode}	HTTP

public class MForgotPw {
	
	private String	messageid;
	private UUID 	requestid;
	private String	email;
	private String	verificationcode;
	
	public MForgotPw() {
		this.messageid = "8007";
	}
	
	// Check if input legal
	public ForgotPwStatus reviewdata(){
		// general checking
		if(this.messageid == null)
			return ForgotPwStatus.WRONG_MSGID;
		if(!this.messageid.equals("8007"))
			return ForgotPwStatus.WRONG_MSGID;
		if(this.requestid == null)
			return ForgotPwStatus.REQID_ERROR;
		if(this.requestid.toString().length()!=36)			
			return ForgotPwStatus.REQID_ERROR;
		
		// length checking	
		if((this.email!=null)&&(this.email.length()>ComStatus.INPUT_EMAIL_LENGTH))
			return ForgotPwStatus.EMAIL_FORMAT_ERR;			
		if((this.verificationcode!=null)&&(this.verificationcode.length()>ComStatus.INPUT_NORMSG_LENGTH))
			return ForgotPwStatus.VARCODE_LENGTH_ERR;
		
		// format checking
		if(!ComStatus.emailFormatCheck(this.email))
			return ForgotPwStatus.EMAIL_FORMAT_ERR;
		if(!ComStatus.userFormatCheck(this.verificationcode))
			return ForgotPwStatus.VARCODE_FORMAT_ERR;
		
		
		return ForgotPwStatus.SUCCESS;
	}

	// getters setters
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerificationcode() {
		return verificationcode;
	}

	public void setVerificationcode(String verificationcode) {
		this.verificationcode = verificationcode;
	}

	
}
