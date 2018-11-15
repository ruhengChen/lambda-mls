package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptSpecCharValue;
import com.yatop.lambda.base.model.CfCmptSpecCharValueExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptSpecCharValueMapper extends MyMapper<CfCmptSpecCharValue> {
    int countByExample(CfCmptSpecCharValueExample example);

    int deleteByExample(CfCmptSpecCharValueExample example);

    List<CfCmptSpecCharValue> selectByExample(CfCmptSpecCharValueExample example);

    int updateByExampleSelective(@Param("record") CfCmptSpecCharValue record, @Param("example") CfCmptSpecCharValueExample example);

    int updateByExample(@Param("record") CfCmptSpecCharValue record, @Param("example") CfCmptSpecCharValueExample example);
}