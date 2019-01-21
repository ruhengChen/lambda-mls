package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionJobQueue;
import com.yatop.lambda.core.enums.JobStateEnum;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class ExecutionJobQueue extends RichModel<WfExecutionJobQueue> {

    public ExecutionJobQueue(WfExecutionJobQueue data) {
        super(data);
    }

    public void flush(String operId) {

        if (this.isColoured())
            ;//NodeHelper.updateNode(this, operId);
    }

    public void changeState2Running() {
        this.changeJobState(JobStateEnum.RUNNING);
    }

    private void changeJobState(JobStateEnum stateEnum) {
        if(this.data().getJobState() == stateEnum.getState())
            return;

        this.data().setJobState(stateEnum.getState());
    }
}
