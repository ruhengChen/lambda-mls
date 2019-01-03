package com.yatop.lambda.workflow.core.mgr.workflow.node.parameter;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.enums.IsDuplicatedEnum;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.core.mgr.workflow.value.CharValueQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;

@Service
public class ParameterQuery {

    @Autowired
    private NodeParameterMgr nodeParameterMgr;

    @Autowired
    private CharValueQuery charValueQuery;

    private NodeParameter queryParameter(WorkflowContext workflowContext, Node node, CmptChar cmptChar, WfFlowNodeParameter parameter) {

        if(cmptChar.getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource() && DataUtil.isNotNull(parameter)) {
            CharValue charValue = new CharValue(cmptChar, parameter.getCharValue(), IsDuplicatedEnum.valueOf(parameter.getIsDuplicated()));
            charValueQuery.queryCharValue(workflowContext, node, charValue);
            return new NodeParameter(parameter, cmptChar, charValue);
        } else {
            CharValue charValue = new CharValue(cmptChar);
            charValueQuery.queryCharValue(workflowContext, node, charValue);
            return ParameterHelper.simulateParameter(workflowContext, node, charValue);
        }
    }

    public void queryParameters(WorkflowContext workflowContext, Node node) {
        List<WfFlowNodeParameter> nodeParameters = nodeParameterMgr.queryNodeParameter(node.getNodeId());

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
                NodeParameter parameter = queryParameter(workflowContext, node, cmptChar, parameterMap.get(cmptChar.getCharId()));
                node.putParameter(parameter);
            }
        }

        //执行调优参数
        CmptSpec optimizeSpec = component.getOptimizeExecution();
        if(optimizeSpec.cmptCharCount() > 0) {
            for (CmptChar cmptChar : optimizeSpec.getCmptChars()) {
                NodeParameter parameter = queryParameter(workflowContext, node, cmptChar, optimizeMap.get(cmptChar.getCharId()));
                node.putOptimizeParameter(parameter);
            }
        }
        parameterMap.clear();
        optimizeMap.clear();
    }
}
