package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_execution_job")
public class WfExecutionJob implements Serializable {
    /**
     * 作业ID
     */
    @Id
    @Column(name = "JOB_ID")
    private Long jobId;

    /**
     * 作业名称，自动生成
     */
    @Column(name = "JOB_NAME")
    private String jobName;

    /**
     * 作业类型
            0：全部运行
            1：从此处开始运行
            2：执行到此处
            3：执行该节点
            10：全部运行（小数据试运行）
            11：从此处开始运行（小数据试运行）
            12：执行到此处（小数据试运行）
            13：执行该节点（小数据试运行）
            20：定时调度运行
            30：在线调度运行
            99：非实验中的任务运行（数据文件上传）
     */
    @Column(name = "JOB_TYPE")
    private Integer jobType;

    /**
     * 所属项目ID
     */
    @Column(name = "OWNER_PROJECT_ID")
    private Long ownerProjectId;

    /**
     * 关联工作流ID，无关联工作流设为-1
     */
    @Column(name = "REL_FLOW_ID")
    private Long relFlowId;

    /**
     * 关联快照ID，无关联则设为-1
     */
    @Column(name = "REL_SNAPSHOT_ID")
    private Long relSnapshotId;

    /**
     * 关联节点ID，填写与触发运行相关的节点ID，无关联则设为-1
     */
    @Column(name = "REL_NODE_ID")
    private Long relNodeId;

    /**
     * DFS运行目录
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>
            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/other/<exec_id>
     */
    @Column(name = "DFS_EXEC_DIR")
    private String dfsExecDir;

    /**
     * 本地运行目录（预留）
            
            ${LOCAL_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>
            ${LOCAL_WORK_ROOT}/proc/<project_id>/other/<exec_id>
     */
    @Column(name = "LOCAL_EXEC_DIR")
    private String localExecDir;

    /**
     * 作业提交时间
     */
    @Column(name = "JOB_SUBMIT_TIME")
    private Date jobSubmitTime;

    /**
     * 作业开始时间
     */
    @Column(name = "JOB_START_TIME")
    private Date jobStartTime;

    /**
     * 作业结束时间
     */
    @Column(name = "JOB_END_TIME")
    private Date jobEndTime;

    /**
     * 作业状态
            0：preparing，准备中
            1：queueing，排队中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户终止
     */
    @Column(name = "JOB_STATE")
    private Integer jobState;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 状态
            0：正常
            1：失效
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 最后更新时间
     */
    @Column(name = "LAST_UPDATE_TIME")
    private Date lastUpdateTime;

    /**
     * 最后更新用户
     */
    @Column(name = "LAST_UPDATE_OPER")
    private String lastUpdateOper;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建用户
     */
    @Column(name = "CREATE_OPER")
    private String createOper;

    /**
     * 任务上下文
     */
    @Column(name = "JOB_CONTENT")
    private String jobContent;

    private static final long serialVersionUID = 1L;

    /**
     * 获取作业ID
     *
     * @return JOB_ID - 作业ID
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * 设置作业ID
     *
     * @param jobId 作业ID
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * 获取作业名称，自动生成
     *
     * @return JOB_NAME - 作业名称，自动生成
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置作业名称，自动生成
     *
     * @param jobName 作业名称，自动生成
     */
    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    /**
     * 获取作业类型
            0：全部运行
            1：从此处开始运行
            2：执行到此处
            3：执行该节点
            10：全部运行（小数据试运行）
            11：从此处开始运行（小数据试运行）
            12：执行到此处（小数据试运行）
            13：执行该节点（小数据试运行）
            20：定时调度运行
            30：在线调度运行
            99：非实验中的任务运行（数据文件上传）
     *
     * @return JOB_TYPE - 作业类型
            0：全部运行
            1：从此处开始运行
            2：执行到此处
            3：执行该节点
            10：全部运行（小数据试运行）
            11：从此处开始运行（小数据试运行）
            12：执行到此处（小数据试运行）
            13：执行该节点（小数据试运行）
            20：定时调度运行
            30：在线调度运行
            99：非实验中的任务运行（数据文件上传）
     */
    public Integer getJobType() {
        return jobType;
    }

    /**
     * 设置作业类型
            0：全部运行
            1：从此处开始运行
            2：执行到此处
            3：执行该节点
            10：全部运行（小数据试运行）
            11：从此处开始运行（小数据试运行）
            12：执行到此处（小数据试运行）
            13：执行该节点（小数据试运行）
            20：定时调度运行
            30：在线调度运行
            99：非实验中的任务运行（数据文件上传）
     *
     * @param jobType 作业类型
            0：全部运行
            1：从此处开始运行
            2：执行到此处
            3：执行该节点
            10：全部运行（小数据试运行）
            11：从此处开始运行（小数据试运行）
            12：执行到此处（小数据试运行）
            13：执行该节点（小数据试运行）
            20：定时调度运行
            30：在线调度运行
            99：非实验中的任务运行（数据文件上传）
     */
    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    /**
     * 获取所属项目ID
     *
     * @return OWNER_PROJECT_ID - 所属项目ID
     */
    public Long getOwnerProjectId() {
        return ownerProjectId;
    }

    /**
     * 设置所属项目ID
     *
     * @param ownerProjectId 所属项目ID
     */
    public void setOwnerProjectId(Long ownerProjectId) {
        this.ownerProjectId = ownerProjectId;
    }

    /**
     * 获取关联工作流ID，无关联工作流设为-1
     *
     * @return REL_FLOW_ID - 关联工作流ID，无关联工作流设为-1
     */
    public Long getRelFlowId() {
        return relFlowId;
    }

    /**
     * 设置关联工作流ID，无关联工作流设为-1
     *
     * @param relFlowId 关联工作流ID，无关联工作流设为-1
     */
    public void setRelFlowId(Long relFlowId) {
        this.relFlowId = relFlowId;
    }

    /**
     * 获取关联快照ID，无关联则设为-1
     *
     * @return REL_SNAPSHOT_ID - 关联快照ID，无关联则设为-1
     */
    public Long getRelSnapshotId() {
        return relSnapshotId;
    }

    /**
     * 设置关联快照ID，无关联则设为-1
     *
     * @param relSnapshotId 关联快照ID，无关联则设为-1
     */
    public void setRelSnapshotId(Long relSnapshotId) {
        this.relSnapshotId = relSnapshotId;
    }

    /**
     * 获取关联节点ID，填写与触发运行相关的节点ID，无关联则设为-1
     *
     * @return REL_NODE_ID - 关联节点ID，填写与触发运行相关的节点ID，无关联则设为-1
     */
    public Long getRelNodeId() {
        return relNodeId;
    }

    /**
     * 设置关联节点ID，填写与触发运行相关的节点ID，无关联则设为-1
     *
     * @param relNodeId 关联节点ID，填写与触发运行相关的节点ID，无关联则设为-1
     */
    public void setRelNodeId(Long relNodeId) {
        this.relNodeId = relNodeId;
    }

    /**
     * 获取DFS运行目录
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>
            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/other/<exec_id>
     *
     * @return DFS_EXEC_DIR - DFS运行目录
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>
            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/other/<exec_id>
     */
    public String getDfsExecDir() {
        return dfsExecDir;
    }

    /**
     * 设置DFS运行目录
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>
            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/other/<exec_id>
     *
     * @param dfsExecDir DFS运行目录
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>
            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/other/<exec_id>
     */
    public void setDfsExecDir(String dfsExecDir) {
        this.dfsExecDir = dfsExecDir == null ? null : dfsExecDir.trim();
    }

    /**
     * 获取本地运行目录（预留）
            
            ${LOCAL_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>
            ${LOCAL_WORK_ROOT}/proc/<project_id>/other/<exec_id>
     *
     * @return LOCAL_EXEC_DIR - 本地运行目录（预留）
            
            ${LOCAL_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>
            ${LOCAL_WORK_ROOT}/proc/<project_id>/other/<exec_id>
     */
    public String getLocalExecDir() {
        return localExecDir;
    }

    /**
     * 设置本地运行目录（预留）
            
            ${LOCAL_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>
            ${LOCAL_WORK_ROOT}/proc/<project_id>/other/<exec_id>
     *
     * @param localExecDir 本地运行目录（预留）
            
            ${LOCAL_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>
            ${LOCAL_WORK_ROOT}/proc/<project_id>/other/<exec_id>
     */
    public void setLocalExecDir(String localExecDir) {
        this.localExecDir = localExecDir == null ? null : localExecDir.trim();
    }

    /**
     * 获取作业提交时间
     *
     * @return JOB_SUBMIT_TIME - 作业提交时间
     */
    public Date getJobSubmitTime() {
        return jobSubmitTime;
    }

    /**
     * 设置作业提交时间
     *
     * @param jobSubmitTime 作业提交时间
     */
    public void setJobSubmitTime(Date jobSubmitTime) {
        this.jobSubmitTime = jobSubmitTime;
    }

    /**
     * 获取作业开始时间
     *
     * @return JOB_START_TIME - 作业开始时间
     */
    public Date getJobStartTime() {
        return jobStartTime;
    }

    /**
     * 设置作业开始时间
     *
     * @param jobStartTime 作业开始时间
     */
    public void setJobStartTime(Date jobStartTime) {
        this.jobStartTime = jobStartTime;
    }

    /**
     * 获取作业结束时间
     *
     * @return JOB_END_TIME - 作业结束时间
     */
    public Date getJobEndTime() {
        return jobEndTime;
    }

    /**
     * 设置作业结束时间
     *
     * @param jobEndTime 作业结束时间
     */
    public void setJobEndTime(Date jobEndTime) {
        this.jobEndTime = jobEndTime;
    }

    /**
     * 获取作业状态
            0：preparing，准备中
            1：queueing，排队中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户终止
     *
     * @return JOB_STATE - 作业状态
            0：preparing，准备中
            1：queueing，排队中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户终止
     */
    public Integer getJobState() {
        return jobState;
    }

    /**
     * 设置作业状态
            0：preparing，准备中
            1：queueing，排队中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户终止
     *
     * @param jobState 作业状态
            0：preparing，准备中
            1：queueing，排队中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户终止
     */
    public void setJobState(Integer jobState) {
        this.jobState = jobState;
    }

    /**
     * 获取描述
     *
     * @return DESCRIPTION - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取状态
            0：正常
            1：失效
     *
     * @return STATUS - 状态
            0：正常
            1：失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
            0：正常
            1：失效
     *
     * @param status 状态
            0：正常
            1：失效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取最后更新时间
     *
     * @return LAST_UPDATE_TIME - 最后更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastUpdateTime 最后更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取最后更新用户
     *
     * @return LAST_UPDATE_OPER - 最后更新用户
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * 设置最后更新用户
     *
     * @param lastUpdateOper 最后更新用户
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建用户
     *
     * @return CREATE_OPER - 创建用户
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * 设置创建用户
     *
     * @param createOper 创建用户
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
    }

    /**
     * 获取任务上下文
     *
     * @return JOB_CONTENT - 任务上下文
     */
    public String getJobContent() {
        return jobContent;
    }

    /**
     * 设置任务上下文
     *
     * @param jobContent 任务上下文
     */
    public void setJobContent(String jobContent) {
        this.jobContent = jobContent == null ? null : jobContent.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WfExecutionJob other = (WfExecutionJob) that;
        return (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
            && (this.getJobName() == null ? other.getJobName() == null : this.getJobName().equals(other.getJobName()))
            && (this.getJobType() == null ? other.getJobType() == null : this.getJobType().equals(other.getJobType()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getRelFlowId() == null ? other.getRelFlowId() == null : this.getRelFlowId().equals(other.getRelFlowId()))
            && (this.getRelSnapshotId() == null ? other.getRelSnapshotId() == null : this.getRelSnapshotId().equals(other.getRelSnapshotId()))
            && (this.getRelNodeId() == null ? other.getRelNodeId() == null : this.getRelNodeId().equals(other.getRelNodeId()))
            && (this.getDfsExecDir() == null ? other.getDfsExecDir() == null : this.getDfsExecDir().equals(other.getDfsExecDir()))
            && (this.getLocalExecDir() == null ? other.getLocalExecDir() == null : this.getLocalExecDir().equals(other.getLocalExecDir()))
            && (this.getJobSubmitTime() == null ? other.getJobSubmitTime() == null : this.getJobSubmitTime().equals(other.getJobSubmitTime()))
            && (this.getJobStartTime() == null ? other.getJobStartTime() == null : this.getJobStartTime().equals(other.getJobStartTime()))
            && (this.getJobEndTime() == null ? other.getJobEndTime() == null : this.getJobEndTime().equals(other.getJobEndTime()))
            && (this.getJobState() == null ? other.getJobState() == null : this.getJobState().equals(other.getJobState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()))
            && (this.getJobContent() == null ? other.getJobContent() == null : this.getJobContent().equals(other.getJobContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getJobName() == null) ? 0 : getJobName().hashCode());
        result = prime * result + ((getJobType() == null) ? 0 : getJobType().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getRelFlowId() == null) ? 0 : getRelFlowId().hashCode());
        result = prime * result + ((getRelSnapshotId() == null) ? 0 : getRelSnapshotId().hashCode());
        result = prime * result + ((getRelNodeId() == null) ? 0 : getRelNodeId().hashCode());
        result = prime * result + ((getDfsExecDir() == null) ? 0 : getDfsExecDir().hashCode());
        result = prime * result + ((getLocalExecDir() == null) ? 0 : getLocalExecDir().hashCode());
        result = prime * result + ((getJobSubmitTime() == null) ? 0 : getJobSubmitTime().hashCode());
        result = prime * result + ((getJobStartTime() == null) ? 0 : getJobStartTime().hashCode());
        result = prime * result + ((getJobEndTime() == null) ? 0 : getJobEndTime().hashCode());
        result = prime * result + ((getJobState() == null) ? 0 : getJobState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        result = prime * result + ((getJobContent() == null) ? 0 : getJobContent().hashCode());
        return result;
    }
}