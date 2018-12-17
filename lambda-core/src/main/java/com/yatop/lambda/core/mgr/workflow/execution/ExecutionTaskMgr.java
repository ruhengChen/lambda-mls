package com.yatop.lambda.core.mgr.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.base.model.WfExecutionTaskExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.TaskStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExecutionTaskMgr extends BaseMgr {

    /*
     *
     *   插入新任务信息（名称、所属作业ID、任务序号、关联节点ID、计算引擎、任务上下文、提交文件、返回文件、日志文件 ...）
     *   返回插入记录
     *
     * */
    public WfExecutionTask insertTask(WfExecutionTask task, String operId) {
        if( DataUtil.isNull(task) ||
                task.isTaskNameNotColoured() ||
                task.isOwnerJobIdNotColoured() ||
                task.isSequenceNotColoured() ||
                task.isRelNodeIdNotColoured() ||
                task.isEngineTypeNotColoured() ||
                task.isTaskContextNotColoured() ||
                task.isSubmitFileNotColoured() ||
                task.isReturnFileNotColoured() ||
                task.isLogFileNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert task info failed -- invalid insert data.", "无效插入数据");
        }

        WfExecutionTask insertTask = new WfExecutionTask();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertTask.copyProperties(task);
            insertTask.setTaskIdColoured(false);
            insertTask.setExternalIdColoured(false);
            insertTask.setCostTimeColoured(false);
            insertTask.setTaskStartTimeColoured(false);
            insertTask.setTaskEndTimeColoured(false);
            insertTask.setTaskProgress(0);
            insertTask.setTaskState(TaskStateEnum.READY.getState());
            insertTask.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertTask.setLastUpdateTime(dtCurrentTime);
            insertTask.setLastUpdateOper(operId);
            insertTask.setCreateTime(dtCurrentTime);
            insertTask.setCreateOper(operId);
            wfExecutionTaskMapper.insertSelective(insertTask);
            return insertTask;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert task info failed.", "插入任务信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除任务信息（按作业，删除实验是否需要删除运行信息待定）
     *   返回删除数量
     *
     * */
    public int deleteTask(WfExecutionJob job, String operId) {
        if(DataUtil.isNull(job) || job.isJobIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete task info -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfExecutionTask deleteTask = new WfExecutionTask();
            deleteTask.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteTask.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteTask.setLastUpdateOper(operId);
            WfExecutionTaskExample example = new WfExecutionTaskExample();
            example.createCriteria().andOwnerJobIdEqualTo(job.getJobId());
            return wfExecutionTaskMapper.updateByExampleSelective(deleteTask, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete task info failed.", "删除任务信息失败", e);
        }
    }

    /*
     *
     *   更新任务信息（外部任务ID、运行耗时、开始时间、结束时间、任务进度、任务状态、描述）
     *   返回更新数量
     *
     * */
    public int updateTask(WfExecutionTask task, String operId) {
        if( DataUtil.isNull(task) || task.isTaskIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task info failed -- invalid update condition.", "无效更新条件");
        }

        if(task.isExternalIdNotColoured() &&
                task.isCostTimeNotColoured() &&
                task.isTaskStartTimeNotColoured() &&
                task.isTaskEndTimeNotColoured() &&
                task.isTaskProgressNotColoured() &&
                task.isTaskStateNotColoured() &&
                task.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task info failed -- invalid update data.", "无效更新内容");
        }

        WfExecutionTask updateTask = new WfExecutionTask();
        try {
            updateTask.setTaskId(task.getTaskId());
            if(task.isExternalIdColoured())
                updateTask.setExternalId(task.getExternalId());
            if(task.isCostTimeColoured())
                updateTask.setCostTime(task.getCostTime());
            if(task.isTaskStartTimeColoured())
                updateTask.setTaskStartTime(task.getTaskStartTime());
            if(task.isTaskEndTimeColoured())
                updateTask.setTaskEndTime(task.getTaskEndTime());
            if(task.isTaskProgressColoured())
                updateTask.setTaskProgress(task.getTaskProgress());
            if(task.isTaskStateColoured())
                updateTask.setTaskState(task.getTaskState());
            if(task.isDescriptionColoured())
                updateTask.setDescription(task.getDescription());

            updateTask.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateTask.setLastUpdateOper((operId));
            return wfExecutionTaskMapper.updateByPrimaryKeySelective(updateTask);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update task info failed.", "更新任务信息失败", e);
        }
    }

    /*
     *
     *   查询任务信息（按ID）
     *   返回结果
     *
     * */
    public WfExecutionTask queryTask(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed -- invalid query condition.", "无效查询条件");
        }

        WfExecutionTask task;
        try {
            task = wfExecutionTaskMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed.", "查询任务信息失败", e);
        }

        if(DataUtil.isNull(task) || (task.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed -- invalid status or not found.", "已删除或未查找到");

        return task;
    }

    /*
     *
     *   查询任务信息（按作业ID + 节点ID）
     *   返回结果集
     *
     * */
    public List<WfExecutionTask> queryTask(Long jobId, Long nodeId) {
        if(DataUtil.isNull(jobId) || DataUtil.isNull(nodeId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            WfExecutionTaskExample example = new WfExecutionTaskExample();
            example.createCriteria().andOwnerJobIdEqualTo(jobId).andRelNodeIdEqualTo(nodeId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfExecutionTaskMapper.selectByExample(example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed.", "查询任务信息失败", e);
        }
    }

    /*
     *
     *   查询任务信息（按作业ID + 任务状态）
     *   返回结果集
     *
     * */
    public List<WfExecutionTask> queryTask(Long jobId, TaskStateEnum stateEnum, PagerUtil pager) {
        if(DataUtil.isNull(jobId) || DataUtil.isNull(stateEnum)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfExecutionTaskExample example = new WfExecutionTaskExample();
            example.createCriteria().andOwnerJobIdEqualTo(jobId).andTaskStateEqualTo(stateEnum.getState()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfExecutionTaskMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed.", "查询任务信息失败", e);
        }
    }

    /*
     *
     *   查询任务信息（按作业ID）
     *   返回结果集
     *
     * */
    public List<WfExecutionTask> queryTaskByJobId(Long jobId, PagerUtil pager) {
        if(DataUtil.isNull(jobId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfExecutionTaskExample example = new WfExecutionTaskExample();
            example.createCriteria().andOwnerJobIdEqualTo(jobId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfExecutionTaskMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query task info failed.", "查询任务信息失败", e);
        }
    }
}
