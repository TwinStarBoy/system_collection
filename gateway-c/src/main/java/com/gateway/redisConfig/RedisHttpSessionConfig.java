package com.gateway.redisConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@Configuration
//maxInactiveIntervalInSeconds session超时时间,单位�?
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300)
public class RedisHttpSessionConfig {

}
