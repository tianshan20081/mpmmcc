package com.aoeng.mp.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.MpBaseRespMsg;
import com.aoeng.mp.bean.MpInputMsg;
import com.aoeng.mp.bean.MpNewRespMsg;
import com.aoeng.mp.bean.MpNewRespMsg.Data;
import com.aoeng.mp.bean.MpVoiceRespMsg;
import com.aoeng.mp.dao.MpTextDao;
import com.aoeng.mp.dao.impl.MpTextDaoImpl;
import com.aoeng.mp.enm.MpMsgType;
import com.aoeng.mp.service.MpService;
import com.aoeng.mp.utils.MpRespUtils;

public class MpTextServiceImpl extends MpServiceImpl implements MpService {

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
	public void resp(MpInputMsg inputMsg, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String cont = inputMsg.getContent();
		MpBaseRespMsg respMsg = null;
		if (MpMsgType.Image.toString().equalsIgnoreCase(cont)) {
			String mediaId = "";
			respMsg = MpRespUtils.getOutPutImageMsg(inputMsg, mediaId);
			String content = "抱歉 调用该接口 需要微信认证，主人正在积极申请中，请稍后。。。";
			respMsg = MpRespUtils.getOutPutTextMsg(inputMsg, content);
		} else if (MpMsgType.Text.toString().equalsIgnoreCase(cont)) {
			String content = String.format("save text ok content %s ", cont);
			respMsg = MpRespUtils.getOutPutTextMsg(inputMsg, content);
		} else if (MpMsgType.Voice.toString().equalsIgnoreCase(cont)) {
			String mediaId = "";
			respMsg = MpRespUtils.getOutPutVoiceMsg(inputMsg, mediaId);
			String content = "抱歉 调用该接口 需要微信认证，主人正在积极申请中，请稍后。。。";
			respMsg = MpRespUtils.getOutPutTextMsg(inputMsg, content);
		} else if (MpMsgType.Video.toString().equalsIgnoreCase(cont)) {
			String videoId = "videoId";
			String title = "title";
			String description = "description";
			// respMsg = MpRespUtils.getOutPutVideoMsg(inputMsg, videoId, title,
			// description);
			String content = "抱歉 调用该接口 需要微信认证，主人正在积极申请中，请稍后。。。";
			respMsg = MpRespUtils.getOutPutTextMsg(inputMsg, content);

		} else if (MpMsgType.Music.toString().equalsIgnoreCase(cont)) {

			String musicUrl = "http://tshan.qiniudn.com/b9174cc1-377e-4dc6-b98d-4707bc3d7f42.mp3";
			String hQMusicUrl = "http://tshan.qiniudn.com/1e5e53fd-169b-4921-8f9f-18bd1f834a61.mp3";
			String title = "拯救";
			String description = "孙楠的拯救";
			String thumbMediaId = "";
			respMsg = MpRespUtils.getOutPutMusicMsg(inputMsg, title, description, hQMusicUrl, musicUrl, thumbMediaId);
		} else if (MpMsgType.NEWS.toString().equalsIgnoreCase(cont)) {
			List<Data> articles = new ArrayList<MpNewRespMsg.Data>();

			String picUrl = "http://tshan.qiniudn.com/0073cc8b-6615-42c1-b9b3-61679426c5c7.jpg";
			String url = "http://chuansongme.com/n/953660";
			articles.add(new Data("如果学习编程可以重来 ", "在过去的几个月里，我一直在学习用Objective-C编写iOS app，最后我开始理清思绪。这比我想象中要难很多，也花了太长时间。", picUrl, url));
			articles.add(new Data("如果学习编程可以重来 ", "在过去的几个月里，我一直在学习用Objective-C编写iOS app，最后我开始理清思绪。这比我想象中要难很多，也花了太长时间。", picUrl, url));
			respMsg = MpRespUtils.getOutPutNewMsg(inputMsg, articles);
		} else {
			String content = String.format("save text ok content %s ", "未定义的 服务类型");
			respMsg = MpRespUtils.getOutPutTextMsg(inputMsg, content);
		}

		MpRespUtils.writeOut(respMsg, resp);
	}

}
