package com.yatop.lambda.base.mapper.extend;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface WorkflowJobMapper {

    @Update(  "     UPDATE WF_EXECUTION_JOB             " +
            "       SET NEXT_TASK_SEQUENCE = NEXT_TASK_SEQUENCE + 1,          " +
            "       LAST_UPDAT_TIME = #{time},          " +
            "       LAST_UPDATE_OPER = #{oper}          " +
            "       WHERE FLOW_ID = #{id}")
    int increaseTaskSequence(@Param("id") Long id, @Param("time") Date time, @Param("oper") String oper);
}
