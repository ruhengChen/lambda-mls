package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionQueue;
import com.yatop.lambda.base.model.WfExecutionQueueExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionQueueMapper extends MyMapper<WfExecutionQueue> {
    int countByExample(WfExecutionQueueExample example);

    int deleteByExample(WfExecutionQueueExample example);

    List<WfExecutionQueue> selectByExample(WfExecutionQueueExample example);

    int updateByExampleSelective(@Param("record") WfExecutionQueue record, @Param("example") WfExecutionQueueExample example);

    int updateByExample(@Param("record") WfExecutionQueue record, @Param("example") WfExecutionQueueExample example);
}