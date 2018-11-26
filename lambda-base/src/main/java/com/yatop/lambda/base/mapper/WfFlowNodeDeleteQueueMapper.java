package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodeDeleteQueue;
import com.yatop.lambda.base.model.WfFlowNodeDeleteQueueExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeDeleteQueueMapper extends MyMapper<WfFlowNodeDeleteQueue> {
    int countByExample(WfFlowNodeDeleteQueueExample example);

    int deleteByExample(WfFlowNodeDeleteQueueExample example);

    List<WfFlowNodeDeleteQueue> selectByExample(WfFlowNodeDeleteQueueExample example);

    int updateByExampleSelective(@Param("record") WfFlowNodeDeleteQueue record, @Param("example") WfFlowNodeDeleteQueueExample example);

    int updateByExample(@Param("record") WfFlowNodeDeleteQueue record, @Param("example") WfFlowNodeDeleteQueueExample example);
}