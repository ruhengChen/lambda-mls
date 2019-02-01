package com.yatop.lambda.portal.api.request;

import com.yatop.lambda.portal.model.User;

import java.io.Serializable;
import java.util.List;

public class UserMenuReq extends User implements Serializable {
	
	private static final long serialVersionUID = -5680235862276163462L;

	private List<Long> menuIds;

	public List<Long> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}
}