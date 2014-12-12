/**
 * 
 */
package com.aoeng.mp.enm;

/**
 * @author sczhang 2014年12月11日 下午9:36:42
 * @Email {zhangshch0131@126.com}
 */
public enum MpTables {

	TB_MP_USER("mp_user");

	public String mpTableName = "";

	/**
	 * 
	 */
	private MpTables(String mpTableName) {
		// TODO Auto-generated constructor stub
		this.mpTableName = mpTableName;
	}

	public String getValue() {
		return this.mpTableName;
	}

}
