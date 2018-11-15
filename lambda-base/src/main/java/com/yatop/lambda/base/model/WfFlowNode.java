package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_flow_node")
public class WfFlowNode implements Serializable {
    /**
     * 节点ID
     */
    @Id
    @Column(name = "NODE_ID")
    private Long nodeId;

    /**
     * 节点名称，自动生成，可编辑
     */
    @Column(name = "NODE_NAME")
    private String nodeName;

    /**
     * 所属工作流ID，无关联实验设为-1
     */
    @Column(name = "OWNER_FLOW_ID")
    private Long ownerFlowId;

    /**
     * 引用工作流组件ID
     */
    @Column(name = "REF_MODULE_ID")
    private Long refModuleId;

    /**
     * 流程图节点X轴坐标
     */
    @Column(name = "POSITION_X")
    private Long positionX;

    /**
     * 流程图节点Y轴坐标
     */
    @Column(name = "POSITION_Y")
    private Long positionY;

    /**
     * 节点序号，用于辅助创建新节点时节点名称的自动生成
     */
    @Column(name = "SEQUENCE")
    private Integer sequence;

    /**
     * 最后任务ID
     */
    @Column(name = "LAST_TASK_ID")
    private Long lastTaskId;

    /**
     * 流程图节点描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 节点状态
            0：not ready，未就绪
            1：ready，已就绪
            2：preparing，准备中
            3：running，运行中
            4：success，运行成功
            5：error，运行出错
     */
    @Column(name = "NODE_STATE")
    private Integer nodeState;

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
     * 获取节点ID
     *
     * @return NODE_ID - 节点ID
     */
    public Long getNodeId() {
        return nodeId;
    }

    /**
     * 设置节点ID
     *
     * @param nodeId 节点ID
     */
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 获取节点名称，自动生成，可编辑
     *
     * @return NODE_NAME - 节点名称，自动生成，可编辑
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * 设置节点名称，自动生成，可编辑
     *
     * @param nodeName 节点名称，自动生成，可编辑
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    /**
     * 获取所属工作流ID，无关联实验设为-1
     *
     * @return OWNER_FLOW_ID - 所属工作流ID，无关联实验设为-1
     */
    public Long getOwnerFlowId() {
        return ownerFlowId;
    }

    /**
     * 设置所属工作流ID，无关联实验设为-1
     *
     * @param ownerFlowId 所属工作流ID，无关联实验设为-1
     */
    public void setOwnerFlowId(Long ownerFlowId) {
        this.ownerFlowId = ownerFlowId;
    }

    /**
     * 获取引用工作流组件ID
     *
     * @return REF_MODULE_ID - 引用工作流组件ID
     */
    public Long getRefModuleId() {
        return refModuleId;
    }

    /**
     * 设置引用工作流组件ID
     *
     * @param refModuleId 引用工作流组件ID
     */
    public void setRefModuleId(Long refModuleId) {
        this.refModuleId = refModuleId;
    }

    /**
     * 获取流程图节点X轴坐标
     *
     * @return POSITION_X - 流程图节点X轴坐标
     */
    public Long getPositionX() {
        return positionX;
    }

    /**
     * 设置流程图节点X轴坐标
     *
     * @param positionX 流程图节点X轴坐标
     */
    public void setPositionX(Long positionX) {
        this.positionX = positionX;
    }

    /**
     * 获取流程图节点Y轴坐标
     *
     * @return POSITION_Y - 流程图节点Y轴坐标
     */
    public Long getPositionY() {
        return positionY;
    }

    /**
     * 设置流程图节点Y轴坐标
     *
     * @param positionY 流程图节点Y轴坐标
     */
    public void setPositionY(Long positionY) {
        this.positionY = positionY;
    }

    /**
     * 获取节点序号，用于辅助创建新节点时节点名称的自动生成
     *
     * @return SEQUENCE - 节点序号，用于辅助创建新节点时节点名称的自动生成
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置节点序号，用于辅助创建新节点时节点名称的自动生成
     *
     * @param sequence 节点序号，用于辅助创建新节点时节点名称的自动生成
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 获取最后任务ID
     *
     * @return LAST_TASK_ID - 最后任务ID
     */
    public Long getLastTaskId() {
        return lastTaskId;
    }

    /**
     * 设置最后任务ID
     *
     * @param lastTaskId 最后任务ID
     */
    public void setLastTaskId(Long lastTaskId) {
        this.lastTaskId = lastTaskId;
    }

    /**
     * 获取流程图节点描述
     *
     * @return DESCRIPTION - 流程图节点描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置流程图节点描述
     *
     * @param description 流程图节点描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取节点状态
            0：not ready，未就绪
            1：ready，已就绪
            2：preparing，准备中
            3：running，运行中
            4：success，运行成功
            5：error，运行出错
     *
     * @return NODE_STATE - 节点状态
            0：not ready，未就绪
            1：ready，已就绪
            2：preparing，准备中
            3：running，运行中
            4：success，运行成功
            5：error，运行出错
     */
    public Integer getNodeState() {
        return nodeState;
    }

    /**
     * 设置节点状态
            0：not ready，未就绪
            1：ready，已就绪
            2：preparing，准备中
            3：running，运行中
            4：success，运行成功
            5：error，运行出错
     *
     * @param nodeState 节点状态
            0：not ready，未就绪
            1：ready，已就绪
            2：preparing，准备中
            3：running，运行中
            4：success，运行成功
            5：error，运行出错
     */
    public void setNodeState(Integer nodeState) {
        this.nodeState = nodeState;
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
        WfFlowNode other = (WfFlowNode) that;
        return (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getNodeName() == null ? other.getNodeName() == null : this.getNodeName().equals(other.getNodeName()))
            && (this.getOwnerFlowId() == null ? other.getOwnerFlowId() == null : this.getOwnerFlowId().equals(other.getOwnerFlowId()))
            && (this.getRefModuleId() == null ? other.getRefModuleId() == null : this.getRefModuleId().equals(other.getRefModuleId()))
            && (this.getPositionX() == null ? other.getPositionX() == null : this.getPositionX().equals(other.getPositionX()))
            && (this.getPositionY() == null ? other.getPositionY() == null : this.getPositionY().equals(other.getPositionY()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getLastTaskId() == null ? other.getLastTaskId() == null : this.getLastTaskId().equals(other.getLastTaskId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getNodeState() == null ? other.getNodeState() == null : this.getNodeState().equals(other.getNodeState()))
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
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getNodeName() == null) ? 0 : getNodeName().hashCode());
        result = prime * result + ((getOwnerFlowId() == null) ? 0 : getOwnerFlowId().hashCode());
        result = prime * result + ((getRefModuleId() == null) ? 0 : getRefModuleId().hashCode());
        result = prime * result + ((getPositionX() == null) ? 0 : getPositionX().hashCode());
        result = prime * result + ((getPositionY() == null) ? 0 : getPositionY().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getLastTaskId() == null) ? 0 : getLastTaskId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getNodeState() == null) ? 0 : getNodeState().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}