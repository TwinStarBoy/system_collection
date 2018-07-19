package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.ResetPwStatus;

//mResetPwAns	0x800A	{requestid, sessionid,managerid,status,comment}	HTTP
public class MResetPwAns {
	
	public MResetPwAns(){
		this.messageid = (short)0x800A;
	}

	// getters and setters
	// getters
	
	public short messageid() {
		return this.messageid;
	}
	
	public UUID requestid() {
		return this.requestid;
	}
	
	public String managerid() {
		return this.managerid;
	}
	
	public ResetPwStatus status() {
		return this.status;
	}
	
	public String comment() {
		return this.comment;
	}
	
	// setters
	public MResetPwAns messageid(Integer messageid) {
		this.messageid = messageid.shortValue();
		return this;
	}
	
	public MResetPwAns requestid(UUID requestid) {
		this.requestid = requestid;
		return this;
	}
	
	public MResetPwAns requestid(String requestid) {
		this.requestid = UUID.fromString(requestid);
		return this;
	}
	
	public MResetPwAns managerid(String managerid) {
		this.managerid = managerid;
		return this;
	}
	
	public MResetPwAns status(ResetPwStatus status) {
		this.status = status;
		return this;
	}
	
	public MResetPwAns comment(String comment) {
		this.comment = comment;
		return this;
	}
	
	private short 			messageid;
	private UUID 			requestid; 
	private String			managerid;
	private	ResetPwStatus	status;
	private	String			comment;
}


