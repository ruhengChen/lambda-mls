package com.yatop.lambda.portal.dao;


import com.yatop.lambda.portal.common.config.MyMapper;
import com.yatop.lambda.portal.model.Role;
import com.yatop.lambda.portal.model.RoleWithMenu;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
	List<RoleWithMenu> findById(Long roleId);
}