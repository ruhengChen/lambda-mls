package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.base.model.EmExperimentExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmExperimentMapper extends MyMapper<EmExperiment> {
    int countByExample(EmExperimentExample example);

    int deleteByExample(EmExperimentExample example);

    List<EmExperiment> selectByExample(EmExperimentExample example);

    int updateByExampleSelective(@Param("record") EmExperiment record, @Param("example") EmExperimentExample example);

    int updateByExample(@Param("record") EmExperiment record, @Param("example") EmExperimentExample example);
}