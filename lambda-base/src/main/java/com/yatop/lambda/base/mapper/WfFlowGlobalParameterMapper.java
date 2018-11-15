package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowGlobalParameter;
import com.yatop.lambda.base.model.WfFlowGlobalParameterExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowGlobalParameterMapper extends MyMapper<WfFlowGlobalParameter> {
    int countByExample(WfFlowGlobalParameterExample example);

    int deleteByExample(WfFlowGlobalParameterExample example);

    List<WfFlowGlobalParameter> selectByExample(WfFlowGlobalParameterExample example);

    int updateByExampleSelective(@Param("record") WfFlowGlobalParameter record, @Param("example") WfFlowGlobalParameterExample example);

    int updateByExample(@Param("record") WfFlowGlobalParameter record, @Param("example") WfFlowGlobalParameterExample example);
}