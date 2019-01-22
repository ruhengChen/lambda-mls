package com.yatop.lambda.workflow.core.mgr.project;

import com.yatop.lambda.core.mgr.project.ProjectMgr;
import com.yatop.lambda.workflow.core.richmodel.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectHelper {

    private static ProjectMgr PROJECT_MGR;

    @Autowired
    public void setProjectMgr(ProjectMgr projectMgr) {
        PROJECT_MGR = projectMgr;
    }

    public static Project queryProject(Long projectId) {
        return new Project(PROJECT_MGR.queryProject(projectId));
    }
}
