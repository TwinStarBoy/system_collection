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
import com.gateway.util.ResponseUtil;
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
//        Cookie[] cookies = request.getCookies(); 
//        for(Cookie cookie : cookies){
//        	if(cookie.getName().equalsIgnoreCase("jsessionid"))    
//            {    
//        		sessionId = cookie.getValue();    
//             }   
//        }
        log.info("sessionId:"+sessionId);
        
        /*Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");*/
        

        HttpServletResponse response = ctx.getResponse();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        //获取请求资源路径  
        String sevletPath = request.getServletPath();
        log.info("sevletPaht:" + sevletPath);
        
        if(Constant.ALLOW_URL.contains(sevletPath)){
        	return null;
        }
        
        String body = stringRedisTemplate.opsForValue().get(sessionId);
        
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
        
        
//        final byte[] reqBodyBytes = body.getBytes();
//        
//        ctx.setRequest(new HttpServletRequestWrapper(ctx.getRequest()) {
//            @Override
//            public ServletInputStream getInputStream() throws IOException {
//                return new ServletInputStreamWrapper(reqBodyBytes);
//            }
//
//            @Override
//            public int getContentLength() {
//                return reqBodyBytes.length;
//            }
//
//            @Override
//            public long getContentLengthLong() {
//                return reqBodyBytes.length;
//            }
//        });
        
        return null;
    }

}
