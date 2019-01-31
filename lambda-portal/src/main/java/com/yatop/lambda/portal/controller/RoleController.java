package com.yatop.lambda.portal.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.JsonResponse;
import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.domain.ResponseBo;
import com.yatop.lambda.portal.common.util.FileUtil;
import com.yatop.lambda.portal.model.Role;
import com.yatop.lambda.portal.model.RoleWithMenu;
import com.yatop.lambda.portal.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

    @RequestMapping("role/queryRoles")
    @RequiresPermissions("role:list")
    @ResponseBody
    public JsonResponse roleList(QueryRequest request, @RequestBody Role role) {
        return super.selectByPageNumSize(request, () -> this.roleService.findAllRole(role));
    }
//
//    @RequestMapping("role/excel")
//    @ResponseBody
//    public ResponseBo roleExcel(@RequestBody Role role) {
//        try {
//            List<Role> list = this.roleService.findAllRole(role);
//            return FileUtil.createExcelByPOIKit("角色表", list, Role.class);
//        } catch (Exception e) {
//            log.error("导出角色信息Excel失败", e);
//            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("role/csv")
//    @ResponseBody
//    public ResponseBo roleCsv(@RequestBody Role role) {
//        try {
//            List<Role> list = this.roleService.findAllRole(role);
//            return FileUtil.createCsv("角色表", list, Role.class);
//        } catch (Exception e) {
//            log.error("导出角色信息Csv失败", e);
//            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
//        }
//    }

    @RequestMapping("role/queryRoleInfo")
    @ResponseBody
    public JsonResponse getRole(@RequestBody JSONObject jsonObject) {
        try {
            Long roleId = jsonObject.getLong("roleId");
            Role role = this.roleService.findRoleWithMenus(roleId);
            return JsonResponse.build(role);
        } catch (Exception e) {
            log.error("获取角色信息失败", e);
            return JsonResponse.build(new Exception("获取角色信息失败，请联系网站管理员！"));
        }
    }

    @RequestMapping("role/checkRoleName")
    @ResponseBody
    public JsonResponse checkRoleName(@RequestBody JSONObject jsonObject) {
//        if (StringUtils.isNotBlank(oldRoleName) && roleName.equalsIgnoreCase(oldRoleName)) {
//            return true;
//        }
        String roleName = jsonObject.getString("roleName");
        Role result = this.roleService.findByName(roleName);
        return JsonResponse.build(result == null);
    }

    @Log("新增角色")
    @RequiresPermissions("role:add")
    @RequestMapping("role/addRole")
    @ResponseBody
    public JsonResponse addRole(@RequestBody RoleWithMenu roleWithMenu) {
        try {
            List<Long> menuId = roleWithMenu.getMenuIds();
            this.roleService.addRole(roleWithMenu, menuId);
            Role resRole = this.roleService.findByName(roleWithMenu.getRoleName());
            return JsonResponse.build(resRole);
        } catch (Exception e) {
            log.error("新增角色失败", e);
            return JsonResponse.build(new Exception("新增角色失败，请联系网站管理员！"));
        }
    }

    @Log("删除角色")
    @RequiresPermissions("role:delete")
    @RequestMapping("role/deleteRole")
    @ResponseBody
    public JsonResponse deleteRoles(@RequestBody JSONObject jsonObject) {
        try {
            List<String> roleIds = JSONObject.parseArray(jsonObject.getJSONArray("roleIds").toJSONString(), String.class);

            this.roleService.deleteRoles(roleIds);

            Map<String, Integer> resMap = new HashMap<String, Integer>(){{
                put("rowCounts", roleIds.size());
            }};
            return JsonResponse.build(resMap);
        } catch (Exception e) {
            log.error("删除角色失败", e);
            return JsonResponse.build(new Exception("删除角色失败，请联系网站管理员！"));
        }
    }

    @Log("修改角色")
    @RequiresPermissions("role:update")
    @RequestMapping("role/updateRole")
    @ResponseBody
    public JsonResponse updateRole(@RequestBody JSONObject jsonObject) {
        try {
            Long roleId =  jsonObject.getLong("roleId");
            Role role = new Role();
            role.setRoleId(roleId);
            List<Long>  menuIds =  JSONObject.parseArray(jsonObject.getJSONArray("menuIds").toJSONString(), Long.class);

            this.roleService.updateRole(role, menuIds);
            Role resRole = this.roleService.findByName(role.getRoleName());
            return JsonResponse.build(resRole);
        } catch (Exception e) {
            log.error("修改角色失败", e);
            return JsonResponse.build(new Exception("修改角色失败，请联系网站管理员！"));
        }
    }
}
