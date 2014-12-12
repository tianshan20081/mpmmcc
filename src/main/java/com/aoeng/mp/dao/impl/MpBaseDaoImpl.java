/**
 * 
 */
package com.aoeng.mp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aoeng.mp.dao.MpBaseDao;
import com.aoeng.mp.enm.MpTables;
import com.aoeng.mp.utils.C3P0Utils;
import com.aoeng.mp.utils.StringUtils;

/**
 * @author sczhang 2014年12月11日 下午8:33:14
 * @Email {zhangshch0131@126.com}
 */
public class MpBaseDaoImpl implements MpBaseDao {
	protected Connection mConn = C3P0Utils.getConnection();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.mp.dao.MpBaseDao#isTableExists(java.lang.String)
	 */
	@Override
	public boolean isTableExists(MpTables tbName) {
		// TODO Auto-generated method stub
		return C3P0Utils.isExistsTable(tbName.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.mp.dao.MpBaseDao#createTable(java.lang.String)
	 */
	@Override
	public boolean createTable(String sql) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement st = mConn.prepareStatement(sql);
			if (!StringUtils.isEmpty(sql)) {
				st.execute(sql);
				C3P0Utils.closeStatement(st);
				return true;
			} else {
				throw new IllegalArgumentException("Create table sql isEmpty !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.mp.dao.MpBaseDao#insert(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public boolean insert(String sql, Object... values) {
		// TODO Auto-generated method stub
		try {
			if (StringUtils.isEmpty(sql)) {
				throw new IllegalArgumentException("insert table sql isEmpty !");
			} else {
				PreparedStatement ps = mConn.prepareStatement(sql);
				for (int i = 0; i < values.length; i++) {
					ps.setObject(i + 1, values[i]);
				}
				ps.execute();
				C3P0Utils.closeStatement(ps);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
