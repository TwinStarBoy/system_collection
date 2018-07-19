package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.ResetPwStatus;

//mResetPwAns	0x800A	{requestid, sessionid,managerid,status,comment}	HTTP
public class MResetPwAns {
	
	private int				managerid;
	private String 			messageid;
	private UUID 			requestid; 
	private	ResetPwStatus	status;
	private	String			comment;

	
	public MResetPwAns(){
		this.messageid = "800A";
	}

	public MResetPwAns(UUID requestid){		
		this.messageid = "800A";
		this.requestid = requestid;
	}

	// getters and setters
	
	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

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

	public ResetPwStatus getStatus() {
		return status;
	}

	public void setStatus(ResetPwStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}


