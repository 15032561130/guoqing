package org.guoqing.bigdata.antun.service;

import java.util.List;

import org.guoqing.bigdata.antun.domain.User;
import org.guoqing.bigdata.antun.web.model.UserAdd;
import org.guoqing.bigdata.antun.web.model.UserUpdate;

public interface UserService {

	List<User> findAll();

	int addUser(UserAdd userAdd);

	User getUser(Long id);

	int updateUser(Long id, UserUpdate userUpdate);

	int deleteUser(Long id);

	User findByPhone(String phone);

}
