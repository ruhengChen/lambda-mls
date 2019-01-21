package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptCharType;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;

public class NodePortInput extends RichModel<WfFlowNodePort> {

    private ModulePort modulePort;
    private boolean analyzed;

    public NodePortInput(WfFlowNodePort data, ModulePort modulePort) {
        super(data);
        this.modulePort = modulePort;
        this.analyzed = false;
    }

    @Override
    public void clear() {
        modulePort = null;
        super.clear();
    }

    public ModulePort getModulePort() {
        return modulePort;
    }

    public CmptChar getCmptChar() {
        return modulePort.getCmptChar();
    }

    public boolean isDataTablePort() {
        return modulePort.isDataTablePort();
    }

    public boolean isAnalyzed() {
        return analyzed;
    }

    protected void markAnalyzed() {
        this.analyzed = true;
    }

    public CmptCharType getType() {
        return this.getCmptChar().getType();
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return this.getCmptChar().getCharTypeClazzBean();
    }
}
