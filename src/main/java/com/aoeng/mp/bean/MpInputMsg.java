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

/**
 * 接收普通消息
 * 
 * @author sczhang 2014年11月28日 上午11:33:45
 * @Email {zhangshch0131@126.com}
 */
public class MpInputMsg {
	/**
	 * 当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。各消息类型的推送XML数据包结构如下：
	 * 
	 * 微信服务器在五秒内收不到响应会断掉连接，并且重新发起请求，总共重试三次
	 * 
	 * 关于重试的消息排重，推荐使用msgid排重。
	 * 
	 * 假如服务器无法保证在五秒内处理并回复，可以直接回复空串，微信服务器不会对此作任何处理，并且不会发起重试。
	 */
	private String ToUserName;
	private String FromUserName;
	private Long CreateTime;
	private String MsgType = "text";
	private Long MsgId;
	// 文本消息
	private String Content;
	// 图片消息
	private String PicUrl;
	// 位置消息
	private String LocationX;
	private String LocationY;
	private Long Scale;
	private String Label;
	// 链接消息
	private String Title;
	private String Description;
	private String Url;
	// 语音信息
	private String MediaId;
	private String Format;
	private String Recognition;
	// 事件
	private String Event;
	private String EventKey;
	private String Ticket;
	private String ThumbMediaId;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getLocationX() {
		return LocationX;
	}

	public void setLocationX(String locationX) {
		LocationX = locationX;
	}

	public String getLocationY() {
		return LocationY;
	}

	public void setLocationY(String locationY) {
		LocationY = locationY;
	}

	public Long getScale() {
		return Scale;
	}

	public void setScale(Long scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	@Override
	public String toString() {
		return "InputMessage [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime + ", MsgType=" + MsgType + ", MsgId=" + MsgId + ", Content=" + Content
				+ ", PicUrl=" + PicUrl + ", LocationX=" + LocationX + ", LocationY=" + LocationY + ", Scale=" + Scale + ", Label=" + Label + ", Title=" + Title + ", Description=" + Description
				+ ", Url=" + Url + ", MediaId=" + MediaId + ", Format=" + Format + ", Recognition=" + Recognition + ", Event=" + Event + ", EventKey=" + EventKey + ", Ticket=" + Ticket
				+ ", ThumbMediaId=" + ThumbMediaId + "]";
	}

}