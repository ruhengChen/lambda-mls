package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cc_cmpt_algorithm")
public class CcCmptAlgorithm implements Serializable {
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
1：One Class Classfication(Anomaly Detection)，异常检测算法
2：Binary Class Classification，二分类算法
3：Multiple Class Classification，多分类算法
4：Clustering，聚类算法
5：Regression，回归算法
6：Association Rules，关联规则算法
7：Collaborative filtering，协同过滤算法

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
            1：Supervised Learning，有监督学习
            2：Unsupervised Learning，无监督学习
            3：Semi-Supervised Learning，半监督学习
     */
    @Column(name = "LEARNING_MODE")
    private Integer learningMode;

    /**
     * 算法最优化方法（预留）
0：unknown
1：批量梯度下降法
2：随机梯度下降法
3：mini-batch梯度下降法
4：牛顿法
5：拟牛顿法
6：共轭梯度法
7：启发式优化方法
8：拉格朗日乘数法
     */
    @Column(name = "OPTIMIZE_METHOD")
    private Integer optimizeMethod;

    /**
     * 是否可调参
            0：否
            1：是
     */
    @Column(name = "IS_TUNABLE")
    private Integer isTunable;

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
1：One Class Classfication(Anomaly Detection)，异常检测算法
2：Binary Class Classification，二分类算法
3：Multiple Class Classification，多分类算法
4：Clustering，聚类算法
5：Regression，回归算法
6：Association Rules，关联规则算法
7：Collaborative filtering，协同过滤算法

//更多算法类型在后续组件开发中确定
     *
     * @return ALGORITHM_TYPE - 算法类型
1：One Class Classfication(Anomaly Detection)，异常检测算法
2：Binary Class Classification，二分类算法
3：Multiple Class Classification，多分类算法
4：Clustering，聚类算法
5：Regression，回归算法
6：Association Rules，关联规则算法
7：Collaborative filtering，协同过滤算法

//更多算法类型在后续组件开发中确定
     */
    public Integer getAlgorithmType() {
        return algorithmType;
    }

    /**
     * 设置算法类型
1：One Class Classfication(Anomaly Detection)，异常检测算法
2：Binary Class Classification，二分类算法
3：Multiple Class Classification，多分类算法
4：Clustering，聚类算法
5：Regression，回归算法
6：Association Rules，关联规则算法
7：Collaborative filtering，协同过滤算法

//更多算法类型在后续组件开发中确定
     *
     * @param algorithmType 算法类型
1：One Class Classfication(Anomaly Detection)，异常检测算法
2：Binary Class Classification，二分类算法
3：Multiple Class Classification，多分类算法
4：Clustering，聚类算法
5：Regression，回归算法
6：Association Rules，关联规则算法
7：Collaborative filtering，协同过滤算法

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
            1：Supervised Learning，有监督学习
            2：Unsupervised Learning，无监督学习
            3：Semi-Supervised Learning，半监督学习
     *
     * @return LEARNING_MODE - 算法学习方式（预留）
            1：Supervised Learning，有监督学习
            2：Unsupervised Learning，无监督学习
            3：Semi-Supervised Learning，半监督学习
     */
    public Integer getLearningMode() {
        return learningMode;
    }

    /**
     * 设置算法学习方式（预留）
            1：Supervised Learning，有监督学习
            2：Unsupervised Learning，无监督学习
            3：Semi-Supervised Learning，半监督学习
     *
     * @param learningMode 算法学习方式（预留）
            1：Supervised Learning，有监督学习
            2：Unsupervised Learning，无监督学习
            3：Semi-Supervised Learning，半监督学习
     */
    public void setLearningMode(Integer learningMode) {
        this.learningMode = learningMode;
    }

    /**
     * 获取算法最优化方法（预留）
0：unknown
1：批量梯度下降法
2：随机梯度下降法
3：mini-batch梯度下降法
4：牛顿法
5：拟牛顿法
6：共轭梯度法
7：启发式优化方法
8：拉格朗日乘数法
     *
     * @return OPTIMIZE_METHOD - 算法最优化方法（预留）
0：unknown
1：批量梯度下降法
2：随机梯度下降法
3：mini-batch梯度下降法
4：牛顿法
5：拟牛顿法
6：共轭梯度法
7：启发式优化方法
8：拉格朗日乘数法
     */
    public Integer getOptimizeMethod() {
        return optimizeMethod;
    }

    /**
     * 设置算法最优化方法（预留）
0：unknown
1：批量梯度下降法
2：随机梯度下降法
3：mini-batch梯度下降法
4：牛顿法
5：拟牛顿法
6：共轭梯度法
7：启发式优化方法
8：拉格朗日乘数法
     *
     * @param optimizeMethod 算法最优化方法（预留）
0：unknown
1：批量梯度下降法
2：随机梯度下降法
3：mini-batch梯度下降法
4：牛顿法
5：拟牛顿法
6：共轭梯度法
7：启发式优化方法
8：拉格朗日乘数法
     */
    public void setOptimizeMethod(Integer optimizeMethod) {
        this.optimizeMethod = optimizeMethod;
    }

    /**
     * 获取是否可调参
            0：否
            1：是
     *
     * @return IS_TUNABLE - 是否可调参
            0：否
            1：是
     */
    public Integer getIsTunable() {
        return isTunable;
    }

    /**
     * 设置是否可调参
            0：否
            1：是
     *
     * @param isTunable 是否可调参
            0：否
            1：是
     */
    public void setIsTunable(Integer isTunable) {
        this.isTunable = isTunable;
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
        CcCmptAlgorithm other = (CcCmptAlgorithm) that;
        return (this.getAlgorithmId() == null ? other.getAlgorithmId() == null : this.getAlgorithmId().equals(other.getAlgorithmId()))
            && (this.getAlgorithmCode() == null ? other.getAlgorithmCode() == null : this.getAlgorithmCode().equals(other.getAlgorithmCode()))
            && (this.getAlgorithmName() == null ? other.getAlgorithmName() == null : this.getAlgorithmName().equals(other.getAlgorithmName()))
            && (this.getAlgorithmType() == null ? other.getAlgorithmType() == null : this.getAlgorithmType().equals(other.getAlgorithmType()))
            && (this.getAlgorithmLabels() == null ? other.getAlgorithmLabels() == null : this.getAlgorithmLabels().equals(other.getAlgorithmLabels()))
            && (this.getLearningMode() == null ? other.getLearningMode() == null : this.getLearningMode().equals(other.getLearningMode()))
            && (this.getOptimizeMethod() == null ? other.getOptimizeMethod() == null : this.getOptimizeMethod().equals(other.getOptimizeMethod()))
            && (this.getIsTunable() == null ? other.getIsTunable() == null : this.getIsTunable().equals(other.getIsTunable()))
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
        result = prime * result + ((getOptimizeMethod() == null) ? 0 : getOptimizeMethod().hashCode());
        result = prime * result + ((getIsTunable() == null) ? 0 : getIsTunable().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}