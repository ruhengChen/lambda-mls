package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptSpec;
import com.yatop.lambda.base.model.CfCmptSpecExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptSpecMapper extends MyMapper<CfCmptSpec> {
    int countByExample(CfCmptSpecExample example);

    int deleteByExample(CfCmptSpecExample example);

    List<CfCmptSpec> selectByExample(CfCmptSpecExample example);

    int updateByExampleSelective(@Param("record") CfCmptSpec record, @Param("example") CfCmptSpecExample example);

    int updateByExample(@Param("record") CfCmptSpec record, @Param("example") CfCmptSpecExample example);
}