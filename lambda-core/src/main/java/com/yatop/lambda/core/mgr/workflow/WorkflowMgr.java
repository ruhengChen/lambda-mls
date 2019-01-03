package com.yatop.lambda.core.mgr.workflow;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.base.model.WfFlowExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.ShareLockStateEnum;
import com.yatop.lambda.core.enums.WorkflowStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkflowMgr extends BaseMgr {

    /*
     *
     *   插入新工作流信息（工作流ID<同实验ID>、名称、所属项目ID ...）
     *   返回插入记录
     *
     * */
    public WfFlow insertWorkflow(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow) ||
                workflow.isFlowIdNotColoured() ||
                workflow.isFlowNameNotColoured() ||
                workflow.isOwnerProjectIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert workflow info failed -- invalid insert data.", "无效插入数据");
        }

        WfFlow insertWorkflow = new WfFlow();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertWorkflow.copyProperties(workflow);
            insertWorkflow.setShareLockState(ShareLockStateEnum.UNLOCKED.getState());
            insertWorkflow.setShareLockMsgColoured(false);
            insertWorkflow.setNextSnapshotVersion(1L);
            insertWorkflow.setNodeCount(0L);
            insertWorkflow.setNextDeleteSequence(0L);
            insertWorkflow.setLastJobIdColoured(false);
            insertWorkflow.setFlowDfsDirColoured(false);
            insertWorkflow.setFlowLocalDirColoured(false);
            insertWorkflow.setFlowState(WorkflowStateEnum.DRAFT.getState());
            insertWorkflow.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertWorkflow.setLastUpdateTime(dtCurrentTime);
            insertWorkflow.setLastUpdateOper(operId);
            insertWorkflow.setCreateTime(dtCurrentTime);
            insertWorkflow.setCreateOper(operId);
            insertWorkflow.setVersion(1L);
            wfFlowMapper.insertSelective(insertWorkflow);
            return insertWorkflow;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert workflow info failed.", "插入工作流信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除工作流信息
     *   返回删除数量
     *
     * */
    public int deleteWorkflow(Long workflowId, String operId) {
        if(DataUtil.isNull(workflowId) || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete workflow info -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfFlow deleteWorkflow = new WfFlow();
            deleteWorkflow.setFlowId(workflowId);
            deleteWorkflow.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteWorkflow.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteWorkflow.setLastUpdateOper(operId);
            WfFlowExample example = new WfFlowExample();
            return wfFlowMapper.updateByPrimaryKeySelective(deleteWorkflow);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete workflow info failed.", "删除工作流信息失败", e);
        }
    }

    /*
     *
     *   更新工作流信息（名称、共享锁状态、共享锁消息、下一快照版本、节点数量、下一删除批次、最后作业ID、DFS工作流目录、本地工作流目录、
     *                   工作流状态、描述、版本号）
     *   返回更新数量
     *
     * */
    public int updateWorkflow(WfFlow workflow, String operId) {
        if( DataUtil.isNull(workflow)  || DataUtil.isNull(workflow.getFlowId()) || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update workflow info failed -- invalid update condition.", "无效更新条件");
        }

        if(workflow.isFlowNameNotColoured() &&
                workflow.isShareLockStateNotColoured() &&
                workflow.isNextSnapshotVersionNotColoured() &&
                workflow.isNodeCountNotColoured() &&
                workflow.isNextDeleteSequenceNotColoured() &&
                workflow.isLastJobIdNotColoured() &&
                workflow.isFlowDfsDirNotColoured() &&
                workflow.isFlowLocalDirNotColoured() &&
                workflow.isFlowStateNotColoured() &&
                workflow.isDescriptionNotColoured() &&
                workflow.isVersionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update workflow info failed -- invalid update data.", "无效更新内容");
        }

        WfFlow updateWorkflow = new WfFlow();
        try {
            updateWorkflow.setFlowId(workflow.getFlowId());
            if(workflow.isFlowNameColoured())
                updateWorkflow.setFlowName(workflow.getFlowName());
            if(workflow.isShareLockStateColoured())
                updateWorkflow.setShareLockState(workflow.getShareLockState());
            if(workflow.isShareLockMsgColoured())
                updateWorkflow.setShareLockMsg(workflow.getShareLockMsg());
            if(workflow.isNextSnapshotVersionColoured())
                updateWorkflow.setNextSnapshotVersion(workflow.getNextSnapshotVersion());
            if(workflow.isNodeCountColoured())
                updateWorkflow.setNodeCount(workflow.getNodeCount());
            if(workflow.isNextDeleteSequenceColoured())
                updateWorkflow.setNextDeleteSequence(workflow.getNextDeleteSequence());
            if(workflow.isLastJobIdColoured())
                updateWorkflow.setLastJobId(workflow.getLastJobId());
            if(workflow.isFlowDfsDirColoured())
                updateWorkflow.setFlowDfsDir(workflow.getFlowDfsDir());
            if(workflow.isFlowLocalDirColoured())
                updateWorkflow.setFlowLocalDir(workflow.getFlowLocalDir());
            if(workflow.isDescriptionColoured())
                updateWorkflow.setDescription(workflow.getDescription());
            if(workflow.isVersionColoured())
                updateWorkflow.setVersion(workflow.getVersion());

            updateWorkflow.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateWorkflow.setLastUpdateOper((operId));

            workflow.setLastUpdateTime(updateWorkflow.getLastUpdateTime());
            workflow.setLastUpdateOper(updateWorkflow.getLastUpdateOper());
            return wfFlowMapper.updateByPrimaryKeySelective(updateWorkflow);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update workflow info failed.", "更新工作流信息失败", e);
        }
    }

    /*
     *
     *   查询工作流信息（按工作流ID<同实验ID>）
     *   返回结果
     *
     * */
    public WfFlow queryWorkflow(Long workflowId) {
        if(DataUtil.isNull(workflowId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow info failed -- invalid query condition.", "无效查询条件");
        }

        WfFlow workflow;
        try {
            workflow = wfFlowMapper.selectByPrimaryKey(workflowId);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow info failed.", "查询工作流信息失败", e);
        }

        if(DataUtil.isNull(workflow) || (workflow.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow info failed -- invalid status or not found.", "已删除或未查找到");

        return workflow;
    }

    /*
     *
     *   查询工作流信息（按项目ID）
     *   返回结果集
     *
     * */
    public List<WfFlow> queryWorkflow(Long projectId, PagerUtil pager) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfFlowExample example = new WfFlowExample();
            example.createCriteria().andOwnerProjectIdEqualTo(projectId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfFlowMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query workflow info failed.", "查询工作流信息失败", e);
        }
    }
}
