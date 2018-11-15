package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WfFlowExample() {
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

        public Criteria andFlowIdIsNull() {
            addCriterion("FLOW_ID is null");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNotNull() {
            addCriterion("FLOW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFlowIdEqualTo(Long value) {
            addCriterion("FLOW_ID =", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotEqualTo(Long value) {
            addCriterion("FLOW_ID <>", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThan(Long value) {
            addCriterion("FLOW_ID >", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FLOW_ID >=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThan(Long value) {
            addCriterion("FLOW_ID <", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThanOrEqualTo(Long value) {
            addCriterion("FLOW_ID <=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdIn(List<Long> values) {
            addCriterion("FLOW_ID in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotIn(List<Long> values) {
            addCriterion("FLOW_ID not in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdBetween(Long value1, Long value2) {
            addCriterion("FLOW_ID between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotBetween(Long value1, Long value2) {
            addCriterion("FLOW_ID not between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowNameIsNull() {
            addCriterion("FLOW_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFlowNameIsNotNull() {
            addCriterion("FLOW_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNameEqualTo(String value) {
            addCriterion("FLOW_NAME =", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotEqualTo(String value) {
            addCriterion("FLOW_NAME <>", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameGreaterThan(String value) {
            addCriterion("FLOW_NAME >", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameGreaterThanOrEqualTo(String value) {
            addCriterion("FLOW_NAME >=", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLessThan(String value) {
            addCriterion("FLOW_NAME <", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLessThanOrEqualTo(String value) {
            addCriterion("FLOW_NAME <=", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLike(String value) {
            addCriterion("FLOW_NAME like", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotLike(String value) {
            addCriterion("FLOW_NAME not like", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameIn(List<String> values) {
            addCriterion("FLOW_NAME in", values, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotIn(List<String> values) {
            addCriterion("FLOW_NAME not in", values, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameBetween(String value1, String value2) {
            addCriterion("FLOW_NAME between", value1, value2, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotBetween(String value1, String value2) {
            addCriterion("FLOW_NAME not between", value1, value2, "flowName");
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

        public Criteria andOwnerExperimentIdIsNull() {
            addCriterion("OWNER_EXPERIMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdIsNotNull() {
            addCriterion("OWNER_EXPERIMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdEqualTo(Long value) {
            addCriterion("OWNER_EXPERIMENT_ID =", value, "ownerExperimentId");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdNotEqualTo(Long value) {
            addCriterion("OWNER_EXPERIMENT_ID <>", value, "ownerExperimentId");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdGreaterThan(Long value) {
            addCriterion("OWNER_EXPERIMENT_ID >", value, "ownerExperimentId");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OWNER_EXPERIMENT_ID >=", value, "ownerExperimentId");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdLessThan(Long value) {
            addCriterion("OWNER_EXPERIMENT_ID <", value, "ownerExperimentId");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdLessThanOrEqualTo(Long value) {
            addCriterion("OWNER_EXPERIMENT_ID <=", value, "ownerExperimentId");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdIn(List<Long> values) {
            addCriterion("OWNER_EXPERIMENT_ID in", values, "ownerExperimentId");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdNotIn(List<Long> values) {
            addCriterion("OWNER_EXPERIMENT_ID not in", values, "ownerExperimentId");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdBetween(Long value1, Long value2) {
            addCriterion("OWNER_EXPERIMENT_ID between", value1, value2, "ownerExperimentId");
            return (Criteria) this;
        }

        public Criteria andOwnerExperimentIdNotBetween(Long value1, Long value2) {
            addCriterion("OWNER_EXPERIMENT_ID not between", value1, value2, "ownerExperimentId");
            return (Criteria) this;
        }

        public Criteria andLockStateIsNull() {
            addCriterion("LOCK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andLockStateIsNotNull() {
            addCriterion("LOCK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andLockStateEqualTo(Integer value) {
            addCriterion("LOCK_STATE =", value, "lockState");
            return (Criteria) this;
        }

        public Criteria andLockStateNotEqualTo(Integer value) {
            addCriterion("LOCK_STATE <>", value, "lockState");
            return (Criteria) this;
        }

        public Criteria andLockStateGreaterThan(Integer value) {
            addCriterion("LOCK_STATE >", value, "lockState");
            return (Criteria) this;
        }

        public Criteria andLockStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOCK_STATE >=", value, "lockState");
            return (Criteria) this;
        }

        public Criteria andLockStateLessThan(Integer value) {
            addCriterion("LOCK_STATE <", value, "lockState");
            return (Criteria) this;
        }

        public Criteria andLockStateLessThanOrEqualTo(Integer value) {
            addCriterion("LOCK_STATE <=", value, "lockState");
            return (Criteria) this;
        }

        public Criteria andLockStateIn(List<Integer> values) {
            addCriterion("LOCK_STATE in", values, "lockState");
            return (Criteria) this;
        }

        public Criteria andLockStateNotIn(List<Integer> values) {
            addCriterion("LOCK_STATE not in", values, "lockState");
            return (Criteria) this;
        }

        public Criteria andLockStateBetween(Integer value1, Integer value2) {
            addCriterion("LOCK_STATE between", value1, value2, "lockState");
            return (Criteria) this;
        }

        public Criteria andLockStateNotBetween(Integer value1, Integer value2) {
            addCriterion("LOCK_STATE not between", value1, value2, "lockState");
            return (Criteria) this;
        }

        public Criteria andLockMsgIsNull() {
            addCriterion("LOCK_MSG is null");
            return (Criteria) this;
        }

        public Criteria andLockMsgIsNotNull() {
            addCriterion("LOCK_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andLockMsgEqualTo(String value) {
            addCriterion("LOCK_MSG =", value, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgNotEqualTo(String value) {
            addCriterion("LOCK_MSG <>", value, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgGreaterThan(String value) {
            addCriterion("LOCK_MSG >", value, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_MSG >=", value, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgLessThan(String value) {
            addCriterion("LOCK_MSG <", value, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgLessThanOrEqualTo(String value) {
            addCriterion("LOCK_MSG <=", value, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgLike(String value) {
            addCriterion("LOCK_MSG like", value, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgNotLike(String value) {
            addCriterion("LOCK_MSG not like", value, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgIn(List<String> values) {
            addCriterion("LOCK_MSG in", values, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgNotIn(List<String> values) {
            addCriterion("LOCK_MSG not in", values, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgBetween(String value1, String value2) {
            addCriterion("LOCK_MSG between", value1, value2, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLockMsgNotBetween(String value1, String value2) {
            addCriterion("LOCK_MSG not between", value1, value2, "lockMsg");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdIsNull() {
            addCriterion("LAST_SNAPSHOT_ID is null");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdIsNotNull() {
            addCriterion("LAST_SNAPSHOT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdEqualTo(Long value) {
            addCriterion("LAST_SNAPSHOT_ID =", value, "lastSnapshotId");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdNotEqualTo(Long value) {
            addCriterion("LAST_SNAPSHOT_ID <>", value, "lastSnapshotId");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdGreaterThan(Long value) {
            addCriterion("LAST_SNAPSHOT_ID >", value, "lastSnapshotId");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LAST_SNAPSHOT_ID >=", value, "lastSnapshotId");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdLessThan(Long value) {
            addCriterion("LAST_SNAPSHOT_ID <", value, "lastSnapshotId");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdLessThanOrEqualTo(Long value) {
            addCriterion("LAST_SNAPSHOT_ID <=", value, "lastSnapshotId");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdIn(List<Long> values) {
            addCriterion("LAST_SNAPSHOT_ID in", values, "lastSnapshotId");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdNotIn(List<Long> values) {
            addCriterion("LAST_SNAPSHOT_ID not in", values, "lastSnapshotId");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdBetween(Long value1, Long value2) {
            addCriterion("LAST_SNAPSHOT_ID between", value1, value2, "lastSnapshotId");
            return (Criteria) this;
        }

        public Criteria andLastSnapshotIdNotBetween(Long value1, Long value2) {
            addCriterion("LAST_SNAPSHOT_ID not between", value1, value2, "lastSnapshotId");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionIsNull() {
            addCriterion("NEXT_SNAPSHOT_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionIsNotNull() {
            addCriterion("NEXT_SNAPSHOT_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionEqualTo(Long value) {
            addCriterion("NEXT_SNAPSHOT_VERSION =", value, "nextSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionNotEqualTo(Long value) {
            addCriterion("NEXT_SNAPSHOT_VERSION <>", value, "nextSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionGreaterThan(Long value) {
            addCriterion("NEXT_SNAPSHOT_VERSION >", value, "nextSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("NEXT_SNAPSHOT_VERSION >=", value, "nextSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionLessThan(Long value) {
            addCriterion("NEXT_SNAPSHOT_VERSION <", value, "nextSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionLessThanOrEqualTo(Long value) {
            addCriterion("NEXT_SNAPSHOT_VERSION <=", value, "nextSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionIn(List<Long> values) {
            addCriterion("NEXT_SNAPSHOT_VERSION in", values, "nextSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionNotIn(List<Long> values) {
            addCriterion("NEXT_SNAPSHOT_VERSION not in", values, "nextSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionBetween(Long value1, Long value2) {
            addCriterion("NEXT_SNAPSHOT_VERSION between", value1, value2, "nextSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andNextSnapshotVersionNotBetween(Long value1, Long value2) {
            addCriterion("NEXT_SNAPSHOT_VERSION not between", value1, value2, "nextSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andLastJobIdIsNull() {
            addCriterion("LAST_JOB_ID is null");
            return (Criteria) this;
        }

        public Criteria andLastJobIdIsNotNull() {
            addCriterion("LAST_JOB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLastJobIdEqualTo(Long value) {
            addCriterion("LAST_JOB_ID =", value, "lastJobId");
            return (Criteria) this;
        }

        public Criteria andLastJobIdNotEqualTo(Long value) {
            addCriterion("LAST_JOB_ID <>", value, "lastJobId");
            return (Criteria) this;
        }

        public Criteria andLastJobIdGreaterThan(Long value) {
            addCriterion("LAST_JOB_ID >", value, "lastJobId");
            return (Criteria) this;
        }

        public Criteria andLastJobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LAST_JOB_ID >=", value, "lastJobId");
            return (Criteria) this;
        }

        public Criteria andLastJobIdLessThan(Long value) {
            addCriterion("LAST_JOB_ID <", value, "lastJobId");
            return (Criteria) this;
        }

        public Criteria andLastJobIdLessThanOrEqualTo(Long value) {
            addCriterion("LAST_JOB_ID <=", value, "lastJobId");
            return (Criteria) this;
        }

        public Criteria andLastJobIdIn(List<Long> values) {
            addCriterion("LAST_JOB_ID in", values, "lastJobId");
            return (Criteria) this;
        }

        public Criteria andLastJobIdNotIn(List<Long> values) {
            addCriterion("LAST_JOB_ID not in", values, "lastJobId");
            return (Criteria) this;
        }

        public Criteria andLastJobIdBetween(Long value1, Long value2) {
            addCriterion("LAST_JOB_ID between", value1, value2, "lastJobId");
            return (Criteria) this;
        }

        public Criteria andLastJobIdNotBetween(Long value1, Long value2) {
            addCriterion("LAST_JOB_ID not between", value1, value2, "lastJobId");
            return (Criteria) this;
        }

        public Criteria andFlowStateIsNull() {
            addCriterion("FLOW_STATE is null");
            return (Criteria) this;
        }

        public Criteria andFlowStateIsNotNull() {
            addCriterion("FLOW_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andFlowStateEqualTo(Integer value) {
            addCriterion("FLOW_STATE =", value, "flowState");
            return (Criteria) this;
        }

        public Criteria andFlowStateNotEqualTo(Integer value) {
            addCriterion("FLOW_STATE <>", value, "flowState");
            return (Criteria) this;
        }

        public Criteria andFlowStateGreaterThan(Integer value) {
            addCriterion("FLOW_STATE >", value, "flowState");
            return (Criteria) this;
        }

        public Criteria andFlowStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("FLOW_STATE >=", value, "flowState");
            return (Criteria) this;
        }

        public Criteria andFlowStateLessThan(Integer value) {
            addCriterion("FLOW_STATE <", value, "flowState");
            return (Criteria) this;
        }

        public Criteria andFlowStateLessThanOrEqualTo(Integer value) {
            addCriterion("FLOW_STATE <=", value, "flowState");
            return (Criteria) this;
        }

        public Criteria andFlowStateIn(List<Integer> values) {
            addCriterion("FLOW_STATE in", values, "flowState");
            return (Criteria) this;
        }

        public Criteria andFlowStateNotIn(List<Integer> values) {
            addCriterion("FLOW_STATE not in", values, "flowState");
            return (Criteria) this;
        }

        public Criteria andFlowStateBetween(Integer value1, Integer value2) {
            addCriterion("FLOW_STATE between", value1, value2, "flowState");
            return (Criteria) this;
        }

        public Criteria andFlowStateNotBetween(Integer value1, Integer value2) {
            addCriterion("FLOW_STATE not between", value1, value2, "flowState");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("SUMMARY is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("SUMMARY is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("SUMMARY =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("SUMMARY <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("SUMMARY >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("SUMMARY >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("SUMMARY <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("SUMMARY <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("SUMMARY like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("SUMMARY not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("SUMMARY in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("SUMMARY not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("SUMMARY between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("SUMMARY not between", value1, value2, "summary");
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

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andFlowNameLikeInsensitive(String value) {
            addCriterion("upper(FLOW_NAME) like", value.toUpperCase(), "flowName");
            return (Criteria) this;
        }

        public Criteria andLockMsgLikeInsensitive(String value) {
            addCriterion("upper(LOCK_MSG) like", value.toUpperCase(), "lockMsg");
            return (Criteria) this;
        }

        public Criteria andSummaryLikeInsensitive(String value) {
            addCriterion("upper(SUMMARY) like", value.toUpperCase(), "summary");
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