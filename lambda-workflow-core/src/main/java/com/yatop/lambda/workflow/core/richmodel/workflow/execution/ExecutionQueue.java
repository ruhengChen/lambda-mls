package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.base.model.WfExecutionQueue;
import com.yatop.lambda.core.enums.JobStateEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ExecutionQueue extends WfExecutionQueue implements IRichModel {

    public ExecutionQueue(WfExecutionQueue data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    public void flush(String operId) {

        if (this.isColoured())
            ;//NodeHelper.updateNode(this, operId);
    }

    @Override
    public void clear() {
        super.clear();
    }

    public void changeJobState2Running() {
        this.changeJobState(JobStateEnum.RUNNING);
    }

    private void changeJobState(JobStateEnum stateEnum) {
        if(this.getJobState() == stateEnum.getState())
            return;

        this.setJobState(stateEnum.getState());
    }
}
