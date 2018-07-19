package crm_mgr_test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import crm_mgr_test.com.apis.permission.MAddPermission;
import crm_mgr_test.com.apis.permission.MAddPermissionAns;
import crm_mgr_test.com.apis.permission.MGetAllUserPermission;
import crm_mgr_test.com.apis.permission.MGetAllUserPermissionAns;
import crm_mgr_test.com.apis.permission.MGetAllUsers;
import crm_mgr_test.com.apis.permission.MGetAllUsersAns;
import crm_mgr_test.com.apis.permission.MGetApiNameMapWeight;
import crm_mgr_test.com.apis.permission.MGetApiNameMapWeightAns;
import crm_mgr_test.com.apis.permission.MScanCustomerPermission;
import crm_mgr_test.com.apis.permission.MScanCustomerPermissionAns;
import crm_mgr_test.com.apis.permission.MUpdatePermission;
import crm_mgr_test.com.apis.permission.MUpdatePermissionAns;
import crm_mgr_test.com.apis.permission.PermissionStatus;
import crm_mgr_test.domain.Manager;
import crm_mgr_test.domain.Permission;
import crm_mgr_test.service.PermissionService;

@RestController
public class PermissionController {

	@Autowired
    private PermissionService permissionService;
	
	@RequestMapping(value = "/mGetAllUsers", method = RequestMethod.POST)
	@ResponseBody
	public MGetAllUsersAns getAllUsers(MGetAllUsers mGetAllUsers){
		
		PermissionStatus.GetAllUserNameEnum getAllUserNameEnum = mGetAllUsers.reviewData();
		MGetAllUsersAns mGetAllUsersAns = new MGetAllUsersAns();
		mGetAllUsersAns.setRequestid(mGetAllUsersAns.getRequestid());
		
		if (PermissionStatus.GetAllUserNameEnum.SUCCESS != getAllUserNameEnum){
			mGetAllUsersAns.setStatus(getAllUserNameEnum);
			return mGetAllUsersAns;
		}
		
		List<Manager> managers = permissionService.getAllUsers();
		
		mGetAllUsersAns.setManagers(managers);
		mGetAllUsersAns.setStatus(PermissionStatus.GetAllUserNameEnum.SUCCESS);
		
		return mGetAllUsersAns;
	}
	
	@RequestMapping(value = "/mGetAllUserPermission", method = RequestMethod.POST)
	@ResponseBody
	public MGetAllUserPermissionAns getAllUserPermission(MGetAllUserPermission mGetAllUserPermission){
		
		PermissionStatus.GetAllUserPermissionEnum getAllUserPermissionEnum = mGetAllUserPermission.reviewData();
		
		MGetAllUserPermissionAns mGetAllUserPermissionAns = new MGetAllUserPermissionAns();
		mGetAllUserPermissionAns.setRequestid(mGetAllUserPermission.getRequestid());
		
		if (PermissionStatus.GetAllUserPermissionEnum.SUCCESS != getAllUserPermissionEnum){
			mGetAllUserPermissionAns.setStatus(getAllUserPermissionEnum);
			return mGetAllUserPermissionAns;
		}
		
		List<Permission> permissions = permissionService.getAllUserPermission();
		mGetAllUserPermissionAns.setPermissions(permissions);
		mGetAllUserPermissionAns.setStatus(PermissionStatus.GetAllUserPermissionEnum.SUCCESS);
		
		return mGetAllUserPermissionAns;
		
	}
	
	@RequestMapping(value = "/mGetApiNameMapWeight", method = RequestMethod.POST)
	@ResponseBody
	public MGetApiNameMapWeightAns getApiNameMapWeight(MGetApiNameMapWeight mGetApiNameMapWeight){
		MGetApiNameMapWeightAns mGetApiNameMapWeightAns = new MGetApiNameMapWeightAns();
		
		mGetApiNameMapWeightAns.setRequestid(mGetApiNameMapWeight.getRequestid());
		
		List<Map<String,Long>> list = permissionService.getApiNameMapWeight();
		
		mGetApiNameMapWeightAns.setList(list);

		mGetApiNameMapWeightAns.setStatus(PermissionStatus.GetApiNameMapWeightEnum.SUCCESS);
		
		return mGetApiNameMapWeightAns;
	}
	
	@RequestMapping(value = "/mScanCustomerPermission", method = RequestMethod.POST)
	@ResponseBody
	public MScanCustomerPermissionAns scanCustomerPermission(MScanCustomerPermission mScanCustomerPermission){
		
		PermissionStatus.ScanCustomerPermission scanCustomerPermission = mScanCustomerPermission.reveiwData();
		
		MScanCustomerPermissionAns mScanCustomerPermissionAns = new MScanCustomerPermissionAns();
		mScanCustomerPermissionAns.setRequestid(mScanCustomerPermission.getRequestid());
		mScanCustomerPermissionAns.setUserId(mScanCustomerPermission.getUserId());
		
		if (PermissionStatus.ScanCustomerPermission.SUCCESS != scanCustomerPermission){
			mScanCustomerPermissionAns.setStatus(scanCustomerPermission);
			return mScanCustomerPermissionAns;
		}
		
		Long permissionCode = permissionService.scanCustomerPermission(mScanCustomerPermission);
		
		mScanCustomerPermissionAns.setPermissionCode(permissionCode);
		
		return mScanCustomerPermissionAns;
	}
	
	@RequestMapping(value = "/mAddPermission", method = RequestMethod.POST)
	@ResponseBody
	public MAddPermissionAns addPermission(MAddPermission mAddPermission) {
		
		PermissionStatus.AddPermissionEnum addPermissionEnum = mAddPermission.reviewData();
		
		MAddPermissionAns mAddPermissionAns = new MAddPermissionAns();
		mAddPermissionAns.setRequestid(mAddPermission.getRequestid());
		mAddPermissionAns.setUserId(mAddPermission.getUserId());
		mAddPermissionAns.setScanAllCustomers(mAddPermission.getScanAllCustomers());
		mAddPermissionAns.setScanCustomerPosition(mAddPermission.getScanCustomerPosition());
		mAddPermissionAns.setCreateCustomer(mAddPermission.getCreateCustomer());
		mAddPermissionAns.setUpdateCustomer(mAddPermission.getUpdateCustomer());
		mAddPermissionAns.setLimitCustomerTrade(mAddPermission.getLimitCustomerTrade());
		mAddPermissionAns.setLimitCustomerDepositWithdraw(mAddPermission.getLimitCustomerDepositWithdraw());
		mAddPermissionAns.setUpdateCustomerOrders(mAddPermission.getUpdateCustomerOrders());
		mAddPermissionAns.setCreateOrder(mAddPermission.getCreateOrder());
		mAddPermissionAns.setDeleteOrder(mAddPermission.getDeleteOrder());
		mAddPermissionAns.setScanOpratorLog(mAddPermission.getScanOpratorLog());
		
		if (PermissionStatus.AddPermissionEnum.SUCCESS != addPermissionEnum){
			mAddPermissionAns.setStatus(addPermissionEnum);
			return mAddPermissionAns;
		}
		
		addPermissionEnum = permissionService.addPermission(mAddPermission);
		if (PermissionStatus.AddPermissionEnum.SUCCESS != addPermissionEnum){
			mAddPermissionAns.setStatus(addPermissionEnum);
			return mAddPermissionAns;
		}
		
		mAddPermissionAns.setStatus(PermissionStatus.AddPermissionEnum.SUCCESS);
		return mAddPermissionAns;
		
	}
	
	@RequestMapping(value = "/mUpdatePermission", method = RequestMethod.POST)
	@ResponseBody
	public MUpdatePermissionAns updatePermission(MUpdatePermission mUpdatePermission) {
		
		PermissionStatus.UpdatePermissionEnum updatePermissionEnum = mUpdatePermission.reviewData();
		
		MUpdatePermissionAns mUpdatePermissionAns = new MUpdatePermissionAns();
		mUpdatePermissionAns.setRequestid(mUpdatePermission.getRequestid());
		mUpdatePermissionAns.setUserId(mUpdatePermission.getUserId());
		mUpdatePermissionAns.setScanAllCustomers(mUpdatePermission.getScanAllCustomers());
		mUpdatePermissionAns.setScanCustomerPosition(mUpdatePermission.getScanCustomerPosition());
		mUpdatePermissionAns.setCreateCustomer(mUpdatePermission.getCreateCustomer());
		mUpdatePermissionAns.setUpdateCustomer(mUpdatePermission.getUpdateCustomer());
		mUpdatePermissionAns.setLimitCustomerTrade(mUpdatePermission.getLimitCustomerTrade());
		mUpdatePermissionAns.setLimitCustomerDepositWithdraw(mUpdatePermission.getLimitCustomerDepositWithdraw());
		mUpdatePermissionAns.setUpdateCustomerOrders(mUpdatePermission.getUpdateCustomerOrders());
		mUpdatePermissionAns.setCreateOrder(mUpdatePermission.getCreateOrder());
		mUpdatePermissionAns.setDeleteOrder(mUpdatePermission.getDeleteOrder());
		mUpdatePermissionAns.setScanOpratorLog(mUpdatePermission.getScanOpratorLog());
		
		if (PermissionStatus.UpdatePermissionEnum.SUCCESS != updatePermissionEnum){
			mUpdatePermissionAns.setStatus(updatePermissionEnum);
			return mUpdatePermissionAns;
		}
		
		updatePermissionEnum = permissionService.updatePermission(mUpdatePermission);
		if (PermissionStatus.UpdatePermissionEnum.SUCCESS != updatePermissionEnum){
			mUpdatePermissionAns.setStatus(updatePermissionEnum);
			return mUpdatePermissionAns;
		}
		
		mUpdatePermissionAns.setStatus(PermissionStatus.UpdatePermissionEnum.SUCCESS);
		return mUpdatePermissionAns;
		
	}
}
