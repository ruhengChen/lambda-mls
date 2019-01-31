package com.yatop.lambda.portal.service.impl;

import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.model.RoleMenu;
import com.yatop.lambda.portal.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends BaseService<RoleMenu> implements RoleMenuService {

	@Override
	@Transactional
	public void deleteRoleMenusByRoleId(List<String> roleIds) {
		this.batchDelete(roleIds, "roleId", RoleMenu.class);
	}

	@Override
	@Transactional
	public void deleteRoleMenusByMenuId(List<String> menuIds) {
		this.batchDelete(menuIds, "menuId", RoleMenu.class);
	}

}
