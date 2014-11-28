/**
 * 
 */
package com.aoeng.mp.xstream;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.aoeng.mp.bean.MpMusicRespMsg;
import com.aoeng.mp.bean.MpNewRespMsg;
import com.aoeng.mp.bean.MpNewRespMsg.Data;
import com.aoeng.mp.utils.MpRespUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @author sczhang 2014年11月28日 下午1:07:56
 * @Email {zhangshch0131@126.com}
 */
public class Main {
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

	@Test
	public void toXml() {
		MpNewRespMsg msg = new MpNewRespMsg();
		msg.setCreateTime(System.currentTimeMillis());
		msg.setFromUserName("safsa");
		List<Data> articles = new ArrayList<Data>();
		for (int i = 0; i < 2; i++) {
			Data item = new MpNewRespMsg.Data("title" + i, "description", "picUrl", "url");
			articles.add(item);
		}
		msg.setArticles(articles);
		xstream.alias("xml", msg.getClass());
		xstream.alias("item", Data.class);
		// 将对象转换为XML字符串
		String xml = xstream.toXML(msg);
		System.out.println(xml);
	}

	@Test
	public void test() {
		List<Data> articles = new ArrayList<MpNewRespMsg.Data>();

		String picUrl = "";
		String url = "http://chuansongme.com/n/953660";
		articles.add(new Data("如果学习编程可以重来 ", "在过去的几个月里，我一直在学习用Objective-C编写iOS app，最后我开始理清思绪。这比我想象中要难很多，也花了太长时间。", picUrl, url));
		articles.add(new Data("如果学习编程可以重来 ", "在过去的几个月里，我一直在学习用Objective-C编写iOS app，最后我开始理清思绪。这比我想象中要难很多，也花了太长时间。", picUrl, url));

		MpNewRespMsg msg = new MpNewRespMsg();
		msg.setArticles(articles);
		msg.setArticleCount(articles.size());

		xstream.alias("xml", msg.getClass());
		xstream.alias("item", Data.class);
		// 将对象转换为XML字符串
		String xml = xstream.toXML(msg);
		System.out.println(xml);
	}

	@Test
	public void music() {

		String musicUrl = "http://tshan.qiniudn.com/b9174cc1-377e-4dc6-b98d-4707bc3d7f42.mp3";
		String hQMusicUrl = "http://tshan.qiniudn.com/1e5e53fd-169b-4921-8f9f-18bd1f834a61.mp3";
		String title = "拯救";
		String description = "孙楠的拯救";
		MpMusicRespMsg msg = new MpMusicRespMsg();
		MpMusicRespMsg.Data music = new MpMusicRespMsg.Data();
		music.setTitle(title);
		music.setDescription(description);
		music.setMusicUrl(musicUrl);
		music.setHQMusicUrl(hQMusicUrl);
		msg.setMusic(music);
		xstream.alias("xml", msg.getClass());
		String xml = xstream.toXML(msg);
		System.out.println(xml);
	}
}
