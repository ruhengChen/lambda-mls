package com.yatop.lambda.workflow.core.richmodel.workflow.snapshot;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.core.enums.SnapshotStateEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class Snapshot extends WfSnapshot implements IRichModel {

    public Snapshot(WfSnapshot data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
