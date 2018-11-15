package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wf_module_port")
public class WfModulePort implements Serializable {
    /**
     * 端口ID，组件的同一类型端口数最多6个
            端口ID值组成：工作流组件ID * 100 + 一位节点端口类型 * 10 + 一位端口序号
     */
    @Id
    @Column(name = "PORT_ID")
    private Long portId;

    /**
     * 端口名称
     */
    @Column(name = "PORT_NAME")
    private String portName;

    /**
     * 端口类型
            0：输入端口
            1：输出端口
     */
    @Column(name = "PORT_TYPE")
    private Integer portType;

    /**
     * 所属工作流组件ID
     */
    @Column(name = "OWNER_MODULE_ID")
    private Long ownerModuleId;

    /**
     * 绑定计算组件输入输出特征ID，SPEC_TYPE in （0, 1）
     */
    @Column(name = "BIND_CHAR_ID")
    private String bindCharId;

    /**
     * 端口序号
     */
    @Column(name = "SEQUENCE")
    private Integer sequence;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 端口状态
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
     * 获取端口ID，组件的同一类型端口数最多6个
            端口ID值组成：工作流组件ID * 100 + 一位节点端口类型 * 10 + 一位端口序号
     *
     * @return PORT_ID - 端口ID，组件的同一类型端口数最多6个
            端口ID值组成：工作流组件ID * 100 + 一位节点端口类型 * 10 + 一位端口序号
     */
    public Long getPortId() {
        return portId;
    }

    /**
     * 设置端口ID，组件的同一类型端口数最多6个
            端口ID值组成：工作流组件ID * 100 + 一位节点端口类型 * 10 + 一位端口序号
     *
     * @param portId 端口ID，组件的同一类型端口数最多6个
            端口ID值组成：工作流组件ID * 100 + 一位节点端口类型 * 10 + 一位端口序号
     */
    public void setPortId(Long portId) {
        this.portId = portId;
    }

    /**
     * 获取端口名称
     *
     * @return PORT_NAME - 端口名称
     */
    public String getPortName() {
        return portName;
    }

    /**
     * 设置端口名称
     *
     * @param portName 端口名称
     */
    public void setPortName(String portName) {
        this.portName = portName == null ? null : portName.trim();
    }

    /**
     * 获取端口类型
            0：输入端口
            1：输出端口
     *
     * @return PORT_TYPE - 端口类型
            0：输入端口
            1：输出端口
     */
    public Integer getPortType() {
        return portType;
    }

    /**
     * 设置端口类型
            0：输入端口
            1：输出端口
     *
     * @param portType 端口类型
            0：输入端口
            1：输出端口
     */
    public void setPortType(Integer portType) {
        this.portType = portType;
    }

    /**
     * 获取所属工作流组件ID
     *
     * @return OWNER_MODULE_ID - 所属工作流组件ID
     */
    public Long getOwnerModuleId() {
        return ownerModuleId;
    }

    /**
     * 设置所属工作流组件ID
     *
     * @param ownerModuleId 所属工作流组件ID
     */
    public void setOwnerModuleId(Long ownerModuleId) {
        this.ownerModuleId = ownerModuleId;
    }

    /**
     * 获取绑定计算组件输入输出特征ID，SPEC_TYPE in （0, 1）
     *
     * @return BIND_CHAR_ID - 绑定计算组件输入输出特征ID，SPEC_TYPE in （0, 1）
     */
    public String getBindCharId() {
        return bindCharId;
    }

    /**
     * 设置绑定计算组件输入输出特征ID，SPEC_TYPE in （0, 1）
     *
     * @param bindCharId 绑定计算组件输入输出特征ID，SPEC_TYPE in （0, 1）
     */
    public void setBindCharId(String bindCharId) {
        this.bindCharId = bindCharId == null ? null : bindCharId.trim();
    }

    /**
     * 获取端口序号
     *
     * @return SEQUENCE - 端口序号
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置端口序号
     *
     * @param sequence 端口序号
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
     * 获取端口状态
            0：正常
            1：失效
     *
     * @return STATUS - 端口状态
            0：正常
            1：失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置端口状态
            0：正常
            1：失效
     *
     * @param status 端口状态
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
        WfModulePort other = (WfModulePort) that;
        return (this.getPortId() == null ? other.getPortId() == null : this.getPortId().equals(other.getPortId()))
            && (this.getPortName() == null ? other.getPortName() == null : this.getPortName().equals(other.getPortName()))
            && (this.getPortType() == null ? other.getPortType() == null : this.getPortType().equals(other.getPortType()))
            && (this.getOwnerModuleId() == null ? other.getOwnerModuleId() == null : this.getOwnerModuleId().equals(other.getOwnerModuleId()))
            && (this.getBindCharId() == null ? other.getBindCharId() == null : this.getBindCharId().equals(other.getBindCharId()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
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
        result = prime * result + ((getPortId() == null) ? 0 : getPortId().hashCode());
        result = prime * result + ((getPortName() == null) ? 0 : getPortName().hashCode());
        result = prime * result + ((getPortType() == null) ? 0 : getPortType().hashCode());
        result = prime * result + ((getOwnerModuleId() == null) ? 0 : getOwnerModuleId().hashCode());
        result = prime * result + ((getBindCharId() == null) ? 0 : getBindCharId().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}