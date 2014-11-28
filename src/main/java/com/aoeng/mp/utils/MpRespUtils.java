package com.aoeng.mp.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.MpBaseRespMsg;
import com.aoeng.mp.bean.MpImageRespMsg;
import com.aoeng.mp.bean.MpInputMsg;
import com.aoeng.mp.bean.MpMusicRespMsg;
import com.aoeng.mp.bean.MpNewRespMsg;
import com.aoeng.mp.bean.MpNewRespMsg.Data;
import com.aoeng.mp.bean.MpTextRespMsg;
import com.aoeng.mp.bean.MpVideoRespMsg;
import com.aoeng.mp.bean.MpVoiceRespMsg;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MpRespUtils {
	static XStream xstream = new XStream(new XppDriver() {
		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				@Override
				protected void writeText(QuickWriter writer, String text) {
					if (!text.startsWith("<![CDATA[")) {
						text = "<![CDATA[" + text + "]]>";
					}
					writer.write(text);
				}
			};
		}
	});

	public static void writeOut(MpBaseRespMsg outputMsg, HttpServletResponse resp) {
		// TODO Auto-generated method stub

		try {
			String xml = "";
			if (null != outputMsg) {
				// 设置对象转换的XML根节点为xml
				xstream.alias("xml", outputMsg.getClass());
				// 将对象转换为XML字符串
				xstream.alias("item", Data.class);
				xml = xstream.toXML(outputMsg);
				// 将内容发送给微信服务器，发送到用户手机
			}
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(xml);
			resp.getWriter().flush();
			logger(xml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger(e.toString());
		}
	}

	public static void logger(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		JPushUtils.push(string);
	}

	public static MpTextRespMsg getOutPutTextMsg(MpInputMsg inputMsg, String content) {
		MpTextRespMsg outputMsg = new MpTextRespMsg(inputMsg);
		outputMsg.setContent(content);
		return outputMsg;
	}

	/**
	 * @param inputMsg
	 * @return
	 */
	public static MpImageRespMsg getOutPutImageMsg(MpInputMsg inputMsg, String mediaId) {
		// TODO Auto-generated method stub
		MpImageRespMsg msg = new MpImageRespMsg(inputMsg);
		msg.setMediaId(mediaId);
		return msg;
	}

	/**
	 * 
	 * @param inputMsg
	 * @param mediaId
	 * @return
	 */
	public static MpVoiceRespMsg getOutPutVoiceMsg(MpInputMsg inputMsg, String mediaId) {
		// TODO Auto-generated method stub
		MpVoiceRespMsg msg = new MpVoiceRespMsg(inputMsg);
		MpVoiceRespMsg.Data voice = new MpVoiceRespMsg.Data();
		voice.setMediaId(mediaId);
		msg.setVoice(voice);
		return msg;
	}

	/**
	 * @param inputMsg
	 * @param videoId
	 * @param title
	 * @param description
	 * @return
	 */
	public static MpVideoRespMsg getOutPutVideoMsg(MpInputMsg inputMsg, String mediaId, String title, String description) {
		// TODO Auto-generated method stub
		MpVideoRespMsg msg = new MpVideoRespMsg(inputMsg);
		MpVideoRespMsg.Data video = new MpVideoRespMsg.Data();
		video.setTitle(title);
		video.setMediaId(mediaId);
		video.setDescription(description);
		return msg;
	}

	/**
	 * 
	 * @param inputMsg
	 * @param title
	 * @param description
	 * @param hQMusicUrl
	 * @param musicURL
	 * @param thumbMediaId
	 * @return
	 */
	public static MpMusicRespMsg getOutPutMusicMsg(MpInputMsg inputMsg, String title, String description, String hQMusicUrl, String musicUrl, String thumbMediaId) {
		// TODO Auto-generated method stub
		MpMusicRespMsg msg = new MpMusicRespMsg(inputMsg);
		MpMusicRespMsg.Data music = new MpMusicRespMsg.Data();
		music.setTitle(title);
		music.setDescription(description);
		music.setHQMusicUrl(hQMusicUrl);
		music.setMusicUrl(musicUrl);
		// music.setThumbMediaId(thumbMediaId);
		msg.setMusic(music);
		return msg;
	}

	/**
	 * @param inputMsg
	 * @param mediaId
	 * @param articles
	 * @return
	 */
	public static MpNewRespMsg getOutPutNewMsg(MpInputMsg inputMsg, List<Data> articles) {
		// TODO Auto-generated method stub
		MpNewRespMsg msg = new MpNewRespMsg(inputMsg);
		msg.setArticles(articles);
		msg.setArticleCount(articles.size());
		return msg;
	}
}
