package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.base.model.WfSnapshotExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfSnapshotMapper extends MyMapper<WfSnapshot> {
    int countByExample(WfSnapshotExample example);

    int deleteByExample(WfSnapshotExample example);

    List<WfSnapshot> selectByExampleWithBLOBs(WfSnapshotExample example);

    List<WfSnapshot> selectByExample(WfSnapshotExample example);

    int updateByExampleSelective(@Param("record") WfSnapshot record, @Param("example") WfSnapshotExample example);

    int updateByExampleWithBLOBs(@Param("record") WfSnapshot record, @Param("example") WfSnapshotExample example);

    int updateByExample(@Param("record") WfSnapshot record, @Param("example") WfSnapshotExample example);
}