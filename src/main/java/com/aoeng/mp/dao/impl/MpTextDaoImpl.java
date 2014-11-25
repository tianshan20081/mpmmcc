package com.aoeng.mp.dao.impl;

import com.aoeng.mp.dao.MpTextDao;

public class MpTextDaoImpl implements MpTextDao {

	@Override
	public String getContentById(int id) {
		// TODO Auto-generated method stub
		return "save test success " + id;
	}

	@Override
	public String getContentByTitle(String title) {
		// TODO Auto-generated method stub
		return "save test success " + title;
	}

}
