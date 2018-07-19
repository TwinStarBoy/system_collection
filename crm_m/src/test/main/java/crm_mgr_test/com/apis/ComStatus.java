package crm_mgr_test.com.apis;

public class ComStatus {

	// 0x8002 MLoginAns
	public static enum LoginStatus {
		SUCCESS, PASSWD_USER_NO_MATCH, ILLEGUEL_CHAR, USER_NOT_FOUND, UNKNOWN
	}

	// 0x8008 MForgotPwAns
	public static enum ForgotPwStatus {
		SUCCESS, MESSAGEID_MISS_MATCH, EMAIL_SENT, UNKNOWN
	}

	// 0x800A mResetPwAns
	public static enum ResetPwStatus {
		SUCCESS, UNKNOWN
	}

	// 0x8012 mChangePwAns
	public static enum ChangePwStatus {
		SUCCESS, UNKNOWN
	}
}
