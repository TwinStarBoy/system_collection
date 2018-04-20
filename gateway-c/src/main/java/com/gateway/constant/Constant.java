package com.gateway.constant;

import java.util.ArrayList;
import java.util.List;

public class Constant {
	public final static String LOGIN_SERVLET_PATH = "/crm/crm-test/onlineManage/login";
	
	public static List<String> ALLOW_URL = new ArrayList<String>();
	
	static {
		ALLOW_URL.add("/crm/crm-test/onlineManage/login");
		ALLOW_URL.add("/crm/crm-test/onlineManage/forgetPassword");
		ALLOW_URL.add("/crm/crm-test/onlineManage/register");
		ALLOW_URL.add("/crm/crm-test/onlineManage/resetPassword");
		ALLOW_URL.add("/crm/crm-test/onlineManage/emailAutoLogin"); 
		ALLOW_URL.add("/crm/crm-test/onlineManage/checkEmailUnique");
		ALLOW_URL.add("/crm/crm-test/onlineManage/checkUsernameUnique");
		ALLOW_URL.add("/crm/crm-test/onlineManage/verifyCode");
	}
}
