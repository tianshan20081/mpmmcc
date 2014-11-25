package com.aoeng.mp.service.impl;

import com.aoeng.mp.dao.MpTextDao;
import com.aoeng.mp.dao.impl.MpTextDaoImpl;
import com.aoeng.mp.service.MpTextService;

public class MpTextServiceImpl implements MpTextService {

	private MpTextDao textDao = new MpTextDaoImpl();
	@Override
	public String getContentById(int id) {
		// TODO Auto-generated method stub
		return textDao.getContentById(id);
	}
	@Override
	public String getContentByTitle(String title) {
		// TODO Auto-generated method stub
		return textDao.getContentByTitle(title);
	}
	
}
