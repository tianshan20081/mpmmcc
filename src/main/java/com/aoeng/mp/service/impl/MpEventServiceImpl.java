package com.aoeng.mp.service.impl;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.MpInputMsg;
import com.aoeng.mp.bean.MpTextRespMsg;
import com.aoeng.mp.service.MpService;
import com.aoeng.mp.utils.MpRespUtils;

public class MpEventServiceImpl implements MpService {

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
		String event = inputMsg.getEvent();
		// 创建文本发送消息对象
		// Event 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
		String content = String.format("save event ok event : %s  ", event);
		MpRespUtils.writeOut(MpRespUtils.getOutPutTextMsg(inputMsg, content), resp);
	}

}
