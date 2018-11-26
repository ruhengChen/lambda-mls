package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "cc_cmpt_spec_rel")
public class CcCmptSpecRelKey implements Serializable {
    /**
     * 组件ID
     */
    @Id
    @Column(name = "CMPT_ID")
    private String cmptId;

    /**
     * 组件规格类型
     */
    @Id
    @Column(name = "SPEC_TYPE")
    private Integer specType;

    private static final long serialVersionUID = 1L;

    /**
     * 获取组件ID
     *
     * @return CMPT_ID - 组件ID
     */
    public String getCmptId() {
        return cmptId;
    }

    /**
     * 设置组件ID
     *
     * @param cmptId 组件ID
     */
    public void setCmptId(String cmptId) {
        this.cmptId = cmptId == null ? null : cmptId.trim();
    }

    /**
     * 获取组件规格类型
     *
     * @return SPEC_TYPE - 组件规格类型
     */
    public Integer getSpecType() {
        return specType;
    }

    /**
     * 设置组件规格类型
     *
     * @param specType 组件规格类型
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
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
        CcCmptSpecRelKey other = (CcCmptSpecRelKey) that;
        return (this.getCmptId() == null ? other.getCmptId() == null : this.getCmptId().equals(other.getCmptId()))
            && (this.getSpecType() == null ? other.getSpecType() == null : this.getSpecType().equals(other.getSpecType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCmptId() == null) ? 0 : getCmptId().hashCode());
        result = prime * result + ((getSpecType() == null) ? 0 : getSpecType().hashCode());
        return result;
    }
}