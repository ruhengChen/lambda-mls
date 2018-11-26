package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_flow_node_link")
public class WfFlowNodeLink implements Serializable {
    /**
     * 链接ID
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
     * 是否为web组件的流出链接
            0：否
            1：是
     */
    @Column(name = "IS_WEB_LINK")
    private Integer isWebLink;

    /**
     * 流出节点端口ID
     */
    @Column(name = "SRC_PORT_ID")
    private Long srcPortId;

    /**
     * 流入节点端口ID
     */
    @Column(name = "DST_PORT_ID")
    private Long dstPortId;

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
     * 获取链接ID
     *
     * @return LINK_ID - 链接ID
     */
    public Long getLinkId() {
        return linkId;
    }

    /**
     * 设置链接ID
     *
     * @param linkId 链接ID
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
     * 获取是否为web组件的流出链接
            0：否
            1：是
     *
     * @return IS_WEB_LINK - 是否为web组件的流出链接
            0：否
            1：是
     */
    public Integer getIsWebLink() {
        return isWebLink;
    }

    /**
     * 设置是否为web组件的流出链接
            0：否
            1：是
     *
     * @param isWebLink 是否为web组件的流出链接
            0：否
            1：是
     */
    public void setIsWebLink(Integer isWebLink) {
        this.isWebLink = isWebLink;
    }

    /**
     * 获取流出节点端口ID
     *
     * @return SRC_PORT_ID - 流出节点端口ID
     */
    public Long getSrcPortId() {
        return srcPortId;
    }

    /**
     * 设置流出节点端口ID
     *
     * @param srcPortId 流出节点端口ID
     */
    public void setSrcPortId(Long srcPortId) {
        this.srcPortId = srcPortId;
    }

    /**
     * 获取流入节点端口ID
     *
     * @return DST_PORT_ID - 流入节点端口ID
     */
    public Long getDstPortId() {
        return dstPortId;
    }

    /**
     * 设置流入节点端口ID
     *
     * @param dstPortId 流入节点端口ID
     */
    public void setDstPortId(Long dstPortId) {
        this.dstPortId = dstPortId;
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
        WfFlowNodeLink other = (WfFlowNodeLink) that;
        return (this.getLinkId() == null ? other.getLinkId() == null : this.getLinkId().equals(other.getLinkId()))
            && (this.getOwnerFlowId() == null ? other.getOwnerFlowId() == null : this.getOwnerFlowId().equals(other.getOwnerFlowId()))
            && (this.getIsWebLink() == null ? other.getIsWebLink() == null : this.getIsWebLink().equals(other.getIsWebLink()))
            && (this.getSrcPortId() == null ? other.getSrcPortId() == null : this.getSrcPortId().equals(other.getSrcPortId()))
            && (this.getDstPortId() == null ? other.getDstPortId() == null : this.getDstPortId().equals(other.getDstPortId()))
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
        result = prime * result + ((getLinkId() == null) ? 0 : getLinkId().hashCode());
        result = prime * result + ((getOwnerFlowId() == null) ? 0 : getOwnerFlowId().hashCode());
        result = prime * result + ((getIsWebLink() == null) ? 0 : getIsWebLink().hashCode());
        result = prime * result + ((getSrcPortId() == null) ? 0 : getSrcPortId().hashCode());
        result = prime * result + ((getDstPortId() == null) ? 0 : getDstPortId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}