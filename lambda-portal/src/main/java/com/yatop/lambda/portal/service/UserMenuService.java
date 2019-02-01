package com.yatop.lambda.portal.service;

import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.model.UserMenu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserMenuService extends BaseService<UserMenu> {

	@Transactional
	public void deleteUserMenusByRoleId(List<String> menuIds) {
		this.batchDelete(menuIds, "menuId", UserMenu.class);
	}

	@Transactional
	public void deleteUserMenusByUserId(List<String> userIds) {
		this.batchDelete(userIds, "userId", UserMenu.class);
	}

}
