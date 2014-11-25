package com.aoeng.mp.service.impl;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.InputMessage;
import com.aoeng.mp.bean.TextOutputMessage;
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
	public void resp(InputMessage inputMsg, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String url = inputMsg.getUrl();
		// 创建文本发送消息对象
		TextOutputMessage outputMsg = MpRespUtils.getOutPutMsg(inputMsg);

		outputMsg.setContent("save link ok " + url);
		MpRespUtils.writeOut(outputMsg, resp);
	}

}
