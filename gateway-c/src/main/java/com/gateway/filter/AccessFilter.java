package com.gateway.filter;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.JSONObject;
import com.gateway.bean.User;
import com.gateway.constant.Constant;
import com.gateway.util.RequestUtil;
import com.gateway.util.ResponseUtil;
import com.gateway.util.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter  {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;
	
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        
        String sessionId = request.getSession().getId();

        log.info("sessionId:"+sessionId);

        HttpServletResponse response = ctx.getResponse();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        //获取请求资源路径  
        String sevletPath = request.getServletPath();
        log.info("sevletPath:" + sevletPath);
        
        if(Constant.ALLOW_URL.contains(sevletPath)){
        	return null;
        }
        
        String body = stringRedisTemplate.opsForValue().get(sessionId);
        
        if(Constant.getUserInfo.equals(sevletPath)){//查看个人信息
        	ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.setResponseBody(body);
            ctx.getResponse().setContentType("application/json;charset=UTF-8");
            return null;
        }
        
        String routeUrl = StringUtil.getRouteStr(sevletPath);
        
        if(Constant.ADD_CLIENTID_URL.contains(routeUrl)){
        	RequestUtil.addClientId(ctx,body);
        }
        
//         obj =  redisTemplate.opsForValue().get(sessionId);
        
        if(null == body ){
        	ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            String json = JSONObject.toJSON(ResponseUtil.setResult("9999", "please login")).toString();
            ctx.setResponseBody(json);
            ctx.getResponse().setContentType("application/json;charset=UTF-8");
            return null;
        }
        
        
        
        stringRedisTemplate.opsForValue().set(sessionId, body ,180, TimeUnit.SECONDS);
        
        String username = request.getParameter("username");
        
        if(username == null || "".equals(username)){
        	ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("illegal param");
            ctx.getResponse().setContentType("application/json;charset=UTF-8");
            return null;
        }
        
        User user = JSONObject.parseObject(body, User.class);
        
        if(!username.equals(user.getUsername())){
        	ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("illegal param");
            ctx.getResponse().setContentType("application/json;charset=UTF-8");
            return null;
        }
        
        return null;
    }

}
