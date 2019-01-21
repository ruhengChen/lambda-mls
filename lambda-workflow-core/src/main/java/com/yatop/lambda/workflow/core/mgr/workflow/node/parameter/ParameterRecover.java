package com.yatop.lambda.workflow.core.mgr.workflow.node.parameter;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.value.CharValueHelper;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;

@Service
public class ParameterRecover {

    @Autowired
    private NodeParameterMgr nodeParameterMgr;

    private NodeParameter recoverParameter(WorkflowContext workflowContext, Node node, CmptChar cmptChar, WfFlowNodeParameter parameter) {

        if(cmptChar.data().getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource() && DataUtil.isNotNull(parameter)) {
            CharValue charValue = new CharValue(cmptChar, parameter.getCharValue());
            CharValueHelper.recoverCharValue(workflowContext, node, charValue);
            return new NodeParameter(parameter, charValue);
        } else {
            CharValue charValue = new CharValue(cmptChar);
            CharValueHelper.queryCharValue(workflowContext, node, charValue);
            return ParameterHelper.simulateParameter(workflowContext, node, charValue);
        }
    }

    public void recoverParameters(WorkflowContext workflowContext, Node node) {

        nodeParameterMgr.recoverNodeParameter(node.data().getNodeId(), workflowContext.getOperId());
        List<WfFlowNodeParameter> nodeParameters = nodeParameterMgr.queryNodeParameter(node.data().getNodeId());

        TreeMap<String, WfFlowNodeParameter> parameterMap = new TreeMap<String, WfFlowNodeParameter>();
        TreeMap<String, WfFlowNodeParameter> optimizeMap = new TreeMap<String, WfFlowNodeParameter>();

        if(DataUtil.isNotEmpty(nodeParameters)) {
            for (WfFlowNodeParameter parameter : nodeParameters) {
                switch (SpecTypeEnum.valueOf(parameter.getSpecType())) {
                    case PARAMETER:
                        parameterMap.put(parameter.getCharId(), parameter);
                        break;
                    case OPTIMIZE_EXECUTION:
                        optimizeMap.put(parameter.getCharId(), parameter);
                        break;
                    default:
                        //TODO throw exception ???
                }
            }
        }

        Component component = node.getComponent();
        //组件参数
        CmptSpec paramSpec = component.getParameter();
        if(paramSpec.cmptCharCount() > 0) {
            for (CmptChar cmptChar : paramSpec.getCmptChars()) {
                NodeParameter parameter = recoverParameter(workflowContext, node, cmptChar, parameterMap.get(cmptChar.data().getCharId()));
                node.putParameter(parameter);
            }
        }

        //执行调优参数
        CmptSpec optimizeSpec = component.getOptimizeExecution();
        if(optimizeSpec.cmptCharCount() > 0) {
            for (CmptChar cmptChar : optimizeSpec.getCmptChars()) {
                NodeParameter parameter = recoverParameter(workflowContext, node, cmptChar, optimizeMap.get(cmptChar.data().getCharId()));
                node.putOptimizeParameter(parameter);
            }
        }
        parameterMap.clear();
        optimizeMap.clear();
    }
}
