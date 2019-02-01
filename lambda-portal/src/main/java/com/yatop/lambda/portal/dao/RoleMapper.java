package com.yatop.lambda.portal.dao;

import com.yatop.lambda.portal.common.config.MyMapper;
import com.yatop.lambda.portal.model.Role;
import com.yatop.lambda.portal.api.request.RoleMenuReq;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
	List<RoleMenuReq> findById(Long roleId);

	List<Long> findMenuIdsByRole(Long roleId);
}