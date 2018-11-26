package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_flow_node_schema")
public class WfFlowNodeSchema implements Serializable {
    /**
     * 节点输出端口ID
     */
    @Id
    @Column(name = "NODE_PORT_ID")
    private Long nodePortId;

    /**
     * json对象ID
     */
    @Column(name = "OBJECT_ID")
    private Long objectId;

    /**
     * schema状态
            0：空schema
            1：正常
            2：不支持
            3：超限中断
     */
    @Column(name = "SCHEMA_STATE")
    private Integer schemaState;

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
     * 获取节点输出端口ID
     *
     * @return NODE_PORT_ID - 节点输出端口ID
     */
    public Long getNodePortId() {
        return nodePortId;
    }

    /**
     * 设置节点输出端口ID
     *
     * @param nodePortId 节点输出端口ID
     */
    public void setNodePortId(Long nodePortId) {
        this.nodePortId = nodePortId;
    }

    /**
     * 获取json对象ID
     *
     * @return OBJECT_ID - json对象ID
     */
    public Long getObjectId() {
        return objectId;
    }

    /**
     * 设置json对象ID
     *
     * @param objectId json对象ID
     */
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    /**
     * 获取schema状态
            0：空schema
            1：正常
            2：不支持
            3：超限中断
     *
     * @return SCHEMA_STATE - schema状态
            0：空schema
            1：正常
            2：不支持
            3：超限中断
     */
    public Integer getSchemaState() {
        return schemaState;
    }

    /**
     * 设置schema状态
            0：空schema
            1：正常
            2：不支持
            3：超限中断
     *
     * @param schemaState schema状态
            0：空schema
            1：正常
            2：不支持
            3：超限中断
     */
    public void setSchemaState(Integer schemaState) {
        this.schemaState = schemaState;
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
        WfFlowNodeSchema other = (WfFlowNodeSchema) that;
        return (this.getNodePortId() == null ? other.getNodePortId() == null : this.getNodePortId().equals(other.getNodePortId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getSchemaState() == null ? other.getSchemaState() == null : this.getSchemaState().equals(other.getSchemaState()))
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
        result = prime * result + ((getNodePortId() == null) ? 0 : getNodePortId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getSchemaState() == null) ? 0 : getSchemaState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}