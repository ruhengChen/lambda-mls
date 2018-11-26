package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcCmptCharValue;
import com.yatop.lambda.base.model.CcCmptCharValueExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCmptCharValueMapper extends MyMapper<CcCmptCharValue> {
    int countByExample(CcCmptCharValueExample example);

    int deleteByExample(CcCmptCharValueExample example);

    List<CcCmptCharValue> selectByExample(CcCmptCharValueExample example);

    int updateByExampleSelective(@Param("record") CcCmptCharValue record, @Param("example") CcCmptCharValueExample example);

    int updateByExample(@Param("record") CcCmptCharValue record, @Param("example") CcCmptCharValueExample example);
}