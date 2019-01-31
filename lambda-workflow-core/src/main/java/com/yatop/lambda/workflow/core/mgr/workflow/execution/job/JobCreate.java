package com.yatop.lambda.workflow.core.mgr.workflow.execution.job;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.execution.ExecutionJobMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.execution.job.analyzer.JobContentAnalyzer;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotCreate;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.snapshot.Snapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.TreeSet;

@Service
public class JobCreate {

    @Autowired
    private ExecutionJobMgr executionJobMgr;

    @Autowired
    private SnapshotCreate snapshotCreate;

    public ExecutionJob createJob(WorkflowContext workflowContext, JobTypeEnum jobType, Node relatedNode) {

        TreeSet<Node>[] jobContent = JobContentAnalyzer.analyzeJobContent(workflowContext, jobType, relatedNode);
        if(DataUtil.isNull(jobContent) || jobContent.length != 2 || DataUtil.isEmpty(jobContent[0]))  {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create job content failed -- no executable nodes.", "无可运行节点");
        }

        Snapshot snapShot = snapshotCreate.createSnapshot4Execution(workflowContext);
        Workflow workflow = workflowContext.getWorkflow();
        WfExecutionJob job = new WfExecutionJob();
        job.setJobName(workflow.getExperiment().data().getExperimentName() + " - " + jobType.getName());
        job.setJobType(jobType.getType());
        job.setOwnerProjectId(workflow.data().getOwnerProjectId());
        job.setRelFlowId(workflow.data().getFlowId());
        job.setRelSnapshotId(snapShot.data().getSnapshotId());
        job.setRelNodeId(DataUtil.isNotNull(relatedNode) ? relatedNode.data().getNodeId() : -1L);
        job = executionJobMgr.insertJob(job, workflowContext.getOperId());

        Experiment experiment= workflowContext.getExperiment();
        job.setJobDfsDir(WorkDirectoryUtil.getJobDfsDirectory(experiment.data().getOwnerProjectId(), workflow.data().getFlowId(), job.getJobId()));
        job.setJobLocalDir(WorkDirectoryUtil.getJobLocalDirectory(experiment.data().getOwnerProjectId(), workflow.data().getFlowId(), job.getJobId()));
        executionJobMgr.updateJob(job, workflowContext.getOperId());

        ExecutionJob richJob = ExecutionJob.BuildExecutionJob4Create(job, workflowContext, snapShot, jobContent);
        workflow.lockWorkflow();
        workflow.changeState2Preparing();
        workflow.data().setLastJobId(job.getJobId());

        workflowContext.flush();
        richJob.flush(workflowContext);

        //TODO push job to queue
        return null;
    }
}
