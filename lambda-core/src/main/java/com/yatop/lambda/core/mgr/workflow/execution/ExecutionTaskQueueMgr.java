package com.yatop.lambda.core.mgr.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionTaskQueue;
import com.yatop.lambda.base.model.WfExecutionTaskQueueExample;
import com.yatop.lambda.core.enums.TaskSignalEnum;
import com.yatop.lambda.core.enums.TaskStateEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExecutionTaskQueueMgr extends BaseMgr {

    /*
     *
     *   插入新任务队列（任务ID、所属项目ID ...）
     *   返回插入记录
     *
     * */
    public WfExecutionTaskQueue insertQueue(WfExecutionTaskQueue jobQueue, String operId) {
        if( DataUtil.isNull(jobQueue) ||
                jobQueue.isTaskIdNotColoured() ||
                jobQueue.isOwnerProjectIdNotColoured() ||
                jobQueue.isOwnerJobIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert task queue failed -- invalid insert data.", "无效插入数据");
        }

        WfExecutionTaskQueue insertQueue = new WfExecutionTaskQueue();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertQueue.copyProperties(jobQueue);
            insertQueue.setOwnerProjectId(jobQueue.getOwnerJobId());
            insertQueue.setOwnerJobId(jobQueue.getOwnerJobId());
            insertQueue.setTaskTime(dtCurrentTime);
            insertQueue.setTaskState(TaskStateEnum.READY.getState());
            insertQueue.setLastUpdateTime(dtCurrentTime);
            insertQueue.setLastUpdateOper(operId);
            insertQueue.setCreateTime(dtCurrentTime);
            insertQueue.setCreateOper(operId);
            wfExecutionTaskQueueMapper.insertSelective(insertQueue);
            return insertQueue;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert task queue failed.", "插入任务队列失败", e);
        }
    }

    /*
     *
     *   移除任务队列
     *   返回删除数量
     *
     * */
    public int removeQueue(Long jobId) {
        if(DataUtil.isNull(jobId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete task queue -- invalid delete condition.", "无效删除条件");
        }

        try {
            return wfExecutionTaskQueueMapper.deleteByPrimaryKey(jobId);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete task queue failed.", "删除任务队列失败", e);
        }
    }

    /*
     *
     *   更新任务队列（任务时间、任务信号、任务状态、描述）
     *   返回更新数量
     *
     * */
    public int updateQueue(WfExecutionTaskQueue jobQueue, String operId) {
        if( DataUtil.isNull(jobQueue) || jobQueue.isTaskIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task queue failed -- invalid update condition.", "无效更新条件");
        }

        if(jobQueue.isTaskTimeNotColoured() &&
                jobQueue.isTaskSignalNotColoured() &&
                jobQueue.isTaskStateNotColoured() &&
                jobQueue.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task queue failed -- invalid update data.", "无效更新内容");
        }

        WfExecutionTaskQueue updateQueue = new WfExecutionTaskQueue();
        try {
            updateQueue.setTaskId(jobQueue.getTaskId());
            if(jobQueue.isTaskTimeColoured())
                updateQueue.setTaskTime(jobQueue.getTaskTime());
            if(jobQueue.isTaskSignalColoured())
                updateQueue.setTaskSignal(jobQueue.getTaskSignal());
            if(jobQueue.isTaskStateColoured())
                updateQueue.setTaskState(jobQueue.getTaskState());
            if(jobQueue.isDescriptionColoured())
                updateQueue.setDescription(jobQueue.getDescription());

            updateQueue.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateQueue.setLastUpdateOper((operId));

            jobQueue.setLastUpdateTime(updateQueue.getLastUpdateTime());
            jobQueue.setLastUpdateOper(updateQueue.getLastUpdateOper());
            return wfExecutionTaskQueueMapper.updateByPrimaryKeySelective(updateQueue);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task queue failed.", "更新任务队列失败", e);
        }
    }

    /*
     *
     *   查询任务队列（按ID）
     *   返回结果
     *
     * */
    public WfExecutionTaskQueue queryQueue(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task queue failed -- invalid query condition.", "无效查询条件");
        }

        WfExecutionTaskQueue jobQueue;
        try {
            jobQueue = wfExecutionTaskQueueMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task queue failed.", "查询任务队列失败", e);
        }

        if(DataUtil.isNull(jobQueue))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task queue failed -- invalid status or not found.", "已删除或未查找到");

        return jobQueue;
    }

    /*
     *
     *   查询任务队列（按任务状态 + [任务信号]）
     *   返回结果集
     *
     * */
    public List<WfExecutionTaskQueue> queryQueue(TaskStateEnum stateEnum, TaskSignalEnum signalEnum, PagerUtil pager) {
        if(DataUtil.isNull(stateEnum)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task queue failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfExecutionTaskQueueExample example = new WfExecutionTaskQueueExample();
            WfExecutionTaskQueueExample.Criteria cond = example.createCriteria().andTaskStateEqualTo(stateEnum.getState());
            if(DataUtil.isNotNull(signalEnum))
                cond.andTaskSignalEqualTo(signalEnum.getSignal());
            example.setOrderByClause("TASK_TIME ASC");
            return wfExecutionTaskQueueMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task queue failed.", "查询任务队列失败", e);
        }
    }

    /*
     *
     *   查询任务队列（按项目ID + 任务状态）
     *   返回结果集
     *
     * */
    public List<WfExecutionTaskQueue> queryQueue(Long projectId, TaskStateEnum stateEnum, PagerUtil pager) {
        if(DataUtil.isNull(projectId) || DataUtil.isNull(stateEnum)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task queue failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfExecutionTaskQueueExample example = new WfExecutionTaskQueueExample();
            example.createCriteria().andOwnerProjectIdEqualTo(projectId).andTaskStateEqualTo(stateEnum.getState());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfExecutionTaskQueueMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task queue failed.", "查询任务队列失败", e);
        }
    }
}
