package com.yatop.lambda.workflow.core.mgr.workflow.module;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.TreeMap;
import java.util.TreeSet;

public class AnalyzeNodeStateHelper {

    public static void analyzeInputPortAndParameter(WorkflowContext workflowContext, Node node) {
        analyzeInputPortAndParameter(workflowContext, node, false);
    }

    public static void analyzeInputPortAndParameter(WorkflowContext workflowContext, Node node, boolean hintNoLink) {

        if(node.isDeleted())
            return;

        TreeMap<NodePortInput, String> missingInputPorts = new TreeMap<NodePortInput, String>();

        if(!node.isHeadNode()) {
            for(NodePortInput inputPort : node.getInputNodePorts()) {
                if(inputPort.getCmptChar().isRequired()) {
                    if(!hintNoLink) {
                        NodeLink link = workflowContext.fetchNonWebInLink(inputPort);
                        if(DataUtil.isNotNull(link) && !link.isDeleted()) {
                            continue;
                        }
                    }

                    CollectionUtil.put(missingInputPorts, inputPort, String.format("「%s」输入端口未连接", inputPort.getModulePort().data().getPortName()));
                }
            }
        }

        if(DataUtil.isNotEmpty(missingInputPorts)) {
            StringBuilder sb = new StringBuilder().append(String.format("「%s」节点", node.getModule().data().getModuleName()));
            for(String message : CollectionUtil.toList(missingInputPorts)) {
                sb.append(",").append(message);
            }
            node.changeOccuredWarning(sb.toString());
        } else {
            analyzeParameter(workflowContext, node);
        }
    }

    private static void analyzeParameter(WorkflowContext workflowContext, Node node) {

        TreeSet<NodeParameter> missingParameters = new TreeSet<NodeParameter>();
        TreeSet<NodeParameter> warningParameters = new TreeSet<NodeParameter>();

        if (node.parameterCount() > 0) {
            for (NodeParameter parameter : node.getParameters()) {
                if (DataUtil.isEmpty(parameter.data().getCharValue()) && parameter.getCmptChar().isRequired()) {
                    parameter.changeOccuredWarning(String.format("「%s」必填参数缺失", parameter.getCmptChar().data().getDisplayName()));
                    CollectionUtil.add(missingParameters, parameter);
                }
            }

            if (DataUtil.isEmpty(missingParameters)) {
                try {
                    TreeMap<CmptChar, String> warningMessages = node.getModuleClazzBean().checkParameter(workflowContext, node);
                    for (NodeParameter parameter : node.getParameters()) {
                        String warningMessage = CollectionUtil.get(warningMessages, parameter.getCmptChar());
                        if (DataUtil.isNotEmpty(warningMessage)) {
                            parameter.changeOccuredWarning(String.format("「%s」%s", parameter.getCmptChar().data().getDisplayName(), warningMessage));
                            CollectionUtil.add(warningParameters, parameter);
                        } else {
                            parameter.clearOccuredWarning();
                        }
                    }
                    CollectionUtil.clear(warningMessages);
                } catch (Throwable e) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check node parameter failed -- module-clazz occur error.", "节点参数校验时发生错误", e, node);
                }
            }
        }

        if (node.optimizeParameterCount() > 0) {
            for (NodeParameter parameter : node.getOptimizeParameters()) {
                if (DataUtil.isEmpty(parameter.data().getCharValue()) && parameter.getCmptChar().isRequired()) {
                    parameter.changeOccuredWarning(String.format("「%s」必填参数缺失", parameter.getCmptChar().data().getDisplayName()));
                    CollectionUtil.add(missingParameters, parameter);
                } else {
                    parameter.clearOccuredWarning();
                }
            }
        }

        if(DataUtil.isNotEmpty(missingParameters) || DataUtil.isNotEmpty(warningParameters)) {
            StringBuilder sb = new StringBuilder().append(String.format("「%s」节点", node.getModule().data().getModuleName()));
            for(NodeParameter parameter : CollectionUtil.toList(missingParameters)) {
                sb.append(",").append(parameter.data().getWarningMsg());
            }
            for(NodeParameter parameter : CollectionUtil.toList(warningParameters)) {
                sb.append(",").append(parameter.data().getWarningMsg());
            }

            node.changeOccuredWarning(sb.toString());
        } else {
            node.changeState2Ready();
        }
    }
}
