package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.DwDataTable;
import com.yatop.lambda.base.model.DwDataTableExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwDataTableMapper extends MyMapper<DwDataTable> {
    int countByExample(DwDataTableExample example);

    int deleteByExample(DwDataTableExample example);

    List<DwDataTable> selectByExample(DwDataTableExample example);

    int updateByExampleSelective(@Param("record") DwDataTable record, @Param("example") DwDataTableExample example);

    int updateByExample(@Param("record") DwDataTable record, @Param("example") DwDataTableExample example);
}