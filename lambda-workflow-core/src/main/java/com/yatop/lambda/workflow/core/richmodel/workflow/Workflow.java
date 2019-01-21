package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.core.enums.ShareLockStateEnum;
import com.yatop.lambda.core.enums.WorkflowStateEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.WorkflowHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class Workflow extends RichModel<WfFlow> {

    private static long NODE_DELETE_MAX_SEQUENCE = 0x20;

    private Project project;
    private Experiment experiment;
    private TreeMap<Long, WorkflowAccumulate> accumulates = new TreeMap<Long, WorkflowAccumulate>();
    private boolean deleted;

    public Workflow(WfFlow data, Project project, Experiment experiment) {
        super(data);
        this.project = project;
        this.experiment = experiment;
        this.deleted = false;
    }

    @Override
    public void clear() {
        project = null;
        experiment = null;
        CollectionUtil.enhancedClear(accumulates);
        super.clear();
    }

    public void flush(String operId) {
        if(!this.isDeleted()) {
            if(this.accumulateCount() > 0) {
                for(WorkflowAccumulate accumulate : this.getAccumulates()) {
                    accumulate.flush(operId);
                }
            }

            if (this.isColoured()) {
                WorkflowHelper.updateWorkflow(this, operId);
            }
        }
    }

    public Project getProject() {
        return project;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public boolean isStateDraft() {
        return this.data().getFlowState() == WorkflowStateEnum.DRAFT.getState();
    }

    public boolean isStatePreparing() {
        return this.data().getFlowState() == WorkflowStateEnum.PREPARING.getState();
    }

    public boolean isStateRunning() {
        return this.data().getFlowState() == WorkflowStateEnum.RUNNING.getState();
    }

    public boolean isStateFinished() {
        return this.data().getFlowState() == WorkflowStateEnum.FINISHED.getState();
    }

    public void changeState2Draft() {
        this.changeWorkflowState(WorkflowStateEnum.DRAFT);
    }

    public void changeState2Preparing() {
        this.changeWorkflowState(WorkflowStateEnum.PREPARING);
    }

    public void changeState2Running() {
        this.changeWorkflowState(WorkflowStateEnum.RUNNING);
    }

    public void changeState2Finished() {
        this.changeWorkflowState(WorkflowStateEnum.FINISHED);
    }

    private void changeWorkflowState(WorkflowStateEnum stateEnum) {
        if(this.data().getFlowState() == stateEnum.getState())
            return;

        this.data().setFlowState(stateEnum.getState());
    }

    public void setModuleSequence(Module module, Long thatSequence, String operId) {
        WorkflowAccumulate accumulate = this.getAccumulate(module, operId);
        if(accumulate.data().getUsageCount() < thatSequence) {
            accumulate.data().setUsageCount(thatSequence);
        }
    }

    public Long nextModuleSequence(Module module, String operId) {
        return this.getAccumulate(module, operId).increaseUsageCount();
    }

    private int accumulateCount() {
        return accumulates.size();
    }

    private WorkflowAccumulate getAccumulate(Module module, String operId) {

        WorkflowAccumulate accumulate = CollectionUtil.get(accumulates, module.data().getModuleId());
        if(DataUtil.isNull(accumulate)) {
            accumulate = WorkflowHelper.queryAccumulate(this, module, operId);
            this.putAccumulate(accumulate);
        }
        return accumulate;
    }

    private List<WorkflowAccumulate> getAccumulates() {
        return CollectionUtil.toList(accumulates);
    }

    private void putAccumulate(WorkflowAccumulate accumulate) {
        CollectionUtil.put(accumulates, accumulate.data().getModuleId(), accumulate);
    }

    public Long previousDeleteSequence() {
        return Math.abs( (this.data().getNextDeleteSequence() - 1) % NODE_DELETE_MAX_SEQUENCE );
    }

    public Long generateNextDeleteSequence() {
        return Math.abs( (this.data().getNextDeleteSequence() + 1) % NODE_DELETE_MAX_SEQUENCE );
    }

    public void increaseNodeCount() {
        this.data().setNodeCount(this.data().getNodeCount() + 1);
    }

    public void increaseNextSnapshotVersion() {
        this.data().setNextSnapshotVersion(this.data().getNextSnapshotVersion() + 1);
    }

    public void increaseVersion() {
        this.data().setVersion(this.data().getVersion() + 1);
    }

    public boolean isWorkflowLocked() {
        return this.data().getShareLockState() == ShareLockStateEnum.LOCKED.getState();
    }

    public boolean lockWorkflow() {
        if(this.data().getShareLockState() == ShareLockStateEnum.LOCKED.getState())
            return false;

        this.data().setShareLockState(ShareLockStateEnum.LOCKED.getState());
        return true;
    }

    public boolean unlockWorkflow() {
        if(this.data().getShareLockState() == ShareLockStateEnum.UNLOCKED.getState())
            return false;

        this.data().setShareLockState(ShareLockStateEnum.UNLOCKED.getState());
        return true;
    }

    public void doneDeleteNodes(Long nodeCount) {
        this.data().setNodeCount(this.data().getNodeCount() - nodeCount);
        this.data().setNextDeleteSequence(generateNextDeleteSequence());
    }

    public void doneRecoverNodes(Long nodeCount) {
        this.data().setNodeCount(this.data().getNodeCount() + nodeCount);
        this.data().setNextDeleteSequence(previousDeleteSequence());
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }
}
