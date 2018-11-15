package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mw_model_evaluation_report")
public class MwModelEvaluationReport implements Serializable {
    /**
     * 评估报告ID
     */
    @Id
    @Column(name = "REPORT_ID")
    private Long reportId;

    /**
     * 评估报告名称
     */
    @Column(name = "REPORT_NAME")
    private String reportName;

    /**
     *  所属模型ID
     */
    @Column(name = "OWNER_MODEL_ID")
    private Long ownerModelId;

    /**
     * 关联快照ID，无关联则设为-1
     */
    @Column(name = "REL_SNAPSHOT_ID")
    private Long relSnapshotId;

    /**
     * 关联节点ID，无关联则设为-1
     */
    @Column(name = "REL_NODE_ID")
    private Long relNodeId;

    /**
     * 测试集数据表ID
            
            由于快照策略会使得工作流节点的输出模型特征值记录被置位为被拷贝过，暂时无需做任何处理
            （关联测试集是否需要另外拷贝一份全量数据，待定）
     */
    @Column(name = "TEST_TABLE_ID")
    private Long testTableId;

    /**
     * 报告状态
            0：空报告
            1：正常
     */
    @Column(name = "REPORT_STATE")
    private Integer reportState;

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
     * 模型文件名，存放于模型目录下
            
            普通模型完整路径：model_<model_id>_<report_id>.rpt
     */
    @Column(name = "REPORT_FILE")
    private byte[] reportFile;

    private static final long serialVersionUID = 1L;

    /**
     * 获取评估报告ID
     *
     * @return REPORT_ID - 评估报告ID
     */
    public Long getReportId() {
        return reportId;
    }

    /**
     * 设置评估报告ID
     *
     * @param reportId 评估报告ID
     */
    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    /**
     * 获取评估报告名称
     *
     * @return REPORT_NAME - 评估报告名称
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * 设置评估报告名称
     *
     * @param reportName 评估报告名称
     */
    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    /**
     * 获取 所属模型ID
     *
     * @return OWNER_MODEL_ID -  所属模型ID
     */
    public Long getOwnerModelId() {
        return ownerModelId;
    }

    /**
     * 设置 所属模型ID
     *
     * @param ownerModelId  所属模型ID
     */
    public void setOwnerModelId(Long ownerModelId) {
        this.ownerModelId = ownerModelId;
    }

    /**
     * 获取关联快照ID，无关联则设为-1
     *
     * @return REL_SNAPSHOT_ID - 关联快照ID，无关联则设为-1
     */
    public Long getRelSnapshotId() {
        return relSnapshotId;
    }

    /**
     * 设置关联快照ID，无关联则设为-1
     *
     * @param relSnapshotId 关联快照ID，无关联则设为-1
     */
    public void setRelSnapshotId(Long relSnapshotId) {
        this.relSnapshotId = relSnapshotId;
    }

    /**
     * 获取关联节点ID，无关联则设为-1
     *
     * @return REL_NODE_ID - 关联节点ID，无关联则设为-1
     */
    public Long getRelNodeId() {
        return relNodeId;
    }

    /**
     * 设置关联节点ID，无关联则设为-1
     *
     * @param relNodeId 关联节点ID，无关联则设为-1
     */
    public void setRelNodeId(Long relNodeId) {
        this.relNodeId = relNodeId;
    }

    /**
     * 获取测试集数据表ID
            
            由于快照策略会使得工作流节点的输出模型特征值记录被置位为被拷贝过，暂时无需做任何处理
            （关联测试集是否需要另外拷贝一份全量数据，待定）
     *
     * @return TEST_TABLE_ID - 测试集数据表ID
            
            由于快照策略会使得工作流节点的输出模型特征值记录被置位为被拷贝过，暂时无需做任何处理
            （关联测试集是否需要另外拷贝一份全量数据，待定）
     */
    public Long getTestTableId() {
        return testTableId;
    }

    /**
     * 设置测试集数据表ID
            
            由于快照策略会使得工作流节点的输出模型特征值记录被置位为被拷贝过，暂时无需做任何处理
            （关联测试集是否需要另外拷贝一份全量数据，待定）
     *
     * @param testTableId 测试集数据表ID
            
            由于快照策略会使得工作流节点的输出模型特征值记录被置位为被拷贝过，暂时无需做任何处理
            （关联测试集是否需要另外拷贝一份全量数据，待定）
     */
    public void setTestTableId(Long testTableId) {
        this.testTableId = testTableId;
    }

    /**
     * 获取报告状态
            0：空报告
            1：正常
     *
     * @return REPORT_STATE - 报告状态
            0：空报告
            1：正常
     */
    public Integer getReportState() {
        return reportState;
    }

    /**
     * 设置报告状态
            0：空报告
            1：正常
     *
     * @param reportState 报告状态
            0：空报告
            1：正常
     */
    public void setReportState(Integer reportState) {
        this.reportState = reportState;
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
     * 获取模型文件名，存放于模型目录下
            
            普通模型完整路径：model_<model_id>_<report_id>.rpt
     *
     * @return REPORT_FILE - 模型文件名，存放于模型目录下
            
            普通模型完整路径：model_<model_id>_<report_id>.rpt
     */
    public byte[] getReportFile() {
        return reportFile;
    }

    /**
     * 设置模型文件名，存放于模型目录下
            
            普通模型完整路径：model_<model_id>_<report_id>.rpt
     *
     * @param reportFile 模型文件名，存放于模型目录下
            
            普通模型完整路径：model_<model_id>_<report_id>.rpt
     */
    public void setReportFile(byte[] reportFile) {
        this.reportFile = reportFile;
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
        MwModelEvaluationReport other = (MwModelEvaluationReport) that;
        return (this.getReportId() == null ? other.getReportId() == null : this.getReportId().equals(other.getReportId()))
            && (this.getReportName() == null ? other.getReportName() == null : this.getReportName().equals(other.getReportName()))
            && (this.getOwnerModelId() == null ? other.getOwnerModelId() == null : this.getOwnerModelId().equals(other.getOwnerModelId()))
            && (this.getRelSnapshotId() == null ? other.getRelSnapshotId() == null : this.getRelSnapshotId().equals(other.getRelSnapshotId()))
            && (this.getRelNodeId() == null ? other.getRelNodeId() == null : this.getRelNodeId().equals(other.getRelNodeId()))
            && (this.getTestTableId() == null ? other.getTestTableId() == null : this.getTestTableId().equals(other.getTestTableId()))
            && (this.getReportState() == null ? other.getReportState() == null : this.getReportState().equals(other.getReportState()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()))
            && (this.getReportFile() == null ? other.getReportFile() == null : this.getReportFile().equals(other.getReportFile()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReportId() == null) ? 0 : getReportId().hashCode());
        result = prime * result + ((getReportName() == null) ? 0 : getReportName().hashCode());
        result = prime * result + ((getOwnerModelId() == null) ? 0 : getOwnerModelId().hashCode());
        result = prime * result + ((getRelSnapshotId() == null) ? 0 : getRelSnapshotId().hashCode());
        result = prime * result + ((getRelNodeId() == null) ? 0 : getRelNodeId().hashCode());
        result = prime * result + ((getTestTableId() == null) ? 0 : getTestTableId().hashCode());
        result = prime * result + ((getReportState() == null) ? 0 : getReportState().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        result = prime * result + ((getReportFile() == null) ? 0 : getReportFile().hashCode());
        return result;
    }
}