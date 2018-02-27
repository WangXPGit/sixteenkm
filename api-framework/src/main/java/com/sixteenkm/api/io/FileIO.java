/** 
 * FileIO.java Create on 2018年1月19日
 */ 


package com.sixteenkm.api.io;

import java.io.IOException;
import java.util.List;

/**
 * 文件 IO
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2018年1月19日
 */
public interface FileIO {
	<T> List<T> read(String name, T t, Class<T> tElement) throws IOException;
	void write(String name, Object obj) throws Exception;
}
