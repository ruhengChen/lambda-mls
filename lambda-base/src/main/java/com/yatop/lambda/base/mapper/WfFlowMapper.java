package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.base.model.WfFlowExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowMapper extends MyMapper<WfFlow> {
    int countByExample(WfFlowExample example);

    int deleteByExample(WfFlowExample example);

    List<WfFlow> selectByExample(WfFlowExample example);

    int updateByExampleSelective(@Param("record") WfFlow record, @Param("example") WfFlowExample example);

    int updateByExample(@Param("record") WfFlow record, @Param("example") WfFlowExample example);
}