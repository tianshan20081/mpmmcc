/**
 * 
 */
package com.aoeng.mp.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aoeng.mp.bean.MpUser;
import com.aoeng.mp.dao.MpUserDao;
import com.aoeng.mp.enm.MpTables;

/**
 * @author sczhang 2014年11月29日 下午6:12:23
 * @Email {zhangshch0131@126.com}
 */
public class MpUserDaoImpl extends MpBaseDaoImpl implements MpUserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.mp.dao.MpUserDao#add(com.aoeng.mp.bean.MpUser)
	 */
	@Override
	public boolean add(MpUser mpUser) {
		// TODO Auto-generated method stub
		String sql = "insert into " + MpTables.TB_MP_USER.getValue() + "(username,eventDate,lastAccessDate) values(?,?,?)";
		if (!isTableExists(MpTables.TB_MP_USER)) {
			String sqlCreate = "create table " + MpTables.TB_MP_USER.getValue() + "(id int auto_increment primary key,username unique  varchar(50),eventDate date, lastAccessDate date)";
			if (!createTable(sqlCreate)) {
				return false;
			}
		}
		return insertUser(sql, mpUser);
	}

	/**
	 * @param mpUser
	 * @return
	 */
	private boolean insertUser(String sql, MpUser mpUser) {
		// TODO Auto-generated method stub
		MpUser user = findUserByName(mpUser.getUserName());
		if (null != user) {
			return insert(sql, mpUser.getUserName(), mpUser.getEventDate(), mpUser.getLastAccessDate());		
		}else {
			throw new IllegalArgumentException("");
		}
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.mp.dao.MpUserDao#findUserByName(java.lang.String)
	 */
	@Override
	public MpUser findUserByName(String mpUserName) {
		// TODO Auto-generated method stub
		try {
			if (!isTableExists(MpTables.TB_MP_USER)) {
				
				return null;
			}
			String sql = "select id,username,eventDate,lastAccessDate from mp_user where username=? ";
			PreparedStatement ps = mConn.prepareStatement(sql);
			ps.setString(1, mpUserName);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				int id = set.getInt(1);
				String userName = set.getString(2);
				Date eventDate = set.getDate(3);
				Date lastAccessDate = set.getDate(4);
				return new MpUser(id, userName, eventDate, lastAccessDate);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
