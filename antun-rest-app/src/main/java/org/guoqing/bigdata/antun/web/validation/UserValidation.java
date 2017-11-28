package org.guoqing.bigdata.antun.web.validation;

import org.apache.commons.lang3.StringUtils;
import org.guoqing.bigdata.antun.domain.User;
import org.guoqing.bigdata.antun.service.UserService;
import org.guoqing.bigdata.antun.web.model.UserAdd;
import org.guoqing.bigdata.antun.web.model.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {
	@Autowired
	private UserService userService;

	private String name_pattern = "[\\u4e00-\\u9fa5]{2,10}";

	/**
	 * 新增验证
	 * 
	 * @param userAdd
	 * @return
	 */
	public String addUserValidation(UserAdd userAdd) {

		if (StringUtils.isBlank(userAdd.getName()))

			return "姓名为空";

		if (!userAdd.getName().matches(name_pattern))
			return "姓名不符合要求";

		User user = userService.findByPhone(userAdd.getPhone());

		if (user != null)

			return "手机号重复";

		return null;
	}

	/**
	 * 修改验证
	 * 
	 * @param userUpdate
	 * @return
	 */
	public String updateUserValidation(UserUpdate userUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

}
