package com.aoeng.mp.utils;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.PushPayload.Builder;
import cn.jpush.api.push.model.audience.Audience;

public class JPushUtils {

	public static void push(String jsonString) {
		// TODO Auto-generated method stub
		String masterSecret = "ad446e80e5633285346420d6";
		String appKey = "d0b7a62a78cdeeeab6ddc8ad";
		JPushClient client = new JPushClient(masterSecret, appKey);

		try {
			Builder builder = PushPayload.newBuilder();
			builder.setAudience(Audience.alias("admin"));
			builder.setPlatform(Platform.android());
			cn.jpush.api.push.model.Message.Builder msgBuilder = Message.newBuilder();
			msgBuilder.setMsgContent(jsonString);
			Message message = msgBuilder.build();
			builder.setMessage(message);
			PushPayload payload = builder.build();
			PushResult sendPush = client.sendPush(payload);
			System.out.println(sendPush);
			// PushResult result = client.sendAndroidMessageWithAlias("title",
			// jsonString, "admin");
			// System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
