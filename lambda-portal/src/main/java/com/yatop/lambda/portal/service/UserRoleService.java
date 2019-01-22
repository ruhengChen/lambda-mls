package com.yatop.lambda.portal.service;


import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.model.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
