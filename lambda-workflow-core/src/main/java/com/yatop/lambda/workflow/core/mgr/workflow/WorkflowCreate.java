package com.yatop.lambda.workflow.core.mgr.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.core.mgr.workflow.WorkflowMgr;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowCreate {

    @Autowired
    private WorkflowMgr workflowMgr;

    public WorkflowContext createWorkflow(Experiment experiment, String operId) {

        WfFlow flow = new WfFlow();
        flow.setFlowId(experiment.getExperimentId());
        flow.setFlowName(experiment.getExperimentId() + " - WorkFLow");
        flow.setOwnerProjectId(experiment.getOwnerProjectId());
        flow = workflowMgr.insertWorkflow(flow, operId);

        Workflow richWorkflow = new Workflow(flow);
        richWorkflow.setFlowDfsDir(WorkDirectoryUtil.getWorkFLowDfsDirectory(experiment.getOwnerProjectId(), richWorkflow.getFlowId()));
        richWorkflow.setFlowLocalDir(WorkDirectoryUtil.getWorkFLowLocalDirectory(experiment.getOwnerProjectId(), richWorkflow.getFlowId()));
        workflowMgr.updateWorkflow(richWorkflow, operId);

        //richWorkflow.copyProperties(workflowMgr.queryWorkflow(richWorkflow.getFlowId()));
        richWorkflow.changeWorkflowState2Draft();
        return WorkflowContext.BuildWorkflowContext(experiment.getProject(), richWorkflow, operId);
    }

    public WorkflowContext createWorkflow(Experiment experiment, WorkflowContext thatWorkflowContext, String operId) {
        WorkflowContext thisWorkFlowContext = createWorkflow(experiment, operId);

        //TODO ...

        return thisWorkFlowContext;
    }
}
