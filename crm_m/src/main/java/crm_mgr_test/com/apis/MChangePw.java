package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.ChangePwStatus;
import crm_mgr_test.com.apis.ComStatus.LoginStatus;

//mChangePw	0x8011	{requestid, sessionid, managerid, oldpw, newpw, repw }	HTTP
public class MChangePw {
	
	private String messageid;
	private UUID requestid;
	private int managerid;
	private String oldpw;
	private String newpw;
	private String repw;
	
	public MChangePw() {
		this.messageid = "8011";
	}
	
	public MChangePw(UUID requestid) {
		this.messageid = "8011";
		this.requestid = requestid;
	}
	
	public ChangePwStatus reviewdata() {
		// general checking
		if (!this.messageid.equals("8011"))
			return ChangePwStatus.WRONG_MSGID;
		if (this.requestid == null)
			return ChangePwStatus.REQID_ERROR;
		if (this.requestid.toString().length() != 36)
			return ChangePwStatus.REQID_ERROR;
		if (this.managerid == 0)
			return ChangePwStatus.ILLEGAL_USER;

		// length checking
		if ((this.oldpw != null) && (this.oldpw.length() > ComStatus.INPUT_NORMSG_LENGTH))
			return ChangePwStatus.PASSWD_LENGTH_ERR;
		if ((this.newpw != null) && (this.newpw.length() > ComStatus.INPUT_NORMSG_LENGTH))
			return ChangePwStatus.PASSWD_LENGTH_ERR;		
		if ((this.repw != null) && (this.repw.length() > ComStatus.INPUT_NORMSG_LENGTH))
				return ChangePwStatus.PASSWD_LENGTH_ERR;
		
		// format checking
		if (!ComStatus.useridFormatCheck(this.managerid))
			return ChangePwStatus.USERID_FORMAT_ERR;
		if (!ComStatus.passwdFormatCheck(this.oldpw))
			return ChangePwStatus.PASSWD_FORMAT_ERR;
		if (!ComStatus.passwdFormatCheck(this.newpw))
			return ChangePwStatus.PASSWD_FORMAT_ERR;
		if (!ComStatus.passwdFormatCheck(this.repw))
			return ChangePwStatus.PASSWD_FORMAT_ERR;
		
		// logic checking
		if(!this.repw.equals(this.newpw))
			return ChangePwStatus.NEWPW_NOT_MATCH;
		
		return ChangePwStatus.SUCCESS;
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

	public String getOldpw() {
		return oldpw;
	}

	public void setOldpw(String oldpw) {
		this.oldpw = oldpw;
	}

	public String getNewpw() {
		return newpw;
	}

	public void setNewpw(String newpw) {
		this.newpw = newpw;
	}

	public String getRepw() {
		return repw;
	}

	public void setRepw(String repw) {
		this.repw = repw;
	}
	
}