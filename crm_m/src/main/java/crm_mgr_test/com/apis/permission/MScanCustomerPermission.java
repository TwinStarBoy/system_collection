package crm_mgr_test.com.apis.permission;

import java.util.UUID;

import crm_mgr_test.com.apis.permission.PermissionStatus.ScanCustomerPermission;

public class MScanCustomerPermission {
	private String messageid;
	private UUID requestid;
	private int userId;
	
	public ScanCustomerPermission reveiwData(){
		return ScanCustomerPermission.SUCCESS;
	}
	
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
