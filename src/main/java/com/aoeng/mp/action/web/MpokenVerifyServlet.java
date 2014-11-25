package com.aoeng.mp.action.web;

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

import com.aoeng.mp.bean.InputMessage;
import com.aoeng.mp.bean.TextOutputMessage;
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
import com.aoeng.mp.utils.MpRespUtils;
import com.aoeng.mp.utils.SignUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

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
		// 将xml内容转换为InputMessage对象
		InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());
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
			TextOutputMessage outPutMsg = MpRespUtils.getOutPutMsg(inputMsg);
			outPutMsg.setContent("未定义的操作类型");
			MpRespUtils.writeOut(outPutMsg, resp);
		}

	}

}
