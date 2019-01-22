package com.yatop.lambda.portal.service;

import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.model.Role;
import com.yatop.lambda.portal.model.RoleWithMenu;

import java.util.List;

public interface RoleService extends IService<Role> {

	List<Role> findUserRole(String userName);

	List<Role> findAllRole(Role role);
	
	RoleWithMenu findRoleWithMenus(Long roleId);

	Role findByName(String roleName);

	void addRole(Role role, Long[] menuIds);
	
	void updateRole(Role role, Long[] menuIds);

	void deleteRoles(String roleIds);
}
