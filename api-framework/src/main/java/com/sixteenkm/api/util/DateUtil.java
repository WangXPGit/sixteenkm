/** 
 * DateUtil.java Create on 2017-11-30
 */

package com.sixteenkm.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @project api-framework
 * @author WangXP
 * @since 1.0.1
 * @date 2017-11-30
 */
public final class DateUtil {

	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat yyyy_dtf = new SimpleDateFormat(
			"yyyy");
	private static SimpleDateFormat MM_dtf = new SimpleDateFormat(
			"MM");

	/**
	 * 获取当前日期与时间, yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentDateTime() {
		return dateTimeFormat.format(new Date());
	}
	
	/**
	 * 获取当前年份, yyyy
	 */
	public static String getCurrentYear() {
		return yyyy_dtf.format(new Date());
	}
	
	/**
	 * 获取当前月份, MM
	 */
	public static String getCurrentMonth() {
		return MM_dtf.format(new Date());
	}

	private DateUtil() {
	}
}
