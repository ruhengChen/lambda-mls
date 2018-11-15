package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_flow_global_parameter")
public class WfFlowGlobalParameter implements Serializable {
    /**
     * 全局参数ID
     */
    @Id
    @Column(name = "GLOBAL_PARAM_ID")
    private Long globalParamId;

    /**
     * 全局参数名
     */
    @Column(name = "GLOBAL_PARAM_NAME")
    private String globalParamName;

    /**
     * 关联工作流ID
     */
    @Column(name = "REL_FLOW_ID")
    private Long relFlowId;

    /**
     * 关联节点ID
     */
    @Column(name = "REL_NODE_ID")
    private Long relNodeId;

    /**
     * 关联组件特征ID
     */
    @Column(name = "REL_CHAR_ID")
    private Long relCharId;

    /**
     * 默认值
     */
    @Column(name = "DEFAULT_VALUE")
    private String defaultValue;

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
     * 获取全局参数ID
     *
     * @return GLOBAL_PARAM_ID - 全局参数ID
     */
    public Long getGlobalParamId() {
        return globalParamId;
    }

    /**
     * 设置全局参数ID
     *
     * @param globalParamId 全局参数ID
     */
    public void setGlobalParamId(Long globalParamId) {
        this.globalParamId = globalParamId;
    }

    /**
     * 获取全局参数名
     *
     * @return GLOBAL_PARAM_NAME - 全局参数名
     */
    public String getGlobalParamName() {
        return globalParamName;
    }

    /**
     * 设置全局参数名
     *
     * @param globalParamName 全局参数名
     */
    public void setGlobalParamName(String globalParamName) {
        this.globalParamName = globalParamName == null ? null : globalParamName.trim();
    }

    /**
     * 获取关联工作流ID
     *
     * @return REL_FLOW_ID - 关联工作流ID
     */
    public Long getRelFlowId() {
        return relFlowId;
    }

    /**
     * 设置关联工作流ID
     *
     * @param relFlowId 关联工作流ID
     */
    public void setRelFlowId(Long relFlowId) {
        this.relFlowId = relFlowId;
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
     * 获取关联组件特征ID
     *
     * @return REL_CHAR_ID - 关联组件特征ID
     */
    public Long getRelCharId() {
        return relCharId;
    }

    /**
     * 设置关联组件特征ID
     *
     * @param relCharId 关联组件特征ID
     */
    public void setRelCharId(Long relCharId) {
        this.relCharId = relCharId;
    }

    /**
     * 获取默认值
     *
     * @return DEFAULT_VALUE - 默认值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 设置默认值
     *
     * @param defaultValue 默认值
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
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
        WfFlowGlobalParameter other = (WfFlowGlobalParameter) that;
        return (this.getGlobalParamId() == null ? other.getGlobalParamId() == null : this.getGlobalParamId().equals(other.getGlobalParamId()))
            && (this.getGlobalParamName() == null ? other.getGlobalParamName() == null : this.getGlobalParamName().equals(other.getGlobalParamName()))
            && (this.getRelFlowId() == null ? other.getRelFlowId() == null : this.getRelFlowId().equals(other.getRelFlowId()))
            && (this.getRelNodeId() == null ? other.getRelNodeId() == null : this.getRelNodeId().equals(other.getRelNodeId()))
            && (this.getRelCharId() == null ? other.getRelCharId() == null : this.getRelCharId().equals(other.getRelCharId()))
            && (this.getDefaultValue() == null ? other.getDefaultValue() == null : this.getDefaultValue().equals(other.getDefaultValue()))
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
        result = prime * result + ((getGlobalParamId() == null) ? 0 : getGlobalParamId().hashCode());
        result = prime * result + ((getGlobalParamName() == null) ? 0 : getGlobalParamName().hashCode());
        result = prime * result + ((getRelFlowId() == null) ? 0 : getRelFlowId().hashCode());
        result = prime * result + ((getRelNodeId() == null) ? 0 : getRelNodeId().hashCode());
        result = prime * result + ((getRelCharId() == null) ? 0 : getRelCharId().hashCode());
        result = prime * result + ((getDefaultValue() == null) ? 0 : getDefaultValue().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}