package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.base.model.DwDataWarehouseExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwDataWarehouseMapper extends MyMapper<DwDataWarehouse> {
    int countByExample(DwDataWarehouseExample example);

    int deleteByExample(DwDataWarehouseExample example);

    List<DwDataWarehouse> selectByExample(DwDataWarehouseExample example);

    int updateByExampleSelective(@Param("record") DwDataWarehouse record, @Param("example") DwDataWarehouseExample example);

    int updateByExample(@Param("record") DwDataWarehouse record, @Param("example") DwDataWarehouseExample example);
}