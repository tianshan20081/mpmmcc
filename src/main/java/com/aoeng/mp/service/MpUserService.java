/**
 * 
 */
package com.aoeng.mp.service;

import com.aoeng.mp.bean.MpUser;

/**
 * @author sczhang 2014年11月29日 下午6:12:50
 * @Email {zhangshch0131@126.com}
 */
public interface MpUserService {

	/**
	 * @param mpUser
	 */
	void addUser(MpUser mpUser);

	/**
	 * @param string
	 */
	MpUser findUserByName(String mpUserName);

}
