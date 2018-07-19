package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.ChangePwStatus;

//mChangePwAns	0x8012	{requestid, sessionid, managerid, status, comment}	HTTP
public class MChangePwAns {

	private String messageid;
	private UUID requestid;
	private int managerid;
	private ChangePwStatus status;
	private String comment;

	public MChangePwAns() {
		this.messageid = "8012";
	}

	public MChangePwAns(UUID requestid) {
		this.messageid = "8012";
		this.requestid = requestid;
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

	public ChangePwStatus getStatus() {
		return status;
	}

	public void setStatus(ChangePwStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
