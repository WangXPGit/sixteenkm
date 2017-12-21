/** 
 * DefaultTokenManager.java Create on 2017-11-30
 */

package com.sixteenkm.api.security.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

import com.sixteenkm.api.security.TokenManager;
import com.sixteenkm.api.util.CodecUtil;

/**
 * 默认令牌管理器
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-30
 */
public class DefaultTokenManager implements TokenManager {

	private static Map<String, String> tokenMaps = new ConcurrentHashMap<>();

	@Override
	public String createToken(String username) {
		String token = CodecUtil.createUUID();
		tokenMaps.put(token, username);
		return token;
	}

	@Override
	public boolean checkToken(String token) {
		return StringUtils.isNotEmpty(token) && tokenMaps.containsKey(token);
	}

}
