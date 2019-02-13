package com.yatop.lambda.portal.service;

import com.yatop.lambda.portal.api.response.UserRoleMenuResp;
import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.common.util.MD5Utils;
import com.yatop.lambda.portal.dao.UserMapper;
import com.yatop.lambda.portal.dao.UserMenuMapper;
import com.yatop.lambda.portal.dao.UserRoleMapper;
import com.yatop.lambda.portal.model.User;
import com.yatop.lambda.portal.model.UserMenu;
import com.yatop.lambda.portal.model.UserRole;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("userService")
@CacheConfig(cacheNames = "UserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserService extends BaseService<User> {

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

    public User findByName(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        List<User> list = this.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
    public List<User> findUserWithDept(User user, QueryRequest request) {
        try {
            return this.userMapper.findUserWithDept(user);
        } catch (Exception e) {
            log.error("error", e);
            return new ArrayList<>();
        }
    }

    public List<User> findUserByConditions(User user, QueryRequest request){
        try {
            return this.userMapper.findUserByConditions(user);
        } catch (Exception e) {
            log.error("error", e);
            return new ArrayList<>();
        }
    }

    @CacheEvict(key = "#p0", allEntries = true)
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

    @Transactional
    public void updateTheme(String theme, String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("username=", userName);
        User user = new User();
        user.setTheme(theme);
        this.userMapper.updateByExampleSelective(user, example);
    }

    @CacheEvict(allEntries = true)
    @Transactional
    public void addUser(User user, List<Long> roles, List<Long> menuIds) {
        user.setCrateTime(new Date());
        user.setTheme(User.DEFAULT_THEME);
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        this.save(user);
        setUserRoles(user, roles);
        setUserMenus(user, menuIds);
    }

    private void setUserRoles(User user, List<Long> roles) {
        roles.forEach(roleId -> {
            UserRole ur = new UserRole();
            ur.setUserId(user.getUserId());
            ur.setRoleId(roleId);
            this.userRoleMapper.insert(ur);
        });
    }

    private void setUserMenus(User user, List<Long> menuIds) {
        menuIds.forEach(menuId -> {
            UserMenu um = BeanUtils.instantiateClass(UserMenu.class);
            um.setUserId(user.getUserId());
            um.setMenuId(menuId);
            this.userMenuMapper.insertSelective(um);
        });
    }

    @CacheEvict(key = "#p0", allEntries = true)
    @Transactional
    public void updateUser(User user, List<Long> roles, List<Long> menuIds) {
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

    @CacheEvict(key = "#p0", allEntries = true)
    @Transactional
    public void deleteUsers(List<String> userIds) {

        this.batchDelete(userIds, "userId", User.class);

        this.userRoleService.deleteUserRolesByUserId(userIds);
        this.userMenuService.deleteUserMenusByUserId(userIds);
    }

    @Transactional
    public void updateLoginTime(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        User user = new User();
        user.setLastLoginTime(new Date());
        this.userMapper.updateByExampleSelective(user, example);
    }

    @Transactional
    public void updatePassword(String password) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Example example = new Example(User.class);
        example.createCriteria().andCondition("username=", user.getUsername());
        String newPassword = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
        user.setPassword(newPassword);
        this.userMapper.updateByExampleSelective(user, example);
    }

    public UserRoleMenuResp findById(User user) {
        List<Long> roleList = this.userMapper.findRoleIdsByUser(user.getUserId());
        UserRoleMenuResp userRoleMenuResp = new UserRoleMenuResp();
        userRoleMenuResp.setRoleIds(roleList);
        List<Long> menuList = this.userMapper.findMenuIdsByUser(user.getUserId());
        userRoleMenuResp.setMenuIds(menuList);
        User user1 = this.userMapper.findUserProfile(user);
        userRoleMenuResp.setUser(user1);
        return userRoleMenuResp;
    }

    public User findUserProfile(User user) {
        return this.userMapper.findUserProfile(user);
    }

    @Transactional
    public void updateUserProfile(User user) {
        user.setUsername(null);
        user.setPassword(null);
        user.setStatus(null);
        if (user.getDeptId() == null)
            user.setDeptId(0L);
        this.updateNotNull(user);
    }

    @Transactional
    public void updateUserPassword(User user){
        this.updateNotNull(user);
    }

    @Transactional
    public void updateUserStatus(User user){
        this.updateNotNull(user);
    }

}
