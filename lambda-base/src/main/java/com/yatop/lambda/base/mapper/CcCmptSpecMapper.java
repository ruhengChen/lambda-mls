package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcCmptSpec;
import com.yatop.lambda.base.model.CcCmptSpecExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCmptSpecMapper extends MyMapper<CcCmptSpec> {
    int countByExample(CcCmptSpecExample example);

    int deleteByExample(CcCmptSpecExample example);

    List<CcCmptSpec> selectByExample(CcCmptSpecExample example);

    int updateByExampleSelective(@Param("record") CcCmptSpec record, @Param("example") CcCmptSpecExample example);

    int updateByExample(@Param("record") CcCmptSpec record, @Param("example") CcCmptSpecExample example);
}