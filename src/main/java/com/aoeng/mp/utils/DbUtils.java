package com.aoeng.mp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbUtils {

	private static class InstanceHolder {
		public static final DbUtils instance = new DbUtils();
	}

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_test";
	private static final String PWSSWORD = "admin";
	private static final String USERNAME = "root";

	private ArrayList<Connection> conns;

	private DbUtils() {
		conns = new ArrayList<Connection>();
		for (int i = 0; i < 3; i++) {
			conns.add(getConn());
		}

	}

	public static DbUtils getInstance() {
		return InstanceHolder.instance;
	}

	private static Connection getConn() {
		try {
			Class.forName(com.mysql.jdbc.Driver.class.getName());
			Connection connection = DriverManager.getConnection(URL, USERNAME, PWSSWORD);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConn(Connection conn) {
		if (null != conn) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
