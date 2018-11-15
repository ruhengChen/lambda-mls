package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptChar;
import com.yatop.lambda.base.model.CfCmptCharExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptCharMapper extends MyMapper<CfCmptChar> {
    int countByExample(CfCmptCharExample example);

    int deleteByExample(CfCmptCharExample example);

    List<CfCmptChar> selectByExample(CfCmptCharExample example);

    int updateByExampleSelective(@Param("record") CfCmptChar record, @Param("example") CfCmptCharExample example);

    int updateByExample(@Param("record") CfCmptChar record, @Param("example") CfCmptCharExample example);
}