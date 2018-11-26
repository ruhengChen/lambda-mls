package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "cc_cmpt_char_type_combine")
public class CcCmptCharTypeCombineKey implements Serializable {
    /**
     * 组合特征类型ID
     */
    @Id
    @Column(name = "COMBINE_CHAR_TYPE_ID")
    private Integer combineCharTypeId;

    /**
     * 成员特征类型ID
     */
    @Id
    @Column(name = "MEMEBER_CHAR_TYPE_ID")
    private Integer memeberCharTypeId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取组合特征类型ID
     *
     * @return COMBINE_CHAR_TYPE_ID - 组合特征类型ID
     */
    public Integer getCombineCharTypeId() {
        return combineCharTypeId;
    }

    /**
     * 设置组合特征类型ID
     *
     * @param combineCharTypeId 组合特征类型ID
     */
    public void setCombineCharTypeId(Integer combineCharTypeId) {
        this.combineCharTypeId = combineCharTypeId;
    }

    /**
     * 获取成员特征类型ID
     *
     * @return MEMEBER_CHAR_TYPE_ID - 成员特征类型ID
     */
    public Integer getMemeberCharTypeId() {
        return memeberCharTypeId;
    }

    /**
     * 设置成员特征类型ID
     *
     * @param memeberCharTypeId 成员特征类型ID
     */
    public void setMemeberCharTypeId(Integer memeberCharTypeId) {
        this.memeberCharTypeId = memeberCharTypeId;
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
        CcCmptCharTypeCombineKey other = (CcCmptCharTypeCombineKey) that;
        return (this.getCombineCharTypeId() == null ? other.getCombineCharTypeId() == null : this.getCombineCharTypeId().equals(other.getCombineCharTypeId()))
            && (this.getMemeberCharTypeId() == null ? other.getMemeberCharTypeId() == null : this.getMemeberCharTypeId().equals(other.getMemeberCharTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCombineCharTypeId() == null) ? 0 : getCombineCharTypeId().hashCode());
        result = prime * result + ((getMemeberCharTypeId() == null) ? 0 : getMemeberCharTypeId().hashCode());
        return result;
    }
}