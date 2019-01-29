package com.yatop.lambda.portal.controller;

import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.model.User;
import com.yatop.lambda.portal.service.PrProjectMemberService;
import com.yatop.lambda.portal.service.PrProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 19016 on 2019/1/28.
 */
@Controller
public class PrProjectController extends BaseController {
    @Autowired
    private PrProjectMemberService prProjectMemberService;
    @RequestMapping("projectMember/list") //todo
    @ResponseBody
    public Map<String,Object> getProjectMemberWithUser(QueryRequest request, String username){
        return super.selectByPageNumSize(request,()->prProjectMemberService.findProjectMemberWithUser(username));
    }
}
