package com.yatop.lambda.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.domain.ResponseBo;
import com.yatop.lambda.portal.common.domain.Tree;
import com.yatop.lambda.portal.common.util.FileUtil;
import com.yatop.lambda.portal.model.Dept;
import com.yatop.lambda.portal.service.DeptService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseBo getDeptTree() {
        try {
            Tree<Dept> tree = this.deptService.getDeptTree();
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            log.error("获取部门树失败", e);
            return ResponseBo.error("获取部门树失败！");
        }
    }

    @RequestMapping("dept/queryDeptInfo")
    @ResponseBody
    public ResponseBo getDept(@RequestBody JSONObject jsonObject) {
        try {
            Long deptId = jsonObject.getLong("deptId");
            Dept dept = this.deptService.findById(deptId);
            return ResponseBo.ok(dept);
        } catch (Exception e) {
            log.error("获取部门信息失败", e);
            return ResponseBo.error("获取部门信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("dept/queryDepts")
    @RequiresPermissions("dept:list")
    @ResponseBody
    public List<Dept> deptList(@RequestBody Dept dept) {
        try {
            return this.deptService.findAllDepts(dept);
        } catch (Exception e) {
            log.error("获取部门列表失败", e);
            return new ArrayList<>();
        }
    }

    @RequestMapping("dept/excel")
    @ResponseBody
    public ResponseBo deptExcel(@RequestBody Dept dept) {
        try {
            List<Dept> list = this.deptService.findAllDepts(dept);
            return FileUtil.createExcelByPOIKit("部门表", list, Dept.class);
        } catch (Exception e) {
            log.error("导出部门信息Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("dept/csv")
    @ResponseBody
    public ResponseBo deptCsv(@RequestBody Dept dept) {
        try {
            List<Dept> list = this.deptService.findAllDepts(dept);
            return FileUtil.createCsv("部门表", list, Dept.class);
        } catch (Exception e) {
            log.error("获取部门信息Csv失败", e);
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @RequestMapping("dept/checkDeptName")
    @ResponseBody
    public ResponseBo checkDeptName(@RequestBody JSONObject jsonObject) {
//        if (StringUtils.isNotBlank(oldDeptName) && deptName.equalsIgnoreCase(oldDeptName)) {
//            return true;
//        }
        String deptName = jsonObject.getString("deptName");
        Dept result = this.deptService.findByName(deptName);
        return ResponseBo.ok(result == null);
    }

    @Log("新增部门 ")
    @RequiresPermissions("dept:add")
    @RequestMapping("dept/addDept")
    @ResponseBody
    public ResponseBo addRole(@RequestBody Dept dept) {
        try {
            this.deptService.addDept(dept);
            Dept dept1 = this.deptService.findById(dept.getDeptId());
            return ResponseBo.ok(dept1);
        } catch (Exception e) {
            log.error("新增部门失败", e);
            return ResponseBo.error("新增部门失败，请联系网站管理员！");
        }
    }

    @Log("删除部门")
    @RequiresPermissions("dept:delete")
    @RequestMapping("dept/deleteDepts")
    @ResponseBody
    public ResponseBo deleteDepts(@RequestBody JSONObject jsonObject) {
        try {
            String deptIds = jsonObject.getString("deptIds");
            this.deptService.deleteDepts(deptIds);
            return ResponseBo.ok("删除部门成功！");
        } catch (Exception e) {
            log.error("删除部门失败", e);
            return ResponseBo.error("删除部门失败，请联系网站管理员！");
        }
    }

    @Log("修改部门 ")
    @RequiresPermissions("dept:update")
    @RequestMapping("dept/updateDept")
    @ResponseBody
    public ResponseBo updateRole(@RequestBody Dept dept) {
        try {
            this.deptService.updateDept(dept);
            Dept dept1 = this.deptService.findById(dept.getDeptId());
            return ResponseBo.ok(dept1);
        } catch (Exception e) {
            log.error("修改部门失败", e);
            return ResponseBo.error("修改部门失败，请联系网站管理员！");
        }
    }
}
