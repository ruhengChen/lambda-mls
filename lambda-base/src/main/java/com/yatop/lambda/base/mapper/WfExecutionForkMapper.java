package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionFork;
import com.yatop.lambda.base.model.WfExecutionForkExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionForkMapper extends MyMapper<WfExecutionFork> {
    int countByExample(WfExecutionForkExample example);

    int deleteByExample(WfExecutionForkExample example);

    List<WfExecutionFork> selectByExample(WfExecutionForkExample example);

    int updateByExampleSelective(@Param("record") WfExecutionFork record, @Param("example") WfExecutionForkExample example);

    int updateByExample(@Param("record") WfExecutionFork record, @Param("example") WfExecutionForkExample example);
}