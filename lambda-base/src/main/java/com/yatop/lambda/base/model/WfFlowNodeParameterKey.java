package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "wf_flow_node_parameter")
public class WfFlowNodeParameterKey implements Serializable {
    /**
     * 节点ID
     */
    @Id
    @Column(name = "NODE_ID")
    private Long nodeId;

    /**
     * 组件特征ID
     */
    @Id
    @Column(name = "CHAR_ID")
    private Long charId;

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
     * 获取组件特征ID
     *
     * @return CHAR_ID - 组件特征ID
     */
    public Long getCharId() {
        return charId;
    }

    /**
     * 设置组件特征ID
     *
     * @param charId 组件特征ID
     */
    public void setCharId(Long charId) {
        this.charId = charId;
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
        WfFlowNodeParameterKey other = (WfFlowNodeParameterKey) that;
        return (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        return result;
    }
}