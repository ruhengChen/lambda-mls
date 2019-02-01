package com.yatop.lambda.portal.api.response;

import com.yatop.lambda.portal.model.User;

import java.io.Serializable;
import java.util.List;

public class UserRoleMenuResp implements Serializable {
	
	private static final long serialVersionUID = -5680235862276163462L;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private List<Long> roleIds;

	private List<Long> menuIds;

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public List<Long> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}
}