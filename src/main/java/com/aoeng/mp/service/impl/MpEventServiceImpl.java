package com.aoeng.mp.service.impl;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.MpInputMsg;
import com.aoeng.mp.bean.MpTextRespMsg;
import com.aoeng.mp.bean.MpUser;
import com.aoeng.mp.enm.MpEvent;
import com.aoeng.mp.service.MpService;
import com.aoeng.mp.service.MpUserService;
import com.aoeng.mp.utils.MpRespUtils;
import com.aoeng.mp.utils.StringUtils;

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
		if (!StringUtils.isEmpty(event)) {
			if (event.toLowerCase().equals(MpEvent.SUBSCRIBE.getValue())) {
				MpUserService userService = new MpUserServiceImpl();
				MpUser user = new MpUser();
				userService.addUser(new MpUser(inputMsg.getFromUserName()));
				
				MpRespUtils.writeOut(MpRespUtils.getOutPutTextMsg(inputMsg, "您好，朋友，欢迎关注 MMCC 订阅号。"), resp);
			} else if (event.toLowerCase().equals(MpEvent.UNSUBSCRIBE.getValue())) {
				MpRespUtils.writeOut(MpRespUtils.getOutPutTextMsg(inputMsg, "您好，好友关注被取消了"), resp);
			} else {
				MpRespUtils.writeOut(MpRespUtils.getOutPutTextMsg(inputMsg, "未定义的 服务类型"), resp);
			}
		} else {
			MpRespUtils.writeOut(MpRespUtils.getOutPutTextMsg(inputMsg, "未定义的 服务类型"), resp);
		}

	}

}
