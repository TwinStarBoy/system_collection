package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.LoginStatus;

public class MLoginAns {

	private UUID requestid;
	private String messageid;
	private int managerid;
	private String loginname;
	private String email;
	private LoginStatus status;
	private String comment;
	
	private Long permissionCode;
	
	public MLoginAns() {
		this.messageid = "8002";
	}
	
	public MLoginAns(UUID requestid) {
		this.messageid = "8002";
		this.requestid = requestid;
	}

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

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoginStatus getStatus() {
		return status;
	}

	public void setStatus(LoginStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(Long permissionCode) {
		this.permissionCode = permissionCode;
	}

	
	/*
	// getters and setters
	// getters
	public final UUID requestid() {
		return this.requestid;
	}

	// sessionid
	public final short messageid() {
		return this.messageid;
	}

	public final long managerid() {
		return this.managerid;
	}

	public final LoginStatus loginst() {
		return this.loginst;
	}

	public final String comment() {
		return this.comment;
	}

	// setters

	public MLoginAns requestid(final UUID requestid) {
		this.requestid = requestid;
		return this;
	}

	public MLoginAns managerid(final long managerid) {
		this.managerid = managerid;
		return this;
	}

	public MLoginAns loginst(final LoginStatus loginst) {
		this.loginst = loginst;
		return this;
	}

	public MLoginAns comment(final String comment) {
		this.comment = comment;
		return this;
	}

	// it is joson or something else
	public String toStr() {
		return "success";
	}

*/

}
