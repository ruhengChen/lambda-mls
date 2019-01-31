package com.yatop.lambda.workflow.core.mgr.workflow.analyzer;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class SchemaAnalyzer4RefreshSchema {

    private static void analyzeOneNode(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack) {

        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        if(!currentNode.isHeadNode()) {
            TreeMap<Long, NodePortOutput> upstreamNonWebPorts = workflowContext.fetchNonWebUpstreamPorts(currentNode);
            for (NodePortInput inputDataPort : currentNode.getInputDataTablePorts()) {
                //仅对必须输入端口的上游端口状态做分析判断
                if (inputDataPort.getCmptChar().isRequired()) {
                    NodePortOutput upstreamDataPort = CollectionUtil.get(upstreamNonWebPorts, inputDataPort.data().getNodePortId());
                    if (DataUtil.isNotNull(upstreamDataPort)) {
                        if (!upstreamDataPort.isDataTablePort())
                            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Schema Analyzer error -- Illegal upstream node port.", "系统数据异常，请联系管理员", upstreamDataPort, inputDataPort);

                        //上游端口已分析，必须输入端口的上游端口schema state不是normal时，直接更改为empty
                        if (upstreamDataPort.isAnalyzed()) {
                            if (!upstreamDataPort.getSchema().isStateNormal()) {
                                currentNode.changeSchemas2Empty();
                                currentNode.markAnalyzed();
                                SchemaAnalyzerHelper.searchDownstreamNodes(workflowContext, currentNode, analyzeStack);
                                return;
                            }

                            //必须输入端口的上游端口schema state为normal时，继续确认下一必须输入端口的上游端口状况
                            continue;
                        } else {
                            //上游必须输入端口未分析，直接跳过返回
                            return;
                        }
                    } else {
                        //必须输入端口无对应数据流入时，无需分析该节点
                        return;
                    }
                }
            }
        }


        SchemaAnalyzerHelper.analyzeSchema(workflowContext, currentNode);
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
