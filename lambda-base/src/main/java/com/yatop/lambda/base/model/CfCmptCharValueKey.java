package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "cf_cmpt_char_value")
public class CfCmptCharValueKey implements Serializable {
    /**
     * 组件ID
     */
    @Id
    @Column(name = "CMPT_ID")
    private String cmptId;

    /**
     * 特征ID
     */
    @Id
    @Column(name = "CHAR_ID")
    private String charId;

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
     * 获取特征ID
     *
     * @return CHAR_ID - 特征ID
     */
    public String getCharId() {
        return charId;
    }

    /**
     * 设置特征ID
     *
     * @param charId 特征ID
     */
    public void setCharId(String charId) {
        this.charId = charId == null ? null : charId.trim();
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
        CfCmptCharValueKey other = (CfCmptCharValueKey) that;
        return (this.getCmptId() == null ? other.getCmptId() == null : this.getCmptId().equals(other.getCmptId()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCmptId() == null) ? 0 : getCmptId().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        return result;
    }
}