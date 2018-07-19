package crm_mgr_test.com.apis.permission;

import java.util.UUID;

import crm_mgr_test.com.apis.permission.PermissionStatus.GetAllUserPermissionEnum;

public class MGetAllUserPermission {
	private String messageid;
	private UUID requestid;
	
	public GetAllUserPermissionEnum reviewData(){
		
		return PermissionStatus.GetAllUserPermissionEnum.SUCCESS;
		
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
	
	
}
