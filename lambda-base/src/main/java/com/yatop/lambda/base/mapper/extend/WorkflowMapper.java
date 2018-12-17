package com.yatop.lambda.base.mapper.extend;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface WorkflowMapper {

    @Update(  "     UPDATE WF_FLOW                      " +
            "       SET NEXT_SNAPSHOT_VERSION = NEXT_SNAPSHOT_VERSION + 1,              " +
            "       LAST_UPDAT_TIME = #{time},          " +
            "       LAST_UPDATE_OPER = #{oper}          " +
            "       WHERE FLOW_ID = #{id}")
    int updateWorkflowSnapshot(@Param("id") Long id, @Param("time") Date time, @Param("oper") String oper);

    @Update(  "     UPDATE WF_FLOW                      " +
            "       SET NODE_COUNT = NODE_COUNT + 1,    " +
            "       LAST_UPDAT_TIME = #{time},          " +
            "       LAST_UPDATE_OPER = #{oper}          " +
            "       WHERE FLOW_ID = #{id}")
    int increaseWorkflowNode(@Param("id") Long id, @Param("time") Date time, @Param("oper") String oper);

    @Update(  "     UPDATE WF_FLOW                      " +
            "       SET NODE_COUNT = NODE_COUNT - #{count},    " +
            "       NEXT_DELETE_SEQUENCE = MOD(NEXT_DELETE_SEQUENCE + 1, 32),          " +
            "       LAST_UPDAT_TIME = #{time},          " +
            "       LAST_UPDATE_OPER = #{oper}          " +
            "       WHERE FLOW_ID = #{id}")
    int updateWorkflowNodeCount4Delete(@Param("id") Long id, @Param("count") Long count, @Param("time") Date time, @Param("oper") String oper);

    @Update(  "     UPDATE WF_FLOW                      " +
            "       SET NODE_COUNT = NODE_COUNT - #{count},    " +
            "       NEXT_DELETE_SEQUENCE = MOD(NEXT_DELETE_SEQUENCE - 1, 32),          " +
            "       LAST_UPDAT_TIME = #{time},          " +
            "       LAST_UPDATE_OPER = #{oper}          " +
            "       WHERE FLOW_ID = #{id}")
    int updateWorkflowNodeCount4Recover(@Param("id") Long id, @Param("count") Long count, @Param("time") Date time, @Param("oper") String oper);

    @Update(  "     UPDATE WF_FLOW                      " +
            "       SET VERSION = VERSION + 1,          " +
            "       LAST_UPDAT_TIME = #{time},          " +
            "       LAST_UPDATE_OPER = #{oper}          " +
            "       WHERE FLOW_ID = #{id}")
    int increaseWorkflowVersion(@Param("id") Long id, @Param("time") Date time, @Param("oper") String oper);
}
