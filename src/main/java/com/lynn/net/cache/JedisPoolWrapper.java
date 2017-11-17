package com.lynn.net.cache;

import javax.annotation.PostConstruct;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.lynn.net.commons.constants.Parameters;

@Component
@Slf4j
@Data
public class JedisPoolWrapper {
	private JedisPool jedisPool = null;
	
	@Autowired
	private Parameters parameters;
	
	@PostConstruct
	public void init() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxWaitMillis(config.getMaxWaitMillis());
			config.setMaxIdle(parameters.getRedisMaxIdle());
			config.setMaxTotal(parameters.getRedisMaxTotal());
			jedisPool = new JedisPool(config,parameters.getRedisHost(),parameters.getRedisPort(),2000);
			
		} catch (Exception e) {
			log.error("Fail to init redis pool",e);
		}
	}
	
	
}
