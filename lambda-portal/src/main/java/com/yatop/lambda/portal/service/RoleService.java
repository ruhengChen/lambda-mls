package com.yatop.lambda.portal.service;

import com.yatop.lambda.portal.api.response.RoleMenuResp;
import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.dao.RoleMapper;
import com.yatop.lambda.portal.dao.RoleMenuMapper;
import com.yatop.lambda.portal.model.Role;
import com.yatop.lambda.portal.model.RoleMenu;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("roleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleService extends BaseService<Role> {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleMenuService roleMenuService;

    public List<Role> findUserRole(String userName) {
        return this.roleMapper.findUserRole(userName);
    }

    public List<Role> findAllRole(Role role) {
        try {
            Example example = new Example(Role.class);
            if (StringUtils.isNotBlank(role.getRoleName())) {
                example.createCriteria().andCondition("role_name=", role.getRoleName());
            }
            example.setOrderByClause("create_time");
            return this.selectByExample(example);
        } catch (Exception e) {
            log.error("获取角色信息失败", e);
            return new ArrayList<>();
        }
    }

    public Role findByName(String roleName) {
        Example example = new Example(Role.class);
        example.createCriteria().andCondition("lower(role_name)=", roleName.toLowerCase());
        List<Role> list = this.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Transactional
    public void addRole(Role role, List<Long> menuIds) {
        role.setCreateTime(new Date());
        this.save(role);
        setRoleMenus(role, menuIds);
    }

    private void setRoleMenus(Role role, List<Long> menuIds) {
        menuIds.forEach(menuId -> {
            RoleMenu rm = new RoleMenu();
            rm.setMenuId(menuId);
            rm.setRoleId(role.getRoleId());
            this.roleMenuMapper.insert(rm);
        });
    }

    @Transactional
    public void deleteRoles(List<String> roleIds) {
        this.batchDelete(roleIds, "roleId", Role.class);

        this.roleMenuService.deleteRoleMenusByRoleId(roleIds);
        this.userRoleService.deleteUserRolesByRoleId(roleIds);

    }

    public RoleMenuResp findRoleWithMenus(Role role) {
        List<Long> menuList = this.roleMapper.findMenuIdsByRole(role.getRoleId());
        RoleMenuResp roleMenuResp = new RoleMenuResp();
        roleMenuResp.setMenuIds(menuList);
        roleMenuResp.setRole(role);
        return roleMenuResp;
    }

    @Transactional
    public void updateRole(Role role, List<Long> menuIds) {
        role.setModifyTime(new Date());
        this.updateNotNull(role);
        Example example = new Example(RoleMenu.class);
        example.createCriteria().andCondition("role_id=", role.getRoleId());
        this.roleMenuMapper.deleteByExample(example);
        setRoleMenus(role, menuIds);
    }

}
