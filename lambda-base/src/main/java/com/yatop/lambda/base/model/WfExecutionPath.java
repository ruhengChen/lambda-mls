package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_execution_path")
public class WfExecutionPath implements Serializable {
    /**
     * 路径ID
     */
    @Id
    @Column(name = "PATH_ID")
    private Long pathId;

    /**
     * 所属作业ID
     */
    @Column(name = "OWNER_JOB_ID")
    private Long ownerJobId;

    /**
     * 起始节点ID
     */
    @Column(name = "START_NODE_ID")
    private Long startNodeId;

    /**
     * 结束节点ID
     */
    @Column(name = "END_NODE_ID")
    private Long endNodeId;

    /**
     * 当前节点ID
     */
    @Column(name = "CUR_NODE_ID")
    private Long curNodeId;

    /**
     * 路径节点数量
     */
    @Column(name = "PATH_NODE_NUM")
    private Integer pathNodeNum;

    /**
     * 路径节点计数
     */
    @Column(name = "PATH_NODE_COUNT")
    private Integer pathNodeCount;

    /**
     * 运行状态
            0：ready，已就绪
            1：preparing，准备中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户终止
     */
    @Column(name = "PATH_STATE")
    private Integer pathState;

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
     * 获取路径ID
     *
     * @return PATH_ID - 路径ID
     */
    public Long getPathId() {
        return pathId;
    }

    /**
     * 设置路径ID
     *
     * @param pathId 路径ID
     */
    public void setPathId(Long pathId) {
        this.pathId = pathId;
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
     * 获取起始节点ID
     *
     * @return START_NODE_ID - 起始节点ID
     */
    public Long getStartNodeId() {
        return startNodeId;
    }

    /**
     * 设置起始节点ID
     *
     * @param startNodeId 起始节点ID
     */
    public void setStartNodeId(Long startNodeId) {
        this.startNodeId = startNodeId;
    }

    /**
     * 获取结束节点ID
     *
     * @return END_NODE_ID - 结束节点ID
     */
    public Long getEndNodeId() {
        return endNodeId;
    }

    /**
     * 设置结束节点ID
     *
     * @param endNodeId 结束节点ID
     */
    public void setEndNodeId(Long endNodeId) {
        this.endNodeId = endNodeId;
    }

    /**
     * 获取当前节点ID
     *
     * @return CUR_NODE_ID - 当前节点ID
     */
    public Long getCurNodeId() {
        return curNodeId;
    }

    /**
     * 设置当前节点ID
     *
     * @param curNodeId 当前节点ID
     */
    public void setCurNodeId(Long curNodeId) {
        this.curNodeId = curNodeId;
    }

    /**
     * 获取路径节点数量
     *
     * @return PATH_NODE_NUM - 路径节点数量
     */
    public Integer getPathNodeNum() {
        return pathNodeNum;
    }

    /**
     * 设置路径节点数量
     *
     * @param pathNodeNum 路径节点数量
     */
    public void setPathNodeNum(Integer pathNodeNum) {
        this.pathNodeNum = pathNodeNum;
    }

    /**
     * 获取路径节点计数
     *
     * @return PATH_NODE_COUNT - 路径节点计数
     */
    public Integer getPathNodeCount() {
        return pathNodeCount;
    }

    /**
     * 设置路径节点计数
     *
     * @param pathNodeCount 路径节点计数
     */
    public void setPathNodeCount(Integer pathNodeCount) {
        this.pathNodeCount = pathNodeCount;
    }

    /**
     * 获取运行状态
            0：ready，已就绪
            1：preparing，准备中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户终止
     *
     * @return PATH_STATE - 运行状态
            0：ready，已就绪
            1：preparing，准备中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户终止
     */
    public Integer getPathState() {
        return pathState;
    }

    /**
     * 设置运行状态
            0：ready，已就绪
            1：preparing，准备中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户终止
     *
     * @param pathState 运行状态
            0：ready，已就绪
            1：preparing，准备中
            2：running，运行中
            3：finished，运行完成
            4：error terminated，出错终止
            5：user terminated，用户终止
     */
    public void setPathState(Integer pathState) {
        this.pathState = pathState;
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
        WfExecutionPath other = (WfExecutionPath) that;
        return (this.getPathId() == null ? other.getPathId() == null : this.getPathId().equals(other.getPathId()))
            && (this.getOwnerJobId() == null ? other.getOwnerJobId() == null : this.getOwnerJobId().equals(other.getOwnerJobId()))
            && (this.getStartNodeId() == null ? other.getStartNodeId() == null : this.getStartNodeId().equals(other.getStartNodeId()))
            && (this.getEndNodeId() == null ? other.getEndNodeId() == null : this.getEndNodeId().equals(other.getEndNodeId()))
            && (this.getCurNodeId() == null ? other.getCurNodeId() == null : this.getCurNodeId().equals(other.getCurNodeId()))
            && (this.getPathNodeNum() == null ? other.getPathNodeNum() == null : this.getPathNodeNum().equals(other.getPathNodeNum()))
            && (this.getPathNodeCount() == null ? other.getPathNodeCount() == null : this.getPathNodeCount().equals(other.getPathNodeCount()))
            && (this.getPathState() == null ? other.getPathState() == null : this.getPathState().equals(other.getPathState()))
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
        result = prime * result + ((getPathId() == null) ? 0 : getPathId().hashCode());
        result = prime * result + ((getOwnerJobId() == null) ? 0 : getOwnerJobId().hashCode());
        result = prime * result + ((getStartNodeId() == null) ? 0 : getStartNodeId().hashCode());
        result = prime * result + ((getEndNodeId() == null) ? 0 : getEndNodeId().hashCode());
        result = prime * result + ((getCurNodeId() == null) ? 0 : getCurNodeId().hashCode());
        result = prime * result + ((getPathNodeNum() == null) ? 0 : getPathNodeNum().hashCode());
        result = prime * result + ((getPathNodeCount() == null) ? 0 : getPathNodeCount().hashCode());
        result = prime * result + ((getPathState() == null) ? 0 : getPathState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}