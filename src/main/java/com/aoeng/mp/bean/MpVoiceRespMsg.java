/**
 * 
 */
package com.aoeng.mp.bean;

import java.util.List;

import com.aoeng.mp.enm.MpMsgType;

/**
 * 回复语音消息
 * 
 * @author sczhang 2014年11月28日 下午12:05:58
 * @Email {zhangshch0131@126.com}
 */
public class MpVoiceRespMsg extends MpBaseRespMsg {

	public MpVoiceRespMsg() {
		super();
	}

	/**
	 * @param inputMsg
	 */
	public MpVoiceRespMsg(MpInputMsg inputMsg) {
		// TODO Auto-generated constructor stub
		super(inputMsg);
	}

	/*
	 * 
	 * 
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[voice]]></MsgType>
	 * <Voice> <MediaId><![CDATA[media_id]]></MediaId> </Voice> </xml>
	 * 
	 * 参数 是否必须 说明 ToUserName 是 接收方帐号（收到的OpenID） FromUserName 是 开发者微信号 CreateTime
	 * 是 消息创建时间戳 （整型） MsgType 是 语音，voice MediaId 是 通过上传多媒体文件，得到的id
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 3018830670047079447L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.mp.bean.MpBaseRespMsg#getMsgType()
	 */
	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return MpMsgType.Voice.toString();
	}

	private Data Voice;

	public Data getVoice() {
		return Voice;
	}

	public void setVoice(Data voice) {
		Voice = voice;
	}

	public static class Data {
		private String MediaId;


		public String getMediaId() {
			return MediaId;
		}

		public void setMediaId(String mediaId) {
			MediaId = mediaId;
		}
	}

}
