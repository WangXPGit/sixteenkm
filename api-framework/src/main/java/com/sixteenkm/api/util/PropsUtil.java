/** 
 * PropsUtil.java Create on 2017-11-30
 */

package com.sixteenkm.api.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 属性文件工具类
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017-11-30
 */
public final class PropsUtil {

	private static Logger logger = LoggerFactory.getLogger(PropsUtil.class);

	/**
	 * 加载属性文件
	 * @param fileName
	 * @return
	 */
	public static Properties loadProps(String fileName) {
		Properties props = null;
		InputStream is = null;
		try {
			is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(fileName);
			if (is == null) {
				throw new FileNotFoundException(fileName + " file is not found");
			}
			props = new Properties();
			props.load(is);
		} catch (IOException e) {
			logger.error("load " + fileName + " properties file failure", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error("close input stream failure", e);
				}
			}
		}
		return props;
	}

	/**
	 * 是否包含某属性
	 * @param props
	 * @param key
	 * @return
	 */
	public static boolean containsKey(Properties props, String key) {
		return props.containsKey(key);
	}

	/**
	 * 获取字符型属性
	 * @param props
	 * @param key
	 * @return
	 */
	public static String getString(Properties props, String key) {
		String value = "";
		if (props.containsKey(key)) {
			value = props.getProperty(key);
		}
		return value;
	}

	/**
	 * 获取字符型属性（带有默认值）
	 * @param props
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(Properties props, String key,
			String defaultValue) {
		String value = defaultValue;
		if (props.containsKey(key)) {
			value = props.getProperty(key);
		}
		return value;
	}

	/**
	 * 获取数值型属性
	 * @param props
	 * @param key
	 * @return
	 */
	public static int getInt(Properties props, String key) {
		int value = 0;
		if (props.containsKey(key)) {
			value = CastUtil.castInt(props.getProperty(key));
		}
		return value;
	}

	/**
	 * 获取数值型属性（带有默认值）
	 * @param props
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static int getInt(Properties props, String key, int defaultValue) {
		int value = defaultValue;
		if (props.containsKey(key)) {
			value = CastUtil.castInt(props.getProperty(key));
		}
		return value;
	}

	/**
	 * 获取双精度型属性
	 * @param props
	 * @param key
	 * @return
	 */
	public static double getDouble(Properties props, String key) {
		double value = 0D;
		if (props.containsKey(key)) {
			value = CastUtil.castDouble(props.getProperty(key));
		}
		return value;
	}

	/**
	 * 获取双精度型属性(带有默认值)
	 * @param props
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static double getDouble(Properties props, String key, double defaultValue) {
		double value = defaultValue;
		if (props.containsKey(key)) {
			value = CastUtil.castDouble(props.getProperty(key));
		}
		return value;
	}

	/**
	 * 获取布尔型属性
	 * @param props
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(Properties props, String key) {
		return getBoolean(props, key, false);
	}

	/**
	 * 获取布尔型属性（带有默认值）
	 * @param props
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static boolean getBoolean(Properties props, String key,
			boolean defaultValue) {
		boolean value = defaultValue;
		if (props.containsKey(key)) {
			value = CastUtil.castBoolean(props.getProperty(key));
		}
		return value;
	}

	private PropsUtil() {
	}
}
