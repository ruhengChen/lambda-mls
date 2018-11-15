package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfCodeScript;
import com.yatop.lambda.base.model.WfCodeScriptExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfCodeScriptMapper extends MyMapper<WfCodeScript> {
    int countByExample(WfCodeScriptExample example);

    int deleteByExample(WfCodeScriptExample example);

    List<WfCodeScript> selectByExampleWithBLOBs(WfCodeScriptExample example);

    List<WfCodeScript> selectByExample(WfCodeScriptExample example);

    int updateByExampleSelective(@Param("record") WfCodeScript record, @Param("example") WfCodeScriptExample example);

    int updateByExampleWithBLOBs(@Param("record") WfCodeScript record, @Param("example") WfCodeScriptExample example);

    int updateByExample(@Param("record") WfCodeScript record, @Param("example") WfCodeScriptExample example);
}