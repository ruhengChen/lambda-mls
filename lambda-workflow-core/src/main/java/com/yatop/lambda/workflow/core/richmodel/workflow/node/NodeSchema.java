package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class NodeSchema extends WfFlowNodeSchema implements IRichModel {

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
