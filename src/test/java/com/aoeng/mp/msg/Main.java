/**
 * 
 */
package com.aoeng.mp.msg;

import com.aoeng.mp.utils.MpMsgCryptUtils;

/**
 * @author sczhang 2014年12月9日 下午1:34:44
 * @Email {zhangshch0131@126.com}
 */
public class Main {

	public static void main(String[] args) {
		String postData = "<xml><ToUserName><![CDATA[gh_a970be45cbbd]]></ToUserName><Encrypt><![CDATA[DQ/MvpFgTqyhKIXe7myQf/1dtS+cVa9/42sF2CDUTK4Jb9i2kqDnZwdjVGsPhGl+7smavEguLwVW5pF+caC//V82DXb4pHC3fprJi/qSgTfnr7UPMmmkmfGo7ZV6+kJeI7x456ZXe3CvumCqlmz3Cyx/jDmObwiGaU85Qq/Tu0Z9F8boxreRoj6dBfc1aBNN9iU5DOledRBa8KrzpE8KKExMUwptPH8mw6Kj7SWQJc0+t8UvltKL9A4DtmbCwcm6lOgnnaBND1oGM7YEatzojoTIodYZIXXomCnHhNuSzNYw6S1SebWzyB1uUyxQRUAFEAHTcEkypZcXCGhdQS3cszk4LzBkF6TGzhL40IjgJpLDuzAuB4XbilNgqgJwV6eejREfBMqluH/z2zN9MNDY07wklbkPoz2lE6kJeKrCPps=]]></Encrypt></xml>";

		String msgSignature = "4cf3d796b59b09714fe7a53dbc24897d5f7e8da6";
		String timeStamp = "1418111243";
		String nonce = "1277495855";
		MpMsgCryptUtils.getMsgDecode(msgSignature, timeStamp, nonce, postData);

	}

}
