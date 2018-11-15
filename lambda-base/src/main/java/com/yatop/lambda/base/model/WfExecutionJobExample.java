package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfExecutionJobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WfExecutionJobExample() {
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

        public Criteria andJobIdIsNull() {
            addCriterion("JOB_ID is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("JOB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Long value) {
            addCriterion("JOB_ID =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Long value) {
            addCriterion("JOB_ID <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Long value) {
            addCriterion("JOB_ID >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("JOB_ID >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Long value) {
            addCriterion("JOB_ID <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Long value) {
            addCriterion("JOB_ID <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Long> values) {
            addCriterion("JOB_ID in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Long> values) {
            addCriterion("JOB_ID not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Long value1, Long value2) {
            addCriterion("JOB_ID between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Long value1, Long value2) {
            addCriterion("JOB_ID not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("JOB_NAME is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("JOB_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("JOB_NAME =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("JOB_NAME <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("JOB_NAME >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_NAME >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("JOB_NAME <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("JOB_NAME <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("JOB_NAME like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("JOB_NAME not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("JOB_NAME in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("JOB_NAME not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("JOB_NAME between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("JOB_NAME not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNull() {
            addCriterion("JOB_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNotNull() {
            addCriterion("JOB_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andJobTypeEqualTo(Integer value) {
            addCriterion("JOB_TYPE =", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotEqualTo(Integer value) {
            addCriterion("JOB_TYPE <>", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThan(Integer value) {
            addCriterion("JOB_TYPE >", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOB_TYPE >=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThan(Integer value) {
            addCriterion("JOB_TYPE <", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThanOrEqualTo(Integer value) {
            addCriterion("JOB_TYPE <=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeIn(List<Integer> values) {
            addCriterion("JOB_TYPE in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotIn(List<Integer> values) {
            addCriterion("JOB_TYPE not in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeBetween(Integer value1, Integer value2) {
            addCriterion("JOB_TYPE between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("JOB_TYPE not between", value1, value2, "jobType");
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

        public Criteria andRelFlowIdIsNull() {
            addCriterion("REL_FLOW_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdIsNotNull() {
            addCriterion("REL_FLOW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdEqualTo(Long value) {
            addCriterion("REL_FLOW_ID =", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdNotEqualTo(Long value) {
            addCriterion("REL_FLOW_ID <>", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdGreaterThan(Long value) {
            addCriterion("REL_FLOW_ID >", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_FLOW_ID >=", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdLessThan(Long value) {
            addCriterion("REL_FLOW_ID <", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdLessThanOrEqualTo(Long value) {
            addCriterion("REL_FLOW_ID <=", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdIn(List<Long> values) {
            addCriterion("REL_FLOW_ID in", values, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdNotIn(List<Long> values) {
            addCriterion("REL_FLOW_ID not in", values, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdBetween(Long value1, Long value2) {
            addCriterion("REL_FLOW_ID between", value1, value2, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdNotBetween(Long value1, Long value2) {
            addCriterion("REL_FLOW_ID not between", value1, value2, "relFlowId");
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

        public Criteria andDfsExecDirIsNull() {
            addCriterion("DFS_EXEC_DIR is null");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirIsNotNull() {
            addCriterion("DFS_EXEC_DIR is not null");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirEqualTo(String value) {
            addCriterion("DFS_EXEC_DIR =", value, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirNotEqualTo(String value) {
            addCriterion("DFS_EXEC_DIR <>", value, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirGreaterThan(String value) {
            addCriterion("DFS_EXEC_DIR >", value, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirGreaterThanOrEqualTo(String value) {
            addCriterion("DFS_EXEC_DIR >=", value, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirLessThan(String value) {
            addCriterion("DFS_EXEC_DIR <", value, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirLessThanOrEqualTo(String value) {
            addCriterion("DFS_EXEC_DIR <=", value, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirLike(String value) {
            addCriterion("DFS_EXEC_DIR like", value, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirNotLike(String value) {
            addCriterion("DFS_EXEC_DIR not like", value, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirIn(List<String> values) {
            addCriterion("DFS_EXEC_DIR in", values, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirNotIn(List<String> values) {
            addCriterion("DFS_EXEC_DIR not in", values, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirBetween(String value1, String value2) {
            addCriterion("DFS_EXEC_DIR between", value1, value2, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirNotBetween(String value1, String value2) {
            addCriterion("DFS_EXEC_DIR not between", value1, value2, "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirIsNull() {
            addCriterion("LOCAL_EXEC_DIR is null");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirIsNotNull() {
            addCriterion("LOCAL_EXEC_DIR is not null");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirEqualTo(String value) {
            addCriterion("LOCAL_EXEC_DIR =", value, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirNotEqualTo(String value) {
            addCriterion("LOCAL_EXEC_DIR <>", value, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirGreaterThan(String value) {
            addCriterion("LOCAL_EXEC_DIR >", value, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirGreaterThanOrEqualTo(String value) {
            addCriterion("LOCAL_EXEC_DIR >=", value, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirLessThan(String value) {
            addCriterion("LOCAL_EXEC_DIR <", value, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirLessThanOrEqualTo(String value) {
            addCriterion("LOCAL_EXEC_DIR <=", value, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirLike(String value) {
            addCriterion("LOCAL_EXEC_DIR like", value, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirNotLike(String value) {
            addCriterion("LOCAL_EXEC_DIR not like", value, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirIn(List<String> values) {
            addCriterion("LOCAL_EXEC_DIR in", values, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirNotIn(List<String> values) {
            addCriterion("LOCAL_EXEC_DIR not in", values, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirBetween(String value1, String value2) {
            addCriterion("LOCAL_EXEC_DIR between", value1, value2, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirNotBetween(String value1, String value2) {
            addCriterion("LOCAL_EXEC_DIR not between", value1, value2, "localExecDir");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeIsNull() {
            addCriterion("JOB_SUBMIT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeIsNotNull() {
            addCriterion("JOB_SUBMIT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeEqualTo(Date value) {
            addCriterion("JOB_SUBMIT_TIME =", value, "jobSubmitTime");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeNotEqualTo(Date value) {
            addCriterion("JOB_SUBMIT_TIME <>", value, "jobSubmitTime");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeGreaterThan(Date value) {
            addCriterion("JOB_SUBMIT_TIME >", value, "jobSubmitTime");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("JOB_SUBMIT_TIME >=", value, "jobSubmitTime");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeLessThan(Date value) {
            addCriterion("JOB_SUBMIT_TIME <", value, "jobSubmitTime");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("JOB_SUBMIT_TIME <=", value, "jobSubmitTime");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeIn(List<Date> values) {
            addCriterion("JOB_SUBMIT_TIME in", values, "jobSubmitTime");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeNotIn(List<Date> values) {
            addCriterion("JOB_SUBMIT_TIME not in", values, "jobSubmitTime");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("JOB_SUBMIT_TIME between", value1, value2, "jobSubmitTime");
            return (Criteria) this;
        }

        public Criteria andJobSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("JOB_SUBMIT_TIME not between", value1, value2, "jobSubmitTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeIsNull() {
            addCriterion("JOB_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeIsNotNull() {
            addCriterion("JOB_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeEqualTo(Date value) {
            addCriterion("JOB_START_TIME =", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeNotEqualTo(Date value) {
            addCriterion("JOB_START_TIME <>", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeGreaterThan(Date value) {
            addCriterion("JOB_START_TIME >", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("JOB_START_TIME >=", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeLessThan(Date value) {
            addCriterion("JOB_START_TIME <", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("JOB_START_TIME <=", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeIn(List<Date> values) {
            addCriterion("JOB_START_TIME in", values, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeNotIn(List<Date> values) {
            addCriterion("JOB_START_TIME not in", values, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeBetween(Date value1, Date value2) {
            addCriterion("JOB_START_TIME between", value1, value2, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("JOB_START_TIME not between", value1, value2, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeIsNull() {
            addCriterion("JOB_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeIsNotNull() {
            addCriterion("JOB_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeEqualTo(Date value) {
            addCriterion("JOB_END_TIME =", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeNotEqualTo(Date value) {
            addCriterion("JOB_END_TIME <>", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeGreaterThan(Date value) {
            addCriterion("JOB_END_TIME >", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("JOB_END_TIME >=", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeLessThan(Date value) {
            addCriterion("JOB_END_TIME <", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("JOB_END_TIME <=", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeIn(List<Date> values) {
            addCriterion("JOB_END_TIME in", values, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeNotIn(List<Date> values) {
            addCriterion("JOB_END_TIME not in", values, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeBetween(Date value1, Date value2) {
            addCriterion("JOB_END_TIME between", value1, value2, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("JOB_END_TIME not between", value1, value2, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobStateIsNull() {
            addCriterion("JOB_STATE is null");
            return (Criteria) this;
        }

        public Criteria andJobStateIsNotNull() {
            addCriterion("JOB_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andJobStateEqualTo(Integer value) {
            addCriterion("JOB_STATE =", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateNotEqualTo(Integer value) {
            addCriterion("JOB_STATE <>", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateGreaterThan(Integer value) {
            addCriterion("JOB_STATE >", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOB_STATE >=", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateLessThan(Integer value) {
            addCriterion("JOB_STATE <", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateLessThanOrEqualTo(Integer value) {
            addCriterion("JOB_STATE <=", value, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateIn(List<Integer> values) {
            addCriterion("JOB_STATE in", values, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateNotIn(List<Integer> values) {
            addCriterion("JOB_STATE not in", values, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateBetween(Integer value1, Integer value2) {
            addCriterion("JOB_STATE between", value1, value2, "jobState");
            return (Criteria) this;
        }

        public Criteria andJobStateNotBetween(Integer value1, Integer value2) {
            addCriterion("JOB_STATE not between", value1, value2, "jobState");
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

        public Criteria andJobNameLikeInsensitive(String value) {
            addCriterion("upper(JOB_NAME) like", value.toUpperCase(), "jobName");
            return (Criteria) this;
        }

        public Criteria andDfsExecDirLikeInsensitive(String value) {
            addCriterion("upper(DFS_EXEC_DIR) like", value.toUpperCase(), "dfsExecDir");
            return (Criteria) this;
        }

        public Criteria andLocalExecDirLikeInsensitive(String value) {
            addCriterion("upper(LOCAL_EXEC_DIR) like", value.toUpperCase(), "localExecDir");
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