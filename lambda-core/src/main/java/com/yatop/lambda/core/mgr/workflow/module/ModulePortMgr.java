package com.yatop.lambda.core.mgr.workflow.module;

import com.yatop.lambda.base.model.WfModulePort;
import com.yatop.lambda.base.model.WfModulePortExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.exception.LambdaException;

import java.util.List;

public class ModulePortMgr extends BaseMgr {

    /*
     *
     *   查询工作流组件端口
     *   返回结果集
     *
     * */
    public List<WfModulePort> queryModulePort() {

        try {
            WfModulePortExample example = new WfModulePortExample();
            example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfModulePortMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow module catalog failed.", "查询工作流组件端口失败", e);
        }
    }
}
