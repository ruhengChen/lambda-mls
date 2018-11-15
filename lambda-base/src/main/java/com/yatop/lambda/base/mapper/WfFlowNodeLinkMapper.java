package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.base.model.WfFlowNodeLinkExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfFlowNodeLinkMapper extends MyMapper<WfFlowNodeLink> {
    int countByExample(WfFlowNodeLinkExample example);

    int deleteByExample(WfFlowNodeLinkExample example);

    List<WfFlowNodeLink> selectByExample(WfFlowNodeLinkExample example);

    int updateByExampleSelective(@Param("record") WfFlowNodeLink record, @Param("example") WfFlowNodeLinkExample example);

    int updateByExample(@Param("record") WfFlowNodeLink record, @Param("example") WfFlowNodeLinkExample example);
}