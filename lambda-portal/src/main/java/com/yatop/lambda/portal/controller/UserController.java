//package com.yatop.lambda.portal.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.yatop.lambda.portal.common.annotation.Log;
//import com.yatop.lambda.portal.common.controller.BaseController;
//import com.yatop.lambda.portal.common.domain.QueryRequest;
//import com.yatop.lambda.portal.common.domain.ResponseBo;
//import com.yatop.lambda.portal.common.util.FileUtil;
//import com.yatop.lambda.portal.common.util.MD5Utils;
//import com.yatop.lambda.portal.model.User;
//import com.yatop.lambda.portal.service.UserService;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class UserController extends BaseController {
//
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private UserService userService;
//
//    private static final String ON = "on";
//
//
//    @RequestMapping("user")
//    @RequiresPermissions("user:list")
//    public String index(Model model) {
//        User user = super.getCurrentUser();
//        model.addAttribute("user", user);
//        return "system/user/user";
//    }
//
//    @RequestMapping("user/checkUserName")
//    @ResponseBody
//    @RequiresPermissions("user:checkUserName")
//    public ResponseBo checkUserName(@RequestBody User user) {
////        if (StringUtils.isNotBlank(oldusername) && username.equalsIgnoreCase(oldusername)) {
////            return true;
////        }
//        User result = this.userService.findByName(user.getUsername());
//        return ResponseBo.ok(result == null, "");
//    }
////    @RequestMapping("user/checkUserName")
////    @ResponseBody
////    public boolean checkUserName(String username, String oldusername) {
////        if (StringUtils.isNotBlank(oldusername) && username.equalsIgnoreCase(oldusername)) {
////            return true;
////        }
////        User result = this.userService.findByName(username);
////        return result == null;
////    }
//
//    @RequestMapping("user/queryUserInfo")
//    @ResponseBody
//    @RequiresPermissions("user:query")
//    public ResponseBo getUser(@RequestBody JSONObject jsonObject) {
//        try {
//            Long userId  = jsonObject.getLong("userId");
//            User user = this.userService.findById(userId);
//            return ResponseBo.ok(user, "获取用户成功");
//        } catch (Exception e) {
//            log.error("获取用户失败", e);
//            return ResponseBo.error("获取用户失败，请联系网站管理员！");
//        }
//    }
//
//    @Log("获取用户信息")
//    @RequestMapping("user/queryUsers")
//    @RequiresPermissions("user:list")
//    @ResponseBody
//    public Map<String, Object> userList(QueryRequest request, @RequestBody User user) {
//        return super.selectByPageNumSize(request, () -> this.userService.findUserWithDept(user, request));
//    }
//
//
//    @RequestMapping("user/queryUsersByConditions")
//    @RequiresPermissions("user:list")
//    @ResponseBody
//    public Map<String, Object> queryUsersByConditions(QueryRequest request,@RequestBody User user) {
//        return super.selectByPageNumSize(request, () -> this.userService.findUserByConditions(user, request));
//    }
//
//    @RequestMapping("user/excel")
//    @ResponseBody
//    public ResponseBo userExcel(@RequestBody User user) {
//        try {
//            List<User> list = this.userService.findUserWithDept(user, null);
//            return FileUtil.createExcelByPOIKit("用户表", list, User.class);
//        } catch (Exception e) {
//            log.error("导出用户信息Excel失败", e);
//            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
//        }
//    }
//
//
//    @RequestMapping("user/csv")
//    @ResponseBody
//    public ResponseBo userCsv(@RequestBody User user) {
//        try {
//            List<User> list = this.userService.findUserWithDept(user, null);
//            return FileUtil.createCsv("用户表", list, User.class);
//        } catch (Exception e) {
//            log.error("导出用户信息Csv失败", e);
//            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("user/regist")
//    @ResponseBody
//    public ResponseBo regist(@RequestBody User user) {
//        try {
//            User result = this.userService.findByName(user.getUsername());
//            if (result != null) {
//                return ResponseBo.warn("该用户名已被使用！");
//            }
//            this.userService.registUser(user);
//            return ResponseBo.ok();
//        } catch (Exception e) {
//            log.error("注册失败", e);
//            return ResponseBo.error("注册失败，请联系网站管理员！");
//        }
//    }
//
//    @Log("更换主题")
//    @RequestMapping("user/theme")
//    @ResponseBody
//    public ResponseBo updateTheme(@RequestBody User user) {
//        try {
//            this.userService.updateTheme(user.getTheme(), user.getUsername());
//            return ResponseBo.ok();
//        } catch (Exception e) {
//            log.error("修改主题失败", e);
//            return ResponseBo.error();
//        }
//    }
//
//    @Log("新增用户")
//    @RequiresPermissions("user:add")
//    @RequestMapping("user/createUser")
//    @ResponseBody
//    public ResponseBo addUser(@RequestBody User user, @RequestBody JSONObject jsonObject) {
//        try {
////            if (ON.equalsIgnoreCase(user.getStatus()))
////                user.setStatus(User.STATUS_VALID);
////            else
////                user.setStatus(User.STATUS_LOCK);
//            Long[] roles = (Long[])jsonObject.getJSONArray("roles").toArray();
//            Long[] menuId = (Long[])jsonObject.getJSONArray("menuId").toArray();
//
//            this.userService.addUser(user, roles, menuId);
//            User resUser = this.userService.findByName(user.getUsername());
//            return ResponseBo.ok(resUser, "新增用户成功");
//        } catch (Exception e) {
//            log.error("新增用户失败", e);
//            return ResponseBo.error("新增用户失败，请联系网站管理员！");
//        }
//    }
//
//    @Log("修改用户状态")
//    @RequiresPermissions("user:status")
//    @RequestMapping("user/updateUserStatus")
//    @ResponseBody
//    public ResponseBo updateUserStatus(@RequestBody User user) {
//        try {
//            this.userService.updateUserProfile(user);
//            User resUser = this.userService.findById(user.getUserId());
//            return ResponseBo.ok(resUser, "修改用户角色状态成功");
//        } catch (Exception e) {
//            log.error("修改用户角色状态失败", e);
//            return ResponseBo.error("修改用户失败，请联系网站管理员！");
//        }
//    }
//
//
//    @Log("修改用户角色权限")
//    @RequiresPermissions("user:permissions")
//    @RequestMapping("user/updateUserPermission")
//    @ResponseBody
//    public ResponseBo updateUserPermission(@RequestBody User user, @RequestBody JSONObject jsonObject) {
//        try {
//            Long[] roles = (Long[])jsonObject.getJSONArray("roles").toArray();
//            Long[] menuId = (Long[])jsonObject.getJSONArray("menuId").toArray();
//            this.userService.updateUser(user, roles, menuId);
//            User resUser = this.userService.findById(user.getUserId());
//            return ResponseBo.ok(resUser, "修改用户角色权限成功");
//        } catch (Exception e) {
//            log.error("修改用户角色权限失败", e);
//            return ResponseBo.error("修改用户失败，请联系网站管理员！");
//        }
//    }
//
//    @Log("修改用户信息")
//    @RequiresPermissions("user:update")
//    @RequestMapping("user/updateUserInfo")
//    @ResponseBody
//    public ResponseBo updateUserInfo(@RequestBody User user) {
//        try {
//            String password;
//            if(user.getPassword() == null) {
//                User existUser = this.userService.findByName(user.getUsername());
//                password = existUser.getPassword();
//            }else {
//                password = user.getPassword();
//            }
//            String passwordRel = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
//            user.setPassword(passwordRel);
//            this.userService.updateUserProfile(user);
//            User resUser = this.userService.findById(user.getUserId());
//            return ResponseBo.ok(resUser, "修改用户信息成功");
//        } catch (Exception e) {
//            log.error("修改用户信息失败", e);
//            return ResponseBo.error("修改用户失败，请联系网站管理员！");
//        }
//    }
//
//
//
//    @Log("删除用户")
//    @RequiresPermissions("user:delete")
//    @RequestMapping("user/deleteUsers")
//    @ResponseBody
//    public ResponseBo deleteUsers(@RequestBody JSONObject jsonObject) {
//        try {
//            String userIds = jsonObject.getString("userIds");
//            this.userService.deleteUsers(userIds);
//
//            return ResponseBo.ok(null, "删除用户成功！");
//
//        } catch (Exception e) {
//            log.error("删除用户失败", e);
//            return ResponseBo.error("删除用户失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("user/checkPassword")
//    @ResponseBody
//    public boolean checkPassword(@RequestBody JSONObject jsonObject) {
//        String password =  jsonObject.getString("password");
//        User user = getCurrentUser();
//        String encrypt = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
//        return user.getPassword().equals(encrypt);
//    }
//
//    @RequestMapping("user/updatePassword")
//    @ResponseBody
//    public ResponseBo updatePassword(@RequestBody JSONObject jsonObject) {
//        try {
//            String newPassword =  jsonObject.getString("newPassword");
//            this.userService.updatePassword(newPassword);
//            return ResponseBo.ok("更改密码成功！");
//        } catch (Exception e) {
//            log.error("修改密码失败", e);
//            return ResponseBo.error("更改密码失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("user/profile")
//    public String profileIndex(@RequestBody Model model) {
//        User user = super.getCurrentUser();
//        user = this.userService.findUserProfile(user);
//        String ssex = user.getSsex();
//        if (User.SEX_MALE.equals(ssex)) {
//            user.setSsex("性别：男");
//        } else if (User.SEX_FEMALE.equals(ssex)) {
//            user.setSsex("性别：女");
//        } else {
//            user.setSsex("性别：保密");
//        }
//        model.addAttribute("user", user);
//        return "system/user/profile";
//    }
//
//    @RequestMapping("user/getUserProfile")
//    @ResponseBody
//    public ResponseBo getUserProfile(@RequestBody JSONObject jsonObject) {
//        try {
//            Long userId = jsonObject.getLong("userId");
//            User user = new User();
//            user.setUserId(userId);
//            return ResponseBo.ok(this.userService.findUserProfile(user));
//        } catch (Exception e) {
//            log.error("获取用户信息失败", e);
//            return ResponseBo.error("获取用户信息失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("user/updateUserProfile")
//    @ResponseBody
//    public ResponseBo updateUserProfile(@RequestBody User user) {
//        try {
//            this.userService.updateUserProfile(user);
//            return ResponseBo.ok("更新个人信息成功！");
//        } catch (Exception e) {
//            log.error("更新用户信息失败", e);
//            return ResponseBo.error("更新用户信息失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("user/changeAvatar")
//    @ResponseBody
//    public ResponseBo changeAvatar(@RequestBody JSONObject jsonObject) {
//        try {
//            String imgName = jsonObject.getString("imgName");
//            String[] img = imgName.split("/");
//            String realImgName = img[img.length - 1];
//            User user = getCurrentUser();
//            user.setAvatar(realImgName);
//            this.userService.updateNotNull(user);
//            return ResponseBo.ok("更新头像成功！");
//        } catch (Exception e) {
//            log.error("更换头像失败", e);
//            return ResponseBo.error("更新头像失败，请联系网站管理员！");
//        }
//    }
//}
