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

	/**
	 * 生成字符序列与指定个数的随机生成文本
	 * @param count
	 * @return
	 */
	public static String random(int count, char[] characters) {
		return RandomStringUtils.random(count, characters);
	}

	/**
	 * 生成随机[a-z]字符串，包含大小写
	 * @param count
	 * @return
	 */
	public static String randomAlphabetic(int count) {
		return RandomStringUtils.randomAlphabetic(count);
	}

	private RandomUtil() {
	}
}
