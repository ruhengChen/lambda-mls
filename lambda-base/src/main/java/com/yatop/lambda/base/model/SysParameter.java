package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_parameter")
public class SysParameter implements Serializable {
    /**
     * 参数ID
     */
    @Id
    @Column(name = "PARAM_ID")
    private Long paramId;

    /**
     * 参数代码
     */
    @Column(name = "PARAM_CODE")
    private String paramCode;

    /**
     * 参数名称
     */
    @Column(name = "PARAM_NAME")
    private String paramName;

    /**
     * 参数类别，按系统模块划分
     */
    @Column(name = "PARAM_CLASS")
    private Integer paramClass;

    /**
     * 参数子类别，按系统模块下的功能模块划分
     */
    @Column(name = "PARAM_SUB_CLASS")
    private Integer paramSubClass;

    /**
     * 参数值
     */
    @Column(name = "PARAM_VALUE")
    private String paramValue;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 参数状态
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
     * 获取参数ID
     *
     * @return PARAM_ID - 参数ID
     */
    public Long getParamId() {
        return paramId;
    }

    /**
     * 设置参数ID
     *
     * @param paramId 参数ID
     */
    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    /**
     * 获取参数代码
     *
     * @return PARAM_CODE - 参数代码
     */
    public String getParamCode() {
        return paramCode;
    }

    /**
     * 设置参数代码
     *
     * @param paramCode 参数代码
     */
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode == null ? null : paramCode.trim();
    }

    /**
     * 获取参数名称
     *
     * @return PARAM_NAME - 参数名称
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 设置参数名称
     *
     * @param paramName 参数名称
     */
    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    /**
     * 获取参数类别，按系统模块划分
     *
     * @return PARAM_CLASS - 参数类别，按系统模块划分
     */
    public Integer getParamClass() {
        return paramClass;
    }

    /**
     * 设置参数类别，按系统模块划分
     *
     * @param paramClass 参数类别，按系统模块划分
     */
    public void setParamClass(Integer paramClass) {
        this.paramClass = paramClass;
    }

    /**
     * 获取参数子类别，按系统模块下的功能模块划分
     *
     * @return PARAM_SUB_CLASS - 参数子类别，按系统模块下的功能模块划分
     */
    public Integer getParamSubClass() {
        return paramSubClass;
    }

    /**
     * 设置参数子类别，按系统模块下的功能模块划分
     *
     * @param paramSubClass 参数子类别，按系统模块下的功能模块划分
     */
    public void setParamSubClass(Integer paramSubClass) {
        this.paramSubClass = paramSubClass;
    }

    /**
     * 获取参数值
     *
     * @return PARAM_VALUE - 参数值
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * 设置参数值
     *
     * @param paramValue 参数值
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
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
     * 获取参数状态
            0：正常
            1：失效
     *
     * @return STATUS - 参数状态
            0：正常
            1：失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置参数状态
            0：正常
            1：失效
     *
     * @param status 参数状态
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
        SysParameter other = (SysParameter) that;
        return (this.getParamId() == null ? other.getParamId() == null : this.getParamId().equals(other.getParamId()))
            && (this.getParamCode() == null ? other.getParamCode() == null : this.getParamCode().equals(other.getParamCode()))
            && (this.getParamName() == null ? other.getParamName() == null : this.getParamName().equals(other.getParamName()))
            && (this.getParamClass() == null ? other.getParamClass() == null : this.getParamClass().equals(other.getParamClass()))
            && (this.getParamSubClass() == null ? other.getParamSubClass() == null : this.getParamSubClass().equals(other.getParamSubClass()))
            && (this.getParamValue() == null ? other.getParamValue() == null : this.getParamValue().equals(other.getParamValue()))
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
        result = prime * result + ((getParamId() == null) ? 0 : getParamId().hashCode());
        result = prime * result + ((getParamCode() == null) ? 0 : getParamCode().hashCode());
        result = prime * result + ((getParamName() == null) ? 0 : getParamName().hashCode());
        result = prime * result + ((getParamClass() == null) ? 0 : getParamClass().hashCode());
        result = prime * result + ((getParamSubClass() == null) ? 0 : getParamSubClass().hashCode());
        result = prime * result + ((getParamValue() == null) ? 0 : getParamValue().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}