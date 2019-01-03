package com.yatop.lambda.workflow.core.richmodel.component.specification;

import com.yatop.lambda.base.model.CfCmptSpecCharValue;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class CmptSpecCharValue extends CfCmptSpecCharValue implements IRichModel {

    public CmptSpecCharValue(CfCmptSpecCharValue data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
