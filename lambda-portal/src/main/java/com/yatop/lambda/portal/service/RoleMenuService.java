package com.yatop.lambda.portal.service;


import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.model.RoleMenu;

import java.util.List;

public interface RoleMenuService extends IService<RoleMenu> {

	void deleteRoleMenusByRoleId(List<String> roleIds);

	void deleteRoleMenusByMenuId(List<String> menuIds);
}
