package com.yatop.lambda.workflow.core.mgr.workflow.execution.job;

import com.yatop.lambda.core.mgr.workflow.execution.ExecutionJobMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobDelete {

    @Autowired
    private ExecutionJobMgr executionJobMgr;

    //TODO 运行作业删除暂时不考虑
}
