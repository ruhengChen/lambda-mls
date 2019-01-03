package com.yatop.lambda.workflow.core.context;

import com.yatop.lambda.core.enums.SpecTypeEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class TaskExecutionContext implements IWorkContext {

    private ExecutionJob job;       //操作关联运行作业
    private ExecutionTask task;     //操作关联运行任务
    private WorkflowContext workflowContext;    //作业内容的工作流上下文
    private Node node;                          //操作关联节点
    private TreeMap<String, CharValue> inputCharValues = new TreeMap<String, CharValue>();         //节点输入内容特征值
    private TreeMap<String, CharValue> outputCharValues = new TreeMap<String, CharValue>();        //节点输出内容特征值
    private TreeMap<String, CharValue> execCharValues = new TreeMap<String, CharValue>();          //节点调用执行特征值
    private TreeMap<String, CharValue> optimizeCharValues = new TreeMap<String, CharValue>();      //节点执行调优参数特征值
    private TreeMap<String, CharValue> parameterCharValues = new TreeMap<String, CharValue>();     //节点组件参数特征值
    private String warningMsg;

    public TaskExecutionContext(ExecutionJob job, ExecutionTask task, WorkflowContext workflowContext, Node node) {
        this.job = job;
        this.task = task;
        this.workflowContext = workflowContext;
        this.node = node;
    }

    @Override
    public void clear() {
        job = null;
        task = null;
        workflowContext = null;
        node = null;
        CollectionUtil.clear(inputCharValues);
        CollectionUtil.clear(outputCharValues);
        CollectionUtil.clear(execCharValues);
        CollectionUtil.clear(optimizeCharValues);
        CollectionUtil.clear(parameterCharValues);
        warningMsg = null;
    }

    public void flush() {
        this.job.flush(workflowContext.getOperId());
        this.task.flush(workflowContext.getOperId());
        this.node.flush(true, true, workflowContext.getOperId());
        this.workflowContext.getWorkflow().flush(workflowContext.getOperId());
    }

    public ExecutionJob getJob() {
        return job;
    }

    public ExecutionTask getTask() {
        return task;
    }

    public WorkflowContext getWorkflowContext() {
        return workflowContext;
    }

    public Node getNode() {
        return node;
    }

    public boolean warningOccoured() {
        return DataUtil.isNotEmpty(getWarningMsg());
    }

    public String getWarningMsg() {
        return warningMsg;
    }

    public void setWarningMsg(String warningMsg) {
        this.warningMsg = warningMsg;
    }

    public int inputCharValueCount() {
        return inputCharValues.size();
    }

    public int outputCharValueCount() {
        return outputCharValues.size();
    }

    public int optimizeCharValueCount() {
        return optimizeCharValues.size();
    }

    public int parameterCharValueCount() {
        return parameterCharValues.size();
    }

    public CharValue getCharValue(CmptChar cmptChar) {
        switch (SpecTypeEnum.valueOf(cmptChar.getSpecType())) {
            case INPUT:
                return inputCharValues.get(cmptChar.getCharId());
            case OUTPUT:
                return outputCharValues.get(cmptChar.getCharId());
            case EXECUTION:
                return execCharValues.get(cmptChar.getCharId());
            case OPTIMIZE_EXECUTION:
                return optimizeCharValues.get(cmptChar.getCharId());
            case PARAMETER:
                return parameterCharValues.get(cmptChar.getCharId());
        }
        return null;
    }

    public List<CharValue> getCharValues(SpecTypeEnum specTypeEnum) {
        switch (specTypeEnum) {
            case INPUT:
                return CollectionUtil.toList(inputCharValues);
            case OUTPUT:
                return CollectionUtil.toList(outputCharValues);
            case EXECUTION:
                return CollectionUtil.toList(execCharValues);
            case OPTIMIZE_EXECUTION:
                return CollectionUtil.toList(optimizeCharValues);
            case PARAMETER:
                return CollectionUtil.toList(parameterCharValues);
        }
        return null;
    }

    public void putCharValue(CmptChar cmptChar, CharValue charValue) {
        switch (SpecTypeEnum.valueOf(cmptChar.getSpecType())) {
            case INPUT:
                CollectionUtil.put(inputCharValues, cmptChar.getCharId(), charValue);
            case OUTPUT:
                CollectionUtil.put(outputCharValues, cmptChar.getCharId(), charValue);
            case EXECUTION:
                CollectionUtil.put(execCharValues, cmptChar.getCharId(), charValue);
            case OPTIMIZE_EXECUTION:
                CollectionUtil.put(optimizeCharValues, cmptChar.getCharId(), charValue);
            case PARAMETER:
                CollectionUtil.put(parameterCharValues, cmptChar.getCharId(), charValue);
        }
    }
}
