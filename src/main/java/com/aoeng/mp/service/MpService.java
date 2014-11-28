package com.aoeng.mp.service;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.MpInputMsg;

public interface MpService {

	String getContentById(int id);

	String getContentByTitle(String title);

	void resp(MpInputMsg inputMsg, HttpServletResponse resp);

}
