package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.core.enums.JobStateEnum;
import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;

import java.util.TreeSet;

public class ExecutionJob extends RichModel<WfExecutionJob> {

    private boolean isViewMode;
    private Snapshot snapshot;
    private TreeSet<Long> jobContent = new TreeSet<Long>(); //作业内容，nodeId列表

    public ExecutionJob(WfExecutionJob data) {
        this(data, false);
    }

    public ExecutionJob(WfExecutionJob data, boolean isViewMode) {
        super(data);
        this.isViewMode = isViewMode;
    }

    public void flush(WorkflowContext workflowContext) {

        if(this.isViewMode())
            return;

        if(this.enableFlushSnapshot() && DataUtil.isNotNull(snapshot)) {
            this.getSnapshot().flush(workflowContext);
        }

        if (this.isColoured())
            //TODO update job
            ;
    }

    @Override
    public void clear() {
        super.clear();
        snapshot.clear();
        jobContent.clear();
    }

    public boolean isViewMode() {
        return isViewMode;
    }

    public boolean enableFlushSnapshot() {
        return JobTypeEnum.enableFlushSnapshot(JobTypeEnum.valueOf(this.data().getJobType()));
    }

    public Snapshot getSnapshot() {
        if(DataUtil.isNull(snapshot)) {
            if(this.isViewMode()) {
                snapshot = SnapshotHelper.querySnapshot4View(this);
            } else {
                snapshot = SnapshotHelper.querySnapshot4Execution(this);
            }
        }
        return snapshot;
    }

    public void increaseNextTaskSequence() {
        this.data().setNextTaskSequence(this.data().getNextTaskSequence() + 1);
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

    private void changeJobState(JobStateEnum jobState) {
        if(this.data().getJobState() == jobState.getState())
            return;

        this.data().setJobState(jobState.getState());
        this.syncJobState2SnapshotAndWorkflow(jobState);
    }

    public void syncJobState2SnapshotAndWorkflow() {
        this.syncJobState2SnapshotAndWorkflow(JobStateEnum.valueOf(this.data().getJobState()));
    }

    private void syncJobState2SnapshotAndWorkflow(JobStateEnum jobState) {
        switch (jobState) {
            case PREPARING:
                this.snapshot.getWorkflow().changeState2Preparing();
                this.syncJobId2Workflow();
                break;
            case QUEUEING:
                this.snapshot.getWorkflow().changeState2Preparing();
                this.syncJobId2Workflow();
                break;
            case RUNNING:
                this.snapshot.getWorkflow().changeState2Running();
                this.syncJobId2Workflow();
                break;
            case SUCCESS:
                this.snapshot.changeState2Finished();
                this.snapshot.getWorkflow().changeState2Finished();
                this.syncJobId2Workflow();
                break;
            case ERROR_TERMINATED:
                this.snapshot.changeState2Finished();
                this.snapshot.getWorkflow().changeState2Finished();
                this.syncJobId2Workflow();
                break;
            case USER_TERMINATED:
                this.snapshot.changeState2Finished();
                this.snapshot.getWorkflow().changeState2Finished();
                this.syncJobId2Workflow();
                break;
            default:
                break;
        }
    }

    private void syncJobId2Workflow() {
        Long lastJobId = this.snapshot.getWorkflow().data().getLastJobId();
        if(DataUtil.isNull(lastJobId) || !lastJobId.equals(this.data().getJobId()))
            this.snapshot.getWorkflow().data().setLastJobId(this.data().getJobId());
    }

    public boolean enableFlushWorkflow() {
        return JobTypeEnum.enableFlushWorkflow(JobTypeEnum.valueOf(this.data().getJobType()));
    }
}
