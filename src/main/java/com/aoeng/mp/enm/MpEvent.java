/**
 * 
 */
package com.aoeng.mp.enm;

/**
 * @author sczhang 2014年12月11日 下午8:08:18
 * @Email {zhangshch0131@126.com}
 */
public enum MpEvent {
	SUBSCRIBE("subscribe"), UNSUBSCRIBE("unsubscribe");

	private String eventType = "";

	MpEvent(String eventType) {
		this.eventType = eventType;
	}

	public String getValue() {
		return this.eventType;
	}

}
