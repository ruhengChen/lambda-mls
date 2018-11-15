package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfCmptAlgorithm;
import com.yatop.lambda.base.model.CfCmptAlgorithmExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfCmptAlgorithmMapper extends MyMapper<CfCmptAlgorithm> {
    int countByExample(CfCmptAlgorithmExample example);

    int deleteByExample(CfCmptAlgorithmExample example);

    List<CfCmptAlgorithm> selectByExample(CfCmptAlgorithmExample example);

    int updateByExampleSelective(@Param("record") CfCmptAlgorithm record, @Param("example") CfCmptAlgorithmExample example);

    int updateByExample(@Param("record") CfCmptAlgorithm record, @Param("example") CfCmptAlgorithmExample example);
}