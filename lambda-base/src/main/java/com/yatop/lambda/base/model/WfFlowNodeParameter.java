package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_flow_node_parameter")
public class WfFlowNodeParameter extends WfFlowNodeParameterKey implements Serializable {
    /**
     * 特征值
     */
    @Column(name = "CHAR_VALUE")
    private String charValue;

    /**
     * 是否为全局参数
            0：否
            1：是
     */
    @Column(name = "IS_GLOBAL_PARAMETER")
    private Integer isGlobalParameter;

    /**
     * 是否被复制
            0：否
            1：是
            
            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值
     */
    @Column(name = "IS_DUPLICATED")
    private Integer isDuplicated;

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
     * 获取特征值
     *
     * @return CHAR_VALUE - 特征值
     */
    public String getCharValue() {
        return charValue;
    }

    /**
     * 设置特征值
     *
     * @param charValue 特征值
     */
    public void setCharValue(String charValue) {
        this.charValue = charValue == null ? null : charValue.trim();
    }

    /**
     * 获取是否为全局参数
            0：否
            1：是
     *
     * @return IS_GLOBAL_PARAMETER - 是否为全局参数
            0：否
            1：是
     */
    public Integer getIsGlobalParameter() {
        return isGlobalParameter;
    }

    /**
     * 设置是否为全局参数
            0：否
            1：是
     *
     * @param isGlobalParameter 是否为全局参数
            0：否
            1：是
     */
    public void setIsGlobalParameter(Integer isGlobalParameter) {
        this.isGlobalParameter = isGlobalParameter;
    }

    /**
     * 获取是否被复制
            0：否
            1：是
            
            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值
     *
     * @return IS_DUPLICATED - 是否被复制
            0：否
            1：是
            
            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值
     */
    public Integer getIsDuplicated() {
        return isDuplicated;
    }

    /**
     * 设置是否被复制
            0：否
            1：是
            
            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值
     *
     * @param isDuplicated 是否被复制
            0：否
            1：是
            
            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值
     */
    public void setIsDuplicated(Integer isDuplicated) {
        this.isDuplicated = isDuplicated;
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
        WfFlowNodeParameter other = (WfFlowNodeParameter) that;
        return (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getCharValue() == null ? other.getCharValue() == null : this.getCharValue().equals(other.getCharValue()))
            && (this.getIsGlobalParameter() == null ? other.getIsGlobalParameter() == null : this.getIsGlobalParameter().equals(other.getIsGlobalParameter()))
            && (this.getIsDuplicated() == null ? other.getIsDuplicated() == null : this.getIsDuplicated().equals(other.getIsDuplicated()))
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
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        result = prime * result + ((getCharValue() == null) ? 0 : getCharValue().hashCode());
        result = prime * result + ((getIsGlobalParameter() == null) ? 0 : getIsGlobalParameter().hashCode());
        result = prime * result + ((getIsDuplicated() == null) ? 0 : getIsDuplicated().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}