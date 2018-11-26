package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodeValue;
import com.yatop.lambda.base.model.WfFlowNodeValueExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeValueMapper extends MyMapper<WfFlowNodeValue> {
    int countByExample(WfFlowNodeValueExample example);

    int deleteByExample(WfFlowNodeValueExample example);

    List<WfFlowNodeValue> selectByExample(WfFlowNodeValueExample example);

    int updateByExampleSelective(@Param("record") WfFlowNodeValue record, @Param("example") WfFlowNodeValueExample example);

    int updateByExample(@Param("record") WfFlowNodeValue record, @Param("example") WfFlowNodeValueExample example);
}