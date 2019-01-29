package com.yatop.lambda.portal.dao;

import com.yatop.lambda.portal.common.config.MyMapper;
import com.yatop.lambda.portal.model.User;
import com.yatop.lambda.portal.model.UserWithMenu;
import com.yatop.lambda.portal.model.UserWithRole;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);

	List<User> findUserByConditions(User user);

	List<UserWithRole> findUserWithRole(Long userId);

	List<UserWithMenu> findUserWithMenu(Long userId);
	
	User findUserProfile(User user);


}