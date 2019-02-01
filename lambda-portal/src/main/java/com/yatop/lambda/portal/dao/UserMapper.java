package com.yatop.lambda.portal.dao;

import com.yatop.lambda.portal.common.config.MyMapper;
import com.yatop.lambda.portal.model.User;
import com.yatop.lambda.portal.api.request.UserMenuReq;
import com.yatop.lambda.portal.api.request.UserRoleReq;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);

	List<User> findUserByConditions(User user);

	List<UserRoleReq> findUserWithRole(Long userId);

	List<UserMenuReq> findUserWithMenu(Long userId);
	
	User findUserProfile(User user);

	List<Long> findMenuIdsByUser(Long userId);

	List<Long> findRoleIdsByUser(Long userId);

}