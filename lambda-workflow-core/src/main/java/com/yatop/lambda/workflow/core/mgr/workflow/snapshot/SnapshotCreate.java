package com.yatop.lambda.workflow.core.mgr.workflow.snapshot;

import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.core.enums.SnapshotStateEnum;
import com.yatop.lambda.core.enums.SnapshotTypeEnum;
import com.yatop.lambda.core.mgr.workflow.snapshot.SnapshotMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnapshotCreate {

    @Autowired
    SnapshotMgr snapshotMgr;

    private Snapshot createSnapshot(WorkflowContext workflowContext, String snapshotName, SnapshotTypeEnum snapshotType, SnapshotStateEnum snapshotState) {
        Workflow workflow = workflowContext.getWorkflow();
        WfSnapshot snapshot = new WfSnapshot();
        snapshot.setSnapshotName(DataUtil.isNotEmpty(snapshotName) ? snapshotName : workflow.getExperiment().data().getExperimentName() + " - " + snapshotType.getName());
        snapshot.setSnapshotType(snapshotType.getType());
        snapshot.setOwnerProjectId(workflow.data().getOwnerProjectId());
        snapshot.setOwnerFlowId(workflow.data().getFlowId());
        snapshot.setSnapshotVersion(workflow.data().getNextSnapshotVersion());
        snapshot.setSnapshotState(snapshotState.getState());
        snapshot = snapshotMgr.insertSnapshot(snapshot, workflowContext.getOperId());
        workflow.increaseNextSnapshotVersion();
        Snapshot richSnapshot = Snapshot.BuildSnapshot4Create(snapshot/*, workflowContext*/);
        return richSnapshot;
    }

    public Snapshot createSnapshot4Execution(WorkflowContext workflowContext) {
        return createSnapshot(workflowContext, null, SnapshotTypeEnum.EXECUTION, SnapshotStateEnum.GENERATING);
    }

    public Snapshot createSnapshot4Copy(WorkflowContext workflowContext, String copyName) {
        Snapshot snapshot = createSnapshot(workflowContext, copyName, SnapshotTypeEnum.COPY, SnapshotStateEnum.FINISHED);
        snapshot.syncWorkflowContext2Snapshot(workflowContext);
        snapshot.flushSnapshotContent();
        snapshotMgr.updateSnapshot(snapshot.data(), workflowContext.getOperId());
        return snapshot;
    }

    public Snapshot createSnapshot4Delete(WorkflowContext workflowContext) {
        Snapshot snapshot = createSnapshot(workflowContext, null, SnapshotTypeEnum.DELETE, SnapshotStateEnum.FINISHED);
        snapshot.syncWorkflowContext2Snapshot(workflowContext);
        snapshot.flushSnapshotContent();
        snapshotMgr.updateSnapshot(snapshot.data(), workflowContext.getOperId());
        return snapshot;
    }
}
