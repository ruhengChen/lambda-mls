package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.component.chartype.CharDefaultValue;
import com.yatop.lambda.workflow.core.component.chartype.CharValue;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class CharValueContext {
    private WorkflowContext workflowContext;
    private CmptChar cmptChar;
    private CharDefaultValue defaultValue;
    private CharValue charValue;

    public JSONObject toJSON() {
        return null;
    }

    public void clear() {

    }
}
