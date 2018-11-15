package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.base.model.MwModelExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MwModelMapper extends MyMapper<MwModel> {
    int countByExample(MwModelExample example);

    int deleteByExample(MwModelExample example);

    List<MwModel> selectByExample(MwModelExample example);

    int updateByExampleSelective(@Param("record") MwModel record, @Param("example") MwModelExample example);

    int updateByExample(@Param("record") MwModel record, @Param("example") MwModelExample example);
}