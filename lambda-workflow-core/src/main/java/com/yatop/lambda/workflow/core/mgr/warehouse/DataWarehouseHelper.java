package com.yatop.lambda.workflow.core.mgr.warehouse;

import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.table.DataWarehouseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataWarehouseHelper {

    private static DataWarehouseMgr DATA_WAREHOUSE_MGR;

    @Autowired
    public void setDataWarehouseMgr(DataWarehouseMgr dataWarehouseMgr) {
        DATA_WAREHOUSE_MGR = dataWarehouseMgr;
    }

    public static DataWarehouse queryDataWarehouse(Long dataWarehouseId) {
        DwDataWarehouse dataWarehouse = DATA_WAREHOUSE_MGR.queryDataWarehouse(dataWarehouseId);
        return new DataWarehouse(dataWarehouse);
    }

    public static DataWarehouse queryDataWarehouse(String dataWarehouseCode) {
        DwDataWarehouse dataWarehouse = DATA_WAREHOUSE_MGR.queryDataWarehouse(dataWarehouseCode);
        if(DataUtil.isNull(dataWarehouse))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query data warehouse failed -- data warehouse not exist.", String.format("数据库不存在:%s", dataWarehouseCode));

        return new DataWarehouse(dataWarehouse);
    }
}
