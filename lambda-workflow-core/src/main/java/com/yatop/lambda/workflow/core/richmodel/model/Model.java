package com.yatop.lambda.workflow.core.richmodel.model;

import com.yatop.lambda.base.model.MwModel;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class Model extends MwModel implements IRichModel {
    private ModelWarehouse modelWarehouse;

    public Model() {}

    public Model(MwModel data) {super.copyProperties(data);}

    @Override
    public void clear() {
        modelWarehouse = null;
        super.clear();
    }

    public ModelWarehouse getModelWarehouse() {
        return modelWarehouse;
    }

    public void setModelWarehouse(ModelWarehouse modelWarehouse) {
        this.modelWarehouse = modelWarehouse;
    }
}
