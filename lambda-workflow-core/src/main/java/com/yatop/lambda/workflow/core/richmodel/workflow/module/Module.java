package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.TreeMap;

public class Module extends WfModule implements Comparable<Module>, IRichModel {

    private ModuleCatalog catalog;
    private Component component;
    private TreeMap<Long, ModulePort> inputPorts = new TreeMap<Long, ModulePort>();
    private TreeMap<Long, ModulePort> outputPorts = new TreeMap<Long, ModulePort>();

    public Module() {}

    public Module(WfModule data) {super.copyProperties(data);}

    @Override
    public int compareTo(Module o) {
        return this.getModuleId() < o.getModuleId() ?  -1 : (this.getModuleId() == o.getModuleId() ? 0 : 1);
    }

    @Override
    public void clear() {
        catalog = null;
        component = null;
        inputPorts.clear();
        inputPorts = null;
        outputPorts.clear();
        outputPorts = null;
        super.clear();
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public ModuleCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(ModuleCatalog catalog) {
        this.catalog = catalog;
    }

    public ModulePort getInputPort(Long inputPortId) {
        return CollectionUtil.get(inputPorts, inputPortId);
    }

    public void setInputPort(ModulePort inputPort) {
        CollectionUtil.put(inputPorts, inputPort.getPortId(), inputPort);
    }

    public ModulePort getOutputPort(Long outputPortId) {
        return CollectionUtil.get(outputPorts, outputPortId);
    }

    public void setOutputPort(ModulePort outputPort) {
        CollectionUtil.put(outputPorts, outputPort.getPortId(), outputPort);
    }
}
