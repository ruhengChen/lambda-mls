package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.base.model.WfFlowNodeSchemaExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeSchemaMapper extends MyMapper<WfFlowNodeSchema> {
    int countByExample(WfFlowNodeSchemaExample example);

    int deleteByExample(WfFlowNodeSchemaExample example);

    List<WfFlowNodeSchema> selectByExample(WfFlowNodeSchemaExample example);

    int updateByExampleSelective(@Param("record") WfFlowNodeSchema record, @Param("example") WfFlowNodeSchemaExample example);

    int updateByExample(@Param("record") WfFlowNodeSchema record, @Param("example") WfFlowNodeSchemaExample example);
}