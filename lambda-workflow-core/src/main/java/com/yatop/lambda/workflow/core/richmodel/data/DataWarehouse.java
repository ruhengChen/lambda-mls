package com.yatop.lambda.workflow.core.richmodel.data;

import com.yatop.lambda.base.model.DwDataWarehouse;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.project.Project;

public class DataWarehouse extends DwDataWarehouse implements IRichModel {
    private Project project;

    public DataWarehouse() {}

    public DataWarehouse(DwDataWarehouse data) {super.copyProperties(data);}

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
