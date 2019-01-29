package com.yatop.lambda.portal.service;

import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.model.PrProjectMember;
import com.yatop.lambda.portal.model.ProjectMemberWithUser;

import java.util.List;

/**
 * Created by 19016 on 2019/1/28.
 */
public interface PrProjectMemberService extends IService<PrProjectMember> {
     List<ProjectMemberWithUser> findProjectMemberWithUser(String username);
}
