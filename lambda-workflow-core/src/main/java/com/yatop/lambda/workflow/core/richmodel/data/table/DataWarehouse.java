package com.yatop.lambda.workflow.core.richmodel.data.table;

import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class DataWarehouse extends DwDataWarehouse implements IRichModel {

    public DataWarehouse(DwDataWarehouse data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
