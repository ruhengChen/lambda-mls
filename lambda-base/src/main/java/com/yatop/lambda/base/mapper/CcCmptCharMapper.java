package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcCmptChar;
import com.yatop.lambda.base.model.CcCmptCharExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCmptCharMapper extends MyMapper<CcCmptChar> {
    int countByExample(CcCmptCharExample example);

    int deleteByExample(CcCmptCharExample example);

    List<CcCmptChar> selectByExample(CcCmptCharExample example);

    int updateByExampleSelective(@Param("record") CcCmptChar record, @Param("example") CcCmptCharExample example);

    int updateByExample(@Param("record") CcCmptChar record, @Param("example") CcCmptCharExample example);
}