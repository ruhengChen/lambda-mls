package com.yatop.lambda.portal.service.impl;

import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.model.UserRole;
import com.yatop.lambda.portal.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userRoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {

	@Override
	@Transactional
	public void deleteUserRolesByRoleId(List<String> roleIds) {
		this.batchDelete(roleIds, "roleId", UserRole.class);
	}

	@Override
	@Transactional
	public void deleteUserRolesByUserId(List<String> userIds) {
		this.batchDelete(userIds, "userId", UserRole.class);
	}

}
