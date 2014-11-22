package com.aoeng.mp.bean;

import java.io.Serializable;

/**
 * 文本消息
 * 
 * @author sczhang
 *
 */
public class MpTextInfo implements Serializable {
	// <xml>
	// <ToUserName><![CDATA[toUser]]></ToUserName>
	// <FromUserName><![CDATA[fromUser]]></FromUserName>
	// <CreateTime>1348831860</CreateTime>
	// <MsgType><![CDATA[text]]></MsgType>
	// <Content><![CDATA[this is a test]]></Content>
	// <MsgId>1234567890123456</MsgId>
	// </xml>
	/**
	 * 
	 */
	private static final long serialVersionUID = -6701491754166395745L;
	private String toUserName;
	private String fromUserName;
	private long createTime;
	private String msgType;
	private String content;
	private long msgId;

	public MpTextInfo(String toUserName, String fromUserName, long createTime, String msgType, String content, long msgId) {
		super();
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
		this.content = content;
		this.msgId = msgId;
	}

	public MpTextInfo() {
		super();
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	@Override
	public String toString() {
		return "MpTextInfo [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime + ", msgType=" + msgType + ", content=" + content + ", msgId=" + msgId + "]";
	}

}
