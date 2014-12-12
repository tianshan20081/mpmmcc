/**
 * 
 */
package com.aoeng.mp.dao;

import com.aoeng.mp.bean.MpUser;

/**
 * @author sczhang 2014年11月29日 下午6:11:49
 * @Email {zhangshch0131@126.com}
 */
public interface MpUserDao {

	/**
	 * @param mpUser
	 */
	boolean add(MpUser mpUser);

	/**
	 * @param mpUserName
	 * @return
	 */
	MpUser findUserByName(String mpUserName);

}
