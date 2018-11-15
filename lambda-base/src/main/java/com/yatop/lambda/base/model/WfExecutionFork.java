package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_execution_fork")
public class WfExecutionFork implements Serializable {
    /**
     * 分叉ID
     */
    @Id
    @Column(name = "FORK_ID")
    private Long forkId;

    /**
     * 所属作业ID
     */
    @Column(name = "OWNER_JOB_ID")
    private Long ownerJobId;

    /**
     * 触发分叉节点ID
     */
    @Column(name = "FORK_NODE_ID")
    private Long forkNodeId;

    /**
     * 分叉数量
     */
    @Column(name = "FORK_NUM")
    private Integer forkNum;

    /**
     * 分叉状态
            0：waiting，等待中
            1：passed，已通过
            2：terminated，已终止
     */
    @Column(name = "FORK_STATE")
    private Integer forkState;

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

    private static final long serialVersionUID = 1L;

    /**
     * 获取分叉ID
     *
     * @return FORK_ID - 分叉ID
     */
    public Long getForkId() {
        return forkId;
    }

    /**
     * 设置分叉ID
     *
     * @param forkId 分叉ID
     */
    public void setForkId(Long forkId) {
        this.forkId = forkId;
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
     * 获取触发分叉节点ID
     *
     * @return FORK_NODE_ID - 触发分叉节点ID
     */
    public Long getForkNodeId() {
        return forkNodeId;
    }

    /**
     * 设置触发分叉节点ID
     *
     * @param forkNodeId 触发分叉节点ID
     */
    public void setForkNodeId(Long forkNodeId) {
        this.forkNodeId = forkNodeId;
    }

    /**
     * 获取分叉数量
     *
     * @return FORK_NUM - 分叉数量
     */
    public Integer getForkNum() {
        return forkNum;
    }

    /**
     * 设置分叉数量
     *
     * @param forkNum 分叉数量
     */
    public void setForkNum(Integer forkNum) {
        this.forkNum = forkNum;
    }

    /**
     * 获取分叉状态
            0：waiting，等待中
            1：passed，已通过
            2：terminated，已终止
     *
     * @return FORK_STATE - 分叉状态
            0：waiting，等待中
            1：passed，已通过
            2：terminated，已终止
     */
    public Integer getForkState() {
        return forkState;
    }

    /**
     * 设置分叉状态
            0：waiting，等待中
            1：passed，已通过
            2：terminated，已终止
     *
     * @param forkState 分叉状态
            0：waiting，等待中
            1：passed，已通过
            2：terminated，已终止
     */
    public void setForkState(Integer forkState) {
        this.forkState = forkState;
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
        WfExecutionFork other = (WfExecutionFork) that;
        return (this.getForkId() == null ? other.getForkId() == null : this.getForkId().equals(other.getForkId()))
            && (this.getOwnerJobId() == null ? other.getOwnerJobId() == null : this.getOwnerJobId().equals(other.getOwnerJobId()))
            && (this.getForkNodeId() == null ? other.getForkNodeId() == null : this.getForkNodeId().equals(other.getForkNodeId()))
            && (this.getForkNum() == null ? other.getForkNum() == null : this.getForkNum().equals(other.getForkNum()))
            && (this.getForkState() == null ? other.getForkState() == null : this.getForkState().equals(other.getForkState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getForkId() == null) ? 0 : getForkId().hashCode());
        result = prime * result + ((getOwnerJobId() == null) ? 0 : getOwnerJobId().hashCode());
        result = prime * result + ((getForkNodeId() == null) ? 0 : getForkNodeId().hashCode());
        result = prime * result + ((getForkNum() == null) ? 0 : getForkNum().hashCode());
        result = prime * result + ((getForkState() == null) ? 0 : getForkState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}