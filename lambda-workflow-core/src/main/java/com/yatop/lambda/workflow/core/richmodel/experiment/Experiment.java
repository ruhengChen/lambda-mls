package com.yatop.lambda.workflow.core.richmodel.experiment;

import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.project.Project;

public class Experiment extends EmExperiment implements IRichModel {

    private Project project;  //实验工作流

    public Experiment(EmExperiment data, Project project) {
        super.copyProperties(data);
        this.project = project;
        this.clearColoured();
    }

    @Override
    public void clear() {
        project = null;
        super.clear();
    }

    public Project getProject() {
        return project;
    }
}
