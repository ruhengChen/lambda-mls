package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.base.model.WfJsonObjectExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfJsonObjectMapper extends MyMapper<WfJsonObject> {
    int countByExample(WfJsonObjectExample example);

    int deleteByExample(WfJsonObjectExample example);

    List<WfJsonObject> selectByExampleWithBLOBs(WfJsonObjectExample example);

    List<WfJsonObject> selectByExample(WfJsonObjectExample example);

    int updateByExampleSelective(@Param("record") WfJsonObject record, @Param("example") WfJsonObjectExample example);

    int updateByExampleWithBLOBs(@Param("record") WfJsonObject record, @Param("example") WfJsonObjectExample example);

    int updateByExample(@Param("record") WfJsonObject record, @Param("example") WfJsonObjectExample example);
}