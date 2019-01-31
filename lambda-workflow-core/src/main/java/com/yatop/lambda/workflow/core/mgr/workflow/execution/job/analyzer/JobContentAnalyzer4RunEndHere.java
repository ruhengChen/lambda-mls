package com.yatop.lambda.workflow.core.mgr.workflow.execution.job.analyzer;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class JobContentAnalyzer4RunEndHere {

    protected static TreeSet<Node>[] analyzeJobContent(WorkflowContext workflowContext, Node relatedNode) {

        if(DataUtil.isNull(relatedNode) || relatedNode.isWebNode())
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable nodes.", "无可运行节点");

        if(relatedNode.isStateNotReady()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", relatedNode.data().getWarningMsg(), relatedNode);
        }


        //List<Node> allHeadNodes = searchHeadNodes(workflowContext);
        //if(DataUtil.isEmpty(allHeadNodes))
        //    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable node.", "无可运行节点");

        TreeSet<Node> jobHeadNodes = new TreeSet<Node>();
        Deque<Node> analyzeStack = new LinkedList<Node>();
        //for(Node headNode : allHeadNodes) {
        //    CollectionUtil.add(jobHeadNodes, headNode);
        //    CollectionUtil.offerLast(analyzeStack, headNode);
        //}

        TreeSet<Node> jobSubNodes = new TreeSet<Node>();
        analyzeUpstreamNodes(workflowContext, analyzeStack, jobHeadNodes, jobSubNodes);
        return new TreeSet[] {jobHeadNodes, jobSubNodes};
    }

    private static void analyzeUpstreamNodes(WorkflowContext workflowContext, Deque<Node> analyzeStack, TreeSet<Node> jobHeadNodes, TreeSet<Node> jobSubNodes) {

        Node currentNode = null;
        while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
            searchUpstreamNodes(workflowContext, currentNode, analyzeStack, jobHeadNodes, jobSubNodes);
        }
    }

    private static void searchUpstreamNodes(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack, TreeSet<Node> jobHeadNodes, TreeSet<Node> jobSubNodes) {

        if(DataUtil.isNull(currentNode) || currentNode.isHeadNode())
            return;

        for(NodePortInput inputPort : currentNode.getInputNodePorts()) {
            Node upstreamNode = workflowContext.fetchNonWebUpstreamNode(inputPort);

            if (DataUtil.isNull(upstreamNode) && !inputPort.getCmptChar().isRequired()) {
                continue;
            }

            if(DataUtil.isNull(upstreamNode) || upstreamNode.isStateNotReady()) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", upstreamNode.data().getWarningMsg(), upstreamNode);
            }

            if(upstreamNode.isHeadNode()) {
                if(!CollectionUtil.contains(jobHeadNodes, upstreamNode)) {
                    CollectionUtil.add(jobHeadNodes, upstreamNode);
                }
            } else {
                if(!CollectionUtil.contains(jobSubNodes, upstreamNode)) {
                    CollectionUtil.offerLast(analyzeStack, upstreamNode);
                    CollectionUtil.add(jobSubNodes, upstreamNode);
                }
            }
        }
    }
}
