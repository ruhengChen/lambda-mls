package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;

public class NodePortInput extends WfFlowNodePort implements IRichModel {

    private ModulePort modulePort;
    private boolean deleted;

    public NodePortInput(WfFlowNodePort data, ModulePort modulePort) {
        super.copyProperties(data);
        this.modulePort = modulePort;
        this.deleted = false;
        this.clearColoured();
    }

    @Override
    public void clear() {
        modulePort = null;
        super.clear();
    }

    public ModulePort getModulePort() {
        return modulePort;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }
}
