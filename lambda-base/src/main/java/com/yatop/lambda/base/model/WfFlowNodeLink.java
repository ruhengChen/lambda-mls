package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_flow_node_link")
public class WfFlowNodeLink implements Serializable {
    /**
     * 链路ID
     */
    @Id
    @Column(name = "LINK_ID")
    private Long linkId;

    /**
     * 所属工作流ID
     */
    @Column(name = "OWNER_FLOW_ID")
    private Long ownerFlowId;

    /**
     * 流出节点端口ID
     */
    @Column(name = "SRC_NODE_PORT_ID")
    private Long srcNodePortId;

    /**
     * 流入节点端口ID
     */
    @Column(name = "DST_NODE_PORT_ID")
    private Long dstNodePortId;

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
     * 获取链路ID
     *
     * @return LINK_ID - 链路ID
     */
    public Long getLinkId() {
        return linkId;
    }

    /**
     * 设置链路ID
     *
     * @param linkId 链路ID
     */
    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    /**
     * 获取所属工作流ID
     *
     * @return OWNER_FLOW_ID - 所属工作流ID
     */
    public Long getOwnerFlowId() {
        return ownerFlowId;
    }

    /**
     * 设置所属工作流ID
     *
     * @param ownerFlowId 所属工作流ID
     */
    public void setOwnerFlowId(Long ownerFlowId) {
        this.ownerFlowId = ownerFlowId;
    }

    /**
     * 获取流出节点端口ID
     *
     * @return SRC_NODE_PORT_ID - 流出节点端口ID
     */
    public Long getSrcNodePortId() {
        return srcNodePortId;
    }

    /**
     * 设置流出节点端口ID
     *
     * @param srcNodePortId 流出节点端口ID
     */
    public void setSrcNodePortId(Long srcNodePortId) {
        this.srcNodePortId = srcNodePortId;
    }

    /**
     * 获取流入节点端口ID
     *
     * @return DST_NODE_PORT_ID - 流入节点端口ID
     */
    public Long getDstNodePortId() {
        return dstNodePortId;
    }

    /**
     * 设置流入节点端口ID
     *
     * @param dstNodePortId 流入节点端口ID
     */
    public void setDstNodePortId(Long dstNodePortId) {
        this.dstNodePortId = dstNodePortId;
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
        WfFlowNodeLink other = (WfFlowNodeLink) that;
        return (this.getLinkId() == null ? other.getLinkId() == null : this.getLinkId().equals(other.getLinkId()))
            && (this.getOwnerFlowId() == null ? other.getOwnerFlowId() == null : this.getOwnerFlowId().equals(other.getOwnerFlowId()))
            && (this.getSrcNodePortId() == null ? other.getSrcNodePortId() == null : this.getSrcNodePortId().equals(other.getSrcNodePortId()))
            && (this.getDstNodePortId() == null ? other.getDstNodePortId() == null : this.getDstNodePortId().equals(other.getDstNodePortId()))
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
        result = prime * result + ((getLinkId() == null) ? 0 : getLinkId().hashCode());
        result = prime * result + ((getOwnerFlowId() == null) ? 0 : getOwnerFlowId().hashCode());
        result = prime * result + ((getSrcNodePortId() == null) ? 0 : getSrcNodePortId().hashCode());
        result = prime * result + ((getDstNodePortId() == null) ? 0 : getDstNodePortId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}