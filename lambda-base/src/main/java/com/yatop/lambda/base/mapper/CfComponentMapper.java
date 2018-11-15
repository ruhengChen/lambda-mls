package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.CfComponent;
import com.yatop.lambda.base.model.CfComponentExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfComponentMapper extends MyMapper<CfComponent> {
    int countByExample(CfComponentExample example);

    int deleteByExample(CfComponentExample example);

    List<CfComponent> selectByExample(CfComponentExample example);

    int updateByExampleSelective(@Param("record") CfComponent record, @Param("example") CfComponentExample example);

    int updateByExample(@Param("record") CfComponent record, @Param("example") CfComponentExample example);
}