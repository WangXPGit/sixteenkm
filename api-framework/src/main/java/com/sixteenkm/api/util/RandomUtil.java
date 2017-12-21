/** 
 * RandomUtil.java Create on 2017-11-30
 */

package com.sixteenkm.api.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 随机数工具类
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-30
 */
public final class RandomUtil {

	/**
	 * 生成随机数
	 * @param count
	 * @return
	 */
	public static String getRandom(int count) {
		return RandomStringUtils.randomNumeric(count);
	}

	private RandomUtil() {
	}
}
