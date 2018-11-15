package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.MwModelEvaluationReport;
import com.yatop.lambda.base.model.MwModelEvaluationReportExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MwModelEvaluationReportMapper extends MyMapper<MwModelEvaluationReport> {
    int countByExample(MwModelEvaluationReportExample example);

    int deleteByExample(MwModelEvaluationReportExample example);

    List<MwModelEvaluationReport> selectByExampleWithBLOBs(MwModelEvaluationReportExample example);

    List<MwModelEvaluationReport> selectByExample(MwModelEvaluationReportExample example);

    int updateByExampleSelective(@Param("record") MwModelEvaluationReport record, @Param("example") MwModelEvaluationReportExample example);

    int updateByExampleWithBLOBs(@Param("record") MwModelEvaluationReport record, @Param("example") MwModelEvaluationReportExample example);

    int updateByExample(@Param("record") MwModelEvaluationReport record, @Param("example") MwModelEvaluationReportExample example);
}