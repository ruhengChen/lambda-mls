package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cc_cmpt_spec")
public class CcCmptSpec implements Serializable {
    /**
     * 规格ID，长度限制20
            
            输入内容规格ID范围：IN@SPEC-[0000 ~ 9999]
            输出内容规格ID范围：OUT@SPEC-[0000 ~ 9999]
            调用执行规格ID范围：EX@SPEC-[0000 ~ 9999]
            执行调优参规格ID范围：OEX@SPEC-[0000 ~ 9999]
            组件参数规格ID范围：CP@SPEC-${CMPT-ID}
     */
    @Id
    @Column(name = "SPEC_ID")
    private String specId;

    /**
     * 规格代码（预留）
     */
    @Column(name = "SPEC_CODE")
    private String specCode;

    /**
     * 规格名称
     */
    @Column(name = "SPEC_NAME")
    private String specName;

    /**
     * 规格类型
1：input，输入内容规格（无此类规格代表无输入内容，仅供数据流转和连线校验用，不做存储）
2：output，输出内容规格（无此类规格代表无输出内容，在运行时分配存储）
3：execution，调用执行规格（无此类规格代表无需执行，基本是配置数据）
4：optimize execution，执行调优参数规格（无此类规格代表无执行调优参数，在编辑时分配存储）
5：parameter，组件参数规格（无此类规格代表无需组件参数配置，在编辑时分配存储）
     */
    @Column(name = "SPEC_TYPE")
    private Integer specType;

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
     * 获取规格ID，长度限制20
            
            输入内容规格ID范围：IN@SPEC-[0000 ~ 9999]
            输出内容规格ID范围：OUT@SPEC-[0000 ~ 9999]
            调用执行规格ID范围：EX@SPEC-[0000 ~ 9999]
            执行调优参规格ID范围：OEX@SPEC-[0000 ~ 9999]
            组件参数规格ID范围：CP@SPEC-${CMPT-ID}
     *
     * @return SPEC_ID - 规格ID，长度限制20
            
            输入内容规格ID范围：IN@SPEC-[0000 ~ 9999]
            输出内容规格ID范围：OUT@SPEC-[0000 ~ 9999]
            调用执行规格ID范围：EX@SPEC-[0000 ~ 9999]
            执行调优参规格ID范围：OEX@SPEC-[0000 ~ 9999]
            组件参数规格ID范围：CP@SPEC-${CMPT-ID}
     */
    public String getSpecId() {
        return specId;
    }

    /**
     * 设置规格ID，长度限制20
            
            输入内容规格ID范围：IN@SPEC-[0000 ~ 9999]
            输出内容规格ID范围：OUT@SPEC-[0000 ~ 9999]
            调用执行规格ID范围：EX@SPEC-[0000 ~ 9999]
            执行调优参规格ID范围：OEX@SPEC-[0000 ~ 9999]
            组件参数规格ID范围：CP@SPEC-${CMPT-ID}
     *
     * @param specId 规格ID，长度限制20
            
            输入内容规格ID范围：IN@SPEC-[0000 ~ 9999]
            输出内容规格ID范围：OUT@SPEC-[0000 ~ 9999]
            调用执行规格ID范围：EX@SPEC-[0000 ~ 9999]
            执行调优参规格ID范围：OEX@SPEC-[0000 ~ 9999]
            组件参数规格ID范围：CP@SPEC-${CMPT-ID}
     */
    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    /**
     * 获取规格代码（预留）
     *
     * @return SPEC_CODE - 规格代码（预留）
     */
    public String getSpecCode() {
        return specCode;
    }

    /**
     * 设置规格代码（预留）
     *
     * @param specCode 规格代码（预留）
     */
    public void setSpecCode(String specCode) {
        this.specCode = specCode == null ? null : specCode.trim();
    }

    /**
     * 获取规格名称
     *
     * @return SPEC_NAME - 规格名称
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * 设置规格名称
     *
     * @param specName 规格名称
     */
    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    /**
     * 获取规格类型
1：input，输入内容规格（无此类规格代表无输入内容，仅供数据流转和连线校验用，不做存储）
2：output，输出内容规格（无此类规格代表无输出内容，在运行时分配存储）
3：execution，调用执行规格（无此类规格代表无需执行，基本是配置数据）
4：optimize execution，执行调优参数规格（无此类规格代表无执行调优参数，在编辑时分配存储）
5：parameter，组件参数规格（无此类规格代表无需组件参数配置，在编辑时分配存储）
     *
     * @return SPEC_TYPE - 规格类型
1：input，输入内容规格（无此类规格代表无输入内容，仅供数据流转和连线校验用，不做存储）
2：output，输出内容规格（无此类规格代表无输出内容，在运行时分配存储）
3：execution，调用执行规格（无此类规格代表无需执行，基本是配置数据）
4：optimize execution，执行调优参数规格（无此类规格代表无执行调优参数，在编辑时分配存储）
5：parameter，组件参数规格（无此类规格代表无需组件参数配置，在编辑时分配存储）
     */
    public Integer getSpecType() {
        return specType;
    }

    /**
     * 设置规格类型
1：input，输入内容规格（无此类规格代表无输入内容，仅供数据流转和连线校验用，不做存储）
2：output，输出内容规格（无此类规格代表无输出内容，在运行时分配存储）
3：execution，调用执行规格（无此类规格代表无需执行，基本是配置数据）
4：optimize execution，执行调优参数规格（无此类规格代表无执行调优参数，在编辑时分配存储）
5：parameter，组件参数规格（无此类规格代表无需组件参数配置，在编辑时分配存储）
     *
     * @param specType 规格类型
1：input，输入内容规格（无此类规格代表无输入内容，仅供数据流转和连线校验用，不做存储）
2：output，输出内容规格（无此类规格代表无输出内容，在运行时分配存储）
3：execution，调用执行规格（无此类规格代表无需执行，基本是配置数据）
4：optimize execution，执行调优参数规格（无此类规格代表无执行调优参数，在编辑时分配存储）
5：parameter，组件参数规格（无此类规格代表无需组件参数配置，在编辑时分配存储）
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
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
        CcCmptSpec other = (CcCmptSpec) that;
        return (this.getSpecId() == null ? other.getSpecId() == null : this.getSpecId().equals(other.getSpecId()))
            && (this.getSpecCode() == null ? other.getSpecCode() == null : this.getSpecCode().equals(other.getSpecCode()))
            && (this.getSpecName() == null ? other.getSpecName() == null : this.getSpecName().equals(other.getSpecName()))
            && (this.getSpecType() == null ? other.getSpecType() == null : this.getSpecType().equals(other.getSpecType()))
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
        result = prime * result + ((getSpecId() == null) ? 0 : getSpecId().hashCode());
        result = prime * result + ((getSpecCode() == null) ? 0 : getSpecCode().hashCode());
        result = prime * result + ((getSpecName() == null) ? 0 : getSpecName().hashCode());
        result = prime * result + ((getSpecType() == null) ? 0 : getSpecType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}