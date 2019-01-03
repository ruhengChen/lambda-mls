package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.workflow.core.mgr.workflow.node.parameter.ParameterHelper;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;

public class NodeParameter extends WfFlowNodeParameter implements IRichModel {

    private CmptChar cmptChar;
    private CharValue value;
    private boolean simulateParameter;  //标记来自ParameterHelper.simulateParameter构建的模拟节点参数

    public NodeParameter(WfFlowNodeParameter data, CmptChar cmptChar, CharValue value) {
        this(data, cmptChar, value, false);
    }

    public NodeParameter(WfFlowNodeParameter data, CmptChar cmptChar, CharValue value, boolean simulateParameter) {
        super.copyProperties(data);
        this.cmptChar = cmptChar;
        this.value = value;
        this.simulateParameter = simulateParameter;
        this.clearColoured();
    }

    @Override
    public void clear() {
        cmptChar = null;
        value.clear();
        value = null;
        super.clear();
    }

    public void flush(String operId) {
        if(this.isColoured() && !simulateParameter) {
            ParameterHelper.updateNodeParameter(this, operId);
        }
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    public CharValue getValue() {
        return value;
    }

    public boolean isSimulateParameter() {
        return simulateParameter;
    }
}
