package com.aoeng.mp.dao.impl;

import com.aoeng.mp.dao.MpTextDao;

public class MpTextDaoImpl implements MpTextDao {

	@Override
	public String getContentById(int id) {
		// TODO Auto-generated method stub
		return "www.nokee.com  www.baidu.com";
	}

	@Override
	public String getContentByTitle(String title) {
		// TODO Auto-generated method stub
		return "这是一个 纯文本文件";
	}

}
