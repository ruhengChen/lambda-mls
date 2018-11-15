package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.base.model.MwModelWarehouseExample;
import com.yatop.lambda.base.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MwModelWarehouseMapper extends MyMapper<MwModelWarehouse> {
    int countByExample(MwModelWarehouseExample example);

    int deleteByExample(MwModelWarehouseExample example);

    List<MwModelWarehouse> selectByExample(MwModelWarehouseExample example);

    int updateByExampleSelective(@Param("record") MwModelWarehouse record, @Param("example") MwModelWarehouseExample example);

    int updateByExample(@Param("record") MwModelWarehouse record, @Param("example") MwModelWarehouseExample example);
}