package com.yatop.lambda.base.extend.mapper;



import com.yatop.lambda.base.extend.model.ProjectMemberWithUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectMemberMapper {
    @Select(  "    select result.memberUser,result.projectRole,result.createTime,u.EMAIL email," +
            "    u.MOBILE mobile,u.STATUS status,u.USER_REL_NAME userRelName" +
            "    from (select ppm.MEMBER_USER memberUser,ppm.PROJECT_ROLE projectRole,ppm.CREATE_TIME createTime" +
            "    from pr_project_member ppm  where ppm.PROJECT_ID=#{projectId} AND ppm.STATUS=0) result" +
            "    left join t_user u on result.memberUser=u.USERNAME")
    List<ProjectMemberWithUser> findProjectMemberWithUser(Long projectId);
}