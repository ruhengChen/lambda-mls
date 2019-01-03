package com.yatop.lambda.workflow.core.mgr.workflow.node;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.workflow.core.context.TaskExecutionContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.utils.ClazzHelperUtil;
import org.springframework.stereotype.Service;

@Service
public class NodeTaskExecution {

    public void taskExecution(TaskExecutionContext taskExecutionContext) {

        IModuleClazz moduleClazz = ClazzHelperUtil.getModuleClazzBean(taskExecutionContext.getNode().getModule());
        if (moduleClazz.catchTaskExecution()) {

            try {
                moduleClazz.onTaskExecution(taskExecutionContext);
            } catch (Exception e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Node task execution pre-process failed -- module-clazz occur error.", "工作流组件节点任务运行预处理时发生错误", e, taskExecutionContext.getNode());
            }

            if(taskExecutionContext.warningOccoured()) {
                taskExecutionContext.getTask().setWarningMsg(String.format("任务节点[%s]:%s", taskExecutionContext.getWarningMsg()));
                //taskExecutionContext.getNode().changeNodeState2Error();
            }
        }
    }
}
