package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_module_catalog")
public class WfModuleCatalog implements Serializable {
    /**
     * 目录ID
     */
    @Id
    @Column(name = "CATALOG_ID")
    private Long catalogId;

    /**
     * 目录代码
     */
    @Column(name = "CATALOG_CODE")
    private String catalogCode;

    /**
     * 目录名称
     */
    @Column(name = "CATALOG_NAME")
    private String catalogName;

    /**
     * 上级目录ID，一级目录设为0
     */
    @Column(name = "PARENT_CATALOG_ID")
    private Long parentCatalogId;

    /**
     * 排序序号
     */
    @Column(name = "SEQUENCE")
    private Integer sequence;

    /**
     * 图标类型
     */
    @Column(name = "ICON_TYPE")
    private Integer iconType;

    /**
     * 组件类别（预留），自定义类别
     */
    @Column(name = "CATEGORY")
    private String category;

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
     * 获取目录ID
     *
     * @return CATALOG_ID - 目录ID
     */
    public Long getCatalogId() {
        return catalogId;
    }

    /**
     * 设置目录ID
     *
     * @param catalogId 目录ID
     */
    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    /**
     * 获取目录代码
     *
     * @return CATALOG_CODE - 目录代码
     */
    public String getCatalogCode() {
        return catalogCode;
    }

    /**
     * 设置目录代码
     *
     * @param catalogCode 目录代码
     */
    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode == null ? null : catalogCode.trim();
    }

    /**
     * 获取目录名称
     *
     * @return CATALOG_NAME - 目录名称
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * 设置目录名称
     *
     * @param catalogName 目录名称
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    /**
     * 获取上级目录ID，一级目录设为0
     *
     * @return PARENT_CATALOG_ID - 上级目录ID，一级目录设为0
     */
    public Long getParentCatalogId() {
        return parentCatalogId;
    }

    /**
     * 设置上级目录ID，一级目录设为0
     *
     * @param parentCatalogId 上级目录ID，一级目录设为0
     */
    public void setParentCatalogId(Long parentCatalogId) {
        this.parentCatalogId = parentCatalogId;
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
     * 获取图标类型
     *
     * @return ICON_TYPE - 图标类型
     */
    public Integer getIconType() {
        return iconType;
    }

    /**
     * 设置图标类型
     *
     * @param iconType 图标类型
     */
    public void setIconType(Integer iconType) {
        this.iconType = iconType;
    }

    /**
     * 获取组件类别（预留），自定义类别
     *
     * @return CATEGORY - 组件类别（预留），自定义类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置组件类别（预留），自定义类别
     *
     * @param category 组件类别（预留），自定义类别
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
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
        WfModuleCatalog other = (WfModuleCatalog) that;
        return (this.getCatalogId() == null ? other.getCatalogId() == null : this.getCatalogId().equals(other.getCatalogId()))
            && (this.getCatalogCode() == null ? other.getCatalogCode() == null : this.getCatalogCode().equals(other.getCatalogCode()))
            && (this.getCatalogName() == null ? other.getCatalogName() == null : this.getCatalogName().equals(other.getCatalogName()))
            && (this.getParentCatalogId() == null ? other.getParentCatalogId() == null : this.getParentCatalogId().equals(other.getParentCatalogId()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getIconType() == null ? other.getIconType() == null : this.getIconType().equals(other.getIconType()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
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
        result = prime * result + ((getCatalogId() == null) ? 0 : getCatalogId().hashCode());
        result = prime * result + ((getCatalogCode() == null) ? 0 : getCatalogCode().hashCode());
        result = prime * result + ((getCatalogName() == null) ? 0 : getCatalogName().hashCode());
        result = prime * result + ((getParentCatalogId() == null) ? 0 : getParentCatalogId().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getIconType() == null) ? 0 : getIconType().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}