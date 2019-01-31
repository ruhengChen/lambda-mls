package com.yatop.lambda.workflow.core.mgr.workflow.analyzer;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.*;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.*;

public class SchemaAnalyzerHelper {

    public static boolean supportAnalyzeSchema(Node node) {

        if (!node.isWebNode() && node.haveOutputDataTablePort()) {
            return node.getModuleClazzBean().supportAnalyzeSchema();
        }
        return false;
    }

    public static boolean needAnalyzeNode(Node node) {
        return !node.isWebNode() && node.haveOutputDataTablePort();
    }

    public static boolean needAnalyzeNode(Node node, NodeParameter parameter) {

        if (node.haveOutputDataTablePort() && parameter.getCmptChar().data().getSpecType() == SpecTypeEnum.PARAMETER.getType()) {
            IModuleClazz moduleClazz = node.getModuleClazzBean();
            if (moduleClazz.supportAnalyzeSchema()) {
                TreeSet<CmptChar> cmptCharSet = moduleClazz.reanalyzeSchemaParameterSet();
                return CollectionUtil.contains(cmptCharSet, parameter.getCmptChar());
            }
        }
        return false;
    }

    private static boolean reanalyzeSchemaConditionReady(WorkflowContext workflowContext, IModuleClazz moduleClazz, Node node) {
        {
            //reanalyze schema parameter in warning
            TreeSet<CmptChar> cmptCharSet = moduleClazz.reanalyzeSchemaParameterSet();
            List<NodeParameter> nodeParameters = node.getParameters();
            if (DataUtil.isNotEmpty(nodeParameters)) {
                for (NodeParameter nodeParameter : node.getParameters()) {
                    if (CollectionUtil.contains(cmptCharSet, nodeParameter.getCmptChar()) && nodeParameter.isOccuredWarning())
                        return false;
                }
            }
        }
        {
            //required inputDataTablePort -> nonWebUpstreamPort's schema state is normal
            if(!node.isHeadNode()) {
                if(!node.haveOutputDataTablePort())
                    return false;

                TreeMap<Long, NodePortOutput> upstreamPorts = workflowContext.fetchNonWebUpstreamPorts(node);
                if(DataUtil.isEmpty(upstreamPorts))
                    return false;

                for (NodePortInput inputNodePort : node.getInputDataTablePorts()) {
                    if(inputNodePort.getCmptChar().isRequired()) {
                        NodePortOutput upstreamPort = CollectionUtil.get(upstreamPorts, inputNodePort.data().getNodePortId());
                        if(DataUtil.isNull(upstreamPort) || !upstreamPort.getSchema().isStateNormal()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void analyzeSchema(WorkflowContext workflowContext, Node node) {

        IModuleClazz moduleClazz = node.getModuleClazzBean();
        if (node.haveOutputDataTablePort()) {
            if (moduleClazz.supportAnalyzeSchema()) {
                if(!reanalyzeSchemaConditionReady(workflowContext, moduleClazz, node)) {
                    try {
                        TreeMap<CmptChar, NodeSchema> outSchemas = moduleClazz.analyzeSchema(workflowContext, node);
                        List<NodeSchema> dataPortSchemas = node.getOutputDataTablePortSchemas();
                        if (DataUtil.isNotEmpty(dataPortSchemas)) {
                            for (NodeSchema nodeSchema : dataPortSchemas) {
                                if (!CollectionUtil.containsKey(outSchemas, nodeSchema.getCmptChar()))
                                    nodeSchema.changeState2Empty();
                            }
                        }
                        CollectionUtil.clear(outSchemas);
                    } catch (Exception e) {
                        throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze node data port schema failed -- module-clazz occur error.", "工作流组件分析节点数据端口schema时发生错误", e, node);
                    }
                } else {
                    node.changeSchemas2Empty();
                }
            } else {
                node.changeSchemas2NotSupport();
            }
        }
    }

    public static void searchDownstreamNodes(WorkflowContext workflowContext, Node currentNode, Deque<Node> analyzeStack) {
        if(DataUtil.isNull(currentNode) || !currentNode.needAnalyzeSchema())
            return;

        for(NodePortOutput outputDataPort : currentNode.getOutputDataTablePorts()) {
            //仅数据输出端口为schema changed时，找出端口下游节点
            if(outputDataPort.isSchemaChanged()) {
                List<Node> downstreamNodes = workflowContext.fetchDownstreamNodes(outputDataPort);
                if(DataUtil.isNotEmpty(downstreamNodes)) {
                    for (Node downstreamNode : downstreamNodes) {
                        if(downstreamNode.needAnalyzeSchema())
                            CollectionUtil.offerLast(analyzeStack, downstreamNode);
                    }
                }
            }
        }
    }
}
