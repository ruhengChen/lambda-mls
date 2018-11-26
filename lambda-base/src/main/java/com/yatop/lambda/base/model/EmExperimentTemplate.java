package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "em_experiment_template")
public class EmExperimentTemplate implements Serializable {
    /**
     * 模版ID
     */
    @Id
    @Column(name = "TEMPLATE_ID")
    private Long templateId;

    /**
     * 模版名称
     */
    @Column(name = "TEMPLATE_NAME")
    private String templateName;

    /**
     * 模版序号，排序用
     */
    @Column(name = "SEQUENCE")
    private Integer sequence;

    /**
     * 模版使用计数
     */
    @Column(name = "TEMPLATE_COUNT")
    private Long templateCount;

    /**
     * 摘要
     */
    @Column(name = "SUMMARY")
    private String summary;

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
     * 模版内容
     */
    @Column(name = "TEMPLATE_CONTENT")
    private String templateContent;

    private static final long serialVersionUID = 1L;

    /**
     * 获取模版ID
     *
     * @return TEMPLATE_ID - 模版ID
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * 设置模版ID
     *
     * @param templateId 模版ID
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取模版名称
     *
     * @return TEMPLATE_NAME - 模版名称
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 设置模版名称
     *
     * @param templateName 模版名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    /**
     * 获取模版序号，排序用
     *
     * @return SEQUENCE - 模版序号，排序用
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置模版序号，排序用
     *
     * @param sequence 模版序号，排序用
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 获取模版使用计数
     *
     * @return TEMPLATE_COUNT - 模版使用计数
     */
    public Long getTemplateCount() {
        return templateCount;
    }

    /**
     * 设置模版使用计数
     *
     * @param templateCount 模版使用计数
     */
    public void setTemplateCount(Long templateCount) {
        this.templateCount = templateCount;
    }

    /**
     * 获取摘要
     *
     * @return SUMMARY - 摘要
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置摘要
     *
     * @param summary 摘要
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
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
     * 获取模版内容
     *
     * @return TEMPLATE_CONTENT - 模版内容
     */
    public String getTemplateContent() {
        return templateContent;
    }

    /**
     * 设置模版内容
     *
     * @param templateContent 模版内容
     */
    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent == null ? null : templateContent.trim();
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
        EmExperimentTemplate other = (EmExperimentTemplate) that;
        return (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()))
            && (this.getTemplateName() == null ? other.getTemplateName() == null : this.getTemplateName().equals(other.getTemplateName()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getTemplateCount() == null ? other.getTemplateCount() == null : this.getTemplateCount().equals(other.getTemplateCount()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()))
            && (this.getTemplateContent() == null ? other.getTemplateContent() == null : this.getTemplateContent().equals(other.getTemplateContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
        result = prime * result + ((getTemplateName() == null) ? 0 : getTemplateName().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getTemplateCount() == null) ? 0 : getTemplateCount().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        result = prime * result + ((getTemplateContent() == null) ? 0 : getTemplateContent().hashCode());
        return result;
    }
}