package com.yatop.lambda.workflow.core.mgr.workflow.node.parameter;

import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.enums.WorkflowStateEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeParameterCheck;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import com.yatop.lambda.workflow.core.mgr.workflow.value.CharValueUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterCharValueUpdate {

    @Autowired
    private CharValueUpdate charValueUpdate;

    @Autowired
    private ParameterCreate parameterCreate;

    @Autowired
    private NodeParameterCheck nodeParameterCheck;

    private NodeParameter updateParameter(WorkflowContext workflowContext, Node node, NodeParameter targetParameter, String charValueText, Class<ParameterCharValueUpdate> none) {

        if(targetParameter.getCmptChar().getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource()) {
            if(!targetParameter.isSimulateParameter()) {
                if(DataUtil.isEmpty(targetParameter.getCharValue()) && DataUtil.isEmpty(charValueText))
                    return targetParameter;

                CharValue charValue = targetParameter.getValue();
                charValue.setInText(charValueText);
                charValueUpdate.updateCharValue(workflowContext, node, charValue);

                targetParameter.setCharValue(DataUtil.isNotEmpty(charValue.getCharValue()) ? charValue.getCharValue() : null);
                return targetParameter;
            } else {
                return parameterCreate.createParameter(workflowContext, node, targetParameter.getCmptChar(), charValueText);
            }
        } else {
            //TODO throw exception ???
            return null;
        }
    }

    public void updateParameter(WorkflowContext workflowContext, Node node, NodeParameter targetParameter, String charValueText) {

        switch (SpecTypeEnum.valueOf(targetParameter.getSpecType())) {
            case PARAMETER: {
                NodeParameter parameter = updateParameter(workflowContext, node, targetParameter, charValueText, ParameterCharValueUpdate.class);
                node.putParameter(parameter);
                break;
            }
            case OPTIMIZE_EXECUTION: {
                NodeParameter parameter = updateParameter(workflowContext, node, targetParameter, charValueText, ParameterCharValueUpdate.class);
                node.putOptimizeParameter(parameter);
                break;
            }
            default:
                //TODO throw exception ???
        }

        nodeParameterCheck.checkParameter(workflowContext, node);
        node.downgradeNodeState2Ready();
        workflowContext.getWorkflow().changeWorkflowState2Draft();
    }
}
