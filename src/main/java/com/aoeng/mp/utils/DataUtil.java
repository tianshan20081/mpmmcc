/**
 * 
 */
package com.aoeng.mp.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author paynet Mar 13, 2014 6:58:10 PM
 * 
 */
public class DataUtil {

	public static Double format(double f) {
		BigDecimal bg = new BigDecimal(f);
		double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	/**
	 * 进行 md5 加密
	 * 
	 * @param src
	 * @return
	 */
	public static String md5(String src) {
		try {
			StringBuffer buffer = new StringBuffer();
			char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] data = digest.digest(src.getBytes());
			for (byte b : data) {
				buffer.append(chars[(b >> 4) & 0x0F]);

				buffer.append(chars[b & 0x0F]);
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
