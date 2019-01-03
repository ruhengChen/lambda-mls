package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class ModulePort extends WfModulePort implements IRichModel {

    private CmptChar cmptChar;  //关联计算组件特征

    public ModulePort(WfModulePort data, CmptChar cmptChar) {
        super.copyProperties(data);
        this.cmptChar = cmptChar;
        this.clearColoured();
    }

    @Override
    public void clear() {
        cmptChar = null;
        super.clear();
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }
}
