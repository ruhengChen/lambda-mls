package com.yatop.lambda.manager.controller;

import com.yatop.lambda.base.model.PrProjectMember;
import com.yatop.lambda.manager.service.PrProjectMemberService;
import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.domain.ResponseBo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PrProjectMemberService prProjectMemberService;
    @RequestMapping("projectMember/list")
    @RequiresPermissions("member:list")
    @ResponseBody
    public Map<String,Object> getProjectMemberWithUser(QueryRequest request, Long projectId){
        return super.selectByPageNumSize(request,()->prProjectMemberService.findProjectMemberWithUser(projectId));
    }
    @RequestMapping("projectMember/add")
    @RequiresPermissions("member:add")
    @ResponseBody
    public ResponseBo addProjectMember(PrProjectMember prProjectMember){
        try{
            prProjectMemberService.addProjectMember(prProjectMember);
            return ResponseBo.ok("新增成功");
        }catch(Exception e){
            log.error("新增项目成员失败", e);
            return ResponseBo.error("新增失败");
        }
    }
    @RequestMapping("projectMember/delete")
    @RequiresPermissions("member:delete")
    @ResponseBody
    public ResponseBo deleteProjectMember(PrProjectMember prProjectMember){
        try{
            return ResponseBo.ok("删除成功");
        }catch(Exception e){
            log.error("删除项目成员失败", e);
            return ResponseBo.error("删除失败");
        }
    }
}
