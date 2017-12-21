/** 
 * SecurityAspect.java Create on 2017-11-30
 */

package com.sixteenkm.api.security;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.sixteenkm.api.web.WebContext;
import com.sixteenkm.api.util.StringUtil;

/**
 * 检查 token 的切面
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-30
 */
public class SecurityAspect {
	private static final String DEFAULT_TOKEN_NAME = "X-Token";
	private TokenManager tokenManager;
	private String tokenName;

	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}

	public void setTokenName(String tokenName) {
		if (StringUtil.isEmpty(tokenName)) {
			this.tokenName = DEFAULT_TOKEN_NAME;
		} else {
			this.tokenName = tokenName;
		}
	}

	public Object execute(ProceedingJoinPoint pjp) throws Throwable{
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		// 若目前方法忽律了安全性检查，则直接调用目标方法
		if (method.isAnnotationPresent(IgnoreSecurity.class)) {
			return pjp.proceed();
		}

		// 从 request header 中获取当前的 token
		String token = WebContext.getRequest().getHeader(tokenName);
		// 检查 token 有效性
		if (!tokenManager.checkToken(token)) {
			String message = String.format("token [%s] is invalid", token);
			throw new TokenException(message);
		}
		// 调用目标方法
		return pjp.proceed();
	}
}
