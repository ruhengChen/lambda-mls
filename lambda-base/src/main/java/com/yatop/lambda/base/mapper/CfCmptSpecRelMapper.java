package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptSpecRel;
import com.yatop.lambda.base.model.CfCmptSpecRelExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptSpecRelMapper extends MyMapper<CfCmptSpecRel> {
    int countByExample(CfCmptSpecRelExample example);

    int deleteByExample(CfCmptSpecRelExample example);

    List<CfCmptSpecRel> selectByExample(CfCmptSpecRelExample example);

    int updateByExampleSelective(@Param("record") CfCmptSpecRel record, @Param("example") CfCmptSpecRelExample example);

    int updateByExample(@Param("record") CfCmptSpecRel record, @Param("example") CfCmptSpecRelExample example);
}