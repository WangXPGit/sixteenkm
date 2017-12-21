/** 
 * TokenException.java Create on 2017-11-30
 */

package com.sixteenkm.api.security;

/**
 * 令牌异常
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-30
 */
public class TokenException extends RuntimeException {
	private static final long serialVersionUID = 8533046061228286517L;

	public TokenException(String message) {
		super(message);
	}
}
