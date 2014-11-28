package com.aoeng.mp.service.impl;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.MpInputMsg;
import com.aoeng.mp.bean.MpTextRespMsg;
import com.aoeng.mp.dao.MpImageDao;
import com.aoeng.mp.dao.impl.MpImageDaoImpl;
import com.aoeng.mp.service.MpService;
import com.aoeng.mp.utils.MpRespUtils;

public class MpImageServiceImpl implements MpService {

	private MpImageDao mpImage = new MpImageDaoImpl();

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
		MpRespUtils.logger(inputMsg.toString());
		String picUrl = inputMsg.getPicUrl();
		// 创建文本发送消息对象

		String content = String.format("save image ok %s ", picUrl);
		MpRespUtils.writeOut(MpRespUtils.getOutPutTextMsg(inputMsg, content), resp);
	}

}
