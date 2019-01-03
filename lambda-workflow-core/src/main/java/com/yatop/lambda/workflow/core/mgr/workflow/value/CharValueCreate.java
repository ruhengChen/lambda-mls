package com.yatop.lambda.workflow.core.mgr.workflow.value;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.utils.ClazzHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharValueCreate {

    @Autowired
    private CharValueValidate charValueValidate;

    //适用组件参数、执行调优参数、输出内容
    // CharValue <[inText] ==>> charValue, [outText, outObject]>
    public void createCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- forbid create non-workflow source level char-value", "不允许非工作流来源级别的特征值创建", charValue);
        }

        if(charValue.getSpecType() == SpecTypeEnum.INPUT.getType() || charValue.getSpecType() == SpecTypeEnum.EXECUTION.getType()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- forbid create input & execution char-value.", "不允许输入内容和调用执行的特征值创建", charValue);
        }

        if(charValue.getSpecType() != SpecTypeEnum.OUTPUT.getType()) {
            if (DataUtil.isEmpty(charValue.getInText()))
                charValue.setInText(node.getComponent().getConfigCharValue(charValue.getCmptChar()));

            if (DataUtil.isNotNull(charValue.getInText()) && !charValueValidate.validateCharValue(workflowContext, node, charValue)){
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- char-value validation failed.", "计算组件特征值验证失败", charValue);
            }
        }

        ICharTypeClazz charTypeClazz = ClazzHelperUtil.getCharTypeClazzBean(charValue.getCmptChar().getType());
        if (charTypeClazz.catchCreateValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                charTypeClazz.onCreateValue(charValueContext);
                charValueContext.clear();
                return;
            } catch (Exception e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- char-type-clazz occur error.", "计算组件特征值创建时发生错误", e, charValue);
            }
        } else if(charValue.getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- char-type-clazz uncaught output char-value create event.", "系统内部严重错误，请联系管理员", charValue);
        } else if(DataUtil.isNotEmpty(charValue.getInText())) {
            charValue.setCharValue(charValue.getInText());
            charValue.setOutText(charValue.getInText());
            return;
        }
        return;
    }
}
