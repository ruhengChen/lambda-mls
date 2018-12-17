package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class ModulePort extends WfModulePort implements IRichModel {
    private Module module;
    private CmptChar cmptChar;

    public ModulePort() {}

    public ModulePort(WfModulePort data) {super.copyProperties(data);}

    @Override
    public void clear() {
        module = null;
        cmptChar = null;
        super.clear();
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public void setCmptChar(CmptChar cmptChar) {
        this.cmptChar = cmptChar;
    }
}
