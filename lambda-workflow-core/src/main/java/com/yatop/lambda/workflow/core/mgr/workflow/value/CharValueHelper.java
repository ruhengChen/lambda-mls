package com.yatop.lambda.workflow.core.mgr.workflow.value;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SourceLevelEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharValueHelper {

    public static Logger logger = LoggerFactory.getLogger(CharValueHelper.class);

    //适用组件参数、执行调优参数
    // CharValue <[inText] ==>> charValue, [outText]>
    public static void createCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- forbid create non-workflow source level char-value", "不允许非工作流来源级别的特征值创建", charValue);
        }

        if (DataUtil.isEmpty(charValue.getInText()))
            charValue.setInText(node.getComponent().getConfigCharValue(charValue.getCmptChar()));

        if (DataUtil.isNotNull(charValue.getInText()) && !validateCharValue(workflowContext, node, charValue)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- char-value validation failed.", "传入内容验证失败", charValue);
        }

        ICharTypeClazz charTypeClazz = charValue.getCharTypeClazzBean();
        if (charTypeClazz.catchCreateValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                charTypeClazz.onCreateValue(charValueContext);
                charValueContext.clear();
                return;
            } catch (Throwable e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- char-type-clazz occur error.", "计算组件特征值创建时发生错误", e, charValue);
            }
        } else if(DataUtil.isNotEmpty(charValue.getInText())) {
            charValue.setCharValue(charValue.getInText());
            charValue.setOutText(charValue.getInText());
            return;
        }
    }

    //适用组件参数、执行调优参数
    // CharValue <[charValue] ==>> none>
    public static void deleteCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete characteristic value failed -- forbid delete non-workflow source level char-value", "不允许非工作流来源级别的特征值删除", charValue);
        }

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        ICharTypeClazz charTypeClazz = charValue.getCharTypeClazzBean();
        if (charTypeClazz.catchDeleteValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                charTypeClazz.onDeleteValue(charValueContext);
                charValueContext.clear();
                return;
            } catch (Throwable e) {
                e = new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete characteristic value failed -- char-type-clazz occur error.", "计算组件特征值删除时发生错误", e, charValue);
                logger.error("系统内部发生错误", e);
            }
        }
    }

    //适用组件参数、执行调优参数、调用执行
    // CharValue <[charValue] ==>> [outText]>
    public static void queryCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        //已存在传出内容时直接返回
        if(DataUtil.isNotEmpty(charValue.getOutText())) {
            return;
        }

        if (DataUtil.isEmpty(charValue.getCharValue()))
            charValue.setCharValue(node.getComponent().getConfigCharValue(charValue.getCmptChar()));

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        ICharTypeClazz charTypeClazz = charValue.getCharTypeClazzBean();
        if (charTypeClazz.catchQueryValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                charTypeClazz.onQueryValue(charValueContext);
                charValueContext.clear();
                return;
            } catch (Throwable e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query characteristic value failed -- char-type-clazz occur error.", "计算组件特征值查询时发生错误", e, charValue);
            }
        } else {
            charValue.setOutText(charValue.getCharValue());
            return;
        }
    }

    //适用组件参数、执行调优参数
    // CharValue <[charValue] ==>> charValue, [outText]>
    public static void recoverCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover characteristic value failed -- forbid recover non-workflow source level char-value", "不允许非工作流来源级别的特征值恢复", charValue);
        }

        if(DataUtil.isEmpty(charValue.getCharValue())) {
            return;
        }

        ICharTypeClazz charTypeClazz = charValue.getCharTypeClazzBean();
        if (charTypeClazz.catchRecoverValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                charTypeClazz.onRecoverValue(charValueContext);
                charValueContext.clear();
                return;
            } catch (Throwable e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover characteristic value failed -- char-type-clazz occur error.", "计算组件特征值恢复时发生错误", e, charValue);
            }
        } else if(DataUtil.isNotEmpty(charValue.getCharValue())) {
            charValue.setOutText(charValue.getCharValue());
            return;
        }
        return;
    }

    //适用组件参数、执行调优参数
    // CharValue <[charValue, inText] ==>> [charValue, outText]>
    public static void updateCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- forbid update non-workflow source level char-value", "不允许非工作流来源级别的特征值更新", charValue);
        }

        if (DataUtil.isNotEmpty(charValue.getInText()) && !validateCharValue(workflowContext, node, charValue)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- char-value validation failed.", "传入内容验证失败", charValue);

            //原特征值和更新值都为空时
        } else if(DataUtil.isEmpty(charValue.getCharValue()) && DataUtil.isEmpty(charValue.getInText())) {
            return;
        }

        ICharTypeClazz charTypeClazz = charValue.getCharTypeClazzBean();
        if (charTypeClazz.catchUpdateValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                charTypeClazz.onUpdateValue(charValueContext);
                charValueContext.clear();
                return;
            } catch (Throwable e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- char-type-clazz occur error.", "计算组件特征值更新时发生错误", e, charValue);
            }
        } else {
            charValue.setCharValue(charValue.getInText());
            charValue.setOutText(charValue.getInText());
            return;
        }
    }

    //适用组件参数、执行调优参数、调用执行
    // CharValue <[inText] ==>> true/false>
    public static boolean validateCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(DataUtil.isNotEmpty(charValue.getInText())) {
            ICharTypeClazz charTypeClazz = charValue.getCharTypeClazzBean();
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
