package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MwModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public MwModelExample() {
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

        public Criteria andModelIdIsNull() {
            addCriterion("MODEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("MODEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Long value) {
            addCriterion("MODEL_ID =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Long value) {
            addCriterion("MODEL_ID <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Long value) {
            addCriterion("MODEL_ID >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MODEL_ID >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Long value) {
            addCriterion("MODEL_ID <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Long value) {
            addCriterion("MODEL_ID <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Long> values) {
            addCriterion("MODEL_ID in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Long> values) {
            addCriterion("MODEL_ID not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Long value1, Long value2) {
            addCriterion("MODEL_ID between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Long value1, Long value2) {
            addCriterion("MODEL_ID not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("MODEL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("MODEL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("MODEL_NAME =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("MODEL_NAME <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("MODEL_NAME >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("MODEL_NAME <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("MODEL_NAME like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("MODEL_NAME not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("MODEL_NAME in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("MODEL_NAME not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("MODEL_NAME between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("MODEL_NAME not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNull() {
            addCriterion("MODEL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNotNull() {
            addCriterion("MODEL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeEqualTo(Integer value) {
            addCriterion("MODEL_TYPE =", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotEqualTo(Integer value) {
            addCriterion("MODEL_TYPE <>", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThan(Integer value) {
            addCriterion("MODEL_TYPE >", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MODEL_TYPE >=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThan(Integer value) {
            addCriterion("MODEL_TYPE <", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("MODEL_TYPE <=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeIn(List<Integer> values) {
            addCriterion("MODEL_TYPE in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotIn(List<Integer> values) {
            addCriterion("MODEL_TYPE not in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_TYPE between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_TYPE not between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelSrcIsNull() {
            addCriterion("MODEL_SRC is null");
            return (Criteria) this;
        }

        public Criteria andModelSrcIsNotNull() {
            addCriterion("MODEL_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andModelSrcEqualTo(Integer value) {
            addCriterion("MODEL_SRC =", value, "modelSrc");
            return (Criteria) this;
        }

        public Criteria andModelSrcNotEqualTo(Integer value) {
            addCriterion("MODEL_SRC <>", value, "modelSrc");
            return (Criteria) this;
        }

        public Criteria andModelSrcGreaterThan(Integer value) {
            addCriterion("MODEL_SRC >", value, "modelSrc");
            return (Criteria) this;
        }

        public Criteria andModelSrcGreaterThanOrEqualTo(Integer value) {
            addCriterion("MODEL_SRC >=", value, "modelSrc");
            return (Criteria) this;
        }

        public Criteria andModelSrcLessThan(Integer value) {
            addCriterion("MODEL_SRC <", value, "modelSrc");
            return (Criteria) this;
        }

        public Criteria andModelSrcLessThanOrEqualTo(Integer value) {
            addCriterion("MODEL_SRC <=", value, "modelSrc");
            return (Criteria) this;
        }

        public Criteria andModelSrcIn(List<Integer> values) {
            addCriterion("MODEL_SRC in", values, "modelSrc");
            return (Criteria) this;
        }

        public Criteria andModelSrcNotIn(List<Integer> values) {
            addCriterion("MODEL_SRC not in", values, "modelSrc");
            return (Criteria) this;
        }

        public Criteria andModelSrcBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_SRC between", value1, value2, "modelSrc");
            return (Criteria) this;
        }

        public Criteria andModelSrcNotBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_SRC not between", value1, value2, "modelSrc");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdIsNull() {
            addCriterion("OWNER_MW_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdIsNotNull() {
            addCriterion("OWNER_MW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdEqualTo(Long value) {
            addCriterion("OWNER_MW_ID =", value, "ownerMwId");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdNotEqualTo(Long value) {
            addCriterion("OWNER_MW_ID <>", value, "ownerMwId");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdGreaterThan(Long value) {
            addCriterion("OWNER_MW_ID >", value, "ownerMwId");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OWNER_MW_ID >=", value, "ownerMwId");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdLessThan(Long value) {
            addCriterion("OWNER_MW_ID <", value, "ownerMwId");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdLessThanOrEqualTo(Long value) {
            addCriterion("OWNER_MW_ID <=", value, "ownerMwId");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdIn(List<Long> values) {
            addCriterion("OWNER_MW_ID in", values, "ownerMwId");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdNotIn(List<Long> values) {
            addCriterion("OWNER_MW_ID not in", values, "ownerMwId");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdBetween(Long value1, Long value2) {
            addCriterion("OWNER_MW_ID between", value1, value2, "ownerMwId");
            return (Criteria) this;
        }

        public Criteria andOwnerMwIdNotBetween(Long value1, Long value2) {
            addCriterion("OWNER_MW_ID not between", value1, value2, "ownerMwId");
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

        public Criteria andRefAlgorithmIdIsNull() {
            addCriterion("REF_ALGORITHM_ID is null");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdIsNotNull() {
            addCriterion("REF_ALGORITHM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdEqualTo(Long value) {
            addCriterion("REF_ALGORITHM_ID =", value, "refAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdNotEqualTo(Long value) {
            addCriterion("REF_ALGORITHM_ID <>", value, "refAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdGreaterThan(Long value) {
            addCriterion("REF_ALGORITHM_ID >", value, "refAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REF_ALGORITHM_ID >=", value, "refAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdLessThan(Long value) {
            addCriterion("REF_ALGORITHM_ID <", value, "refAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdLessThanOrEqualTo(Long value) {
            addCriterion("REF_ALGORITHM_ID <=", value, "refAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdIn(List<Long> values) {
            addCriterion("REF_ALGORITHM_ID in", values, "refAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdNotIn(List<Long> values) {
            addCriterion("REF_ALGORITHM_ID not in", values, "refAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdBetween(Long value1, Long value2) {
            addCriterion("REF_ALGORITHM_ID between", value1, value2, "refAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRefAlgorithmIdNotBetween(Long value1, Long value2) {
            addCriterion("REF_ALGORITHM_ID not between", value1, value2, "refAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeIsNull() {
            addCriterion("MODEL_FILE_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeIsNotNull() {
            addCriterion("MODEL_FILE_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeEqualTo(Long value) {
            addCriterion("MODEL_FILE_SIZE =", value, "modelFileSize");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeNotEqualTo(Long value) {
            addCriterion("MODEL_FILE_SIZE <>", value, "modelFileSize");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeGreaterThan(Long value) {
            addCriterion("MODEL_FILE_SIZE >", value, "modelFileSize");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("MODEL_FILE_SIZE >=", value, "modelFileSize");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeLessThan(Long value) {
            addCriterion("MODEL_FILE_SIZE <", value, "modelFileSize");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("MODEL_FILE_SIZE <=", value, "modelFileSize");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeIn(List<Long> values) {
            addCriterion("MODEL_FILE_SIZE in", values, "modelFileSize");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeNotIn(List<Long> values) {
            addCriterion("MODEL_FILE_SIZE not in", values, "modelFileSize");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeBetween(Long value1, Long value2) {
            addCriterion("MODEL_FILE_SIZE between", value1, value2, "modelFileSize");
            return (Criteria) this;
        }

        public Criteria andModelFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("MODEL_FILE_SIZE not between", value1, value2, "modelFileSize");
            return (Criteria) this;
        }

        public Criteria andModelFileIsNull() {
            addCriterion("MODEL_FILE is null");
            return (Criteria) this;
        }

        public Criteria andModelFileIsNotNull() {
            addCriterion("MODEL_FILE is not null");
            return (Criteria) this;
        }

        public Criteria andModelFileEqualTo(String value) {
            addCriterion("MODEL_FILE =", value, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileNotEqualTo(String value) {
            addCriterion("MODEL_FILE <>", value, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileGreaterThan(String value) {
            addCriterion("MODEL_FILE >", value, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_FILE >=", value, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileLessThan(String value) {
            addCriterion("MODEL_FILE <", value, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileLessThanOrEqualTo(String value) {
            addCriterion("MODEL_FILE <=", value, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileLike(String value) {
            addCriterion("MODEL_FILE like", value, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileNotLike(String value) {
            addCriterion("MODEL_FILE not like", value, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileIn(List<String> values) {
            addCriterion("MODEL_FILE in", values, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileNotIn(List<String> values) {
            addCriterion("MODEL_FILE not in", values, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileBetween(String value1, String value2) {
            addCriterion("MODEL_FILE between", value1, value2, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelFileNotBetween(String value1, String value2) {
            addCriterion("MODEL_FILE not between", value1, value2, "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileIsNull() {
            addCriterion("MODEL_SUMMARY_FILE is null");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileIsNotNull() {
            addCriterion("MODEL_SUMMARY_FILE is not null");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileEqualTo(String value) {
            addCriterion("MODEL_SUMMARY_FILE =", value, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileNotEqualTo(String value) {
            addCriterion("MODEL_SUMMARY_FILE <>", value, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileGreaterThan(String value) {
            addCriterion("MODEL_SUMMARY_FILE >", value, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_SUMMARY_FILE >=", value, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileLessThan(String value) {
            addCriterion("MODEL_SUMMARY_FILE <", value, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileLessThanOrEqualTo(String value) {
            addCriterion("MODEL_SUMMARY_FILE <=", value, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileLike(String value) {
            addCriterion("MODEL_SUMMARY_FILE like", value, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileNotLike(String value) {
            addCriterion("MODEL_SUMMARY_FILE not like", value, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileIn(List<String> values) {
            addCriterion("MODEL_SUMMARY_FILE in", values, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileNotIn(List<String> values) {
            addCriterion("MODEL_SUMMARY_FILE not in", values, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileBetween(String value1, String value2) {
            addCriterion("MODEL_SUMMARY_FILE between", value1, value2, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileNotBetween(String value1, String value2) {
            addCriterion("MODEL_SUMMARY_FILE not between", value1, value2, "modelSummaryFile");
            return (Criteria) this;
        }

        public Criteria andModelStateIsNull() {
            addCriterion("MODEL_STATE is null");
            return (Criteria) this;
        }

        public Criteria andModelStateIsNotNull() {
            addCriterion("MODEL_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andModelStateEqualTo(Integer value) {
            addCriterion("MODEL_STATE =", value, "modelState");
            return (Criteria) this;
        }

        public Criteria andModelStateNotEqualTo(Integer value) {
            addCriterion("MODEL_STATE <>", value, "modelState");
            return (Criteria) this;
        }

        public Criteria andModelStateGreaterThan(Integer value) {
            addCriterion("MODEL_STATE >", value, "modelState");
            return (Criteria) this;
        }

        public Criteria andModelStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("MODEL_STATE >=", value, "modelState");
            return (Criteria) this;
        }

        public Criteria andModelStateLessThan(Integer value) {
            addCriterion("MODEL_STATE <", value, "modelState");
            return (Criteria) this;
        }

        public Criteria andModelStateLessThanOrEqualTo(Integer value) {
            addCriterion("MODEL_STATE <=", value, "modelState");
            return (Criteria) this;
        }

        public Criteria andModelStateIn(List<Integer> values) {
            addCriterion("MODEL_STATE in", values, "modelState");
            return (Criteria) this;
        }

        public Criteria andModelStateNotIn(List<Integer> values) {
            addCriterion("MODEL_STATE not in", values, "modelState");
            return (Criteria) this;
        }

        public Criteria andModelStateBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_STATE between", value1, value2, "modelState");
            return (Criteria) this;
        }

        public Criteria andModelStateNotBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_STATE not between", value1, value2, "modelState");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdIsNull() {
            addCriterion("TRAIN_TABLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdIsNotNull() {
            addCriterion("TRAIN_TABLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdEqualTo(Long value) {
            addCriterion("TRAIN_TABLE_ID =", value, "trainTableId");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdNotEqualTo(Long value) {
            addCriterion("TRAIN_TABLE_ID <>", value, "trainTableId");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdGreaterThan(Long value) {
            addCriterion("TRAIN_TABLE_ID >", value, "trainTableId");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TRAIN_TABLE_ID >=", value, "trainTableId");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdLessThan(Long value) {
            addCriterion("TRAIN_TABLE_ID <", value, "trainTableId");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdLessThanOrEqualTo(Long value) {
            addCriterion("TRAIN_TABLE_ID <=", value, "trainTableId");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdIn(List<Long> values) {
            addCriterion("TRAIN_TABLE_ID in", values, "trainTableId");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdNotIn(List<Long> values) {
            addCriterion("TRAIN_TABLE_ID not in", values, "trainTableId");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdBetween(Long value1, Long value2) {
            addCriterion("TRAIN_TABLE_ID between", value1, value2, "trainTableId");
            return (Criteria) this;
        }

        public Criteria andTrainTableIdNotBetween(Long value1, Long value2) {
            addCriterion("TRAIN_TABLE_ID not between", value1, value2, "trainTableId");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeIsNull() {
            addCriterion("TRAIN_COST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeIsNotNull() {
            addCriterion("TRAIN_COST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeEqualTo(Long value) {
            addCriterion("TRAIN_COST_TIME =", value, "trainCostTime");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeNotEqualTo(Long value) {
            addCriterion("TRAIN_COST_TIME <>", value, "trainCostTime");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeGreaterThan(Long value) {
            addCriterion("TRAIN_COST_TIME >", value, "trainCostTime");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("TRAIN_COST_TIME >=", value, "trainCostTime");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeLessThan(Long value) {
            addCriterion("TRAIN_COST_TIME <", value, "trainCostTime");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeLessThanOrEqualTo(Long value) {
            addCriterion("TRAIN_COST_TIME <=", value, "trainCostTime");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeIn(List<Long> values) {
            addCriterion("TRAIN_COST_TIME in", values, "trainCostTime");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeNotIn(List<Long> values) {
            addCriterion("TRAIN_COST_TIME not in", values, "trainCostTime");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeBetween(Long value1, Long value2) {
            addCriterion("TRAIN_COST_TIME between", value1, value2, "trainCostTime");
            return (Criteria) this;
        }

        public Criteria andTrainCostTimeNotBetween(Long value1, Long value2) {
            addCriterion("TRAIN_COST_TIME not between", value1, value2, "trainCostTime");
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

        public Criteria andModelNameLikeInsensitive(String value) {
            addCriterion("upper(MODEL_NAME) like", value.toUpperCase(), "modelName");
            return (Criteria) this;
        }

        public Criteria andModelFileLikeInsensitive(String value) {
            addCriterion("upper(MODEL_FILE) like", value.toUpperCase(), "modelFile");
            return (Criteria) this;
        }

        public Criteria andModelSummaryFileLikeInsensitive(String value) {
            addCriterion("upper(MODEL_SUMMARY_FILE) like", value.toUpperCase(), "modelSummaryFile");
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