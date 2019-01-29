package com.yatop.lambda.portal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "pr_project")
public class PrProject implements Serializable {

    private static final long serialVersionUID = 778081231535870010L;
    /**
     * 项目ID
     */
    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口，不做自动清理可配置为-1
     */
    @Column(name = "CACHE_EXPIRE_DAYS")
    private Integer cacheExpireDays;

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
     * 获取临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口，不做自动清理可配置为-1
     *
     * @return CACHE_EXPIRE_DAYS - 临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口，不做自动清理可配置为-1
     */
    public Integer getCacheExpireDays() {
        return cacheExpireDays;
    }

    /**
     * 设置临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口，不做自动清理可配置为-1
     *
     * @param cacheExpireDays 临时数据表过期天数，每天2点扫描清理，另外提供主动清理接口，不做自动清理可配置为-1
     */
    public void setCacheExpireDays(Integer cacheExpireDays) {
        this.cacheExpireDays = cacheExpireDays;
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
}