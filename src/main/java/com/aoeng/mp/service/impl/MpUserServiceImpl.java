/**
 * 
 */
package com.aoeng.mp.service.impl;

import com.aoeng.mp.bean.MpUser;
import com.aoeng.mp.dao.MpUserDao;
import com.aoeng.mp.dao.impl.MpUserDaoImpl;
import com.aoeng.mp.service.MpUserService;

/**
 * @author sczhang 2014年11月29日 下午6:13:00
 * @Email {zhangshch0131@126.com}
 */
public class MpUserServiceImpl implements MpUserService {

	private MpUserDao userDao = new MpUserDaoImpl();


	/* (non-Javadoc)
	 * @see com.aoeng.mp.service.MpUserService#addUser(com.aoeng.mp.bean.MpUser)
	 */
	@Override
	public void addUser(MpUser mpUser) {
		// TODO Auto-generated method stub
		userDao.add(mpUser);
	}


	/* (non-Javadoc)
	 * @see com.aoeng.mp.service.MpUserService#findUserByName(java.lang.String)
	 */
	@Override
	public MpUser findUserByName(String mpUserName) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(mpUserName);
	}

}
