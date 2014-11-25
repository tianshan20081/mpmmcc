package com.aoeng.mp.service;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.InputMessage;

public interface MpService {

	String getContentById(int id);

	String getContentByTitle(String title);

	void resp(InputMessage inputMsg, HttpServletResponse resp);

}
