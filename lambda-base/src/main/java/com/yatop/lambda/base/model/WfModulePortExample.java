package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfModulePortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WfModulePortExample() {
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

        public Criteria andPortIdIsNull() {
            addCriterion("PORT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPortIdIsNotNull() {
            addCriterion("PORT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPortIdEqualTo(Long value) {
            addCriterion("PORT_ID =", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdNotEqualTo(Long value) {
            addCriterion("PORT_ID <>", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdGreaterThan(Long value) {
            addCriterion("PORT_ID >", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PORT_ID >=", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdLessThan(Long value) {
            addCriterion("PORT_ID <", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdLessThanOrEqualTo(Long value) {
            addCriterion("PORT_ID <=", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdIn(List<Long> values) {
            addCriterion("PORT_ID in", values, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdNotIn(List<Long> values) {
            addCriterion("PORT_ID not in", values, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdBetween(Long value1, Long value2) {
            addCriterion("PORT_ID between", value1, value2, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdNotBetween(Long value1, Long value2) {
            addCriterion("PORT_ID not between", value1, value2, "portId");
            return (Criteria) this;
        }

        public Criteria andPortNameIsNull() {
            addCriterion("PORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPortNameIsNotNull() {
            addCriterion("PORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPortNameEqualTo(String value) {
            addCriterion("PORT_NAME =", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameNotEqualTo(String value) {
            addCriterion("PORT_NAME <>", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameGreaterThan(String value) {
            addCriterion("PORT_NAME >", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameGreaterThanOrEqualTo(String value) {
            addCriterion("PORT_NAME >=", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameLessThan(String value) {
            addCriterion("PORT_NAME <", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameLessThanOrEqualTo(String value) {
            addCriterion("PORT_NAME <=", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameLike(String value) {
            addCriterion("PORT_NAME like", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameNotLike(String value) {
            addCriterion("PORT_NAME not like", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameIn(List<String> values) {
            addCriterion("PORT_NAME in", values, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameNotIn(List<String> values) {
            addCriterion("PORT_NAME not in", values, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameBetween(String value1, String value2) {
            addCriterion("PORT_NAME between", value1, value2, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameNotBetween(String value1, String value2) {
            addCriterion("PORT_NAME not between", value1, value2, "portName");
            return (Criteria) this;
        }

        public Criteria andPortTypeIsNull() {
            addCriterion("PORT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPortTypeIsNotNull() {
            addCriterion("PORT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPortTypeEqualTo(Integer value) {
            addCriterion("PORT_TYPE =", value, "portType");
            return (Criteria) this;
        }

        public Criteria andPortTypeNotEqualTo(Integer value) {
            addCriterion("PORT_TYPE <>", value, "portType");
            return (Criteria) this;
        }

        public Criteria andPortTypeGreaterThan(Integer value) {
            addCriterion("PORT_TYPE >", value, "portType");
            return (Criteria) this;
        }

        public Criteria andPortTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PORT_TYPE >=", value, "portType");
            return (Criteria) this;
        }

        public Criteria andPortTypeLessThan(Integer value) {
            addCriterion("PORT_TYPE <", value, "portType");
            return (Criteria) this;
        }

        public Criteria andPortTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PORT_TYPE <=", value, "portType");
            return (Criteria) this;
        }

        public Criteria andPortTypeIn(List<Integer> values) {
            addCriterion("PORT_TYPE in", values, "portType");
            return (Criteria) this;
        }

        public Criteria andPortTypeNotIn(List<Integer> values) {
            addCriterion("PORT_TYPE not in", values, "portType");
            return (Criteria) this;
        }

        public Criteria andPortTypeBetween(Integer value1, Integer value2) {
            addCriterion("PORT_TYPE between", value1, value2, "portType");
            return (Criteria) this;
        }

        public Criteria andPortTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PORT_TYPE not between", value1, value2, "portType");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdIsNull() {
            addCriterion("OWNER_MODULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdIsNotNull() {
            addCriterion("OWNER_MODULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdEqualTo(Long value) {
            addCriterion("OWNER_MODULE_ID =", value, "ownerModuleId");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdNotEqualTo(Long value) {
            addCriterion("OWNER_MODULE_ID <>", value, "ownerModuleId");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdGreaterThan(Long value) {
            addCriterion("OWNER_MODULE_ID >", value, "ownerModuleId");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OWNER_MODULE_ID >=", value, "ownerModuleId");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdLessThan(Long value) {
            addCriterion("OWNER_MODULE_ID <", value, "ownerModuleId");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdLessThanOrEqualTo(Long value) {
            addCriterion("OWNER_MODULE_ID <=", value, "ownerModuleId");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdIn(List<Long> values) {
            addCriterion("OWNER_MODULE_ID in", values, "ownerModuleId");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdNotIn(List<Long> values) {
            addCriterion("OWNER_MODULE_ID not in", values, "ownerModuleId");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdBetween(Long value1, Long value2) {
            addCriterion("OWNER_MODULE_ID between", value1, value2, "ownerModuleId");
            return (Criteria) this;
        }

        public Criteria andOwnerModuleIdNotBetween(Long value1, Long value2) {
            addCriterion("OWNER_MODULE_ID not between", value1, value2, "ownerModuleId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdIsNull() {
            addCriterion("BIND_CHAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andBindCharIdIsNotNull() {
            addCriterion("BIND_CHAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBindCharIdEqualTo(String value) {
            addCriterion("BIND_CHAR_ID =", value, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdNotEqualTo(String value) {
            addCriterion("BIND_CHAR_ID <>", value, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdGreaterThan(String value) {
            addCriterion("BIND_CHAR_ID >", value, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdGreaterThanOrEqualTo(String value) {
            addCriterion("BIND_CHAR_ID >=", value, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdLessThan(String value) {
            addCriterion("BIND_CHAR_ID <", value, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdLessThanOrEqualTo(String value) {
            addCriterion("BIND_CHAR_ID <=", value, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdLike(String value) {
            addCriterion("BIND_CHAR_ID like", value, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdNotLike(String value) {
            addCriterion("BIND_CHAR_ID not like", value, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdIn(List<String> values) {
            addCriterion("BIND_CHAR_ID in", values, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdNotIn(List<String> values) {
            addCriterion("BIND_CHAR_ID not in", values, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdBetween(String value1, String value2) {
            addCriterion("BIND_CHAR_ID between", value1, value2, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andBindCharIdNotBetween(String value1, String value2) {
            addCriterion("BIND_CHAR_ID not between", value1, value2, "bindCharId");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNull() {
            addCriterion("SEQUENCE is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("SEQUENCE is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Integer value) {
            addCriterion("SEQUENCE =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Integer value) {
            addCriterion("SEQUENCE <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Integer value) {
            addCriterion("SEQUENCE >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEQUENCE >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Integer value) {
            addCriterion("SEQUENCE <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("SEQUENCE <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Integer> values) {
            addCriterion("SEQUENCE in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Integer> values) {
            addCriterion("SEQUENCE not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Integer value1, Integer value2) {
            addCriterion("SEQUENCE between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("SEQUENCE not between", value1, value2, "sequence");
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

        public Criteria andPortNameLikeInsensitive(String value) {
            addCriterion("upper(PORT_NAME) like", value.toUpperCase(), "portName");
            return (Criteria) this;
        }

        public Criteria andBindCharIdLikeInsensitive(String value) {
            addCriterion("upper(BIND_CHAR_ID) like", value.toUpperCase(), "bindCharId");
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