package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTaskQueue;
import com.yatop.lambda.core.enums.TaskStateEnum;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class ExecutionTaskQueue extends RichModel<WfExecutionTaskQueue> {

    public ExecutionTaskQueue(WfExecutionTaskQueue data) {
        super(data);
    }

    public void flush(String operId) {

        if (this.isColoured())
            ;//NodeHelper.updateNode(this, operId);
    }

    public void changeState2Running() {
        this.changeTaskState(TaskStateEnum.RUNNING);
    }

    private void changeTaskState(TaskStateEnum stateEnum) {
        if(this.data().getTaskState() == stateEnum.getState())
            return;

        this.data().setTaskState(stateEnum.getState());
    }
}
