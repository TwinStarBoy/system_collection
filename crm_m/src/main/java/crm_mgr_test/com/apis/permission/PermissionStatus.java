package crm_mgr_test.com.apis.permission;

import java.util.HashMap;
import java.util.Map;

public class PermissionStatus {
	
	private static Map<String,Long> weightMap = new HashMap<String,Long>();
	
	static {
		weightMap.put("scanAllCustomers",1L);
		weightMap.put("scanCustomerPosition",2L);
		weightMap.put("createCustomer",4L);
		weightMap.put("updateCustomer",8L);
		weightMap.put("limitCustomerTrade",16L);
		weightMap.put("limitCustomerDepositWithdraw",32L);
		weightMap.put("updateCustomerOrders",64L);
		weightMap.put("createOrder",128L);
		weightMap.put("deleteOrder",256L);
		weightMap.put("scanOpratorLog",512L);
		weightMap.put("manageUser",1024L);
	}
	
	public static Long getApiWeight(String key){
		return weightMap.get(key);
	}
	
	public static enum GetAllUserNameEnum {
		SERVER_BUSY,
		SUCCESS
	}
	
	public static enum GetAllUserPermissionEnum {
		SERVER_BUSY,
		SUCCESS
	}
	
	public static enum GetApiNameMapWeightEnum {
		SUCCESS
	}
	
	public static enum ScanCustomerPermission {
		SERVER_BUSY,
		SUCCESS
	}
	
	public static enum AddPermissionEnum {
		SERVER_BUSY,
		CREATE_FAILED,
		SUCCESS
	}
	
	public static enum UpdatePermissionEnum {
		SERVER_BUSY,
		UPDATE_FAILED,
		SUCCESS
	}
	
	
	
}
