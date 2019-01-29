package com.yatop.lambda.portal.service.impl;

import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.dao.PrProjectMemberMapper;
import com.yatop.lambda.portal.model.PrProjectMember;
import com.yatop.lambda.portal.model.ProjectMemberWithUser;
import com.yatop.lambda.portal.service.PrProjectMemberService;
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
public class PrProjectMemberServiceImpl extends BaseService<PrProjectMember> implements PrProjectMemberService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PrProjectMemberMapper prProjectMemberMapper;
    @Override
    public List<ProjectMemberWithUser> findProjectMemberWithUser(Long projectId) {
       try{
           return this.prProjectMemberMapper.findProjectMemberWithUser(projectId);
       }catch (Exception e){
           this.log.error("error", e);
           return new ArrayList<>();
       }
    }

    @Override
    public void addProjectMember(PrProjectMember prProjectMember) {

    }

}
