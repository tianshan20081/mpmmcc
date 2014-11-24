package com.aoeng.mp.action.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.InputMessage;
import com.aoeng.mp.bean.TextOutputMessage;
import com.aoeng.mp.enm.MpMsgType;
import com.aoeng.mp.utils.JPushUtils;
import com.aoeng.mp.utils.SignUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * Servlet implementation class MpServlet
 */
@WebServlet("/mpTokenVerify")
public class MpokenVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String signature = req.getParameter("signature");
		// 时间戳
		String timestamp = req.getParameter("timestamp");
		// 随机数
		String nonce = req.getParameter("nonce");
		// 随机字符串
		String echostr = req.getParameter("echostr");
		Map map = new HashMap<String, String[]>();
		map.putAll(req.getParameterMap());
		map.put("requestMethod", req.getRequestURL().toString());
		PrintWriter out = resp.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtils.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);

		// 处理接收消息
		ServletInputStream in = req.getInputStream();
		// 将POST流转换为XStream对象
		XStream xs = new XStream(new DomDriver());
		// 将指定节点下的xml节点数据映射为对象
		xs.alias("xml", InputMessage.class);
		// 将流转换为字符串
		StringBuilder xmlMsg = new StringBuilder();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			xmlMsg.append(new String(b, 0, n, "UTF-8"));
		}
		System.out.println("xmlMsg.toString()" + xmlMsg.toString());
		// 将xml内容转换为InputMessage对象
		InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());
		// 取得消息类型
		String msgType = inputMsg.getMsgType();
		System.out.println("msgType" + msgType);
		// 根据消息类型获取对应的消息内容
		if (msgType.equals(MpMsgType.Text.toString())) {
			// 文本消息
			StringBuffer buffer = new StringBuffer();
			buffer.append("开发者微信号：" + inputMsg.getToUserName());
			buffer.append("发送方帐号：" + inputMsg.getFromUserName());
			buffer.append("消息创建时间：" + inputMsg.getCreateTime());
			buffer.append("消息内容：" + inputMsg.getContent());
			buffer.append("消息Id：" + inputMsg.getMsgId());
			System.out.println("开发者微信号：" + inputMsg.getToUserName());
			System.out.println("发送方帐号：" + inputMsg.getFromUserName());
			System.out.println("消息创建时间：" + inputMsg.getCreateTime());
			System.out.println("消息内容：" + inputMsg.getContent());
			System.out.println("消息Id：" + inputMsg.getMsgId());

			try {
				// 文本消息
				System.out.println("开发者微信号：" + inputMsg.getToUserName());
				System.out.println("发送方帐号：" + inputMsg.getFromUserName());
				System.out.println("消息创建时间：" + inputMsg.getCreateTime());
				System.out.println("消息内容：" + inputMsg.getContent());
				System.out.println("消息Id：" + inputMsg.getMsgId());
				// 发送文本消息 start
				XStream xstream = new XStream(new XppDriver() {
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
				// 创建文本发送消息对象
				TextOutputMessage outputMsg = new TextOutputMessage();
				outputMsg.setContent("你的消息已经收到，谢谢！");
				setOutputMsgInfo(outputMsg, inputMsg);
				// 设置对象转换的XML根节点为xml
				xstream.alias("xml", outputMsg.getClass());
				// 将对象转换为XML字符串
				String xml = xstream.toXML(outputMsg);
				// 将内容发送给微信服务器，发送到用户手机
				resp.setCharacterEncoding("UTF-8");
				resp.getWriter().write(xml);
			} catch (Exception ex) {
				System.out.println("消息接受和发送出现异常!");
				ex.printStackTrace();
			}
			JPushUtils.push(buffer.toString());
		}

	}

	private void setOutputMsgInfo(TextOutputMessage oms, InputMessage msg) throws Exception, SecurityException {
		// TODO Auto-generated method stub
		// 设置发送信息
		Class<?> outMsg = oms.getClass().getSuperclass();
		Field CreateTime = outMsg.getDeclaredField("CreateTime");
		Field ToUserName = outMsg.getDeclaredField("ToUserName");
		Field FromUserName = outMsg.getDeclaredField("FromUserName");

		ToUserName.setAccessible(true);
		CreateTime.setAccessible(true);
		FromUserName.setAccessible(true);

		CreateTime.set(oms, new Date().getTime());
		ToUserName.set(oms, msg.getFromUserName());
		FromUserName.set(oms, msg.getToUserName());
	}

}
