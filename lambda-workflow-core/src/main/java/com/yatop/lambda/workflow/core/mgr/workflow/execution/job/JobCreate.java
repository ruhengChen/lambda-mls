package com.yatop.lambda.workflow.core.mgr.workflow.execution.job;

import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.core.mgr.workflow.execution.ExecutionJobMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobCreate {

    @Autowired
    private ExecutionJobMgr executionJobMgr;

    public ExecutionJob createJob(WorkflowContext workflowContext, JobTypeEnum jobType) {
        //TODO analyze workflow execution content, already to do execute
        //TODO reset execution nodes' state
        //TODO create snapshot
        //TODO create job
        //TODO push job queue
        return null;
    }
}
