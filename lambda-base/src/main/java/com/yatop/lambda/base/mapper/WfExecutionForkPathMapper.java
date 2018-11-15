package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionForkPath;
import com.yatop.lambda.base.model.WfExecutionForkPathExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionForkPathMapper extends MyMapper<WfExecutionForkPath> {
    int countByExample(WfExecutionForkPathExample example);

    int deleteByExample(WfExecutionForkPathExample example);

    List<WfExecutionForkPath> selectByExample(WfExecutionForkPathExample example);

    int updateByExampleSelective(@Param("record") WfExecutionForkPath record, @Param("example") WfExecutionForkPathExample example);

    int updateByExample(@Param("record") WfExecutionForkPath record, @Param("example") WfExecutionForkPathExample example);
}