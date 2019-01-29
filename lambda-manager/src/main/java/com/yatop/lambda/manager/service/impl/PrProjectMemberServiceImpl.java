package com.yatop.lambda.manager.service.impl;

import com.yatop.lambda.base.extend.mapper.ProjectMemberMapper;
import com.yatop.lambda.base.extend.model.ProjectMemberWithUser;
import com.yatop.lambda.base.model.PrProjectMember;
import com.yatop.lambda.core.mgr.project.ProjectMemberMgr;
import com.yatop.lambda.manager.service.PrProjectMemberService;
import com.yatop.lambda.portal.model.User;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 19016 on 2019/1/29.
 */
@Service("projectMemberService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PrProjectMemberServiceImpl  implements PrProjectMemberService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProjectMemberMapper projectMemberMapper;
    @Autowired
    private ProjectMemberMgr projectMemberMgr;
    @Override
    public List<ProjectMemberWithUser> findProjectMemberWithUser(Long projectId) {
       try{
           return this.projectMemberMapper.findProjectMemberWithUser(projectId);
       }catch (Exception e){
           this.log.error("error", e);
           return new ArrayList<>();
       }
    }

    /**
     *
     * @param prProjectMember 项目成员对象
     * 项目成员状态，最近更新时间，最近更新用户，创建时间，创建用户。
     */
    @Override
    public void addProjectMember(PrProjectMember prProjectMember) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        projectMemberMgr.insertProjectMember(prProjectMember,user.getUsername());
    }
}
