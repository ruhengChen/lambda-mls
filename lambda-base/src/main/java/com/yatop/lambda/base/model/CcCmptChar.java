package com.yatop.lambda.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cc_cmpt_char")
public class CcCmptChar implements Serializable {
    /**
     * 特征ID

输入内容规格类型
特征ID范围：IN@C-[0000 ~ 9999]

输出内容规格类型
特征ID范围：OUT@C[0000 ~ 9999]

调用执行规格类型
特征ID范围：EX@C-[0000 ~ 9999]

执行调优参数规格类型
特征ID范围：OEX@C-[0000 ~ 9999]

组件参数规格类型
所有组件通用特征ID范围：CCP@C-ALL@COM-[0000 ~ 9999]
同类组件通用特征ID范围：CCP@C-[XX]@COM-[0000 ~ 9999]
单个组件专用特征ID值组成：SCP@C-${CMPT-ID}-[00~99]
     */
    @Id
    @Column(name = "CHAR_ID")
    private String charId;

    /**
     * 特征代码
     */
    @Column(name = "CHAR_CODE")
    private String charCode;

    /**
     * 特征名称
     */
    @Column(name = "CHAR_NAME")
    private String charName;

    /**
     * 特征别名，非空时，使用特征别名替代特征代码作为参数名
     */
    @Column(name = "CHAR_ALIAS")
    private String charAlias;

    /**
     * 适用规格类型
     */
    @Column(name = "SPEC_TYPE")
    private Integer specType;

    /**
     * 特征类型ID
     */
    @Column(name = "CHAR_TYPE")
    private Integer charType;

    /**
     * 特征值来源级别
1：计算组件规格
2：计算组件
3：工作流节点（仅限组件参数、执行调优、输入输出）

注意，仅限在小于来源级别的地方做特征值设置有效，否则无效
说明，特征值选用次序工作流节点 > 计算组件 > 计算组件规格 > 特征默认值
     */
    @Column(name = "SRC_LEVEL")
    private Integer srcLevel;

    /**
     * 允许设置为全局变量
            0：否
            1：是
     */
    @Column(name = "ALLOW_GLOBAL")
    private Integer allowGlobal;

    /**
     * 特征值是否必须设置
            0：否
            1：是
     */
    @Column(name = "IS_REQUIRED")
    private Integer isRequired;

    /**
     * 特征值是否受限定
0：否
1：开区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
2：闭区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
3：左开右闭方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
4：左闭右开方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
5：枚举方式限定
     */
    @Column(name = "IS_LIMITED")
    private Integer isLimited;

    /**
     * 最大长度
            
            字符串类型：限制字符串最大长度
            JSON列表类型：限制列表最大长度
            调参类型，限制自定义用户列表最大长度
     */
    @Column(name = "MAX_LENGTH")
    private Integer maxLength;

    /**
     * 特征值步长，限数值和日期类型，日期以天为单位，时间以秒为单位
     */
    @Column(name = "STEP_SIZE")
    private String stepSize;

    /**
     * 最大特征值，未设置表示无穷小
     */
    @Column(name = "MIN_VALUE")
    private String minValue;

    /**
     * 最大特征值，未设置表示无穷大
     */
    @Column(name = "MAX_VALUE")
    private String maxValue;

    /**
     * 默认特征值
     */
    @Column(name = "DEFAULT_VALUE")
    private String defaultValue;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 状态
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
     * 获取特征ID

输入内容规格类型
特征ID范围：IN@C-[0000 ~ 9999]

输出内容规格类型
特征ID范围：OUT@C[0000 ~ 9999]

调用执行规格类型
特征ID范围：EX@C-[0000 ~ 9999]

执行调优参数规格类型
特征ID范围：OEX@C-[0000 ~ 9999]

组件参数规格类型
所有组件通用特征ID范围：CCP@C-ALL@COM-[0000 ~ 9999]
同类组件通用特征ID范围：CCP@C-[XX]@COM-[0000 ~ 9999]
单个组件专用特征ID值组成：SCP@C-${CMPT-ID}-[00~99]
     *
     * @return CHAR_ID - 特征ID

输入内容规格类型
特征ID范围：IN@C-[0000 ~ 9999]

输出内容规格类型
特征ID范围：OUT@C[0000 ~ 9999]

调用执行规格类型
特征ID范围：EX@C-[0000 ~ 9999]

执行调优参数规格类型
特征ID范围：OEX@C-[0000 ~ 9999]

组件参数规格类型
所有组件通用特征ID范围：CCP@C-ALL@COM-[0000 ~ 9999]
同类组件通用特征ID范围：CCP@C-[XX]@COM-[0000 ~ 9999]
单个组件专用特征ID值组成：SCP@C-${CMPT-ID}-[00~99]
     */
    public String getCharId() {
        return charId;
    }

    /**
     * 设置特征ID

输入内容规格类型
特征ID范围：IN@C-[0000 ~ 9999]

输出内容规格类型
特征ID范围：OUT@C[0000 ~ 9999]

调用执行规格类型
特征ID范围：EX@C-[0000 ~ 9999]

执行调优参数规格类型
特征ID范围：OEX@C-[0000 ~ 9999]

组件参数规格类型
所有组件通用特征ID范围：CCP@C-ALL@COM-[0000 ~ 9999]
同类组件通用特征ID范围：CCP@C-[XX]@COM-[0000 ~ 9999]
单个组件专用特征ID值组成：SCP@C-${CMPT-ID}-[00~99]
     *
     * @param charId 特征ID

输入内容规格类型
特征ID范围：IN@C-[0000 ~ 9999]

输出内容规格类型
特征ID范围：OUT@C[0000 ~ 9999]

调用执行规格类型
特征ID范围：EX@C-[0000 ~ 9999]

执行调优参数规格类型
特征ID范围：OEX@C-[0000 ~ 9999]

组件参数规格类型
所有组件通用特征ID范围：CCP@C-ALL@COM-[0000 ~ 9999]
同类组件通用特征ID范围：CCP@C-[XX]@COM-[0000 ~ 9999]
单个组件专用特征ID值组成：SCP@C-${CMPT-ID}-[00~99]
     */
    public void setCharId(String charId) {
        this.charId = charId == null ? null : charId.trim();
    }

    /**
     * 获取特征代码
     *
     * @return CHAR_CODE - 特征代码
     */
    public String getCharCode() {
        return charCode;
    }

    /**
     * 设置特征代码
     *
     * @param charCode 特征代码
     */
    public void setCharCode(String charCode) {
        this.charCode = charCode == null ? null : charCode.trim();
    }

    /**
     * 获取特征名称
     *
     * @return CHAR_NAME - 特征名称
     */
    public String getCharName() {
        return charName;
    }

    /**
     * 设置特征名称
     *
     * @param charName 特征名称
     */
    public void setCharName(String charName) {
        this.charName = charName == null ? null : charName.trim();
    }

    /**
     * 获取特征别名，非空时，使用特征别名替代特征代码作为参数名
     *
     * @return CHAR_ALIAS - 特征别名，非空时，使用特征别名替代特征代码作为参数名
     */
    public String getCharAlias() {
        return charAlias;
    }

    /**
     * 设置特征别名，非空时，使用特征别名替代特征代码作为参数名
     *
     * @param charAlias 特征别名，非空时，使用特征别名替代特征代码作为参数名
     */
    public void setCharAlias(String charAlias) {
        this.charAlias = charAlias == null ? null : charAlias.trim();
    }

    /**
     * 获取适用规格类型
     *
     * @return SPEC_TYPE - 适用规格类型
     */
    public Integer getSpecType() {
        return specType;
    }

    /**
     * 设置适用规格类型
     *
     * @param specType 适用规格类型
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
    }

    /**
     * 获取特征类型ID
     *
     * @return CHAR_TYPE - 特征类型ID
     */
    public Integer getCharType() {
        return charType;
    }

    /**
     * 设置特征类型ID
     *
     * @param charType 特征类型ID
     */
    public void setCharType(Integer charType) {
        this.charType = charType;
    }

    /**
     * 获取特征值来源级别
1：计算组件规格
2：计算组件
3：工作流节点（仅限组件参数、执行调优、输入输出）

注意，仅限在小于来源级别的地方做特征值设置有效，否则无效
说明，特征值选用次序工作流节点 > 计算组件 > 计算组件规格 > 特征默认值
     *
     * @return SRC_LEVEL - 特征值来源级别
1：计算组件规格
2：计算组件
3：工作流节点（仅限组件参数、执行调优、输入输出）

注意，仅限在小于来源级别的地方做特征值设置有效，否则无效
说明，特征值选用次序工作流节点 > 计算组件 > 计算组件规格 > 特征默认值
     */
    public Integer getSrcLevel() {
        return srcLevel;
    }

    /**
     * 设置特征值来源级别
1：计算组件规格
2：计算组件
3：工作流节点（仅限组件参数、执行调优、输入输出）

注意，仅限在小于来源级别的地方做特征值设置有效，否则无效
说明，特征值选用次序工作流节点 > 计算组件 > 计算组件规格 > 特征默认值
     *
     * @param srcLevel 特征值来源级别
1：计算组件规格
2：计算组件
3：工作流节点（仅限组件参数、执行调优、输入输出）

注意，仅限在小于来源级别的地方做特征值设置有效，否则无效
说明，特征值选用次序工作流节点 > 计算组件 > 计算组件规格 > 特征默认值
     */
    public void setSrcLevel(Integer srcLevel) {
        this.srcLevel = srcLevel;
    }

    /**
     * 获取允许设置为全局变量
            0：否
            1：是
     *
     * @return ALLOW_GLOBAL - 允许设置为全局变量
            0：否
            1：是
     */
    public Integer getAllowGlobal() {
        return allowGlobal;
    }

    /**
     * 设置允许设置为全局变量
            0：否
            1：是
     *
     * @param allowGlobal 允许设置为全局变量
            0：否
            1：是
     */
    public void setAllowGlobal(Integer allowGlobal) {
        this.allowGlobal = allowGlobal;
    }

    /**
     * 获取特征值是否必须设置
            0：否
            1：是
     *
     * @return IS_REQUIRED - 特征值是否必须设置
            0：否
            1：是
     */
    public Integer getIsRequired() {
        return isRequired;
    }

    /**
     * 设置特征值是否必须设置
            0：否
            1：是
     *
     * @param isRequired 特征值是否必须设置
            0：否
            1：是
     */
    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    /**
     * 获取特征值是否受限定
0：否
1：开区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
2：闭区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
3：左开右闭方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
4：左闭右开方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
5：枚举方式限定
     *
     * @return IS_LIMITED - 特征值是否受限定
0：否
1：开区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
2：闭区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
3：左开右闭方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
4：左闭右开方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
5：枚举方式限定
     */
    public Integer getIsLimited() {
        return isLimited;
    }

    /**
     * 设置特征值是否受限定
0：否
1：开区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
2：闭区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
3：左开右闭方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
4：左闭右开方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
5：枚举方式限定
     *
     * @param isLimited 特征值是否受限定
0：否
1：开区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
2：闭区间方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
3：左开右闭方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
4：左闭右开方式限定，限数值和日期类型，结合最大值和最小值构成区间范围
5：枚举方式限定
     */
    public void setIsLimited(Integer isLimited) {
        this.isLimited = isLimited;
    }

    /**
     * 获取最大长度
            
            字符串类型：限制字符串最大长度
            JSON列表类型：限制列表最大长度
            调参类型，限制自定义用户列表最大长度
     *
     * @return MAX_LENGTH - 最大长度
            
            字符串类型：限制字符串最大长度
            JSON列表类型：限制列表最大长度
            调参类型，限制自定义用户列表最大长度
     */
    public Integer getMaxLength() {
        return maxLength;
    }

    /**
     * 设置最大长度
            
            字符串类型：限制字符串最大长度
            JSON列表类型：限制列表最大长度
            调参类型，限制自定义用户列表最大长度
     *
     * @param maxLength 最大长度
            
            字符串类型：限制字符串最大长度
            JSON列表类型：限制列表最大长度
            调参类型，限制自定义用户列表最大长度
     */
    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * 获取特征值步长，限数值和日期类型，日期以天为单位，时间以秒为单位
     *
     * @return STEP_SIZE - 特征值步长，限数值和日期类型，日期以天为单位，时间以秒为单位
     */
    public String getStepSize() {
        return stepSize;
    }

    /**
     * 设置特征值步长，限数值和日期类型，日期以天为单位，时间以秒为单位
     *
     * @param stepSize 特征值步长，限数值和日期类型，日期以天为单位，时间以秒为单位
     */
    public void setStepSize(String stepSize) {
        this.stepSize = stepSize == null ? null : stepSize.trim();
    }

    /**
     * 获取最大特征值，未设置表示无穷小
     *
     * @return MIN_VALUE - 最大特征值，未设置表示无穷小
     */
    public String getMinValue() {
        return minValue;
    }

    /**
     * 设置最大特征值，未设置表示无穷小
     *
     * @param minValue 最大特征值，未设置表示无穷小
     */
    public void setMinValue(String minValue) {
        this.minValue = minValue == null ? null : minValue.trim();
    }

    /**
     * 获取最大特征值，未设置表示无穷大
     *
     * @return MAX_VALUE - 最大特征值，未设置表示无穷大
     */
    public String getMaxValue() {
        return maxValue;
    }

    /**
     * 设置最大特征值，未设置表示无穷大
     *
     * @param maxValue 最大特征值，未设置表示无穷大
     */
    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue == null ? null : maxValue.trim();
    }

    /**
     * 获取默认特征值
     *
     * @return DEFAULT_VALUE - 默认特征值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 设置默认特征值
     *
     * @param defaultValue 默认特征值
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
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
     * 获取状态
            0：正常
            1：失效
     *
     * @return STATUS - 状态
            0：正常
            1：失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
            0：正常
            1：失效
     *
     * @param status 状态
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
        CcCmptChar other = (CcCmptChar) that;
        return (this.getCharId() == null ? other.getCharId() == null : this.getCharId().equals(other.getCharId()))
            && (this.getCharCode() == null ? other.getCharCode() == null : this.getCharCode().equals(other.getCharCode()))
            && (this.getCharName() == null ? other.getCharName() == null : this.getCharName().equals(other.getCharName()))
            && (this.getCharAlias() == null ? other.getCharAlias() == null : this.getCharAlias().equals(other.getCharAlias()))
            && (this.getSpecType() == null ? other.getSpecType() == null : this.getSpecType().equals(other.getSpecType()))
            && (this.getCharType() == null ? other.getCharType() == null : this.getCharType().equals(other.getCharType()))
            && (this.getSrcLevel() == null ? other.getSrcLevel() == null : this.getSrcLevel().equals(other.getSrcLevel()))
            && (this.getAllowGlobal() == null ? other.getAllowGlobal() == null : this.getAllowGlobal().equals(other.getAllowGlobal()))
            && (this.getIsRequired() == null ? other.getIsRequired() == null : this.getIsRequired().equals(other.getIsRequired()))
            && (this.getIsLimited() == null ? other.getIsLimited() == null : this.getIsLimited().equals(other.getIsLimited()))
            && (this.getMaxLength() == null ? other.getMaxLength() == null : this.getMaxLength().equals(other.getMaxLength()))
            && (this.getStepSize() == null ? other.getStepSize() == null : this.getStepSize().equals(other.getStepSize()))
            && (this.getMinValue() == null ? other.getMinValue() == null : this.getMinValue().equals(other.getMinValue()))
            && (this.getMaxValue() == null ? other.getMaxValue() == null : this.getMaxValue().equals(other.getMaxValue()))
            && (this.getDefaultValue() == null ? other.getDefaultValue() == null : this.getDefaultValue().equals(other.getDefaultValue()))
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
        result = prime * result + ((getCharId() == null) ? 0 : getCharId().hashCode());
        result = prime * result + ((getCharCode() == null) ? 0 : getCharCode().hashCode());
        result = prime * result + ((getCharName() == null) ? 0 : getCharName().hashCode());
        result = prime * result + ((getCharAlias() == null) ? 0 : getCharAlias().hashCode());
        result = prime * result + ((getSpecType() == null) ? 0 : getSpecType().hashCode());
        result = prime * result + ((getCharType() == null) ? 0 : getCharType().hashCode());
        result = prime * result + ((getSrcLevel() == null) ? 0 : getSrcLevel().hashCode());
        result = prime * result + ((getAllowGlobal() == null) ? 0 : getAllowGlobal().hashCode());
        result = prime * result + ((getIsRequired() == null) ? 0 : getIsRequired().hashCode());
        result = prime * result + ((getIsLimited() == null) ? 0 : getIsLimited().hashCode());
        result = prime * result + ((getMaxLength() == null) ? 0 : getMaxLength().hashCode());
        result = prime * result + ((getStepSize() == null) ? 0 : getStepSize().hashCode());
        result = prime * result + ((getMinValue() == null) ? 0 : getMinValue().hashCode());
        result = prime * result + ((getMaxValue() == null) ? 0 : getMaxValue().hashCode());
        result = prime * result + ((getDefaultValue() == null) ? 0 : getDefaultValue().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }
}