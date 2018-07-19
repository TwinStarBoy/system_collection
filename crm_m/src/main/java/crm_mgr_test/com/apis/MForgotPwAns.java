package crm_mgr_test.com.apis;

import java.util.UUID;
import crm_mgr_test.com.apis.ComStatus.ForgotPwStatus;

//mForgotPwAns 0x8008 {requestid, sessionid,managerid,email,status,comment} HTTP

public class MForgotPwAns {

	private UUID requestid;
	private String messageid;
	private String email;
	private ForgotPwStatus status;
	private String comment;

	// constructors
	public MForgotPwAns() {
		this.messageid = "8008";
	}

	public MForgotPwAns(UUID requestid) {
		this.messageid = "8008";
		this.requestid = requestid;
	}

	// getters and setters

	public UUID getRequestid() {
		return requestid;
	}

	public void setRequestid(UUID requestid) {
		this.requestid = requestid;
	}

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public ForgotPwStatus getStatus() {
		return status;
	}

	public void setStatus(ForgotPwStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}



}
