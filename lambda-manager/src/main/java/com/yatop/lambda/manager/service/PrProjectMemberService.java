package com.yatop.lambda.manager.service;



import com.yatop.lambda.base.extend.model.ProjectMemberWithUser;
import com.yatop.lambda.base.model.PrProjectMember;

import java.util.List;

/**
 * Created by 19016 on 2019/1/28.
 */
public interface PrProjectMemberService  {
     List<ProjectMemberWithUser> findProjectMemberWithUser(Long projectId);
     void addProjectMember(PrProjectMember prProjectMember);
     int deleteProjectMember(PrProjectMember prProjectMember);
}
