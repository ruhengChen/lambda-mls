package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class ExecutionTaskContext implements IWorkContext {

    private WorkflowContext workflowContext;
    private ExecutionTask task;                                                    //操作关联运行任务
    private TreeMap<String, CharValue> inputCharValues = new TreeMap<String, CharValue>();         //输入内容
    private TreeMap<String, CharValue> execCharValues = new TreeMap<String, CharValue>();          //调用执行

    public ExecutionTaskContext(WorkflowContext workflowContext, ExecutionTask task) {
        this.workflowContext = workflowContext;
        this.task = task;
    }

    @Override
    public void clear() {
        workflowContext = null;
        task = null;
        CollectionUtil.clear(inputCharValues);
        CollectionUtil.enhancedClear(execCharValues);
    }

    public ExecutionJob getJob() {
        return workflowContext.getCurrentJob();
    }

    public ExecutionTask getTask() {
        return task;
    }

    public WorkflowContext getWorkflowContext() {
        return workflowContext;
    }

    public Node getNode() {
        return task.getNode();
    }

    public int inputCharValueCount() {
        return inputCharValues.size();
    }

    public int outputCharValueCount() {
        return task.taskOutputCount();
    }

    public int optimizeCharValueCount() {
        return getNode().optimizeParameterCount();
    }

    public int parameterCharValueCount() {
        return getNode().parameterCount();
    }

    public CharValue getCharValue(CmptChar cmptChar) {
        switch (SpecTypeEnum.valueOf(cmptChar.data().getSpecType())) {
            case INPUT:
                return inputCharValues.get(cmptChar.data().getCharId());
            case OUTPUT:
                return task.getOutputCharValue(cmptChar.data().getCharId());
            case EXECUTION:
                return execCharValues.get(cmptChar.data().getCharId());
            case OPTIMIZE_EXECUTION:
                return getNode().getOptimizeParameterCharValue(cmptChar);
            case PARAMETER:
                return getNode().getParameterCharValue(cmptChar);
            default:
                break;
        }
        return null;
    }

    public List<CharValue> getCharValues(SpecTypeEnum specTypeEnum) {
        switch (specTypeEnum) {
            case INPUT:
                return CollectionUtil.toList(inputCharValues);
            case OUTPUT:
                return task.getOutputCharValues();
            case EXECUTION:
                return CollectionUtil.toList(execCharValues);
            case OPTIMIZE_EXECUTION:
                return getNode().getOptimizeParameterCharValues();
            case PARAMETER:
                return getNode().getParameterCharValues();
            default:
                break;
        }
        return null;
    }

    public void putInputCharValue(CharValue charValue) {
        CollectionUtil.put(inputCharValues, charValue.getCmptChar().data().getCharId(), charValue);
    }

    public void putExecutionCharValue(CharValue charValue) {
        CollectionUtil.put(execCharValues, charValue.getCmptChar().data().getCharId(), charValue);
    }
}
