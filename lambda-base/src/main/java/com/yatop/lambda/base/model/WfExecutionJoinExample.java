package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfExecutionJoinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WfExecutionJoinExample() {
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

        public Criteria andJoinIdIsNull() {
            addCriterion("JOIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andJoinIdIsNotNull() {
            addCriterion("JOIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJoinIdEqualTo(Long value) {
            addCriterion("JOIN_ID =", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdNotEqualTo(Long value) {
            addCriterion("JOIN_ID <>", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdGreaterThan(Long value) {
            addCriterion("JOIN_ID >", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdGreaterThanOrEqualTo(Long value) {
            addCriterion("JOIN_ID >=", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdLessThan(Long value) {
            addCriterion("JOIN_ID <", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdLessThanOrEqualTo(Long value) {
            addCriterion("JOIN_ID <=", value, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdIn(List<Long> values) {
            addCriterion("JOIN_ID in", values, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdNotIn(List<Long> values) {
            addCriterion("JOIN_ID not in", values, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdBetween(Long value1, Long value2) {
            addCriterion("JOIN_ID between", value1, value2, "joinId");
            return (Criteria) this;
        }

        public Criteria andJoinIdNotBetween(Long value1, Long value2) {
            addCriterion("JOIN_ID not between", value1, value2, "joinId");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdIsNull() {
            addCriterion("OWNER_JOB_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdIsNotNull() {
            addCriterion("OWNER_JOB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdEqualTo(Long value) {
            addCriterion("OWNER_JOB_ID =", value, "ownerJobId");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdNotEqualTo(Long value) {
            addCriterion("OWNER_JOB_ID <>", value, "ownerJobId");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdGreaterThan(Long value) {
            addCriterion("OWNER_JOB_ID >", value, "ownerJobId");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OWNER_JOB_ID >=", value, "ownerJobId");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdLessThan(Long value) {
            addCriterion("OWNER_JOB_ID <", value, "ownerJobId");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdLessThanOrEqualTo(Long value) {
            addCriterion("OWNER_JOB_ID <=", value, "ownerJobId");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdIn(List<Long> values) {
            addCriterion("OWNER_JOB_ID in", values, "ownerJobId");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdNotIn(List<Long> values) {
            addCriterion("OWNER_JOB_ID not in", values, "ownerJobId");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdBetween(Long value1, Long value2) {
            addCriterion("OWNER_JOB_ID between", value1, value2, "ownerJobId");
            return (Criteria) this;
        }

        public Criteria andOwnerJobIdNotBetween(Long value1, Long value2) {
            addCriterion("OWNER_JOB_ID not between", value1, value2, "ownerJobId");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdIsNull() {
            addCriterion("JOIN_NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdIsNotNull() {
            addCriterion("JOIN_NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdEqualTo(Long value) {
            addCriterion("JOIN_NODE_ID =", value, "joinNodeId");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdNotEqualTo(Long value) {
            addCriterion("JOIN_NODE_ID <>", value, "joinNodeId");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdGreaterThan(Long value) {
            addCriterion("JOIN_NODE_ID >", value, "joinNodeId");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("JOIN_NODE_ID >=", value, "joinNodeId");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdLessThan(Long value) {
            addCriterion("JOIN_NODE_ID <", value, "joinNodeId");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdLessThanOrEqualTo(Long value) {
            addCriterion("JOIN_NODE_ID <=", value, "joinNodeId");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdIn(List<Long> values) {
            addCriterion("JOIN_NODE_ID in", values, "joinNodeId");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdNotIn(List<Long> values) {
            addCriterion("JOIN_NODE_ID not in", values, "joinNodeId");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdBetween(Long value1, Long value2) {
            addCriterion("JOIN_NODE_ID between", value1, value2, "joinNodeId");
            return (Criteria) this;
        }

        public Criteria andJoinNodeIdNotBetween(Long value1, Long value2) {
            addCriterion("JOIN_NODE_ID not between", value1, value2, "joinNodeId");
            return (Criteria) this;
        }

        public Criteria andJoinNumIsNull() {
            addCriterion("JOIN_NUM is null");
            return (Criteria) this;
        }

        public Criteria andJoinNumIsNotNull() {
            addCriterion("JOIN_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andJoinNumEqualTo(Integer value) {
            addCriterion("JOIN_NUM =", value, "joinNum");
            return (Criteria) this;
        }

        public Criteria andJoinNumNotEqualTo(Integer value) {
            addCriterion("JOIN_NUM <>", value, "joinNum");
            return (Criteria) this;
        }

        public Criteria andJoinNumGreaterThan(Integer value) {
            addCriterion("JOIN_NUM >", value, "joinNum");
            return (Criteria) this;
        }

        public Criteria andJoinNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOIN_NUM >=", value, "joinNum");
            return (Criteria) this;
        }

        public Criteria andJoinNumLessThan(Integer value) {
            addCriterion("JOIN_NUM <", value, "joinNum");
            return (Criteria) this;
        }

        public Criteria andJoinNumLessThanOrEqualTo(Integer value) {
            addCriterion("JOIN_NUM <=", value, "joinNum");
            return (Criteria) this;
        }

        public Criteria andJoinNumIn(List<Integer> values) {
            addCriterion("JOIN_NUM in", values, "joinNum");
            return (Criteria) this;
        }

        public Criteria andJoinNumNotIn(List<Integer> values) {
            addCriterion("JOIN_NUM not in", values, "joinNum");
            return (Criteria) this;
        }

        public Criteria andJoinNumBetween(Integer value1, Integer value2) {
            addCriterion("JOIN_NUM between", value1, value2, "joinNum");
            return (Criteria) this;
        }

        public Criteria andJoinNumNotBetween(Integer value1, Integer value2) {
            addCriterion("JOIN_NUM not between", value1, value2, "joinNum");
            return (Criteria) this;
        }

        public Criteria andJoinCountIsNull() {
            addCriterion("JOIN_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andJoinCountIsNotNull() {
            addCriterion("JOIN_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andJoinCountEqualTo(Integer value) {
            addCriterion("JOIN_COUNT =", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountNotEqualTo(Integer value) {
            addCriterion("JOIN_COUNT <>", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountGreaterThan(Integer value) {
            addCriterion("JOIN_COUNT >", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOIN_COUNT >=", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountLessThan(Integer value) {
            addCriterion("JOIN_COUNT <", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountLessThanOrEqualTo(Integer value) {
            addCriterion("JOIN_COUNT <=", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountIn(List<Integer> values) {
            addCriterion("JOIN_COUNT in", values, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountNotIn(List<Integer> values) {
            addCriterion("JOIN_COUNT not in", values, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountBetween(Integer value1, Integer value2) {
            addCriterion("JOIN_COUNT between", value1, value2, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountNotBetween(Integer value1, Integer value2) {
            addCriterion("JOIN_COUNT not between", value1, value2, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinStateIsNull() {
            addCriterion("JOIN_STATE is null");
            return (Criteria) this;
        }

        public Criteria andJoinStateIsNotNull() {
            addCriterion("JOIN_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andJoinStateEqualTo(Integer value) {
            addCriterion("JOIN_STATE =", value, "joinState");
            return (Criteria) this;
        }

        public Criteria andJoinStateNotEqualTo(Integer value) {
            addCriterion("JOIN_STATE <>", value, "joinState");
            return (Criteria) this;
        }

        public Criteria andJoinStateGreaterThan(Integer value) {
            addCriterion("JOIN_STATE >", value, "joinState");
            return (Criteria) this;
        }

        public Criteria andJoinStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOIN_STATE >=", value, "joinState");
            return (Criteria) this;
        }

        public Criteria andJoinStateLessThan(Integer value) {
            addCriterion("JOIN_STATE <", value, "joinState");
            return (Criteria) this;
        }

        public Criteria andJoinStateLessThanOrEqualTo(Integer value) {
            addCriterion("JOIN_STATE <=", value, "joinState");
            return (Criteria) this;
        }

        public Criteria andJoinStateIn(List<Integer> values) {
            addCriterion("JOIN_STATE in", values, "joinState");
            return (Criteria) this;
        }

        public Criteria andJoinStateNotIn(List<Integer> values) {
            addCriterion("JOIN_STATE not in", values, "joinState");
            return (Criteria) this;
        }

        public Criteria andJoinStateBetween(Integer value1, Integer value2) {
            addCriterion("JOIN_STATE between", value1, value2, "joinState");
            return (Criteria) this;
        }

        public Criteria andJoinStateNotBetween(Integer value1, Integer value2) {
            addCriterion("JOIN_STATE not between", value1, value2, "joinState");
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