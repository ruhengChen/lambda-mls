package com.yatop.lambda.portal.model;

import java.util.List;

public class UserWithMenu extends User{
	
	private static final long serialVersionUID = -5680235862276163462L;

	private Long menuId;

	private List<Long> menuIds;

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
}