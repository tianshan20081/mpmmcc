/**
 * 
 */
package com.aoeng.mp.utils;

/**
 * @author sczhang 2014年12月9日 下午12:11:27
 * @Email {zhangshch0131@126.com}
 */
public class MpMsgCryptUtils {
	static WXBizMsgCrypt crypt;
	private static String appId = "wx5d94a7bcdbe6b9aa";
	// 与接口配置信息中的Token要一致
	private static String token = "wc6PIO9OVbuP8WQ66Ew7O4";
	static String xmlFormat = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";

	private static String encodingAesKey = "3YU3xU7Rq3ZW4MDJwc6PIO9OVbuP8WQ66Ew7O40u1JB";
	static {
		try {
			crypt = new WXBizMsgCrypt(token, encodingAesKey, appId);
		} catch (AesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getMsgDecode(String msgSignature, String timeStamp, String nonce, String postData) {
		try {
			crypt = new WXBizMsgCrypt(token, encodingAesKey, appId);
			return crypt.decryptMsg(msgSignature, timeStamp, nonce, postData);
		} catch (AesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getMsgEncrypt(String replyMsg, String timeStamp, String nonce) {
		try {
			return crypt.encryptMsg(replyMsg, timeStamp, nonce);
		} catch (AesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
