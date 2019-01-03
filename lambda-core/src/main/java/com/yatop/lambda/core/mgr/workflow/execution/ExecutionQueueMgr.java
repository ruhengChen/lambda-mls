package com.yatop.lambda.core.mgr.workflow.execution;

import com.yatop.lambda.base.model.WfExecutionQueue;
import com.yatop.lambda.base.model.WfExecutionQueueExample;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.JobSignalEnum;
import com.yatop.lambda.core.enums.JobStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExecutionQueueMgr extends BaseMgr {

    /*
     *
     *   插入新作业队列（作业ID、所属项目ID ...）
     *   返回插入记录
     *
     * */
    public WfExecutionQueue insertqueue(WfExecutionQueue jobQueue, String operId) {
        if( DataUtil.isNull(jobQueue) ||
                jobQueue.isJobIdNotColoured() ||
                jobQueue.isOwnerProjectIdNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert job queue failed -- invalid insert data.", "无效插入数据");
        }

        WfExecutionQueue insertQueue = new WfExecutionQueue();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertQueue.copyProperties(jobQueue);
            insertQueue.setJobId(jobQueue.getJobId());
            insertQueue.setOwnerProjectId(jobQueue.getJobId());
            insertQueue.setJobTime(dtCurrentTime);
            insertQueue.setJobState(JobStateEnum.QUEUEING.getState());
            insertQueue.setLastUpdateTime(dtCurrentTime);
            insertQueue.setLastUpdateOper(operId);
            insertQueue.setCreateTime(dtCurrentTime);
            insertQueue.setCreateOper(operId);
            wfExecutionQueueMapper.insertSelective(insertQueue);
            return insertQueue;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert job queue failed.", "插入作业队列失败", e);
        }
    }

    /*
     *
     *   移除作业队列
     *   返回删除数量
     *
     * */
    public int removeQueue(Long jobId) {
        if(DataUtil.isNull(jobId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete job queue -- invalid delete condition.", "无效删除条件");
        }

        try {
            return wfExecutionQueueMapper.deleteByPrimaryKey(jobId);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete job queue failed.", "删除作业队列失败", e);
        }
    }

    /*
     *
     *   更新作业队列（作业时间、作业信号、作业状态、描述）
     *   返回更新数量
     *
     * */
    public int updateQueue(WfExecutionQueue jobQueue, String operId) {
        if( DataUtil.isNull(jobQueue) || jobQueue.isJobIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update job queue failed -- invalid update condition.", "无效更新条件");
        }

        if(jobQueue.isJobTimeNotColoured() &&
                jobQueue.isJobSignalNotColoured() &&
                jobQueue.isJobStateNotColoured() &&
                jobQueue.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update job queue failed -- invalid update data.", "无效更新内容");
        }

        WfExecutionQueue updateQueue = new WfExecutionQueue();
        try {
            updateQueue.setJobId(jobQueue.getJobId());
            if(jobQueue.isJobTimeColoured())
                updateQueue.setJobTime(jobQueue.getJobTime());
            if(jobQueue.isJobSignalColoured())
                updateQueue.setJobSignal(jobQueue.getJobSignal());
            if(jobQueue.isJobStateColoured())
                updateQueue.setJobState(jobQueue.getJobState());
            if(jobQueue.isDescriptionColoured())
                updateQueue.setDescription(jobQueue.getDescription());

            updateQueue.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateQueue.setLastUpdateOper((operId));

            jobQueue.setLastUpdateTime(updateQueue.getLastUpdateTime());
            jobQueue.setLastUpdateOper(updateQueue.getLastUpdateOper());
            return wfExecutionQueueMapper.updateByPrimaryKeySelective(updateQueue);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update job queue failed.", "更新作业队列失败", e);
        }
    }

    /*
     *
     *   查询作业队列（按ID）
     *   返回结果
     *
     * */
    public WfExecutionQueue queryQueue(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job queue failed -- invalid query condition.", "无效查询条件");
        }

        WfExecutionQueue jobQueue;
        try {
            jobQueue = wfExecutionQueueMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job queue failed.", "查询作业队列失败", e);
        }

        if(DataUtil.isNull(jobQueue))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job queue failed -- invalid status or not found.", "已删除或未查找到");

        return jobQueue;
    }

    /*
     *
     *   查询作业队列（按作业状态 + [作业信号]）
     *   返回结果集
     *
     * */
    public List<WfExecutionQueue> queryQueue(JobStateEnum stateEnum, JobSignalEnum signalEnum, PagerUtil pager) {
        if(DataUtil.isNull(stateEnum)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job queue failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfExecutionQueueExample example = new WfExecutionQueueExample();
            WfExecutionQueueExample.Criteria cond = example.createCriteria().andJobStateEqualTo(stateEnum.getState());
            if(DataUtil.isNotNull(signalEnum))
                cond.andJobSignalEqualTo(signalEnum.getSignal());
            example.setOrderByClause("JOB_TIME ASC");
            return wfExecutionQueueMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job queue failed.", "查询作业队列失败", e);
        }
    }

    /*
     *
     *   查询作业队列（按项目ID + 作业状态）
     *   返回结果集
     *
     * */
    public List<WfExecutionQueue> queryQueue(Long projectId, JobStateEnum stateEnum, PagerUtil pager) {
        if(DataUtil.isNull(projectId) || DataUtil.isNull(stateEnum)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job queue failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfExecutionQueueExample example = new WfExecutionQueueExample();
            example.createCriteria().andOwnerProjectIdEqualTo(projectId).andJobStateEqualTo(stateEnum.getState());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfExecutionQueueMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job queue failed.", "查询作业队列失败", e);
        }
    }
}
