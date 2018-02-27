/** 
 * StringUtil.java Create on 2017-11-29
 */

package com.sixteenkm.api.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 字符串工具类
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-29
 */
public final class StringUtil {

	/**
	 * 转换指定字符串为大写字符序列
	 * 
	 * @param str
	 * @return
	 */
	public static String upperCase(String str) {
		if (isEmpty(str)) {
			return null;
		}
		return str.toUpperCase();
	}

	/**
	 * 转换指定字符串为小写字符序列
	 * 
	 * @param str
	 * @return
	 */
	public static String lowerCase(String str) {
		if (isEmpty(str)) {
			return null;
		}
		return str.toLowerCase();
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 * @create_time 2017-11-29 21:40:09
	 */
	public static boolean isEmpty(String str) {
		if (str != null) {
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}

	/**
	 * 判断字符串数组中任何一个为非空, 即结果为 false
	 * 
	 * @param str
	 * @return
	 * @create_time 2017-11-29 21:40:09
	 */
	public static boolean isEmptyAnyone(String... strs) {
		String trimStr = null;
		for (String item : strs) {
			trimStr = item;
			if (item != null) trimStr = item.trim();
			if (StringUtils.isNotEmpty(trimStr)) return false;
		}
		return true;
	}

	/**
	 * 判断字符串是否非空
	 * @param str
	 * @return
	 * @create_time 2017-11-29 21:40:28
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 判断字符串是否为数字
	 * 
	 * @param str
	 * @return
	 * @create_time 2017-11-29 21:40:36
	 */
	public static boolean isNumeric(String str) {
		return NumberUtils.isDigits(str);
	}

	/**
	 * 正向查找指定字符串
	 * @param str
	 * @param searchStr
	 * @param ignoreCase
	 * @return
	 * @create_time 2017-11-29 21:40:44
	 */
	public static int indexOf(String str, String searchStr, boolean ignoreCase) {
		if (ignoreCase) {
			return StringUtils.indexOfIgnoreCase(str, searchStr);
		} else {
			return str.indexOf(searchStr);
		}
	}

	/**
	 * 反向查找指定字符串
	 * @param str
	 * @param searchStr
	 * @param ignoreCase
	 * @return
	 * @create_time 2017-11-29 21:40:51
	 */
	public static int lastIndexOf(String str, String searchStr,
			boolean ignoreCase) {
		if (ignoreCase) {
			return StringUtils.lastIndexOfIgnoreCase(str, searchStr);
		} else {
			return str.lastIndexOf(searchStr);
		}
	}
}
