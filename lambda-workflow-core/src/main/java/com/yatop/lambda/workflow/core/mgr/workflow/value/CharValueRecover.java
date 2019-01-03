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
import org.springframework.stereotype.Service;

@Service
public class CharValueRecover {

    //适用组件参数、执行调优参数、输出内容
    // CharValue <[charValue] ==>> charValue, [outText, outObject]>
    public void recoverCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover characteristic value failed -- forbid recover non-workflow source level char-value", "不允许非工作流来源级别的特征值恢复", charValue);
        }

        if(charValue.getSpecType() == SpecTypeEnum.INPUT.getType() || charValue.getSpecType() == SpecTypeEnum.OUTPUT.getType() || charValue.getSpecType() == SpecTypeEnum.EXECUTION.getType()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover characteristic value failed -- forbid recover input & execution char-value.", "不允许输入输出内容和调用执行的特征值恢复", charValue);
        }

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        ICharTypeClazz charTypeClazz = ClazzHelperUtil.getCharTypeClazzBean(charValue.getCmptChar().getType());
        if (charTypeClazz.catchRecoverValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                charTypeClazz.onRecoverValue(charValueContext);
                charValueContext.clear();
                return;
            } catch (Exception e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover characteristic value failed -- char-type-clazz occur error.", "计算组件特征值恢复时发生错误", e, charValue);
            }
        } else if(charValue.getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover characteristic value failed -- char-type-clazz uncaught output char-value recover event.", "系统内部严重错误，请联系管理员", charValue);
        } else if(DataUtil.isNotEmpty(charValue.getCharValue())) {
            charValue.setOutText(charValue.getCharValue());
            return;
        }
        return;
    }
}
