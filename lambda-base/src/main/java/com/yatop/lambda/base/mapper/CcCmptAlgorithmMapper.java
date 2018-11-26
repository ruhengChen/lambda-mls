package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcCmptAlgorithm;
import com.yatop.lambda.base.model.CcCmptAlgorithmExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCmptAlgorithmMapper extends MyMapper<CcCmptAlgorithm> {
    int countByExample(CcCmptAlgorithmExample example);

    int deleteByExample(CcCmptAlgorithmExample example);

    List<CcCmptAlgorithm> selectByExample(CcCmptAlgorithmExample example);

    int updateByExampleSelective(@Param("record") CcCmptAlgorithm record, @Param("example") CcCmptAlgorithmExample example);

    int updateByExample(@Param("record") CcCmptAlgorithm record, @Param("example") CcCmptAlgorithmExample example);
}