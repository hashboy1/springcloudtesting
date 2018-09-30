package com.SpringCloudEurekaClient.cache;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
 
@Component
public class RedisCacheTransfer {
	
	JedisConnectionFactory mrc;
	
	@Autowired
	public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		System.out.println("jedisConnectionFactory initialization");
		MybatisRedisCache.setJedisConnectionFactory(jedisConnectionFactory);
		//it clear the cache db when service startups 
		MybatisRedisCache.clearCache();
	}
	
}
