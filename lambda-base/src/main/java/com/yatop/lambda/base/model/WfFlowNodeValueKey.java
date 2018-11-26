package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "wf_flow_node_value")
public class WfFlowNodeValueKey implements Serializable {
    /**
     * 节点ID
     */
    @Id
    @Column(name = "NODE_ID")
    private Long nodeId;

    /**
     * 规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE
            节点上只设置组件参数和调优执行
     */
    @Id
    @Column(name = "SPEC_TYPE")
    private Integer specType;

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
     * 获取规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE
            节点上只设置组件参数和调优执行
     *
     * @return SPEC_TYPE - 规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE
            节点上只设置组件参数和调优执行
     */
    public Integer getSpecType() {
        return specType;
    }

    /**
     * 设置规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE
            节点上只设置组件参数和调优执行
     *
     * @param specType 规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE
            节点上只设置组件参数和调优执行
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
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
        WfFlowNodeValueKey other = (WfFlowNodeValueKey) that;
        return (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getSpecType() == null ? other.getSpecType() == null : this.getSpecType().equals(other.getSpecType()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getSpecType() == null) ? 0 : getSpecType().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        return result;
    }
}