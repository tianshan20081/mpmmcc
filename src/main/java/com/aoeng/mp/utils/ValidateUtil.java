/**
 * 
 */
package com.aoeng.mp.utils;

import java.util.Collection;

/**
 * @author paynet Mar 13, 2014 6:56:33 PM
 * 
 */
public class ValidateUtil {
	/**
	 * 字符串的非空验证，空 ，返回 false ;非空 返回 true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isValid(String str) {
		if (str == null || "".equals(str.trim())) {
			return false;
		}
		return true;
	}

	/**
	 * 验证集合的非空性，为空 ,false ;非空 true
	 * 
	 * @param coll
	 * @return
	 */
	public static boolean isValid(Collection coll) {
		if (null == coll || coll.isEmpty()) {
			return false;
		}
		return true;
	}
}
