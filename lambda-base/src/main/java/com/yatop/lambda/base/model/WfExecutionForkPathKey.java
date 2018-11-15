package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "wf_execution_fork_path")
public class WfExecutionForkPathKey implements Serializable {
    /**
     * 分叉ID
     */
    @Id
    @Column(name = "FORK_ID")
    private Long forkId;

    /**
     * 下游路径ID
     */
    @Id
    @Column(name = "DOWNSTREAM_PATH_ID")
    private Long downstreamPathId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取分叉ID
     *
     * @return FORK_ID - 分叉ID
     */
    public Long getForkId() {
        return forkId;
    }

    /**
     * 设置分叉ID
     *
     * @param forkId 分叉ID
     */
    public void setForkId(Long forkId) {
        this.forkId = forkId;
    }

    /**
     * 获取下游路径ID
     *
     * @return DOWNSTREAM_PATH_ID - 下游路径ID
     */
    public Long getDownstreamPathId() {
        return downstreamPathId;
    }

    /**
     * 设置下游路径ID
     *
     * @param downstreamPathId 下游路径ID
     */
    public void setDownstreamPathId(Long downstreamPathId) {
        this.downstreamPathId = downstreamPathId;
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
        WfExecutionForkPathKey other = (WfExecutionForkPathKey) that;
        return (this.getForkId() == null ? other.getForkId() == null : this.getForkId().equals(other.getForkId()))
            && (this.getDownstreamPathId() == null ? other.getDownstreamPathId() == null : this.getDownstreamPathId().equals(other.getDownstreamPathId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getForkId() == null) ? 0 : getForkId().hashCode());
        result = prime * result + ((getDownstreamPathId() == null) ? 0 : getDownstreamPathId().hashCode());
        return result;
    }
}