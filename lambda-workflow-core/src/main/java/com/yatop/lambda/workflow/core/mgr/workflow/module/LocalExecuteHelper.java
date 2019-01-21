package com.yatop.lambda.workflow.core.mgr.workflow.module;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class LocalExecuteHelper {

    public static Logger logger = LoggerFactory.getLogger(LocalExecuteHelper.class);

    public static void execute(ExecutionTaskContext context) {

        Timestamp startTime = SystemTimeUtil.getCurrentTimeMillis();
        IModuleClazz moduleClazz = context.getNode().getModuleClazzBean();
        try {
            moduleClazz.execute(context);
        } catch (Throwable e) {
            e = new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Local execute task failed -- module-clazz occur error.", "本地运行时发生错误", e, context.getTask());
            logger.error("系统内部发生错误", e);
            context.getTask().setOccuredWarning("本地运行时发生错误");
        }
        Timestamp endTime = SystemTimeUtil.getCurrentTimeMillis();
        context.getTask().data().setTaskStartTime(startTime);
        context.getTask().data().setTaskEndTime(endTime);
        context.getTask().data().setCostTime(endTime.getTime() - startTime.getTime());
        if(!context.getTask().isOccuredWarning()) {
            context.getTask().changeState2Success();
        }
    }
}
