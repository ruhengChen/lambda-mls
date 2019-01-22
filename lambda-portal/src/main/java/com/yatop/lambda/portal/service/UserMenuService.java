package com.yatop.lambda.portal.service;


import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.model.UserMenu;

public interface UserMenuService extends IService<UserMenu> {

	void deleteUserMenusByRoleId(String menuIds);

	void deleteUserMenusByUserId(String userIds);
}
