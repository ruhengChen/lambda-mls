package com.yatop.lambda.core.mgr.workflow.execution;

import com.yatop.lambda.base.mapper.extend.WorkflowJobMapper;
import com.yatop.lambda.base.model.WfExecutionJob;
import com.yatop.lambda.base.model.WfExecutionJobExample;
import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.JobStateEnum;
import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.PagerUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExecutionJobMgr extends BaseMgr {

    @Autowired
    WorkflowJobMapper workflowJobMapper;

    /*
     *
     *   插入新作业信息（名称、作业类型、所属项目ID、关联工作流ID、关联快照ID、关联节点ID、DFS作业目录、本地作业目录 ...）
     *   返回插入记录
     *
     * */
    public WfExecutionJob insertJob(WfExecutionJob job, String operId) {
        if( DataUtil.isNull(job) ||
                job.isJobNameNotColoured() ||
                job.isJobTypeNotColoured() ||
                job.isOwnerProjectIdNotColoured() ||
                job.isRelFlowIdNotColoured() ||
                job.isRelSnapshotIdNotColoured() ||
                job.isRelNodeIdNotColoured() ||
                job.isJobDfsDirNotColoured() ||
                job.isJobLocalDirNotColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert job info failed -- invalid insert data.", "无效插入数据");
        }

        WfExecutionJob insertJob = new WfExecutionJob();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            insertJob.copyProperties(job);
            insertJob.setJobIdColoured(false);
            insertJob.setNextTaskSequence(1L);
            insertJob.setJobSubmitTimeColoured(false);
            insertJob.setJobStartTimeColoured(false);
            insertJob.setJobEndTimeColoured(false);
            insertJob.setJobState(JobStateEnum.PREPARING.getState());
            insertJob.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertJob.setLastUpdateTime(dtCurrentTime);
            insertJob.setLastUpdateOper(operId);
            insertJob.setCreateTime(dtCurrentTime);
            insertJob.setCreateOper(operId);
            wfExecutionJobMapper.insertSelective(insertJob);
            return insertJob;
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Insert job info failed.", "插入作业信息失败", e);
        }
    }

    /*
     *
     *   逻辑删除作业信息（按工作流，删除实验是否需要删除运行信息待定）
     *   返回删除数量
     *
     * */
    public int deleteJob(WfFlow flow, String operId) {
        if(DataUtil.isNull(flow) || flow.isOwnerProjectIdNotColoured() || flow.isFlowIdNotColoured() || DataUtil.isEmpty(operId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete job info -- invalid delete condition.", "无效删除条件");
        }

        try {
            WfExecutionJob deleteJob = new WfExecutionJob();
            deleteJob.setStatus(DataStatusEnum.INVALID.getStatus());
            deleteJob.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            deleteJob.setLastUpdateOper(operId);
            WfExecutionJobExample example = new WfExecutionJobExample();
            example.createCriteria().andOwnerProjectIdEqualTo(flow.getOwnerProjectId()).andRelFlowIdEqualTo(flow.getFlowId());
            return wfExecutionJobMapper.updateByExampleSelective(deleteJob, example);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete job info failed.", "删除作业信息失败", e);
        }
    }

    /*
     *
     *   更新作业信息（作业上下文、作业提交时间、作业开始时间、作业结束时间、作业状态、描述）
     *   返回更新数量
     *
     * */
    public int updateJob(WfExecutionJob job, String operId) {
        if( DataUtil.isNull(job) || job.isJobIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update job info failed -- invalid update condition.", "无效更新条件");
        }

        if(job.isJobContextNotColoured() &&
                job.isJobSubmitTimeNotColoured() &&
                job.isJobStartTimeNotColoured() &&
                job.isJobEndTimeNotColoured() &&
                job.isJobStateNotColoured() &&
                job.isDescriptionNotColoured()) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update job info failed -- invalid update data.", "无效更新内容");
        }

        WfExecutionJob updateJob = new WfExecutionJob();
        try {
            updateJob.setJobId(job.getJobId());
            if(job.isJobContextColoured())
                updateJob.setJobContext(job.getJobContext());
            if(job.isJobSubmitTimeColoured())
                updateJob.setJobSubmitTime(job.getJobSubmitTime());
            if(job.isJobStartTimeColoured())
                updateJob.setJobStartTime(job.getJobStartTime());
            if(job.isJobEndTimeColoured())
                updateJob.setJobEndTime(job.getJobEndTime());
            if(job.isJobStateColoured())
                updateJob.setJobState(job.getJobState());
            if(job.isDescriptionColoured())
                updateJob.setDescription(job.getDescription());

            updateJob.setLastUpdateTime(SystemTimeUtil.getCurrentTime());
            updateJob.setLastUpdateOper((operId));
            return wfExecutionJobMapper.updateByPrimaryKeySelective(updateJob);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update job info failed.", "更新作业信息失败", e);
        }
    }

    /*
     *
     *   作业任务序号增加
     *   返回更新数量
     *
     * */
    public int increaseTaskSequence(WfExecutionJob job, String operId) {
        if( DataUtil.isNull(job) || job.isJobIdNotColoured() || DataUtil.isEmpty(operId)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update job info failed -- invalid update condition.", "无效更新条件");
        }

        try {
            return workflowJobMapper.increaseTaskSequence(job.getJobId(), SystemTimeUtil.getCurrentTime(), operId);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Update job info failed.", "更新作业信息失败", e);
        }
    }

    /*
     *
     *   查询作业信息（按ID）
     *   返回结果
     *
     * */
    public WfExecutionJob queryJob(Long id) {
        if(DataUtil.isNull(id)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job info failed -- invalid query condition.", "无效查询条件");
        }

        WfExecutionJob job;
        try {
            job = wfExecutionJobMapper.selectByPrimaryKey(id);
        } catch (Throwable e) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job info failed.", "查询作业信息失败", e);
        }

        if(DataUtil.isNull(job) || (job.getStatus() == DataStatusEnum.INVALID.getStatus()))
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job info failed -- invalid status or not found.", "已删除或未查找到");

        return job;
    }

    /*
     *
     *   查询作业信息（按项目ID + 工作流ID）
     *   返回结果集
     *
     * */
    public List<WfExecutionJob> queryJob(Long projectId, Long flowId, PagerUtil pager) {
        if(DataUtil.isNull(projectId) || DataUtil.isNull(flowId)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfExecutionJobExample example = new WfExecutionJobExample();
            example.createCriteria().andOwnerProjectIdEqualTo(projectId).andRelFlowIdEqualTo(flowId).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfExecutionJobMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job info failed.", "查询作业信息失败", e);
        }
    }

    /*
     *
     *   查询作业信息（按项目ID + 作业类型）
     *   返回结果集
     *
     * */
    public List<WfExecutionJob> queryJob(Long projectId, JobTypeEnum typeEnum, PagerUtil pager) {
        if(DataUtil.isNull(projectId) || DataUtil.isNull(typeEnum)){
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job info failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PagerUtil.startPage(pager);
            WfExecutionJobExample example = new WfExecutionJobExample();
            example.createCriteria().andOwnerProjectIdEqualTo(projectId).andJobTypeEqualTo(typeEnum.getType()).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            example.setOrderByClause("CREATE_TIME ASC");
            return wfExecutionJobMapper.selectByExample(example);
        } catch (Throwable e) {
            PagerUtil.clearPage(pager);
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query job info failed.", "查询作业信息失败", e);
        }
    }
}
