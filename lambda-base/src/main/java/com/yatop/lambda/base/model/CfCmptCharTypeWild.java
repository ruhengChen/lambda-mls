package com.yatop.lambda.base.model;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.base.utils.LambdaRootModel;
import java.io.Serializable;
import java.util.Date;

public class CfCmptCharTypeWild extends LambdaRootModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private Integer wildCharTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private boolean wildCharTypeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private Integer matchCharTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private boolean matchCharTypeIdColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.DESCRIPTION
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private boolean descriptionColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.STATUS
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private boolean statusColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private Date lastUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private boolean lastUpdateTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private String lastUpdateOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private boolean lastUpdateOperColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.CREATE_TIME
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private boolean createTimeColoured;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.CREATE_OPER
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private String createOper;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cf_cmpt_char_type_wild.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private boolean createOperColoured;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID
     *
     * @return the value of cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public Integer getWildCharTypeId() {
        return wildCharTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isWildCharTypeIdColoured() {
        return wildCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isWildCharTypeIdNotColoured() {
        return !wildCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID
     *
     * @param wildCharTypeId the value for cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setWildCharTypeId(Integer wildCharTypeId) {
        this.wildCharTypeId = wildCharTypeId;
        this.wildCharTypeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID:Coloured
     *
     * @param wildCharTypeIdColoured the value for cf_cmpt_char_type_wild.WILD_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setWildCharTypeIdColoured(boolean wildCharTypeIdColoured) {
        this.wildCharTypeIdColoured = wildCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID
     *
     * @return the value of cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public Integer getMatchCharTypeId() {
        return matchCharTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isMatchCharTypeIdColoured() {
        return matchCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isMatchCharTypeIdNotColoured() {
        return !matchCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID
     *
     * @param matchCharTypeId the value for cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setMatchCharTypeId(Integer matchCharTypeId) {
        this.matchCharTypeId = matchCharTypeId;
        this.matchCharTypeIdColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID:Coloured
     *
     * @param matchCharTypeIdColoured the value for cf_cmpt_char_type_wild.MATCH_CHAR_TYPE_ID:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setMatchCharTypeIdColoured(boolean matchCharTypeIdColoured) {
        this.matchCharTypeIdColoured = matchCharTypeIdColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.DESCRIPTION
     *
     * @return the value of cf_cmpt_char_type_wild.DESCRIPTION
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.DESCRIPTION:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isDescriptionColoured() {
        return descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.DESCRIPTION:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isDescriptionNotColoured() {
        return !descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.DESCRIPTION
     *
     * @param description the value for cf_cmpt_char_type_wild.DESCRIPTION
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
        this.descriptionColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.DESCRIPTION:Coloured
     *
     * @param descriptionColoured the value for cf_cmpt_char_type_wild.DESCRIPTION:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setDescriptionColoured(boolean descriptionColoured) {
        this.descriptionColoured = descriptionColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.STATUS
     *
     * @return the value of cf_cmpt_char_type_wild.STATUS
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.STATUS:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isStatusColoured() {
        return statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.STATUS:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isStatusNotColoured() {
        return !statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.STATUS
     *
     * @param status the value for cf_cmpt_char_type_wild.STATUS
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
        this.statusColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.STATUS:Coloured
     *
     * @param statusColoured the value for cf_cmpt_char_type_wild.STATUS:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setStatusColoured(boolean statusColoured) {
        this.statusColoured = statusColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.LAST_UPDATE_TIME
     *
     * @return the value of cf_cmpt_char_type_wild.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isLastUpdateTimeColoured() {
        return lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isLastUpdateTimeNotColoured() {
        return !lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for cf_cmpt_char_type_wild.LAST_UPDATE_TIME
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @param lastUpdateTimeColoured the value for cf_cmpt_char_type_wild.LAST_UPDATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setLastUpdateTimeColoured(boolean lastUpdateTimeColoured) {
        this.lastUpdateTimeColoured = lastUpdateTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.LAST_UPDATE_OPER
     *
     * @return the value of cf_cmpt_char_type_wild.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isLastUpdateOperColoured() {
        return lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isLastUpdateOperNotColoured() {
        return !lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.LAST_UPDATE_OPER
     *
     * @param lastUpdateOper the value for cf_cmpt_char_type_wild.LAST_UPDATE_OPER
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
        this.lastUpdateOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @param lastUpdateOperColoured the value for cf_cmpt_char_type_wild.LAST_UPDATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setLastUpdateOperColoured(boolean lastUpdateOperColoured) {
        this.lastUpdateOperColoured = lastUpdateOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.CREATE_TIME
     *
     * @return the value of cf_cmpt_char_type_wild.CREATE_TIME
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.CREATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isCreateTimeColoured() {
        return createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.CREATE_TIME:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isCreateTimeNotColoured() {
        return !createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.CREATE_TIME
     *
     * @param createTime the value for cf_cmpt_char_type_wild.CREATE_TIME
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.CREATE_TIME:Coloured
     *
     * @param createTimeColoured the value for cf_cmpt_char_type_wild.CREATE_TIME:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setCreateTimeColoured(boolean createTimeColoured) {
        this.createTimeColoured = createTimeColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.CREATE_OPER
     *
     * @return the value of cf_cmpt_char_type_wild.CREATE_OPER
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.CREATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isCreateOperColoured() {
        return createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cf_cmpt_char_type_wild.CREATE_OPER:Coloured
     *
     * @return the value of cf_cmpt_char_type_wild.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public boolean isCreateOperNotColoured() {
        return !createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.CREATE_OPER
     *
     * @param createOper the value for cf_cmpt_char_type_wild.CREATE_OPER
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
        this.createOperColoured = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cf_cmpt_char_type_wild.CREATE_OPER:Coloured
     *
     * @param createOperColoured the value for cf_cmpt_char_type_wild.CREATE_OPER:Coloured
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void setCreateOperColoured(boolean createOperColoured) {
        this.createOperColoured = createOperColoured;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
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
        CfCmptCharTypeWild other = (CfCmptCharTypeWild) that;
        return (this.getWildCharTypeId() == null ? other.getWildCharTypeId() == null : this.getWildCharTypeId().equals(other.getWildCharTypeId()))
            && (this.getMatchCharTypeId() == null ? other.getMatchCharTypeId() == null : this.getMatchCharTypeId().equals(other.getMatchCharTypeId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateOper() == null ? other.getLastUpdateOper() == null : this.getLastUpdateOper().equals(other.getLastUpdateOper()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateOper() == null ? other.getCreateOper() == null : this.getCreateOper().equals(other.getCreateOper()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWildCharTypeId() == null) ? 0 : getWildCharTypeId().hashCode());
        result = prime * result + ((getMatchCharTypeId() == null) ? 0 : getMatchCharTypeId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateOper() == null) ? 0 : getLastUpdateOper().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateOper() == null) ? 0 : getCreateOper().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    public void copyProperties(CfCmptCharTypeWild that) {
        if (this == that || that == null) {
            return;
        }
        if(that.isWildCharTypeIdColoured() ) {this.setWildCharTypeId(that.getWildCharTypeId() );}
        if(that.isMatchCharTypeIdColoured() ) {this.setMatchCharTypeId(that.getMatchCharTypeId() );}
        if(that.isDescriptionColoured() ) {this.setDescription(that.getDescription() );}
        if(that.isStatusColoured() ) {this.setStatus(that.getStatus() );}
        if(that.isLastUpdateTimeColoured() ) {this.setLastUpdateTime(that.getLastUpdateTime() );}
        if(that.isLastUpdateOperColoured() ) {this.setLastUpdateOper(that.getLastUpdateOper() );}
        if(that.isCreateTimeColoured() ) {this.setCreateTime(that.getCreateTime() );}
        if(that.isCreateOperColoured() ) {this.setCreateOper(that.getCreateOper() );}
        return;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject(32, true);
        if(this.wildCharTypeIdColoured) {jsonObj.put("wildCharTypeId", this.wildCharTypeId);}
        if(this.matchCharTypeIdColoured) {jsonObj.put("matchCharTypeId", this.matchCharTypeId);}
        if(this.descriptionColoured) {jsonObj.put("description", this.description);}
        if(this.statusColoured) {jsonObj.put("status", this.status);}
        if(this.lastUpdateTimeColoured) {jsonObj.put("lastUpdateTime", this.lastUpdateTime);}
        if(this.lastUpdateOperColoured) {jsonObj.put("lastUpdateOper", this.lastUpdateOper);}
        if(this.createTimeColoured) {jsonObj.put("createTime", this.createTime);}
        if(this.createOperColoured) {jsonObj.put("createOper", this.createOper);}
        return jsonObj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 17 01:50:09 CST 2018
     */
    @Override
    public void clear() {
         this.wildCharTypeId = null; this.wildCharTypeIdColoured = false;
         this.matchCharTypeId = null; this.matchCharTypeIdColoured = false;
         this.description = null; this.descriptionColoured = false;
         this.status = null; this.statusColoured = false;
         this.lastUpdateTime = null; this.lastUpdateTimeColoured = false;
         this.lastUpdateOper = null; this.lastUpdateOperColoured = false;
         this.createTime = null; this.createTimeColoured = false;
         this.createOper = null; this.createOperColoured = false;
        return;
    }
}