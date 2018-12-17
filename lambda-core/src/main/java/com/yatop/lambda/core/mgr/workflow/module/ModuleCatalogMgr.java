package com.yatop.lambda.core.mgr.workflow.module;

import com.yatop.lambda.base.model.WfModuleCatalog;
import com.yatop.lambda.base.model.WfModuleCatalogExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;

import java.util.List;

public class ModuleCatalogMgr extends BaseMgr {

    /*
     *
     *   查询工作流组件目录
     *   返回结果集
     *
     * */
    public List<WfModuleCatalog> queryModuleCatalog() {

        try {
            WfModuleCatalogExample example = new WfModuleCatalogExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return  wfModuleCatalogMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow module catalog failed.", "查询工作流组件目录失败", e);
        }
    }
}
