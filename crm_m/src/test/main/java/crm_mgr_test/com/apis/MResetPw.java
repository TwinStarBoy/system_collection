package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.ResetPwStatus;

//mResetPw	0x8009	{requestid, sessionid,managerid,passwords,repasswords}	HTTP
public class MResetPw {

	public MResetPw() {
		this.messageid = (short) 0x8009;
	}

	public ResetPwStatus reviewdata() {
		return ComStatus.ResetPwStatus.SUCCESS;
	}
	
	// getters and setters
	// getters
	public short messageid() {
		return this.messageid;
	}

	public UUID requestid() {
		return this.requesetid;
	}

	public String managerid() {
		return this.managerid;
	}

	public String passwords() {
		return this.passwords;
	}

	public String repasswords() {
		return this.repasswords;
	}
	// setters

	public MResetPw messageid(Integer messageid) {
		this.messageid = messageid.shortValue();
		return this;
	}
	
	public MResetPw requestid(String requestid) {
		this.requesetid = UUID.fromString(requestid);
		return this;
	}
		
	public MResetPw managerid(String managerid) {
		this.managerid = managerid;
		return this;
	} 
	
	public MResetPw passwords(String passwords) {
		this.passwords = passwords;
		return this;
	}
	
	public MResetPw repasswords(String repasswords) {
		this.repasswords = repasswords;
		return this;
	} 
	
	private short messageid;
	private UUID requesetid;
	private String managerid;
	private String passwords;
	private String repasswords;

}
