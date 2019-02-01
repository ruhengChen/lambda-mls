package com.yatop.lambda.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.JsonResponse;
import com.yatop.lambda.portal.common.domain.Tree;
import com.yatop.lambda.portal.model.Menu;
import com.yatop.lambda.portal.service.MenuService;
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
public class MenuController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuService menuService;

    @RequestMapping("menu/queryMenus")
    @ResponseBody
    public JsonResponse getMenu(@RequestBody JSONObject jsonObject) {
        try {
            String userName = jsonObject.getString("userName");
            List<Menu> menus = this.menuService.findUserMenus(userName);
            return JsonResponse.build(menus);
        } catch (Exception e) {
            logger.error("获取菜单失败", e);
            return JsonResponse.build(new Exception("获取菜单失败！"));
        }
    }

    @RequestMapping("menu/getMenu")
    @ResponseBody
    public JsonResponse getMenuInfo(@RequestBody JSONObject jsonObject) {
        try {
            Long menuId = jsonObject.getLong("menuId");
            Menu menu = this.menuService.findById(menuId);
            return JsonResponse.build(menu);
        } catch (Exception e) {
            logger.error("获取菜单信息失败", e);
            return JsonResponse.build(new Exception("获取信息失败，请联系网站管理员！"));
        }
    }

    @RequestMapping("menu/menuButtonTree")
    @ResponseBody
    public JsonResponse getMenuButtonTree() {
        try {
            Tree<Menu> tree = this.menuService.getMenuButtonTree();
            return JsonResponse.build(tree);
        } catch (Exception e) {
            logger.error("获取菜单列表失败", e);
            return JsonResponse.build(new Exception("获取菜单列表失败！"));
        }
    }

    @RequestMapping("menu/menuTree")
    @ResponseBody
    public JsonResponse getMenuTree() {
        try {
            Tree<Menu> tree = this.menuService.getMenuTree();
            return JsonResponse.build(tree);
        } catch (Exception e) {
            logger.error("获取菜单树失败", e);
            return JsonResponse.build(new Exception("获取菜单树失败！"));
        }
    }

    @RequestMapping("menu/getUserMenu")
    @ResponseBody
    public JsonResponse getUserMenu(@RequestBody JSONObject jsonObject) {
        try {
            String userName = jsonObject.getString("userName");
            Tree<Menu> tree = this.menuService.getUserMenu(userName);
            return JsonResponse.build(tree);
        } catch (Exception e) {
            logger.error("获取用户菜单失败", e);
            return JsonResponse.build(new Exception("获取用户菜单失败！"));
        }
    }

    @RequestMapping("menu/list")
    @RequiresPermissions("sys:menu:list")
    @ResponseBody
    public JsonResponse menuList(@RequestBody Menu menu) {
        try {
            return JsonResponse.build(this.menuService.findAllMenus(menu));
        } catch (Exception e) {
            logger.error("获取菜单集合失败", e);
            return JsonResponse.build(new Exception("获取菜单集合失败"));
        }
    }
//
//    @RequestMapping("menu/excel")
//    @ResponseBody
//    public ResponseBo menuExcel(@RequestBody Menu menu) {
//        try {
//            List<Menu> list = this.menuService.findAllMenus(menu);
//            return FileUtil.createExcelByPOIKit("菜单表", list, Menu.class);
//        } catch (Exception e) {
//            logger.error("带出菜单列表Excel失败", e);
//            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("menu/csv")
//    @ResponseBody
//    public ResponseBo menuCsv(@RequestBody Menu menu) {
//        try {
//            List<Menu> list = this.menuService.findAllMenus(menu);
//            return FileUtil.createCsv("菜单表", list, Menu.class);
//        } catch (Exception e) {
//            logger.error("导出菜单列表Csv失败", e);
//            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
//        }
//    }

    @RequestMapping("menu/checkMenuName")
    @ResponseBody
    public JsonResponse checkMenuName(@RequestBody JSONObject jsonObject) {
//        if (StringUtils.isNotBlank(oldMenuName) && menuName.equalsIgnoreCase(oldMenuName)) {
//            return true;
//        }
        String menuName = jsonObject.getString("menuName");
        String type = jsonObject.getString("type");
        Menu result = this.menuService.findByNameAndType(menuName, type);
        return JsonResponse.build(result == null);
    }

    @Log("新增菜单/按钮")
    @RequiresPermissions("sys:menu:add")
    @RequestMapping("menu/addMenu")
    @ResponseBody
    public JsonResponse addMenu(@RequestBody Menu menu) {
        String name;
        if (Menu.TYPE_MENU.equals(menu.getType())) {
            name = "菜单";
        } else {
            name = "按钮";
        }
        try {
            this.menuService.addMenu(menu);
            Menu menu1 = this.menuService.findById(menu.getMenuId());
            return JsonResponse.build(menu1);
        } catch (Exception e) {
            logger.error("新增{}失败", name, e);
            return JsonResponse.build(new Exception("新增" + name + "失败，请联系网站管理员！"));
        }
    }

    @Log("删除菜单")
    @RequiresPermissions("sys:menu:delete")
    @RequestMapping("menu/deleteMenu")
    @ResponseBody
    public JsonResponse deleteMenus(@RequestBody JSONObject jsonObject) {
        try {
            List<String> menuIds = JSONObject.parseArray(jsonObject.getJSONArray("menuIds").toJSONString(), String.class);

            this.menuService.deleteMeuns(menuIds);

            Map<String, Integer> resMap = new HashMap<String, Integer>() {{
                put("rowCount", menuIds.size());
            }};
            return JsonResponse.build(resMap);
        } catch (Exception e) {
            logger.error("获取菜单失败", e);
            return JsonResponse.build(new Exception("删除失败，请联系网站管理员！"));
        }
    }

    @Log("修改菜单/按钮")
    @RequiresPermissions("sys:menu:update")
    @RequestMapping("menu/updateMenu")
    @ResponseBody
    public JsonResponse updateMenu(@RequestBody Menu menu) {
        String name;
        if (Menu.TYPE_MENU.equals(menu.getType()))
            name = "菜单";
        else
            name = "按钮";
        try {
            this.menuService.updateMenu(menu);
            Menu resMenu = this.menuService.findById(menu.getMenuId());
            return JsonResponse.build(resMenu);
        } catch (Exception e) {
            logger.error("修改{}失败", name, e);
            return JsonResponse.build(new Exception("修改" + name + "失败，请联系网站管理员！"));
        }
    }

//
//    @Log("获取系统所有URL")
//    @GetMapping("menu/urlList")
//    @ResponseBody
//    public List<Map<String, String>> getAllUrl() {
//        return this.menuService.getAllUrl("1");
//    }

}
