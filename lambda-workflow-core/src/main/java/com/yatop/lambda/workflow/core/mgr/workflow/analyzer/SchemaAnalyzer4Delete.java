package com.yatop.lambda.workflow.core.mgr.workflow.analyzer;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class SchemaAnalyzer4Delete {

    public static List<Node> searchDownstreamNodes4DeleteNode(WorkflowContext workflowContext, Node deleteNode) {
        if(DataUtil.isNull(deleteNode))
            return null;

        TreeMap<Long, Node> downstreamNodes = new TreeMap<Long, Node>();
        for(NodePortOutput outputDataPort : deleteNode.getOutputDataTablePorts()) {
            List<Node> nodes = workflowContext.fetchDownstreamNodes(outputDataPort);
            if(DataUtil.isNotEmpty(downstreamNodes)) {
                for (Node downstreamNode : nodes) {
                    if(downstreamNode.needAnalyzeSchema())
                        CollectionUtil.put(downstreamNodes, downstreamNode.data().getNodeId(), downstreamNode);
                }
            }
        }

        return CollectionUtil.toList(downstreamNodes);
    }

    private static void analyzeOneNode(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack) {
        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        currentNode.changeSchemas2Empty();
        currentNode.markAnalyzed();
        SchemaAnalyzerHelper.searchDownstreamNodes(workflowContext, currentNode, analyzeStack);
    }

    private static void analyzeStackNodes(WorkflowContext workflowContext, Deque<Node> analyzeStack) {
        Node currentNode = null;
        while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
            analyzeOneNode(workflowContext, currentNode, analyzeStack);
        }
    }

    public static void analyzeStartNode(WorkflowContext workflowContext, Node startNode) {

        Deque<Node> analyzeStack = new LinkedList<Node>();
        analyzeOneNode(workflowContext, startNode, analyzeStack);
        analyzeStackNodes(workflowContext, analyzeStack);
    }
}
