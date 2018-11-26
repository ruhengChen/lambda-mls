package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mw_model_warehouse")
public class MwModelWarehouse implements Serializable {
    /**
     * 数据库ID
     */
    @Id
    @Column(name = "MW_ID")
    private Long mwId;

    /**
     * 模型库代码
            
            公共模型库：由英文字符、数字和下划线组成，起始字符不能为下划线
            项目模型库：$符号前缀 + 项目代码
     */
    @Column(name = "MW_CODE")
    private String mwCode;

    /**
     * 模型库名
     */
    @Column(name = "MW_NAME")
    private String mwName;

    /**
     * 数据库类型
            0：公共模型库（长期建议不支持）
            1：项目模型库，随项目创建同时生成，存放项目中产生的模型
     */
    @Column(name = "MW_TYPE")
    private Integer mwType;

    /**
     * 所属项目ID，模型库类型为公共模型库时设为-1
     */
    @Column(name = "OWNER_PROJECT_ID")
    private Long ownerProjectId;

    /**
     * DFS模型目录，存放普通模型的模型文件和模型概要文件
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/mw_model/<mw_code>
     */
    @Column(name = "MODEL_DFS_DIR")
    private String modelDfsDir;

    /**
     * 本地模型目录，缓存普通模型的模型概要文件
            
            ${LOCAL_WORK_ROOT}/mw_model/<mw_code>
     */
    @Column(name = "MODEL_LOCAL_DIR")
    private String modelLocalDir;

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
     * @return MW_ID - 数据库ID
     */
    public Long getMwId() {
        return mwId;
    }

    /**
     * 设置数据库ID
     *
     * @param mwId 数据库ID
     */
    public void setMwId(Long mwId) {
        this.mwId = mwId;
    }

    /**
     * 获取模型库代码
            
            公共模型库：由英文字符、数字和下划线组成，起始字符不能为下划线
            项目模型库：$符号前缀 + 项目代码
     *
     * @return MW_CODE - 模型库代码
            
            公共模型库：由英文字符、数字和下划线组成，起始字符不能为下划线
            项目模型库：$符号前缀 + 项目代码
     */
    public String getMwCode() {
        return mwCode;
    }

    /**
     * 设置模型库代码
            
            公共模型库：由英文字符、数字和下划线组成，起始字符不能为下划线
            项目模型库：$符号前缀 + 项目代码
     *
     * @param mwCode 模型库代码
            
            公共模型库：由英文字符、数字和下划线组成，起始字符不能为下划线
            项目模型库：$符号前缀 + 项目代码
     */
    public void setMwCode(String mwCode) {
        this.mwCode = mwCode == null ? null : mwCode.trim();
    }

    /**
     * 获取模型库名
     *
     * @return MW_NAME - 模型库名
     */
    public String getMwName() {
        return mwName;
    }

    /**
     * 设置模型库名
     *
     * @param mwName 模型库名
     */
    public void setMwName(String mwName) {
        this.mwName = mwName == null ? null : mwName.trim();
    }

    /**
     * 获取数据库类型
            0：公共模型库（长期建议不支持）
            1：项目模型库，随项目创建同时生成，存放项目中产生的模型
     *
     * @return MW_TYPE - 数据库类型
            0：公共模型库（长期建议不支持）
            1：项目模型库，随项目创建同时生成，存放项目中产生的模型
     */
    public Integer getMwType() {
        return mwType;
    }

    /**
     * 设置数据库类型
            0：公共模型库（长期建议不支持）
            1：项目模型库，随项目创建同时生成，存放项目中产生的模型
     *
     * @param mwType 数据库类型
            0：公共模型库（长期建议不支持）
            1：项目模型库，随项目创建同时生成，存放项目中产生的模型
     */
    public void setMwType(Integer mwType) {
        this.mwType = mwType;
    }

    /**
     * 获取所属项目ID，模型库类型为公共模型库时设为-1
     *
     * @return OWNER_PROJECT_ID - 所属项目ID，模型库类型为公共模型库时设为-1
     */
    public Long getOwnerProjectId() {
        return ownerProjectId;
    }

    /**
     * 设置所属项目ID，模型库类型为公共模型库时设为-1
     *
     * @param ownerProjectId 所属项目ID，模型库类型为公共模型库时设为-1
     */
    public void setOwnerProjectId(Long ownerProjectId) {
        this.ownerProjectId = ownerProjectId;
    }

    /**
     * 获取DFS模型目录，存放普通模型的模型文件和模型概要文件
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/mw_model/<mw_code>
     *
     * @return MODEL_DFS_DIR - DFS模型目录，存放普通模型的模型文件和模型概要文件
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/mw_model/<mw_code>
     */
    public String getModelDfsDir() {
        return modelDfsDir;
    }

    /**
     * 设置DFS模型目录，存放普通模型的模型文件和模型概要文件
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/mw_model/<mw_code>
     *
     * @param modelDfsDir DFS模型目录，存放普通模型的模型文件和模型概要文件
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/mw_model/<mw_code>
     */
    public void setModelDfsDir(String modelDfsDir) {
        this.modelDfsDir = modelDfsDir == null ? null : modelDfsDir.trim();
    }

    /**
     * 获取本地模型目录，缓存普通模型的模型概要文件
            
            ${LOCAL_WORK_ROOT}/mw_model/<mw_code>
     *
     * @return MODEL_LOCAL_DIR - 本地模型目录，缓存普通模型的模型概要文件
            
            ${LOCAL_WORK_ROOT}/mw_model/<mw_code>
     */
    public String getModelLocalDir() {
        return modelLocalDir;
    }

    /**
     * 设置本地模型目录，缓存普通模型的模型概要文件
            
            ${LOCAL_WORK_ROOT}/mw_model/<mw_code>
     *
     * @param modelLocalDir 本地模型目录，缓存普通模型的模型概要文件
            
            ${LOCAL_WORK_ROOT}/mw_model/<mw_code>
     */
    public void setModelLocalDir(String modelLocalDir) {
        this.modelLocalDir = modelLocalDir == null ? null : modelLocalDir.trim();
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
        MwModelWarehouse other = (MwModelWarehouse) that;
        return (this.getMwId() == null ? other.getMwId() == null : this.getMwId().equals(other.getMwId()))
            && (this.getMwCode() == null ? other.getMwCode() == null : this.getMwCode().equals(other.getMwCode()))
            && (this.getMwName() == null ? other.getMwName() == null : this.getMwName().equals(other.getMwName()))
            && (this.getMwType() == null ? other.getMwType() == null : this.getMwType().equals(other.getMwType()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getModelDfsDir() == null ? other.getModelDfsDir() == null : this.getModelDfsDir().equals(other.getModelDfsDir()))
            && (this.getModelLocalDir() == null ? other.getModelLocalDir() == null : this.getModelLocalDir().equals(other.getModelLocalDir()))
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
        result = prime * result + ((getMwId() == null) ? 0 : getMwId().hashCode());
        result = prime * result + ((getMwCode() == null) ? 0 : getMwCode().hashCode());
        result = prime * result + ((getMwName() == null) ? 0 : getMwName().hashCode());
        result = prime * result + ((getMwType() == null) ? 0 : getMwType().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getModelDfsDir() == null) ? 0 : getModelDfsDir().hashCode());
        result = prime * result + ((getModelLocalDir() == null) ? 0 : getModelLocalDir().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}