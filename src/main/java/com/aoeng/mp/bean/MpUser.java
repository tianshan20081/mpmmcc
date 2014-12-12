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

	/**
	 * 用户 id 自增长
	 */
	private int id;
	/**
	 * user WeiChart name
	 */
	private String userName;
	/**
	 * 关注的时间
	 */
	private Date eventDate;
	/**
	 * 最后一次发送信息时间
	 */
	private Date lastAccessDate;

	public MpUser() {
		super();
	}

	public MpUser(String userName) {
		super();
		this.userName = userName;
		eventDate = new Date();
		lastAccessDate = new Date();
	}

	public MpUser(int id, String userName, Date eventDate, Date lastAccessDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.eventDate = eventDate;
		this.lastAccessDate = lastAccessDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Date getLastAccessDate() {
		return lastAccessDate;
	}

	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	@Override
	public String toString() {
		return "MpUser [id=" + id + ", userName=" + userName + ", eventDate=" + eventDate + ", lastAccessDate=" + lastAccessDate + "]";
	}

}
