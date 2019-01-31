package com.yatop.lambda.workflow.core.mgr.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.WorkflowMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.WorkDirectoryUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeCreate;
import com.yatop.lambda.workflow.core.mgr.workflow.node.link.LinkCreate;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class WorkflowCreate {

    @Autowired
    private WorkflowMgr workflowMgr;

    @Autowired
    private NodeCreate nodeCreate;

    @Autowired
    private LinkCreate linkCreate;

    public WorkflowContext createWorkflow(Experiment experiment, String operId) {

        WfFlow flow = new WfFlow();
        flow.setFlowId(experiment.getWorkflowId());
        flow.setFlowName(experiment.getWorkflowId() + " - WorkFLow");
        flow.setOwnerProjectId(experiment.data().getOwnerProjectId());
        flow = workflowMgr.insertWorkflow(flow, operId);

        flow.setFlowDfsDir(WorkDirectoryUtil.getWorkFLowDfsDirectory(experiment.data().getOwnerProjectId(), flow.getFlowId()));
        flow.setFlowLocalDir(WorkDirectoryUtil.getWorkFLowLocalDirectory(experiment.data().getOwnerProjectId(), flow.getFlowId()));
        workflowMgr.updateWorkflow(flow, operId);
        Workflow richWorkflow = new Workflow(flow, experiment);

        //richWorkflow.copyProperties(workflowMgr.queryWorkflow(richWorkflow.data().getFlowId()));
        richWorkflow.changeState2Draft();
        return WorkflowContext.BuildWorkflowContext4Create(experiment, operId);
    }

    public WorkflowContext createWorkflow(Experiment experiment, WorkflowContext otherWorkflowContext, String operId) {
        if(otherWorkflowContext.isLazyLoadMode())
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create workflow error -- other workflow context work in lazy-load-mode.", "系统内部错误，请联系管理员");
        if(otherWorkflowContext.isLoadNodeParameter())
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create workflow error -- other workflow context work in not load-node-parameter mode.", "系统内部错误，请联系管理员");

        WorkflowContext thisWorkFlowContext = createWorkflow(experiment, operId);
        thisWorkFlowContext.markAnalyzeWithRefreshSchema();

        if(otherWorkflowContext.nodeCount() > 0) {
            //key: otherNodeId, thisNode
            HashMap<Long, Node> nodeIndexTable = new HashMap<Long, Node>(otherWorkflowContext.nodeCount());
            for (Node otherNode : otherWorkflowContext.getNodes()) {
                Node thisNode = nodeCreate.copyNode4DiffWorkflow(thisWorkFlowContext, otherNode);
                CollectionUtil.put(nodeIndexTable, otherNode.data().getNodeId(), thisNode);
            }

            if(otherWorkflowContext.linkCount() > 0) {
                for(NodeLink otherLink : otherWorkflowContext.getLinks()) {
                    Node thisSrcNode = CollectionUtil.get(nodeIndexTable, otherWorkflowContext.getUpstreamNode(otherLink).data().getNodeId());
                    Node thisDstNode = CollectionUtil.get(nodeIndexTable, otherWorkflowContext.getDownstreamNode(otherLink).data().getNodeId());
                    if(DataUtil.isNull(thisSrcNode) || DataUtil.isNull(thisDstNode))
                        throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create workflow error -- source node or destination node not found.", "系统数据异常，请联系管理员");

                    NodePortOutput thisSrcPort = thisSrcNode.getOutputNodePort(otherWorkflowContext.getUpstreamPort(otherLink).getCmptChar().data().getCharId());
                    NodePortInput thisDstPort = thisDstNode.getInputNodePort(otherWorkflowContext.getDownstreamPort(otherLink).getCmptChar().data().getCharId());
                    if(DataUtil.isNull(thisSrcPort) || DataUtil.isNull(thisDstPort))
                        throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create workflow error -- source port or destination port not found.", "系统数据异常，请联系管理员");

                    linkCreate.createLink(thisWorkFlowContext, thisSrcNode, thisDstNode, thisSrcPort, thisDstPort);
                }
            }
        }
        
        thisWorkFlowContext.flush();
        return thisWorkFlowContext;
    }
}
