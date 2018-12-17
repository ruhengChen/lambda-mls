package com.yatop.lambda.core.mgr.workflow.module;

import com.yatop.lambda.base.model.WfModule;
import com.yatop.lambda.base.model.WfModuleExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;

import java.util.List;

public class ModuleMgr extends BaseMgr {

    /*
     *
     *   查询工作流组件信息
     *   返回结果集
     *
     * */
    public List<WfModule> queryModule() {

        try {
            WfModuleExample example = new WfModuleExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfModuleMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow module catalog failed.", "查询工作流组件信息失败", e);
        }
    }
}
