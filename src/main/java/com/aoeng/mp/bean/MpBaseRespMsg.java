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

import java.util.Date;

/**
 * 发送被动响应消息 BaseResponse
 * 
 * @author sczhang 2014年11月28日 上午11:29:49
 * @Email {zhangshch0131@126.com}
 */
public abstract class MpBaseRespMsg implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9159599274148403367L;
	/**
	 * 接收方帐号（收到的OpenID）
	 */
	private String ToUserName;
	/**
	 * 开发者微信号
	 */
	private String FromUserName;
	/**
	 * 消息创建时间 （整型）
	 */
	private Long CreateTime;

	protected String MsgType;

	public MpBaseRespMsg() {

		super();
		this.MsgType = getMsgType();
	}

	/**
	 * @param inputMsg
	 */
	public MpBaseRespMsg(MpInputMsg inputMsg) {
		// TODO Auto-generated constructor stub
		super();
		this.CreateTime = new Date().getTime();
		this.FromUserName = inputMsg.getToUserName();
		this.ToUserName = inputMsg.getFromUserName();
		this.MsgType = getMsgType();
	}

	/**
	 * 获取 接收方帐号（收到的OpenID）
	 *
	 * @return 接收方帐号（收到的OpenID）
	 */
	public String getToUserName() {
		return ToUserName;
	}

	/**
	 * 设置 接收方帐号（收到的OpenID）
	 *
	 * @return 接收方帐号（收到的OpenID）
	 */
	public String getFromUserName() {
		return FromUserName;
	}

	/**
	 * 获取 消息创建时间 （整型）
	 *
	 * @return 消息创建时间 （整型）
	 */
	public Long getCreateTime() {
		return CreateTime;
	}

	/**
	 * 获取 消息类型
	 *
	 * @return 消息类型
	 */
	public abstract String getMsgType();

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

}