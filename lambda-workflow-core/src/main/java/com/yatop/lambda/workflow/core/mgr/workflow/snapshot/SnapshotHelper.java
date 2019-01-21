package com.yatop.lambda.workflow.core.mgr.workflow.snapshot;

import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.core.mgr.workflow.snapshot.SnapshotMgr;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SnapshotHelper {

    private static SnapshotMgr SNAPSHOT_MGR;

    @Autowired
    public void setSnapshotMgr(SnapshotMgr snapshotMgr) {
        SNAPSHOT_MGR = snapshotMgr;
    }

    public static Snapshot querySnapshot(Long snapshotId) {
        WfSnapshot snapshot = SNAPSHOT_MGR.querySnapshot(snapshotId);
        return new Snapshot(snapshot);
    }

    public static Snapshot querySnapshot(ExecutionJob job) {
        return querySnapshot(job.data().getRelSnapshotId());
    }

    public static void updateSnapshot(Snapshot snapshot, String operId) {
        SNAPSHOT_MGR.updateSnapshot(snapshot.data(), operId);
        snapshot.clearColoured();
    }
}
