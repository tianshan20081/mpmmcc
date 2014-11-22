/**
 * 
 */
package com.aoeng.mp.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

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

}
