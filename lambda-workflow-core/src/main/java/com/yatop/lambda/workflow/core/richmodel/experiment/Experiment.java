package com.yatop.lambda.workflow.core.richmodel.experiment;

import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.WorkflowHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;

public class Experiment extends RichModel<EmExperiment> {

    private Project project;
    private Workflow workflow;

    public Experiment(EmExperiment data, Project project) {
        super(data);
        this.project = project;
    }

    @Override
    public void clear() {
        project = null;
        workflow = null;
        super.clear();
    }

    public Project getProject() {
        return project;
    }

    public Long getWorkflowId() {
        return data().getExperimentId();
    }

    public Workflow getWorkflow() {
        if(DataUtil.isNull(workflow)) {
            workflow = WorkflowHelper.queryWorkflow(this);
        }
        return workflow;
    }
}
