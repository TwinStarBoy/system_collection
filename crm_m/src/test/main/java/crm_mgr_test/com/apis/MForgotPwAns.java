package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.ForgotPwStatus;

public class MForgotPwAns {
	
	// constructors
	
	// getters and setters
	// getters

	public UUID requestid() {
		return this.requestid;
	}

	public short messageid() {
		return this.messageid;
	}

	public String managerid() {
		return this.managerid;
	}

	public String email() {
		return this.email;
	}

	public ForgotPwStatus status() {
		return this.status;
	}

	public String comment() {
		return this.comment;
	}

	// setters

	public MForgotPwAns requestid(String requestid) {
		this.requestid = UUID.fromString(requestid);
		return this;
	}

	public MForgotPwAns requestid(UUID requestid) {
		this.requestid = requestid;
		return this;
	}

	public MForgotPwAns messageid(Integer messageid) {
		this.messageid = messageid.shortValue();
		return this;
	}

	public MForgotPwAns managerid(String managerid) {
		this.managerid = managerid;
		return this;
	}

	public MForgotPwAns email(String email) {
		this.email = email;
		return this;
	}

	public MForgotPwAns status(ForgotPwStatus status) {
		this.status = status;
		return this;
	}

	public MForgotPwAns comment(String comment) {
		this.comment = comment;
		return this;
	}

	private UUID requestid;
	private short messageid;
	private String managerid;
	private String email;
	private ForgotPwStatus status;
	private String comment;

}
// mForgotPwAns 0x8008 {requestid, sessionid,managerid,email,status,comment}
// HTTP
