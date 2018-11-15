package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_flow_node_schema")
public class WfFlowNodeSchema implements Serializable {
    /**
     * 所属节点输出端口ID
     */
    @Id
    @Column(name = "NODE_PORT_ID")
    private Long nodePortId;

    /**
     * json对象ID
     */
    @Column(name = "JSON_OBJECT_ID")
    private Long jsonObjectId;

    /**
     * JSON数据状态
            0：空对象
            1：非空对象
     */
    @Column(name = "SCHEMA_STATE")
    private Integer schemaState;

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
     * 获取所属节点输出端口ID
     *
     * @return NODE_PORT_ID - 所属节点输出端口ID
     */
    public Long getNodePortId() {
        return nodePortId;
    }

    /**
     * 设置所属节点输出端口ID
     *
     * @param nodePortId 所属节点输出端口ID
     */
    public void setNodePortId(Long nodePortId) {
        this.nodePortId = nodePortId;
    }

    /**
     * 获取json对象ID
     *
     * @return JSON_OBJECT_ID - json对象ID
     */
    public Long getJsonObjectId() {
        return jsonObjectId;
    }

    /**
     * 设置json对象ID
     *
     * @param jsonObjectId json对象ID
     */
    public void setJsonObjectId(Long jsonObjectId) {
        this.jsonObjectId = jsonObjectId;
    }

    /**
     * 获取JSON数据状态
            0：空对象
            1：非空对象
     *
     * @return SCHEMA_STATE - JSON数据状态
            0：空对象
            1：非空对象
     */
    public Integer getSchemaState() {
        return schemaState;
    }

    /**
     * 设置JSON数据状态
            0：空对象
            1：非空对象
     *
     * @param schemaState JSON数据状态
            0：空对象
            1：非空对象
     */
    public void setSchemaState(Integer schemaState) {
        this.schemaState = schemaState;
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
            && (this.getJsonObjectId() == null ? other.getJsonObjectId() == null : this.getJsonObjectId().equals(other.getJsonObjectId()))
            && (this.getSchemaState() == null ? other.getSchemaState() == null : this.getSchemaState().equals(other.getSchemaState()))
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
        result = prime * result + ((getJsonObjectId() == null) ? 0 : getJsonObjectId().hashCode());
        result = prime * result + ((getSchemaState() == null) ? 0 : getSchemaState().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}