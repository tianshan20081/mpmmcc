/**
 * 
 */
package com.aoeng.mp.bean;

import java.util.List;

import com.aoeng.mp.enm.MpMsgType;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 回复图文消息
 * 
 * @author sczhang 2014年11月28日 下午1:04:49
 * @Email {zhangshch0131@126.com}
 */
public class MpNewRespMsg extends MpBaseRespMsg {

	public MpNewRespMsg() {
		super();
	}

	/**
	 * @param inputMsg
	 */
	public MpNewRespMsg(MpInputMsg inputMsg) {
		// TODO Auto-generated constructor stub
		
		super(inputMsg);
	}

	/*
	 * 
	 * 
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[news]]></MsgType>
	 * <ArticleCount>2</ArticleCount> <Articles> <item>
	 * <Title><![CDATA[title1]]></Title>
	 * <Description><![CDATA[description1]]></Description>
	 * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
	 * <item> <Title><![CDATA[title]]></Title>
	 * <Description><![CDATA[description]]></Description>
	 * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
	 * </Articles> </xml>
	 * 
	 * 参数 是否必须 说明 ToUserName 是 接收方帐号（收到的OpenID） FromUserName 是 开发者微信号 CreateTime
	 * 是 消息创建时间 （整型） MsgType 是 news ArticleCount 是 图文消息个数，限制为10条以内 Articles 是
	 * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应 Title 否 图文消息标题 Description 否
	 * 图文消息描述 PicUrl 否 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200 Url 否
	 * 点击图文消息跳转链接
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.mp.bean.MpBaseRespMsg#getMsgType()
	 */
	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return MpMsgType.NEWS.toString();
	}

	private int ArticleCount;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	private List<Data> Articles;

	public List<Data> getArticles() {
		return Articles;
	}

	public void setArticles(List<Data> articles) {
		Articles = articles;
	}

	public static class Data {
		private String Title;
		private String Description;
		private String PicUrl;
		private String Url;

		public Data() {
			super();
		}

		public Data(String title, String description, String picUrl, String url) {
			super();
			Title = title;
			Description = description;
			PicUrl = picUrl;
			Url = url;
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

		public String getPicUrl() {
			return PicUrl;
		}

		public void setPicUrl(String picUrl) {
			PicUrl = picUrl;
		}

		public String getUrl() {
			return Url;
		}

		public void setUrl(String url) {
			Url = url;
		}

	}

}
