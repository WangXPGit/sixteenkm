/** 
 * ServiceException.java Create on 2017-12-21
 */ 


package com.sixteenkm.api.jdbc;

/**
 * 服务运行异常
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-12-21
 */
public class ServiceException extends RuntimeException {

	public ServiceException(String message) {
        super(message);
    }
}
