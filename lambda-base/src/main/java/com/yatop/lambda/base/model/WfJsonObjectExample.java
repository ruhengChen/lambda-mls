package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfJsonObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WfJsonObjectExample() {
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

        public Criteria andObjectIdIsNull() {
            addCriterion("OBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("OBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(Long value) {
            addCriterion("OBJECT_ID =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(Long value) {
            addCriterion("OBJECT_ID <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(Long value) {
            addCriterion("OBJECT_ID >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OBJECT_ID >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(Long value) {
            addCriterion("OBJECT_ID <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(Long value) {
            addCriterion("OBJECT_ID <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(List<Long> values) {
            addCriterion("OBJECT_ID in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(List<Long> values) {
            addCriterion("OBJECT_ID not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(Long value1, Long value2) {
            addCriterion("OBJECT_ID between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(Long value1, Long value2) {
            addCriterion("OBJECT_ID not between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectNameIsNull() {
            addCriterion("OBJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andObjectNameIsNotNull() {
            addCriterion("OBJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andObjectNameEqualTo(String value) {
            addCriterion("OBJECT_NAME =", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameNotEqualTo(String value) {
            addCriterion("OBJECT_NAME <>", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameGreaterThan(String value) {
            addCriterion("OBJECT_NAME >", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("OBJECT_NAME >=", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameLessThan(String value) {
            addCriterion("OBJECT_NAME <", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameLessThanOrEqualTo(String value) {
            addCriterion("OBJECT_NAME <=", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameLike(String value) {
            addCriterion("OBJECT_NAME like", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameNotLike(String value) {
            addCriterion("OBJECT_NAME not like", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameIn(List<String> values) {
            addCriterion("OBJECT_NAME in", values, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameNotIn(List<String> values) {
            addCriterion("OBJECT_NAME not in", values, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameBetween(String value1, String value2) {
            addCriterion("OBJECT_NAME between", value1, value2, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameNotBetween(String value1, String value2) {
            addCriterion("OBJECT_NAME not between", value1, value2, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeIsNull() {
            addCriterion("OBJECTY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeIsNotNull() {
            addCriterion("OBJECTY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeEqualTo(Integer value) {
            addCriterion("OBJECTY_TYPE =", value, "objectyType");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeNotEqualTo(Integer value) {
            addCriterion("OBJECTY_TYPE <>", value, "objectyType");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeGreaterThan(Integer value) {
            addCriterion("OBJECTY_TYPE >", value, "objectyType");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OBJECTY_TYPE >=", value, "objectyType");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeLessThan(Integer value) {
            addCriterion("OBJECTY_TYPE <", value, "objectyType");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("OBJECTY_TYPE <=", value, "objectyType");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeIn(List<Integer> values) {
            addCriterion("OBJECTY_TYPE in", values, "objectyType");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeNotIn(List<Integer> values) {
            addCriterion("OBJECTY_TYPE not in", values, "objectyType");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeBetween(Integer value1, Integer value2) {
            addCriterion("OBJECTY_TYPE between", value1, value2, "objectyType");
            return (Criteria) this;
        }

        public Criteria andObjectyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OBJECTY_TYPE not between", value1, value2, "objectyType");
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

        public Criteria andStorageLocationIsNull() {
            addCriterion("STORAGE_LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andStorageLocationIsNotNull() {
            addCriterion("STORAGE_LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andStorageLocationEqualTo(Integer value) {
            addCriterion("STORAGE_LOCATION =", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationNotEqualTo(Integer value) {
            addCriterion("STORAGE_LOCATION <>", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationGreaterThan(Integer value) {
            addCriterion("STORAGE_LOCATION >", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationGreaterThanOrEqualTo(Integer value) {
            addCriterion("STORAGE_LOCATION >=", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationLessThan(Integer value) {
            addCriterion("STORAGE_LOCATION <", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationLessThanOrEqualTo(Integer value) {
            addCriterion("STORAGE_LOCATION <=", value, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationIn(List<Integer> values) {
            addCriterion("STORAGE_LOCATION in", values, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationNotIn(List<Integer> values) {
            addCriterion("STORAGE_LOCATION not in", values, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationBetween(Integer value1, Integer value2) {
            addCriterion("STORAGE_LOCATION between", value1, value2, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andStorageLocationNotBetween(Integer value1, Integer value2) {
            addCriterion("STORAGE_LOCATION not between", value1, value2, "storageLocation");
            return (Criteria) this;
        }

        public Criteria andObjectFileIsNull() {
            addCriterion("OBJECT_FILE is null");
            return (Criteria) this;
        }

        public Criteria andObjectFileIsNotNull() {
            addCriterion("OBJECT_FILE is not null");
            return (Criteria) this;
        }

        public Criteria andObjectFileEqualTo(String value) {
            addCriterion("OBJECT_FILE =", value, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileNotEqualTo(String value) {
            addCriterion("OBJECT_FILE <>", value, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileGreaterThan(String value) {
            addCriterion("OBJECT_FILE >", value, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileGreaterThanOrEqualTo(String value) {
            addCriterion("OBJECT_FILE >=", value, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileLessThan(String value) {
            addCriterion("OBJECT_FILE <", value, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileLessThanOrEqualTo(String value) {
            addCriterion("OBJECT_FILE <=", value, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileLike(String value) {
            addCriterion("OBJECT_FILE like", value, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileNotLike(String value) {
            addCriterion("OBJECT_FILE not like", value, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileIn(List<String> values) {
            addCriterion("OBJECT_FILE in", values, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileNotIn(List<String> values) {
            addCriterion("OBJECT_FILE not in", values, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileBetween(String value1, String value2) {
            addCriterion("OBJECT_FILE between", value1, value2, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectFileNotBetween(String value1, String value2) {
            addCriterion("OBJECT_FILE not between", value1, value2, "objectFile");
            return (Criteria) this;
        }

        public Criteria andObjectStateIsNull() {
            addCriterion("OBJECT_STATE is null");
            return (Criteria) this;
        }

        public Criteria andObjectStateIsNotNull() {
            addCriterion("OBJECT_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andObjectStateEqualTo(Integer value) {
            addCriterion("OBJECT_STATE =", value, "objectState");
            return (Criteria) this;
        }

        public Criteria andObjectStateNotEqualTo(Integer value) {
            addCriterion("OBJECT_STATE <>", value, "objectState");
            return (Criteria) this;
        }

        public Criteria andObjectStateGreaterThan(Integer value) {
            addCriterion("OBJECT_STATE >", value, "objectState");
            return (Criteria) this;
        }

        public Criteria andObjectStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("OBJECT_STATE >=", value, "objectState");
            return (Criteria) this;
        }

        public Criteria andObjectStateLessThan(Integer value) {
            addCriterion("OBJECT_STATE <", value, "objectState");
            return (Criteria) this;
        }

        public Criteria andObjectStateLessThanOrEqualTo(Integer value) {
            addCriterion("OBJECT_STATE <=", value, "objectState");
            return (Criteria) this;
        }

        public Criteria andObjectStateIn(List<Integer> values) {
            addCriterion("OBJECT_STATE in", values, "objectState");
            return (Criteria) this;
        }

        public Criteria andObjectStateNotIn(List<Integer> values) {
            addCriterion("OBJECT_STATE not in", values, "objectState");
            return (Criteria) this;
        }

        public Criteria andObjectStateBetween(Integer value1, Integer value2) {
            addCriterion("OBJECT_STATE between", value1, value2, "objectState");
            return (Criteria) this;
        }

        public Criteria andObjectStateNotBetween(Integer value1, Integer value2) {
            addCriterion("OBJECT_STATE not between", value1, value2, "objectState");
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

        public Criteria andObjectNameLikeInsensitive(String value) {
            addCriterion("upper(OBJECT_NAME) like", value.toUpperCase(), "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectFileLikeInsensitive(String value) {
            addCriterion("upper(OBJECT_FILE) like", value.toUpperCase(), "objectFile");
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