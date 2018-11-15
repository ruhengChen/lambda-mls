package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.base.model.WfExecutionTaskExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionTaskMapper extends MyMapper<WfExecutionTask> {
    int countByExample(WfExecutionTaskExample example);

    int deleteByExample(WfExecutionTaskExample example);

    List<WfExecutionTask> selectByExampleWithBLOBs(WfExecutionTaskExample example);

    List<WfExecutionTask> selectByExample(WfExecutionTaskExample example);

    int updateByExampleSelective(@Param("record") WfExecutionTask record, @Param("example") WfExecutionTaskExample example);

    int updateByExampleWithBLOBs(@Param("record") WfExecutionTask record, @Param("example") WfExecutionTaskExample example);

    int updateByExample(@Param("record") WfExecutionTask record, @Param("example") WfExecutionTaskExample example);
}