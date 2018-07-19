package crm_mgr_test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import crm_mgr_test.domain.Manager;

@Component
public interface ManagerDao {

	//public Manager getManager();
	
	//public String getPasswords(@Param(value="loginname") String loginname);
	
	//public String getEmail(@Param(value="email") String email);
	
//	public String getUserFromUserPW(@Param(value="loginname") String loginname, @Param(value="password") String password);
	
	public Manager getUserFromUserPW(@Param(value="loginname") String loginname, @Param(value="password") String password);
	
//	public String getEmailFromEmailPW(@Param(value="email") String email, @Param(value="password") String password);
	
	public Manager getEmailFromEmailPW(@Param(value="email") String email, @Param(value="password") String password);

//	public Integer getMidFromMidPW(@Param(value="managerid") int managerid, @Param(value="password") String password);
	
	public Manager getMidFromMidPW(@Param(value="managerid") int managerid, @Param(value="password") String password);

	public Manager getManagerFromMID(@Param(value="managerid") int managerid);// no implementation yet
	
	public Manager getManagerFromEmail(@Param(value="email") String email);
	
	public Integer updatePassword(@Param(value="managerid") int managerid, @Param(value="password") String password);

	public List<Manager> getAllUsers();
}
