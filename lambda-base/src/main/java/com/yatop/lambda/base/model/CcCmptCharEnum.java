package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cc_cmpt_char_enum")
public class CcCmptCharEnum extends CcCmptCharEnumKey implements Serializable {
    /**
     * 枚举值
     */
    @Column(name = "ENUM_VALUE")
    private String enumValue;

    /**
     * 枚举值标签，用于下拉框显示用，NULL时使用ENUM_VALUE填充
     */
    @Column(name = "ENUM_LABEL")
    private String enumLabel;

    /**
     * 排序序号
     */
    @Column(name = "SEQUENCE")
    private Integer sequence;

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
     * 获取枚举值
     *
     * @return ENUM_VALUE - 枚举值
     */
    public String getEnumValue() {
        return enumValue;
    }

    /**
     * 设置枚举值
     *
     * @param enumValue 枚举值
     */
    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue == null ? null : enumValue.trim();
    }

    /**
     * 获取枚举值标签，用于下拉框显示用，NULL时使用ENUM_VALUE填充
     *
     * @return ENUM_LABEL - 枚举值标签，用于下拉框显示用，NULL时使用ENUM_VALUE填充
     */
    public String getEnumLabel() {
        return enumLabel;
    }

    /**
     * 设置枚举值标签，用于下拉框显示用，NULL时使用ENUM_VALUE填充
     *
     * @param enumLabel 枚举值标签，用于下拉框显示用，NULL时使用ENUM_VALUE填充
     */
    public void setEnumLabel(String enumLabel) {
        this.enumLabel = enumLabel == null ? null : enumLabel.trim();
    }

    /**
     * 获取排序序号
     *
     * @return SEQUENCE - 排序序号
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置排序序号
     *
     * @param sequence 排序序号
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
        CcCmptCharEnum other = (CcCmptCharEnum) that;
        return (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getEnumName() == null ? other.getEnumName() == null : this.getEnumName().equals(other.getEnumName()))
            && (this.getEnumValue() == null ? other.getEnumValue() == null : this.getEnumValue().equals(other.getEnumValue()))
            && (this.getEnumLabel() == null ? other.getEnumLabel() == null : this.getEnumLabel().equals(other.getEnumLabel()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
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
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        result = prime * result + ((getEnumName() == null) ? 0 : getEnumName().hashCode());
        result = prime * result + ((getEnumValue() == null) ? 0 : getEnumValue().hashCode());
        result = prime * result + ((getEnumLabel() == null) ? 0 : getEnumLabel().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}