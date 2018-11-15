package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.base.model.WfModuleExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfModuleMapper extends MyMapper<WfModule> {
    int countByExample(WfModuleExample example);

    int deleteByExample(WfModuleExample example);

    List<WfModule> selectByExample(WfModuleExample example);

    int updateByExampleSelective(@Param("record") WfModule record, @Param("example") WfModuleExample example);

    int updateByExample(@Param("record") WfModule record, @Param("example") WfModuleExample example);
}