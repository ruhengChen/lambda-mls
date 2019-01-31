package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.enums.NodeStateEnum;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.mgr.workflow.analyzer.SchemaAnalyzerHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Node extends RichModel<WfFlowNode> implements Comparable<Node> {

    private Module module;
    private TreeMap<String, NodeParameter> parameters = new TreeMap<String, NodeParameter>();   //组件参数，key=charId
    private TreeMap<String, NodeParameter> parametersOrderByCharCode = new TreeMap<String, NodeParameter>();   //组件参数，key=charCode
    private TreeMap<String, NodeParameter> optimizeParameters = new TreeMap<String, NodeParameter>();         //执行调优参数，key=charId
    private TreeMap<String, NodeParameter> optimizeParametersOrderByCharCode = new TreeMap<String, NodeParameter>();         //执行调优参数，key=charCode
    private TreeMap<Long, NodePortInput> inputNodePorts = new TreeMap<Long, NodePortInput>();                 //输入节点端口，key=nodePortId
    private TreeMap<String, NodePortInput> inputNodePortsOrderByCharId = new TreeMap<String, NodePortInput>();                 //输入节点端口，key=charId
    private TreeMap<String, NodePortInput> inputNodePortsOrderByCharCode = new TreeMap<String, NodePortInput>();                 //输入节点端口，key=charCode
    private TreeMap<Integer, NodePortInput> inputNodePortsOrderBySequence = new TreeMap<Integer, NodePortInput>(); //输入节点端口按序号排序
    private TreeMap<Long, NodePortOutput> outputNodePorts = new TreeMap<Long, NodePortOutput>();                //输出节点端口，key=nodePortId
    private TreeMap<String, NodePortOutput> outputNodePortsOrderByCharId = new TreeMap<String, NodePortOutput>();                //输出节点端口，key=charId
    private TreeMap<String, NodePortOutput> outputNodePortsOrderByCharCode = new TreeMap<String, NodePortOutput>();                //输出节点端口，key=charCode
    private TreeMap<Integer, NodePortOutput> outputNodePortsOrderBySequence = new TreeMap<Integer, NodePortOutput>();//输出节点端口按序号排序
  //private TreeMap<String, GlobalParameter> globalParameters = new TreeMap<String, GlobalParameter>();  //操作关联节点参数，key=charId
    private int indegree;
    private boolean deleted;
    private boolean analyzed;

    public Node(WfFlowNode data, Module module) {
        super(data);
        this.module = module;
        this.deleted = false;
        this.analyzed = false;
    }

    @Override
    public int compareTo(Node o) {
        return this.data().getNodeId().compareTo(o.data().getNodeId());
    }

    @Override
    public void clear() {
        module = null;
        CollectionUtil.enhancedClear(parameters);
        CollectionUtil.enhancedClear(optimizeParameters);
        CollectionUtil.enhancedClear(inputNodePorts);
        CollectionUtil.clear(inputNodePortsOrderBySequence);
        CollectionUtil.enhancedClear(outputNodePorts);
        CollectionUtil.clear(outputNodePortsOrderBySequence);
      //CollectionUtil.enhancedClear(globalParameters);
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
            if (flushDataPortSchema && !this.isTailNode()) {
                for (NodePortOutput outputPort : this.getOutputNodePorts()) {
                    outputPort.flush(operId);
                }
            }
            if (this.isColoured() && this.data().getNodeId() > 0)
                NodeHelper.updateNode(this, operId);
        }
    }

    public boolean isStateNotReady() {
        return this.data().getNodeState() == NodeStateEnum.NOT_READY.getState();
    }

    public boolean isStateReady() {
        return this.data().getNodeState() == NodeStateEnum.READY.getState();
    }

    public boolean isStatePreparing() {
        return this.data().getNodeState() == NodeStateEnum.PREPARING.getState();
    }

    public boolean isStateRunning() {
        return this.data().getNodeState() == NodeStateEnum.RUNNING.getState();
    }

    public boolean isStateSuccess() {
        return this.data().getNodeState() == NodeStateEnum.SUCCESS.getState();
    }

    public boolean isStateError() {
        return this.data().getNodeState() == NodeStateEnum.ERROR.getState();
    }

    public void changeState2NotReady() {
        this.changeNodeState(NodeStateEnum.NOT_READY);
    }

    public void downgradeState2Ready() {
        if(this.data().getNodeState() <= NodeStateEnum.READY.getState())
            return;

        this.changeNodeState(NodeStateEnum.READY);
    }

    public void changeState2Ready() {
        this.clearOccuredWarning();
        this.changeNodeState(NodeStateEnum.READY);
    }

    public void changeState2Preparing() {
        this.changeNodeState(NodeStateEnum.PREPARING);
    }

    public void changeState2Running() {
        this.changeNodeState(NodeStateEnum.RUNNING);
    }

    public void changeState2Success() {
        this.changeNodeState(NodeStateEnum.SUCCESS);
    }

    public void changeState2Error() {
        this.changeNodeState(NodeStateEnum.ERROR);
    }

    private void changeNodeState(NodeStateEnum stateEnum) {
        if(this.data().getNodeState() == stateEnum.getState())
            return;

        this.data().setNodeState(stateEnum.getState());
    }

    public Module getModule() {
        return module;
    }

    public Component getComponent() {
        return module.getComponent();
    }

    public boolean isWebNode() {
        return this.getModule().isWebModule();
    }

    public int parameterCount() {
        return parameters.size();
    }

    public NodeParameter getParameter(String charId) {
        return CollectionUtil.get(parameters, charId);
    }

    public NodeParameter getParameter(CmptChar cmptChar) {
        return getParameter(cmptChar.data().getCharId());
    }

    public NodeParameter getParameterByCharCode(String charCode) {
        return CollectionUtil.get(parametersOrderByCharCode, charCode);
    }

    public List<NodeParameter> getParameters() {
        return CollectionUtil.toList(parameters);
    }

    public CharValue getParameterCharValue(CmptChar cmptChar) {
        return getParameter(cmptChar.data().getCharId()).getCharValue();
    }

    public List<CharValue> getParameterCharValues() {
        if(parameterCount() == 0)
            return null;

        List<CharValue> charValues = new ArrayList<CharValue>();
        for(NodeParameter parameter : getParameters()) {
            charValues.add(parameter.getCharValue());
        }
        return charValues;
    }

    public void putParameter(NodeParameter parameter) {
        CollectionUtil.put(parameters, parameter.data().getCharId(), parameter);
        CollectionUtil.put(parametersOrderByCharCode, parameter.getCmptChar().data().getCharCode(), parameter);
    }

    public int optimizeParameterCount() {
        return optimizeParameters.size();
    }

    public NodeParameter getOptimizeParameter(String charId) {
        return CollectionUtil.get(optimizeParameters, charId);
    }

    public NodeParameter getOptimizeParameter(CmptChar cmptChar) {
        return getOptimizeParameter(cmptChar.data().getCharId());
    }

    public NodeParameter getOptimizeParameterByCharCode(String charCode) {
        return CollectionUtil.get(optimizeParametersOrderByCharCode, charCode);
    }

    public List<NodeParameter> getOptimizeParameters() {
        return CollectionUtil.toList(optimizeParameters);
    }

    public CharValue getOptimizeParameterCharValue(CmptChar cmptChar) {
        return getOptimizeParameter(cmptChar.data().getCharId()).getCharValue();
    }

    public List<CharValue> getOptimizeParameterCharValues() {
        if(parameterCount() == 0)
            return null;

        List<CharValue> charValues = new ArrayList<CharValue>();
        for(NodeParameter parameter : getOptimizeParameters()) {
            charValues.add(parameter.getCharValue());
        }
        return charValues;
    }

    public void putOptimizeParameter(NodeParameter parameter) {
        CollectionUtil.put(optimizeParameters, parameter.data().getCharId(), parameter);
        CollectionUtil.put(optimizeParametersOrderByCharCode, parameter.getCmptChar().data().getCharCode(), parameter);
    }

    public int inputPortCount() {
        return module.inputPortCount();
    }

    public boolean isHeadNode() {
        return module.isHeadNode();
    }

    public boolean isTailNode() {
        return module.isTailNode();
    }

    public boolean haveOutputDataTablePort() {
        return module.outputDataTablePortCount() > 0;
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

    public NodePortInput getInputNodePortByCharCode(String charCode) {
        return CollectionUtil.get(inputNodePortsOrderByCharCode, charCode);
    }

    public NodePortInput getInputNodePortBySequence(Integer sequence) {
        return CollectionUtil.get(inputNodePortsOrderBySequence, sequence);
    }

    public List<NodePortInput> getInputNodePorts() {
        return CollectionUtil.toList(inputNodePortsOrderBySequence);
    }

    public void putInputNodePort(NodePortInput inputNodePort) {
        CollectionUtil.put(inputNodePorts, inputNodePort.data().getNodePortId(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderByCharId, inputNodePort.data().getRefCharId(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderByCharCode, inputNodePort.getCmptChar().data().getCharCode(), inputNodePort);
        CollectionUtil.put(inputNodePortsOrderBySequence, inputNodePort.getModulePort().data().getSequence(), inputNodePort);
    }

    public int inputDataTablePortCount() {
        return module.inputDataTablePortCount();
    }

    public List<NodePortInput> getInputDataTablePorts() {
        List<NodePortInput> dataPorts = null;
        if(outputDataTablePortCount() > 0) {
            dataPorts = new ArrayList<NodePortInput>();
            for (NodePortInput inputNodePort : getInputNodePorts()) {
                if (inputNodePort.isDataTablePort()) {
                    dataPorts.add(inputNodePort);
                }
            }
        }
        return dataPorts;
    }

    public int outputPortCount() {
        return module.outputPortCount();
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

    public NodePortOutput getOutputNodePortByCharCode(String charCode) {
        return CollectionUtil.get(outputNodePortsOrderByCharCode, charCode);
    }

    public NodePortOutput getOutputNodePortBySequence(Integer sequence) {
        return CollectionUtil.get(outputNodePortsOrderBySequence, sequence);
    }

    public List<NodePortOutput> getOutputNodePorts() {
        return CollectionUtil.toList(outputNodePortsOrderBySequence);
    }

    public void putOutputNodePort(NodePortOutput outputNodePort) {
        CollectionUtil.put(outputNodePorts, outputNodePort.data().getNodePortId(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderByCharId, outputNodePort.data().getRefCharId(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderByCharCode, outputNodePort.getCmptChar().data().getCharCode(), outputNodePort);
        CollectionUtil.put(outputNodePortsOrderBySequence, outputNodePort.getModulePort().data().getSequence(), outputNodePort);
    }

    public int outputDataTablePortCount() {
        return module.outputDataTablePortCount();
    }

    public List<NodePortOutput> getOutputDataTablePorts() {
        List<NodePortOutput> dataPorts = null;
        if(outputDataTablePortCount() > 0) {
            dataPorts = new ArrayList<NodePortOutput>();
            for (NodePortOutput outputNodePort : getOutputNodePorts()) {
                if (outputNodePort.isDataTablePort()) {
                    dataPorts.add(outputNodePort);
                }
            }
        }
        return dataPorts;
    }

    public NodeSchema getOutputDataTablePortSchema(String charId) {
        NodePortOutput outputNodePort = getOutputNodePort(charId);
        return outputNodePort.isDataTablePort() ? outputNodePort.getSchema() : null;
    }

    public NodeSchema getOutputDataTablePortSchemaByCharCode(String charCode) {
        NodePortOutput outputNodePort = getOutputNodePortByCharCode(charCode);
        return outputNodePort.isDataTablePort() ? outputNodePort.getSchema() : null;
    }

    public List<NodeSchema> getOutputDataTablePortSchemas() {
        List<NodeSchema> nodeSchemas = null;
        if(outputDataTablePortCount() > 0) {
            nodeSchemas = new ArrayList<NodeSchema>(outputDataTablePortCount());
            for (NodePortOutput outputNodePort : getOutputNodePorts()) {
                if (outputNodePort.isDataTablePort()) {
                    nodeSchemas.add(outputNodePort.getSchema());
                }
            }
        }
        return nodeSchemas;
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
        CollectionUtil.put(globalParameters, globalParameter.data().getRelCharId(), globalParameter);
    }

    public void removeGlobalParameter(String charId) {
        CollectionUtil.remove(globalParameters, charId);
    }
*/

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }

    public boolean isAnalyzed() {
        return analyzed;
    }

    public void markAnalyzed() {
        if(!this.isHeadNode()) {
            for (NodePortInput inputNodePort : this.getInputNodePorts()) {
                inputNodePort.markAnalyzed();
            }
        }
        if(!this.isTailNode()) {
            for (NodePortOutput outputNodePort : this.getOutputNodePorts()) {
                outputNodePort.markAnalyzed();
            }
        }
        this.analyzed = true;
    }

    public boolean isSupportAnalyze() {
        return SchemaAnalyzerHelper.supportAnalyzeSchema(this);
    }

    //用于analyzer在分析过程中判断节点是否需要分析输出数据端口的schema
    public boolean needAnalyzeSchema() {
        return !this.isDeleted() && !this.isAnalyzed() && !this.isWebNode() && this.haveOutputDataTablePort();
    }

    public void changeSchemas2Empty() {
        List<NodeSchema> dataPortSchemas = this.getOutputDataTablePortSchemas();
        if (DataUtil.isNotEmpty(dataPortSchemas)) {
            for (NodeSchema nodeSchema : dataPortSchemas)
                nodeSchema.changeState2Empty();
        }
    }

    public void changeSchemas2NotSupport() {
        List<NodeSchema> dataPortSchemas = this.getOutputDataTablePortSchemas();
        if (DataUtil.isNotEmpty(dataPortSchemas)) {
            for (NodeSchema nodeSchema : dataPortSchemas)
                nodeSchema.changeState2NotSupport();
        }
    }

    public boolean isOccuredWarning() {
        return isStateNotReady();
    }

    public void changeOccuredWarning(String warningMsg) {
        this.data().setWarningMsg(warningMsg);
        this.changeState2NotReady();
    }

    public void clearOccuredWarning() {
        if(DataUtil.isNotEmpty(this.data().getWarningMsg()))
            this.data().setWarningMsg(null);
    }

    public int getIndegree() {
        return indegree;
    }

    public void setIndegree(int indegree) {
        this.indegree = indegree;
    }

    public int decreaseIndegree() {
        return --this.indegree;
    }

    public IModuleClazz getModuleClazzBean() {
        return this.getModule().getModuleClazzBean();
    }
}
