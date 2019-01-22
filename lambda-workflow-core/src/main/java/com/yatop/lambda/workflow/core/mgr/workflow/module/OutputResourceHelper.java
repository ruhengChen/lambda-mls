package com.yatop.lambda.workflow.core.mgr.workflow.module;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OutputResourceHelper {

    public static Logger logger = LoggerFactory.getLogger(OutputResourceHelper.class);

    public static void prepareOutputResource(WorkflowContext workflowContext, ExecutionTask task) {

        IModuleClazz moduleClazz = task.getNode().getModuleClazzBean();
        try {
            moduleClazz.prepareOutputResource(workflowContext,task);
        } catch (Throwable e) {
            e = new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Prepare task execution output resource failed -- module-clazz occur error.", "准备输出资源时发生错误", e, task);
            logger.error("系统内部发生错误", e);
            task.setOccuredWarning("准备输出资源时发生错误");
        }
    }

    public static void completeOutputResource(WorkflowContext workflowContext, ExecutionTask task) {

        IModuleClazz moduleClazz = task.getNode().getModuleClazzBean();
        try {
            moduleClazz.completeOutputResource(workflowContext,task);
        } catch (Throwable e) {
            e = new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Complete task execution output resource failed -- module-clazz occur error.", "完成输出资源时发生错误", e, task);
            logger.error("系统内部发生错误", e);
            task.setOccuredWarning("完成输出资源时发生错误");
        }
    }

    public static void clearOutputResource(WorkflowContext workflowContext, ExecutionTask task) {

        IModuleClazz moduleClazz = task.getNode().getModuleClazzBean();
        try {
            moduleClazz.clearOutputResource(workflowContext,task);
        } catch (Throwable e) {
            e = new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Clear task execution output resource failed -- module-clazz occur error.", "清理输出资源时发生错误", e, task);
            logger.error("系统内部发生错误", e);
        }
    }

    public static boolean exploreOutputResource(WorkflowContext workflowContext, ExecutionTask task) {

        IModuleClazz moduleClazz = task.getNode().getModuleClazzBean();
        try {
            moduleClazz.exploreOutputResource(workflowContext, task);
            return true;
        } catch (Throwable e) {
            e = new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Explore task execution output resource failed -- module-clazz occur error.", "探测输出资源时发生错误", e, task);
            logger.error("系统内部发生错误", e);
            //task.setOccuredWarning("探测输出资源时发生错误");
            return false;
        }
    }
}
