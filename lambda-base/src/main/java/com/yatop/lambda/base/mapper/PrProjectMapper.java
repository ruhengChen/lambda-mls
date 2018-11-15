package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.base.model.PrProjectExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrProjectMapper extends MyMapper<PrProject> {
    int countByExample(PrProjectExample example);

    int deleteByExample(PrProjectExample example);

    List<PrProject> selectByExample(PrProjectExample example);

    int updateByExampleSelective(@Param("record") PrProject record, @Param("example") PrProjectExample example);

    int updateByExample(@Param("record") PrProject record, @Param("example") PrProjectExample example);
}