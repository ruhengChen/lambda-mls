package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_flow_node_port")
public class WfFlowNodePort implements Serializable {
    /**
     * 节点端口ID
     */
    @Id
    @Column(name = "NODE_PORT_ID")
    private Long nodePortId;

    /**
     * 所属节点ID
     */
    @Column(name = "OWNER_NODE_ID")
    private Long ownerNodeId;

    /**
     * 引用组件端口ID
     */
    @Column(name = "REF_PORT_ID")
    private Long refPortId;

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
     * 获取节点端口ID
     *
     * @return NODE_PORT_ID - 节点端口ID
     */
    public Long getNodePortId() {
        return nodePortId;
    }

    /**
     * 设置节点端口ID
     *
     * @param nodePortId 节点端口ID
     */
    public void setNodePortId(Long nodePortId) {
        this.nodePortId = nodePortId;
    }

    /**
     * 获取所属节点ID
     *
     * @return OWNER_NODE_ID - 所属节点ID
     */
    public Long getOwnerNodeId() {
        return ownerNodeId;
    }

    /**
     * 设置所属节点ID
     *
     * @param ownerNodeId 所属节点ID
     */
    public void setOwnerNodeId(Long ownerNodeId) {
        this.ownerNodeId = ownerNodeId;
    }

    /**
     * 获取引用组件端口ID
     *
     * @return REF_PORT_ID - 引用组件端口ID
     */
    public Long getRefPortId() {
        return refPortId;
    }

    /**
     * 设置引用组件端口ID
     *
     * @param refPortId 引用组件端口ID
     */
    public void setRefPortId(Long refPortId) {
        this.refPortId = refPortId;
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
        WfFlowNodePort other = (WfFlowNodePort) that;
        return (this.getNodePortId() == null ? other.getNodePortId() == null : this.getNodePortId().equals(other.getNodePortId()))
            && (this.getOwnerNodeId() == null ? other.getOwnerNodeId() == null : this.getOwnerNodeId().equals(other.getOwnerNodeId()))
            && (this.getRefPortId() == null ? other.getRefPortId() == null : this.getRefPortId().equals(other.getRefPortId()))
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
        result = prime * result + ((getNodePortId() == null) ? 0 : getNodePortId().hashCode());
        result = prime * result + ((getOwnerNodeId() == null) ? 0 : getOwnerNodeId().hashCode());
        result = prime * result + ((getRefPortId() == null) ? 0 : getRefPortId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}