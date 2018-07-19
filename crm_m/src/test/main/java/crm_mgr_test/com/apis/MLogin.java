package crm_mgr_test.com.apis;

import java.util.UUID;

//this is a request message

public class MLogin {

	public MLogin(){
		this.messageid = (short) 0x8001;
	}
	
	public MLogin(UUID requestid) {
		this.messageid = (short) 0x8001;
		this.requestid = requestid;
		this.passwords = new String();//
		this.verficationcode = new String();//
	}

	// getters and setters
	// getters

	public final UUID requestid() {
		return this.requestid;
	}

	public final short messageid() {
		return this.messageid;
	}

	public String managerid() {
		return this.managerid;
	}

	public final String passwords() {
		return this.passwords;
	}

	public final String verificationcode() {
		return this.verficationcode;
	}

	// setters
	public MLogin requestid(final UUID requestid) {
		this.requestid = requestid;
		return this;
	}

	public MLogin managerid(final String managerid) {
		this.managerid = managerid;
		return this;
	}
	
	/*
	public MLogin managerid(final String managerid) {
		this.managerid = managerid.hashCode();
		return this;
	}
	*/

	public final MLogin passwords(String passwords) {
		this.passwords = passwords;
		return this;
	}

	public final MLogin verficationcode(String verficationcode) {
		this.verficationcode = verficationcode;
		return this;
	}
	
	//--------------------------------------//
	
	// ------------------------------------ //

	public UUID getRequestid() {
		return requestid;
	}

	public void setRequestid(UUID requestid) {
		this.requestid = requestid;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getVerficationcode() {
		return verficationcode;
	}

	public void setVerficationcode(String verficationcode) {
		this.verficationcode = verficationcode;
	}

	public void setMessageid(short messageid) {
		this.messageid = messageid;
	}
	
	public short getMessageid() {
		return messageid;
	}

	private short messageid;
	
	private UUID requestid;
	// private long sessionid;
	private String managerid;

	private String passwords;// 30 char

	private String verficationcode;// 20 char

}
