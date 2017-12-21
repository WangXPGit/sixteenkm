/** 
 * TokenManager.java Create on 2017-11-30
 */ 


package com.sixteenkm.api.security;

/**
 * 令牌管理器
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-30
 */
public interface TokenManager {

	String createToken(String username);

	boolean checkToken(String token);
}
