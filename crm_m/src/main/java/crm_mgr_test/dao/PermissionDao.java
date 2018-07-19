package crm_mgr_test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import crm_mgr_test.domain.Permission;

@Component
public interface PermissionDao {
	
	public List<Permission> getAllPermission();

	public Long getPermissionByUserId(@Param(value="user_id") int userId);
	
	public int addPermission(Permission permission);
	
	public int updatePermission(Permission permission);
}
