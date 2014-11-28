/**
 * 
 */
package com.aoeng.mp.bean;

import com.aoeng.mp.enm.MpMsgType;

/**
 * 回复视频消息
 * 
 * @author sczhang 2014年11月28日 下午12:16:01
 * @Email {zhangshch0131@126.com}
 */
public class MpVideoRespMsg extends MpBaseRespMsg {
	/**
	 * @param inputMsg
	 */
	public MpVideoRespMsg(MpInputMsg inputMsg) {
		// TODO Auto-generated constructor stub
		super(inputMsg);
	}

	/*
	 * 回复视频消息
	 * 
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[video]]></MsgType>
	 * <Video> <MediaId><![CDATA[media_id]]></MediaId>
	 * <Title><![CDATA[title]]></Title>
	 * <Description><![CDATA[description]]></Description> </Video> </xml>
	 * 
	 * 参数 是否必须 说明 ToUserName 是 接收方帐号（收到的OpenID） FromUserName 是 开发者微信号 CreateTime
	 * 是 消息创建时间 （整型） MsgType 是 video MediaId 是 通过上传多媒体文件，得到的id Title 否 视频消息的标题
	 * Description 否 视频消息的描述
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.mp.bean.MpBaseRespMsg#getMsgType()
	 */
	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return MpMsgType.Video.toString();
	}

	private Data Video;

	public Data getVideo() {
		return Video;
	}

	public void setVideo(Data video) {
		Video = video;
	}

	public static class Data {
		private String MediaId;
		private String Title;
		private String Description;

		public String getMediaId() {
			return MediaId;
		}

		public void setMediaId(String mediaId) {
			MediaId = mediaId;
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

	}

}
