/** 
 * JavaIO.java Create on 2018年1月19日
 */

package com.sixteenkm.api.io.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sixteenkm.api.io.FileIO;
import com.sixteenkm.api.io.IOFormater;
import com.sixteenkm.api.util.JsonUtil;

/**
 * 基于 Java 原生的文件 IO 处理。
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2018年1月19日
 */
public final class JavaIO implements FileIO {

	@Override
	public <T> List<T> read(String name, T t, Class<T> t1)
			throws IOException {
		FileInputStream inputStream = null;
		Scanner fileScanner = null;
		List datas = new ArrayList();
		try {
			File file = new File(name);
			if (!file.exists()) return null;
			inputStream = new FileInputStream(name);
			fileScanner = new Scanner(inputStream, "UTF-8");
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				if (t1 == String.class) {
					datas.add(line);
				} else {
					datas.add(JsonUtil.fromJson(line, t1.getClass()));
				}
			}
			if (fileScanner.ioException() != null) {
				throw fileScanner.ioException();
			}
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} finally {
				if (fileScanner != null) {
					fileScanner.close();
				}
			}
		}
		return datas;
	}

	@Override
	public void write(String name, Object obj)
			throws Exception
	{
		File file = new File(name);
		if (!file.exists()) {
			if (!file.createNewFile())
				throw new FileNotFoundException(name + " create fail.");
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.write(obj.toString());
		writer.close();
		writer = null;
	}
}
