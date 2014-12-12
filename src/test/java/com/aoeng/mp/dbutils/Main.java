package com.aoeng.mp.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aoeng.mp.utils.C3P0Utils;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection conn = C3P0Utils.getConnection();
		System.out.println(conn);
		String tableName = "mp_text";
		boolean isExists = C3P0Utils.isExistsTable(tableName);
		if (isExists) {
			System.out.println("exists ");
		} else {
			System.out.println("not exists ");
		}
		String sql = "select count(*) from mp_text";
		for (int i = 0; i < 100; i++) {
			Connection conn2 = C3P0Utils.getConnection();
			System.out.println(conn2);
		}

	}

}
