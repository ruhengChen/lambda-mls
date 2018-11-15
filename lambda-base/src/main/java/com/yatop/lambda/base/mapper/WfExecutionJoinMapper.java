package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionJoin;
import com.yatop.lambda.base.model.WfExecutionJoinExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionJoinMapper extends MyMapper<WfExecutionJoin> {
    int countByExample(WfExecutionJoinExample example);

    int deleteByExample(WfExecutionJoinExample example);

    List<WfExecutionJoin> selectByExample(WfExecutionJoinExample example);

    int updateByExampleSelective(@Param("record") WfExecutionJoin record, @Param("example") WfExecutionJoinExample example);

    int updateByExample(@Param("record") WfExecutionJoin record, @Param("example") WfExecutionJoinExample example);
}