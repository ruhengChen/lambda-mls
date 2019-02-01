package com.yatop.lambda.portal.api.request;

import com.yatop.lambda.portal.model.Role;

import java.io.Serializable;
import java.util.List;

public class RoleMenuReq implements Serializable {

	private static final long serialVersionUID = 2013847071068967187L;

	private List<Long> menuIds;

	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Long> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}

}
