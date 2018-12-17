package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ExecutionJob extends WfExecutionJob implements IRichModel {

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
