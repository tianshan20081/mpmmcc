package com.aoeng.mp.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.InputMessage;
import com.aoeng.mp.bean.TextOutputMessage;
import com.aoeng.mp.service.MpTextService;
import com.aoeng.mp.service.impl.MpTextServiceImpl;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MpTextUtils {

	public static MpTextService textService = new MpTextServiceImpl();
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

	public static void resp(InputMessage inputMsg, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		logsInfo(inputMsg);
		String cont = inputMsg.getContent();
		// 创建文本发送消息对象
		TextOutputMessage outputMsg = getOutPutMsg(inputMsg);
		String respCont = "";
		try {
			int id = Integer.valueOf(cont);
			respCont = textService.getContentById(Integer.valueOf(id));
		} catch (Exception e) {
			// TODO: handle exception
			respCont = textService.getContentByTitle(cont);
		}

		outputMsg.setContent(respCont);
		writeOut(outputMsg, resp);
	}

	private static void logsInfo(InputMessage inputMsg) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("开发者微信号：" + inputMsg.getToUserName());
		buffer.append("发送方帐号：" + inputMsg.getFromUserName());
		buffer.append("消息创建时间：" + inputMsg.getCreateTime());
		buffer.append("消息内容：" + inputMsg.getContent());
		buffer.append("消息Id：" + inputMsg.getMsgId());
		logger(buffer.toString());
	}

	private static TextOutputMessage getOutPutMsg(InputMessage inputMsg) {
		// TODO Auto-generated method stub
		TextOutputMessage outputMsg = new TextOutputMessage();
		outputMsg.setCreateTime(new Date().getTime());
		outputMsg.setFromUserName(inputMsg.getToUserName());
		outputMsg.setToUserName(inputMsg.getFromUserName());
		return outputMsg;
	}

	private static void logger(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		JPushUtils.push(string);
	}

	private static void writeOut(TextOutputMessage outputMsg, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		// 设置对象转换的XML根节点为xml
		xstream.alias("xml", outputMsg.getClass());
		// 将对象转换为XML字符串
		String xml = xstream.toXML(outputMsg);
		// 将内容发送给微信服务器，发送到用户手机
		resp.setCharacterEncoding("UTF-8");
		try {
			logger(xml);
			resp.getWriter().write(xml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger(e.toString());
		}
	}

}
