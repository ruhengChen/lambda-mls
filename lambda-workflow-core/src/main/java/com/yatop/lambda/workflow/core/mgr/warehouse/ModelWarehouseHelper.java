package com.yatop.lambda.workflow.core.mgr.warehouse;

import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.model.ModelWarehouseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.data.model.ModelWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelWarehouseHelper {

    private static ModelWarehouseMgr MODEL_WAREHOUSE_MGR;

    @Autowired
    public void setModelWarehouseMgr(ModelWarehouseMgr modelWarehouseMgr) {
        MODEL_WAREHOUSE_MGR = modelWarehouseMgr;
    }

    public static ModelWarehouse queryModelWarehouse(Long modelWarehouseId) {
        MwModelWarehouse modelWarehouse = MODEL_WAREHOUSE_MGR.queryModelWarehouse(modelWarehouseId);
        return new ModelWarehouse(modelWarehouse);
    }

    public static ModelWarehouse queryModelWarehouse(String modelWarehouseCode) {
        MwModelWarehouse modelWarehouse = MODEL_WAREHOUSE_MGR.queryModelWarehouse(modelWarehouseCode);
        if(DataUtil.isNull(modelWarehouse))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query model warehouse failed -- model warehouse not exist.", String.format("模型库不存在:%s", modelWarehouseCode));

        return new ModelWarehouse(modelWarehouse);
    }
}
