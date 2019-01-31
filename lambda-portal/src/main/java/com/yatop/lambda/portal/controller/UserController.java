package com.yatop.lambda.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.JsonResponse;
import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.util.MD5Utils;
import com.yatop.lambda.portal.model.User;
import com.yatop.lambda.portal.model.UserWithRoleAndMenu;
import com.yatop.lambda.portal.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    @RequestMapping("user")
    @RequiresPermissions("user:list")
    public String index(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "system/user/user";
    }

    @RequestMapping("user/checkUserName")
    @ResponseBody
    public JsonResponse checkUserName(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
//        if (StringUtils.isNotBlank(oldusername) && username.equalsIgnoreCase(oldusername)) {
//            return true;
//        }
        User result = this.userService.findByName(username);
        return JsonResponse.build(result == null);
    }


    @Log("查询用户信息")
    @RequestMapping("user/queryUserInfo")
    @ResponseBody
    @RequiresPermissions("user:query")
    public JsonResponse getUser(@RequestBody JSONObject jsonObject) {
        try {
            Long userId = jsonObject.getLong("userId");
            User user = this.userService.findById(userId);
            return JsonResponse.build(user);
        } catch (Exception e) {
            log.error("获取用户失败", e);
            return JsonResponse.build(new Exception("获取用户失败，请联系网站管理员！"));
        }
    }

    @Log("获取用户列表信息")
    @RequestMapping("user/queryUsers")
    @RequiresPermissions("user:list")
    @ResponseBody
    public JsonResponse userList(QueryRequest request, User user) {
        return super.selectByPageNumSize(request, () -> this.userService.findUserWithDept(user, request));
    }


    @Log("新增用户")
    @RequiresPermissions("user:add")
    @RequestMapping("user/createUser")
    @ResponseBody
    public JsonResponse addUser(@RequestBody UserWithRoleAndMenu userWithRoleAndMenu) {
        try {
//            if (ON.equalsIgnoreCase(user.getStatus()))
//                user.setStatus(User.STATUS_VALID);
//            else
//                user.setStatus(User.STATUS_LOCK);

            List<Long> roleIds = userWithRoleAndMenu.getRoleIds();
            List<Long> menuIds = userWithRoleAndMenu.getMenuIds();

            this.userService.addUser(userWithRoleAndMenu, roleIds, menuIds);
            User resUser = this.userService.findByName(userWithRoleAndMenu.getUsername());
            return JsonResponse.build(resUser);
        } catch (Exception e) {
            log.error("新增用户失败", e);
            return JsonResponse.build(new Exception("新增用户失败，请联系网站管理员！"));
        }
    }

    @Log("修改用户状态")
    @RequiresPermissions("user:status")
    @RequestMapping("user/updateUserStatus")
    @ResponseBody
    public JsonResponse updateUserStatus(@RequestBody JSONObject jsonObject) {
        try {
            Long userId =  jsonObject.getLong("userId");
            String username =  jsonObject.getString("username");
            String newStatus =  jsonObject.getString("newStatus");
            User user = new User();
            user.setUserId(userId);
            user.setUsername(username);
            user.setStatus(newStatus);
            this.userService.updateUserStatus(user);
            User resUser = this.userService.findById(user.getUserId());
            return JsonResponse.build(resUser);
        } catch (Exception e) {
            log.error("修改用户角色状态失败", e);
            return JsonResponse.build(new Exception("修改用户失败，请联系网站管理员！"));
        }
    }


    @Log("修改用户角色权限")
    @RequiresPermissions("user:permissions")
    @RequestMapping("user/updateUserPermission")
    @ResponseBody
    public JsonResponse updateUserPermission(@RequestBody UserWithRoleAndMenu userWithRoleAndMenu) {
        try {
            List<Long> roleIds = userWithRoleAndMenu.getRoleIds();
            List<Long> menuIds = userWithRoleAndMenu.getMenuIds();

            this.userService.updateUser(userWithRoleAndMenu, roleIds, menuIds);
            User resUser = this.userService.findById(userWithRoleAndMenu.getUserId());
            return JsonResponse.build(resUser);
        } catch (Exception e) {
            log.error("修改用户角色权限失败", e);
            return JsonResponse.build(new Exception("修改用户失败，请联系网站管理员！"));
        }
    }

    @Log("修改用户信息")
    @RequiresPermissions("user:update")
    @RequestMapping("user/updateUserInfo")
    @ResponseBody
    public JsonResponse updateUserInfo(@RequestBody User user) {
        try {
            this.userService.updateUserProfile(user);
            User resUser = this.userService.findById(user.getUserId());
            return JsonResponse.build(resUser);
        } catch (Exception e) {
            log.error("修改用户信息失败", e);
            return JsonResponse.build(new Exception("修改用户失败，请联系网站管理员！"));
        }
    }

    @Log("修改用户密码")
    @RequiresPermissions("user:update")
    @RequestMapping("user/updateUserPassword")
    @ResponseBody
    public JsonResponse updateUserPassword(@RequestBody JSONObject jsonObject) {
        try {
            Long userId =  jsonObject.getLong("userId");
            String username =  jsonObject.getString("username");
            String newPassword =  jsonObject.getString("newPassword");

            String password = MD5Utils.encrypt(username.toLowerCase(), newPassword);
            User user = new User();
            user.setPassword(password);
            user.setUserId(userId);

            this.userService.updateUserPassword(user);
            User resUser = this.userService.findById(user.getUserId());
            return JsonResponse.build(resUser);
        } catch (Exception e) {
            log.error("修改用户信息失败", e);
            return JsonResponse.build(new Exception("修改用户失败，请联系网站管理员！"));
        }
    }


    @Log("删除用户")
    @RequiresPermissions("user:delete")
    @RequestMapping("user/deleteUsers")
    @ResponseBody
    public JsonResponse deleteUsers(@RequestBody JSONObject jsonObject) {
        try {
            List<String> userIds = JSONObject.parseArray(jsonObject.getJSONArray("userIds").toJSONString(), String.class);

            this.userService.deleteUsers(userIds);

            Map<String, Integer> resMap = new HashMap<String, Integer>(){{
                put("rowCounts", userIds.size());
            }};
            return JsonResponse.build(resMap);

        } catch (Exception e) {
            log.error("删除用户失败", e);
            return JsonResponse.build(new Exception("删除用户失败，请联系网站管理员！"));
        }
    }

    @RequestMapping("user/updatePassword")
    @ResponseBody
    public JsonResponse updatePassword(@RequestBody JSONObject jsonObject) {
        try {
            String newPassword =  jsonObject.getString("newPassword");
            String oldPassword =  jsonObject.getString("oldPassword");

            User user = getCurrentUser();
            String encrypt = MD5Utils.encrypt(user.getUsername().toLowerCase(), oldPassword);
            if(user.getPassword().equals(encrypt)){
                this.userService.updatePassword(newPassword);
                return JsonResponse.build("");
            } else{
                return JsonResponse.build(new Exception("旧密码错误！"));
            }

        } catch (Exception e) {
            log.error("修改密码失败", e);
            return JsonResponse.build(new Exception("更改密码失败，请联系网站管理员！"));
        }
    }


    @RequestMapping("user/getUserProfile")
    @ResponseBody
    public JsonResponse getUserProfile(@RequestBody JSONObject jsonObject) {
        try {
            Long userId = jsonObject.getLong("userId");
            User user = new User();
            user.setUserId(userId);
            return JsonResponse.build(this.userService.findUserProfile(user));
        } catch (Exception e) {
            log.error("获取用户信息失败", e);
            return JsonResponse.build(new Exception("获取用户信息失败，请联系网站管理员！"));
        }
    }

    @RequestMapping("user/updateUserProfile")
    @ResponseBody
    public JsonResponse updateUserProfile(@RequestBody User user) {
        try {
            User currentUser = getCurrentUser();
            if(! currentUser.getUserId().equals(user.getUserId())){
                return JsonResponse.build(new Exception("只能修改当前用户信息"));
            }
            this.userService.updateUserProfile(user);
            return JsonResponse.build(null);
        } catch (Exception e) {
            log.error("更新用户信息失败", e);
            return JsonResponse.build(new Exception("更新用户信息失败，请联系网站管理员！"));
        }
    }

//    @RequestMapping("user/changeAvatar")
//    @ResponseBody
//    public JsonResponse changeAvatar(@RequestBody JSONObject jsonObject) {
//        try {
//            String imgName = jsonObject.getString("imgName");
//            String[] img = imgName.split("/");
//            String realImgName = img[img.length - 1];
//            User user = getCurrentUser();
//            user.setAvatar(realImgName);
//            this.userService.updateNotNull(user);
//            return JsonResponse.build("更新头像成功！");
//        } catch (Exception e) {
//            log.error("更换头像失败", e);
//            return JsonResponse.build(new Exception("更新头像失败，请联系网站管理员！"));
//        }
//    }

//    @RequestMapping("user/checkPassword")
//    @ResponseBody
//    public boolean checkPassword(@RequestBody JSONObject jsonObject) {
//        String password =  jsonObject.getString("password");
//        User user = getCurrentUser();
//        String encrypt = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
//        return user.getPassword().equals(encrypt);
//    }
//
//

// 预留
//    @RequestMapping("user/queryUsersByConditions")
//    @RequiresPermissions("user:list")
//    @ResponseBody
//    public Map<String, Object> queryUsersByConditions(QueryRequest request,@RequestBody User user) {
//        return super.selectByPageNumSize(request, () -> this.userService.findUserByConditions(user, request));
//    }

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
}
