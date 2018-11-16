package com.yatop.lambda.core.mangement;

import org.springframework.beans.factory.annotation.Autowired;
import com.yatop.lambda.base.mapper.*;

public class BaseMgnt {

    @Autowired
    CfCmptAlgorithmMapper cfCmptAlgorithmMapper;

    @Autowired
    CfCmptCharEnumMapper cfCmptCharEnumMapper;

    @Autowired
    CfCmptCharMapper cfCmptCharMapper;

    @Autowired
    CfCmptCharTypeMapper cfCmptCharTypeMapper;

    @Autowired
    CfCmptCharValueMapper cfCmptCharValueMapper;

    @Autowired
    CfCmptSpecCharRelMapper cfCmptSpecCharRelMapper;

    @Autowired
    CfCmptSpecCharValueMapper cfCmptSpecCharValueMapper;

    @Autowired
    CfCmptSpecMapper cfCmptSpecMapper;

    @Autowired
    CfCmptSpecRelMapper cfCmptSpecRelMapper;

    @Autowired
    CfComponentMapper cfComponentMapper;

    @Autowired
    DwDataTableMapper dwDataTableMapper;

    @Autowired
    DwDataWarehouseMapper dwDataWarehouseMapper;

    @Autowired
    EmExperimentMapper emExperimentMapper;

    @Autowired
    EmExperimentTemplateMapper emExperimentTemplateMapper;

    @Autowired
    MwModelEvaluationReportMapper mwModelEvaluationReportMapper;

    @Autowired
    MwModelMapper mwModelMapper;

    @Autowired
    MwModelWarehouseMapper mwModelWarehouseMapper;

    @Autowired
    PrProjectMapper prProjectMapper;

    @Autowired
    PrProjectMemberMapper prProjectMemberMapper;

    @Autowired
    SysParameterMapper sysParameterMapper;

    @Autowired
    WfCodeScriptMapper wfCodeScriptMapper;

    @Autowired
    WfExecutionForkMapper wfExecutionForkMapper;

    @Autowired
    WfExecutionForkPathMapper wfExecutionForkPathMapper;

    @Autowired
    WfExecutionJobMapper wfExecutionJobMapper;

    @Autowired
    WfExecutionJoinMapper wfExecutionJoinMapper;

    @Autowired
    WfExecutionJoinPathMapper wfExecutionJoinPathMapper;

    @Autowired
    WfExecutionPathMapper wfExecutionPathMapper;

    @Autowired
    WfExecutionQueueMapper wfExecutionQueueMapper;

    @Autowired
    WfExecutionTaskMapper wfExecutionTaskMapper;

    @Autowired
    WfFlowGlobalParameterMapper wfFlowGlobalParameterMapper;

    @Autowired
    WfFlowMapper wfFlowMapper;

    @Autowired
    WfFlowNodeLinkMapper wfFlowNodeLinkMapper;

    @Autowired
    WfFlowNodeMapper wfFlowNodeMapper;

    @Autowired
    WfFlowNodeParameterMapper wfFlowNodeParameterMapper;

    @Autowired
    WfFlowNodePortMapper wfFlowNodePortMapper;

    @Autowired
    WfFlowNodeSchemaMapper wfFlowNodeSchemaMapper;

    @Autowired
    WfJsonObjectMapper wfJsonObjectMapper;

    @Autowired
    WfModuleCatalogMapper wfModuleCatalogMapper;

    @Autowired
    WfModuleMapper wfModuleMapper;

    @Autowired
    WfModulePortMapper wfModulePortMapper;

    @Autowired
    WfSnapshotMapper wfSnapshotMapper;
}
