package com.yatop.lambda.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.JsonResponse;
import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.model.Dict;
import com.yatop.lambda.portal.service.DictService;
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
public class DictController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DictService dictService;


    @RequestMapping("dict/queryDicts")
    @RequiresPermissions("sys:dict:list")
    @ResponseBody
    public JsonResponse queryDicts(QueryRequest request, Dict dict) {
        return super.selectByPageNumSize(request, () -> this.dictService.findAllDicts(dict, request));
    }

    @RequestMapping("dict/queryDictInfo")
    @ResponseBody
    public JsonResponse queryDictInfo(@RequestBody JSONObject jsonObject) {
        try {
            Long dictId = jsonObject.getLong("dictId");
            Dict dict = this.dictService.findById(dictId);
            return JsonResponse.build(dict);
        } catch (Exception e) {
            log.error("获取字典信息失败", e);
            return JsonResponse.build(new Exception("获取字典信息失败，请联系网站管理员！"));
        }
    }

    @Log("新增字典 ")
    @RequiresPermissions("sys:dict:add")
    @RequestMapping("dict/addDict")
    @ResponseBody
    public JsonResponse addDict(@RequestBody Dict dict) {
        try {
            this.dictService.addDict(dict);
            Dict resDict = this.dictService.findById(dict.getDictId());
            return JsonResponse.build(resDict);
        } catch (Exception e) {
            log.error("新增字典失败", e);
            return JsonResponse.build(new Exception("新增字典失败，请联系网站管理员！"));
        }
    }

    @Log("删除字典")
    @RequiresPermissions("sys:dict:delete")
    @RequestMapping("dict/deleteDicts")
    @ResponseBody
    public JsonResponse deleteDicts(@RequestBody JSONObject jsonObject) {
        try {
            List<String> dictIds = JSONObject.parseArray(jsonObject.getJSONArray("dictIds").toJSONString(), String.class);
            int deleteCount = this.dictService.deleteDicts(dictIds);
            Map<String, Integer> resMap = new HashMap<String, Integer>(){{
                put("rowCounts", deleteCount);
            }};
            return JsonResponse.build(resMap);
        } catch (Exception e) {
            log.error("删除字典失败", e);
            return JsonResponse.build(new Exception("删除字典失败，请联系网站管理员！"));
        }
    }

    @Log("修改字典 ")
    @RequiresPermissions("sys:dict:update")
    @RequestMapping("dict/updateDict")
    @ResponseBody
    public JsonResponse updateDict(@RequestBody Dict dict) {
        try {
            this.dictService.updateDict(dict);
            Dict resDict = this.dictService.findById(dict.getDictId());
            return JsonResponse.build(resDict);
        } catch (Exception e) {
            log.error("修改字典失败", e);
            return JsonResponse.build(new Exception("修改字典失败，请联系网站管理员！"));
        }
    }
}
//
//    @RequestMapping("dict/excel")
//    @ResponseBody
//    public ResponseBo dictExcel(@RequestBody Dict dict) {
//        try {
//            List<Dict> list = this.dictService.findAllDicts(dict, null);
//            return FileUtil.createExcelByPOIKit("字典表", list, Dict.class);
//        } catch (Exception e) {
//            log.error("导出字典信息Excel失败", e);
//            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("dict/csv")
//    @ResponseBody
//    public ResponseBo dictCsv(@RequestBody Dict dict) {
//        try {
//            List<Dict> list = this.dictService.findAllDicts(dict, null);
//            return FileUtil.createCsv("字典表", list, Dict.class);
//        } catch (Exception e) {
//            log.error("导出字典信息Csv失败", e);
//            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
//        }
//    }
