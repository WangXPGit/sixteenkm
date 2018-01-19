/** 
 * JsonUtil.java Create on 2017-11-29
 */

package com.sixteenkm.api.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixteenkm.api.json.CustomizeObjectMapper;

/**
 * JSON 工具类
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-29
 */
public final class JsonUtil {
	private static ObjectMapper objectMapper = new CustomizeObjectMapper();

	/**
	 * 将 POJO 对象转为 JSON 字符串
	 * 
	 * @param pojo
	 * @return
	 * @create_time 2017-11-29 22:00:21
	 */
	public static <T> String toJson(T pojo) {
		String json;
		try {
			json = objectMapper.writeValueAsString(pojo);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return json;
	}

	/**
	 * 将 JSON 字符串转为 POJO 对象
	 * 
	 * @param json
	 * @param type
	 * @return
	 * @create_time 2017-11-29 22:00:40
	 */
	public static <T> T fromJson(String json, Class<T> type) {
		T pojo;
		try {
			pojo = objectMapper.readValue(json, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return pojo;
	}

	/**
	 * 将指定 JSON 字符串转为指定类型集合对象
	 * 
	 * @param json
	 * @param collectionClass
	 * @param elementClass
	 * @return
	 */
	public static <T> T fromJson(String json, Class<?> collectionClass,
			Class<?> elementClass) {
		T pojo;
		try {
			JavaType javaType = objectMapper.getTypeFactory()
					.constructParametricType(collectionClass, elementClass);
			pojo = objectMapper.readValue(json, javaType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return pojo;
	}
}
