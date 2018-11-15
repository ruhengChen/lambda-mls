package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cf_cmpt_algorithm")
public class CfCmptAlgorithm implements Serializable {
    /**
     * 算法ID
     */
    @Id
    @Column(name = "ALGORITHM_ID")
    private Long algorithmId;

    /**
     * 算法代码
     */
    @Column(name = "ALGORITHM_CODE")
    private String algorithmCode;

    /**
     * 算法名称
     */
    @Column(name = "ALGORITHM_NAME")
    private String algorithmName;

    /**
     * 算法类型
            1：One-Classification，单分类算法
            2：Binary-Classification，二分类算法
            3：Multiple-Classification，多分类算法
            4：Clustering，聚类算法
            5：Regression，回归算法
            
            //更多算法类型在后续组件开发中确定
     */
    @Column(name = "ALGORITHM_TYPE")
    private Integer algorithmType;

    /**
     * 算法标签列表（预留），标签之间用‘|’符号分隔
     */
    @Column(name = "ALGORITHM_LABELS")
    private String algorithmLabels;

    /**
     * 算法学习方式（预留）
            0：Supervised Learning，有监督学习
            1：Unsupervised Learning，无监督学习
            2：Semi-Supervised Learning，半监督学习
     */
    @Column(name = "LEARNING_MODE")
    private Integer learningMode;

    /**
     * 算法最优化方式（预留）
            0：Full-batch Learning，全批量学习
            1：Mini-batch Learning，小批量学习
            2：Online Learning，在线学习
     */
    @Column(name = "OPTIMIZE_MODE")
    private Integer optimizeMode;

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
     * 获取算法ID
     *
     * @return ALGORITHM_ID - 算法ID
     */
    public Long getAlgorithmId() {
        return algorithmId;
    }

    /**
     * 设置算法ID
     *
     * @param algorithmId 算法ID
     */
    public void setAlgorithmId(Long algorithmId) {
        this.algorithmId = algorithmId;
    }

    /**
     * 获取算法代码
     *
     * @return ALGORITHM_CODE - 算法代码
     */
    public String getAlgorithmCode() {
        return algorithmCode;
    }

    /**
     * 设置算法代码
     *
     * @param algorithmCode 算法代码
     */
    public void setAlgorithmCode(String algorithmCode) {
        this.algorithmCode = algorithmCode == null ? null : algorithmCode.trim();
    }

    /**
     * 获取算法名称
     *
     * @return ALGORITHM_NAME - 算法名称
     */
    public String getAlgorithmName() {
        return algorithmName;
    }

    /**
     * 设置算法名称
     *
     * @param algorithmName 算法名称
     */
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName == null ? null : algorithmName.trim();
    }

    /**
     * 获取算法类型
            1：One-Classification，单分类算法
            2：Binary-Classification，二分类算法
            3：Multiple-Classification，多分类算法
            4：Clustering，聚类算法
            5：Regression，回归算法
            
            //更多算法类型在后续组件开发中确定
     *
     * @return ALGORITHM_TYPE - 算法类型
            1：One-Classification，单分类算法
            2：Binary-Classification，二分类算法
            3：Multiple-Classification，多分类算法
            4：Clustering，聚类算法
            5：Regression，回归算法
            
            //更多算法类型在后续组件开发中确定
     */
    public Integer getAlgorithmType() {
        return algorithmType;
    }

    /**
     * 设置算法类型
            1：One-Classification，单分类算法
            2：Binary-Classification，二分类算法
            3：Multiple-Classification，多分类算法
            4：Clustering，聚类算法
            5：Regression，回归算法
            
            //更多算法类型在后续组件开发中确定
     *
     * @param algorithmType 算法类型
            1：One-Classification，单分类算法
            2：Binary-Classification，二分类算法
            3：Multiple-Classification，多分类算法
            4：Clustering，聚类算法
            5：Regression，回归算法
            
            //更多算法类型在后续组件开发中确定
     */
    public void setAlgorithmType(Integer algorithmType) {
        this.algorithmType = algorithmType;
    }

    /**
     * 获取算法标签列表（预留），标签之间用‘|’符号分隔
     *
     * @return ALGORITHM_LABELS - 算法标签列表（预留），标签之间用‘|’符号分隔
     */
    public String getAlgorithmLabels() {
        return algorithmLabels;
    }

    /**
     * 设置算法标签列表（预留），标签之间用‘|’符号分隔
     *
     * @param algorithmLabels 算法标签列表（预留），标签之间用‘|’符号分隔
     */
    public void setAlgorithmLabels(String algorithmLabels) {
        this.algorithmLabels = algorithmLabels == null ? null : algorithmLabels.trim();
    }

    /**
     * 获取算法学习方式（预留）
            0：Supervised Learning，有监督学习
            1：Unsupervised Learning，无监督学习
            2：Semi-Supervised Learning，半监督学习
     *
     * @return LEARNING_MODE - 算法学习方式（预留）
            0：Supervised Learning，有监督学习
            1：Unsupervised Learning，无监督学习
            2：Semi-Supervised Learning，半监督学习
     */
    public Integer getLearningMode() {
        return learningMode;
    }

    /**
     * 设置算法学习方式（预留）
            0：Supervised Learning，有监督学习
            1：Unsupervised Learning，无监督学习
            2：Semi-Supervised Learning，半监督学习
     *
     * @param learningMode 算法学习方式（预留）
            0：Supervised Learning，有监督学习
            1：Unsupervised Learning，无监督学习
            2：Semi-Supervised Learning，半监督学习
     */
    public void setLearningMode(Integer learningMode) {
        this.learningMode = learningMode;
    }

    /**
     * 获取算法最优化方式（预留）
            0：Full-batch Learning，全批量学习
            1：Mini-batch Learning，小批量学习
            2：Online Learning，在线学习
     *
     * @return OPTIMIZE_MODE - 算法最优化方式（预留）
            0：Full-batch Learning，全批量学习
            1：Mini-batch Learning，小批量学习
            2：Online Learning，在线学习
     */
    public Integer getOptimizeMode() {
        return optimizeMode;
    }

    /**
     * 设置算法最优化方式（预留）
            0：Full-batch Learning，全批量学习
            1：Mini-batch Learning，小批量学习
            2：Online Learning，在线学习
     *
     * @param optimizeMode 算法最优化方式（预留）
            0：Full-batch Learning，全批量学习
            1：Mini-batch Learning，小批量学习
            2：Online Learning，在线学习
     */
    public void setOptimizeMode(Integer optimizeMode) {
        this.optimizeMode = optimizeMode;
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
        CfCmptAlgorithm other = (CfCmptAlgorithm) that;
        return (this.getAlgorithmId() == null ? other.getAlgorithmId() == null : this.getAlgorithmId().equals(other.getAlgorithmId()))
            && (this.getAlgorithmCode() == null ? other.getAlgorithmCode() == null : this.getAlgorithmCode().equals(other.getAlgorithmCode()))
            && (this.getAlgorithmName() == null ? other.getAlgorithmName() == null : this.getAlgorithmName().equals(other.getAlgorithmName()))
            && (this.getAlgorithmType() == null ? other.getAlgorithmType() == null : this.getAlgorithmType().equals(other.getAlgorithmType()))
            && (this.getAlgorithmLabels() == null ? other.getAlgorithmLabels() == null : this.getAlgorithmLabels().equals(other.getAlgorithmLabels()))
            && (this.getLearningMode() == null ? other.getLearningMode() == null : this.getLearningMode().equals(other.getLearningMode()))
            && (this.getOptimizeMode() == null ? other.getOptimizeMode() == null : this.getOptimizeMode().equals(other.getOptimizeMode()))
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
        result = prime * result + ((getAlgorithmId() == null) ? 0 : getAlgorithmId().hashCode());
        result = prime * result + ((getAlgorithmCode() == null) ? 0 : getAlgorithmCode().hashCode());
        result = prime * result + ((getAlgorithmName() == null) ? 0 : getAlgorithmName().hashCode());
        result = prime * result + ((getAlgorithmType() == null) ? 0 : getAlgorithmType().hashCode());
        result = prime * result + ((getAlgorithmLabels() == null) ? 0 : getAlgorithmLabels().hashCode());
        result = prime * result + ((getLearningMode() == null) ? 0 : getLearningMode().hashCode());
        result = prime * result + ((getOptimizeMode() == null) ? 0 : getOptimizeMode().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}