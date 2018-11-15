package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfExecutionJoinPath;
import com.yatop.lambda.base.model.WfExecutionJoinPathExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfExecutionJoinPathMapper extends MyMapper<WfExecutionJoinPath> {
    int countByExample(WfExecutionJoinPathExample example);

    int deleteByExample(WfExecutionJoinPathExample example);

    List<WfExecutionJoinPath> selectByExample(WfExecutionJoinPathExample example);

    int updateByExampleSelective(@Param("record") WfExecutionJoinPath record, @Param("example") WfExecutionJoinPathExample example);

    int updateByExample(@Param("record") WfExecutionJoinPath record, @Param("example") WfExecutionJoinPathExample example);
}