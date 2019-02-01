package com.yatop.lambda.portal.api.request;

import com.yatop.lambda.portal.model.User;

import java.util.List;

public class UserRoleMenuReq {
	
	private static final long serialVersionUID = -5680235862276163462L;

	private User user;


	private Long roleId;
	
	private List<Long> roleIds;

	private Long menuId;

	private List<Long> menuIds;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public List<Long> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}