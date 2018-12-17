package com.yatop.lambda.workflow.core.context;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class WorkflowSchemaContext {
    private WorkflowContext workflowContext;
    private Node node;
    private List<NodeSchema> changeSchemas = new ArrayList<NodeSchema>();

    public JSONObject toJSON() {
        return null;
    }

    public void clear() {

    }
}
