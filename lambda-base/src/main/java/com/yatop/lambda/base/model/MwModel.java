package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mw_model")
public class MwModel implements Serializable {
    /**
     * 模型ID
     */
    @Id
    @Column(name = "MODEL_ID")
    private Long modelId;

    /**
     * 模型名称
            
            普通和动态模型：由字符和数字组成，无特殊字符
            临时模型：组件名称 - 同组件节点序号 - Model [ - 评估指标 - 排名序号] - 作业ID
     */
    @Column(name = "MODEL_NAME")
    private String modelName;

    /**
     * 模型类型
            0：普通模型
            1：临时模型
            
             禁止做需要动态模型的组件设计和功能设计
     */
    @Column(name = "MODEL_TYPE")
    private Integer modelType;

    /**
     * 模型来源
            0：内部生成
            1：外部导入
     */
    @Column(name = "MODEL_SRC")
    private Integer modelSrc;

    /**
     * 所属模型库ID
     */
    @Column(name = "OWNER_MW_ID")
    private Long ownerMwId;

    /**
     * 关联实验ID，无关联实验设为-1
     */
    @Column(name = "REL_EXPERIMENT_ID")
    private Long relExperimentId;

    /**
     * 关联作业ID，无关联则设为-1
     */
    @Column(name = "REL_JOB_ID")
    private Long relJobId;

    /**
     * 关联节点ID，创建模型的工作流节点，无关联则设为-1
     */
    @Column(name = "REL_NODE_ID")
    private Long relNodeId;

    /**
     * 关联特征ID，创建模型的工作流节点输出特征，无关联则设为-1
     */
    @Column(name = "REL_CHAR_ID")
    private Long relCharId;

    /**
     * 引用算法ID
     */
    @Column(name = "REF_ALGORITHM_ID")
    private Long refAlgorithmId;

    /**
     * 模型文件大小，单位为字节
     */
    @Column(name = "MODEL_FILE_SIZE")
    private Long modelFileSize;

    /**
     * 模型文件名，普通模型存放于模型目录下，临时模型存放于作业目录下
            
            普通模型和动态：${MODEL_DIR}/model_<model_id>.mdl
            临时模型：${JOB_DIR}/model_<task_id>_<model_id>.mdl
     */
    @Column(name = "MODEL_FILE")
    private String modelFile;

    /**
     * 模型概要文件名，普通模型存放于模型目录下，临时模型存放于作业目录下，记录训练算法参数，训练收敛过程（e.g. LogLoss，AUC），以及其他模型训练相关可以收集到的所有信息
            
            普通和动态模型：${MODEL_DIR}/model_summary_<model_id>.json
            临时模型：${JOB_DIR}/model_summary_<task_id>_<model_id>.json
     */
    @Column(name = "MODEL_SUMMARY_FILE")
    private String modelSummaryFile;

    /**
     * 模型状态
            0：空模型
            1：正常
     */
    @Column(name = "MODEL_STATE")
    private Integer modelState;

    /**
     * 训练集数据表ID（关联训练集是否需要另外拷贝一份全量数据，待定）
     */
    @Column(name = "TRAIN_TABLE_ID")
    private Long trainTableId;

    /**
     * 训练运行时间，单位毫秒
     */
    @Column(name = "TRAIN_COST_TIME")
    private Long trainCostTime;

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
     * 获取模型ID
     *
     * @return MODEL_ID - 模型ID
     */
    public Long getModelId() {
        return modelId;
    }

    /**
     * 设置模型ID
     *
     * @param modelId 模型ID
     */
    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    /**
     * 获取模型名称
            
            普通和动态模型：由字符和数字组成，无特殊字符
            临时模型：组件名称 - 同组件节点序号 - Model [ - 评估指标 - 排名序号] - 作业ID
     *
     * @return MODEL_NAME - 模型名称
            
            普通和动态模型：由字符和数字组成，无特殊字符
            临时模型：组件名称 - 同组件节点序号 - Model [ - 评估指标 - 排名序号] - 作业ID
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 设置模型名称
            
            普通和动态模型：由字符和数字组成，无特殊字符
            临时模型：组件名称 - 同组件节点序号 - Model [ - 评估指标 - 排名序号] - 作业ID
     *
     * @param modelName 模型名称
            
            普通和动态模型：由字符和数字组成，无特殊字符
            临时模型：组件名称 - 同组件节点序号 - Model [ - 评估指标 - 排名序号] - 作业ID
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    /**
     * 获取模型类型
            0：普通模型
            1：临时模型
            
             禁止做需要动态模型的组件设计和功能设计
     *
     * @return MODEL_TYPE - 模型类型
            0：普通模型
            1：临时模型
            
             禁止做需要动态模型的组件设计和功能设计
     */
    public Integer getModelType() {
        return modelType;
    }

    /**
     * 设置模型类型
            0：普通模型
            1：临时模型
            
             禁止做需要动态模型的组件设计和功能设计
     *
     * @param modelType 模型类型
            0：普通模型
            1：临时模型
            
             禁止做需要动态模型的组件设计和功能设计
     */
    public void setModelType(Integer modelType) {
        this.modelType = modelType;
    }

    /**
     * 获取模型来源
            0：内部生成
            1：外部导入
     *
     * @return MODEL_SRC - 模型来源
            0：内部生成
            1：外部导入
     */
    public Integer getModelSrc() {
        return modelSrc;
    }

    /**
     * 设置模型来源
            0：内部生成
            1：外部导入
     *
     * @param modelSrc 模型来源
            0：内部生成
            1：外部导入
     */
    public void setModelSrc(Integer modelSrc) {
        this.modelSrc = modelSrc;
    }

    /**
     * 获取所属模型库ID
     *
     * @return OWNER_MW_ID - 所属模型库ID
     */
    public Long getOwnerMwId() {
        return ownerMwId;
    }

    /**
     * 设置所属模型库ID
     *
     * @param ownerMwId 所属模型库ID
     */
    public void setOwnerMwId(Long ownerMwId) {
        this.ownerMwId = ownerMwId;
    }

    /**
     * 获取关联实验ID，无关联实验设为-1
     *
     * @return REL_EXPERIMENT_ID - 关联实验ID，无关联实验设为-1
     */
    public Long getRelExperimentId() {
        return relExperimentId;
    }

    /**
     * 设置关联实验ID，无关联实验设为-1
     *
     * @param relExperimentId 关联实验ID，无关联实验设为-1
     */
    public void setRelExperimentId(Long relExperimentId) {
        this.relExperimentId = relExperimentId;
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
     * 获取关联节点ID，创建模型的工作流节点，无关联则设为-1
     *
     * @return REL_NODE_ID - 关联节点ID，创建模型的工作流节点，无关联则设为-1
     */
    public Long getRelNodeId() {
        return relNodeId;
    }

    /**
     * 设置关联节点ID，创建模型的工作流节点，无关联则设为-1
     *
     * @param relNodeId 关联节点ID，创建模型的工作流节点，无关联则设为-1
     */
    public void setRelNodeId(Long relNodeId) {
        this.relNodeId = relNodeId;
    }

    /**
     * 获取关联特征ID，创建模型的工作流节点输出特征，无关联则设为-1
     *
     * @return REL_CHAR_ID - 关联特征ID，创建模型的工作流节点输出特征，无关联则设为-1
     */
    public Long getRelCharId() {
        return relCharId;
    }

    /**
     * 设置关联特征ID，创建模型的工作流节点输出特征，无关联则设为-1
     *
     * @param relCharId 关联特征ID，创建模型的工作流节点输出特征，无关联则设为-1
     */
    public void setRelCharId(Long relCharId) {
        this.relCharId = relCharId;
    }

    /**
     * 获取引用算法ID
     *
     * @return REF_ALGORITHM_ID - 引用算法ID
     */
    public Long getRefAlgorithmId() {
        return refAlgorithmId;
    }

    /**
     * 设置引用算法ID
     *
     * @param refAlgorithmId 引用算法ID
     */
    public void setRefAlgorithmId(Long refAlgorithmId) {
        this.refAlgorithmId = refAlgorithmId;
    }

    /**
     * 获取模型文件大小，单位为字节
     *
     * @return MODEL_FILE_SIZE - 模型文件大小，单位为字节
     */
    public Long getModelFileSize() {
        return modelFileSize;
    }

    /**
     * 设置模型文件大小，单位为字节
     *
     * @param modelFileSize 模型文件大小，单位为字节
     */
    public void setModelFileSize(Long modelFileSize) {
        this.modelFileSize = modelFileSize;
    }

    /**
     * 获取模型文件名，普通模型存放于模型目录下，临时模型存放于作业目录下
            
            普通模型和动态：${MODEL_DIR}/model_<model_id>.mdl
            临时模型：${JOB_DIR}/model_<task_id>_<model_id>.mdl
     *
     * @return MODEL_FILE - 模型文件名，普通模型存放于模型目录下，临时模型存放于作业目录下
            
            普通模型和动态：${MODEL_DIR}/model_<model_id>.mdl
            临时模型：${JOB_DIR}/model_<task_id>_<model_id>.mdl
     */
    public String getModelFile() {
        return modelFile;
    }

    /**
     * 设置模型文件名，普通模型存放于模型目录下，临时模型存放于作业目录下
            
            普通模型和动态：${MODEL_DIR}/model_<model_id>.mdl
            临时模型：${JOB_DIR}/model_<task_id>_<model_id>.mdl
     *
     * @param modelFile 模型文件名，普通模型存放于模型目录下，临时模型存放于作业目录下
            
            普通模型和动态：${MODEL_DIR}/model_<model_id>.mdl
            临时模型：${JOB_DIR}/model_<task_id>_<model_id>.mdl
     */
    public void setModelFile(String modelFile) {
        this.modelFile = modelFile == null ? null : modelFile.trim();
    }

    /**
     * 获取模型概要文件名，普通模型存放于模型目录下，临时模型存放于作业目录下，记录训练算法参数，训练收敛过程（e.g. LogLoss，AUC），以及其他模型训练相关可以收集到的所有信息
            
            普通和动态模型：${MODEL_DIR}/model_summary_<model_id>.json
            临时模型：${JOB_DIR}/model_summary_<task_id>_<model_id>.json
     *
     * @return MODEL_SUMMARY_FILE - 模型概要文件名，普通模型存放于模型目录下，临时模型存放于作业目录下，记录训练算法参数，训练收敛过程（e.g. LogLoss，AUC），以及其他模型训练相关可以收集到的所有信息
            
            普通和动态模型：${MODEL_DIR}/model_summary_<model_id>.json
            临时模型：${JOB_DIR}/model_summary_<task_id>_<model_id>.json
     */
    public String getModelSummaryFile() {
        return modelSummaryFile;
    }

    /**
     * 设置模型概要文件名，普通模型存放于模型目录下，临时模型存放于作业目录下，记录训练算法参数，训练收敛过程（e.g. LogLoss，AUC），以及其他模型训练相关可以收集到的所有信息
            
            普通和动态模型：${MODEL_DIR}/model_summary_<model_id>.json
            临时模型：${JOB_DIR}/model_summary_<task_id>_<model_id>.json
     *
     * @param modelSummaryFile 模型概要文件名，普通模型存放于模型目录下，临时模型存放于作业目录下，记录训练算法参数，训练收敛过程（e.g. LogLoss，AUC），以及其他模型训练相关可以收集到的所有信息
            
            普通和动态模型：${MODEL_DIR}/model_summary_<model_id>.json
            临时模型：${JOB_DIR}/model_summary_<task_id>_<model_id>.json
     */
    public void setModelSummaryFile(String modelSummaryFile) {
        this.modelSummaryFile = modelSummaryFile == null ? null : modelSummaryFile.trim();
    }

    /**
     * 获取模型状态
            0：空模型
            1：正常
     *
     * @return MODEL_STATE - 模型状态
            0：空模型
            1：正常
     */
    public Integer getModelState() {
        return modelState;
    }

    /**
     * 设置模型状态
            0：空模型
            1：正常
     *
     * @param modelState 模型状态
            0：空模型
            1：正常
     */
    public void setModelState(Integer modelState) {
        this.modelState = modelState;
    }

    /**
     * 获取训练集数据表ID（关联训练集是否需要另外拷贝一份全量数据，待定）
     *
     * @return TRAIN_TABLE_ID - 训练集数据表ID（关联训练集是否需要另外拷贝一份全量数据，待定）
     */
    public Long getTrainTableId() {
        return trainTableId;
    }

    /**
     * 设置训练集数据表ID（关联训练集是否需要另外拷贝一份全量数据，待定）
     *
     * @param trainTableId 训练集数据表ID（关联训练集是否需要另外拷贝一份全量数据，待定）
     */
    public void setTrainTableId(Long trainTableId) {
        this.trainTableId = trainTableId;
    }

    /**
     * 获取训练运行时间，单位毫秒
     *
     * @return TRAIN_COST_TIME - 训练运行时间，单位毫秒
     */
    public Long getTrainCostTime() {
        return trainCostTime;
    }

    /**
     * 设置训练运行时间，单位毫秒
     *
     * @param trainCostTime 训练运行时间，单位毫秒
     */
    public void setTrainCostTime(Long trainCostTime) {
        this.trainCostTime = trainCostTime;
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
        MwModel other = (MwModel) that;
        return (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getModelType() == null ? other.getModelType() == null : this.getModelType().equals(other.getModelType()))
            && (this.getModelSrc() == null ? other.getModelSrc() == null : this.getModelSrc().equals(other.getModelSrc()))
            && (this.getOwnerMwId() == null ? other.getOwnerMwId() == null : this.getOwnerMwId().equals(other.getOwnerMwId()))
            && (this.getRelExperimentId() == null ? other.getRelExperimentId() == null : this.getRelExperimentId().equals(other.getRelExperimentId()))
            && (this.getRelJobId() == null ? other.getRelJobId() == null : this.getRelJobId().equals(other.getRelJobId()))
            && (this.getRelNodeId() == null ? other.getRelNodeId() == null : this.getRelNodeId().equals(other.getRelNodeId()))
            && (this.getRelCharId() == null ? other.getRelCharId() == null : this.getRelCharId().equals(other.getRelCharId()))
            && (this.getRefAlgorithmId() == null ? other.getRefAlgorithmId() == null : this.getRefAlgorithmId().equals(other.getRefAlgorithmId()))
            && (this.getModelFileSize() == null ? other.getModelFileSize() == null : this.getModelFileSize().equals(other.getModelFileSize()))
            && (this.getModelFile() == null ? other.getModelFile() == null : this.getModelFile().equals(other.getModelFile()))
            && (this.getModelSummaryFile() == null ? other.getModelSummaryFile() == null : this.getModelSummaryFile().equals(other.getModelSummaryFile()))
            && (this.getModelState() == null ? other.getModelState() == null : this.getModelState().equals(other.getModelState()))
            && (this.getTrainTableId() == null ? other.getTrainTableId() == null : this.getTrainTableId().equals(other.getTrainTableId()))
            && (this.getTrainCostTime() == null ? other.getTrainCostTime() == null : this.getTrainCostTime().equals(other.getTrainCostTime()))
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
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getModelType() == null) ? 0 : getModelType().hashCode());
        result = prime * result + ((getModelSrc() == null) ? 0 : getModelSrc().hashCode());
        result = prime * result + ((getOwnerMwId() == null) ? 0 : getOwnerMwId().hashCode());
        result = prime * result + ((getRelExperimentId() == null) ? 0 : getRelExperimentId().hashCode());
        result = prime * result + ((getRelJobId() == null) ? 0 : getRelJobId().hashCode());
        result = prime * result + ((getRelNodeId() == null) ? 0 : getRelNodeId().hashCode());
        result = prime * result + ((getRelCharId() == null) ? 0 : getRelCharId().hashCode());
        result = prime * result + ((getRefAlgorithmId() == null) ? 0 : getRefAlgorithmId().hashCode());
        result = prime * result + ((getModelFileSize() == null) ? 0 : getModelFileSize().hashCode());
        result = prime * result + ((getModelFile() == null) ? 0 : getModelFile().hashCode());
        result = prime * result + ((getModelSummaryFile() == null) ? 0 : getModelSummaryFile().hashCode());
        result = prime * result + ((getModelState() == null) ? 0 : getModelState().hashCode());
        result = prime * result + ((getTrainTableId() == null) ? 0 : getTrainTableId().hashCode());
        result = prime * result + ((getTrainCostTime() == null) ? 0 : getTrainCostTime().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}