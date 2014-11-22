package com.aoeng.mp.action.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoeng.mp.bean.MpTextInfo;
import com.aoeng.mp.utils.SignUtils;
import com.aoeng.mp.utils.WXBizMsgCrypt;
import com.aoeng.mp.xmlparser.MpTextInfoParser;

/**
 * Servlet implementation class MpServlet
 */
@WebServlet("/mpTokenVerify")
public class MpokenVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);

		String signature = req.getParameter("signature");
		// 时间戳
		String timestamp = req.getParameter("timestamp");
		// 随机数
		String nonce = req.getParameter("nonce");
		// 随机字符串
		String echostr = req.getParameter("echostr");

		PrintWriter out = resp.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtils.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		MpTextInfo info = MpTextInfoParser.parser();
		out.close();
		out = null;

	}

}
