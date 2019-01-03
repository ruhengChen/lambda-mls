package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.core.enums.JobStateEnum;
import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class ExecutionJob extends WfExecutionJob implements IRichModel {

    public ExecutionJob(WfExecutionJob data) {
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

    public void changeJobState2Queueing() {
        this.changeJobState(JobStateEnum.QUEUEING);
    }

    public void changeJobState2Running() {
        this.changeJobState(JobStateEnum.RUNNING);
    }

    public void changeJobState2Finished() {
        this.changeJobState(JobStateEnum.FINISHED);
    }

    public void changeJobState2ErrorTerminated() {
        this.changeJobState(JobStateEnum.ERROR_TERMINATED);
    }

    public void changeJobState2UserTerminated() {
        this.changeJobState(JobStateEnum.USER_TERMINATED);
    }

    private void changeJobState(JobStateEnum stateEnum) {
        if(this.getJobState() == stateEnum.getState())
            return;

        this.setJobState(stateEnum.getState());
    }
}
