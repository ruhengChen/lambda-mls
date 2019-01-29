package com.yatop.lambda.portal.service.impl;

import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.common.util.MD5Utils;
import com.yatop.lambda.portal.dao.UserMapper;
import com.yatop.lambda.portal.dao.UserMenuMapper;
import com.yatop.lambda.portal.dao.UserRoleMapper;
import com.yatop.lambda.portal.model.*;
import com.yatop.lambda.portal.service.UserMenuService;
import com.yatop.lambda.portal.service.UserRoleService;
import com.yatop.lambda.portal.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends BaseService<User> implements UserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserMenuMapper userMenuMapper;

    @Autowired
    private UserMenuService userMenuService;

    @Override
    public User findByName(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        List<User> list = this.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<User> findUserWithDept(User user, QueryRequest request) {
        try {
            return this.userMapper.findUserWithDept(user);
        } catch (Exception e) {
            log.error("error", e);
            return new ArrayList<>();
        }
    }

    @Override
    public List<User> findUserByConditions(User user, QueryRequest request){
        try {
            return this.userMapper.findUserByConditions(user);
        } catch (Exception e) {
            log.error("error", e);
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public void registUser(User user) {
//        user.setCrateTime(new Date());
//        user.setTheme(User.DEFAULT_THEME);
//        user.setAvatar(User.DEFAULT_AVATAR);
//        user.setSsex(User.SEX_UNKNOW);
//        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
//        this.save(user);
//        UserRole ur = new UserRole();
//        ur.setUserId(user.getUserId());
//        ur.setRoleId(3L);
//        this.userRoleMapper.insert(ur);
    }

    @Override
    @Transactional
    public void updateTheme(String theme, String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("username=", userName);
        User user = new User();
        user.setTheme(theme);
        this.userMapper.updateByExampleSelective(user, example);
    }

    @Override
    @Transactional
    public void addUser(User user, Long[] roles, Long[] menuIds) {
        user.setCrateTime(new Date());
        user.setTheme(User.DEFAULT_THEME);
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        this.save(user);
        setUserRoles(user, roles);
        setUserMenus(user, menuIds);
    }

    private void setUserRoles(User user, Long[] roles) {
        Arrays.stream(roles).forEach(roleId -> {
            UserRole ur = new UserRole();
            ur.setUserId(user.getUserId());
            ur.setRoleId(roleId);
            this.userRoleMapper.insert(ur);
        });
    }

    private void setUserMenus(User user, Long[] menuIds) {
        Arrays.stream(menuIds).forEach(menuId -> {
            UserMenu um = BeanUtils.instantiateClass(UserMenu.class);
            um.setUserId(user.getUserId());
            um.setMenuId(menuId);
            this.userMenuMapper.insertSelective(um);
        });
    }

    @Override
    @Transactional
    public void updateUser(User user, Long[] roles, Long[] menuIds) {
//        user.setPassword(null);
        user.setUsername(null);
        user.setModifyTime(new Date());
        this.updateNotNull(user);
        Example example = new Example(UserRole.class);
        example.createCriteria().andCondition("user_id=", user.getUserId());
        this.userRoleMapper.deleteByExample(example);
        example = new Example(UserMenu.class);
        example.createCriteria().andCondition("user_id=", user.getUserId());
        this.userMenuMapper.deleteByExample(example);
        setUserRoles(user, roles);
        setUserMenus(user, menuIds);
    }

    @Override
    @Transactional
    public void deleteUsers(String userIds) {
        List<String> list = Arrays.asList(userIds.split(","));
        this.batchDelete(list, "userId", User.class);

        this.userRoleService.deleteUserRolesByUserId(userIds);
        this.userMenuService.deleteUserMenusByUserId(userIds);
    }

    @Override
    @Transactional
    public void updateLoginTime(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        User user = new User();
        user.setLastLoginTime(new Date());
        this.userMapper.updateByExampleSelective(user, example);
    }

    @Override
    @Transactional
    public void updatePassword(String password) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Example example = new Example(User.class);
        example.createCriteria().andCondition("username=", user.getUsername());
        String newPassword = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
        user.setPassword(newPassword);
        this.userMapper.updateByExampleSelective(user, example);
    }

    @Override
    public UserWithRoleAndMenu findById(Long userId) {
        List<UserWithRole> roleLists = this.userMapper.findUserWithRole(userId);
        List<Long> roleList = roleLists.stream().map(UserWithRole::getRoleId).collect(Collectors.toList());
        if (roleLists.isEmpty())
            return null;

        UserWithRoleAndMenu userWithRoleAndMenu = BeanUtils.instantiateClass(UserWithRoleAndMenu.class);
        BeanUtils.copyProperties(roleLists.get(0), userWithRoleAndMenu);
        userWithRoleAndMenu.setRoleIds(roleList);

        List<UserWithMenu> menuLists = this.userMapper.findUserWithMenu(userId);
        List<Long> menuList = menuLists.stream().map(UserWithMenu::getMenuId).collect(Collectors.toList());
        if(!menuLists.isEmpty()){
            userWithRoleAndMenu.setMenuId(menuLists.get(0).getMenuId());
            userWithRoleAndMenu.setMenuIds(menuList);
        }

        return userWithRoleAndMenu;
    }

    @Override
    public User findUserProfile(User user) {
        return this.userMapper.findUserProfile(user);
    }

    @Override
    @Transactional
    public void updateUserProfile(User user) {
        user.setUsername(null);
        user.setPassword(null);
        if (user.getDeptId() == null)
            user.setDeptId(0L);
        this.updateNotNull(user);
    }

}
