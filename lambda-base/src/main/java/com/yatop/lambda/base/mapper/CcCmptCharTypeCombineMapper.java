package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcCmptCharTypeCombine;
import com.yatop.lambda.base.model.CcCmptCharTypeCombineExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCmptCharTypeCombineMapper extends MyMapper<CcCmptCharTypeCombine> {
    int countByExample(CcCmptCharTypeCombineExample example);

    int deleteByExample(CcCmptCharTypeCombineExample example);

    List<CcCmptCharTypeCombine> selectByExample(CcCmptCharTypeCombineExample example);

    int updateByExampleSelective(@Param("record") CcCmptCharTypeCombine record, @Param("example") CcCmptCharTypeCombineExample example);

    int updateByExample(@Param("record") CcCmptCharTypeCombine record, @Param("example") CcCmptCharTypeCombineExample example);
}