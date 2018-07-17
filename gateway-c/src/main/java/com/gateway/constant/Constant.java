package com.gateway.constant;

import java.util.ArrayList;
import java.util.List;

public class Constant {
	public final static String LOGIN_SERVLET_PATH = "/crm/cLogin";
	
	public static List<String> ALLOW_URL = new ArrayList<String>();
	
	public static String getUserInfo = "/crm/getUserInfo";
	
	public static List<String> ADD_CLIENTID_URL = new ArrayList<String>();
	
	public final static String LOGOUT_URL = "/crm/cLogout";
	
	static {
		ALLOW_URL.add("/crm/cLogin");
		ALLOW_URL.add("/crm/cForgetPassword");
		ALLOW_URL.add("/crm/cRegister");
		ALLOW_URL.add("/crm/cResetPassword");
		ALLOW_URL.add("/crm/cEmailAutoLogin"); 
		ALLOW_URL.add("/crm/cCheckEmailUnique");
		ALLOW_URL.add("/crm/cCheckUsernameUnique");
		ALLOW_URL.add("/crm/cVerifyCode");
		
		ADD_CLIENTID_URL.add("publisher");
		ADD_CLIENTID_URL.add("subscriber");
		ADD_CLIENTID_URL.add("crm");
	}
}
