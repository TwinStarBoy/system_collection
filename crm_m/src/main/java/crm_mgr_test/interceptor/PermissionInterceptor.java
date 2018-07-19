package crm_mgr_test.interceptor;

import java.io.InputStream;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import crm_mgr_test.dao.PermissionDao;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
	
	@Autowired
    private PermissionDao permissionDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
/*		String clientidParam = request.getParameter("clientid");
		if (clientidParam == null || "".equals(clientidParam)){
			
			InputStream in = request.getInputStream();
			String body = StreamUtils
					.copyToString(in, Charset.forName("UTF-8"));
			System.out.println("body:" + body);
			JSONObject json = JSONObject.parseObject(body);
			
			int clientidJson =  (int) json.get("clientId");
			int permissionCodeJson = (int) json.get("permissionCode");
			
			int permissionCode = permissionDao.getPermissionById(clientidJson);
			
			if (permissionCode == 0 || permissionCode != permissionCodeJson){
				
				return false;
			}
			
		} else {
			
			String permissionCodeParam = request.getParameter("permissionCode");
			
			if (permissionCodeParam == null || "".equals(permissionCodeParam)){
				return false;
			}
			
			int tmpId = Integer.parseInt(clientidParam);
			
			int permissionCode = permissionDao.getPermissionById(tmpId);
			
			int tmpPermissionCode = Integer.parseInt(permissionCodeParam);
			
			if (permissionCode == 0 || permissionCode != tmpPermissionCode){
				return false;
			}
			
			
		}
*/		
		
		System.out.println("CommonHandlerInterceptor。preHandle，，，，，，，，，，，，，，，");
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CommonHandlerInterceptor。postHandle，，，，，，，，，，，，，，，");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CommonHandlerInterceptor。afterCompletion，，，，，，，，，，，，，，，");
	}

}
