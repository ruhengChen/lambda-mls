package com.yatop.lambda.portal.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sys_manage_user_menu")
public class UserMenu implements Serializable {


    private static final long serialVersionUID = 71342434535870010L;
    /**
     * 用户id
     */
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 菜单id
     */
    @Column(name = "MENU_ID")
    private Long menuId;

    /**
     * 获取用户id
     *
     * @return USER_ID - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取菜单id
     *
     * @return MENU_ID - 菜单id
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单id
     *
     * @param menuId 菜单id
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}