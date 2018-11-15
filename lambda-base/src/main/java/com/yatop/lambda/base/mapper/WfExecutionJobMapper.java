package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.base.model.WfExecutionJobExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionJobMapper extends MyMapper<WfExecutionJob> {
    int countByExample(WfExecutionJobExample example);

    int deleteByExample(WfExecutionJobExample example);

    List<WfExecutionJob> selectByExampleWithBLOBs(WfExecutionJobExample example);

    List<WfExecutionJob> selectByExample(WfExecutionJobExample example);

    int updateByExampleSelective(@Param("record") WfExecutionJob record, @Param("example") WfExecutionJobExample example);

    int updateByExampleWithBLOBs(@Param("record") WfExecutionJob record, @Param("example") WfExecutionJobExample example);

    int updateByExample(@Param("record") WfExecutionJob record, @Param("example") WfExecutionJobExample example);
}