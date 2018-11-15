package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cf_component")
public class CfComponent implements Serializable {
    /**
     * 组件ID，长度限制20
            
            输入输出组件ID范围：IO@COM-[0000 ~ 9999]
            脚本工具组件ID范围：ST@COM-[0000 ~ 9999]
            数据预处理组件ID范围：DP@COM-[0000 ~ 9999]
            特征工程组件ID范围：FE@COM-[0000 ~ 9999]
            统计分析组件ID范围：SA@COM-[0000 ~ 9999]
            机器学习组件ID范围：ML@COM-[0000 ~ 9999]
            深度学习组件ID范围：DL@COM-[0000 ~ 9999]
            文本分析组件ID范围：TA@COM-[0000 ~ 9999]
            网络分析组件ID范围：NA@COM-[0000 ~ 9999]
            
     */
    @Id
    @Column(name = "CMPT_ID")
    private String cmptId;

    /**
     * 组件代码
     */
    @Column(name = "CMPT_CODE")
    private String cmptCode;

    /**
     * 组件名称
     */
    @Column(name = "CMPT_NAME")
    private String cmptName;

    /**
     * 组件种类
            0：输入输出组件
            1：脚本工具组件
            2：数据预处理组件
            3：特征工程组件
            4：统计分析组件
            5：机器学习组件
            6：深度学习组件
            7：文本分析组件
            8：网络分析组件
     */
    @Column(name = "CMPT_TYPE")
    private Integer cmptType;

    /**
     * 组件修订号
     */
    @Column(name = "CMPT_REVISION")
    private Integer cmptRevision;

    /**
     * 关联算法ID，非算法组件设为-1
     */
    @Column(name = "REL_ALGORITHM_ID")
    private Long relAlgorithmId;

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
     * 获取组件ID，长度限制20
            
            输入输出组件ID范围：IO@COM-[0000 ~ 9999]
            脚本工具组件ID范围：ST@COM-[0000 ~ 9999]
            数据预处理组件ID范围：DP@COM-[0000 ~ 9999]
            特征工程组件ID范围：FE@COM-[0000 ~ 9999]
            统计分析组件ID范围：SA@COM-[0000 ~ 9999]
            机器学习组件ID范围：ML@COM-[0000 ~ 9999]
            深度学习组件ID范围：DL@COM-[0000 ~ 9999]
            文本分析组件ID范围：TA@COM-[0000 ~ 9999]
            网络分析组件ID范围：NA@COM-[0000 ~ 9999]
            
     *
     * @return CMPT_ID - 组件ID，长度限制20
            
            输入输出组件ID范围：IO@COM-[0000 ~ 9999]
            脚本工具组件ID范围：ST@COM-[0000 ~ 9999]
            数据预处理组件ID范围：DP@COM-[0000 ~ 9999]
            特征工程组件ID范围：FE@COM-[0000 ~ 9999]
            统计分析组件ID范围：SA@COM-[0000 ~ 9999]
            机器学习组件ID范围：ML@COM-[0000 ~ 9999]
            深度学习组件ID范围：DL@COM-[0000 ~ 9999]
            文本分析组件ID范围：TA@COM-[0000 ~ 9999]
            网络分析组件ID范围：NA@COM-[0000 ~ 9999]
            
     */
    public String getCmptId() {
        return cmptId;
    }

    /**
     * 设置组件ID，长度限制20
            
            输入输出组件ID范围：IO@COM-[0000 ~ 9999]
            脚本工具组件ID范围：ST@COM-[0000 ~ 9999]
            数据预处理组件ID范围：DP@COM-[0000 ~ 9999]
            特征工程组件ID范围：FE@COM-[0000 ~ 9999]
            统计分析组件ID范围：SA@COM-[0000 ~ 9999]
            机器学习组件ID范围：ML@COM-[0000 ~ 9999]
            深度学习组件ID范围：DL@COM-[0000 ~ 9999]
            文本分析组件ID范围：TA@COM-[0000 ~ 9999]
            网络分析组件ID范围：NA@COM-[0000 ~ 9999]
            
     *
     * @param cmptId 组件ID，长度限制20
            
            输入输出组件ID范围：IO@COM-[0000 ~ 9999]
            脚本工具组件ID范围：ST@COM-[0000 ~ 9999]
            数据预处理组件ID范围：DP@COM-[0000 ~ 9999]
            特征工程组件ID范围：FE@COM-[0000 ~ 9999]
            统计分析组件ID范围：SA@COM-[0000 ~ 9999]
            机器学习组件ID范围：ML@COM-[0000 ~ 9999]
            深度学习组件ID范围：DL@COM-[0000 ~ 9999]
            文本分析组件ID范围：TA@COM-[0000 ~ 9999]
            网络分析组件ID范围：NA@COM-[0000 ~ 9999]
            
     */
    public void setCmptId(String cmptId) {
        this.cmptId = cmptId == null ? null : cmptId.trim();
    }

    /**
     * 获取组件代码
     *
     * @return CMPT_CODE - 组件代码
     */
    public String getCmptCode() {
        return cmptCode;
    }

    /**
     * 设置组件代码
     *
     * @param cmptCode 组件代码
     */
    public void setCmptCode(String cmptCode) {
        this.cmptCode = cmptCode == null ? null : cmptCode.trim();
    }

    /**
     * 获取组件名称
     *
     * @return CMPT_NAME - 组件名称
     */
    public String getCmptName() {
        return cmptName;
    }

    /**
     * 设置组件名称
     *
     * @param cmptName 组件名称
     */
    public void setCmptName(String cmptName) {
        this.cmptName = cmptName == null ? null : cmptName.trim();
    }

    /**
     * 获取组件种类
            0：输入输出组件
            1：脚本工具组件
            2：数据预处理组件
            3：特征工程组件
            4：统计分析组件
            5：机器学习组件
            6：深度学习组件
            7：文本分析组件
            8：网络分析组件
     *
     * @return CMPT_TYPE - 组件种类
            0：输入输出组件
            1：脚本工具组件
            2：数据预处理组件
            3：特征工程组件
            4：统计分析组件
            5：机器学习组件
            6：深度学习组件
            7：文本分析组件
            8：网络分析组件
     */
    public Integer getCmptType() {
        return cmptType;
    }

    /**
     * 设置组件种类
            0：输入输出组件
            1：脚本工具组件
            2：数据预处理组件
            3：特征工程组件
            4：统计分析组件
            5：机器学习组件
            6：深度学习组件
            7：文本分析组件
            8：网络分析组件
     *
     * @param cmptType 组件种类
            0：输入输出组件
            1：脚本工具组件
            2：数据预处理组件
            3：特征工程组件
            4：统计分析组件
            5：机器学习组件
            6：深度学习组件
            7：文本分析组件
            8：网络分析组件
     */
    public void setCmptType(Integer cmptType) {
        this.cmptType = cmptType;
    }

    /**
     * 获取组件修订号
     *
     * @return CMPT_REVISION - 组件修订号
     */
    public Integer getCmptRevision() {
        return cmptRevision;
    }

    /**
     * 设置组件修订号
     *
     * @param cmptRevision 组件修订号
     */
    public void setCmptRevision(Integer cmptRevision) {
        this.cmptRevision = cmptRevision;
    }

    /**
     * 获取关联算法ID，非算法组件设为-1
     *
     * @return REL_ALGORITHM_ID - 关联算法ID，非算法组件设为-1
     */
    public Long getRelAlgorithmId() {
        return relAlgorithmId;
    }

    /**
     * 设置关联算法ID，非算法组件设为-1
     *
     * @param relAlgorithmId 关联算法ID，非算法组件设为-1
     */
    public void setRelAlgorithmId(Long relAlgorithmId) {
        this.relAlgorithmId = relAlgorithmId;
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
        CfComponent other = (CfComponent) that;
        return (this.getCmptId() == null ? other.getCmptId() == null : this.getCmptId().equals(other.getCmptId()))
            && (this.getCmptCode() == null ? other.getCmptCode() == null : this.getCmptCode().equals(other.getCmptCode()))
            && (this.getCmptName() == null ? other.getCmptName() == null : this.getCmptName().equals(other.getCmptName()))
            && (this.getCmptType() == null ? other.getCmptType() == null : this.getCmptType().equals(other.getCmptType()))
            && (this.getCmptRevision() == null ? other.getCmptRevision() == null : this.getCmptRevision().equals(other.getCmptRevision()))
            && (this.getRelAlgorithmId() == null ? other.getRelAlgorithmId() == null : this.getRelAlgorithmId().equals(other.getRelAlgorithmId()))
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
        result = prime * result + ((getCmptId() == null) ? 0 : getCmptId().hashCode());
        result = prime * result + ((getCmptCode() == null) ? 0 : getCmptCode().hashCode());
        result = prime * result + ((getCmptName() == null) ? 0 : getCmptName().hashCode());
        result = prime * result + ((getCmptType() == null) ? 0 : getCmptType().hashCode());
        result = prime * result + ((getCmptRevision() == null) ? 0 : getCmptRevision().hashCode());
        result = prime * result + ((getRelAlgorithmId() == null) ? 0 : getRelAlgorithmId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}