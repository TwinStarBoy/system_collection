package crm_mgr_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import crm_mgr_test.queue.MessagePublisher;
import crm_mgr_test.queue.MessagePublisherImpl;
import crm_mgr_test.queue.MessageSubscriber;

@Configuration
@ComponentScan("crm_mgr_test")
public class RedisConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}// return jedis connection factory

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return template;
	}// return redis template

	@Bean
	MessageListenerAdapter messageListener() {
		return new MessageListenerAdapter(new MessageSubscriber());
	}// return message listener adapter

	@Bean
	RedisMessageListenerContainer redisContainer() {
		final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(jedisConnectionFactory());
		container.addMessageListener(messageListener(), topic());
		return container;
	}// 

	@Bean
	MessagePublisher redisPublisher() {
		return new MessagePublisherImpl(redisTemplate(), topic());
	}

	@Bean
	ChannelTopic topic() {
		return new ChannelTopic("pubsub:queue");
		//org/apache/commons/pool2/impl/GenericObjectPoolConfig

	}

}

