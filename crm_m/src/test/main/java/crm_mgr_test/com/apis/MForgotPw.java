package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.ForgotPwStatus;

//	mForgotPw	0x8007	{requestid, sessionid,managerid,email}	HTTP

public class MForgotPw {
	
	public MForgotPw() {
		this.messageid = (short)0x8007;
	}
	
	// Check if input legal
	public ForgotPwStatus reviewdata(){
		if(this.messageid!= 0x8007)
			return ComStatus.ForgotPwStatus.MESSAGEID_MISS_MATCH;
		
		
		return ComStatus.ForgotPwStatus.SUCCESS;
	}

	// getters setters
	// getters
	public short messageid(){
		return this.messageid;
	}
	
	public UUID requestid(){
		return this.requestid;
	}
	
	public String email() {
		return this.email;
	}
	
	// setters
	public MForgotPw messageid(Integer messageid) {
		this.messageid = messageid.shortValue();
		return this;
	}
	
	public MForgotPw requestid(String requestid){
		this.requestid = UUID.fromString(requestid);
		return this;
	}
	
	public MForgotPw email(String email) {
		this.email = email;
		return this;
	}
	
	private short	messageid;
	private UUID 	requestid;
	private String	email;
	
}
