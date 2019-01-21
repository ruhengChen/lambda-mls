package com.yatop.lambda.workflow.core.mgr.workflow.node.parameter;

import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.module.ParameterCheckHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.value.CharValueHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterCharValueUpdate {

    @Autowired
    private ParameterCreate parameterCreate;

    private NodeParameter updateParameter(WorkflowContext workflowContext, Node node, NodeParameter targetParameter, String charValueText, Class<ParameterCharValueUpdate> none) {

        if(targetParameter.getCmptChar().data().getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource()) {
            if(!targetParameter.isSimulateParameter()) {
                if(DataUtil.isEmpty(targetParameter.data().getCharValue()) && DataUtil.isEmpty(charValueText))
                    return targetParameter;

                CharValue charValue = targetParameter.getCharValue();
                charValue.setInText(charValueText);
                CharValueHelper.updateCharValue(workflowContext, node, charValue);

                targetParameter.data().setCharValue(DataUtil.isNotEmpty(charValue.getCharValue()) ? charValue.getCharValue() : null);
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

        switch (SpecTypeEnum.valueOf(targetParameter.data().getSpecType())) {
            case PARAMETER: {
                NodeParameter parameter = updateParameter(workflowContext, node, targetParameter, charValueText, ParameterCharValueUpdate.class);
                node.putParameter(parameter);
                ParameterCheckHelper.checkParameter(workflowContext, node);
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
        workflowContext.doneUpdateNodeParameter(node, targetParameter);
    }
}
