package com.yatop.lambda.workflow.core.richmodel.component.characteristic;

import com.yatop.lambda.base.model.CfCmptCharEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class CmptCharEnum extends CfCmptCharEnum implements IRichModel {

    public CmptCharEnum(CfCmptCharEnum data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
