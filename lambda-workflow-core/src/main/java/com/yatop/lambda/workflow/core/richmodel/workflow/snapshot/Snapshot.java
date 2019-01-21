package com.yatop.lambda.workflow.core.richmodel.workflow.snapshot;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.model.EmExperiment;
import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.core.enums.SnapshotStateEnum;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.snapshot.SnapshotHelper;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.experiment.Experiment;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;

public class Snapshot extends RichModel<WfSnapshot> {

    private JSONObject content;

    public Snapshot(WfSnapshot data) {
        super(data);
    }

    public void flush(String operId) {
        if(this.isColoured()) {
            SnapshotHelper.updateSnapshot(this, operId);
        }
    }

    public void updateContent(WorkflowContext workflowContext) {
        //TODO create 和 update 注意parameter duplicate flag区分处理
    }

    private void parseContent() {
        //Query Project
        //Experiment
        //Workflow
    }

    public Workflow getWorkflow() {

        JSONObject jsonExperiment = content.getJSONObject("experiment");
        EmExperiment experiment = jsonExperiment.toJavaObject(EmExperiment.class);
        Experiment richExperiment = new Experiment(experiment, );


        JSONObject jsonWorkflow = content.getJSONObject("workflow");
        WfFlow workflow = jsonWorkflow.toJavaObject(WfFlow.class);
        return new Workflow(workflow, );
    }
}
