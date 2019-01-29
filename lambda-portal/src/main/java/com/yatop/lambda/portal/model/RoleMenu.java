package com.yatop.lambda.portal.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sys_manage_role_menu")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 7780820231235870010L;
    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private Long roleId;

    /**
     * 菜单/按钮ID
     */
    @Column(name = "MENU_ID")
    private Long menuId;

    /**
     * 获取角色ID
     *
     * @return ROLE_ID - 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单/按钮ID
     *
     * @return MENU_ID - 菜单/按钮ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单/按钮ID
     *
     * @param menuId 菜单/按钮ID
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}