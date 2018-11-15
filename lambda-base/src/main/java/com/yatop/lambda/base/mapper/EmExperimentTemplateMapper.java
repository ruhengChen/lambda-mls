package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.EmExperimentTemplate;
import com.yatop.lambda.base.model.EmExperimentTemplateExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmExperimentTemplateMapper extends MyMapper<EmExperimentTemplate> {
    int countByExample(EmExperimentTemplateExample example);

    int deleteByExample(EmExperimentTemplateExample example);

    List<EmExperimentTemplate> selectByExampleWithBLOBs(EmExperimentTemplateExample example);

    List<EmExperimentTemplate> selectByExample(EmExperimentTemplateExample example);

    int updateByExampleSelective(@Param("record") EmExperimentTemplate record, @Param("example") EmExperimentTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") EmExperimentTemplate record, @Param("example") EmExperimentTemplateExample example);

    int updateByExample(@Param("record") EmExperimentTemplate record, @Param("example") EmExperimentTemplateExample example);
}