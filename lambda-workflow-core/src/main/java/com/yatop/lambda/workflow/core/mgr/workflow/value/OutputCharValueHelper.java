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

public class OutputCharValueHelper {

    //适用输出内容
    // CharValue <none ==>> charValue, outObject>
    public void createCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- forbid create non-workflow source level char-value", "不允许非工作流来源级别的特征值创建", charValue);
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
        } else {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create characteristic value failed -- char-type-clazz uncaught output char-value create event.", "系统内部严重错误，请联系管理员", charValue);
        }
    }

    //适用输出内容
    // CharValue <[charValue] ==>> none>
    public void deleteCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

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
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete characteristic value failed -- char-type-clazz occur error.", "计算组件特征值删除时发生错误", e, charValue);
            }
        } else {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete characteristic value failed -- char-type-clazz uncaught output char-value delete event.", "系统内部严重错误，请联系管理员", charValue);
        }
    }

    //适用输出内容
    // CharValue <charValue, inObject ==>> charValue, outObject>
    public static void completeCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        if(charValue.getCmptChar().data().getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- forbid update non-workflow source level char-value", "不允许非工作流来源级别的特征值更新", charValue);
        }

        if(DataUtil.isEmpty(charValue.getCharValue()) || DataUtil.isNull(charValue.getInObject())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- output char-value missing.", "计算组件输出内容特征值/更新内容缺失", charValue);
        }

        ICharTypeClazz charTypeClazz = charValue.getCharTypeClazzBean();
        if (charTypeClazz.catchCompleteValue()) {

            try {
                CharValueContext charValueContext = new CharValueContext(workflowContext, node, charValue);
                charTypeClazz.onCompleteValue(charValueContext);
                charValueContext.clear();
                return;
            } catch (Throwable e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- char-type-clazz occur error.", "计算组件特征值更新时发生错误", e, charValue);
            }
        } else {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update characteristic value failed -- char-type-clazz uncaught output char-value complete event.", "系统内部严重错误，请联系管理员", charValue);
        }
    }

    //适用输出内容
    // CharValue <[charValue] ==>> [outObject]>
    public void queryCharValue(WorkflowContext workflowContext, Node node, CharValue charValue) {

        //已存在传出内容时直接返回
        if(DataUtil.isNotNull(charValue.getOutObject())) {
            return;
        }

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
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query characteristic value failed -- char-type-clazz uncaught input/output char-value query event.", "系统内部严重错误，请联系管理员", charValue);
        }
    }
}
