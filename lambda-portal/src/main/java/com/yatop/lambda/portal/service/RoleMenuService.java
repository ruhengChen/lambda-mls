package com.yatop.lambda.portal.service;


import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.model.RoleMenu;

public interface RoleMenuService extends IService<RoleMenu> {

	void deleteRoleMenusByRoleId(String roleIds);

	void deleteRoleMenusByMenuId(String menuIds);
}
