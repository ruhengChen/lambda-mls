package com.yatop.lambda.portal.service;


import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.model.UserMenu;

import java.util.List;

public interface UserMenuService extends IService<UserMenu> {

	void deleteUserMenusByRoleId(List<String> menuIds);

	void deleteUserMenusByUserId(List<String> userIds);
}
