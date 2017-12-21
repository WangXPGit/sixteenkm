/** 
 * ArrayUtil.java Create on 2017-11-29
 * www.cikers.com. 
 */

package com.sixteenkm.api.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-29
 */
public final class ArrayUtil {

	/**
	 * 指定数组是否为空
	 * 
	 * @param array
	 * @return true: 空的 <br/>
	 *         false: 非空的
	 * @create_time 2017-11-29 21:24:54
	 */
	public static boolean isEmpty(Object[] array) {
		return ArrayUtils.isEmpty(array);
	}

	/**
	 * 指定数据为非空
	 * 
	 * @param array
	 * @return true: 非空的 <br/>
	 *         false: 空的
	 * @create_time 2017-11-29 21:27:24
	 */
	public static boolean isNotEmpty(Object[] array) {
		return ArrayUtils.isNotEmpty(array);
	}

	/**
	 * Array 转 List
	 * 
	 * @param array
	 * @return
	 * @create_time 2017-11-29 21:28:49
	 */
	public static <T> List<T> toList(T[] array) {
		if (isEmpty(array)) {
			return new ArrayList<T>();
		}
		return Arrays.asList(array);
	}

	private ArrayUtil() {
	}
}