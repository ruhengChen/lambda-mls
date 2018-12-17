package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfFlowNodeDeleteQueue;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class NodeDelete extends WfFlowNodeDeleteQueue implements IRichModel {

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void clear() {

    }
}
