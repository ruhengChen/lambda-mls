package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cc_cmpt_char_type")
public class CcCmptCharType implements Serializable {
    /**
     * 特征类型ID
     */
    @Id
    @Column(name = "CHAR_TYPE_ID")
    private Integer charTypeId;

    /**
     * 特征类型代码
     */
    @Column(name = "CHAR_TYPE_CODE")
    private String charTypeCode;

    /**
     * 特征类型名称
     */
    @Column(name = "CHAR_TYPE_NAME")
    private String charTypeName;

    /**
     * 是否为组合类型
0：否
1：是
     */
    @Column(name = "IS_COMBINE")
    private Integer isCombine;

    /**
     * 适用规格类型二进制掩码（预留）

0：不支持作为对应规格的特征类型使用
1：支持作为对应规格的特征类型使用

第一位，输入内容规格，开关位0x01：数据表、模型、算法参数
第二位，输出内容规格，开关位0x02：数据表、模型、算法参数
第三位，调用执行规格，开关位0x04：基本类型
第四位，执行调优规格，开关位0x08：基本类型
第五位，组件参数规格，开关位0x10：基本类型、调参类型、代码脚本、Json Object、Json Array

     */
    @Column(name = "SPEC_TYPE_MASK")
    private Integer specTypeMask;

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
     * 获取特征类型ID
     *
     * @return CHAR_TYPE_ID - 特征类型ID
     */
    public Integer getCharTypeId() {
        return charTypeId;
    }

    /**
     * 设置特征类型ID
     *
     * @param charTypeId 特征类型ID
     */
    public void setCharTypeId(Integer charTypeId) {
        this.charTypeId = charTypeId;
    }

    /**
     * 获取特征类型代码
     *
     * @return CHAR_TYPE_CODE - 特征类型代码
     */
    public String getCharTypeCode() {
        return charTypeCode;
    }

    /**
     * 设置特征类型代码
     *
     * @param charTypeCode 特征类型代码
     */
    public void setCharTypeCode(String charTypeCode) {
        this.charTypeCode = charTypeCode == null ? null : charTypeCode.trim();
    }

    /**
     * 获取特征类型名称
     *
     * @return CHAR_TYPE_NAME - 特征类型名称
     */
    public String getCharTypeName() {
        return charTypeName;
    }

    /**
     * 设置特征类型名称
     *
     * @param charTypeName 特征类型名称
     */
    public void setCharTypeName(String charTypeName) {
        this.charTypeName = charTypeName == null ? null : charTypeName.trim();
    }

    /**
     * 获取是否为组合类型
0：否
1：是
     *
     * @return IS_COMBINE - 是否为组合类型
0：否
1：是
     */
    public Integer getIsCombine() {
        return isCombine;
    }

    /**
     * 设置是否为组合类型
0：否
1：是
     *
     * @param isCombine 是否为组合类型
0：否
1：是
     */
    public void setIsCombine(Integer isCombine) {
        this.isCombine = isCombine;
    }

    /**
     * 获取适用规格类型二进制掩码（预留）

0：不支持作为对应规格的特征类型使用
1：支持作为对应规格的特征类型使用

第一位，输入内容规格，开关位0x01：数据表、模型、算法参数
第二位，输出内容规格，开关位0x02：数据表、模型、算法参数
第三位，调用执行规格，开关位0x04：基本类型
第四位，执行调优规格，开关位0x08：基本类型
第五位，组件参数规格，开关位0x10：基本类型、调参类型、代码脚本、Json Object、Json Array

     *
     * @return SPEC_TYPE_MASK - 适用规格类型二进制掩码（预留）

0：不支持作为对应规格的特征类型使用
1：支持作为对应规格的特征类型使用

第一位，输入内容规格，开关位0x01：数据表、模型、算法参数
第二位，输出内容规格，开关位0x02：数据表、模型、算法参数
第三位，调用执行规格，开关位0x04：基本类型
第四位，执行调优规格，开关位0x08：基本类型
第五位，组件参数规格，开关位0x10：基本类型、调参类型、代码脚本、Json Object、Json Array

     */
    public Integer getSpecTypeMask() {
        return specTypeMask;
    }

    /**
     * 设置适用规格类型二进制掩码（预留）

0：不支持作为对应规格的特征类型使用
1：支持作为对应规格的特征类型使用

第一位，输入内容规格，开关位0x01：数据表、模型、算法参数
第二位，输出内容规格，开关位0x02：数据表、模型、算法参数
第三位，调用执行规格，开关位0x04：基本类型
第四位，执行调优规格，开关位0x08：基本类型
第五位，组件参数规格，开关位0x10：基本类型、调参类型、代码脚本、Json Object、Json Array

     *
     * @param specTypeMask 适用规格类型二进制掩码（预留）

0：不支持作为对应规格的特征类型使用
1：支持作为对应规格的特征类型使用

第一位，输入内容规格，开关位0x01：数据表、模型、算法参数
第二位，输出内容规格，开关位0x02：数据表、模型、算法参数
第三位，调用执行规格，开关位0x04：基本类型
第四位，执行调优规格，开关位0x08：基本类型
第五位，组件参数规格，开关位0x10：基本类型、调参类型、代码脚本、Json Object、Json Array

     */
    public void setSpecTypeMask(Integer specTypeMask) {
        this.specTypeMask = specTypeMask;
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
        CcCmptCharType other = (CcCmptCharType) that;
        return (this.getCharTypeId() == null ? other.getCharTypeId() == null : this.getCharTypeId().equals(other.getCharTypeId()))
            && (this.getCharTypeCode() == null ? other.getCharTypeCode() == null : this.getCharTypeCode().equals(other.getCharTypeCode()))
            && (this.getCharTypeName() == null ? other.getCharTypeName() == null : this.getCharTypeName().equals(other.getCharTypeName()))
            && (this.getIsCombine() == null ? other.getIsCombine() == null : this.getIsCombine().equals(other.getIsCombine()))
            && (this.getSpecTypeMask() == null ? other.getSpecTypeMask() == null : this.getSpecTypeMask().equals(other.getSpecTypeMask()))
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
        result = prime * result + ((getCharTypeId() == null) ? 0 : getCharTypeId().hashCode());
        result = prime * result + ((getCharTypeCode() == null) ? 0 : getCharTypeCode().hashCode());
        result = prime * result + ((getCharTypeName() == null) ? 0 : getCharTypeName().hashCode());
        result = prime * result + ((getIsCombine() == null) ? 0 : getIsCombine().hashCode());
        result = prime * result + ((getSpecTypeMask() == null) ? 0 : getSpecTypeMask().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}