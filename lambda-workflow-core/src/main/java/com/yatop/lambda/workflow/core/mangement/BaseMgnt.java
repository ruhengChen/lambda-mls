package com.yatop.lambda.workflow.core.mangement;

import org.springframework.beans.factory.annotation.Autowired;
import com.yatop.lambda.core.mangement.*;

public class BaseMgnt {

    @Autowired
    ComponentMgnt componentMgnt;

    @Autowired
    DataMgnt dataMgnt;

    @Autowired
    ModelMgnt modelMgnt;

    @Autowired
    ExperimentMgnt experimentMgnt;

    @Autowired
    ProjectMgnt projectMgnt;

    @Autowired
    SystemParameterMgnt systemParameterMgnt;

    @Autowired
    WorkflowExecutionMgnt workflowExecutionMgnt;

    @Autowired
    WorkflowMgnt workflowMgnt;

    @Autowired
    WorkflowModuleMgnt workflowModuleMgnt;

    @Autowired
    WorkflowSnapshotMgnt workflowSnapshotMgnt;

    @Autowired
    WorkflowUnstructuredDataMgnt workflowUnstructuredDataMgnt;
}
