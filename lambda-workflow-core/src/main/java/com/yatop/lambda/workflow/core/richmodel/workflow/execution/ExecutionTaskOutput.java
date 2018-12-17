package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfExecutionTaskOutput;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ExecutionTaskOutput extends WfExecutionTaskOutput implements IRichModel {

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
