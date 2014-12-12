/**
 * 
 */
package com.aoeng.mp.dao;

import com.aoeng.mp.enm.MpTables;

/**
 * @author sczhang 2014年12月11日 下午8:33:00
 * @Email {zhangshch0131@126.com}
 */
public interface MpBaseDao {

	boolean isTableExists(MpTables tbName);

	boolean createTable(String sql);

	boolean insert(String sql, Object... values);

}
