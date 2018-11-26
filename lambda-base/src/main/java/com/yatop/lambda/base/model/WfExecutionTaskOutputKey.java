package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "wf_execution_task_output")
public class WfExecutionTaskOutputKey implements Serializable {
    /**
     * 节点ID
     */
    @Id
    @Column(name = "TASK_ID")
    private Long taskId;

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
     * @return TASK_ID - 节点ID
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 设置节点ID
     *
     * @param taskId 节点ID
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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
        WfExecutionTaskOutputKey other = (WfExecutionTaskOutputKey) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        return result;
    }
}