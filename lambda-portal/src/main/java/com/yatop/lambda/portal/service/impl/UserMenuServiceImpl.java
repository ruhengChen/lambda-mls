package com.yatop.lambda.portal.service.impl;

import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.model.UserMenu;
import com.yatop.lambda.portal.service.UserMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserMenuServiceImpl extends BaseService<UserMenu> implements UserMenuService {

	@Override
	@Transactional
	public void deleteUserMenusByRoleId(List<String> menuIds) {
		this.batchDelete(menuIds, "menuId", UserMenu.class);
	}

	@Override
	@Transactional
	public void deleteUserMenusByUserId(List<String> userIds) {
		this.batchDelete(userIds, "userId", UserMenu.class);
	}

}
