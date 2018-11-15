package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.base.model.WfFlowNodeExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeMapper extends MyMapper<WfFlowNode> {
    int countByExample(WfFlowNodeExample example);

    int deleteByExample(WfFlowNodeExample example);

    List<WfFlowNode> selectByExample(WfFlowNodeExample example);

    int updateByExampleSelective(@Param("record") WfFlowNode record, @Param("example") WfFlowNodeExample example);

    int updateByExample(@Param("record") WfFlowNode record, @Param("example") WfFlowNodeExample example);
}