package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptCharEnum;
import com.yatop.lambda.base.model.CfCmptCharEnumExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharEnumMapper extends MyMapper<CfCmptCharEnum> {
    int countByExample(CfCmptCharEnumExample example);

    int deleteByExample(CfCmptCharEnumExample example);

    List<CfCmptCharEnum> selectByExample(CfCmptCharEnumExample example);

    int updateByExampleSelective(@Param("record") CfCmptCharEnum record, @Param("example") CfCmptCharEnumExample example);

    int updateByExample(@Param("record") CfCmptCharEnum record, @Param("example") CfCmptCharEnumExample example);
}