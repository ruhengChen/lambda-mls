package com.yatop.lambda.workflow.core.richmodel.component;

import com.yatop.lambda.base.model.CfCmptAlgorithm;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class CmptAlgorithm extends CfCmptAlgorithm implements IRichModel {

    public CmptAlgorithm(CfCmptAlgorithm data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
