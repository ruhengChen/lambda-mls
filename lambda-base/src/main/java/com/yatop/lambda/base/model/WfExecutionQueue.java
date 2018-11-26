package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_execution_queue")
public class WfExecutionQueue implements Serializable {
    /**
     * 作业ID
     */
    @Id
    @Column(name = "JOB_ID")
    private Long jobId;

    /**
     * 所属项目ID
     */
    @Column(name = "OWNER_PROJECT_ID")
    private Long ownerProjectId;

    /**
     * 作业时间
            
            指定作业的开始处理时间，值来自进入队列时和继续执行时
     */
    @Column(name = "JOB_TIME")
    private Date jobTime;

    /**
     * 作业信号
            0：SIG_NORMAL，正常信号
            1：SIG_KILL，杀死作业信号
            2：SIG_STOP，停止执行信号
            3：SIG_CONT，继续执行信号
     */
    @Column(name = "JOB_SIGNAL")
    private Integer jobSignal;

    /**
     * 处理状态
            0：queueing，排队中
            1：processing，处理中
            2：finished，运行结束
     */
    @Column(name = "JOB_STATE")
    private Integer jobState;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

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
     * 获取作业ID
     *
     * @return JOB_ID - 作业ID
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * 设置作业ID
     *
     * @param jobId 作业ID
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
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
     * 获取作业时间
            
            指定作业的开始处理时间，值来自进入队列时和继续执行时
     *
     * @return JOB_TIME - 作业时间
            
            指定作业的开始处理时间，值来自进入队列时和继续执行时
     */
    public Date getJobTime() {
        return jobTime;
    }

    /**
     * 设置作业时间
            
            指定作业的开始处理时间，值来自进入队列时和继续执行时
     *
     * @param jobTime 作业时间
            
            指定作业的开始处理时间，值来自进入队列时和继续执行时
     */
    public void setJobTime(Date jobTime) {
        this.jobTime = jobTime;
    }

    /**
     * 获取作业信号
            0：SIG_NORMAL，正常信号
            1：SIG_KILL，杀死作业信号
            2：SIG_STOP，停止执行信号
            3：SIG_CONT，继续执行信号
     *
     * @return JOB_SIGNAL - 作业信号
            0：SIG_NORMAL，正常信号
            1：SIG_KILL，杀死作业信号
            2：SIG_STOP，停止执行信号
            3：SIG_CONT，继续执行信号
     */
    public Integer getJobSignal() {
        return jobSignal;
    }

    /**
     * 设置作业信号
            0：SIG_NORMAL，正常信号
            1：SIG_KILL，杀死作业信号
            2：SIG_STOP，停止执行信号
            3：SIG_CONT，继续执行信号
     *
     * @param jobSignal 作业信号
            0：SIG_NORMAL，正常信号
            1：SIG_KILL，杀死作业信号
            2：SIG_STOP，停止执行信号
            3：SIG_CONT，继续执行信号
     */
    public void setJobSignal(Integer jobSignal) {
        this.jobSignal = jobSignal;
    }

    /**
     * 获取处理状态
            0：queueing，排队中
            1：processing，处理中
            2：finished，运行结束
     *
     * @return JOB_STATE - 处理状态
            0：queueing，排队中
            1：processing，处理中
            2：finished，运行结束
     */
    public Integer getJobState() {
        return jobState;
    }

    /**
     * 设置处理状态
            0：queueing，排队中
            1：processing，处理中
            2：finished，运行结束
     *
     * @param jobState 处理状态
            0：queueing，排队中
            1：processing，处理中
            2：finished，运行结束
     */
    public void setJobState(Integer jobState) {
        this.jobState = jobState;
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
        WfExecutionQueue other = (WfExecutionQueue) that;
        return (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
            && (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId()))
            && (this.getJobTime() == null ? other.getJobTime() == null : this.getJobTime().equals(other.getJobTime()))
            && (this.getJobSignal() == null ? other.getJobSignal() == null : this.getJobSignal().equals(other.getJobSignal()))
            && (this.getJobState() == null ? other.getJobState() == null : this.getJobState().equals(other.getJobState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getJobTime() == null) ? 0 : getJobTime().hashCode());
        result = prime * result + ((getJobSignal() == null) ? 0 : getJobSignal().hashCode());
        result = prime * result + ((getJobState() == null) ? 0 : getJobState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}