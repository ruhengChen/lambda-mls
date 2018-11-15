package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptCharType;
import com.yatop.lambda.base.model.CfCmptCharTypeExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharTypeMapper extends MyMapper<CfCmptCharType> {
    int countByExample(CfCmptCharTypeExample example);

    int deleteByExample(CfCmptCharTypeExample example);

    List<CfCmptCharType> selectByExample(CfCmptCharTypeExample example);

    int updateByExampleSelective(@Param("record") CfCmptCharType record, @Param("example") CfCmptCharTypeExample example);

    int updateByExample(@Param("record") CfCmptCharType record, @Param("example") CfCmptCharTypeExample example);
}