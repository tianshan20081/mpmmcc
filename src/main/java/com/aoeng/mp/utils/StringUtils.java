/**
 * 
 */
package com.aoeng.mp.utils;

/**
 * @author sczhang 2014年12月9日 上午10:37:17
 * @Email {zhangshch0131@126.com}
 */
public class StringUtils {

	/**
	 * 判断字符串是否为(全部)空
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return false :不为空；true ：为空
	 */
	public static boolean isEmpty(String... params) {
		// TODO Auto-generated method stub
		boolean isEmpty = false;
		if (null == params) {
			return isEmpty;
		}
		for (String string : params) {
			isEmpty = isEmptys(string);
			if (isEmpty) {
				break;
			}

		}
		return isEmpty;
	}

	/**
	 * @param string
	 * @return
	 */
	private static boolean isEmptys(String string) {
		// TODO Auto-generated method stub
		if (null != string && !"".equals(string.trim()) && !"null".equals(string.toLowerCase())) {
			return false;
		}
		return true;
	}

}
