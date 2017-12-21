/** 
 * WebContext.java Create on 2017-11-30
 */

package com.sixteenkm.api.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 封装了 Request 与 Response 对象
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-30
 */
public class WebContext {

	private static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();
	private static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<>();

    /**
     * 初始化
     * @param request
     * @param response
     */
	public static void init(HttpServletRequest request,
			HttpServletResponse response) {
        requestHolder.set(request);
        responseHolder.set(response);
    }

    /**
     * 销毁
     */
    public static void destroy() {
        requestHolder.remove();
        responseHolder.remove();
    }

    /**
     * 获取 Request 对象
     * @return
     */
    public static HttpServletRequest getRequest() {
        return requestHolder.get();
    }

    /**
     * 获取 Response 对象
     * @return
     */
    public static HttpServletResponse getResponse() {
        return responseHolder.get();
    }
}
