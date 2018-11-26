package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionTaskOutput;
import com.yatop.lambda.base.model.WfExecutionTaskOutputExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionTaskOutputMapper extends MyMapper<WfExecutionTaskOutput> {
    int countByExample(WfExecutionTaskOutputExample example);

    int deleteByExample(WfExecutionTaskOutputExample example);

    List<WfExecutionTaskOutput> selectByExample(WfExecutionTaskOutputExample example);

    int updateByExampleSelective(@Param("record") WfExecutionTaskOutput record, @Param("example") WfExecutionTaskOutputExample example);

    int updateByExample(@Param("record") WfExecutionTaskOutput record, @Param("example") WfExecutionTaskOutputExample example);
}