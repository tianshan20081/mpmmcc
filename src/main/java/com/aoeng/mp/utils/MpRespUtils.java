package com.aoeng.mp.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.InputMessage;
import com.aoeng.mp.bean.TextOutputMessage;
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

	public static void writeOut(TextOutputMessage outputMsg, HttpServletResponse resp) {
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

	public static void logger(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		// JPushUtils.push(string);
	}

	public static TextOutputMessage getOutPutMsg(InputMessage inputMsg) {
		TextOutputMessage outputMsg = new TextOutputMessage();
		outputMsg.setCreateTime(new Date().getTime());
		outputMsg.setFromUserName(inputMsg.getToUserName());
		outputMsg.setToUserName(inputMsg.getFromUserName());
		return outputMsg;
	}

}
