package com.yatop.lambda.workflow.core.mgr.experiment;

import com.yatop.lambda.core.mgr.experiment.ExperimentTemplateMgr;
import com.yatop.lambda.workflow.core.richmodel.experiment.ExperimentTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExperimentTemplateHelper {

    private static ExperimentTemplateMgr EXPERIMENT_TEMPLATE_MGR;

    @Autowired
    public void setExperimentTemplateMgr(ExperimentTemplateMgr experimentTemplateMgr) {
        EXPERIMENT_TEMPLATE_MGR = experimentTemplateMgr;
    }

    public static ExperimentTemplate queryExperimentTemplate(Long templateId) {
        return new ExperimentTemplate(EXPERIMENT_TEMPLATE_MGR.queryDataTemplate(templateId));
    }
}
