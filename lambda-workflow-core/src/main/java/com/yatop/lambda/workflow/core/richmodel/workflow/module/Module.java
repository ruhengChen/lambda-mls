package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.module.IModuleClazz;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.utils.ClazzHelperUtil;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;
import java.util.TreeMap;

public class Module extends RichModel<WfModule> implements Comparable<Module> {

    private Component component;    //关联计算组件
    private TreeMap<Long, ModulePort> inputPorts = new TreeMap<Long, ModulePort>();     //工作流组件输入端口
    private TreeMap<String, ModulePort> inputPortsOrderByCharId = new TreeMap<String, ModulePort>();     //工作流组件输入端口
    private TreeMap<Integer, ModulePort> inputPortsOrderBySequence = new TreeMap<Integer, ModulePort>();    //工作流组件输入端口按序号排序
    private TreeMap<Long, ModulePort> outputPorts = new TreeMap<Long, ModulePort>();    //工作流组件输出端口
    private TreeMap<String, ModulePort> outputPortsOrderByCharId = new TreeMap<String, ModulePort>();     //工作流组件输出端口
    private TreeMap<Integer, ModulePort> outputPortsOrderBySequence = new TreeMap<Integer, ModulePort>();   //工作流组件输出端口按序号排序
    private int inputDataTablePortCount = 0;
    private int outputDataTablePortCount = 0;

    public Module(WfModule data, Component component) {
        super(data);
        this.component = component;
    }

    @Override
    public int compareTo(Module o) {
        return this.data().getModuleId().compareTo(o.data().getModuleId());
    }

    @Override
    public void clear() {
        component = null;
        CollectionUtil.clear(inputPorts);
        CollectionUtil.clear(inputPortsOrderByCharId);
        CollectionUtil.clear(inputPortsOrderBySequence);
        CollectionUtil.clear(outputPorts);
        CollectionUtil.clear(outputPortsOrderByCharId);
        CollectionUtil.clear(outputPortsOrderBySequence);
        inputDataTablePortCount = 0;
        outputDataTablePortCount = 0;
        super.clear();
    }

    public void initializeDataPortCount() {
        {
            int counter = 0;
            if(inputPortCount() > 0) {
                for (ModulePort modulePort : getInputPorts()) {
                    if (modulePort.isDataTablePort())
                        counter++;
                }
            }
            inputDataTablePortCount = counter;
        }
         {
            int counter = 0;
            if(outputPortCount() > 0) {
                for (ModulePort modulePort : getOutputPorts()) {
                    if (modulePort.isDataTablePort())
                        counter++;
                }
            }
             outputDataTablePortCount = counter;
        }
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
        CollectionUtil.put(inputPorts, inputPort.data().getPortId(), inputPort);
        CollectionUtil.put(inputPortsOrderBySequence, inputPort.data().getSequence(), inputPort);
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
        CollectionUtil.put(outputPorts, outputPort.data().getPortId(), outputPort);
        CollectionUtil.put(outputPortsOrderBySequence, outputPort.data().getSequence(), outputPort);
    }

    public boolean existsModulePort(ModulePort modulePort) {
        return DataUtil.isNotNull(this.getInputPort(modulePort.data().getPortId())) || DataUtil.isNotNull(this.getOutputPort(modulePort.data().getPortId()));
    }

    public int inputDataTablePortCount() {
        return inputDataTablePortCount;
    }

    public int outputDataTablePortCount() {
        return outputDataTablePortCount;
    }

    public boolean isHeadNode() {
        return this.inputPortCount() == 0;
    }

    public boolean isTailNode() {
        return this.outputPortCount() == 0;
    }

    public boolean isWebModule() {
        return this.getComponent().isWebComponent();
    }

    public IModuleClazz getModuleClazzBean() {
        return ClazzHelperUtil.getModuleClazzBean(this);
    }
}
