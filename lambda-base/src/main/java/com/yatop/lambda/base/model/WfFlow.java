package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_flow")
public class WfFlow implements Serializable {
    /**
     * 流程图ID
     */
    @Id
    @Column(name = "FLOW_ID")
    private Long flowId;

    /**
     * 流程图名称，自动生成
     */
    @Column(name = "FLOW_NAME")
    private String flowName;

    /**
     * 所属项目ID
     */
    @Column(name = "OWNER_PROJECT_ID")
    private Long ownerProjectId;

    /**
     * 所属实验ID
     */
    @Column(name = "OWNER_EXPERIMENT_ID")
    private Long ownerExperimentId;

    /**
     * 加锁状态，实验运行和快照期间加锁，可读不可写
            
            0：未加锁
            1：已加锁
     */
    @Column(name = "LOCK_STATE")
    private Integer lockState;

    /**
     * 加锁消息
     */
    @Column(name = "LOCK_MSG")
    private String lockMsg;

    /**
     * 最后快照ID
     */
    @Column(name = "LAST_SNAPSHOT_ID")
    private Long lastSnapshotId;

    /**
     * 下一快照版本
     */
    @Column(name = "NEXT_SNAPSHOT_VERSION")
    private Long nextSnapshotVersion;

    /**
     * 最后作业ID
     */
    @Column(name = "LAST_JOB_ID")
    private Long lastJobId;

    /**
     * 工作流状态
            0：draft，草稿
            1：preparing，准备中
            2：running，运行中
            3：finished running，运行结束
     */
    @Column(name = "FLOW_STATE")
    private Integer flowState;

    /**
     * 摘要，实验摘要信息
     */
    @Column(name = "SUMMARY")
    private String summary;

    /**
     * 描述，实验描述信息
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
     * 版本号，解决同一实验多用户编辑问题
     */
    @Column(name = "VERSION")
    private Long version;

    private static final long serialVersionUID = 1L;

    /**
     * 获取流程图ID
     *
     * @return FLOW_ID - 流程图ID
     */
    public Long getFlowId() {
        return flowId;
    }

    /**
     * 设置流程图ID
     *
     * @param flowId 流程图ID
     */
    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    /**
     * 获取流程图名称，自动生成
     *
     * @return FLOW_NAME - 流程图名称，自动生成
     */
    public String getFlowName() {
        return flowName;
    }

    /**
     * 设置流程图名称，自动生成
     *
     * @param flowName 流程图名称，自动生成
     */
    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
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
     * 获取所属实验ID
     *
     * @return OWNER_EXPERIMENT_ID - 所属实验ID
     */
    public Long getOwnerExperimentId() {
        return ownerExperimentId;
    }

    /**
     * 设置所属实验ID
     *
     * @param ownerExperimentId 所属实验ID
     */
    public void setOwnerExperimentId(Long ownerExperimentId) {
        this.ownerExperimentId = ownerExperimentId;
    }

    /**
     * 获取加锁状态，实验运行和快照期间加锁，可读不可写
            
            0：未加锁
            1：已加锁
     *
     * @return LOCK_STATE - 加锁状态，实验运行和快照期间加锁，可读不可写
            
            0：未加锁
            1：已加锁
     */
    public Integer getLockState() {
        return lockState;
    }

    /**
     * 设置加锁状态，实验运行和快照期间加锁，可读不可写
            
            0：未加锁
            1：已加锁
     *
     * @param lockState 加锁状态，实验运行和快照期间加锁，可读不可写
            
            0：未加锁
            1：已加锁
     */
    public void setLockState(Integer lockState) {
        this.lockState = lockState;
    }

    /**
     * 获取加锁消息
     *
     * @return LOCK_MSG - 加锁消息
     */
    public String getLockMsg() {
        return lockMsg;
    }

    /**
     * 设置加锁消息
     *
     * @param lockMsg 加锁消息
     */
    public void setLockMsg(String lockMsg) {
        this.lockMsg = lockMsg == null ? null : lockMsg.trim();
    }

    /**
     * 获取最后快照ID
     *
     * @return LAST_SNAPSHOT_ID - 最后快照ID
     */
    public Long getLastSnapshotId() {
        return lastSnapshotId;
    }

    /**
     * 设置最后快照ID
     *
     * @param lastSnapshotId 最后快照ID
     */
    public void setLastSnapshotId(Long lastSnapshotId) {
        this.lastSnapshotId = lastSnapshotId;
    }

    /**
     * 获取下一快照版本
     *
     * @return NEXT_SNAPSHOT_VERSION - 下一快照版本
     */
    public Long getNextSnapshotVersion() {
        return nextSnapshotVersion;
    }

    /**
     * 设置下一快照版本
     *
     * @param nextSnapshotVersion 下一快照版本
     */
    public void setNextSnapshotVersion(Long nextSnapshotVersion) {
        this.nextSnapshotVersion = nextSnapshotVersion;
    }

    /**
     * 获取最后作业ID
     *
     * @return LAST_JOB_ID - 最后作业ID
     */
    public Long getLastJobId() {
        return lastJobId;
    }

    /**
     * 设置最后作业ID
     *
     * @param lastJobId 最后作业ID
     */
    public void setLastJobId(Long lastJobId) {
        this.lastJobId = lastJobId;
    }

    /**
     * 获取工作流状态
            0：draft，草稿
            1：preparing，准备中
            2：running，运行中
            3：finished running，运行结束
     *
     * @return FLOW_STATE - 工作流状态
            0：draft，草稿
            1：preparing，准备中
            2：running，运行中
            3：finished running，运行结束
     */
    public Integer getFlowState() {
        return flowState;
    }

    /**
     * 设置工作流状态
            0：draft，草稿
            1：preparing，准备中
            2：running，运行中
            3：finished running，运行结束
     *
     * @param flowState 工作流状态
            0：draft，草稿
            1：preparing，准备中
            2：running，运行中
            3：finished running，运行结束
     */
    public void setFlowState(Integer flowState) {
        this.flowState = flowState;
    }

    /**
     * 获取摘要，实验摘要信息
     *
     * @return SUMMARY - 摘要，实验摘要信息
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置摘要，实验摘要信息
     *
     * @param summary 摘要，实验摘要信息
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * 获取描述，实验描述信息
     *
     * @return DESCRIPTION - 描述，实验描述信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述，实验描述信息
     *
     * @param description 描述，实验描述信息
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
     * 获取版本号，解决同一实验多用户编辑问题
     *
     * @return VERSION - 版本号，解决同一实验多用户编辑问题
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 设置版本号，解决同一实验多用户编辑问题
     *
     * @param version 版本号，解决同一实验多用户编辑问题
     */
    public void setVersion(Long version) {
        this.version = version;
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
        WfFlow other = (WfFlow) that;
        return (this.getFlowId() == null ? other.getFlowId() == null : this.getFlowId().equals(other.getFlowId()))
            && (this.getFlowName() == null ? other.getFlowName() == null : this.getFlowName().equals(other.getFlowName()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getOwnerExperimentId() == null ? other.getOwnerExperimentId() == null : this.getOwnerExperimentId().equals(other.getOwnerExperimentId()))
            && (this.getLockState() == null ? other.getLockState() == null : this.getLockState().equals(other.getLockState()))
            && (this.getLockMsg() == null ? other.getLockMsg() == null : this.getLockMsg().equals(other.getLockMsg()))
            && (this.getLastSnapshotId() == null ? other.getLastSnapshotId() == null : this.getLastSnapshotId().equals(other.getLastSnapshotId()))
            && (this.getNextSnapshotVersion() == null ? other.getNextSnapshotVersion() == null : this.getNextSnapshotVersion().equals(other.getNextSnapshotVersion()))
            && (this.getLastJobId() == null ? other.getLastJobId() == null : this.getLastJobId().equals(other.getLastJobId()))
            && (this.getFlowState() == null ? other.getFlowState() == null : this.getFlowState().equals(other.getFlowState()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFlowId() == null) ? 0 : getFlowId().hashCode());
        result = prime * result + ((getFlowName() == null) ? 0 : getFlowName().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getOwnerExperimentId() == null) ? 0 : getOwnerExperimentId().hashCode());
        result = prime * result + ((getLockState() == null) ? 0 : getLockState().hashCode());
        result = prime * result + ((getLockMsg() == null) ? 0 : getLockMsg().hashCode());
        result = prime * result + ((getLastSnapshotId() == null) ? 0 : getLastSnapshotId().hashCode());
        result = prime * result + ((getNextSnapshotVersion() == null) ? 0 : getNextSnapshotVersion().hashCode());
        result = prime * result + ((getLastJobId() == null) ? 0 : getLastJobId().hashCode());
        result = prime * result + ((getFlowState() == null) ? 0 : getFlowState().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }
}