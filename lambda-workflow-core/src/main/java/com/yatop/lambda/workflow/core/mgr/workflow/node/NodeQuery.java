package com.yatop.lambda.workflow.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.config.ModuleConfig;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.module.ParameterCheckHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.node.parameter.ParameterQuery;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.NodePortQuery;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeQuery {

    @Autowired
    NodeMgr nodeMgr;

    @Autowired
    NodePortQuery nodePortQuery;

    @Autowired
    ParameterQuery parameterQuery;

    @Autowired
    ModuleConfig moduleConfig;

    public Node queryNode(WorkflowContext workflowContext, Long nodeId) {

        Node richNode = workflowContext.getNode(nodeId);
        if(DataUtil.isNotNull(richNode))
            return richNode;

        WfFlowNode node = nodeMgr.queryNode(nodeId);
        if(DataUtil.isNull(node)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, String.format("Query node failed -- node not found, node-id:%d.", nodeId), "节点信息缺失");
        }
        if(DataUtil.isNull(workflowContext.getWorkflow().data().getFlowId() != node.getOwnerFlowId())) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node failed -- flow-id vs owner-flow-id inconsistent.", "节点信息错误", workflowContext.getWorkflow(), node);
        }

        Module module = moduleConfig.getModule(node.getRefModuleId());
        if(DataUtil.isNull(module)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node failed -- module not found.", "节点信息错误", node);
        }

        richNode = new Node(node, module);
        workflowContext.putNode(richNode);
        nodePortQuery.queryNodePorts(workflowContext, richNode);
        if(!workflowContext.isLoadNodeParameter()) {
            parameterQuery.queryParameters(workflowContext, richNode);
            //ParameterCheckHelper.checkParameter(workflowContext, richNode);
        }
        return richNode;
    }

    public void queryNodes(WorkflowContext workflowContext) {
        List<WfFlowNode> nodeList = nodeMgr.queryNode(workflowContext.getWorkflow().data().getFlowId(), null);
        if(DataUtil.isEmpty(nodeList)) {
            return;
        }

        for(WfFlowNode node : nodeList) {
            Module module = moduleConfig.getModule(node.getRefModuleId());
            if(DataUtil.isNull(module)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query node failed -- module not found.", "节点信息错误", node);
            }

            if(DataUtil.isNotNull(workflowContext.getNode(node.getNodeId())))
                continue;

            Node richNode = new Node(node, module);
            workflowContext.putNode(richNode);
            nodePortQuery.queryNodePorts(workflowContext, richNode);
            if(!workflowContext.isLoadNodeParameter()) {
                parameterQuery.queryParameters(workflowContext, richNode);
                //ParameterCheckHelper.checkParameter(workflowContext, richNode);
            }
        }
    }
}
