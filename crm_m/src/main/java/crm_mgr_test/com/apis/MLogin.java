package crm_mgr_test.com.apis;

import java.util.UUID;

import crm_mgr_test.com.apis.ComStatus.LoginStatus;

public class MLogin {

	private String messageid;
	private UUID requestid;
	private int managerid;
	private String loginname; // 25 char
	private String email; // 45 char
	private String password; // 25 char
	private String verificationcode; // 25 char

	public MLogin() {
		this.messageid = "8001";
	}

	public MLogin(UUID requestid) {
		this.messageid = "8001";
		this.requestid = requestid;//
		this.password = new String();//
		this.verificationcode = new String();//
	}

	// review input data
	public LoginStatus reviewData() {
		// general checking
		if (!this.messageid.equals("8001"))
			return LoginStatus.WRONG_MSGID;
		if (this.requestid == null)
			return LoginStatus.REQID_ERROR;
		if (this.requestid.toString().length() != 36)
			return LoginStatus.REQID_ERROR;
		if ((this.managerid == 0) && (this.loginname == null || this.loginname.equals(""))
				&& (this.email == null || this.email.equals("")))
			return LoginStatus.ILLEGAL_USER;

		// length checking
		if ((this.loginname != null) && (this.loginname.length() > ComStatus.INPUT_NORMSG_LENGTH))
			return LoginStatus.ILLEGAL_USER;
		if ((this.email != null) && (this.email.length() > ComStatus.INPUT_EMAIL_LENGTH))
			return LoginStatus.ILLEGAL_USER;
		if ((this.password != null) && (this.password.length() > ComStatus.INPUT_NORMSG_LENGTH))
			return LoginStatus.PASSWD_LENGTH_ERR;
		if ((this.verificationcode != null) && (this.verificationcode.length() > ComStatus.INPUT_NORMSG_LENGTH))
			return LoginStatus.VARCODE_LENGTH_ERR;

		// format checking
		if (!ComStatus.useridFormatCheck(this.managerid))
			return LoginStatus.USERID_FORMAT_ERR;
		if (!ComStatus.userFormatCheck(this.loginname))
			return LoginStatus.USER_FORMAT_ERR;
		if (!ComStatus.emailFormatCheck(this.email))
			return LoginStatus.EMAIL_FORMAT_ERR;
		if (!ComStatus.passwdFormatCheck(this.password))
			return LoginStatus.PASSWD_FORMAT_ERR;
		if (!ComStatus.userFormatCheck(this.verificationcode))
			return LoginStatus.VARCODE_FORMAT_ERR;

		return LoginStatus.SUCCESS;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificationcode() {
		return verificationcode;
	}

	public void setVerificationcode(String verificationcode) {
		this.verificationcode = verificationcode;
	}

}
