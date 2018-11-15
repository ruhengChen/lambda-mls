package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.base.model.WfModulePortExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfModulePortMapper extends MyMapper<WfModulePort> {
    int countByExample(WfModulePortExample example);

    int deleteByExample(WfModulePortExample example);

    List<WfModulePort> selectByExample(WfModulePortExample example);

    int updateByExampleSelective(@Param("record") WfModulePort record, @Param("example") WfModulePortExample example);

    int updateByExample(@Param("record") WfModulePort record, @Param("example") WfModulePortExample example);
}