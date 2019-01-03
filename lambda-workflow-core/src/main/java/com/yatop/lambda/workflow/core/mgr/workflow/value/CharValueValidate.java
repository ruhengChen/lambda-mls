package com.yatop.lambda.workflow.core.mgr.workflow.value;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
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
public class CharValueValidate {

    //适用组件参数、执行调优参数、调用执行
    // CharValue <[inText] ==>> no/yes>
    public boolean validateCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getSpecType() == SpecTypeEnum.INPUT.getType() || charValue.getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Validate characteristic value failed -- forbid validate input & output char-value.", "不允许输入内容和输出内容的特征值校验", charValue);
        }

        if(DataUtil.isNotEmpty(charValue.getInText())) {
            ICharTypeClazz charTypeClazz = ClazzHelperUtil.getCharTypeClazzBean(charValue.getCmptChar().getType());
            if (charTypeClazz.catchValidateValue()) {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                boolean isPassValidate = charTypeClazz.onValidateValue(charValueContext);
                charValueContext.clear();
                return isPassValidate;
            }
            return true;
        }
        return true;
    }
}
