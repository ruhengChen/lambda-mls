package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "wf_flow_node_delete_queue")
public class WfFlowNodeDeleteQueueKey implements Serializable {
    /**
     * 工作流ID
     */
    @Id
    @Column(name = "FLOW_ID")
    private Long flowId;

    /**
     * 节点ID
     */
    @Id
    @Column(name = "NODE_ID")
    private Long nodeId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取工作流ID
     *
     * @return FLOW_ID - 工作流ID
     */
    public Long getFlowId() {
        return flowId;
    }

    /**
     * 设置工作流ID
     *
     * @param flowId 工作流ID
     */
    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

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
        WfFlowNodeDeleteQueueKey other = (WfFlowNodeDeleteQueueKey) that;
        return (this.getFlowId() == null ? other.getFlowId() == null : this.getFlowId().equals(other.getFlowId()))
            && (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFlowId() == null) ? 0 : getFlowId().hashCode());
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        return result;
    }
}