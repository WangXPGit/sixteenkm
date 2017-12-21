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
 * @since 1.0.0
 * @date 2017-11-30
 */
public final class DateUtil {

	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 获取当前日期与时间, yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentDateTime() {
		return dateTimeFormat.format(new Date());
	}

	private DateUtil() {
	}
}
