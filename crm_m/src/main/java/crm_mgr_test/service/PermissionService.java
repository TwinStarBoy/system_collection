package crm_mgr_test.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm_mgr_test.com.apis.permission.MAddPermission;
import crm_mgr_test.com.apis.permission.MScanCustomerPermission;
import crm_mgr_test.com.apis.permission.MUpdatePermission;
import crm_mgr_test.com.apis.permission.PermissionDefineEnum;
import crm_mgr_test.com.apis.permission.PermissionStatus;
import crm_mgr_test.com.apis.permission.PermissionStatus.AddPermissionEnum;
import crm_mgr_test.com.apis.permission.PermissionStatus.UpdatePermissionEnum;
import crm_mgr_test.com.apis.permission.PermissionWeightMapEnum;
import crm_mgr_test.dao.ManagerDao;
import crm_mgr_test.dao.PermissionDao;
import crm_mgr_test.domain.Manager;
import crm_mgr_test.domain.Permission;

@Service
public class PermissionService {

	@Autowired
	PermissionDao permissionDao;
	
	@Autowired
	ManagerDao managerDao;
	
	public List<Manager> getAllUsers() {
		List<Manager> managers = managerDao.getAllUsers();
		return managers;
	}
	
	public List<Permission> getAllUserPermission(){
		List<Permission> permissions = permissionDao.getAllPermission();
		return permissions;
	}
	
	public List<Map<String,Long>> getApiNameMapWeight(){
		List<Map<String,Long>> list = new ArrayList<Map<String,Long>>();
		
		list = PermissionWeightMapEnum.getMapList();
		
		return list;
	}
	
	public Long scanCustomerPermission(MScanCustomerPermission mScanCustomerPermission){
		
		int userId = mScanCustomerPermission.getUserId();
		
		Long permissionCode = permissionDao.getPermissionByUserId(userId);
		
		return permissionCode;
	}
	
	public AddPermissionEnum addPermission(MAddPermission mAddPermission){
		//TODO userid 校验
		Long score = 0L;
		try {
			score = calculatePermission(mAddPermission);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return AddPermissionEnum.SERVER_BUSY;
		}
		
		
		Permission permission = new Permission();
		permission.setUserId(mAddPermission.getUserId());
		permission.setScanAllCustomers(mAddPermission.getScanAllCustomers());
		permission.setScanCustomerPosition(mAddPermission.getScanCustomerPosition());
		permission.setCreateCustomer(mAddPermission.getCreateCustomer());
		permission.setUpdateCustomer(mAddPermission.getUpdateCustomer());
		permission.setLimitCustomerTrade(mAddPermission.getLimitCustomerTrade());
		permission.setLimitCustomerDepositWithdraw(mAddPermission.getLimitCustomerDepositWithdraw());
		permission.setUpdateCustomerOrders(mAddPermission.getUpdateCustomerOrders());
		permission.setCreateOrder(mAddPermission.getCreateOrder());
		permission.setDeleteOrder(mAddPermission.getDeleteOrder());
		permission.setScanOpratorLog(mAddPermission.getScanOpratorLog());
		
		permission.setPermissionCode(score);
		
		int row = permissionDao.addPermission(permission);
		
		if (row == 0){
			return AddPermissionEnum.CREATE_FAILED;
		}
		
		return AddPermissionEnum.SUCCESS;
	}
	
	public Long calculatePermission(MAddPermission mAddPermission) throws Exception{
		
		Long score = 0L;
		Class cls = mAddPermission.getClass();
		Field[] fields = cls.getDeclaredFields();  
		for(int i=0; i<fields.length; i++){  
            Field f = fields[i];  
            f.setAccessible(true);  
            
            String property = f.getName();
            Object value = f.get(mAddPermission);
            
            System.out.println("属性名:" + property + " 属性值:" + value);
            
            Long weight = PermissionStatus.getApiWeight(property);
            
            if(weight == null){//排出计算 requestid ， messageid
            	continue;
            }
            
            int flag = (int) value;
            
            Long scoreTmp = weight * flag;
            
            System.out.println("scoreTmp:"+scoreTmp);
            
            score += scoreTmp;
        }   
		System.out.println("score:"+score);
		return score;
	}
	
	public UpdatePermissionEnum updatePermission(MUpdatePermission mUpdatePermission){
		
		Long score = 0L;
		
		Permission permission = new Permission();
		permission.setUserId(mUpdatePermission.getUserId());
		
		int scanAllCustomers = mUpdatePermission.getScanAllCustomers();
		Long scoreScanAllCustomers = scanAllCustomers * PermissionDefineEnum.SCAN_ALL_CUSTOMERS.getWeight();
		score += scoreScanAllCustomers;
		permission.setScanAllCustomers(scanAllCustomers);
		
		int scanCustomerPosition = mUpdatePermission.getScanCustomerPosition();
		Long scoreScanCustomerPosition = scanCustomerPosition * PermissionDefineEnum.SCAN_CUSTOMER_POSITION.getWeight();
		score += scoreScanCustomerPosition;
		permission.setScanCustomerPosition(scanCustomerPosition);
		
		int createCustomer = mUpdatePermission.getCreateCustomer();
		Long scoreCreateCustomer = createCustomer * PermissionDefineEnum.CREATE_CUSTOMER.getWeight();
		score += scoreCreateCustomer;
		permission.setCreateCustomer(createCustomer);
		
		int updateCustomer = mUpdatePermission.getUpdateCustomer();
		Long scoreUpdateCustomer = updateCustomer * PermissionDefineEnum.UPDATE_CUSTOMER.getWeight();
		score += scoreUpdateCustomer;
		permission.setUpdateCustomer(updateCustomer);
		
		int limitCustomerTrade = mUpdatePermission.getLimitCustomerTrade();
		Long scoreLimitCustomerTrade = limitCustomerTrade * PermissionDefineEnum.LIMIT_CUSTOMER_TRADE.getWeight();
		score += scoreLimitCustomerTrade;
		permission.setLimitCustomerTrade(limitCustomerTrade);
		
		int limitCustomerDepositWithdraw = mUpdatePermission.getLimitCustomerDepositWithdraw();
		Long scoreLimitCustomerDepositWithdraw = limitCustomerDepositWithdraw * PermissionDefineEnum.LIMIT_CUSTOMER_DEPOSIT_WITHDRAW.getWeight();
		score += scoreLimitCustomerDepositWithdraw;
		permission.setLimitCustomerDepositWithdraw(limitCustomerDepositWithdraw);
		
		int updateCustomerOrders = mUpdatePermission.getUpdateCustomerOrders();
		Long scoreUpdateCustomerOrders = updateCustomerOrders * PermissionDefineEnum.UPDATE_CUSTOMER_ORDERS.getWeight();
		score += scoreUpdateCustomerOrders;
		permission.setUpdateCustomerOrders(updateCustomerOrders);
		
		int createOrder = mUpdatePermission.getCreateOrder();
		Long scoreCreateOrder = createOrder * PermissionDefineEnum.CREATE_ORDER.getWeight();
		score += scoreCreateOrder;
		permission.setCreateOrder(createOrder);
		
		int deleteOrder = mUpdatePermission.getDeleteOrder();
		Long scoreDeleteOrder = deleteOrder * PermissionDefineEnum.DELETE_ORDER.getWeight();
		score += scoreDeleteOrder;
		permission.setDeleteOrder(deleteOrder);
		
		int scanOpratorLog = mUpdatePermission.getScanOpratorLog();
		Long scoreScanOpratorLog = scanOpratorLog * PermissionDefineEnum.SCAN_OPRATOR_LOG.getWeight();
		score += scoreScanOpratorLog;
		permission.setScanOpratorLog(scanOpratorLog);
		
		permission.setPermissionCode(score);
		
		int row = permissionDao.updatePermission(permission);
		
		if (row == 0){
			return UpdatePermissionEnum.UPDATE_FAILED;
		}
		
		return UpdatePermissionEnum.SUCCESS;
	}

}
