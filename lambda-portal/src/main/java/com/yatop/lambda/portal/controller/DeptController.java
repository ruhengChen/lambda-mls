package com.yatop.lambda.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.domain.JsonResponse;
import com.yatop.lambda.portal.common.domain.Tree;
import com.yatop.lambda.portal.model.Dept;
import com.yatop.lambda.portal.service.DeptService;
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
public class DeptController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeptService deptService;

    @Log("获取部门信息")
    @RequestMapping("dept")
    @RequiresPermissions("dept:list")
    public String index() {
        return "system/dept/dept";
    }

    @RequestMapping("dept/deptTree")
    @ResponseBody
    public JsonResponse getDeptTree() {
        try {
            Tree<Dept> tree = this.deptService.getDeptTree();
            return JsonResponse.build(tree);
//            return ResponseBo.ok(tree);
        } catch (Exception e) {
            log.error("获取部门树失败", e);
            return JsonResponse.build(new Exception("获取部门树失败！"));
//            return ResponseBo.error("获取部门树失败！");
        }
    }

    @RequestMapping("dept/queryDeptInfo")
    @ResponseBody
    public JsonResponse getDept(@RequestBody JSONObject jsonObject) {
        try {
            Long deptId = jsonObject.getLong("deptId");
            Dept dept = this.deptService.findById(deptId);
            return JsonResponse.build(dept);
        } catch (Exception e) {
            log.error("获取部门信息失败", e);
            return JsonResponse.build(new Exception("获取部门信息失败，请联系网站管理员！"));
        }
    }

    @RequestMapping("dept/queryDepts")
    @RequiresPermissions("dept:list")
    @ResponseBody
    public JsonResponse deptList(@RequestBody Dept dept) {
        try {
            return JsonResponse.build(this.deptService.findAllDepts(dept));
        } catch (Exception e) {
            log.error("获取部门列表失败", e);
            return JsonResponse.build(new Exception("获取部门列表失败"));
        }
    }
//
//    @RequestMapping("dept/excel")
//    @ResponseBody
//    public ResponseBo deptExcel(@RequestBody Dept dept) {
//        try {
//            List<Dept> list = this.deptService.findAllDepts(dept);
//            return FileUtil.createExcelByPOIKit("部门表", list, Dept.class);
//        } catch (Exception e) {
//            log.error("导出部门信息Excel失败", e);
//            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("dept/csv")
//    @ResponseBody
//    public ResponseBo deptCsv(@RequestBody Dept dept) {
//        try {
//            List<Dept> list = this.deptService.findAllDepts(dept);
//            return FileUtil.createCsv("部门表", list, Dept.class);
//        } catch (Exception e) {
//            log.error("获取部门信息Csv失败", e);
//            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
//        }
//    }

    @RequestMapping("dept/checkDeptName")
    @ResponseBody
    public JsonResponse checkDeptName(@RequestBody JSONObject jsonObject) {
//        if (StringUtils.isNotBlank(oldDeptName) && deptName.equalsIgnoreCase(oldDeptName)) {
//            return true;
//        }
        String deptName = jsonObject.getString("deptName");
        Dept result = this.deptService.findByName(deptName);
        return JsonResponse.build(result == null);
    }

    @Log("新增部门 ")
    @RequiresPermissions("dept:add")
    @RequestMapping("dept/addDept")
    @ResponseBody
    public JsonResponse addRole(@RequestBody Dept dept) {
        try {
            this.deptService.addDept(dept);
            Dept dept1 = this.deptService.findById(dept.getDeptId());
            return JsonResponse.build(dept1);
        } catch (Exception e) {
            log.error("新增部门失败", e);
            return JsonResponse.build(new Exception("新增部门失败，请联系网站管理员！"));
        }
    }

    @Log("删除部门")
    @RequiresPermissions("dept:delete")
    @RequestMapping("dept/deleteDepts")
    @ResponseBody
    public JsonResponse deleteDepts(@RequestBody JSONObject jsonObject) {
        try {
            List<String> deptIds = JSONObject.parseArray(jsonObject.getJSONArray("deptIds").toJSONString(), String.class);
            this.deptService.deleteDepts(deptIds);
            Map<String, Integer> resMap = new HashMap<String, Integer>(){{
                put("rowCounts", deptIds.size());
            }};
            return JsonResponse.build(resMap);
        } catch (Exception e) {
            log.error("删除部门失败", e);
            return JsonResponse.build(new Exception("删除部门失败，请联系网站管理员！"));
        }
    }

    @Log("修改部门 ")
    @RequiresPermissions("dept:update")
    @RequestMapping("dept/updateDept")
    @ResponseBody
    public JsonResponse updateRole(@RequestBody Dept dept) {
        try {
            this.deptService.updateDept(dept);
            Dept dept1 = this.deptService.findById(dept.getDeptId());
            return JsonResponse.build(dept1);
        } catch (Exception e) {
            log.error("修改部门失败", e);
            return JsonResponse.build(new Exception("修改部门失败，请联系网站管理员！"));
        }
    }
}
