package com.aoeng.mp.service.impl;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.InputMessage;
import com.aoeng.mp.bean.TextOutputMessage;
import com.aoeng.mp.dao.MpTextDao;
import com.aoeng.mp.dao.impl.MpTextDaoImpl;
import com.aoeng.mp.service.MpService;
import com.aoeng.mp.utils.MpRespUtils;

public class MpTextServiceImpl implements MpService {

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

	@Override
	public void resp(InputMessage inputMsg, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		MpRespUtils.logger(inputMsg.toString());
		String cont = inputMsg.getContent();
		// 创建文本发送消息对象
		TextOutputMessage outputMsg = MpRespUtils.getOutPutMsg(inputMsg);
		String respCont = "";
		try {
			int id = Integer.valueOf(cont);
			respCont = getContentById(Integer.valueOf(id));
		} catch (Exception e) {
			// TODO: handle exception
			respCont = getContentByTitle(cont);
		}

		outputMsg.setContent(respCont);
		MpRespUtils.writeOut(outputMsg, resp);
	}

}
