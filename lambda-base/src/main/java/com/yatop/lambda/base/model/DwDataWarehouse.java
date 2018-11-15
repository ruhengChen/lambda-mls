package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "dw_data_warehouse")
public class DwDataWarehouse implements Serializable {
    /**
     * 数据库ID
     */
    @Id
    @Column(name = "DW_ID")
    private Long dwId;

    /**
     * 数据库代码
            
            公共数据库：由英文字符、数字和下划线组成，起始字符不能为下划线
            项目数据库：$符号前缀 + 项目代码
     */
    @Column(name = "DW_CODE")
    private String dwCode;

    /**
     * 数据库名
     */
    @Column(name = "DW_NAME")
    private String dwName;

    /**
     * 数据库类型
            0：公共数据库，暂用于存放实验模版所预置的数据表
            1：项目数据库，随项目创建同时生成，存放项目中产生的数据表
     */
    @Column(name = "DW_TYPE")
    private Integer dwType;

    /**
     * 所属项目ID，数据库类型为公共数据库时设为-1
     */
    @Column(name = "OWNER_PROJECT_ID")
    private Long ownerProjectId;

    /**
     * DFS数据目录，存放全量数据文件和数据概要文件
            
            示例如下：
            ${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/<dw_code>
     */
    @Column(name = "DFS_DATA_DIR")
    private String dfsDataDir;

    /**
     * 本地数据目录，仅缓存数据概要文件
            
            示例如下：
            ${LOCAL_WORK_ROOT}/dw_data/<dw_code>
     */
    @Column(name = "LOCAL_DATA_DIR")
    private String localDataDir;

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
     * 获取数据库ID
     *
     * @return DW_ID - 数据库ID
     */
    public Long getDwId() {
        return dwId;
    }

    /**
     * 设置数据库ID
     *
     * @param dwId 数据库ID
     */
    public void setDwId(Long dwId) {
        this.dwId = dwId;
    }

    /**
     * 获取数据库代码
            
            公共数据库：由英文字符、数字和下划线组成，起始字符不能为下划线
            项目数据库：$符号前缀 + 项目代码
     *
     * @return DW_CODE - 数据库代码
            
            公共数据库：由英文字符、数字和下划线组成，起始字符不能为下划线
            项目数据库：$符号前缀 + 项目代码
     */
    public String getDwCode() {
        return dwCode;
    }

    /**
     * 设置数据库代码
            
            公共数据库：由英文字符、数字和下划线组成，起始字符不能为下划线
            项目数据库：$符号前缀 + 项目代码
     *
     * @param dwCode 数据库代码
            
            公共数据库：由英文字符、数字和下划线组成，起始字符不能为下划线
            项目数据库：$符号前缀 + 项目代码
     */
    public void setDwCode(String dwCode) {
        this.dwCode = dwCode == null ? null : dwCode.trim();
    }

    /**
     * 获取数据库名
     *
     * @return DW_NAME - 数据库名
     */
    public String getDwName() {
        return dwName;
    }

    /**
     * 设置数据库名
     *
     * @param dwName 数据库名
     */
    public void setDwName(String dwName) {
        this.dwName = dwName == null ? null : dwName.trim();
    }

    /**
     * 获取数据库类型
            0：公共数据库，暂用于存放实验模版所预置的数据表
            1：项目数据库，随项目创建同时生成，存放项目中产生的数据表
     *
     * @return DW_TYPE - 数据库类型
            0：公共数据库，暂用于存放实验模版所预置的数据表
            1：项目数据库，随项目创建同时生成，存放项目中产生的数据表
     */
    public Integer getDwType() {
        return dwType;
    }

    /**
     * 设置数据库类型
            0：公共数据库，暂用于存放实验模版所预置的数据表
            1：项目数据库，随项目创建同时生成，存放项目中产生的数据表
     *
     * @param dwType 数据库类型
            0：公共数据库，暂用于存放实验模版所预置的数据表
            1：项目数据库，随项目创建同时生成，存放项目中产生的数据表
     */
    public void setDwType(Integer dwType) {
        this.dwType = dwType;
    }

    /**
     * 获取所属项目ID，数据库类型为公共数据库时设为-1
     *
     * @return OWNER_PROJECT_ID - 所属项目ID，数据库类型为公共数据库时设为-1
     */
    public Long getOwnerProjectId() {
        return ownerProjectId;
    }

    /**
     * 设置所属项目ID，数据库类型为公共数据库时设为-1
     *
     * @param ownerProjectId 所属项目ID，数据库类型为公共数据库时设为-1
     */
    public void setOwnerProjectId(Long ownerProjectId) {
        this.ownerProjectId = ownerProjectId;
    }

    /**
     * 获取DFS数据目录，存放全量数据文件和数据概要文件
            
            示例如下：
            ${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/<dw_code>
     *
     * @return DFS_DATA_DIR - DFS数据目录，存放全量数据文件和数据概要文件
            
            示例如下：
            ${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/<dw_code>
     */
    public String getDfsDataDir() {
        return dfsDataDir;
    }

    /**
     * 设置DFS数据目录，存放全量数据文件和数据概要文件
            
            示例如下：
            ${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/<dw_code>
     *
     * @param dfsDataDir DFS数据目录，存放全量数据文件和数据概要文件
            
            示例如下：
            ${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/<dw_code>
     */
    public void setDfsDataDir(String dfsDataDir) {
        this.dfsDataDir = dfsDataDir == null ? null : dfsDataDir.trim();
    }

    /**
     * 获取本地数据目录，仅缓存数据概要文件
            
            示例如下：
            ${LOCAL_WORK_ROOT}/dw_data/<dw_code>
     *
     * @return LOCAL_DATA_DIR - 本地数据目录，仅缓存数据概要文件
            
            示例如下：
            ${LOCAL_WORK_ROOT}/dw_data/<dw_code>
     */
    public String getLocalDataDir() {
        return localDataDir;
    }

    /**
     * 设置本地数据目录，仅缓存数据概要文件
            
            示例如下：
            ${LOCAL_WORK_ROOT}/dw_data/<dw_code>
     *
     * @param localDataDir 本地数据目录，仅缓存数据概要文件
            
            示例如下：
            ${LOCAL_WORK_ROOT}/dw_data/<dw_code>
     */
    public void setLocalDataDir(String localDataDir) {
        this.localDataDir = localDataDir == null ? null : localDataDir.trim();
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
        DwDataWarehouse other = (DwDataWarehouse) that;
        return (this.getDwId() == null ? other.getDwId() == null : this.getDwId().equals(other.getDwId()))
            && (this.getDwCode() == null ? other.getDwCode() == null : this.getDwCode().equals(other.getDwCode()))
            && (this.getDwName() == null ? other.getDwName() == null : this.getDwName().equals(other.getDwName()))
            && (this.getDwType() == null ? other.getDwType() == null : this.getDwType().equals(other.getDwType()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getDfsDataDir() == null ? other.getDfsDataDir() == null : this.getDfsDataDir().equals(other.getDfsDataDir()))
            && (this.getLocalDataDir() == null ? other.getLocalDataDir() == null : this.getLocalDataDir().equals(other.getLocalDataDir()))
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
        result = prime * result + ((getDwId() == null) ? 0 : getDwId().hashCode());
        result = prime * result + ((getDwCode() == null) ? 0 : getDwCode().hashCode());
        result = prime * result + ((getDwName() == null) ? 0 : getDwName().hashCode());
        result = prime * result + ((getDwType() == null) ? 0 : getDwType().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getDfsDataDir() == null) ? 0 : getDfsDataDir().hashCode());
        result = prime * result + ((getLocalDataDir() == null) ? 0 : getLocalDataDir().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}