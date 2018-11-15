package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.base.model.WfFlowNodeParameterExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeParameterMapper extends MyMapper<WfFlowNodeParameter> {
    int countByExample(WfFlowNodeParameterExample example);

    int deleteByExample(WfFlowNodeParameterExample example);

    List<WfFlowNodeParameter> selectByExample(WfFlowNodeParameterExample example);

    int updateByExampleSelective(@Param("record") WfFlowNodeParameter record, @Param("example") WfFlowNodeParameterExample example);

    int updateByExample(@Param("record") WfFlowNodeParameter record, @Param("example") WfFlowNodeParameterExample example);
}