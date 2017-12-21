/** 
 * RedisTokenManager.java Create on 2017-11-30
 */

package com.sixteenkm.api.security.impl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.sixteenkm.api.security.TokenManager;
import com.sixteenkm.api.util.CodecUtil;

/**
 * 基于 Redis 的令牌管理器
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-30
 */
public class RedisTokenManager implements TokenManager {
	private static final int DEFAULT_DATABASE = 0;
	private static final int DEFAULT_SECONDS = 0;

	private JedisPool jedisPool;
	private int database = DEFAULT_DATABASE;
	private int seconds = DEFAULT_SECONDS;

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	@Override
	public String createToken(String username) {
		String token = CodecUtil.createUUID();
		try (Jedis jedis = jedisPool.getResource()) {
			jedis.select(database);
			if (seconds != 0) {
				jedis.setex(token, seconds, username);
			} else {
				jedis.set(token, username);
			}
		}
		return token;
	}

	@Override
	public boolean checkToken(String token) {
		boolean result;
		try (Jedis jedis = jedisPool.getResource()) {
			jedis.select(database);
			result = jedis.exists(token);
			if (seconds != 0) {
				jedis.expire(token, seconds);
			}
		}
		return result;
	}
}
