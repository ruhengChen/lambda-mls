package com.yatop.lambda.workflow.core.richmodel.component.specification;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.CfCmptSpecCharValue;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class CmptSpecCharValue extends CfCmptSpecCharValue implements IRichModel {

    private CmptChar cmptChar;
    private CmptSpec cmptSpec;

    public CmptSpecCharValue() {}

    public CmptSpecCharValue(CfCmptSpecCharValue data) {super.copyProperties(data);}

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

    public CmptSpec getCmptSpec() {
        return cmptSpec;
    }

    public void setCmptSpec(CmptSpec cmptSpec) {
        this.cmptSpec = cmptSpec;
    }
}
