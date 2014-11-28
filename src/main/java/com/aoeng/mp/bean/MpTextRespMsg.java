/*
 * 微信公众平台(JAVA) SDK
 *
 * Copyright (c) 2014, Ansitech Network Technology Co.,Ltd All rights reserved.
 * http://www.ansitech.com/weixin/sdk/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aoeng.mp.bean;

import com.aoeng.mp.enm.MpMsgType;

/**
 * * 回复文本消息
 * http://mp.weixin.qq.com/wiki/index.php?title=%E5%8F%91%E9%80%81%E8%A2%AB
 * %E5%8A%A8%E5%93%8D%E5%BA%94%E6%B6%88%E6%81%AF
 * 
 * @author sczhang 2014年11月28日 上午11:30:42
 * @Email {zhangshch0131@126.com}
 */
public class MpTextRespMsg extends MpBaseRespMsg {

	/**
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[text]]></MsgType>
	 * <Content><![CDATA[你好]]></Content> </xml>
	 * 
	 * 参数 是否必须 描述 ToUserName 是 接收方帐号（收到的OpenID） FromUserName 是 开发者微信号 CreateTime
	 * 是 消息创建时间 （整型） MsgType 是 text Content 是
	 * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 */

	/**
	 * 文本消息
	 */
	private String Content;

	/**
	 * 创建一个新的 Output Message.并且MsgType的值为text.
	 */
	public MpTextRespMsg() {
	}

	/**
	 * 创建一个自定义文本内容content的Output Message.
	 *
	 * @param content
	 *            文本内容
	 */
	public MpTextRespMsg(String content) {
		Content = content;
	}

	/**
	 * @param inputMsg
	 */
	public MpTextRespMsg(MpInputMsg inputMsg) {
		// TODO Auto-generated constructor stub
		super(inputMsg);
	}

	/**
	 * 获取 消息类型
	 *
	 * @return 消息类型
	 */
	@Override
	public String getMsgType() {
		return MpMsgType.Text.toString();
	}

	/**
	 * 获取 文本消息
	 *
	 * @return 文本消息
	 */
	public String getContent() {
		return Content;
	}

	/**
	 * 设置 文本消息
	 *
	 * @param content
	 *            文本消息
	 */
	public void setContent(String content) {
		Content = content;
	}
}