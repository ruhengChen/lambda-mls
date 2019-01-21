package com.yatop.lambda.workflow.core.mgr.workflow.analyzer;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.context.WorkflowContextHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;

import java.util.*;

public class SchemaAnalyzer {

    public static void dealAnalyzeSchema(WorkflowContext workflowContext) {
        switch (workflowContext.getAnalyzeType()) {
            case CREATE_NODE:
                dealAnalyzeSchema4CreateNode(workflowContext);
                break;
            case CREATE_LINK:
                dealAnalyzeSchema4CreateLink(workflowContext);
                break;
            case UPDATE_NODE_PARAMETER:
                dealAnalyzeSchema4UpdateNodeParameter(workflowContext);
                break;
            case DELETE_NODE:
                dealAnalyzeSchema4DeleteNode(workflowContext);
                break;
            case DELETE_LINK:
                dealAnalyzeSchema4DeleteLink(workflowContext);
                break;
            case REFRESH_SCHEMA:
                dealAnalyzeSchema4RefreshSchema(workflowContext);
                break;
            default:
                break;
        }
    }

    private static void dealAnalyzeSchema4CreateNode(WorkflowContext workflowContext) {

        Node analyzeNode = null;
        while(DataUtil.isNotNull(analyzeNode = workflowContext.popAnalyzeNode())) {

            //非头结点创建时schema已经初始化为empty，这里仅对头结点schema做分析
            if(analyzeNode.needAnalyzeSchema() && analyzeNode.isHeadNode() && !analyzeNode.isAnalyzed()) {
                SchemaAnalyzerHelper.analyzeSchema(workflowContext, analyzeNode);
                analyzeNode.markAnalyzed();
            }
        }
    }

    private static void dealAnalyzeSchema4CreateLink(WorkflowContext workflowContext) {
        NodeLink analyzeLink = workflowContext.popAnalyzeLink();
        if(DataUtil.isNotNull(analyzeLink) && !analyzeLink.isWebLink()) {
            Node analyzeNode = workflowContext.fetchDownstreamNode(analyzeLink);
            SchemaAnalyzer4CreateAndUpdate.analyzeStartNode(workflowContext, analyzeNode);
        }
    }

    private static void dealAnalyzeSchema4UpdateNodeParameter(WorkflowContext workflowContext) {
        Node analyzeNode = workflowContext.popAnalyzeNode();
        SchemaAnalyzer4CreateAndUpdate.analyzeStartNode(workflowContext, analyzeNode);
    }

    private static void dealAnalyzeSchema4DeleteNode(WorkflowContext workflowContext) {

        Node deleteNode = null;
        while (DataUtil.isNotNull(deleteNode = workflowContext.popAnalyzeNode())) {
            if(SchemaAnalyzerHelper.needAnalyzeNode(deleteNode)) {
                List<Node> downstreamNodes =  SchemaAnalyzer4Delete.searchDownstreamNodes4DeleteNode(workflowContext, deleteNode);
                if(DataUtil.isNotEmpty(downstreamNodes)) {
                    for(Node downstreamNode : downstreamNodes)
                        SchemaAnalyzer4Delete.analyzeStartNode(workflowContext, downstreamNode);
                }
            }
        }
    }

    private static void dealAnalyzeSchema4DeleteLink(WorkflowContext workflowContext) {

        NodeLink deleteLink = null;
        while(DataUtil.isNotNull(deleteLink = workflowContext.popAnalyzeLink())) {
            if(!deleteLink.isWebLink()) {
                Node downstreamNode = workflowContext.fetchDownstreamNode(deleteLink);
                SchemaAnalyzer4Delete.analyzeStartNode(workflowContext, downstreamNode);
            }
        }
    }

    private static void dealAnalyzeSchema4RefreshSchema(WorkflowContext workflowContext) {

        List<Node> headNodes = WorkflowContextHelper.searchHeadNodes(workflowContext);
        if(DataUtil.isNotEmpty(headNodes)) {
            for(Node headNode : headNodes) {
                if(SchemaAnalyzerHelper.needAnalyzeNode(headNode))
                    SchemaAnalyzer4RefreshSchema.analyzeStartNode(workflowContext, headNode);
            }
        }
    }
}
