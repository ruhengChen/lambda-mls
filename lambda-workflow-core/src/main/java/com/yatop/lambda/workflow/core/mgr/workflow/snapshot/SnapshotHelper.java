package com.yatop.lambda.workflow.core.mgr.workflow.snapshot;

import com.yatop.lambda.base.model.PrProject;
import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.SnapshotStateEnum;
import com.yatop.lambda.core.enums.SnapshotTypeEnum;
import com.yatop.lambda.core.mgr.workflow.snapshot.SnapshotMgr;
import com.yatop.lambda.workflow.core.richmodel.experiment.ExperimentTemplate;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
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

    public static WfSnapshot querySnapshot(Long snapshotId) {
        return SNAPSHOT_MGR.querySnapshot(snapshotId);
    }

    public static Snapshot querySnapshot4View(Long snapshotId) {
        return Snapshot.BuildSnapshot4View(querySnapshot(snapshotId));
    }

    public static Snapshot querySnapshot4View(ExecutionJob job) {
        return querySnapshot4View(job.data().getRelSnapshotId());
    }

    public static Snapshot querySnapshot4Execution(ExecutionJob job) {
        return Snapshot.BuildSnapshot4Execution(querySnapshot(job.data().getRelSnapshotId()), job.enableFlushSnapshot());
    }

    public static Snapshot simulateSnapshot4Template(ExperimentTemplate template) {
        PrProject dataProject = new PrProject();
        dataProject.setProjectId(-1L);
        dataProject.setProjectCode("SIMULATION_PROJECT");
        dataProject.setProjectName("模拟项目-实验模版");
        dataProject.setDwId(-1L);
        dataProject.setMwId(-1L);
        dataProject.setCacheExpireDays(-1);
        dataProject.setDescription(String.format("[%s]: %d - %s", dataProject.getProjectName(), template.data().getTemplateId(), template.data().getTemplateName()));
        dataProject.setStatus(DataStatusEnum.NORMAL.getStatus());
        dataProject.setLastUpdateTime(template.data().getCreateTime());
        dataProject.setLastUpdateOper(template.data().getCreateOper());
        dataProject.setCreateTime(template.data().getCreateTime());
        dataProject.setCreateOper(template.data().getCreateOper());
        Project simulationProject = new Project(dataProject);

        WfSnapshot dataSnapshot = new WfSnapshot();
        dataSnapshot.setSnapshotId(-1L);
        dataSnapshot.setSnapshotName(template.data().getTemplateName());
        dataSnapshot.setSnapshotType(SnapshotTypeEnum.TEMPLATE.getType());
        dataSnapshot.setOwnerProjectId(simulationProject.data().getProjectId());
        dataSnapshot.setOwnerFlowId(-1L);
        dataSnapshot.setSnapshotContent(template.data().getTemplateContent());
        dataSnapshot.setSnapshotVersion(-1L);
        dataSnapshot.setSnapshotState(SnapshotStateEnum.FINISHED.getState());
        dataSnapshot.setDescription(template.data().getDescription());
        dataSnapshot.setStatus(DataStatusEnum.NORMAL.getStatus());
        dataSnapshot.setLastUpdateTime(template.data().getCreateTime());
        dataSnapshot.setLastUpdateOper(template.data().getCreateOper());
        dataSnapshot.setCreateTime(template.data().getCreateTime());
        dataSnapshot.setCreateOper(template.data().getCreateOper());
        return Snapshot.BuildSnapshot4Template(dataSnapshot, simulationProject);
    }

    public static void updateSnapshot(Snapshot snapshot, String operId) {
        SNAPSHOT_MGR.updateSnapshot(snapshot.data(), operId);
        snapshot.clearColoured();
    }
}
