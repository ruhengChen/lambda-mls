package com.yatop.lambda.workflow.core.richmodel.experiment;

import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;

public class Experiment extends EmExperiment implements IRichModel {
    private Project project;
    private Workflow workflow;

    public Experiment() {}

    public Experiment(EmExperiment data) {super.copyProperties(data);}

    @Override
    public void clear() {
        project = null;
        workflow = null;
        super.clear();
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }
}
