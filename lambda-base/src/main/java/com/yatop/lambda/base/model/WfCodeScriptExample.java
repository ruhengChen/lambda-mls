package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfCodeScriptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WfCodeScriptExample() {
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

        public Criteria andScriptIdIsNull() {
            addCriterion("SCRIPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andScriptIdIsNotNull() {
            addCriterion("SCRIPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andScriptIdEqualTo(Long value) {
            addCriterion("SCRIPT_ID =", value, "scriptId");
            return (Criteria) this;
        }

        public Criteria andScriptIdNotEqualTo(Long value) {
            addCriterion("SCRIPT_ID <>", value, "scriptId");
            return (Criteria) this;
        }

        public Criteria andScriptIdGreaterThan(Long value) {
            addCriterion("SCRIPT_ID >", value, "scriptId");
            return (Criteria) this;
        }

        public Criteria andScriptIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SCRIPT_ID >=", value, "scriptId");
            return (Criteria) this;
        }

        public Criteria andScriptIdLessThan(Long value) {
            addCriterion("SCRIPT_ID <", value, "scriptId");
            return (Criteria) this;
        }

        public Criteria andScriptIdLessThanOrEqualTo(Long value) {
            addCriterion("SCRIPT_ID <=", value, "scriptId");
            return (Criteria) this;
        }

        public Criteria andScriptIdIn(List<Long> values) {
            addCriterion("SCRIPT_ID in", values, "scriptId");
            return (Criteria) this;
        }

        public Criteria andScriptIdNotIn(List<Long> values) {
            addCriterion("SCRIPT_ID not in", values, "scriptId");
            return (Criteria) this;
        }

        public Criteria andScriptIdBetween(Long value1, Long value2) {
            addCriterion("SCRIPT_ID between", value1, value2, "scriptId");
            return (Criteria) this;
        }

        public Criteria andScriptIdNotBetween(Long value1, Long value2) {
            addCriterion("SCRIPT_ID not between", value1, value2, "scriptId");
            return (Criteria) this;
        }

        public Criteria andScriptNameIsNull() {
            addCriterion("SCRIPT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andScriptNameIsNotNull() {
            addCriterion("SCRIPT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andScriptNameEqualTo(String value) {
            addCriterion("SCRIPT_NAME =", value, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameNotEqualTo(String value) {
            addCriterion("SCRIPT_NAME <>", value, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameGreaterThan(String value) {
            addCriterion("SCRIPT_NAME >", value, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameGreaterThanOrEqualTo(String value) {
            addCriterion("SCRIPT_NAME >=", value, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameLessThan(String value) {
            addCriterion("SCRIPT_NAME <", value, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameLessThanOrEqualTo(String value) {
            addCriterion("SCRIPT_NAME <=", value, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameLike(String value) {
            addCriterion("SCRIPT_NAME like", value, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameNotLike(String value) {
            addCriterion("SCRIPT_NAME not like", value, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameIn(List<String> values) {
            addCriterion("SCRIPT_NAME in", values, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameNotIn(List<String> values) {
            addCriterion("SCRIPT_NAME not in", values, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameBetween(String value1, String value2) {
            addCriterion("SCRIPT_NAME between", value1, value2, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptNameNotBetween(String value1, String value2) {
            addCriterion("SCRIPT_NAME not between", value1, value2, "scriptName");
            return (Criteria) this;
        }

        public Criteria andScriptTypeIsNull() {
            addCriterion("SCRIPT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andScriptTypeIsNotNull() {
            addCriterion("SCRIPT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andScriptTypeEqualTo(Integer value) {
            addCriterion("SCRIPT_TYPE =", value, "scriptType");
            return (Criteria) this;
        }

        public Criteria andScriptTypeNotEqualTo(Integer value) {
            addCriterion("SCRIPT_TYPE <>", value, "scriptType");
            return (Criteria) this;
        }

        public Criteria andScriptTypeGreaterThan(Integer value) {
            addCriterion("SCRIPT_TYPE >", value, "scriptType");
            return (Criteria) this;
        }

        public Criteria andScriptTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCRIPT_TYPE >=", value, "scriptType");
            return (Criteria) this;
        }

        public Criteria andScriptTypeLessThan(Integer value) {
            addCriterion("SCRIPT_TYPE <", value, "scriptType");
            return (Criteria) this;
        }

        public Criteria andScriptTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SCRIPT_TYPE <=", value, "scriptType");
            return (Criteria) this;
        }

        public Criteria andScriptTypeIn(List<Integer> values) {
            addCriterion("SCRIPT_TYPE in", values, "scriptType");
            return (Criteria) this;
        }

        public Criteria andScriptTypeNotIn(List<Integer> values) {
            addCriterion("SCRIPT_TYPE not in", values, "scriptType");
            return (Criteria) this;
        }

        public Criteria andScriptTypeBetween(Integer value1, Integer value2) {
            addCriterion("SCRIPT_TYPE between", value1, value2, "scriptType");
            return (Criteria) this;
        }

        public Criteria andScriptTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SCRIPT_TYPE not between", value1, value2, "scriptType");
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

        public Criteria andRelSnapshotVersionIsNull() {
            addCriterion("REL_SNAPSHOT_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionIsNotNull() {
            addCriterion("REL_SNAPSHOT_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_VERSION =", value, "relSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionNotEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_VERSION <>", value, "relSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionGreaterThan(Long value) {
            addCriterion("REL_SNAPSHOT_VERSION >", value, "relSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_VERSION >=", value, "relSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionLessThan(Long value) {
            addCriterion("REL_SNAPSHOT_VERSION <", value, "relSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionLessThanOrEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_VERSION <=", value, "relSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionIn(List<Long> values) {
            addCriterion("REL_SNAPSHOT_VERSION in", values, "relSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionNotIn(List<Long> values) {
            addCriterion("REL_SNAPSHOT_VERSION not in", values, "relSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionBetween(Long value1, Long value2) {
            addCriterion("REL_SNAPSHOT_VERSION between", value1, value2, "relSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotVersionNotBetween(Long value1, Long value2) {
            addCriterion("REL_SNAPSHOT_VERSION not between", value1, value2, "relSnapshotVersion");
            return (Criteria) this;
        }

        public Criteria andRelJobIdIsNull() {
            addCriterion("REL_JOB_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelJobIdIsNotNull() {
            addCriterion("REL_JOB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelJobIdEqualTo(Long value) {
            addCriterion("REL_JOB_ID =", value, "relJobId");
            return (Criteria) this;
        }

        public Criteria andRelJobIdNotEqualTo(Long value) {
            addCriterion("REL_JOB_ID <>", value, "relJobId");
            return (Criteria) this;
        }

        public Criteria andRelJobIdGreaterThan(Long value) {
            addCriterion("REL_JOB_ID >", value, "relJobId");
            return (Criteria) this;
        }

        public Criteria andRelJobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_JOB_ID >=", value, "relJobId");
            return (Criteria) this;
        }

        public Criteria andRelJobIdLessThan(Long value) {
            addCriterion("REL_JOB_ID <", value, "relJobId");
            return (Criteria) this;
        }

        public Criteria andRelJobIdLessThanOrEqualTo(Long value) {
            addCriterion("REL_JOB_ID <=", value, "relJobId");
            return (Criteria) this;
        }

        public Criteria andRelJobIdIn(List<Long> values) {
            addCriterion("REL_JOB_ID in", values, "relJobId");
            return (Criteria) this;
        }

        public Criteria andRelJobIdNotIn(List<Long> values) {
            addCriterion("REL_JOB_ID not in", values, "relJobId");
            return (Criteria) this;
        }

        public Criteria andRelJobIdBetween(Long value1, Long value2) {
            addCriterion("REL_JOB_ID between", value1, value2, "relJobId");
            return (Criteria) this;
        }

        public Criteria andRelJobIdNotBetween(Long value1, Long value2) {
            addCriterion("REL_JOB_ID not between", value1, value2, "relJobId");
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

        public Criteria andRelCharIdIsNull() {
            addCriterion("REL_CHAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelCharIdIsNotNull() {
            addCriterion("REL_CHAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelCharIdEqualTo(Long value) {
            addCriterion("REL_CHAR_ID =", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdNotEqualTo(Long value) {
            addCriterion("REL_CHAR_ID <>", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdGreaterThan(Long value) {
            addCriterion("REL_CHAR_ID >", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_CHAR_ID >=", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdLessThan(Long value) {
            addCriterion("REL_CHAR_ID <", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdLessThanOrEqualTo(Long value) {
            addCriterion("REL_CHAR_ID <=", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdIn(List<Long> values) {
            addCriterion("REL_CHAR_ID in", values, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdNotIn(List<Long> values) {
            addCriterion("REL_CHAR_ID not in", values, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdBetween(Long value1, Long value2) {
            addCriterion("REL_CHAR_ID between", value1, value2, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdNotBetween(Long value1, Long value2) {
            addCriterion("REL_CHAR_ID not between", value1, value2, "relCharId");
            return (Criteria) this;
        }

        public Criteria andScriptStateIsNull() {
            addCriterion("SCRIPT_STATE is null");
            return (Criteria) this;
        }

        public Criteria andScriptStateIsNotNull() {
            addCriterion("SCRIPT_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andScriptStateEqualTo(Integer value) {
            addCriterion("SCRIPT_STATE =", value, "scriptState");
            return (Criteria) this;
        }

        public Criteria andScriptStateNotEqualTo(Integer value) {
            addCriterion("SCRIPT_STATE <>", value, "scriptState");
            return (Criteria) this;
        }

        public Criteria andScriptStateGreaterThan(Integer value) {
            addCriterion("SCRIPT_STATE >", value, "scriptState");
            return (Criteria) this;
        }

        public Criteria andScriptStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCRIPT_STATE >=", value, "scriptState");
            return (Criteria) this;
        }

        public Criteria andScriptStateLessThan(Integer value) {
            addCriterion("SCRIPT_STATE <", value, "scriptState");
            return (Criteria) this;
        }

        public Criteria andScriptStateLessThanOrEqualTo(Integer value) {
            addCriterion("SCRIPT_STATE <=", value, "scriptState");
            return (Criteria) this;
        }

        public Criteria andScriptStateIn(List<Integer> values) {
            addCriterion("SCRIPT_STATE in", values, "scriptState");
            return (Criteria) this;
        }

        public Criteria andScriptStateNotIn(List<Integer> values) {
            addCriterion("SCRIPT_STATE not in", values, "scriptState");
            return (Criteria) this;
        }

        public Criteria andScriptStateBetween(Integer value1, Integer value2) {
            addCriterion("SCRIPT_STATE between", value1, value2, "scriptState");
            return (Criteria) this;
        }

        public Criteria andScriptStateNotBetween(Integer value1, Integer value2) {
            addCriterion("SCRIPT_STATE not between", value1, value2, "scriptState");
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

        public Criteria andScriptNameLikeInsensitive(String value) {
            addCriterion("upper(SCRIPT_NAME) like", value.toUpperCase(), "scriptName");
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