package org.guoqing.bigdata.antun.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.guoqing.bigdata.antun.domain.User;
import org.guoqing.bigdata.antun.service.UserService;
import org.guoqing.bigdata.antun.web.model.UserAdd;
import org.guoqing.bigdata.antun.web.model.UserUpdate;
import org.guoqing.bigdata.antun.web.response.BaseResponse;
import org.guoqing.bigdata.antun.web.validation.UserValidation;

@RestController
@RequestMapping("/users")
public class UserController extends BaseResponse {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidation userValidation;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public BaseResponse findAll() {

		List<User> findAll = userService.findAll();

		return successResponse("查询成功").data(findAll);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public BaseResponse addUser(UserAdd userAdd) {

		String msg = userValidation.addUserValidation(userAdd);

		if (msg != null) {

			return errorResponse(msg);
		}

		int addUser = userService.addUser(userAdd);

		return successResponse("入库成功，数量：" + addUser);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public BaseResponse getUser(@PathVariable Long id) {
		User user = userService.getUser(id);
		return successResponse("查询成功").data(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public BaseResponse updateUser(@PathVariable Long id, UserUpdate userUpdate) {

		String msg = userValidation.updateUserValidation(userUpdate);

		if (msg != null)

			return errorResponse(msg);

		int updateUser = userService.updateUser(id, userUpdate);

		return successResponse("修改成功，数量：" + updateUser);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public BaseResponse deleteUser(@PathVariable Long id) {

		int deleteUser = userService.deleteUser(id);

		return successResponse("删除成功，数量：" + deleteUser);
	}
}
