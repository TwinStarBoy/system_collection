package crm_mgr_test.com.apis.permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum PermissionWeightMapEnum {

	SCAN_ALL_CUSTOMERS("mScanAllCustomers",1L),
	SCAN_CUSTOMER_POSITION("mScanCustomerPosition",2L),
	CREATE_CUSTOMER("mCreateCustomer",4L),
	UPDATE_CUSTOMER("mUpdateCustomer",8L),
	LIMIT_CUSTOMER_TRADE("mLimitCustomerTrade",16L),
	LIMIT_CUSTOMER_DEPOSIT_WITHDRAW("mLimitCustomerDepositWithdraw",32L),
	UPDATE_CUSTOMER_ORDERS("mUpdateCustomerOrders",64L),
	CREATE_ORDER("mCreateOrder",128L),
	DELETE_ORDER("mDeleteOrder",256L),
	SCAN_OPRATOR_LOG("mScanOpratorLog",512L),
	//除了admin之外，所有人都是0。数据库表字段某认是0。使用mybatis操作数据库记录时，不能用这个字段。但是计算权限的时候必须使用这个字段
	MANAGE_USER("manageUser",1024L);
	
	PermissionWeightMapEnum (String apiName ,Long weight){
		this.apiName = apiName;
		this.weight = weight;
	}
	
	private String apiName;
	private Long weight;
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public Long getWeight() {
		return weight;
	}
	public void setWeight(Long weight) {
		this.weight = weight;
	}
	
	public static List<Map<String,Long>> getMapList(){
		Map<String,Long> map = new HashMap<String,Long>();
		
		List<Map<String,Long>> list = new ArrayList<Map<String,Long>>();
		
		for (PermissionWeightMapEnum e : PermissionWeightMapEnum.values()){
			map.put(e.getApiName(), e.getWeight());
		}
		
		list.add(map);
		
		return list;
	}
	

}
