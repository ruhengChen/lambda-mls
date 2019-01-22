package com.yatop.lambda.workflow.core.mgr.workflow;


import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.base.model.WfFlowAccumulate;
import com.yatop.lambda.core.mgr.workflow.WorkflowAccumulateMgr;
import com.yatop.lambda.core.mgr.workflow.WorkflowMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.WorkflowAccumulate;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkflowHelper {

    private static WorkflowMgr WORKFLOW_MGR;

    private static WorkflowAccumulateMgr WORKFLOW_ACCUMULATE_MGR;

    @Autowired
    public void setWorkflowMgr(WorkflowMgr workflowMgr) {
        WORKFLOW_MGR = workflowMgr;
    }

    @Autowired
    public void setWorkflowAccumulateMgr(WorkflowAccumulateMgr workflowAccumulateMgr) {
        WORKFLOW_ACCUMULATE_MGR = workflowAccumulateMgr;
    }

    public static Workflow queryWorkflow(Experiment experiment) {
        WfFlow workflow = WORKFLOW_MGR.queryWorkflow(experiment.getWorkflowId());
        return new Workflow(workflow, experiment);
    }

    //名称、共享锁状态、共享锁消息、下一快照版本、节点数量、下一删除批次、最后作业ID、DFS工作流目录、本地工作流目录、工作流状态、描述、版本号
    public static void updateWorkflow(Workflow workflow, String operId) {
        WORKFLOW_MGR.updateWorkflow(workflow.data(), operId);
        workflow.clearColoured();
    }

    public static WorkflowAccumulate queryAccumulate(Workflow workflow, Module module, String operId) {
        WfFlowAccumulate accumulate = WORKFLOW_ACCUMULATE_MGR.queryFlowAccumulate(workflow.data().getFlowId(), module.data().getModuleId());
        if(DataUtil.isNull(accumulate)) {
            accumulate = new WfFlowAccumulate();
            accumulate.setFlowId(workflow.data().getFlowId());
            accumulate.setModuleId(module.data().getModuleId());
            accumulate.setUsageCount(0L);
            accumulate = WORKFLOW_ACCUMULATE_MGR.insertFlowAccumulate(accumulate, operId);
        }
        return new WorkflowAccumulate(accumulate);
    }

    public static void updateAccumulate(WorkflowAccumulate accumulate, String operId) {
        WORKFLOW_ACCUMULATE_MGR.updateFlowAccumulate(accumulate.data(), operId);
        accumulate.clearColoured();
    }

    public static void deleteAccumulates(Workflow workflow, String operId) {
        WORKFLOW_ACCUMULATE_MGR.deleteFlowAccumulate(workflow.data().getFlowId(), operId);
    }
}
