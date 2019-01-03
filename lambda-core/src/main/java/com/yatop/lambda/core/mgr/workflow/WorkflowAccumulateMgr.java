package com.yatop.lambda.core.mgr.workflow;

import com.yatop.lambda.base.model.WfFlowAccumulate;
import com.yatop.lambda.base.model.WfFlowAccumulateExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkflowAccumulateMgr extends BaseMgr {

    /*
     *
     *   插入新工作流累计信息（工作流ID、工作流组件ID、使用次数 ...）
     *   返回插入记录
     *
     * */
    public WfFlowAccumulate insertFlowAccumulate(WfFlowAccumulate flowAccumulate, String operId) {
        if( DataUtil.isNull(flowAccumulate) ||
                flowAccumulate.isFlowIdNotColoured() ||
                flowAccumulate.isModuleIdNotColoured() ||
                flowAccumulate.isUsageCountNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert workflow accumulate failed -- invalid insert data.", "无效插入数据");
        }

        WfFlowAccumulate insertFlowAccumulate = new WfFlowAccumulate();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertFlowAccumulate.copyProperties(flowAccumulate);
            insertFlowAccumulate.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertFlowAccumulate.setLastUpdateTime(dtCurrentTime);
            insertFlowAccumulate.setLastUpdateOper(operId);
            insertFlowAccumulate.setCreateTime(dtCurrentTime);
            insertFlowAccumulate.setCreateOper(operId);
            wfFlowAccumulateMapper.insertSelective(insertFlowAccumulate);
            return insertFlowAccumulate;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert workflow accumulate failed.", "插入工作流累计信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除工作流累计信息（按工作流ID删除）
     *   返回删除数量
     *
     * */
    public int deleteFlowAccumulate(Long workflowId, String operId) {
        if(DataUtil.isNull(workflowId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete workflow accumulate -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlowAccumulate deleteFlowAccumulate = new WfFlowAccumulate();
            deleteFlowAccumulate.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteFlowAccumulate.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteFlowAccumulate.setLastUpdateOper(operId);
            WfFlowAccumulateExample example = new WfFlowAccumulateExample();
            example.createCriteria().andFlowIdEqualTo(workflowId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowAccumulateMapper.updateByExampleSelective(deleteFlowAccumulate, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete workflow accumulate failed.", "删除工作流累计信息失败", e);
        }
    }

    /*
     *
     *   更新工作流累计信息（使用次数、描述）
     *   返回更新数量
     *
     * */
    public int updateFlowAccumulate(WfFlowAccumulate flowAccumulate, String operId) {
        if( DataUtil.isNull(flowAccumulate) || DataUtil.isNull(flowAccumulate.getFlowId()) || DataUtil.isNull(flowAccumulate.getModuleId()) || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update workflow accumulate failed -- invalid update condition.", "无效更新条件");
        }

        if(flowAccumulate.isUsageCountNotColoured() &&
                flowAccumulate.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update workflow accumulate failed -- invalid update data.", "无效更新内容");
        }

        WfFlowAccumulate updateFlowAccumulate = new WfFlowAccumulate();
        try {
            if(flowAccumulate.isUsageCountColoured())
                updateFlowAccumulate.setUsageCount(flowAccumulate.getUsageCount());
            if(flowAccumulate.isDescriptionColoured())
                updateFlowAccumulate.setDescription(flowAccumulate.getDescription());
            updateFlowAccumulate.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateFlowAccumulate.setLastUpdateOper((operId));

            flowAccumulate.setLastUpdateTime(updateFlowAccumulate.getLastUpdateTime());
            flowAccumulate.setLastUpdateOper(updateFlowAccumulate.getLastUpdateOper());

            WfFlowAccumulateExample example = new WfFlowAccumulateExample();
            example.createCriteria().andFlowIdEqualTo(flowAccumulate.getFlowId()).andModuleIdEqualTo(flowAccumulate.getModuleId()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowAccumulateMapper.updateByExampleSelective(updateFlowAccumulate, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update workflow accumulate failed.", "更新工作流累计信息失败", e);
        }
    }

    /*
     *
     *   查询工作流累计信息（按工作流ID）
     *   返回结果
     *
     * */
    public List<WfFlowAccumulate> queryFlowAccumulate(Long workflowId) {
        return queryFlowAccumulateExt(workflowId, null);
    }

    /*
     *
     *   查询工作流累计信息（按工作流ID + [工作流组件ID]）
     *   返回结果
     *
     * */
    public WfFlowAccumulate queryFlowAccumulate(Long workflowId, Long moduleId) {
        if(DataUtil.isNull(workflowId) || DataUtil.isNull(moduleId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow accumulate failed -- invalid query condition.", "无效查询条件");
        }

        List<WfFlowAccumulate> resultList = queryFlowAccumulateExt(workflowId, moduleId);
        return DataUtil.isNotEmpty(resultList) ? resultList.get(0) : null;
    }

    /*
     *
     *   查询工作流累计信息（按工作流ID + [工作流组件ID]）
     *   返回结果
     *
     * */
    public List<WfFlowAccumulate> queryFlowAccumulateExt(Long workflowId, Long moduleId) {
        if(DataUtil.isNull(workflowId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow accumulate failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfFlowAccumulateExample example = new WfFlowAccumulateExample();
            WfFlowAccumulateExample.Criteria cond = example.createCriteria().andFlowIdEqualTo(workflowId);
            if(DataUtil.isNotNull(moduleId))
                cond.andModuleIdEqualTo(moduleId);
            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowAccumulateMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow accumulate failed.", "查询工作流累计信息失败", e);
        }
    }

    /*
     *
     *   是否已存在工作流累计信息
     *   返回结果集
     *
     * */
/*    public boolean existsFlowAccumulate(Long workflowId, Long moduleId) {
        if(DataUtil.isNull(workflowId) || DataUtil.isNull(moduleId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check workflow accumulate exists failed -- invalid check condition.", "无效检查条件");
        }

        try {
            WfFlowAccumulateExample example = new WfFlowAccumulateExample();
            example.createCriteria().andFlowIdEqualTo(workflowId).andModuleIdEqualTo(moduleId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            return wfFlowAccumulateMapper.countByExample(example) > 0 ? true : false;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Check workflow accumulate exists failed.", "检查工作流累计信息是否已存在失败", e);
        }
    }*/
}
