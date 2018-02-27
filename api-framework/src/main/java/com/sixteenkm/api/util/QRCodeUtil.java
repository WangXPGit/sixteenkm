/** 
 * QRCodeUtil.java Create on 2017-12-25
 */

package com.sixteenkm.api.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 矩阵二维码工具
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.1.2
 * @date 2017-12-25
 */
public class QRCodeUtil {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(QRCodeUtil.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void createZxing(String targetImagePath) throws Exception {
		int width = 300;
		int hight = 300;
		String format = "png";
		String content = "www.baidu.com";
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);// 纠错等级L,M,Q,H
		hints.put(EncodeHintType.MARGIN, 2); // 边距
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, width, hight, hints);
		Path file = new File(targetImagePath).toPath();
		MatrixToImageWriter.writeToPath(bitMatrix, format, file);
	}

	public static void readZxing(String imagePath) throws IOException, NotFoundException {
		MultiFormatReader read = new MultiFormatReader();
		File file = new File(imagePath);
		BufferedImage image = ImageIO.read(file);
		Binarizer binarizer = new HybridBinarizer(
				new BufferedImageLuminanceSource(image));
		BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
		Result res = read.decode(binaryBitmap);
		System.out.println(res.toString());
		System.out.println(res.getBarcodeFormat());
		System.out.println(res.getText());
	}

	public static void main(String[] args)
	{
		String path = "/Users/wangxiaoping/Downloads/cikersgalaxy_title.png";
		try {
			createZxing(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
