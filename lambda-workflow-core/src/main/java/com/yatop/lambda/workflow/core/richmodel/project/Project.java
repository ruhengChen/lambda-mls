package com.yatop.lambda.workflow.core.richmodel.project;

import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.workflow.core.richmodel.data.table.DataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.data.model.ModelWarehouse;

public class Project extends PrProject implements IRichModel {
    private DataWarehouse dataWarehouse;    //项目数据库
    private ModelWarehouse modelWarehouse;  //项目模型库

    public Project(PrProject data, DataWarehouse dataWarehouse, ModelWarehouse modelWarehouse) {
        super.copyProperties(data);
        this.dataWarehouse = dataWarehouse;
        this.modelWarehouse = modelWarehouse;
        this.clearColoured();
    }

    @Override
    public void clear() {
        dataWarehouse = null;
        modelWarehouse = null;
        super.clear();
    }

    public DataWarehouse getDataWarehouse() {
        return dataWarehouse;
    }

    public ModelWarehouse getModelWarehouse() {
        return modelWarehouse;
    }
}
