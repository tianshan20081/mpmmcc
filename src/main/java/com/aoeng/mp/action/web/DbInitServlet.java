package com.aoeng.mp.action.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.utils.C3P0Utils;
import com.aoeng.mp.utils.JPushUtils;
import com.aoeng.mp.utils.JsonUtils;

/**
 * Servlet implementation class DbInitServlet
 */
@WebServlet(name = "dbInit", urlPatterns = { "/dbInit" })
public class DbInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = C3P0Utils.getConnection();
		String tbName = request.getParameter("tbname");
		boolean isExists = C3P0Utils.isExistsTable(tbName);
		map.put("request url", request.getRequestURL().toString());
		map.put("table " + tbName + " is exists ?", isExists ? "exists" : "not exists");
		map.put("remoteaddr", request.getRemoteAddr());
		map.put("timemillis", System.currentTimeMillis());
		map.put("method", request.getMethod());

		JsonUtils.toJson(map, response);
		JPushUtils.push(JsonUtils.toJsonString(map));
	}

}
