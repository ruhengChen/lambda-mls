package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_json_object")
public class WfJsonObject implements Serializable {
    /**
     * 对象ID
     */
    @Id
    @Column(name = "OBJECT_ID")
    private Long objectId;

    /**
     * 对象名称
            
            普通对象：object_<node_id>_<char_id>_<snapshot_version> 
            算法参数：algorithm_parameters_<node_id>_<char_id>_<job_id>
            模型评估报告：model_evaluation_report_<node_id>_<char_id>_<job_id>
            统计分析报告：statisticsl_analysis_report_<node_id>_<char_id>_<job_id>
            自动调参报告：tune_parameters_<node_id>_<char_id>_<job_id>
            生成规则报告：generate_rules_<node_id>_<char_id>_<job_id>
            输出端口schema：outport_schema_<node_id>_<char_id>
     */
    @Column(name = "OBJECT_NAME")
    private String objectName;

    /**
     * 对象类型
            0：JsonObject&JsonArray（组件参数，仅存放于OBJECT_DATA）
            1：算法参数（输出内容，仅存放于OBJECT_DATA）
            2：模型评估报告（输出内容，存放于文件系统）
            3：统计分析报告（输出内容，存放于文件系统）
            4：自动调参报告（输出内容，存放于文件系统）
            5：生成规则报告（输出内容，存放于文件系统）
            99：输出端口schema（端口信息，仅存放于OBJECT_DATA）
     */
    @Column(name = "OBJECTY_TYPE")
    private Integer objectyType;

    /**
     * 对象来源
            0：作业运行
            1：实验编辑
     */
    @Column(name = "OBJECT_SRC")
    private Integer objectSrc;

    /**
     * 所属项目ID
     */
    @Column(name = "OWNER_PROJECT_ID")
    private Long ownerProjectId;

    /**
     * 关联工作流ID，无关联工作流设为-1
     */
    @Column(name = "REL_FLOW_ID")
    private Long relFlowId;

    /**
     * 关联快照版本，取FLOW表的NEXT_SNAPSHOT_VERSION值，无关联则设为-1
     */
    @Column(name = "REL_SNAPSHOT_VERSION")
    private Long relSnapshotVersion;

    /**
     * 关联作业ID，无关联则设为-1
     */
    @Column(name = "REL_JOB_ID")
    private Long relJobId;

    /**
     * 关联节点ID，创建脚本的工作流节点，无关联则设为-1
     */
    @Column(name = "REL_NODE_ID")
    private Long relNodeId;

    /**
     * 关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1
     */
    @Column(name = "REL_CHAR_ID")
    private Long relCharId;

    /**
     * 存储位置
            
            0：OBJECT_DATA字段
            1：文件系统
     */
    @Column(name = "STORAGE_LOCATION")
    private Integer storageLocation;

    /**
     * 对象文件名
            
            算法参数：${JOB_DIR}/algorithm_parameters_<json_id>.json（预留）
            模型评估报告：${JOB_DIR}/model_evaluation_report_<json_id>.json
            统计分析报告：${JOB_DIR}/statistics_analysis_report_<json_id>.json
            自动调参报告：${JOB_DIR}/tune_parameters_report_<json_id>.json
            生成规则报告：${JOB_DIR}/generate_rules_report_<json_id>.json
            输出端口schema：${EXPERIMENT_DIR}/outport_schema_<json_id>.json（预留）
     */
    @Column(name = "OBJECT_FILE")
    private String objectFile;

    /**
     * JSON数据状态
            0：空对象
            1：非空对象
     */
    @Column(name = "OBJECT_STATE")
    private Integer objectState;

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
     * JSON数据
     */
    @Column(name = "OBJECT_DATA")
    private String objectData;

    private static final long serialVersionUID = 1L;

    /**
     * 获取对象ID
     *
     * @return OBJECT_ID - 对象ID
     */
    public Long getObjectId() {
        return objectId;
    }

    /**
     * 设置对象ID
     *
     * @param objectId 对象ID
     */
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    /**
     * 获取对象名称
            
            普通对象：object_<node_id>_<char_id>_<snapshot_version> 
            算法参数：algorithm_parameters_<node_id>_<char_id>_<job_id>
            模型评估报告：model_evaluation_report_<node_id>_<char_id>_<job_id>
            统计分析报告：statisticsl_analysis_report_<node_id>_<char_id>_<job_id>
            自动调参报告：tune_parameters_<node_id>_<char_id>_<job_id>
            生成规则报告：generate_rules_<node_id>_<char_id>_<job_id>
            输出端口schema：outport_schema_<node_id>_<char_id>
     *
     * @return OBJECT_NAME - 对象名称
            
            普通对象：object_<node_id>_<char_id>_<snapshot_version> 
            算法参数：algorithm_parameters_<node_id>_<char_id>_<job_id>
            模型评估报告：model_evaluation_report_<node_id>_<char_id>_<job_id>
            统计分析报告：statisticsl_analysis_report_<node_id>_<char_id>_<job_id>
            自动调参报告：tune_parameters_<node_id>_<char_id>_<job_id>
            生成规则报告：generate_rules_<node_id>_<char_id>_<job_id>
            输出端口schema：outport_schema_<node_id>_<char_id>
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * 设置对象名称
            
            普通对象：object_<node_id>_<char_id>_<snapshot_version> 
            算法参数：algorithm_parameters_<node_id>_<char_id>_<job_id>
            模型评估报告：model_evaluation_report_<node_id>_<char_id>_<job_id>
            统计分析报告：statisticsl_analysis_report_<node_id>_<char_id>_<job_id>
            自动调参报告：tune_parameters_<node_id>_<char_id>_<job_id>
            生成规则报告：generate_rules_<node_id>_<char_id>_<job_id>
            输出端口schema：outport_schema_<node_id>_<char_id>
     *
     * @param objectName 对象名称
            
            普通对象：object_<node_id>_<char_id>_<snapshot_version> 
            算法参数：algorithm_parameters_<node_id>_<char_id>_<job_id>
            模型评估报告：model_evaluation_report_<node_id>_<char_id>_<job_id>
            统计分析报告：statisticsl_analysis_report_<node_id>_<char_id>_<job_id>
            自动调参报告：tune_parameters_<node_id>_<char_id>_<job_id>
            生成规则报告：generate_rules_<node_id>_<char_id>_<job_id>
            输出端口schema：outport_schema_<node_id>_<char_id>
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName == null ? null : objectName.trim();
    }

    /**
     * 获取对象类型
            0：JsonObject&JsonArray（组件参数，仅存放于OBJECT_DATA）
            1：算法参数（输出内容，仅存放于OBJECT_DATA）
            2：模型评估报告（输出内容，存放于文件系统）
            3：统计分析报告（输出内容，存放于文件系统）
            4：自动调参报告（输出内容，存放于文件系统）
            5：生成规则报告（输出内容，存放于文件系统）
            99：输出端口schema（端口信息，仅存放于OBJECT_DATA）
     *
     * @return OBJECTY_TYPE - 对象类型
            0：JsonObject&JsonArray（组件参数，仅存放于OBJECT_DATA）
            1：算法参数（输出内容，仅存放于OBJECT_DATA）
            2：模型评估报告（输出内容，存放于文件系统）
            3：统计分析报告（输出内容，存放于文件系统）
            4：自动调参报告（输出内容，存放于文件系统）
            5：生成规则报告（输出内容，存放于文件系统）
            99：输出端口schema（端口信息，仅存放于OBJECT_DATA）
     */
    public Integer getObjectyType() {
        return objectyType;
    }

    /**
     * 设置对象类型
            0：JsonObject&JsonArray（组件参数，仅存放于OBJECT_DATA）
            1：算法参数（输出内容，仅存放于OBJECT_DATA）
            2：模型评估报告（输出内容，存放于文件系统）
            3：统计分析报告（输出内容，存放于文件系统）
            4：自动调参报告（输出内容，存放于文件系统）
            5：生成规则报告（输出内容，存放于文件系统）
            99：输出端口schema（端口信息，仅存放于OBJECT_DATA）
     *
     * @param objectyType 对象类型
            0：JsonObject&JsonArray（组件参数，仅存放于OBJECT_DATA）
            1：算法参数（输出内容，仅存放于OBJECT_DATA）
            2：模型评估报告（输出内容，存放于文件系统）
            3：统计分析报告（输出内容，存放于文件系统）
            4：自动调参报告（输出内容，存放于文件系统）
            5：生成规则报告（输出内容，存放于文件系统）
            99：输出端口schema（端口信息，仅存放于OBJECT_DATA）
     */
    public void setObjectyType(Integer objectyType) {
        this.objectyType = objectyType;
    }

    /**
     * 获取对象来源
            0：作业运行
            1：实验编辑
     *
     * @return OBJECT_SRC - 对象来源
            0：作业运行
            1：实验编辑
     */
    public Integer getObjectSrc() {
        return objectSrc;
    }

    /**
     * 设置对象来源
            0：作业运行
            1：实验编辑
     *
     * @param objectSrc 对象来源
            0：作业运行
            1：实验编辑
     */
    public void setObjectSrc(Integer objectSrc) {
        this.objectSrc = objectSrc;
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
     * 获取关联工作流ID，无关联工作流设为-1
     *
     * @return REL_FLOW_ID - 关联工作流ID，无关联工作流设为-1
     */
    public Long getRelFlowId() {
        return relFlowId;
    }

    /**
     * 设置关联工作流ID，无关联工作流设为-1
     *
     * @param relFlowId 关联工作流ID，无关联工作流设为-1
     */
    public void setRelFlowId(Long relFlowId) {
        this.relFlowId = relFlowId;
    }

    /**
     * 获取关联快照版本，取FLOW表的NEXT_SNAPSHOT_VERSION值，无关联则设为-1
     *
     * @return REL_SNAPSHOT_VERSION - 关联快照版本，取FLOW表的NEXT_SNAPSHOT_VERSION值，无关联则设为-1
     */
    public Long getRelSnapshotVersion() {
        return relSnapshotVersion;
    }

    /**
     * 设置关联快照版本，取FLOW表的NEXT_SNAPSHOT_VERSION值，无关联则设为-1
     *
     * @param relSnapshotVersion 关联快照版本，取FLOW表的NEXT_SNAPSHOT_VERSION值，无关联则设为-1
     */
    public void setRelSnapshotVersion(Long relSnapshotVersion) {
        this.relSnapshotVersion = relSnapshotVersion;
    }

    /**
     * 获取关联作业ID，无关联则设为-1
     *
     * @return REL_JOB_ID - 关联作业ID，无关联则设为-1
     */
    public Long getRelJobId() {
        return relJobId;
    }

    /**
     * 设置关联作业ID，无关联则设为-1
     *
     * @param relJobId 关联作业ID，无关联则设为-1
     */
    public void setRelJobId(Long relJobId) {
        this.relJobId = relJobId;
    }

    /**
     * 获取关联节点ID，创建脚本的工作流节点，无关联则设为-1
     *
     * @return REL_NODE_ID - 关联节点ID，创建脚本的工作流节点，无关联则设为-1
     */
    public Long getRelNodeId() {
        return relNodeId;
    }

    /**
     * 设置关联节点ID，创建脚本的工作流节点，无关联则设为-1
     *
     * @param relNodeId 关联节点ID，创建脚本的工作流节点，无关联则设为-1
     */
    public void setRelNodeId(Long relNodeId) {
        this.relNodeId = relNodeId;
    }

    /**
     * 获取关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1
     *
     * @return REL_CHAR_ID - 关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1
     */
    public Long getRelCharId() {
        return relCharId;
    }

    /**
     * 设置关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1
     *
     * @param relCharId 关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1
     */
    public void setRelCharId(Long relCharId) {
        this.relCharId = relCharId;
    }

    /**
     * 获取存储位置
            
            0：OBJECT_DATA字段
            1：文件系统
     *
     * @return STORAGE_LOCATION - 存储位置
            
            0：OBJECT_DATA字段
            1：文件系统
     */
    public Integer getStorageLocation() {
        return storageLocation;
    }

    /**
     * 设置存储位置
            
            0：OBJECT_DATA字段
            1：文件系统
     *
     * @param storageLocation 存储位置
            
            0：OBJECT_DATA字段
            1：文件系统
     */
    public void setStorageLocation(Integer storageLocation) {
        this.storageLocation = storageLocation;
    }

    /**
     * 获取对象文件名
            
            算法参数：${JOB_DIR}/algorithm_parameters_<json_id>.json（预留）
            模型评估报告：${JOB_DIR}/model_evaluation_report_<json_id>.json
            统计分析报告：${JOB_DIR}/statistics_analysis_report_<json_id>.json
            自动调参报告：${JOB_DIR}/tune_parameters_report_<json_id>.json
            生成规则报告：${JOB_DIR}/generate_rules_report_<json_id>.json
            输出端口schema：${EXPERIMENT_DIR}/outport_schema_<json_id>.json（预留）
     *
     * @return OBJECT_FILE - 对象文件名
            
            算法参数：${JOB_DIR}/algorithm_parameters_<json_id>.json（预留）
            模型评估报告：${JOB_DIR}/model_evaluation_report_<json_id>.json
            统计分析报告：${JOB_DIR}/statistics_analysis_report_<json_id>.json
            自动调参报告：${JOB_DIR}/tune_parameters_report_<json_id>.json
            生成规则报告：${JOB_DIR}/generate_rules_report_<json_id>.json
            输出端口schema：${EXPERIMENT_DIR}/outport_schema_<json_id>.json（预留）
     */
    public String getObjectFile() {
        return objectFile;
    }

    /**
     * 设置对象文件名
            
            算法参数：${JOB_DIR}/algorithm_parameters_<json_id>.json（预留）
            模型评估报告：${JOB_DIR}/model_evaluation_report_<json_id>.json
            统计分析报告：${JOB_DIR}/statistics_analysis_report_<json_id>.json
            自动调参报告：${JOB_DIR}/tune_parameters_report_<json_id>.json
            生成规则报告：${JOB_DIR}/generate_rules_report_<json_id>.json
            输出端口schema：${EXPERIMENT_DIR}/outport_schema_<json_id>.json（预留）
     *
     * @param objectFile 对象文件名
            
            算法参数：${JOB_DIR}/algorithm_parameters_<json_id>.json（预留）
            模型评估报告：${JOB_DIR}/model_evaluation_report_<json_id>.json
            统计分析报告：${JOB_DIR}/statistics_analysis_report_<json_id>.json
            自动调参报告：${JOB_DIR}/tune_parameters_report_<json_id>.json
            生成规则报告：${JOB_DIR}/generate_rules_report_<json_id>.json
            输出端口schema：${EXPERIMENT_DIR}/outport_schema_<json_id>.json（预留）
     */
    public void setObjectFile(String objectFile) {
        this.objectFile = objectFile == null ? null : objectFile.trim();
    }

    /**
     * 获取JSON数据状态
            0：空对象
            1：非空对象
     *
     * @return OBJECT_STATE - JSON数据状态
            0：空对象
            1：非空对象
     */
    public Integer getObjectState() {
        return objectState;
    }

    /**
     * 设置JSON数据状态
            0：空对象
            1：非空对象
     *
     * @param objectState JSON数据状态
            0：空对象
            1：非空对象
     */
    public void setObjectState(Integer objectState) {
        this.objectState = objectState;
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

    /**
     * 获取JSON数据
     *
     * @return OBJECT_DATA - JSON数据
     */
    public String getObjectData() {
        return objectData;
    }

    /**
     * 设置JSON数据
     *
     * @param objectData JSON数据
     */
    public void setObjectData(String objectData) {
        this.objectData = objectData == null ? null : objectData.trim();
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
        WfJsonObject other = (WfJsonObject) that;
        return (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getObjectName() == null ? other.getObjectName() == null : this.getObjectName().equals(other.getObjectName()))
            && (this.getObjectyType() == null ? other.getObjectyType() == null : this.getObjectyType().equals(other.getObjectyType()))
            && (this.getObjectSrc() == null ? other.getObjectSrc() == null : this.getObjectSrc().equals(other.getObjectSrc()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getRelFlowId() == null ? other.getRelFlowId() == null : this.getRelFlowId().equals(other.getRelFlowId()))
            && (this.getRelSnapshotVersion() == null ? other.getRelSnapshotVersion() == null : this.getRelSnapshotVersion().equals(other.getRelSnapshotVersion()))
            && (this.getRelJobId() == null ? other.getRelJobId() == null : this.getRelJobId().equals(other.getRelJobId()))
            && (this.getRelNodeId() == null ? other.getRelNodeId() == null : this.getRelNodeId().equals(other.getRelNodeId()))
            && (this.getRelCharId() == null ? other.getRelCharId() == null : this.getRelCharId().equals(other.getRelCharId()))
            && (this.getStorageLocation() == null ? other.getStorageLocation() == null : this.getStorageLocation().equals(other.getStorageLocation()))
            && (this.getObjectFile() == null ? other.getObjectFile() == null : this.getObjectFile().equals(other.getObjectFile()))
            && (this.getObjectState() == null ? other.getObjectState() == null : this.getObjectState().equals(other.getObjectState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()))
            && (this.getObjectData() == null ? other.getObjectData() == null : this.getObjectData().equals(other.getObjectData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getObjectName() == null) ? 0 : getObjectName().hashCode());
        result = prime * result + ((getObjectyType() == null) ? 0 : getObjectyType().hashCode());
        result = prime * result + ((getObjectSrc() == null) ? 0 : getObjectSrc().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getRelFlowId() == null) ? 0 : getRelFlowId().hashCode());
        result = prime * result + ((getRelSnapshotVersion() == null) ? 0 : getRelSnapshotVersion().hashCode());
        result = prime * result + ((getRelJobId() == null) ? 0 : getRelJobId().hashCode());
        result = prime * result + ((getRelNodeId() == null) ? 0 : getRelNodeId().hashCode());
        result = prime * result + ((getRelCharId() == null) ? 0 : getRelCharId().hashCode());
        result = prime * result + ((getStorageLocation() == null) ? 0 : getStorageLocation().hashCode());
        result = prime * result + ((getObjectFile() == null) ? 0 : getObjectFile().hashCode());
        result = prime * result + ((getObjectState() == null) ? 0 : getObjectState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        result = prime * result + ((getObjectData() == null) ? 0 : getObjectData().hashCode());
        return result;
    }
}