package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.base.model.WfFlowNodePortExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodePortMapper extends MyMapper<WfFlowNodePort> {
    int countByExample(WfFlowNodePortExample example);

    int deleteByExample(WfFlowNodePortExample example);

    List<WfFlowNodePort> selectByExample(WfFlowNodePortExample example);

    int updateByExampleSelective(@Param("record") WfFlowNodePort record, @Param("example") WfFlowNodePortExample example);

    int updateByExample(@Param("record") WfFlowNodePort record, @Param("example") WfFlowNodePortExample example);
}