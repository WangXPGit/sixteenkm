/** 
 * BeanUtil.java Create on 2018年1月17日
 */

package com.sixteenkm.api.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * 实体工具类
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2018-1-17
 */
public final class BeanUtil {

	/**
	 * 转换指定对象为 java.lang.Map 对象。
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> toMap(Object object) throws Exception {
		if (object == null)
			return null;
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] declaredFields = object.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(object));
		}
		return map;
	}

	/**
	 * 转换指定 java.lang.Map 数值到指定类型的实例。
	 * 
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object toObject(Map<String, Object> map, Class<?> beanClass)
			throws Exception {
		if (map == null) return null;
		Object object = beanClass.newInstance();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			int mod = field.getModifiers();
			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}

			field.setAccessible(true);
			field.set(object, map.get(field.getName()));
		}
		return object;
	}

	private BeanUtil() {
	}
}
