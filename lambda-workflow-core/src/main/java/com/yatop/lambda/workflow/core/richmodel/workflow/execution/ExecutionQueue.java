package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfExecutionQueue;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ExecutionQueue extends WfExecutionQueue implements IRichModel {

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
