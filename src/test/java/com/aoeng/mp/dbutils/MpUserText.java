/**
 * 
 */
package com.aoeng.mp.dbutils;

import java.sql.Timestamp;

import org.junit.Test;

import com.aoeng.mp.bean.MpUser;
import com.aoeng.mp.service.MpUserService;
import com.aoeng.mp.service.impl.MpUserServiceImpl;

/**
 * @author sczhang 2014年12月11日 下午9:16:11
 * @Email {zhangshch0131@126.com}
 */
public class MpUserText {

	@Test
	public void insertUser() {

		MpUserService userService = new MpUserServiceImpl();
		 userService.addUser(new MpUser("zhangsan"));
		MpUser user = userService.findUserByName("zhangsan");
		if (null != user) {
			System.out.println(user.toString());
		}

	}

}
