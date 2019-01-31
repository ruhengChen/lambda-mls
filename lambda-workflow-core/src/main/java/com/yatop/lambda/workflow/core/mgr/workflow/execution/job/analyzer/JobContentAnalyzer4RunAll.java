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

public class JobContentAnalyzer4RunAll {

    protected static TreeSet<Node>[] analyzeJobContent(WorkflowContext workflowContext) {

        //TODO 改为简单点，直接在search node过程中构建wait-head-nodes和wait-nodes ?

        List<Node> allHeadNodes = searchHeadNodes(workflowContext);
        if(DataUtil.isEmpty(allHeadNodes))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- no executable nodes.", "无可运行节点");

        TreeSet<Node> jobHeadNodes = new TreeSet<Node>();
        Deque<Node> analyzeStack = new LinkedList<Node>();
        for(Node headNode : allHeadNodes) {
            CollectionUtil.add(jobHeadNodes, headNode);
            CollectionUtil.offerLast(analyzeStack, headNode);
        }

        TreeSet<Node> jobSubNodes = new TreeSet<Node>();
        analyzeDownstreamNodes(workflowContext, analyzeStack, jobSubNodes);
        return new TreeSet[] {jobHeadNodes, jobSubNodes};
    }

    private static void analyzeDownstreamNodes(WorkflowContext workflowContext, Deque<Node> analyzeStack, TreeSet<Node> jobSubNodes) {

        Node currentNode = null;
        while(DataUtil.isNotNull(currentNode = CollectionUtil.pollLast(analyzeStack))) {
            searchDownstreamNodes(workflowContext, currentNode, analyzeStack, jobSubNodes);
        }
    }

    private static void searchDownstreamNodes(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack, TreeSet<Node> jobSubNodes) {

        if(DataUtil.isNull(currentNode) || currentNode.isTailNode())
            return;

        for(NodePortOutput outputPort : currentNode.getOutputNodePorts()) {
            List<Node> downstreamNodes = workflowContext.fetchNonWebDownstreamNodes(outputPort);
            if(DataUtil.isNotEmpty(downstreamNodes)) {
                for (Node downstreamNode : downstreamNodes) {
                    if(downstreamNode.isStateNotReady()) {
                        throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", downstreamNode.data().getWarningMsg(), downstreamNode);
                    }

                    if(!isUpstreamNodeExecutionConditionReady(workflowContext, downstreamNode))
                        continue;

                    if(!CollectionUtil.contains(jobSubNodes, downstreamNode)) {
                        CollectionUtil.add(jobSubNodes, downstreamNode);
                        if(!downstreamNode.isTailNode()) {
                            CollectionUtil.offerLast(analyzeStack, downstreamNode);
                        }
                    }
                }
            }
        }
    }

    private static boolean isUpstreamNodeExecutionConditionReady(WorkflowContext workflowContext, Node currentNode) {
        if(!currentNode.isHeadNode()) {
            for (NodePortInput inputPort : currentNode.getInputNodePorts()) {

                Node upstreamNode = workflowContext.fetchNonWebUpstreamNode(inputPort);
                if (DataUtil.isNull(upstreamNode) && inputPort.getCmptChar().isRequired()) {
                    return false;
                }
                if (DataUtil.isNotNull(upstreamNode) && upstreamNode.isStateNotReady()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Node> searchHeadNodes(WorkflowContext workflowContext) {
        if(workflowContext.nodeCount() == 0)
            return null;

        List<Node> headNodes = new ArrayList<Node>();
        for(Node node : workflowContext.getNodes()) {
            if(node.isStateNotReady()) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- node not ready.", node.data().getWarningMsg(), node);
            }

            if(node.isHeadNode() && !node.isWebNode()) {
                headNodes.add(node);
            }
        }
        return headNodes;
    }
}
