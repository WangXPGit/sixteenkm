/** 
 * SerializationUtil.java Create on 2017-11-30
 */

package com.sixteenkm.api.util;

import org.springframework.util.SerializationUtils;

/**
 * 序列化工具类
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-30
 */
public final class SerializationUtil {

	/**
	 * 序列化
	 * 
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		return SerializationUtils.serialize(object);
	}

	/**
	 * 反序列化
	 * 
	 * @param bytes
	 * @return
	 */
	public static Object deserialize(byte[] bytes) {
		return SerializationUtils.deserialize(bytes);
	}

	private SerializationUtil() {
	}
}
