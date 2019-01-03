package com.yatop.lambda.core.mgr.base;

import org.springframework.beans.factory.annotation.Autowired;
import com.yatop.lambda.base.mapper.*;

public class BaseMgr {

    @Autowired
    protected DwDataTableMapper dwDataTableMapper;

    @Autowired
    protected DwDataWarehouseMapper dwDataWarehouseMapper;

    @Autowired
    protected EmExperimentMapper emExperimentMapper;

    @Autowired
    protected EmExperimentTemplateMapper emExperimentTemplateMapper;

    @Autowired
    protected MwModelMapper mwModelMapper;

    @Autowired
    protected MwModelWarehouseMapper mwModelWarehouseMapper;

    @Autowired
    protected PrProjectMapper prProjectMapper;

    @Autowired
    protected PrProjectMemberMapper prProjectMemberMapper;

    @Autowired
    protected WfCodeScriptMapper wfCodeScriptMapper;

    @Autowired
    protected WfExecutionJobMapper wfExecutionJobMapper;

    @Autowired
    protected WfExecutionQueueMapper wfExecutionQueueMapper;

    @Autowired
    protected WfExecutionTaskMapper wfExecutionTaskMapper;

    @Autowired
    protected WfExecutionTaskOutputMapper wfExecutionTaskOutputMapper;

    @Autowired
    protected WfFlowGlobalParameterMapper wfFlowGlobalParameterMapper;

    @Autowired
    protected WfFlowMapper wfFlowMapper;

    @Autowired
    protected WfFlowAccumulateMapper wfFlowAccumulateMapper;

    @Autowired
    protected WfFlowNodeDeleteQueueMapper wfFlowNodeDeleteQueueMapper;

    @Autowired
    protected WfFlowNodeLinkMapper wfFlowNodeLinkMapper;

    @Autowired
    protected WfFlowNodeMapper wfFlowNodeMapper;

    @Autowired
    protected WfFlowNodeParameterMapper wfFlowNodeParameterMapper;

    @Autowired
    protected WfFlowNodePortMapper wfFlowNodePortMapper;

    @Autowired
    protected WfFlowNodeSchemaMapper wfFlowNodeSchemaMapper;

    @Autowired
    protected WfJsonObjectMapper wfJsonObjectMapper;

    @Autowired
    protected WfSnapshotMapper wfSnapshotMapper;

    @Autowired
    protected WfUserFavoriteModuleMapper wfUserFavoriteModuleMapper;

    @Autowired
    protected WfUserFavoriteTableMapper wfUserFavoriteTableMapper;

    //配置数据Mapper

    @Autowired
    protected SysParameterMapper sysParameterMapper;

    @Autowired
    protected CfCmptAlgorithmMapper cfCmptAlgorithmMapper;

    @Autowired
    protected CfCmptCharEnumMapper cfCmptCharEnumMapper;

    @Autowired
    protected CfCmptCharMapper cfCmptCharMapper;

    @Autowired
    protected CfCmptCharTypeMapper cfCmptCharTypeMapper;

    @Autowired
    protected CfCmptCharTypeWildMapper cfCmptCharTypeWildMapper;

    @Autowired
    protected CfCmptCharValueMapper cfCmptCharValueMapper;

    @Autowired
    protected CfCmptSpecCharRelMapper cfCmptSpecCharRelMapper;

    @Autowired
    protected CfCmptSpecCharValueMapper cfCmptSpecCharValueMapper;

    @Autowired
    protected CfCmptSpecMapper cfCmptSpecMapper;

    @Autowired
    protected CfCmptSpecRelMapper cfCmptSpecRelMapper;

    @Autowired
    protected CfComponentMapper cfComponentMapper;

    @Autowired
    protected WfModuleCatalogMapper wfModuleCatalogMapper;

    @Autowired
    protected WfModuleMapper wfModuleMapper;

    @Autowired
    protected WfModulePortMapper wfModulePortMapper;
}
