package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcCmptSpecCharValue;
import com.yatop.lambda.base.model.CcCmptSpecCharValueExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCmptSpecCharValueMapper extends MyMapper<CcCmptSpecCharValue> {
    int countByExample(CcCmptSpecCharValueExample example);

    int deleteByExample(CcCmptSpecCharValueExample example);

    List<CcCmptSpecCharValue> selectByExample(CcCmptSpecCharValueExample example);

    int updateByExampleSelective(@Param("record") CcCmptSpecCharValue record, @Param("example") CcCmptSpecCharValueExample example);

    int updateByExample(@Param("record") CcCmptSpecCharValue record, @Param("example") CcCmptSpecCharValueExample example);
}