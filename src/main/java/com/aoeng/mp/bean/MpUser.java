/**
 * 
 */
package com.aoeng.mp.bean;

import java.util.Date;

/**
 * @author sczhang 2014年11月29日 下午6:08:49
 * @Email {zhangshch0131@126.com}
 */
public class MpUser {

	private int id;
	private String name;
	/**
	 * 关注的时间
	 */
	private Date eventDate;
	/**
	 * 最后一次发送信息时间
	 */
	private Date lastAccessDate;

}
