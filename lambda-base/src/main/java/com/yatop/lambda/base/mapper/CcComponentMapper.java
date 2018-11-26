package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CcComponent;
import com.yatop.lambda.base.model.CcComponentExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcComponentMapper extends MyMapper<CcComponent> {
    int countByExample(CcComponentExample example);

    int deleteByExample(CcComponentExample example);

    List<CcComponent> selectByExample(CcComponentExample example);

    int updateByExampleSelective(@Param("record") CcComponent record, @Param("example") CcComponentExample example);

    int updateByExample(@Param("record") CcComponent record, @Param("example") CcComponentExample example);
}