package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.project.Project;

public class Workflow extends WfFlow implements IRichModel {
    private Project project;
    private Experiment experiment;

    public Workflow() {}

    public Workflow(WfFlow data) {super.copyProperties(data);}

    @Override
    public void clear() {
        this.project = null;
        this.experiment = null;
        super.clear();
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }
}
