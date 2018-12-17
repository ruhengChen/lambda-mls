package com.yatop.lambda.workflow.core.richmodel.model;

import com.yatop.lambda.base.model.MwModelWarehouse;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.project.Project;

public class ModelWarehouse extends MwModelWarehouse implements IRichModel {
    private Project project;

    public ModelWarehouse() {}

    public ModelWarehouse(MwModelWarehouse data) {super.copyProperties(data);}

    @Override
    public void clear() {
        project = null;
        super.clear();
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
