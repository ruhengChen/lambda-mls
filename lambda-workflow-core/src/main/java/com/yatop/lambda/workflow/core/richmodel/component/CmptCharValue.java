package com.yatop.lambda.workflow.core.richmodel.component;

import com.yatop.lambda.base.model.CfCmptCharValue;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class CmptCharValue extends CfCmptCharValue implements IRichModel {

    public CmptCharValue(CfCmptCharValue data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
