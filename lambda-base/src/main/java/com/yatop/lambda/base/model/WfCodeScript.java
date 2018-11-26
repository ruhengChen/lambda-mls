package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_code_script")
public class WfCodeScript implements Serializable {
    /**
     * 脚本ID
     */
    @Id
    @Column(name = "SCRIPT_ID")
    private Long scriptId;

    /**
     * 脚本名称
            
            由工作流创建：<module_code>_<node_id>_<char_id>_<snapshot_version>
     */
    @Column(name = "SCRIPT_NAME")
    private String scriptName;

    /**
     * 脚本类型
            1：SQL脚本
            2：Python脚本（预留）
            3：R脚本（预留）
            4：特征抽取脚本（预留）
     */
    @Column(name = "SCRIPT_TYPE")
    private Integer scriptType;

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
     * 脚本状态
            0：正常
            1：空脚本
     */
    @Column(name = "SCRIPT_STATE")
    private Integer scriptState;

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
     * 脚本内容
     */
    @Column(name = "SCRIPT_CONTENT")
    private String scriptContent;

    private static final long serialVersionUID = 1L;

    /**
     * 获取脚本ID
     *
     * @return SCRIPT_ID - 脚本ID
     */
    public Long getScriptId() {
        return scriptId;
    }

    /**
     * 设置脚本ID
     *
     * @param scriptId 脚本ID
     */
    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    /**
     * 获取脚本名称
            
            由工作流创建：<module_code>_<node_id>_<char_id>_<snapshot_version>
     *
     * @return SCRIPT_NAME - 脚本名称
            
            由工作流创建：<module_code>_<node_id>_<char_id>_<snapshot_version>
     */
    public String getScriptName() {
        return scriptName;
    }

    /**
     * 设置脚本名称
            
            由工作流创建：<module_code>_<node_id>_<char_id>_<snapshot_version>
     *
     * @param scriptName 脚本名称
            
            由工作流创建：<module_code>_<node_id>_<char_id>_<snapshot_version>
     */
    public void setScriptName(String scriptName) {
        this.scriptName = scriptName == null ? null : scriptName.trim();
    }

    /**
     * 获取脚本类型
            1：SQL脚本
            2：Python脚本（预留）
            3：R脚本（预留）
            4：特征抽取脚本（预留）
     *
     * @return SCRIPT_TYPE - 脚本类型
            1：SQL脚本
            2：Python脚本（预留）
            3：R脚本（预留）
            4：特征抽取脚本（预留）
     */
    public Integer getScriptType() {
        return scriptType;
    }

    /**
     * 设置脚本类型
            1：SQL脚本
            2：Python脚本（预留）
            3：R脚本（预留）
            4：特征抽取脚本（预留）
     *
     * @param scriptType 脚本类型
            1：SQL脚本
            2：Python脚本（预留）
            3：R脚本（预留）
            4：特征抽取脚本（预留）
     */
    public void setScriptType(Integer scriptType) {
        this.scriptType = scriptType;
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
     * 获取脚本状态
            0：正常
            1：空脚本
     *
     * @return SCRIPT_STATE - 脚本状态
            0：正常
            1：空脚本
     */
    public Integer getScriptState() {
        return scriptState;
    }

    /**
     * 设置脚本状态
            0：正常
            1：空脚本
     *
     * @param scriptState 脚本状态
            0：正常
            1：空脚本
     */
    public void setScriptState(Integer scriptState) {
        this.scriptState = scriptState;
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
     * 获取脚本内容
     *
     * @return SCRIPT_CONTENT - 脚本内容
     */
    public String getScriptContent() {
        return scriptContent;
    }

    /**
     * 设置脚本内容
     *
     * @param scriptContent 脚本内容
     */
    public void setScriptContent(String scriptContent) {
        this.scriptContent = scriptContent == null ? null : scriptContent.trim();
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
        WfCodeScript other = (WfCodeScript) that;
        return (this.getScriptId() == null ? other.getScriptId() == null : this.getScriptId().equals(other.getScriptId()))
            && (this.getScriptName() == null ? other.getScriptName() == null : this.getScriptName().equals(other.getScriptName()))
            && (this.getScriptType() == null ? other.getScriptType() == null : this.getScriptType().equals(other.getScriptType()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getRelFlowId() == null ? other.getRelFlowId() == null : this.getRelFlowId().equals(other.getRelFlowId()))
            && (this.getRelSnapshotVersion() == null ? other.getRelSnapshotVersion() == null : this.getRelSnapshotVersion().equals(other.getRelSnapshotVersion()))
            && (this.getRelJobId() == null ? other.getRelJobId() == null : this.getRelJobId().equals(other.getRelJobId()))
            && (this.getRelNodeId() == null ? other.getRelNodeId() == null : this.getRelNodeId().equals(other.getRelNodeId()))
            && (this.getRelCharId() == null ? other.getRelCharId() == null : this.getRelCharId().equals(other.getRelCharId()))
            && (this.getScriptState() == null ? other.getScriptState() == null : this.getScriptState().equals(other.getScriptState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()))
            && (this.getScriptContent() == null ? other.getScriptContent() == null : this.getScriptContent().equals(other.getScriptContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getScriptId() == null) ? 0 : getScriptId().hashCode());
        result = prime * result + ((getScriptName() == null) ? 0 : getScriptName().hashCode());
        result = prime * result + ((getScriptType() == null) ? 0 : getScriptType().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getRelFlowId() == null) ? 0 : getRelFlowId().hashCode());
        result = prime * result + ((getRelSnapshotVersion() == null) ? 0 : getRelSnapshotVersion().hashCode());
        result = prime * result + ((getRelJobId() == null) ? 0 : getRelJobId().hashCode());
        result = prime * result + ((getRelNodeId() == null) ? 0 : getRelNodeId().hashCode());
        result = prime * result + ((getRelCharId() == null) ? 0 : getRelCharId().hashCode());
        result = prime * result + ((getScriptState() == null) ? 0 : getScriptState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        result = prime * result + ((getScriptContent() == null) ? 0 : getScriptContent().hashCode());
        return result;
    }
}