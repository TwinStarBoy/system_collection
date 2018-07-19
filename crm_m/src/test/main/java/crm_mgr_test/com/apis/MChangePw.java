package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.ChangePwStatus;

//mChangePw	0x8011	{requestid, sessionid, managerid, oldpw, newpw, repw }	HTTP
public class MChangePw {
	
	public ChangePwStatus reviewdata() {
		return ComStatus.ChangePwStatus.SUCCESS;
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
	
	public String oldpw() {
		return this.oldpw;
	}
	
	public String newpw() {
		return this.newpw;
	}
	
	public String repw() {
		return this.repw;
	}
	
	// setters
	public MChangePw messageid(short messageid) {
		this.messageid = messageid;
		return this;
	}
	
	public MChangePw requestid(UUID requestid) {
		this.requestid = requestid;
		return this;
	}
	
	public MChangePw requestid(String requestid) {
		this.requestid = UUID.fromString(requestid);
		return this;
	}
	
	public MChangePw managerid(String managerid) {
		this.managerid = managerid;
		return this;
	}
	
	public MChangePw oldpw(String oldpw) {
		this.oldpw = oldpw;
		return this;
	}
	
	public MChangePw newpw(String newpw) {
		this.newpw = newpw;
		return this;
	}
	
	public MChangePw repw(String repw) {
		this.repw = repw;
		return this;
	}
	
	private short messageid;
	private UUID requestid;
	private String managerid;
	private String oldpw;
	private String newpw;
	private String repw;
	
}