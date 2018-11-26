package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MwModelWarehouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public MwModelWarehouseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMwIdIsNull() {
            addCriterion("MW_ID is null");
            return (Criteria) this;
        }

        public Criteria andMwIdIsNotNull() {
            addCriterion("MW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMwIdEqualTo(Long value) {
            addCriterion("MW_ID =", value, "mwId");
            return (Criteria) this;
        }

        public Criteria andMwIdNotEqualTo(Long value) {
            addCriterion("MW_ID <>", value, "mwId");
            return (Criteria) this;
        }

        public Criteria andMwIdGreaterThan(Long value) {
            addCriterion("MW_ID >", value, "mwId");
            return (Criteria) this;
        }

        public Criteria andMwIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MW_ID >=", value, "mwId");
            return (Criteria) this;
        }

        public Criteria andMwIdLessThan(Long value) {
            addCriterion("MW_ID <", value, "mwId");
            return (Criteria) this;
        }

        public Criteria andMwIdLessThanOrEqualTo(Long value) {
            addCriterion("MW_ID <=", value, "mwId");
            return (Criteria) this;
        }

        public Criteria andMwIdIn(List<Long> values) {
            addCriterion("MW_ID in", values, "mwId");
            return (Criteria) this;
        }

        public Criteria andMwIdNotIn(List<Long> values) {
            addCriterion("MW_ID not in", values, "mwId");
            return (Criteria) this;
        }

        public Criteria andMwIdBetween(Long value1, Long value2) {
            addCriterion("MW_ID between", value1, value2, "mwId");
            return (Criteria) this;
        }

        public Criteria andMwIdNotBetween(Long value1, Long value2) {
            addCriterion("MW_ID not between", value1, value2, "mwId");
            return (Criteria) this;
        }

        public Criteria andMwCodeIsNull() {
            addCriterion("MW_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMwCodeIsNotNull() {
            addCriterion("MW_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMwCodeEqualTo(String value) {
            addCriterion("MW_CODE =", value, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeNotEqualTo(String value) {
            addCriterion("MW_CODE <>", value, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeGreaterThan(String value) {
            addCriterion("MW_CODE >", value, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MW_CODE >=", value, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeLessThan(String value) {
            addCriterion("MW_CODE <", value, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeLessThanOrEqualTo(String value) {
            addCriterion("MW_CODE <=", value, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeLike(String value) {
            addCriterion("MW_CODE like", value, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeNotLike(String value) {
            addCriterion("MW_CODE not like", value, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeIn(List<String> values) {
            addCriterion("MW_CODE in", values, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeNotIn(List<String> values) {
            addCriterion("MW_CODE not in", values, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeBetween(String value1, String value2) {
            addCriterion("MW_CODE between", value1, value2, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwCodeNotBetween(String value1, String value2) {
            addCriterion("MW_CODE not between", value1, value2, "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwNameIsNull() {
            addCriterion("MW_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMwNameIsNotNull() {
            addCriterion("MW_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMwNameEqualTo(String value) {
            addCriterion("MW_NAME =", value, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameNotEqualTo(String value) {
            addCriterion("MW_NAME <>", value, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameGreaterThan(String value) {
            addCriterion("MW_NAME >", value, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameGreaterThanOrEqualTo(String value) {
            addCriterion("MW_NAME >=", value, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameLessThan(String value) {
            addCriterion("MW_NAME <", value, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameLessThanOrEqualTo(String value) {
            addCriterion("MW_NAME <=", value, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameLike(String value) {
            addCriterion("MW_NAME like", value, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameNotLike(String value) {
            addCriterion("MW_NAME not like", value, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameIn(List<String> values) {
            addCriterion("MW_NAME in", values, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameNotIn(List<String> values) {
            addCriterion("MW_NAME not in", values, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameBetween(String value1, String value2) {
            addCriterion("MW_NAME between", value1, value2, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwNameNotBetween(String value1, String value2) {
            addCriterion("MW_NAME not between", value1, value2, "mwName");
            return (Criteria) this;
        }

        public Criteria andMwTypeIsNull() {
            addCriterion("MW_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMwTypeIsNotNull() {
            addCriterion("MW_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMwTypeEqualTo(Integer value) {
            addCriterion("MW_TYPE =", value, "mwType");
            return (Criteria) this;
        }

        public Criteria andMwTypeNotEqualTo(Integer value) {
            addCriterion("MW_TYPE <>", value, "mwType");
            return (Criteria) this;
        }

        public Criteria andMwTypeGreaterThan(Integer value) {
            addCriterion("MW_TYPE >", value, "mwType");
            return (Criteria) this;
        }

        public Criteria andMwTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MW_TYPE >=", value, "mwType");
            return (Criteria) this;
        }

        public Criteria andMwTypeLessThan(Integer value) {
            addCriterion("MW_TYPE <", value, "mwType");
            return (Criteria) this;
        }

        public Criteria andMwTypeLessThanOrEqualTo(Integer value) {
            addCriterion("MW_TYPE <=", value, "mwType");
            return (Criteria) this;
        }

        public Criteria andMwTypeIn(List<Integer> values) {
            addCriterion("MW_TYPE in", values, "mwType");
            return (Criteria) this;
        }

        public Criteria andMwTypeNotIn(List<Integer> values) {
            addCriterion("MW_TYPE not in", values, "mwType");
            return (Criteria) this;
        }

        public Criteria andMwTypeBetween(Integer value1, Integer value2) {
            addCriterion("MW_TYPE between", value1, value2, "mwType");
            return (Criteria) this;
        }

        public Criteria andMwTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("MW_TYPE not between", value1, value2, "mwType");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdIsNull() {
            addCriterion("OWNER_PROJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdIsNotNull() {
            addCriterion("OWNER_PROJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdEqualTo(Long value) {
            addCriterion("OWNER_PROJECT_ID =", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdNotEqualTo(Long value) {
            addCriterion("OWNER_PROJECT_ID <>", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdGreaterThan(Long value) {
            addCriterion("OWNER_PROJECT_ID >", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OWNER_PROJECT_ID >=", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdLessThan(Long value) {
            addCriterion("OWNER_PROJECT_ID <", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("OWNER_PROJECT_ID <=", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdIn(List<Long> values) {
            addCriterion("OWNER_PROJECT_ID in", values, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdNotIn(List<Long> values) {
            addCriterion("OWNER_PROJECT_ID not in", values, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdBetween(Long value1, Long value2) {
            addCriterion("OWNER_PROJECT_ID between", value1, value2, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("OWNER_PROJECT_ID not between", value1, value2, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirIsNull() {
            addCriterion("MODEL_DFS_DIR is null");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirIsNotNull() {
            addCriterion("MODEL_DFS_DIR is not null");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirEqualTo(String value) {
            addCriterion("MODEL_DFS_DIR =", value, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirNotEqualTo(String value) {
            addCriterion("MODEL_DFS_DIR <>", value, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirGreaterThan(String value) {
            addCriterion("MODEL_DFS_DIR >", value, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_DFS_DIR >=", value, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirLessThan(String value) {
            addCriterion("MODEL_DFS_DIR <", value, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirLessThanOrEqualTo(String value) {
            addCriterion("MODEL_DFS_DIR <=", value, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirLike(String value) {
            addCriterion("MODEL_DFS_DIR like", value, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirNotLike(String value) {
            addCriterion("MODEL_DFS_DIR not like", value, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirIn(List<String> values) {
            addCriterion("MODEL_DFS_DIR in", values, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirNotIn(List<String> values) {
            addCriterion("MODEL_DFS_DIR not in", values, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirBetween(String value1, String value2) {
            addCriterion("MODEL_DFS_DIR between", value1, value2, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirNotBetween(String value1, String value2) {
            addCriterion("MODEL_DFS_DIR not between", value1, value2, "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirIsNull() {
            addCriterion("MODEL_LOCAL_DIR is null");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirIsNotNull() {
            addCriterion("MODEL_LOCAL_DIR is not null");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirEqualTo(String value) {
            addCriterion("MODEL_LOCAL_DIR =", value, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirNotEqualTo(String value) {
            addCriterion("MODEL_LOCAL_DIR <>", value, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirGreaterThan(String value) {
            addCriterion("MODEL_LOCAL_DIR >", value, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_LOCAL_DIR >=", value, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirLessThan(String value) {
            addCriterion("MODEL_LOCAL_DIR <", value, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirLessThanOrEqualTo(String value) {
            addCriterion("MODEL_LOCAL_DIR <=", value, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirLike(String value) {
            addCriterion("MODEL_LOCAL_DIR like", value, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirNotLike(String value) {
            addCriterion("MODEL_LOCAL_DIR not like", value, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirIn(List<String> values) {
            addCriterion("MODEL_LOCAL_DIR in", values, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirNotIn(List<String> values) {
            addCriterion("MODEL_LOCAL_DIR not in", values, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirBetween(String value1, String value2) {
            addCriterion("MODEL_LOCAL_DIR between", value1, value2, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirNotBetween(String value1, String value2) {
            addCriterion("MODEL_LOCAL_DIR not between", value1, value2, "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("LAST_UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("LAST_UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("LAST_UPDATE_TIME >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("LAST_UPDATE_TIME <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("LAST_UPDATE_TIME in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("LAST_UPDATE_TIME not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_TIME between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_TIME not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperIsNull() {
            addCriterion("LAST_UPDATE_OPER is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperIsNotNull() {
            addCriterion("LAST_UPDATE_OPER is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperEqualTo(String value) {
            addCriterion("LAST_UPDATE_OPER =", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperNotEqualTo(String value) {
            addCriterion("LAST_UPDATE_OPER <>", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperGreaterThan(String value) {
            addCriterion("LAST_UPDATE_OPER >", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATE_OPER >=", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperLessThan(String value) {
            addCriterion("LAST_UPDATE_OPER <", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATE_OPER <=", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperLike(String value) {
            addCriterion("LAST_UPDATE_OPER like", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperNotLike(String value) {
            addCriterion("LAST_UPDATE_OPER not like", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperIn(List<String> values) {
            addCriterion("LAST_UPDATE_OPER in", values, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperNotIn(List<String> values) {
            addCriterion("LAST_UPDATE_OPER not in", values, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperBetween(String value1, String value2) {
            addCriterion("LAST_UPDATE_OPER between", value1, value2, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperNotBetween(String value1, String value2) {
            addCriterion("LAST_UPDATE_OPER not between", value1, value2, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperIsNull() {
            addCriterion("CREATE_OPER is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIsNotNull() {
            addCriterion("CREATE_OPER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperEqualTo(String value) {
            addCriterion("CREATE_OPER =", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotEqualTo(String value) {
            addCriterion("CREATE_OPER <>", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperGreaterThan(String value) {
            addCriterion("CREATE_OPER >", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER >=", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLessThan(String value) {
            addCriterion("CREATE_OPER <", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLessThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER <=", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLike(String value) {
            addCriterion("CREATE_OPER like", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotLike(String value) {
            addCriterion("CREATE_OPER not like", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperIn(List<String> values) {
            addCriterion("CREATE_OPER in", values, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotIn(List<String> values) {
            addCriterion("CREATE_OPER not in", values, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperBetween(String value1, String value2) {
            addCriterion("CREATE_OPER between", value1, value2, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotBetween(String value1, String value2) {
            addCriterion("CREATE_OPER not between", value1, value2, "createOper");
            return (Criteria) this;
        }

        public Criteria andMwCodeLikeInsensitive(String value) {
            addCriterion("upper(MW_CODE) like", value.toUpperCase(), "mwCode");
            return (Criteria) this;
        }

        public Criteria andMwNameLikeInsensitive(String value) {
            addCriterion("upper(MW_NAME) like", value.toUpperCase(), "mwName");
            return (Criteria) this;
        }

        public Criteria andModelDfsDirLikeInsensitive(String value) {
            addCriterion("upper(MODEL_DFS_DIR) like", value.toUpperCase(), "modelDfsDir");
            return (Criteria) this;
        }

        public Criteria andModelLocalDirLikeInsensitive(String value) {
            addCriterion("upper(MODEL_LOCAL_DIR) like", value.toUpperCase(), "modelLocalDir");
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(DESCRIPTION) like", value.toUpperCase(), "description");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperLikeInsensitive(String value) {
            addCriterion("upper(LAST_UPDATE_OPER) like", value.toUpperCase(), "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLikeInsensitive(String value) {
            addCriterion("upper(CREATE_OPER) like", value.toUpperCase(), "createOper");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}