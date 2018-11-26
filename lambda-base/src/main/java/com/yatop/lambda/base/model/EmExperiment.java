package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "em_experiment")
public class EmExperiment implements Serializable {
    /**
     * 实验ID
     */
    @Id
    @Column(name = "EXPERIMENT_ID")
    private Long experimentId;

    /**
     * 实验名称
     */
    @Column(name = "EXPERIMENT_NAME")
    private String experimentName;

    /**
     * 实验类型
            0：主实验，正常创建实验
            1：预测实验（预留），通过选择主实验中的已训练模型进行自动创建
     */
    @Column(name = "EXPERIMENT_TYPE")
    private Integer experimentType;

    /**
     * 所属主实验ID，主实验设为自身ID
     */
    @Column(name = "MAIN_EXPERIMENT_ID")
    private Long mainExperimentId;

    /**
     * 所属项目ID
     */
    @Column(name = "OWNER_PROJECT_ID")
    private Long ownerProjectId;

    /**
     * 流程图ID
     */
    @Column(name = "FLOW_ID")
    private Long flowId;

    /**
     * DFS实验目录
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/exp_data/<project_id>/<experiment_id>
     */
    @Column(name = "EXPERIMENT_DFS_DIR")
    private String experimentDfsDir;

    /**
     * 本地实验目录
            
            ${LOCAL_WORK_ROOT}/exp_data/<project_id>/<experiment_id>
     */
    @Column(name = "EXPERIMENT_LOCAL_DIR")
    private String experimentLocalDir;

    /**
     * 摘要，冗余WF_FLOW.SUMMARY信息
     */
    @Column(name = "SUMMARY")
    private String summary;

    /**
     * 描述，冗余WF_FLOW.DESCRIPTION信息
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
     * 获取实验ID
     *
     * @return EXPERIMENT_ID - 实验ID
     */
    public Long getExperimentId() {
        return experimentId;
    }

    /**
     * 设置实验ID
     *
     * @param experimentId 实验ID
     */
    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    /**
     * 获取实验名称
     *
     * @return EXPERIMENT_NAME - 实验名称
     */
    public String getExperimentName() {
        return experimentName;
    }

    /**
     * 设置实验名称
     *
     * @param experimentName 实验名称
     */
    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName == null ? null : experimentName.trim();
    }

    /**
     * 获取实验类型
            0：主实验，正常创建实验
            1：预测实验（预留），通过选择主实验中的已训练模型进行自动创建
     *
     * @return EXPERIMENT_TYPE - 实验类型
            0：主实验，正常创建实验
            1：预测实验（预留），通过选择主实验中的已训练模型进行自动创建
     */
    public Integer getExperimentType() {
        return experimentType;
    }

    /**
     * 设置实验类型
            0：主实验，正常创建实验
            1：预测实验（预留），通过选择主实验中的已训练模型进行自动创建
     *
     * @param experimentType 实验类型
            0：主实验，正常创建实验
            1：预测实验（预留），通过选择主实验中的已训练模型进行自动创建
     */
    public void setExperimentType(Integer experimentType) {
        this.experimentType = experimentType;
    }

    /**
     * 获取所属主实验ID，主实验设为自身ID
     *
     * @return MAIN_EXPERIMENT_ID - 所属主实验ID，主实验设为自身ID
     */
    public Long getMainExperimentId() {
        return mainExperimentId;
    }

    /**
     * 设置所属主实验ID，主实验设为自身ID
     *
     * @param mainExperimentId 所属主实验ID，主实验设为自身ID
     */
    public void setMainExperimentId(Long mainExperimentId) {
        this.mainExperimentId = mainExperimentId;
    }

    /**
     * 获取所属项目ID
     *
     * @return OWNER_PROJECT_ID - 所属项目ID
     */
    public Long getOwnerProjectId() {
        return ownerProjectId;
    }

    /**
     * 设置所属项目ID
     *
     * @param ownerProjectId 所属项目ID
     */
    public void setOwnerProjectId(Long ownerProjectId) {
        this.ownerProjectId = ownerProjectId;
    }

    /**
     * 获取流程图ID
     *
     * @return FLOW_ID - 流程图ID
     */
    public Long getFlowId() {
        return flowId;
    }

    /**
     * 设置流程图ID
     *
     * @param flowId 流程图ID
     */
    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    /**
     * 获取DFS实验目录
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/exp_data/<project_id>/<experiment_id>
     *
     * @return EXPERIMENT_DFS_DIR - DFS实验目录
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/exp_data/<project_id>/<experiment_id>
     */
    public String getExperimentDfsDir() {
        return experimentDfsDir;
    }

    /**
     * 设置DFS实验目录
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/exp_data/<project_id>/<experiment_id>
     *
     * @param experimentDfsDir DFS实验目录
            
            ${HDFS_SITE}/${DFS_WORK_ROOT}/exp_data/<project_id>/<experiment_id>
     */
    public void setExperimentDfsDir(String experimentDfsDir) {
        this.experimentDfsDir = experimentDfsDir == null ? null : experimentDfsDir.trim();
    }

    /**
     * 获取本地实验目录
            
            ${LOCAL_WORK_ROOT}/exp_data/<project_id>/<experiment_id>
     *
     * @return EXPERIMENT_LOCAL_DIR - 本地实验目录
            
            ${LOCAL_WORK_ROOT}/exp_data/<project_id>/<experiment_id>
     */
    public String getExperimentLocalDir() {
        return experimentLocalDir;
    }

    /**
     * 设置本地实验目录
            
            ${LOCAL_WORK_ROOT}/exp_data/<project_id>/<experiment_id>
     *
     * @param experimentLocalDir 本地实验目录
            
            ${LOCAL_WORK_ROOT}/exp_data/<project_id>/<experiment_id>
     */
    public void setExperimentLocalDir(String experimentLocalDir) {
        this.experimentLocalDir = experimentLocalDir == null ? null : experimentLocalDir.trim();
    }

    /**
     * 获取摘要，冗余WF_FLOW.SUMMARY信息
     *
     * @return SUMMARY - 摘要，冗余WF_FLOW.SUMMARY信息
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置摘要，冗余WF_FLOW.SUMMARY信息
     *
     * @param summary 摘要，冗余WF_FLOW.SUMMARY信息
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * 获取描述，冗余WF_FLOW.DESCRIPTION信息
     *
     * @return DESCRIPTION - 描述，冗余WF_FLOW.DESCRIPTION信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述，冗余WF_FLOW.DESCRIPTION信息
     *
     * @param description 描述，冗余WF_FLOW.DESCRIPTION信息
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
        EmExperiment other = (EmExperiment) that;
        return (this.getExperimentId() == null ? other.getExperimentId() == null : this.getExperimentId().equals(other.getExperimentId()))
            && (this.getExperimentName() == null ? other.getExperimentName() == null : this.getExperimentName().equals(other.getExperimentName()))
            && (this.getExperimentType() == null ? other.getExperimentType() == null : this.getExperimentType().equals(other.getExperimentType()))
            && (this.getMainExperimentId() == null ? other.getMainExperimentId() == null : this.getMainExperimentId().equals(other.getMainExperimentId()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getFlowId() == null ? other.getFlowId() == null : this.getFlowId().equals(other.getFlowId()))
            && (this.getExperimentDfsDir() == null ? other.getExperimentDfsDir() == null : this.getExperimentDfsDir().equals(other.getExperimentDfsDir()))
            && (this.getExperimentLocalDir() == null ? other.getExperimentLocalDir() == null : this.getExperimentLocalDir().equals(other.getExperimentLocalDir()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
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
        result = prime * result + ((getExperimentId() == null) ? 0 : getExperimentId().hashCode());
        result = prime * result + ((getExperimentName() == null) ? 0 : getExperimentName().hashCode());
        result = prime * result + ((getExperimentType() == null) ? 0 : getExperimentType().hashCode());
        result = prime * result + ((getMainExperimentId() == null) ? 0 : getMainExperimentId().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getFlowId() == null) ? 0 : getFlowId().hashCode());
        result = prime * result + ((getExperimentDfsDir() == null) ? 0 : getExperimentDfsDir().hashCode());
        result = prime * result + ((getExperimentLocalDir() == null) ? 0 : getExperimentLocalDir().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}