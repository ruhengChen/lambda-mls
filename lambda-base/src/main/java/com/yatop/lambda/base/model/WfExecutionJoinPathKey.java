package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "wf_execution_join_path")
public class WfExecutionJoinPathKey implements Serializable {
    /**
     * 会合ID
     */
    @Id
    @Column(name = "JOIN_ID")
    private Long joinId;

    /**
     * 上游路径ID
     */
    @Id
    @Column(name = "UPSTREAM_PATH_ID")
    private Long upstreamPathId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取会合ID
     *
     * @return JOIN_ID - 会合ID
     */
    public Long getJoinId() {
        return joinId;
    }

    /**
     * 设置会合ID
     *
     * @param joinId 会合ID
     */
    public void setJoinId(Long joinId) {
        this.joinId = joinId;
    }

    /**
     * 获取上游路径ID
     *
     * @return UPSTREAM_PATH_ID - 上游路径ID
     */
    public Long getUpstreamPathId() {
        return upstreamPathId;
    }

    /**
     * 设置上游路径ID
     *
     * @param upstreamPathId 上游路径ID
     */
    public void setUpstreamPathId(Long upstreamPathId) {
        this.upstreamPathId = upstreamPathId;
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
        WfExecutionJoinPathKey other = (WfExecutionJoinPathKey) that;
        return (this.getJoinId() == null ? other.getJoinId() == null : this.getJoinId().equals(other.getJoinId()))
            && (this.getUpstreamPathId() == null ? other.getUpstreamPathId() == null : this.getUpstreamPathId().equals(other.getUpstreamPathId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJoinId() == null) ? 0 : getJoinId().hashCode());
        result = prime * result + ((getUpstreamPathId() == null) ? 0 : getUpstreamPathId().hashCode());
        return result;
    }
}