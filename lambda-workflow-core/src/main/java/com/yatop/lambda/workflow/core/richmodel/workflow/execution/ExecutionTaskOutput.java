package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTaskOutput;
import com.yatop.lambda.core.enums.OutputStateEnum;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;

public class ExecutionTaskOutput extends RichModel<WfExecutionTaskOutput> {

    private CharValue charValue;

    public ExecutionTaskOutput(WfExecutionTaskOutput data, CharValue charValue) {
        super(data);
        this.charValue = charValue;
    }

    protected void flush(String operId) {

        if (this.isColoured())
            ;//NodeHelper.updateNode(this, operId);
    }

    @Override
    public void clear() {
        charValue = null;
        super.clear();
    }

    public CmptChar getCmptChar() {
        return charValue.getCmptChar();
    }

    public CharValue getCharValue() {
        return charValue;
    }

    public void changeState2Normal() {
        this.changeOutputState(OutputStateEnum.NORMAL);
    }

    private void changeOutputState(OutputStateEnum stateEnum) {
        if(this.data().getOutputState() == stateEnum.getState())
            return;

        this.data().setOutputState(stateEnum.getState());
    }
}
