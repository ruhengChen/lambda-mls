package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeParameter;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.mgr.workflow.node.parameter.ParameterHelper;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;

public class NodeParameter extends RichModel<WfFlowNodeParameter> implements Comparable<NodeParameter> {

    private CharValue charValue;
    private boolean simulateParameter;  //标记来自ParameterHelper.simulateParameter构建的模拟节点参数

    public NodeParameter(WfFlowNodeParameter data, CharValue charValue) {
        this(data, charValue, false);
    }

    public NodeParameter(WfFlowNodeParameter data, CharValue charValue, boolean simulateParameter) {
        super(data);
        this.charValue = charValue;
        this.simulateParameter = simulateParameter;
    }

    @Override
    public int compareTo(NodeParameter o) {
        return this.getCmptChar().data().getCharId().compareTo(o.getCmptChar().data().getCharId());
    }

    @Override
    public void clear() {
        charValue = null;
        super.clear();
    }

    protected void flush(String operId) {
        if(this.isColoured() && !simulateParameter) {
            ParameterHelper.updateNodeParameter(this, operId);
        }
    }

    public CmptChar getCmptChar() {
        return charValue.getCmptChar();
    }

    public CharValue getCharValue() {
        return charValue;
    }

    public String getTextValue() {
        return this.getCharValue().getTextValue();
    }

    public IRichModel getObjectValue() {
        return this.getCharValue().getObjectValue();
    }

    public boolean isSimulateParameter() {
        return simulateParameter;
    }

    public boolean isOccuredWarning() {
        return DataUtil.isNotEmpty(this.data().getWarningMsg());
    }

    public void changeOccuredWarning(String warningMsg) {
        if(!DataUtil.equals(this.data().getWarningMsg(), warningMsg)) {
            this.data().setWarningMsg(warningMsg);
        }
    }

    public void clearOccuredWarning() {
        if(this.isOccuredWarning()) {
            this.changeOccuredWarning(null);
        }
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return this.getCmptChar().getCharTypeClazzBean();
    }
}
