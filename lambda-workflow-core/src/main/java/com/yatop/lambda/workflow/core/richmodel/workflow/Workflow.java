package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.core.enums.ShareLockStateEnum;
import com.yatop.lambda.core.enums.WorkflowStateEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.WorkflowHelper;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class Workflow extends WfFlow implements IRichModel {

    private static long NODE_DELETE_MAX_SEQUENCE = 0x20;

    private boolean deleted;
    private TreeMap<Long, WorkflowAccumulate> accumulates = new TreeMap<Long, WorkflowAccumulate>();

    public Workflow(WfFlow data) {
        super.copyProperties(data);
        this.deleted = false;
        this.clearColoured();
    }

    public void flush(String operId) {
        if(!this.isDeleted()) {
            if(this.accumulateCount() > 0) {
                for(WorkflowAccumulate accumulate : this.getAccumulates()) {
                    accumulate.flush(operId);
                }
            }

            if (this.isColoured() && this.getFlowId() > 0) {
                WorkflowHelper.updateWorkflow(this, operId);
            }
        }
    }

    public void changeWorkflowState2Draft() {
        this.changeWorkflowState(WorkflowStateEnum.DRAFT);
    }

    public void changeWorkflowState2Preparing() {
        this.changeWorkflowState(WorkflowStateEnum.PREPARING);
    }

    public void changeWorkflowState2Running() {
        this.changeWorkflowState(WorkflowStateEnum.RUNNING);
    }

    public void changeWorkflowState2FinishedRunning() {
        this.changeWorkflowState(WorkflowStateEnum.FINISHED_RUNNING);
    }

    private void changeWorkflowState(WorkflowStateEnum stateEnum) {
        if(this.getFlowState() == stateEnum.getState())
            return;

        this.setFlowState(stateEnum.getState());
    }

    public void setModuleSequence(Module module, Long thatSequence, String operId) {
        WorkflowAccumulate accumulate = this.getAccumulate(module, operId);
        if(accumulate.getUsageCount() < thatSequence) {
            accumulate.setUsageCount(thatSequence);
        }
    }

    public Long nextModuleSequence(Module module, String operId) {
        return this.getAccumulate(module, operId).increaseUsageCount();
    }

    private int accumulateCount() {
        return accumulates.size();
    }

    private WorkflowAccumulate getAccumulate(Module module, String operId) {

        WorkflowAccumulate accumulate = CollectionUtil.get(accumulates, module.getModuleId());
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
        CollectionUtil.put(accumulates, accumulate.getModuleId(), accumulate);
    }

    public Long previousDeleteSequence() {
        return Math.abs( (this.getNextDeleteSequence() - 1) % NODE_DELETE_MAX_SEQUENCE );
    }

    public Long generateNextDeleteSequence() {
        return Math.abs( (this.getNextDeleteSequence() + 1) % NODE_DELETE_MAX_SEQUENCE );
    }

    public void increaseNodeCount() {
        this.setNodeCount(this.getNodeCount() + 1);
    }

    public void increaseNextSnapshotVersion() {
        this.setNextSnapshotVersion(this.getNextSnapshotVersion() + 1);
    }

    public void increaseVersion() {
        this.setVersion(this.getVersion() + 1);
    }

    public boolean isWorkflowLocked() {
        return this.getShareLockState() == ShareLockStateEnum.LOCKED.getState();
    }

    public boolean lockWorkflow() {
        if(this.getShareLockState() == ShareLockStateEnum.LOCKED.getState())
            return false;

        this.setShareLockState(ShareLockStateEnum.LOCKED.getState());
        return true;
    }

    public boolean unlockWorkflow() {
        if(this.getShareLockState() == ShareLockStateEnum.UNLOCKED.getState())
            return false;

        this.setShareLockState(ShareLockStateEnum.UNLOCKED.getState());
        return true;
    }

    public void doneDeleteNodes(Long nodeCount) {
        this.setNodeCount(this.getNodeCount() - nodeCount);
        this.setNextDeleteSequence(generateNextDeleteSequence());
    }

    public void doneRecoverNodes(Long nodeCount) {
        this.setNodeCount(this.getNodeCount() + nodeCount);
        this.setNextDeleteSequence(previousDeleteSequence());
    }

    @Override
    public void clear() {
        CollectionUtil.clear(accumulates);
        super.clear();
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }
}
