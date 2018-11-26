package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_execution_task")
public class WfExecutionTask implements Serializable {
    /**
     * 任务ID
     */
    @Id
    @Column(name = "TASK_ID")
    private Long taskId;

    /**
     * 任务名称，自动生成
     */
    @Column(name = "TASK_NAME")
    private String taskName;

    /**
     * 所属作业ID
     */
    @Column(name = "OWNER_JOB_ID")
    private Long ownerJobId;

    /**
     * 作业中任务序号
     */
    @Column(name = "SEQUENCE")
    private Integer sequence;

    /**
     * 关联节点ID
     */
    @Column(name = "REL_NODE_ID")
    private Long relNodeId;

    /**
     * 计算引擎类型（预留）
     */
    @Column(name = "ENGINE_TYPE")
    private String engineType;

    /**
     * 外部任务ID，比如yarn的application id，默认unknown
     */
    @Column(name = "EXTERNAL_ID")
    private String externalId;

    /**
     * 提交文件名，存放在运行目录下
            
            ${JOB_DIR}/submit_<task_id>_<module_code>.json
     */
    @Column(name = "SUBMIT_FILE")
    private String submitFile;

    /**
     * 返回文件名，存放在运行目录下
            
            ${JOB_DIR}/return_<task_id>_<module_code>.json
     */
    @Column(name = "RETURN_FILE")
    private String returnFile;

    /**
     * 日志文件名，存放在运行目录下
            
            ${JOB_DIR}/log_<task_id>_<module_code>.log
     */
    @Column(name = "LOG_FILE")
    private String logFile;

    /**
     * 运行时间，单位毫秒，默认为-1
     */
    @Column(name = "COST_TIME")
    private Long costTime;

    /**
     * 任务进度，百分比数值0到100
     */
    @Column(name = "TASK_PROGRESS")
    private Integer taskProgress;

    /**
     * 运行状态
            0：ready，已就绪
            1：queueing，排队中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户中止
     */
    @Column(name = "TASK_STATE")
    private Integer taskState;

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
    @Column(name = "TASK_CONTEXT")
    private String taskContext;

    private static final long serialVersionUID = 1L;

    /**
     * 获取任务ID
     *
     * @return TASK_ID - 任务ID
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 设置任务ID
     *
     * @param taskId 任务ID
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取任务名称，自动生成
     *
     * @return TASK_NAME - 任务名称，自动生成
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置任务名称，自动生成
     *
     * @param taskName 任务名称，自动生成
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 获取所属作业ID
     *
     * @return OWNER_JOB_ID - 所属作业ID
     */
    public Long getOwnerJobId() {
        return ownerJobId;
    }

    /**
     * 设置所属作业ID
     *
     * @param ownerJobId 所属作业ID
     */
    public void setOwnerJobId(Long ownerJobId) {
        this.ownerJobId = ownerJobId;
    }

    /**
     * 获取作业中任务序号
     *
     * @return SEQUENCE - 作业中任务序号
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置作业中任务序号
     *
     * @param sequence 作业中任务序号
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 获取关联节点ID
     *
     * @return REL_NODE_ID - 关联节点ID
     */
    public Long getRelNodeId() {
        return relNodeId;
    }

    /**
     * 设置关联节点ID
     *
     * @param relNodeId 关联节点ID
     */
    public void setRelNodeId(Long relNodeId) {
        this.relNodeId = relNodeId;
    }

    /**
     * 获取计算引擎类型（预留）
     *
     * @return ENGINE_TYPE - 计算引擎类型（预留）
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * 设置计算引擎类型（预留）
     *
     * @param engineType 计算引擎类型（预留）
     */
    public void setEngineType(String engineType) {
        this.engineType = engineType == null ? null : engineType.trim();
    }

    /**
     * 获取外部任务ID，比如yarn的application id，默认unknown
     *
     * @return EXTERNAL_ID - 外部任务ID，比如yarn的application id，默认unknown
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * 设置外部任务ID，比如yarn的application id，默认unknown
     *
     * @param externalId 外部任务ID，比如yarn的application id，默认unknown
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId == null ? null : externalId.trim();
    }

    /**
     * 获取提交文件名，存放在运行目录下
            
            ${JOB_DIR}/submit_<task_id>_<module_code>.json
     *
     * @return SUBMIT_FILE - 提交文件名，存放在运行目录下
            
            ${JOB_DIR}/submit_<task_id>_<module_code>.json
     */
    public String getSubmitFile() {
        return submitFile;
    }

    /**
     * 设置提交文件名，存放在运行目录下
            
            ${JOB_DIR}/submit_<task_id>_<module_code>.json
     *
     * @param submitFile 提交文件名，存放在运行目录下
            
            ${JOB_DIR}/submit_<task_id>_<module_code>.json
     */
    public void setSubmitFile(String submitFile) {
        this.submitFile = submitFile == null ? null : submitFile.trim();
    }

    /**
     * 获取返回文件名，存放在运行目录下
            
            ${JOB_DIR}/return_<task_id>_<module_code>.json
     *
     * @return RETURN_FILE - 返回文件名，存放在运行目录下
            
            ${JOB_DIR}/return_<task_id>_<module_code>.json
     */
    public String getReturnFile() {
        return returnFile;
    }

    /**
     * 设置返回文件名，存放在运行目录下
            
            ${JOB_DIR}/return_<task_id>_<module_code>.json
     *
     * @param returnFile 返回文件名，存放在运行目录下
            
            ${JOB_DIR}/return_<task_id>_<module_code>.json
     */
    public void setReturnFile(String returnFile) {
        this.returnFile = returnFile == null ? null : returnFile.trim();
    }

    /**
     * 获取日志文件名，存放在运行目录下
            
            ${JOB_DIR}/log_<task_id>_<module_code>.log
     *
     * @return LOG_FILE - 日志文件名，存放在运行目录下
            
            ${JOB_DIR}/log_<task_id>_<module_code>.log
     */
    public String getLogFile() {
        return logFile;
    }

    /**
     * 设置日志文件名，存放在运行目录下
            
            ${JOB_DIR}/log_<task_id>_<module_code>.log
     *
     * @param logFile 日志文件名，存放在运行目录下
            
            ${JOB_DIR}/log_<task_id>_<module_code>.log
     */
    public void setLogFile(String logFile) {
        this.logFile = logFile == null ? null : logFile.trim();
    }

    /**
     * 获取运行时间，单位毫秒，默认为-1
     *
     * @return COST_TIME - 运行时间，单位毫秒，默认为-1
     */
    public Long getCostTime() {
        return costTime;
    }

    /**
     * 设置运行时间，单位毫秒，默认为-1
     *
     * @param costTime 运行时间，单位毫秒，默认为-1
     */
    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    /**
     * 获取任务进度，百分比数值0到100
     *
     * @return TASK_PROGRESS - 任务进度，百分比数值0到100
     */
    public Integer getTaskProgress() {
        return taskProgress;
    }

    /**
     * 设置任务进度，百分比数值0到100
     *
     * @param taskProgress 任务进度，百分比数值0到100
     */
    public void setTaskProgress(Integer taskProgress) {
        this.taskProgress = taskProgress;
    }

    /**
     * 获取运行状态
            0：ready，已就绪
            1：queueing，排队中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户中止
     *
     * @return TASK_STATE - 运行状态
            0：ready，已就绪
            1：queueing，排队中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户中止
     */
    public Integer getTaskState() {
        return taskState;
    }

    /**
     * 设置运行状态
            0：ready，已就绪
            1：queueing，排队中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户中止
     *
     * @param taskState 运行状态
            0：ready，已就绪
            1：queueing，排队中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户中止
     */
    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
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
     * @return TASK_CONTEXT - 任务上下文
     */
    public String getTaskContext() {
        return taskContext;
    }

    /**
     * 设置任务上下文
     *
     * @param taskContext 任务上下文
     */
    public void setTaskContext(String taskContext) {
        this.taskContext = taskContext == null ? null : taskContext.trim();
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
        WfExecutionTask other = (WfExecutionTask) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getOwnerJobId() == null ? other.getOwnerJobId() == null : this.getOwnerJobId().equals(other.getOwnerJobId()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getRelNodeId() == null ? other.getRelNodeId() == null : this.getRelNodeId().equals(other.getRelNodeId()))
            && (this.getEngineType() == null ? other.getEngineType() == null : this.getEngineType().equals(other.getEngineType()))
            && (this.getExternalId() == null ? other.getExternalId() == null : this.getExternalId().equals(other.getExternalId()))
            && (this.getSubmitFile() == null ? other.getSubmitFile() == null : this.getSubmitFile().equals(other.getSubmitFile()))
            && (this.getReturnFile() == null ? other.getReturnFile() == null : this.getReturnFile().equals(other.getReturnFile()))
            && (this.getLogFile() == null ? other.getLogFile() == null : this.getLogFile().equals(other.getLogFile()))
            && (this.getCostTime() == null ? other.getCostTime() == null : this.getCostTime().equals(other.getCostTime()))
            && (this.getTaskProgress() == null ? other.getTaskProgress() == null : this.getTaskProgress().equals(other.getTaskProgress()))
            && (this.getTaskState() == null ? other.getTaskState() == null : this.getTaskState().equals(other.getTaskState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()))
            && (this.getTaskContext() == null ? other.getTaskContext() == null : this.getTaskContext().equals(other.getTaskContext()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getOwnerJobId() == null) ? 0 : getOwnerJobId().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getRelNodeId() == null) ? 0 : getRelNodeId().hashCode());
        result = prime * result + ((getEngineType() == null) ? 0 : getEngineType().hashCode());
        result = prime * result + ((getExternalId() == null) ? 0 : getExternalId().hashCode());
        result = prime * result + ((getSubmitFile() == null) ? 0 : getSubmitFile().hashCode());
        result = prime * result + ((getReturnFile() == null) ? 0 : getReturnFile().hashCode());
        result = prime * result + ((getLogFile() == null) ? 0 : getLogFile().hashCode());
        result = prime * result + ((getCostTime() == null) ? 0 : getCostTime().hashCode());
        result = prime * result + ((getTaskProgress() == null) ? 0 : getTaskProgress().hashCode());
        result = prime * result + ((getTaskState() == null) ? 0 : getTaskState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        result = prime * result + ((getTaskContext() == null) ? 0 : getTaskContext().hashCode());
        return result;
    }
}