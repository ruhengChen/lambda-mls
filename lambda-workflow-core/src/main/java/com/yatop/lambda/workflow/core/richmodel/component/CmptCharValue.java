package com.yatop.lambda.workflow.core.richmodel.component;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptCharValue;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class CmptCharValue extends CfCmptCharValue implements IRichModel {

    private CmptChar cmptChar;
    private Component component;

    public CmptCharValue() {}

    public CmptCharValue(CfCmptCharValue data) {super.copyProperties(data);}

    @Override
    public void clear() {
        cmptChar = null;
        super.clear();
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public void setCmptChar(CmptChar cmptChar) {
        this.cmptChar = cmptChar;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
}
