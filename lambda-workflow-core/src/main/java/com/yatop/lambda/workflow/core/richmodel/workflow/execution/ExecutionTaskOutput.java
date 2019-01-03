package com.yatop.lambda.workflow.core.richmodel.workflow.execution;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.WfExecutionTaskOutput;
import com.yatop.lambda.core.enums.OutputStateEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;

public class ExecutionTaskOutput extends WfExecutionTaskOutput implements IRichModel {

    private CmptChar cmptChar;

    public ExecutionTaskOutput(WfExecutionTaskOutput data, CmptChar cmptChar) {
        super.copyProperties(data);
        this.cmptChar = cmptChar;
        this.clearColoured();
    }

    @Override
    public void clear() {
        cmptChar = null;
        super.clear();
    }

    public void changeOutputState2Normal() {
        this.changeOutputState(OutputStateEnum.NORMAL);
    }

    private void changeOutputState(OutputStateEnum stateEnum) {
        if(this.getOutputState() == stateEnum.getState())
            return;

        this.setOutputState(stateEnum.getState());
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }
}
