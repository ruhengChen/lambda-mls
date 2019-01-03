package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.base.model.WfFlowAccumulate;
import com.yatop.lambda.core.enums.ShareLockStateEnum;
import com.yatop.lambda.core.enums.WorkflowStateEnum;
import com.yatop.lambda.workflow.core.mgr.workflow.WorkflowHelper;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class WorkflowAccumulate extends WfFlowAccumulate implements IRichModel {

    public WorkflowAccumulate(WfFlowAccumulate data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    public void flush(String operId) {
        if (this.isColoured()) {
            WorkflowHelper.updateAccumulate(this, operId);
        }
    }

    public Long increaseUsageCount() {
        this.setUsageCount(this.getUsageCount() + 1);
        return this.getUsageCount();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
