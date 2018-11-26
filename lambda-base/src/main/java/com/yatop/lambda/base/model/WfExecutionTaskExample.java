package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfExecutionTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WfExecutionTaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("TASK_ID =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("TASK_ID <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("TASK_ID >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TASK_ID >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("TASK_ID <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("TASK_ID <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("TASK_ID in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("TASK_ID not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("TASK_ID between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("TASK_ID not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("TASK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("TASK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("TASK_NAME =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("TASK_NAME <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("TASK_NAME >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_NAME >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("TASK_NAME <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("TASK_NAME <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("TASK_NAME like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("TASK_NAME not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("TASK_NAME in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("TASK_NAME not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("TASK_NAME between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("TASK_NAME not between", value1, value2, "taskName");
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

        public Criteria andEngineTypeIsNull() {
            addCriterion("ENGINE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEngineTypeIsNotNull() {
            addCriterion("ENGINE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEngineTypeEqualTo(String value) {
            addCriterion("ENGINE_TYPE =", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotEqualTo(String value) {
            addCriterion("ENGINE_TYPE <>", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeGreaterThan(String value) {
            addCriterion("ENGINE_TYPE >", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ENGINE_TYPE >=", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeLessThan(String value) {
            addCriterion("ENGINE_TYPE <", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeLessThanOrEqualTo(String value) {
            addCriterion("ENGINE_TYPE <=", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeLike(String value) {
            addCriterion("ENGINE_TYPE like", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotLike(String value) {
            addCriterion("ENGINE_TYPE not like", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeIn(List<String> values) {
            addCriterion("ENGINE_TYPE in", values, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotIn(List<String> values) {
            addCriterion("ENGINE_TYPE not in", values, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeBetween(String value1, String value2) {
            addCriterion("ENGINE_TYPE between", value1, value2, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotBetween(String value1, String value2) {
            addCriterion("ENGINE_TYPE not between", value1, value2, "engineType");
            return (Criteria) this;
        }

        public Criteria andExternalIdIsNull() {
            addCriterion("EXTERNAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andExternalIdIsNotNull() {
            addCriterion("EXTERNAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExternalIdEqualTo(String value) {
            addCriterion("EXTERNAL_ID =", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotEqualTo(String value) {
            addCriterion("EXTERNAL_ID <>", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdGreaterThan(String value) {
            addCriterion("EXTERNAL_ID >", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_ID >=", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdLessThan(String value) {
            addCriterion("EXTERNAL_ID <", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdLessThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_ID <=", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdLike(String value) {
            addCriterion("EXTERNAL_ID like", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotLike(String value) {
            addCriterion("EXTERNAL_ID not like", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdIn(List<String> values) {
            addCriterion("EXTERNAL_ID in", values, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotIn(List<String> values) {
            addCriterion("EXTERNAL_ID not in", values, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdBetween(String value1, String value2) {
            addCriterion("EXTERNAL_ID between", value1, value2, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotBetween(String value1, String value2) {
            addCriterion("EXTERNAL_ID not between", value1, value2, "externalId");
            return (Criteria) this;
        }

        public Criteria andSubmitFileIsNull() {
            addCriterion("SUBMIT_FILE is null");
            return (Criteria) this;
        }

        public Criteria andSubmitFileIsNotNull() {
            addCriterion("SUBMIT_FILE is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitFileEqualTo(String value) {
            addCriterion("SUBMIT_FILE =", value, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileNotEqualTo(String value) {
            addCriterion("SUBMIT_FILE <>", value, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileGreaterThan(String value) {
            addCriterion("SUBMIT_FILE >", value, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileGreaterThanOrEqualTo(String value) {
            addCriterion("SUBMIT_FILE >=", value, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileLessThan(String value) {
            addCriterion("SUBMIT_FILE <", value, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileLessThanOrEqualTo(String value) {
            addCriterion("SUBMIT_FILE <=", value, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileLike(String value) {
            addCriterion("SUBMIT_FILE like", value, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileNotLike(String value) {
            addCriterion("SUBMIT_FILE not like", value, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileIn(List<String> values) {
            addCriterion("SUBMIT_FILE in", values, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileNotIn(List<String> values) {
            addCriterion("SUBMIT_FILE not in", values, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileBetween(String value1, String value2) {
            addCriterion("SUBMIT_FILE between", value1, value2, "submitFile");
            return (Criteria) this;
        }

        public Criteria andSubmitFileNotBetween(String value1, String value2) {
            addCriterion("SUBMIT_FILE not between", value1, value2, "submitFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileIsNull() {
            addCriterion("RETURN_FILE is null");
            return (Criteria) this;
        }

        public Criteria andReturnFileIsNotNull() {
            addCriterion("RETURN_FILE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnFileEqualTo(String value) {
            addCriterion("RETURN_FILE =", value, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileNotEqualTo(String value) {
            addCriterion("RETURN_FILE <>", value, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileGreaterThan(String value) {
            addCriterion("RETURN_FILE >", value, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_FILE >=", value, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileLessThan(String value) {
            addCriterion("RETURN_FILE <", value, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileLessThanOrEqualTo(String value) {
            addCriterion("RETURN_FILE <=", value, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileLike(String value) {
            addCriterion("RETURN_FILE like", value, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileNotLike(String value) {
            addCriterion("RETURN_FILE not like", value, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileIn(List<String> values) {
            addCriterion("RETURN_FILE in", values, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileNotIn(List<String> values) {
            addCriterion("RETURN_FILE not in", values, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileBetween(String value1, String value2) {
            addCriterion("RETURN_FILE between", value1, value2, "returnFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileNotBetween(String value1, String value2) {
            addCriterion("RETURN_FILE not between", value1, value2, "returnFile");
            return (Criteria) this;
        }

        public Criteria andLogFileIsNull() {
            addCriterion("LOG_FILE is null");
            return (Criteria) this;
        }

        public Criteria andLogFileIsNotNull() {
            addCriterion("LOG_FILE is not null");
            return (Criteria) this;
        }

        public Criteria andLogFileEqualTo(String value) {
            addCriterion("LOG_FILE =", value, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileNotEqualTo(String value) {
            addCriterion("LOG_FILE <>", value, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileGreaterThan(String value) {
            addCriterion("LOG_FILE >", value, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_FILE >=", value, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileLessThan(String value) {
            addCriterion("LOG_FILE <", value, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileLessThanOrEqualTo(String value) {
            addCriterion("LOG_FILE <=", value, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileLike(String value) {
            addCriterion("LOG_FILE like", value, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileNotLike(String value) {
            addCriterion("LOG_FILE not like", value, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileIn(List<String> values) {
            addCriterion("LOG_FILE in", values, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileNotIn(List<String> values) {
            addCriterion("LOG_FILE not in", values, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileBetween(String value1, String value2) {
            addCriterion("LOG_FILE between", value1, value2, "logFile");
            return (Criteria) this;
        }

        public Criteria andLogFileNotBetween(String value1, String value2) {
            addCriterion("LOG_FILE not between", value1, value2, "logFile");
            return (Criteria) this;
        }

        public Criteria andCostTimeIsNull() {
            addCriterion("COST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCostTimeIsNotNull() {
            addCriterion("COST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCostTimeEqualTo(Long value) {
            addCriterion("COST_TIME =", value, "costTime");
            return (Criteria) this;
        }

        public Criteria andCostTimeNotEqualTo(Long value) {
            addCriterion("COST_TIME <>", value, "costTime");
            return (Criteria) this;
        }

        public Criteria andCostTimeGreaterThan(Long value) {
            addCriterion("COST_TIME >", value, "costTime");
            return (Criteria) this;
        }

        public Criteria andCostTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("COST_TIME >=", value, "costTime");
            return (Criteria) this;
        }

        public Criteria andCostTimeLessThan(Long value) {
            addCriterion("COST_TIME <", value, "costTime");
            return (Criteria) this;
        }

        public Criteria andCostTimeLessThanOrEqualTo(Long value) {
            addCriterion("COST_TIME <=", value, "costTime");
            return (Criteria) this;
        }

        public Criteria andCostTimeIn(List<Long> values) {
            addCriterion("COST_TIME in", values, "costTime");
            return (Criteria) this;
        }

        public Criteria andCostTimeNotIn(List<Long> values) {
            addCriterion("COST_TIME not in", values, "costTime");
            return (Criteria) this;
        }

        public Criteria andCostTimeBetween(Long value1, Long value2) {
            addCriterion("COST_TIME between", value1, value2, "costTime");
            return (Criteria) this;
        }

        public Criteria andCostTimeNotBetween(Long value1, Long value2) {
            addCriterion("COST_TIME not between", value1, value2, "costTime");
            return (Criteria) this;
        }

        public Criteria andTaskProgressIsNull() {
            addCriterion("TASK_PROGRESS is null");
            return (Criteria) this;
        }

        public Criteria andTaskProgressIsNotNull() {
            addCriterion("TASK_PROGRESS is not null");
            return (Criteria) this;
        }

        public Criteria andTaskProgressEqualTo(Integer value) {
            addCriterion("TASK_PROGRESS =", value, "taskProgress");
            return (Criteria) this;
        }

        public Criteria andTaskProgressNotEqualTo(Integer value) {
            addCriterion("TASK_PROGRESS <>", value, "taskProgress");
            return (Criteria) this;
        }

        public Criteria andTaskProgressGreaterThan(Integer value) {
            addCriterion("TASK_PROGRESS >", value, "taskProgress");
            return (Criteria) this;
        }

        public Criteria andTaskProgressGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_PROGRESS >=", value, "taskProgress");
            return (Criteria) this;
        }

        public Criteria andTaskProgressLessThan(Integer value) {
            addCriterion("TASK_PROGRESS <", value, "taskProgress");
            return (Criteria) this;
        }

        public Criteria andTaskProgressLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_PROGRESS <=", value, "taskProgress");
            return (Criteria) this;
        }

        public Criteria andTaskProgressIn(List<Integer> values) {
            addCriterion("TASK_PROGRESS in", values, "taskProgress");
            return (Criteria) this;
        }

        public Criteria andTaskProgressNotIn(List<Integer> values) {
            addCriterion("TASK_PROGRESS not in", values, "taskProgress");
            return (Criteria) this;
        }

        public Criteria andTaskProgressBetween(Integer value1, Integer value2) {
            addCriterion("TASK_PROGRESS between", value1, value2, "taskProgress");
            return (Criteria) this;
        }

        public Criteria andTaskProgressNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_PROGRESS not between", value1, value2, "taskProgress");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNull() {
            addCriterion("TASK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNotNull() {
            addCriterion("TASK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStateEqualTo(Integer value) {
            addCriterion("TASK_STATE =", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotEqualTo(Integer value) {
            addCriterion("TASK_STATE <>", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThan(Integer value) {
            addCriterion("TASK_STATE >", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_STATE >=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThan(Integer value) {
            addCriterion("TASK_STATE <", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_STATE <=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateIn(List<Integer> values) {
            addCriterion("TASK_STATE in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotIn(List<Integer> values) {
            addCriterion("TASK_STATE not in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateBetween(Integer value1, Integer value2) {
            addCriterion("TASK_STATE between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_STATE not between", value1, value2, "taskState");
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

        public Criteria andTaskNameLikeInsensitive(String value) {
            addCriterion("upper(TASK_NAME) like", value.toUpperCase(), "taskName");
            return (Criteria) this;
        }

        public Criteria andEngineTypeLikeInsensitive(String value) {
            addCriterion("upper(ENGINE_TYPE) like", value.toUpperCase(), "engineType");
            return (Criteria) this;
        }

        public Criteria andExternalIdLikeInsensitive(String value) {
            addCriterion("upper(EXTERNAL_ID) like", value.toUpperCase(), "externalId");
            return (Criteria) this;
        }

        public Criteria andSubmitFileLikeInsensitive(String value) {
            addCriterion("upper(SUBMIT_FILE) like", value.toUpperCase(), "submitFile");
            return (Criteria) this;
        }

        public Criteria andReturnFileLikeInsensitive(String value) {
            addCriterion("upper(RETURN_FILE) like", value.toUpperCase(), "returnFile");
            return (Criteria) this;
        }

        public Criteria andLogFileLikeInsensitive(String value) {
            addCriterion("upper(LOG_FILE) like", value.toUpperCase(), "logFile");
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