package com.yatop.lambda.portal.controller;

import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.domain.JsonResponse;
import com.yatop.lambda.portal.common.domain.ResponseBo;
import com.yatop.lambda.portal.model.UserOnline;
import com.yatop.lambda.portal.service.SessionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class SessionController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SessionService sessionService;

    @Log("获取在线用户信息")
    @RequestMapping("session")
    @RequiresPermissions("session:list")
    public String online() {
        return "system/monitor/online";
    }

    @ResponseBody
    @RequestMapping("session/list")
    @RequiresPermissions("session:list")
    public JsonResponse list() {
        List<UserOnline> list = sessionService.list();
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", list);
        rspData.put("total", list.size());
        return JsonResponse.build(rspData);
    }

    @ResponseBody
    @RequiresPermissions("user:kickout")
    @RequestMapping("session/forceLogout")
    public JsonResponse forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
            return JsonResponse.build("");
        } catch (Exception e) {
            log.error("踢出用户失败", e);
            return JsonResponse.build(new Exception("踢出用户失败"));
        }

    }
}
