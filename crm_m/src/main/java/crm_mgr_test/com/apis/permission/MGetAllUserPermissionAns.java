package crm_mgr_test.com.apis.permission;

import java.util.List;
import java.util.UUID;

import crm_mgr_test.com.apis.permission.PermissionStatus.GetAllUserPermissionEnum;
import crm_mgr_test.domain.Permission;

public class MGetAllUserPermissionAns {
	private String messageid;
	private UUID requestid;
	
	private List<Permission> permissions;
	
	private GetAllUserPermissionEnum status;

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

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public GetAllUserPermissionEnum getStatus() {
		return status;
	}

	public void setStatus(GetAllUserPermissionEnum status) {
		this.status = status;
	}
	
	
	
}
