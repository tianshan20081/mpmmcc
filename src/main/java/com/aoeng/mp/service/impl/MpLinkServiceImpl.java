package com.aoeng.mp.service.impl;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.MpInputMsg;
import com.aoeng.mp.bean.MpTextRespMsg;
import com.aoeng.mp.service.MpService;
import com.aoeng.mp.utils.MpRespUtils;

public class MpLinkServiceImpl implements MpService {

	@Override
	public String getContentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resp(MpInputMsg inputMsg, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String url = inputMsg.getUrl();

		String content = String.format("save link ok %s", url);
		MpRespUtils.writeOut(MpRespUtils.getOutPutTextMsg(inputMsg, content), resp);
	}

}
