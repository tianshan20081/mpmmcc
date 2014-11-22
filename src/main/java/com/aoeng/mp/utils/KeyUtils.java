/**
 * 
 */
package com.aoeng.mp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author paynet  Apr 3, 2014 3:46:30 PM
 * 
 */
public class KeyUtils {
	/**
	 * 創建訂單號
	 * @return
	 */
	public static String createOid(){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return format.format(new Date());
	}
	public static String  getYmd(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		return format.format(new Date());
	} 

}
