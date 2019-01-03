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
public class CharValueUpdate {

    @Autowired
    private CharValueValidate charValueValidate;

    //适用组件参数、执行调优参数、输出内容
    // CharValue <[charValue, inText] ==>> charValue, [outText, outObject]>
    public void updateCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- forbid update non-workflow source level char-value", "不允许非工作流来源级别的特征值更新", charValue);
        }

        if(charValue.getSpecType() == SpecTypeEnum.INPUT.getType() || charValue.getSpecType() == SpecTypeEnum.EXECUTION.getType()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- forbid update input & execution char-value.", "不允许输入内容和调用执行的特征值更新", charValue);
        }

        if(charValue.getSpecType() != SpecTypeEnum.OUTPUT.getType()) {

            if (DataUtil.isNotEmpty(charValue.getInText()) && !charValueValidate.validateCharValue(workflowContext, node, charValue)){
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- char-value validation failed.", "计算组件特征值验证失败", charValue);

                //原特征值和更新值都为空时
            } else if(DataUtil.isEmpty(charValue.getCharValue()) && DataUtil.isEmpty(charValue.getInText())) {
                return;
            }
        } else { //FOR OUTPUT
            if(DataUtil.isEmpty(charValue.getCharValue()) || DataUtil.isNull(charValue.getInObject())) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- output char-value missing.", "计算组件输出内容特征值/更新内容缺失", charValue);
            }
        }

        ICharTypeClazz charTypeClazz = ClazzHelperUtil.getCharTypeClazzBean(charValue.getCmptChar().getType());
        if (charTypeClazz.catchUpdateValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                charTypeClazz.onUpdateValue(charValueContext);
                charValueContext.clear();
                return;
            } catch (Exception e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- char-type-clazz occur error.", "计算组件特征值更新时发生错误", e, charValue);
            }
        } else if(charValue.getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- char-type-clazz uncaught output char-value update event.", "系统内部严重错误，请联系管理员", charValue);
        } else {
            charValue.setCharValue(charValue.getInText());
            charValue.setOutText(charValue.getInText());
            return;
        }
    }
}
