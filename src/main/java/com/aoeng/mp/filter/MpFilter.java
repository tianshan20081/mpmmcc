package com.aoeng.mp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.aoeng.mp.utils.MpSignUtils;


/**
 * Servlet Filter implementation class MpFilter
 */
@WebFilter(filterName = "mpFilter", urlPatterns = { "/mp/*" })
public class MpFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public MpFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		String reqAction = httpRequest.getRequestURI();
		System.out.println(reqAction);
		String mpEncode = "/mp/mp_encode";
		CharSequence mpText = "/mp/mp_text";
		CharSequence mpBoth = "/mp/mp_both";
		if (reqAction.contains(mpEncode) || reqAction.contains(mpText) || reqAction.contains(mpBoth)) {
			String signature = httpRequest.getParameter("signature");
			// 时间戳
			String timestamp = httpRequest.getParameter("timestamp");
			// 随机数
			String nonce = httpRequest.getParameter("nonce");
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (MpSignUtils.checkSignature(signature, timestamp, nonce)) {
				System.out.println("signature	" + signature);
				System.out.println("timestamp	" + timestamp);
				System.out.println("nonce	" + nonce);
				chain.doFilter(servletRequest, servletResponse);
			} else {
				System.out.println("destory");
				destroy();
			}
		}
		// pass the request along the filter chain
		chain.doFilter(servletRequest, servletResponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
