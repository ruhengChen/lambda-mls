package com.yatop.lambda.workflow.core.mgr.workflow.node.port;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.core.mgr.workflow.node.NodePortMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema.SchemaCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodePortCreate {

    @Autowired
    private NodePortMgr nodePortMgr;

    @Autowired
    SchemaCreate schemaCreate;

    private NodePortInput createInputPort(WorkflowContext workflowContext, Node node, ModulePort inputPort) {

        WfFlowNodePort nodePort = new WfFlowNodePort();
        nodePort.setNodePortName(inputPort.getPortName());
        nodePort.setOwnerNodeId(node.getNodeId());
        nodePort.setRefPortId(inputPort.getPortId());
        nodePort.setRefCharId(inputPort.getCmptChar().getCharId());
        nodePortMgr.insertNodePort(nodePort, workflowContext.getOperId());
        //nodePort.copyProperties(nodePortMgr.queryNodePort(nodePort.getNodePortId()));
        NodePortInput richNodePort = new NodePortInput(nodePort, inputPort);
        return  richNodePort;
    }

    private NodePortOutput createOutputPort(WorkflowContext workflowContext, Node node, ModulePort outputPort) {

        WfFlowNodePort nodePort = new WfFlowNodePort();
        nodePort.setNodePortName(outputPort.getPortName());
        nodePort.setOwnerNodeId(node.getNodeId());
        nodePort.setRefPortId(outputPort.getPortId());
        nodePort.setRefCharId(outputPort.getCmptChar().getCharId());
        nodePortMgr.insertNodePort(nodePort, workflowContext.getOperId());
        //nodePort.copyProperties(nodePortMgr.queryNodePort(nodePort.getNodePortId()));
        NodePortOutput richNodePort = new NodePortOutput(nodePort, outputPort);

        if(richNodePort.isDataPort()) {
            schemaCreate.createSchema(workflowContext, node, richNodePort);
        }

        return  richNodePort;
    }

    public void createNodePorts(WorkflowContext workflowContext, Node node) {

        Module module = node.getModule();
        //节点输入端口
        if(module.inputPortCount() > 0) {
            List<ModulePort> inputPorts = module.getInputPorts();
            for (ModulePort inputPort : inputPorts) {
                NodePortInput inputNodePort = createInputPort(workflowContext, node, inputPort);
                node.putInputNodePort(inputNodePort);
                workflowContext.putInputPort(inputNodePort);
            }
        }

        //节点输出端口
        if(module.outputPortCount() > 0) {
            List<ModulePort> outputPorts = module.getOutputPorts();
            for (ModulePort outputPort : outputPorts) {
                NodePortOutput outputNodePort = createOutputPort(workflowContext, node, outputPort);
                node.putOutputNodePort(outputNodePort);
                workflowContext.putOutputPort(outputNodePort);
            }
        }
    }
}
