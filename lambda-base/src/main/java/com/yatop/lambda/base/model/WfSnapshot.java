package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_snapshot")
public class WfSnapshot implements Serializable {
    /**
     * 快照ID
     */
    @Id
    @Column(name = "SNAPSHOT_ID")
    private Long snapshotId;

    /**
     * 快照名称
     */
    @Column(name = "SNAPSHOT_NAME")
    private String snapshotName;

    /**
     * 快照来源
            0：工作流运行
            1：工作流副本
     */
    @Column(name = "SHAPSHOT_SRC")
    private Integer shapshotSrc;

    /**
     * 所属项目ID
     */
    @Column(name = "OWNER_PROJECT_ID")
    private Long ownerProjectId;

    /**
     * 所属流程图ID
     */
    @Column(name = "OWNER_FLOW_ID")
    private Long ownerFlowId;

    /**
     * 快照版本
     */
    @Column(name = "SNAPSHOT_VERSION")
    private Long snapshotVersion;

    /**
     * 快照状态
            0：generating，快照生成中
            1：finished，快照完成
     */
    @Column(name = "SNAPSHOT_STATE")
    private Integer snapshotState;

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
     * 快照内容
     */
    @Column(name = "SNAPSHOT_CONTENT")
    private String snapshotContent;

    private static final long serialVersionUID = 1L;

    /**
     * 获取快照ID
     *
     * @return SNAPSHOT_ID - 快照ID
     */
    public Long getSnapshotId() {
        return snapshotId;
    }

    /**
     * 设置快照ID
     *
     * @param snapshotId 快照ID
     */
    public void setSnapshotId(Long snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * 获取快照名称
     *
     * @return SNAPSHOT_NAME - 快照名称
     */
    public String getSnapshotName() {
        return snapshotName;
    }

    /**
     * 设置快照名称
     *
     * @param snapshotName 快照名称
     */
    public void setSnapshotName(String snapshotName) {
        this.snapshotName = snapshotName == null ? null : snapshotName.trim();
    }

    /**
     * 获取快照来源
            0：工作流运行
            1：工作流副本
     *
     * @return SHAPSHOT_SRC - 快照来源
            0：工作流运行
            1：工作流副本
     */
    public Integer getShapshotSrc() {
        return shapshotSrc;
    }

    /**
     * 设置快照来源
            0：工作流运行
            1：工作流副本
     *
     * @param shapshotSrc 快照来源
            0：工作流运行
            1：工作流副本
     */
    public void setShapshotSrc(Integer shapshotSrc) {
        this.shapshotSrc = shapshotSrc;
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
     * 获取所属流程图ID
     *
     * @return OWNER_FLOW_ID - 所属流程图ID
     */
    public Long getOwnerFlowId() {
        return ownerFlowId;
    }

    /**
     * 设置所属流程图ID
     *
     * @param ownerFlowId 所属流程图ID
     */
    public void setOwnerFlowId(Long ownerFlowId) {
        this.ownerFlowId = ownerFlowId;
    }

    /**
     * 获取快照版本
     *
     * @return SNAPSHOT_VERSION - 快照版本
     */
    public Long getSnapshotVersion() {
        return snapshotVersion;
    }

    /**
     * 设置快照版本
     *
     * @param snapshotVersion 快照版本
     */
    public void setSnapshotVersion(Long snapshotVersion) {
        this.snapshotVersion = snapshotVersion;
    }

    /**
     * 获取快照状态
            0：generating，快照生成中
            1：finished，快照完成
     *
     * @return SNAPSHOT_STATE - 快照状态
            0：generating，快照生成中
            1：finished，快照完成
     */
    public Integer getSnapshotState() {
        return snapshotState;
    }

    /**
     * 设置快照状态
            0：generating，快照生成中
            1：finished，快照完成
     *
     * @param snapshotState 快照状态
            0：generating，快照生成中
            1：finished，快照完成
     */
    public void setSnapshotState(Integer snapshotState) {
        this.snapshotState = snapshotState;
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
     * 获取快照内容
     *
     * @return SNAPSHOT_CONTENT - 快照内容
     */
    public String getSnapshotContent() {
        return snapshotContent;
    }

    /**
     * 设置快照内容
     *
     * @param snapshotContent 快照内容
     */
    public void setSnapshotContent(String snapshotContent) {
        this.snapshotContent = snapshotContent == null ? null : snapshotContent.trim();
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
        WfSnapshot other = (WfSnapshot) that;
        return (this.getSnapshotId() == null ? other.getSnapshotId() == null : this.getSnapshotId().equals(other.getSnapshotId()))
            && (this.getSnapshotName() == null ? other.getSnapshotName() == null : this.getSnapshotName().equals(other.getSnapshotName()))
            && (this.getShapshotSrc() == null ? other.getShapshotSrc() == null : this.getShapshotSrc().equals(other.getShapshotSrc()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getOwnerFlowId() == null ? other.getOwnerFlowId() == null : this.getOwnerFlowId().equals(other.getOwnerFlowId()))
            && (this.getSnapshotVersion() == null ? other.getSnapshotVersion() == null : this.getSnapshotVersion().equals(other.getSnapshotVersion()))
            && (this.getSnapshotState() == null ? other.getSnapshotState() == null : this.getSnapshotState().equals(other.getSnapshotState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()))
            && (this.getSnapshotContent() == null ? other.getSnapshotContent() == null : this.getSnapshotContent().equals(other.getSnapshotContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSnapshotId() == null) ? 0 : getSnapshotId().hashCode());
        result = prime * result + ((getSnapshotName() == null) ? 0 : getSnapshotName().hashCode());
        result = prime * result + ((getShapshotSrc() == null) ? 0 : getShapshotSrc().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getOwnerFlowId() == null) ? 0 : getOwnerFlowId().hashCode());
        result = prime * result + ((getSnapshotVersion() == null) ? 0 : getSnapshotVersion().hashCode());
        result = prime * result + ((getSnapshotState() == null) ? 0 : getSnapshotState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        result = prime * result + ((getSnapshotContent() == null) ? 0 : getSnapshotContent().hashCode());
        return result;
    }
}