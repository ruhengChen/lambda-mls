package com.yatop.lambda.base.extend.mapper;

import com.yatop.lambda.base.model.PrProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectMapper {

    @Select(  "     SELECT                                                                                             " +
              "         x.`PROJECT_ID` as projectId,                                                                   " +
              "         x.`PROJECT_CODE` as projectCode,                                                               " +
              "         x.`PROJECT_NAME` as projectName,                                                               " +
              "         x.`DW_ID` as dwId,                                                                             " +
              "         x.`MW_ID` as mwId,                                                                             " +
              "         x.`CACHE_EXPIRE_DAYS` as cacheExpireDays,                                                      " +
              "         x.`DESCRIPTION` as description,                                                                " +
              "         x.`STATUS` as status,                                                                          " +
              "         x.`LAST_UPDATE_TIME` as lastUpdateTime,                                                        " +
              "         x.`LAST_UPDATE_OPER` as lastUpdateOper,                                                        " +
              "         x.`CREATE_TIME` as createTime,                                                                 " +
              "         x.`CREATE_OPER` as createOper                                                                  " +
              "     FROM                                                                                               " +
              "         PR_PROJECT x,                                                                                  " +
              "         PR_PROJECT_MEMBER y                                                                            " +
              "     WHERE                                                                                              " +
              "           y.MEMBER_USER = #{user}                                                                      " +
            "         AND y.`STATUS` = #{status}                                                                       " +
            "         AND x.PROJECT_ID = y.PROJECT_ID                                                                  " +
            "         AND x.`STATUS` = #{status}")
    List<PrProject> getProject4User(@Param("user") String operId, @Param("status") Integer status);

    @Select(  "     SELECT                                                                                           " +
            "         x.`PROJECT_ID` as projectId,                                                                   " +
            "         x.`PROJECT_CODE` as projectCode,                                                               " +
            "         x.`PROJECT_NAME` as projectName,                                                               " +
            "         x.`DW_ID` as dwId,                                                                             " +
            "         x.`MW_ID` as mwId,                                                                             " +
            "         x.`CACHE_EXPIRE_DAYS` as cacheExpireDays,                                                      " +
            "         x.`DESCRIPTION` as description,                                                                " +
            "         x.`STATUS` as status,                                                                          " +
            "         x.`LAST_UPDATE_TIME` as lastUpdateTime,                                                        " +
            "         x.`LAST_UPDATE_OPER` as lastUpdateOper,                                                        " +
            "         x.`CREATE_TIME` as createTime,                                                                 " +
            "         x.`CREATE_OPER` as createOper                                                                  " +
            "     FROM                                                                                               " +
            "         PR_PROJECT x,                                                                                  " +
            "         PR_PROJECT_MEMBER y                                                                            " +
            "     WHERE                                                                                              " +
            "           y.MEMBER_USER = #{user}                                                                      " +
            "         AND y.`STATUS` = #{status}                                                                     " +
            "         AND x.PROJECT_ID = y.PROJECT_ID                                                                " +
            "         AND x.`STATUS` = #{status}                                                                     " +
            "         AND (x.PROJECT_CODE LIKE #{keyword} or x.PROJECT_NAME LIKE #{keyword})")
    List<PrProject> getProjectMixed4Keyword(@Param("keyword") String keyword, @Param("user") String operId, @Param("status") Integer status);
}
