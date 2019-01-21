package com.yatop.lambda.workflow.core.mgr.workflow.node.port;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.PortTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodePortMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.config.ModuleConfig;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema.SchemaRecover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodePortRecover {

    @Autowired
    private NodePortMgr nodePortMgr;

    @Autowired
    private SchemaRecover schemaRecover;

    @Autowired
    private ModuleConfig moduleConfig;

    public void recoverNodePorts(WorkflowContext workflowContext, Node node) {

        Module module = node.getModule();
        if(module.inputPortCount() > 0 || module.outputPortCount() > 0) {
            nodePortMgr.recoverNodePort(node.data().getNodeId(), workflowContext.getOperId());

            List<WfFlowNodePort> nodePortList = nodePortMgr.queryNodePortByNodeId(node.data().getNodeId());
            if (DataUtil.isEmpty(nodePortList)) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node port failed -- node port list empty.", "节点端口信息缺失", node);
            }

            for(WfFlowNodePort nodePort : nodePortList) {
                ModulePort modulePort = moduleConfig.getModulePort(nodePort.getRefPortId());
                if(DataUtil.isNull(modulePort) || !module.existsModulePort(modulePort)) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node port failed -- module port not found.", "节点端口信息错误", nodePort);
                }
                switch(PortTypeEnum.valueOf(modulePort.data().getPortType())) {
                    case INPUT_PORT:
                        node.putInputNodePort(new NodePortInput(nodePort, modulePort));
                        break;
                    case OUTPUT_PORT:
                        node.putOutputNodePort(new NodePortOutput(nodePort, modulePort));
                        break;
                }
            }

            if(module.inputPortCount() != node.inputNodePortCount() || module.outputPortCount() != node.outputNodePortCount()) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node port failed -- module-port vs node-port inconsistent.", "节点端口信息错误", node);
            }

            schemaRecover.recoverSchemas(workflowContext, node);
        }
    }
}
