package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_execution_join")
public class WfExecutionJoin implements Serializable {
    /**
     * 会合ID
     */
    @Id
    @Column(name = "JOIN_ID")
    private Long joinId;

    /**
     * 所属作业ID
     */
    @Column(name = "OWNER_JOB_ID")
    private Long ownerJobId;

    /**
     * 等候会合节点ID
     */
    @Column(name = "JOIN_NODE_ID")
    private Long joinNodeId;

    /**
     * 会合数量
     */
    @Column(name = "JOIN_NUM")
    private Integer joinNum;

    /**
     * 会合计数
     */
    @Column(name = "JOIN_COUNT")
    private Integer joinCount;

    /**
     * 会合状态
            0：waiting，等待中
            1：passed，已通过
            2：terminated，已终止
     */
    @Column(name = "JOIN_STATE")
    private Integer joinState;

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
     * 获取会合ID
     *
     * @return JOIN_ID - 会合ID
     */
    public Long getJoinId() {
        return joinId;
    }

    /**
     * 设置会合ID
     *
     * @param joinId 会合ID
     */
    public void setJoinId(Long joinId) {
        this.joinId = joinId;
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
     * 获取等候会合节点ID
     *
     * @return JOIN_NODE_ID - 等候会合节点ID
     */
    public Long getJoinNodeId() {
        return joinNodeId;
    }

    /**
     * 设置等候会合节点ID
     *
     * @param joinNodeId 等候会合节点ID
     */
    public void setJoinNodeId(Long joinNodeId) {
        this.joinNodeId = joinNodeId;
    }

    /**
     * 获取会合数量
     *
     * @return JOIN_NUM - 会合数量
     */
    public Integer getJoinNum() {
        return joinNum;
    }

    /**
     * 设置会合数量
     *
     * @param joinNum 会合数量
     */
    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }

    /**
     * 获取会合计数
     *
     * @return JOIN_COUNT - 会合计数
     */
    public Integer getJoinCount() {
        return joinCount;
    }

    /**
     * 设置会合计数
     *
     * @param joinCount 会合计数
     */
    public void setJoinCount(Integer joinCount) {
        this.joinCount = joinCount;
    }

    /**
     * 获取会合状态
            0：waiting，等待中
            1：passed，已通过
            2：terminated，已终止
     *
     * @return JOIN_STATE - 会合状态
            0：waiting，等待中
            1：passed，已通过
            2：terminated，已终止
     */
    public Integer getJoinState() {
        return joinState;
    }

    /**
     * 设置会合状态
            0：waiting，等待中
            1：passed，已通过
            2：terminated，已终止
     *
     * @param joinState 会合状态
            0：waiting，等待中
            1：passed，已通过
            2：terminated，已终止
     */
    public void setJoinState(Integer joinState) {
        this.joinState = joinState;
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
        WfExecutionJoin other = (WfExecutionJoin) that;
        return (this.getJoinId() == null ? other.getJoinId() == null : this.getJoinId().equals(other.getJoinId()))
            && (this.getOwnerJobId() == null ? other.getOwnerJobId() == null : this.getOwnerJobId().equals(other.getOwnerJobId()))
            && (this.getJoinNodeId() == null ? other.getJoinNodeId() == null : this.getJoinNodeId().equals(other.getJoinNodeId()))
            && (this.getJoinNum() == null ? other.getJoinNum() == null : this.getJoinNum().equals(other.getJoinNum()))
            && (this.getJoinCount() == null ? other.getJoinCount() == null : this.getJoinCount().equals(other.getJoinCount()))
            && (this.getJoinState() == null ? other.getJoinState() == null : this.getJoinState().equals(other.getJoinState()))
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
        result = prime * result + ((getJoinId() == null) ? 0 : getJoinId().hashCode());
        result = prime * result + ((getOwnerJobId() == null) ? 0 : getOwnerJobId().hashCode());
        result = prime * result + ((getJoinNodeId() == null) ? 0 : getJoinNodeId().hashCode());
        result = prime * result + ((getJoinNum() == null) ? 0 : getJoinNum().hashCode());
        result = prime * result + ((getJoinCount() == null) ? 0 : getJoinCount().hashCode());
        result = prime * result + ((getJoinState() == null) ? 0 : getJoinState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}