package com.yatop.lambda.portal.dao;

import com.yatop.lambda.portal.common.config.MyMapper;
import com.yatop.lambda.portal.model.PrProjectMember;

import java.util.List;

public interface PrProjectMemberMapper extends MyMapper<PrProjectMember> {
    List<ProjectMemberWithUser> findProjectMemberWithUser(String username);
}