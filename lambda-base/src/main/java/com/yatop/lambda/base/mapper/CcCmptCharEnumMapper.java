package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcCmptCharEnum;
import com.yatop.lambda.base.model.CcCmptCharEnumExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCmptCharEnumMapper extends MyMapper<CcCmptCharEnum> {
    int countByExample(CcCmptCharEnumExample example);

    int deleteByExample(CcCmptCharEnumExample example);

    List<CcCmptCharEnum> selectByExample(CcCmptCharEnumExample example);

    int updateByExampleSelective(@Param("record") CcCmptCharEnum record, @Param("example") CcCmptCharEnumExample example);

    int updateByExample(@Param("record") CcCmptCharEnum record, @Param("example") CcCmptCharEnumExample example);
}