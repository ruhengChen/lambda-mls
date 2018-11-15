package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MwModelEvaluationReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public MwModelEvaluationReportExample() {
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

        public Criteria andReportIdIsNull() {
            addCriterion("REPORT_ID is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("REPORT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(Long value) {
            addCriterion("REPORT_ID =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(Long value) {
            addCriterion("REPORT_ID <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(Long value) {
            addCriterion("REPORT_ID >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REPORT_ID >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(Long value) {
            addCriterion("REPORT_ID <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(Long value) {
            addCriterion("REPORT_ID <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<Long> values) {
            addCriterion("REPORT_ID in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<Long> values) {
            addCriterion("REPORT_ID not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(Long value1, Long value2) {
            addCriterion("REPORT_ID between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(Long value1, Long value2) {
            addCriterion("REPORT_ID not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportNameIsNull() {
            addCriterion("REPORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReportNameIsNotNull() {
            addCriterion("REPORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReportNameEqualTo(String value) {
            addCriterion("REPORT_NAME =", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotEqualTo(String value) {
            addCriterion("REPORT_NAME <>", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameGreaterThan(String value) {
            addCriterion("REPORT_NAME >", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameGreaterThanOrEqualTo(String value) {
            addCriterion("REPORT_NAME >=", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameLessThan(String value) {
            addCriterion("REPORT_NAME <", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameLessThanOrEqualTo(String value) {
            addCriterion("REPORT_NAME <=", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameLike(String value) {
            addCriterion("REPORT_NAME like", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotLike(String value) {
            addCriterion("REPORT_NAME not like", value, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameIn(List<String> values) {
            addCriterion("REPORT_NAME in", values, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotIn(List<String> values) {
            addCriterion("REPORT_NAME not in", values, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameBetween(String value1, String value2) {
            addCriterion("REPORT_NAME between", value1, value2, "reportName");
            return (Criteria) this;
        }

        public Criteria andReportNameNotBetween(String value1, String value2) {
            addCriterion("REPORT_NAME not between", value1, value2, "reportName");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdIsNull() {
            addCriterion("OWNER_MODEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdIsNotNull() {
            addCriterion("OWNER_MODEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdEqualTo(Long value) {
            addCriterion("OWNER_MODEL_ID =", value, "ownerModelId");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdNotEqualTo(Long value) {
            addCriterion("OWNER_MODEL_ID <>", value, "ownerModelId");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdGreaterThan(Long value) {
            addCriterion("OWNER_MODEL_ID >", value, "ownerModelId");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OWNER_MODEL_ID >=", value, "ownerModelId");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdLessThan(Long value) {
            addCriterion("OWNER_MODEL_ID <", value, "ownerModelId");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdLessThanOrEqualTo(Long value) {
            addCriterion("OWNER_MODEL_ID <=", value, "ownerModelId");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdIn(List<Long> values) {
            addCriterion("OWNER_MODEL_ID in", values, "ownerModelId");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdNotIn(List<Long> values) {
            addCriterion("OWNER_MODEL_ID not in", values, "ownerModelId");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdBetween(Long value1, Long value2) {
            addCriterion("OWNER_MODEL_ID between", value1, value2, "ownerModelId");
            return (Criteria) this;
        }

        public Criteria andOwnerModelIdNotBetween(Long value1, Long value2) {
            addCriterion("OWNER_MODEL_ID not between", value1, value2, "ownerModelId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdIsNull() {
            addCriterion("REL_SNAPSHOT_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdIsNotNull() {
            addCriterion("REL_SNAPSHOT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_ID =", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdNotEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_ID <>", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdGreaterThan(Long value) {
            addCriterion("REL_SNAPSHOT_ID >", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_ID >=", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdLessThan(Long value) {
            addCriterion("REL_SNAPSHOT_ID <", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdLessThanOrEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_ID <=", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdIn(List<Long> values) {
            addCriterion("REL_SNAPSHOT_ID in", values, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdNotIn(List<Long> values) {
            addCriterion("REL_SNAPSHOT_ID not in", values, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdBetween(Long value1, Long value2) {
            addCriterion("REL_SNAPSHOT_ID between", value1, value2, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdNotBetween(Long value1, Long value2) {
            addCriterion("REL_SNAPSHOT_ID not between", value1, value2, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdIsNull() {
            addCriterion("REL_NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdIsNotNull() {
            addCriterion("REL_NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdEqualTo(Long value) {
            addCriterion("REL_NODE_ID =", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdNotEqualTo(Long value) {
            addCriterion("REL_NODE_ID <>", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdGreaterThan(Long value) {
            addCriterion("REL_NODE_ID >", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_NODE_ID >=", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdLessThan(Long value) {
            addCriterion("REL_NODE_ID <", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdLessThanOrEqualTo(Long value) {
            addCriterion("REL_NODE_ID <=", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdIn(List<Long> values) {
            addCriterion("REL_NODE_ID in", values, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdNotIn(List<Long> values) {
            addCriterion("REL_NODE_ID not in", values, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdBetween(Long value1, Long value2) {
            addCriterion("REL_NODE_ID between", value1, value2, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdNotBetween(Long value1, Long value2) {
            addCriterion("REL_NODE_ID not between", value1, value2, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andTestTableIdIsNull() {
            addCriterion("TEST_TABLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTestTableIdIsNotNull() {
            addCriterion("TEST_TABLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTestTableIdEqualTo(Long value) {
            addCriterion("TEST_TABLE_ID =", value, "testTableId");
            return (Criteria) this;
        }

        public Criteria andTestTableIdNotEqualTo(Long value) {
            addCriterion("TEST_TABLE_ID <>", value, "testTableId");
            return (Criteria) this;
        }

        public Criteria andTestTableIdGreaterThan(Long value) {
            addCriterion("TEST_TABLE_ID >", value, "testTableId");
            return (Criteria) this;
        }

        public Criteria andTestTableIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TEST_TABLE_ID >=", value, "testTableId");
            return (Criteria) this;
        }

        public Criteria andTestTableIdLessThan(Long value) {
            addCriterion("TEST_TABLE_ID <", value, "testTableId");
            return (Criteria) this;
        }

        public Criteria andTestTableIdLessThanOrEqualTo(Long value) {
            addCriterion("TEST_TABLE_ID <=", value, "testTableId");
            return (Criteria) this;
        }

        public Criteria andTestTableIdIn(List<Long> values) {
            addCriterion("TEST_TABLE_ID in", values, "testTableId");
            return (Criteria) this;
        }

        public Criteria andTestTableIdNotIn(List<Long> values) {
            addCriterion("TEST_TABLE_ID not in", values, "testTableId");
            return (Criteria) this;
        }

        public Criteria andTestTableIdBetween(Long value1, Long value2) {
            addCriterion("TEST_TABLE_ID between", value1, value2, "testTableId");
            return (Criteria) this;
        }

        public Criteria andTestTableIdNotBetween(Long value1, Long value2) {
            addCriterion("TEST_TABLE_ID not between", value1, value2, "testTableId");
            return (Criteria) this;
        }

        public Criteria andReportStateIsNull() {
            addCriterion("REPORT_STATE is null");
            return (Criteria) this;
        }

        public Criteria andReportStateIsNotNull() {
            addCriterion("REPORT_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andReportStateEqualTo(Integer value) {
            addCriterion("REPORT_STATE =", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateNotEqualTo(Integer value) {
            addCriterion("REPORT_STATE <>", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateGreaterThan(Integer value) {
            addCriterion("REPORT_STATE >", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("REPORT_STATE >=", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateLessThan(Integer value) {
            addCriterion("REPORT_STATE <", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateLessThanOrEqualTo(Integer value) {
            addCriterion("REPORT_STATE <=", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateIn(List<Integer> values) {
            addCriterion("REPORT_STATE in", values, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateNotIn(List<Integer> values) {
            addCriterion("REPORT_STATE not in", values, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateBetween(Integer value1, Integer value2) {
            addCriterion("REPORT_STATE between", value1, value2, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateNotBetween(Integer value1, Integer value2) {
            addCriterion("REPORT_STATE not between", value1, value2, "reportState");
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

        public Criteria andReportNameLikeInsensitive(String value) {
            addCriterion("upper(REPORT_NAME) like", value.toUpperCase(), "reportName");
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