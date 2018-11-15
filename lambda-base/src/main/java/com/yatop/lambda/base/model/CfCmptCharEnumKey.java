package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "cf_cmpt_char_enum")
public class CfCmptCharEnumKey implements Serializable {
    /**
     * 特征ID
     */
    @Id
    @Column(name = "CHAR_ID")
    private String charId;

    /**
     * 枚举值代码
     */
    @Id
    @Column(name = "ENUM_CODE")
    private String enumCode;

    private static final long serialVersionUID = 1L;

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

    /**
     * 获取枚举值代码
     *
     * @return ENUM_CODE - 枚举值代码
     */
    public String getEnumCode() {
        return enumCode;
    }

    /**
     * 设置枚举值代码
     *
     * @param enumCode 枚举值代码
     */
    public void setEnumCode(String enumCode) {
        this.enumCode = enumCode == null ? null : enumCode.trim();
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
        CfCmptCharEnumKey other = (CfCmptCharEnumKey) that;
        return (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getEnumCode() == null ? other.getEnumCode() == null : this.getEnumCode().equals(other.getEnumCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        result = prime * result + ((getEnumCode() == null) ? 0 : getEnumCode().hashCode());
        return result;
    }
}