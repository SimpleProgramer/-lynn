package com.lynn.net.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import com.lynn.net.commons.util.PageParam;
import com.lynn.net.user.entity.Admin;
import com.lynn.net.user.entity.AdminElement;
import com.lynn.net.user.entity.VipUser;

@Component
@Slf4j
public class CommonCacheUtil {

	@Autowired
	private JedisPoolWrapper jedisPoolWrapper;
	
	
	private final static String TOKEN_PREFIX = "token.";
	
	private final static String USER_PREFIX = "user.";
	/**
	 * 缓存 可以value 永久
	 * @param key
	 * @param value
	 */
	public void cache(String key, String value) {
		try {
			JedisPool pool = jedisPoolWrapper.getJedisPool();
			if (pool != null) {
				try (Jedis Jedis = pool.getResource()) {
					Jedis.select(0);
					Jedis.set(key, value);
				}
			}
		} catch (Exception e) {
			log.error("Fail to cache value", e);
		}
	}
	
	/**
	 * 缓存 可以value 永久
	 * @param key
	 * @param value
	 */
	public void cacheBytes(String key, byte[] value) {
		try {
			JedisPool pool = jedisPoolWrapper.getJedisPool();
			if (pool != null) {
				try (Jedis Jedis = pool.getResource()) {
					Jedis.select(0);
					Jedis.set(key.getBytes(), value);
				}
			}
		} catch (Exception e) {
			log.error("Fail to cache value", e);
		}
	}
	
	/**
	 * 获取缓存key
	 * @param key
	 * @return
	 */
	public String getCacheValue(String key) {
		String value = null;
		try {
			JedisPool pool = jedisPoolWrapper.getJedisPool();
			if (pool != null) {
				try (Jedis Jedis = pool.getResource()) {
					Jedis.select(0);
					value = Jedis.get(key);
				}
			}
		} catch (Exception e) {
			log.error("Fail to get cached value", e);
		}
		return value;
	}
	/**
	 * 设置key value 以及过期时间
	 * @param key
	 * @param value
	 * @param expiry
	 * @return
	 */
	public long cacheNxExpire(String key, String value, int expiry) {
		long result = 0;
		try {
			JedisPool pool = jedisPoolWrapper.getJedisPool();
			if (pool != null) {
				try (Jedis jedis = pool.getResource()) {
					jedis.select(0);
					result = jedis.setnx(key, value);
					jedis.expire(key, expiry);
				}
			}
		} catch (Exception e) {
			log.error("Fail to cacheNx value", e);
		}
		
		return result;
	}

	/**
	 * 删除缓存key
	 * @param key
	 */
	public void delKey(String key) {
		JedisPool pool = jedisPoolWrapper.getJedisPool();
		if (pool != null) {

			try (Jedis jedis = pool.getResource()) {
				jedis.select(0);
				try {
					jedis.del(key);
				} catch (Exception e) {
					log.error("Fail to remove key from redis", e);
				}
			}
		}
	}

	public void putTokenWhenLogin(AdminElement ue) {
		/*// TODO Auto-generated method stub
		JedisPool pool = jedisPoolWrapper.getJedisPool();
		if (pool != null) {

			try (Jedis jedis = pool.getResource()) {
				jedis.select(0);
				//start redis transactional
				Transaction trans = jedis.multi();
				try{
					trans.del(TOKEN_PREFIX + ue.getToken());
					trans.hmset(TOKEN_PREFIX + ue.getToken(), ue.toMap());
					trans.expire(TOKEN_PREFIX + ue.getToken(), 2592000);
					trans.sadd(USER_PREFIX + ue.getUserId(), ue.getToken());
					// submit redis transactional 
					trans.exec();
				}catch(Exception e) {
					//callback redis transactional 
					trans.discard();
					log.error("Fail to cache token to redis",e);
				}
			}
		}*/
	}
	
	/**
	 * put admin info to redis
	 * */
	public void putAdminLoginParam(AdminElement ae,boolean isRem) {
		JedisPool pool = jedisPoolWrapper.getJedisPool();
		if (pool != null) {

			try (Jedis jedis = pool.getResource()) {
				jedis.select(0);
				//start redis transactional
				Transaction trans = jedis.multi();
				try{
					trans.del(USER_PREFIX + ae.getName());
					trans.hmset(USER_PREFIX + ae.getName(), ae.toMap());
				}catch(Exception e) {
					//callback redis transactional 
					trans.discard();
					log.error("Fail to cache token to redis",e);
				}
			}
		}
	}
	
	/**
	 * get admin info by redis
	 * */
	public String getAdminLoginParam(String key) {
		String pwd = "";
		try {
			JedisPool pool = jedisPoolWrapper.getJedisPool();
			if (pool != null) {
				try (Jedis Jedis = pool.getResource()) {
					Jedis.select(0);
					List<String> list = Jedis.hmget(USER_PREFIX+key, "password");
					if(list.size() == 1) {
						pwd = list.get(0);
					}
				}
			}
			return pwd;
		} catch (Exception e) {
			log.error("Fail to get cached value", e);
			return null;
		}
	}

	public byte[] getCacheBytesValue(String key) {
		byte[] value = null;
		try {
			JedisPool pool = jedisPoolWrapper.getJedisPool();
			if (pool != null) {
				try (Jedis Jedis = pool.getResource()) {
					Jedis.select(0);
					value = Jedis.get(key.getBytes());
				}
			}
		} catch (Exception e) {
			log.error("Fail to get cached value", e);
		}
		return value;
	}
}
