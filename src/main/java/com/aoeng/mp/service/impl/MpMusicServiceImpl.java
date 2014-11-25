package com.aoeng.mp.service.impl;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.InputMessage;
import com.aoeng.mp.bean.TextOutputMessage;
import com.aoeng.mp.service.MpService;
import com.aoeng.mp.utils.MpRespUtils;

public class MpMusicServiceImpl implements MpService {

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
		String mediaId = inputMsg.getMediaId();
		String format = inputMsg.getFormat();
		// 创建文本发送消息对象
		TextOutputMessage outputMsg = MpRespUtils.getOutPutMsg(inputMsg);

		outputMsg.setContent(String.format("save music ok mediaId %s  format %s", mediaId, format));
		MpRespUtils.writeOut(outputMsg, resp);
	}

}
