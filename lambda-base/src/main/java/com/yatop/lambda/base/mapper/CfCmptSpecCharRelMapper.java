package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptSpecCharRel;
import com.yatop.lambda.base.model.CfCmptSpecCharRelExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptSpecCharRelMapper extends MyMapper<CfCmptSpecCharRel> {
    int countByExample(CfCmptSpecCharRelExample example);

    int deleteByExample(CfCmptSpecCharRelExample example);

    List<CfCmptSpecCharRel> selectByExample(CfCmptSpecCharRelExample example);

    int updateByExampleSelective(@Param("record") CfCmptSpecCharRel record, @Param("example") CfCmptSpecCharRelExample example);

    int updateByExample(@Param("record") CfCmptSpecCharRel record, @Param("example") CfCmptSpecCharRelExample example);
}