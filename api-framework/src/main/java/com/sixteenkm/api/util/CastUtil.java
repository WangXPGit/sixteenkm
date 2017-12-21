/** 
 * CastUtil.java Create on 2017-11-29
 */

package com.sixteenkm.api.util;

/**
 * 类型转换工具类
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-29
 */
public final class CastUtil {

	/**
	 * 转为 String 型
	 * 
	 * @param obj
	 * @return
	 * @create_time 2017-11-29 21:38:02
	 */
	public static String castString(Object obj) {
		return CastUtil.castString(obj, "");
	}

	/**
	 * 转为 String 型（提供默认值）
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 * @create_time 2017-11-29 21:37:50
	 */
	public static String castString(Object obj, String defaultValue) {
		return obj != null ? String.valueOf(obj) : defaultValue;
	}

	/**
	 * 转为 double 型
	 * 
	 * @param obj
	 * @return
	 * @create_time 2017-11-29 21:37:36
	 */
	public static double castDouble(Object obj) {
		return CastUtil.castDouble(obj, 0);
	}

	/**
	 * 转为 double 型（提供默认值）
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 * @create_time 2017-11-29 21:37:18
	 */
	public static double castDouble(Object obj, double defaultValue) {
		double doubleValue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					doubleValue = Double.parseDouble(strValue);
				} catch (NumberFormatException e) {
					doubleValue = defaultValue;
				}
			}
		}
		return doubleValue;
	}

	/**
	 * 转为 long 型
	 * 
	 * @param obj
	 * @return
	 * @create_time 2017-11-29 21:37:10
	 */
	public static long castLong(Object obj) {
		return CastUtil.castLong(obj, 0);
	}

	/**
	 * 转为 long 型（提供默认值）
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 * @create_time 2017-11-29 21:37:02
	 */
	public static long castLong(Object obj, long defaultValue) {
		long longValue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					longValue = Long.parseLong(strValue);
				} catch (NumberFormatException e) {
					longValue = defaultValue;
				}
			}
		}
		return longValue;
	}

	/**
	 * 转为 int 型
	 * 
	 * @param obj
	 * @return
	 * @create_time 2017-11-29 21:36:52
	 */
	public static int castInt(Object obj) {
		return CastUtil.castInt(obj, 0);
	}

	/**
	 * 转为 int 型（提供默认值）
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 * @create_time 2017-11-29 21:36:46
	 */
	public static int castInt(Object obj, int defaultValue) {
		int intValue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					intValue = Integer.parseInt(strValue);
				} catch (NumberFormatException e) {
					intValue = defaultValue;
				}
			}
		}
		return intValue;
	}

	/**
	 * 转为 boolean 型
	 * 
	 * @param obj
	 * @return
	 * @create_time 2017-11-29 21:36:24
	 */
	public static boolean castBoolean(Object obj) {
		return CastUtil.castBoolean(obj, false);
	}

	/**
	 * 转为 boolean 型（提供默认值）
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 * @create_time 2017-11-29 21:36:14
	 */
	public static boolean castBoolean(Object obj, boolean defaultValue) {
		boolean booleanValue = defaultValue;
		if (obj != null) {
			booleanValue = Boolean.parseBoolean(castString(obj));
		}
		return booleanValue;
	}

	private CastUtil() {
	}
}
