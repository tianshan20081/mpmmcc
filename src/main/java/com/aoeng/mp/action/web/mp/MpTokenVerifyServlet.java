package com.aoeng.mp.action.web.mp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.MpInputMsg;
import com.aoeng.mp.bean.MpTextRespMsg;
import com.aoeng.mp.enm.MpMsgType;
import com.aoeng.mp.service.MpService;
import com.aoeng.mp.service.impl.MpEventServiceImpl;
import com.aoeng.mp.service.impl.MpImageServiceImpl;
import com.aoeng.mp.service.impl.MpLinkServiceImpl;
import com.aoeng.mp.service.impl.MpLocationServiceImpl;
import com.aoeng.mp.service.impl.MpMusicServiceImpl;
import com.aoeng.mp.service.impl.MpTextServiceImpl;
import com.aoeng.mp.service.impl.MpVideoServiceImpl;
import com.aoeng.mp.service.impl.MpVoiceServiceImpl;
import com.aoeng.mp.utils.JPushUtils;
import com.aoeng.mp.utils.MpMsgCryptUtils;
import com.aoeng.mp.utils.MpRespUtils;
import com.aoeng.mp.utils.MpSignUtils;
import com.aoeng.mp.utils.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Servlet implementation class MpServlet
 */
@WebServlet("/mp/mpTokenVerify")
public class MpTokenVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 随机字符串
		String echostr = req.getParameter("echostr");
		PrintWriter out = resp.getWriter();
		out.print(echostr);
		out.close();
		out = null;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msgSignature = req.getParameter("signature");
		// 时间戳
		String timeStamp = req.getParameter("timestamp");
		// 随机数
		String nonce = req.getParameter("nonce");

		// 处理接收消息
		ServletInputStream in = req.getInputStream();
		// 将POST流转换为XStream对象
		XStream xs = new XStream(new DomDriver());
		// 将指定节点下的xml节点数据映射为对象
		xs.alias("xml", MpInputMsg.class);
		// 将流转换为字符串
		StringBuilder xmlMsg = new StringBuilder();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			xmlMsg.append(new String(b, 0, n, "UTF-8"));
		}
		in.close();
		StringBuffer buffer = new StringBuffer();
		buffer.append("msgSignature	").append(msgSignature);
		buffer.append("timeStamp	").append(timeStamp);
		buffer.append("nonce	").append(nonce);
		buffer.append("xmlMsg	").append(xmlMsg.toString());

		System.out.println(buffer.toString());
		JPushUtils.push(buffer.toString());
		String decodeMsg = MpMsgCryptUtils.getMsgDecode(msgSignature, timeStamp, nonce, xmlMsg.toString());
		// 将xml内容转换为InputMessage对象
		MpInputMsg inputMsg = (MpInputMsg) xs.fromXML(decodeMsg);
		// 取得消息类型
		String msgType = inputMsg.getMsgType();
		// 根据消息类型获取对应的消息内容
		MpService mpService = null;
		if (msgType.equals(MpMsgType.Text.toString())) {
			// 文本信息
			mpService = new MpTextServiceImpl();
		} else if (msgType.equals(MpMsgType.Image.toString())) {
			mpService = new MpImageServiceImpl();
		} else if (msgType.equals(MpMsgType.Music.toString())) {
			mpService = new MpMusicServiceImpl();
		} else if (msgType.equals(MpMsgType.Link.toString())) {
			mpService = new MpLinkServiceImpl();
		} else if (msgType.equals(MpMsgType.Location.toString())) {
			mpService = new MpLocationServiceImpl();
		} else if (msgType.equals(MpMsgType.Video.toString())) {
			mpService = new MpVideoServiceImpl();
		} else if (msgType.equals(MpMsgType.Voice.toString())) {
			mpService = new MpVoiceServiceImpl();
		} else if (msgType.equals(MpMsgType.Event.toString())) {
			mpService = new MpEventServiceImpl();
		}
		if (null != mpService) {
			mpService.resp(inputMsg, resp);
		} else {
			MpRespUtils.writeOut(MpRespUtils.getOutPutTextMsg(inputMsg, "未定义的操作类型"), resp);
		}

	}

}
