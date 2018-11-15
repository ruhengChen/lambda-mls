package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionPath;
import com.yatop.lambda.base.model.WfExecutionPathExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionPathMapper extends MyMapper<WfExecutionPath> {
    int countByExample(WfExecutionPathExample example);

    int deleteByExample(WfExecutionPathExample example);

    List<WfExecutionPath> selectByExample(WfExecutionPathExample example);

    int updateByExampleSelective(@Param("record") WfExecutionPath record, @Param("example") WfExecutionPathExample example);

    int updateByExample(@Param("record") WfExecutionPath record, @Param("example") WfExecutionPathExample example);
}