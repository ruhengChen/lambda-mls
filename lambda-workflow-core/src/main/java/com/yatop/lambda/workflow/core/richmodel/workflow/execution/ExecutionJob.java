package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.core.enums.JobStateEnum;
import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;

import java.util.TreeSet;

public class ExecutionJob extends RichModel<WfExecutionJob> {

    private Snapshot snapshot;
    private TreeSet<Long> jobContent = new TreeSet<Long>(); //作业内容，nodeId列表

    public ExecutionJob(WfExecutionJob data) {
        super(data);
    }

    public void flush(String operId) {

        //Update job, snapshot
        if(this.enableFlushSnapshot())
            this.getSnapshot().flush(operId);

        if (this.isColoured())
            ;
    }

    @Override
    public void clear() {
        super.clear();
        snapshot.clear();
        jobContent.clear();
    }

    public boolean isStatePreparing() {
        return this.data().getJobState() == JobStateEnum.PREPARING.getState();
    }

    public boolean isStateQueueing() {
        return this.data().getJobState() == JobStateEnum.QUEUEING.getState();
    }

    public boolean isStateRunning() {
        return this.data().getJobState() == JobStateEnum.RUNNING.getState();
    }

    public boolean isStateSuccess() {
        return this.data().getJobState() == JobStateEnum.SUCCESS.getState();
    }

    public boolean isStateErrorTerminated() {
        return this.data().getJobState() == JobStateEnum.ERROR_TERMINATED.getState();
    }

    public boolean isStateUserTerminated() {
        return this.data().getJobState() == JobStateEnum.USER_TERMINATED.getState();
    }

    public void changeState2Queueing() {
        this.changeJobState(JobStateEnum.QUEUEING);
    }

    public void changeState2Running() {
        this.changeJobState(JobStateEnum.RUNNING);
    }

    public void changeState2Success() {
        this.changeJobState(JobStateEnum.SUCCESS);
    }

    public void changeState2ErrorTerminated() {
        this.changeJobState(JobStateEnum.ERROR_TERMINATED);
    }

    public void changeState2UserTerminated() {
        this.changeJobState(JobStateEnum.USER_TERMINATED);
    }

    private void changeJobState(JobStateEnum stateEnum) {
        if(this.data().getJobState() == stateEnum.getState())
            return;

        this.data().setJobState(stateEnum.getState());
    }

    public boolean enableFlushWorkflow() {
        return JobTypeEnum.enableFlushWorkflow(JobTypeEnum.valueOf(this.data().getJobType()));
    }

    public boolean enableFlushSnapshot() {
        return JobTypeEnum.enableFlushSnapshot(JobTypeEnum.valueOf(this.data().getJobType()));
    }

    public Snapshot getSnapshot() {
        if(DataUtil.isNull(snapshot)) {
            snapshot = SnapshotHelper.querySnapshot(this);
        }
        return snapshot;
    }
}
