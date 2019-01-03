package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class Module extends WfModule implements Comparable<Module>, IRichModel {

    private Component component;    //关联计算组件
    private TreeMap<Long, ModulePort> inputPorts = new TreeMap<Long, ModulePort>();     //工作流组件输入端口
    private TreeMap<String, ModulePort> inputPortsOrderByCharId = new TreeMap<String, ModulePort>();     //工作流组件输入端口
    private TreeMap<Integer, ModulePort> inputPortsOrderBySequence = new TreeMap<Integer, ModulePort>();    //工作流组件输入端口按序号排序
    private TreeMap<Long, ModulePort> outputPorts = new TreeMap<Long, ModulePort>();    //工作流组件输出端口
    private TreeMap<String, ModulePort> outputPortsOrderByCharId = new TreeMap<String, ModulePort>();     //工作流组件输出端口
    private TreeMap<Integer, ModulePort> outputPortsOrderBySequence = new TreeMap<Integer, ModulePort>();   //工作流组件输出端口按序号排序

    public Module(WfModule data, Component component) {
        super.copyProperties(data);
        this.component = component;
        this.clearColoured();
    }

    @Override
    public int compareTo(Module o) {
        return this.getModuleId().compareTo(o.getModuleId());
    }

    @Override
    public void clear() {
        inputPorts.clear();
        inputPortsOrderByCharId.clear();
        inputPortsOrderBySequence.clear();
        outputPorts.clear();
        outputPortsOrderByCharId.clear();
        outputPortsOrderBySequence.clear();
        super.clear();
    }

    public Component getComponent() {
        return component;
    }

    public int inputPortCount() {
        return inputPorts.size();
    }

    public ModulePort getInputPort(Long inputPortId) {
        return CollectionUtil.get(inputPorts, inputPortId);
    }

    public ModulePort getInputPort(String inputCharId) {
        return CollectionUtil.get(inputPortsOrderByCharId, inputCharId);
    }

    public List<ModulePort> getInputPorts() {
        return CollectionUtil.toList(inputPortsOrderBySequence);
    }

    public void putInputPort(ModulePort inputPort) {
        CollectionUtil.put(inputPorts, inputPort.getPortId(), inputPort);
        CollectionUtil.put(inputPortsOrderBySequence, inputPort.getSequence(), inputPort);
    }

    public int outputPortCount() {
        return outputPorts.size();
    }

    public ModulePort getOutputPort(Long outputPortId) {
        return CollectionUtil.get(outputPorts, outputPortId);
    }

    public ModulePort getOutputPort(String outputCharId) {
        return CollectionUtil.get(outputPortsOrderByCharId, outputCharId);
    }

    public List<ModulePort> getOutputPorts() {
        return CollectionUtil.toList(outputPortsOrderBySequence);
    }

    public void putOutputPort(ModulePort outputPort) {
        CollectionUtil.put(outputPorts, outputPort.getPortId(), outputPort);
        CollectionUtil.put(outputPortsOrderBySequence, outputPort.getSequence(), outputPort);
    }

    public boolean existsModulePort(ModulePort modulePort) {
        return DataUtil.isNotNull(this.getInputPort(modulePort.getPortId())) || DataUtil.isNotNull(this.getOutputPort(modulePort.getPortId()));
    }
}
