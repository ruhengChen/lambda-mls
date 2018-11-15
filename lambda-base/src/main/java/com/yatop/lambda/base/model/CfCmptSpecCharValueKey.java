package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "cf_cmpt_spec_char_value")
public class CfCmptSpecCharValueKey implements Serializable {
    /**
     * 规格ID
     */
    @Id
    @Column(name = "SPEC_ID")
    private String specId;

    /**
     * 特征ID
     */
    @Id
    @Column(name = "CHAR_ID")
    private String charId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取规格ID
     *
     * @return SPEC_ID - 规格ID
     */
    public String getSpecId() {
        return specId;
    }

    /**
     * 设置规格ID
     *
     * @param specId 规格ID
     */
    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
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
        CfCmptSpecCharValueKey other = (CfCmptSpecCharValueKey) that;
        return (this.getSpecId() == null ? other.getSpecId() == null : this.getSpecId().equals(other.getSpecId()))
            && (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpecId() == null) ? 0 : getSpecId().hashCode());
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        return result;
    }
}