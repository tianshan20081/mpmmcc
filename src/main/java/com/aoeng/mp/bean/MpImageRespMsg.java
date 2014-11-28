/**
 * 
 */
package com.aoeng.mp.bean;

import com.aoeng.mp.enm.MpMsgType;

/**
 * 回复图片消息
 * 
 * @author sczhang 2014年11月28日 上午11:53:05
 * @Email {zhangshch0131@126.com}
 */
public class MpImageRespMsg extends MpBaseRespMsg {
	/**
	 * 回复图片消息
	 * 
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[image]]></MsgType>
	 * <Image> <MediaId><![CDATA[media_id]]></MediaId> </Image> </xml>
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.mp.bean.MpBaseRespMsg#getMsgType()
	 */
	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return MpMsgType.Image.toString();
	}

	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public MpImageRespMsg() {
		super();
	}

	/**
	 * @param inputMsg
	 */
	public MpImageRespMsg(MpInputMsg inputMsg) {
		// TODO Auto-generated constructor stub
		super(inputMsg);
	}

}
