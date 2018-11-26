package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcCmptSpecRel;
import com.yatop.lambda.base.model.CcCmptSpecRelExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCmptSpecRelMapper extends MyMapper<CcCmptSpecRel> {
    int countByExample(CcCmptSpecRelExample example);

    int deleteByExample(CcCmptSpecRelExample example);

    List<CcCmptSpecRel> selectByExample(CcCmptSpecRelExample example);

    int updateByExampleSelective(@Param("record") CcCmptSpecRel record, @Param("example") CcCmptSpecRelExample example);

    int updateByExample(@Param("record") CcCmptSpecRel record, @Param("example") CcCmptSpecRelExample example);
}