package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptCharValue;
import com.yatop.lambda.base.model.CfCmptCharValueExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharValueMapper extends MyMapper<CfCmptCharValue> {
    int countByExample(CfCmptCharValueExample example);

    int deleteByExample(CfCmptCharValueExample example);

    List<CfCmptCharValue> selectByExample(CfCmptCharValueExample example);

    int updateByExampleSelective(@Param("record") CfCmptCharValue record, @Param("example") CfCmptCharValueExample example);

    int updateByExample(@Param("record") CfCmptCharValue record, @Param("example") CfCmptCharValueExample example);
}