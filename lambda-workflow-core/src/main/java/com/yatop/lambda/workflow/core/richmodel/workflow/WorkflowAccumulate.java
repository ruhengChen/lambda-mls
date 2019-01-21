package com.yatop.lambda.workflow.core.richmodel.workflow;

import com.yatop.lambda.base.model.WfFlowAccumulate;
import com.yatop.lambda.workflow.core.mgr.workflow.WorkflowHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;

public class WorkflowAccumulate extends RichModel<WfFlowAccumulate> {

    public WorkflowAccumulate(WfFlowAccumulate data) {
        super(data);
        this.clearColoured();
    }

    public void flush(String operId) {
        if (this.isColoured()) {
            WorkflowHelper.updateAccumulate(this, operId);
        }
    }

    public Long increaseUsageCount() {
        this.data().setUsageCount(this.data().getUsageCount() + 1);
        return this.data().getUsageCount();
    }
}
