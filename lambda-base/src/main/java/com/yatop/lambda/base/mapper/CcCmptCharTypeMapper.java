package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcCmptCharType;
import com.yatop.lambda.base.model.CcCmptCharTypeExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCmptCharTypeMapper extends MyMapper<CcCmptCharType> {
    int countByExample(CcCmptCharTypeExample example);

    int deleteByExample(CcCmptCharTypeExample example);

    List<CcCmptCharType> selectByExample(CcCmptCharTypeExample example);

    int updateByExampleSelective(@Param("record") CcCmptCharType record, @Param("example") CcCmptCharTypeExample example);

    int updateByExample(@Param("record") CcCmptCharType record, @Param("example") CcCmptCharTypeExample example);
}