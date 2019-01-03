package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.enums.NodeStateEnum;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeHelper;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.workflow.global.GlobalParameter;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Node extends WfFlowNode implements IRichModel {

    private Module module;
    private TreeMap<String, NodeParameter> parameters = new TreeMap<String, NodeParameter>();   //组件参数，key=charId
    private TreeMap<String, NodeParameter> optimizeParameters = new TreeMap<String, NodeParameter>();         //执行调优参数，key=charId
    private TreeMap<Long, NodePortInput> inputNodePorts = new TreeMap<Long, NodePortInput>();                 //输入节点端口，key=nodePortId
    private TreeMap<String, NodePortInput> inputNodePortsOrderByCharId = new TreeMap<String, NodePortInput>();                 //输入节点端口，key=charId
    private TreeMap<Integer, NodePortInput> inputNodePortsOrderBySequence = new TreeMap<Integer, NodePortInput>(); //输入节点端口按序号排序
    private TreeMap<Long, NodePortOutput> outputNodePorts = new TreeMap<Long, NodePortOutput>();                //输出节点端口，key=nodePortId
    private TreeMap<String, NodePortOutput> outputNodePortsOrderByCharId = new TreeMap<String, NodePortOutput>();                //输出节点端口，key=charId
    private TreeMap<Integer, NodePortOutput> outputNodePortsOrderBySequence = new TreeMap<Integer, NodePortOutput>();//输出节点端口按序号排序
  //private TreeMap<String, GlobalParameter> globalParameters = new TreeMap<String, GlobalParameter>();  //操作关联节点参数，key=charId
    private boolean deleted;
    private boolean anlyzed;

    public Node(WfFlowNode data, Module module) {
        super.copyProperties(data);
        this.module = module;
        this.deleted = false;
        this.anlyzed = false;
        this.clearColoured();
    }

    @Override
    public void clear() {
        module = null;
        CollectionUtil.clear(parameters);
        CollectionUtil.clear(optimizeParameters);
        CollectionUtil.clear(inputNodePorts);
        inputNodePortsOrderBySequence.clear();
        CollectionUtil.clear(outputNodePorts);
        outputNodePortsOrderBySequence.clear();
      //CollectionUtil.clear(globalParameters);
        super.clear();
    }

    public void flush(boolean flushNodeParameter, boolean flushDataPortSchema, String operId) {

        if(!this.isDeleted()) {
            if (flushNodeParameter && this.parameterCount() > 0) {
                for (NodeParameter parameter : this.getParameters()) {
                    parameter.flush(operId);
                }
            }
            if (flushNodeParameter && this.optimizeParameterCount() > 0) {
                for (NodeParameter parameter : this.getOptimizeParameters()) {
                    parameter.flush(operId);
                }
            }
            if (flushDataPortSchema && this.outputNodePortCount() > 0) {
                for (NodePortOutput outputPort : this.getOutputNodePorts()) {
                    outputPort.flush(operId);
                }
            }
            if (this.isColoured() && this.getNodeId() > 0)
                NodeHelper.updateNode(this, operId);
        }
    }

    public void changeNodeState2NotReady() {
        this.changeNodeState(NodeStateEnum.NOT_READY);
    }

    public void downgradeNodeState2Ready() {
        if(this.getNodeState() <= NodeStateEnum.READY.getState())
            return;

        this.changeNodeState(NodeStateEnum.READY);
    }

    public void changeNodeState2Ready() {
        this.changeNodeState(NodeStateEnum.READY);
    }

    public void changeNodeState2Preparing() {
        this.changeNodeState(NodeStateEnum.PREPARING);
    }

    public void changeNodeState2Running() {
        this.changeNodeState(NodeStateEnum.RUNNING);
    }

    public void changeNodeState2Success() {
        this.changeNodeState(NodeStateEnum.SUCCESS);
    }

    public void changeNodeState2Error() {
        this.changeNodeState(NodeStateEnum.ERROR);
    }

    private void changeNodeState(NodeStateEnum stateEnum) {
        if(this.getNodeState() == stateEnum.getState())
            return;

        this.setNodeState(stateEnum.getState());
    }

    public Module getModule() {
        return module;
    }

    public Component getComponent() {
        return module.getComponent();
    }

    public int parameterCount() {
        return parameters.size();
    }

    public NodeParameter getParameter(String charId) {
        return CollectionUtil.get(parameters, charId);
    }

    public List<NodeParameter> getParameters() {
        return CollectionUtil.toList(parameters);
    }

    public void putParameter(NodeParameter parameter) {
        CollectionUtil.put(parameters, parameter.getCharId(), parameter);
    }

    public int optimizeParameterCount() {
        return optimizeParameters.size();
    }

    public NodeParameter getOptimizeParameter(String charId) {
        return CollectionUtil.get(optimizeParameters, charId);
    }

    public List<NodeParameter> getOptimizeParameters() {
        return CollectionUtil.toList(optimizeParameters);
    }

    public void putOptimizeParameter(NodeParameter parameter) {
        CollectionUtil.put(optimizeParameters, parameter.getCharId(), parameter);
    }

    public int inputNodePortCount() {
        return inputNodePorts.size();
    }

    public NodePortInput getInputNodePort(Long nodePortId) {
        return CollectionUtil.get(inputNodePorts, nodePortId);
    }

    public NodePortInput getInputNodePort(String charId) {
        return CollectionUtil.get(inputNodePortsOrderByCharId, charId);
    }

    public List<NodePortInput> getInputNodePorts() {
        return CollectionUtil.toList(inputNodePortsOrderBySequence);
    }

    public void putInputNodePort(NodePortInput inputNodePort) {
        CollectionUtil.put(inputNodePorts, inputNodePort.getNodePortId(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderByCharId, inputNodePort.getRefCharId(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderBySequence, inputNodePort.getModulePort().getSequence(), inputNodePort);
    }

    public int outputNodePortCount() {
        return outputNodePorts.size();
    }

    public NodePortOutput getOutputNodePort(Long nodePortId) {
        return CollectionUtil.get(outputNodePorts, nodePortId);
    }

    public NodePortOutput getOutputNodePort(String charId) {
        return CollectionUtil.get(outputNodePortsOrderByCharId, charId);
    }

    public List<NodePortOutput> getOutputNodePorts() {
        return CollectionUtil.toList(outputNodePortsOrderBySequence);
    }

    //key=charId
    public TreeMap<String, NodeSchema> getOutputPortSchemas() {
        TreeMap<String, NodeSchema> nodeSchemas = new TreeMap<String, NodeSchema>();
        for(Map.Entry<Long, NodePortOutput> entry : outputNodePorts.entrySet()) {
            if(entry.getValue().isDataPort()) {
                NodeSchema schema = entry.getValue().getSchema();
                nodeSchemas.put(entry.getValue().getRefCharId(), schema);
            }
        }
        return nodeSchemas;
    }

    public void putOutputNodePort(NodePortOutput outputNodePort) {
        CollectionUtil.put(outputNodePorts, outputNodePort.getNodePortId(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderByCharId, outputNodePort.getRefCharId(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderBySequence, outputNodePort.getModulePort().getSequence(), outputNodePort);
    }
/*

    public int globalParameterCount() {
        return globalParameters.size();
    }

    public GlobalParameter getGlobalParameter(String charId) {
        return globalParameters.get(charId);
    }

    public List<GlobalParameter> getGlobalParameters() {
        return CollectionUtil.toList(globalParameters);
    }

    public void putGlobalParameter(GlobalParameter globalParameter) {
        CollectionUtil.put(globalParameters, globalParameter.getRelCharId(), globalParameter);
    }

    public void removeGlobalParameter(String charId) {
        CollectionUtil.remove(globalParameters, charId);
    }
*/

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        if(this.inputNodePortCount() > 0) {
            for (NodePortInput inputPort : this.getInputNodePorts()) {
                inputPort.markDeleted();
            }
        }
        if(this.outputNodePortCount() > 0) {
            for (NodePortOutput outputPort : this.getOutputNodePorts()) {
                outputPort.markDeleted();
            }
        }
        this.deleted = true;
    }

    public boolean isAnalyzed() {
        return deleted;
    }

    public void markAnalyzed() {
        if(this.inputNodePortCount() > 0) {
            for (NodePortInput inputPort : this.getInputNodePorts()) {
                inputPort.markAnalyzed();
            }
        }
        this.deleted = true;
    }
}
