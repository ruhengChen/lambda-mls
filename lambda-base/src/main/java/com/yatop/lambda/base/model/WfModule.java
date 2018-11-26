package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_module")
public class WfModule implements Serializable {
    /**
     * 组件ID
     */
    @Id
    @Column(name = "MODULE_ID")
    private Long moduleId;

    /**
     * 组件代码
     */
    @Column(name = "MODULE_CODE")
    private String moduleCode;

    /**
     * 组件名称
     */
    @Column(name = "MODULE_NAME")
    private String moduleName;

    /**
     * 所属目录ID，不进目录设为-1
     */
    @Column(name = "CATALOG_ID")
    private Long catalogId;

    /**
     * 排序序号
     */
    @Column(name = "SEQUENCE")
    private Integer sequence;

    /**
     * 组件类别（预留），自定义类别
     */
    @Column(name = "CATEGORY")
    private String category;

    /**
     * 图标类型
     */
    @Column(name = "ICON_TYPE")
    private Integer iconType;

    /**
     * 组件java类class path
     */
    @Column(name = "CLASS_PATH")
    private String classPath;

    /**
     * 所封装的计算组件ID
     */
    @Column(name = "PKG_CMPT_ID")
    private String pkgCmptId;

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
     * 获取组件ID
     *
     * @return MODULE_ID - 组件ID
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * 设置组件ID
     *
     * @param moduleId 组件ID
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 获取组件代码
     *
     * @return MODULE_CODE - 组件代码
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * 设置组件代码
     *
     * @param moduleCode 组件代码
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }

    /**
     * 获取组件名称
     *
     * @return MODULE_NAME - 组件名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置组件名称
     *
     * @param moduleName 组件名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * 获取所属目录ID，不进目录设为-1
     *
     * @return CATALOG_ID - 所属目录ID，不进目录设为-1
     */
    public Long getCatalogId() {
        return catalogId;
    }

    /**
     * 设置所属目录ID，不进目录设为-1
     *
     * @param catalogId 所属目录ID，不进目录设为-1
     */
    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
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
     * 获取组件java类class path
     *
     * @return CLASS_PATH - 组件java类class path
     */
    public String getClassPath() {
        return classPath;
    }

    /**
     * 设置组件java类class path
     *
     * @param classPath 组件java类class path
     */
    public void setClassPath(String classPath) {
        this.classPath = classPath == null ? null : classPath.trim();
    }

    /**
     * 获取所封装的计算组件ID
     *
     * @return PKG_CMPT_ID - 所封装的计算组件ID
     */
    public String getPkgCmptId() {
        return pkgCmptId;
    }

    /**
     * 设置所封装的计算组件ID
     *
     * @param pkgCmptId 所封装的计算组件ID
     */
    public void setPkgCmptId(String pkgCmptId) {
        this.pkgCmptId = pkgCmptId == null ? null : pkgCmptId.trim();
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
        WfModule other = (WfModule) that;
        return (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getModuleCode() == null ? other.getModuleCode() == null : this.getModuleCode().equals(other.getModuleCode()))
            && (this.getModuleName() == null ? other.getModuleName() == null : this.getModuleName().equals(other.getModuleName()))
            && (this.getCatalogId() == null ? other.getCatalogId() == null : this.getCatalogId().equals(other.getCatalogId()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getIconType() == null ? other.getIconType() == null : this.getIconType().equals(other.getIconType()))
            && (this.getClassPath() == null ? other.getClassPath() == null : this.getClassPath().equals(other.getClassPath()))
            && (this.getPkgCmptId() == null ? other.getPkgCmptId() == null : this.getPkgCmptId().equals(other.getPkgCmptId()))
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
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        result = prime * result + ((getModuleCode() == null) ? 0 : getModuleCode().hashCode());
        result = prime * result + ((getModuleName() == null) ? 0 : getModuleName().hashCode());
        result = prime * result + ((getCatalogId() == null) ? 0 : getCatalogId().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getIconType() == null) ? 0 : getIconType().hashCode());
        result = prime * result + ((getClassPath() == null) ? 0 : getClassPath().hashCode());
        result = prime * result + ((getPkgCmptId() == null) ? 0 : getPkgCmptId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}