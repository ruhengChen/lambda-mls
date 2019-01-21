package com.yatop.lambda.workflow.core.mgr.workflow.node.parameter;

import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.mgr.workflow.node.NodeParameterMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.value.CharValueHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterDelete {

    @Autowired
    private NodeParameterMgr nodeParameterMgr;

    private void deleteParameter(WorkflowContext workflowContext, Node node, NodeParameter parameter) {

        if(parameter.getCmptChar().data().getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource() && DataUtil.isNotNull(parameter)) {
            CharValueHelper.deleteCharValue(workflowContext, node, parameter.getCharValue());
        }
    }

    public void deleteParameters(WorkflowContext workflowContext, Node node) {

        //组件参数
        if(node.parameterCount() > 0) {
            for (NodeParameter parameter : node.getParameters()) {
                deleteParameter(workflowContext, node, parameter);
            }
        }

        //执行调优参数
        if(node.optimizeParameterCount() > 0) {
            for (NodeParameter parameter : node.getOptimizeParameters()) {
                deleteParameter(workflowContext, node, parameter);
            }
        }

        if(node.parameterCount() > 0 && node.optimizeParameterCount() > 0)
            nodeParameterMgr.deleteNodeParameter(node.data().getNodeId(), workflowContext.getOperId());
    }
}
