package com.yatop.lambda.portal.service;


import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.model.UserRole;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(List<String> roleIds);

	void deleteUserRolesByUserId(List<String> userIds);
}
