package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "pr_project")
public class PrProject implements Serializable {
    /**
     * 项目ID
     */
    @Id
    @Column(name = "PROJECT_ID")
    private Long projectId;

    /**
     * 项目代码
     */
    @Column(name = "PROJECT_CODE")
    private String projectCode;

    /**
     * 项目名称
     */
    @Column(name = "PROJECT_NAME")
    private String projectName;

    /**
     * 项目数据库ID
     */
    @Column(name = "DW_ID")
    private Long dwId;

    /**
     * 项目模型库ID
     */
    @Column(name = "MW_ID")
    private Long mwId;

    /**
     * 临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口
     */
    @Column(name = "CACHE_EXIPRE_DAYS")
    private Integer cacheExipreDays;

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
     * 获取项目ID
     *
     * @return PROJECT_ID - 项目ID
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 设置项目ID
     *
     * @param projectId 项目ID
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取项目代码
     *
     * @return PROJECT_CODE - 项目代码
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * 设置项目代码
     *
     * @param projectCode 项目代码
     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    /**
     * 获取项目名称
     *
     * @return PROJECT_NAME - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 获取项目数据库ID
     *
     * @return DW_ID - 项目数据库ID
     */
    public Long getDwId() {
        return dwId;
    }

    /**
     * 设置项目数据库ID
     *
     * @param dwId 项目数据库ID
     */
    public void setDwId(Long dwId) {
        this.dwId = dwId;
    }

    /**
     * 获取项目模型库ID
     *
     * @return MW_ID - 项目模型库ID
     */
    public Long getMwId() {
        return mwId;
    }

    /**
     * 设置项目模型库ID
     *
     * @param mwId 项目模型库ID
     */
    public void setMwId(Long mwId) {
        this.mwId = mwId;
    }

    /**
     * 获取临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口
     *
     * @return CACHE_EXIPRE_DAYS - 临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口
     */
    public Integer getCacheExipreDays() {
        return cacheExipreDays;
    }

    /**
     * 设置临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口
     *
     * @param cacheExipreDays 临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口
     */
    public void setCacheExipreDays(Integer cacheExipreDays) {
        this.cacheExipreDays = cacheExipreDays;
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
        PrProject other = (PrProject) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getDwId() == null ? other.getDwId() == null : this.getDwId().equals(other.getDwId()))
            && (this.getMwId() == null ? other.getMwId() == null : this.getMwId().equals(other.getMwId()))
            && (this.getCacheExipreDays() == null ? other.getCacheExipreDays() == null : this.getCacheExipreDays().equals(other.getCacheExipreDays()))
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
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectCode() == null) ? 0 : getProjectCode().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getDwId() == null) ? 0 : getDwId().hashCode());
        result = prime * result + ((getMwId() == null) ? 0 : getMwId().hashCode());
        result = prime * result + ((getCacheExipreDays() == null) ? 0 : getCacheExipreDays().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}