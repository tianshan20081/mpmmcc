/**
 * 
 */
package com.aoeng.mp.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.compiler.JspUtil;

import com.alibaba.fastjson.JSON;
import com.mchange.v2.log.LogUtils;

/**
 * @author paynet Mar 14, 2014 5:57:51 PM
 * 
 */
public class JsonUtils {

	public static void toJson(Map map, HttpServletResponse response) {
		try {
			String jsonStr = JSON.toJSONString(map);
			System.out.println(jsonStr);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonStr);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			try {
				response.getWriter().print("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static String toJsonString(Map map) {
		// TODO Auto-generated method stub
		String jsonStr = JSON.toJSONString(map);
		return jsonStr;
	}

	public static void toJsonString(String string, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			System.out.println(string);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(string);
			JPushUtils.push(string);
		} catch (Exception e) {
			// TODO: handle exception
			JPushUtils.push(e.toString());
			e.printStackTrace();
		}
	}

}
