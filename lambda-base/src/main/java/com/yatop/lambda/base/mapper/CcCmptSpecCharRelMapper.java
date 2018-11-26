package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcCmptSpecCharRel;
import com.yatop.lambda.base.model.CcCmptSpecCharRelExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCmptSpecCharRelMapper extends MyMapper<CcCmptSpecCharRel> {
    int countByExample(CcCmptSpecCharRelExample example);

    int deleteByExample(CcCmptSpecCharRelExample example);

    List<CcCmptSpecCharRel> selectByExample(CcCmptSpecCharRelExample example);

    int updateByExampleSelective(@Param("record") CcCmptSpecCharRel record, @Param("example") CcCmptSpecCharRelExample example);

    int updateByExample(@Param("record") CcCmptSpecCharRel record, @Param("example") CcCmptSpecCharRelExample example);
}