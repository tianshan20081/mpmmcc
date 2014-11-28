/**
 * 
 */
package com.aoeng.mp.bean;

import com.aoeng.mp.enm.MpMsgType;

/**
 * 回复音乐消息
 * 
 * @author sczhang 2014年11月28日 下午12:22:02
 * @Email {zhangshch0131@126.com}
 */
public class MpMusicRespMsg extends MpBaseRespMsg {
	/**
	 * @param inputMsg
	 */
	public MpMusicRespMsg(MpInputMsg inputMsg) {
		// TODO Auto-generated constructor stub
		super(inputMsg);
	}

	/**
	 * 
	 */
	public MpMusicRespMsg() {
		// TODO Auto-generated constructor stub
		super();
	}

	/*
	 * 
	 * 
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[music]]></MsgType>
	 * <Music> <Title><![CDATA[TITLE]]></Title>
	 * <Description><![CDATA[DESCRIPTION]]></Description>
	 * <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
	 * <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
	 * <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId> </Music> </xml>
	 * 
	 * 参数 是否必须 说明 ToUserName 是 接收方帐号（收到的OpenID） FromUserName 是 开发者微信号 CreateTime
	 * 是 消息创建时间 （整型） MsgType 是 music Title 否 音乐标题 Description 否 音乐描述 MusicURL 否
	 * 音乐链接 HQMusicUrl 否 高质量音乐链接，WIFI环境优先使用该链接播放音乐 ThumbMediaId 是
	 * 缩略图的媒体id，通过上传多媒体文件，得到的id
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.mp.bean.MpBaseRespMsg#getMsgType()
	 */
	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return MpMsgType.Music.toString();
	}

	private Data Music;

	public Data getMusic() {
		return Music;
	}

	public void setMusic(Data music) {
		Music = music;
	}

	public static class Data {
		private String Title;
		private String Description;
		private String MusicUrl;
		private String HQMusicUrl;
//		private String ThumbMediaId;

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

		public String getMusicUrl() {
			return MusicUrl;
		}

		public void setMusicUrl(String musicUrl) {
			MusicUrl = musicUrl;
		}

		public String getHQMusicUrl() {
			return HQMusicUrl;
		}

		public void setHQMusicUrl(String hQMusicUrl) {
			HQMusicUrl = hQMusicUrl;
		}

		// public String getThumbMediaId() {
		// return ThumbMediaId;
		// }
		//
		// public void setThumbMediaId(String thumbMediaId) {
		// ThumbMediaId = thumbMediaId;
		// }

	}

}
