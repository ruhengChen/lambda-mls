package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "cc_cmpt_char_enum")
public class CcCmptCharEnumKey implements Serializable {
    /**
     * 特征ID
     */
    @Id
    @Column(name = "CHAR_ID")
    private String charId;

    /**
     * 枚举值名称
     */
    @Id
    @Column(name = "ENUM_NAME")
    private String enumName;

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
     * 获取枚举值名称
     *
     * @return ENUM_NAME - 枚举值名称
     */
    public String getEnumName() {
        return enumName;
    }

    /**
     * 设置枚举值名称
     *
     * @param enumName 枚举值名称
     */
    public void setEnumName(String enumName) {
        this.enumName = enumName == null ? null : enumName.trim();
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
        CcCmptCharEnumKey other = (CcCmptCharEnumKey) that;
        return (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getEnumName() == null ? other.getEnumName() == null : this.getEnumName().equals(other.getEnumName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        result = prime * result + ((getEnumName() == null) ? 0 : getEnumName().hashCode());
        return result;
    }
}