package com.yatop.lambda.portal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "dw_data_table")
public class DwDataTable {
    /**
     * 数据表ID
     */
    @Id
    @Column(name = "TABLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    /**
     * 数据表名
            
            普通数据表：由英文字符、数字和下划线组成，起始字符不能为下划线
            临时数据表：tmp$<node_id>_<node_port_id>_<job_id>
     */
    @Column(name = "TABLE_NAME")
    private String tableName;

    /**
     * 数据表类型
            0：普通数据表
            1：临时数据表
            2：外部数据表，由在线服务的数据文件输入组件产生，DATA_FILE关联完整文件路径，作业完成时被立即清理
     */
    @Column(name = "TABLE_TYPE")
    private Integer tableType;

    /**
     * 数据表来源
            0：上传导入数据表
            1：保存临时数据表
            2：任务运行输出
     */
    @Column(name = "TABLE_SRC")
    private Integer tableSrc;

    /**
     * 所属数据库ID
     */
    @Column(name = "OWNER_DW_ID")
    private Long ownerDwId;

    /**
     * 关联工作流ID，无关联实验设为-1
     */
    @Column(name = "REL_FLOW_ID")
    private Long relFlowId;

    /**
     * 关联节点ID，创建数据表的工作流节点，无关联则设为-1
     */
    @Column(name = "REL_NODE_ID")
    private Long relNodeId;

    /**
     * 关联特征ID，创建数据表的工作流节点输出特征，无关联则设为-1
     */
    @Column(name = "REL_CHAR_ID")
    private String relCharId;

    /**
     * 关联任务ID，无关联则设为-1
     */
    @Column(name = "REL_TASK_ID")
    private Long relTaskId;

    /**
     * 列数
     */
    @Column(name = "TABLE_COLUMNS")
    private Long tableColumns;

    /**
     * 行数
     */
    @Column(name = "TABLE_ROWS")
    private Long tableRows;

    /**
     * 数据文件类型
            1：Parquet文件格式 
     */
    @Column(name = "DATA_FILE_TYPE")
    private Integer dataFileType;

    /**
     * 文件大小，单位为字节
     */
    @Column(name = "DATA_FILE_SIZE")
    private Long dataFileSize;

    /**
     * 数据文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下
            
            普通数据表：${DATA_DIR}/table_<table_id>.parquet
            临时数据表：${JOB_DIR}/table_<task_id>_<table_id>.parquet
     */
    @Column(name = "DATA_FILE")
    private String dataFile;

    /**
     * 数据概要文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下
            
            普通数据表：${DATA_DIR}/table_summary_<table_id>.parquet
            临时数据表：${JOB_DIR}/table_summary_<task_id>_<table_id>.parquet
     */
    @Column(name = "DATA_SUMMARY_FILE")
    private String dataSummaryFile;

    /**
     * 数据表状态
            0：空表
            1：正常
            2：仅概要文件
     */
    @Column(name = "TABLE_STATE")
    private Integer tableState;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 状态
            0：正常
            1：失效
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 最后更新时间
     */
    @Column(name = "LAST_UPDATE_TIME")
    private Date lastUpdateTime;

    /**
     * 最后更新用户
     */
    @Column(name = "LAST_UPDATE_OPER")
    private String lastUpdateOper;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建用户
     */
    @Column(name = "CREATE_OPER")
    private String createOper;

    /**
     * 获取数据表ID
     *
     * @return TABLE_ID - 数据表ID
     */
    public Long getTableId() {
        return tableId;
    }

    /**
     * 设置数据表ID
     *
     * @param tableId 数据表ID
     */
    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    /**
     * 获取数据表名
            
            普通数据表：由英文字符、数字和下划线组成，起始字符不能为下划线
            临时数据表：tmp$<node_id>_<node_port_id>_<job_id>
     *
     * @return TABLE_NAME - 数据表名
            
            普通数据表：由英文字符、数字和下划线组成，起始字符不能为下划线
            临时数据表：tmp$<node_id>_<node_port_id>_<job_id>
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置数据表名
            
            普通数据表：由英文字符、数字和下划线组成，起始字符不能为下划线
            临时数据表：tmp$<node_id>_<node_port_id>_<job_id>
     *
     * @param tableName 数据表名
            
            普通数据表：由英文字符、数字和下划线组成，起始字符不能为下划线
            临时数据表：tmp$<node_id>_<node_port_id>_<job_id>
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 获取数据表类型
            0：普通数据表
            1：临时数据表
            2：外部数据表，由在线服务的数据文件输入组件产生，DATA_FILE关联完整文件路径，作业完成时被立即清理
     *
     * @return TABLE_TYPE - 数据表类型
            0：普通数据表
            1：临时数据表
            2：外部数据表，由在线服务的数据文件输入组件产生，DATA_FILE关联完整文件路径，作业完成时被立即清理
     */
    public Integer getTableType() {
        return tableType;
    }

    /**
     * 设置数据表类型
            0：普通数据表
            1：临时数据表
            2：外部数据表，由在线服务的数据文件输入组件产生，DATA_FILE关联完整文件路径，作业完成时被立即清理
     *
     * @param tableType 数据表类型
            0：普通数据表
            1：临时数据表
            2：外部数据表，由在线服务的数据文件输入组件产生，DATA_FILE关联完整文件路径，作业完成时被立即清理
     */
    public void setTableType(Integer tableType) {
        this.tableType = tableType;
    }

    /**
     * 获取数据表来源
            0：上传导入数据表
            1：保存临时数据表
            2：任务运行输出
     *
     * @return TABLE_SRC - 数据表来源
            0：上传导入数据表
            1：保存临时数据表
            2：任务运行输出
     */
    public Integer getTableSrc() {
        return tableSrc;
    }

    /**
     * 设置数据表来源
            0：上传导入数据表
            1：保存临时数据表
            2：任务运行输出
     *
     * @param tableSrc 数据表来源
            0：上传导入数据表
            1：保存临时数据表
            2：任务运行输出
     */
    public void setTableSrc(Integer tableSrc) {
        this.tableSrc = tableSrc;
    }

    /**
     * 获取所属数据库ID
     *
     * @return OWNER_DW_ID - 所属数据库ID
     */
    public Long getOwnerDwId() {
        return ownerDwId;
    }

    /**
     * 设置所属数据库ID
     *
     * @param ownerDwId 所属数据库ID
     */
    public void setOwnerDwId(Long ownerDwId) {
        this.ownerDwId = ownerDwId;
    }

    /**
     * 获取关联工作流ID，无关联实验设为-1
     *
     * @return REL_FLOW_ID - 关联工作流ID，无关联实验设为-1
     */
    public Long getRelFlowId() {
        return relFlowId;
    }

    /**
     * 设置关联工作流ID，无关联实验设为-1
     *
     * @param relFlowId 关联工作流ID，无关联实验设为-1
     */
    public void setRelFlowId(Long relFlowId) {
        this.relFlowId = relFlowId;
    }

    /**
     * 获取关联节点ID，创建数据表的工作流节点，无关联则设为-1
     *
     * @return REL_NODE_ID - 关联节点ID，创建数据表的工作流节点，无关联则设为-1
     */
    public Long getRelNodeId() {
        return relNodeId;
    }

    /**
     * 设置关联节点ID，创建数据表的工作流节点，无关联则设为-1
     *
     * @param relNodeId 关联节点ID，创建数据表的工作流节点，无关联则设为-1
     */
    public void setRelNodeId(Long relNodeId) {
        this.relNodeId = relNodeId;
    }

    /**
     * 获取关联特征ID，创建数据表的工作流节点输出特征，无关联则设为-1
     *
     * @return REL_CHAR_ID - 关联特征ID，创建数据表的工作流节点输出特征，无关联则设为-1
     */
    public String getRelCharId() {
        return relCharId;
    }

    /**
     * 设置关联特征ID，创建数据表的工作流节点输出特征，无关联则设为-1
     *
     * @param relCharId 关联特征ID，创建数据表的工作流节点输出特征，无关联则设为-1
     */
    public void setRelCharId(String relCharId) {
        this.relCharId = relCharId == null ? null : relCharId.trim();
    }

    /**
     * 获取关联任务ID，无关联则设为-1
     *
     * @return REL_TASK_ID - 关联任务ID，无关联则设为-1
     */
    public Long getRelTaskId() {
        return relTaskId;
    }

    /**
     * 设置关联任务ID，无关联则设为-1
     *
     * @param relTaskId 关联任务ID，无关联则设为-1
     */
    public void setRelTaskId(Long relTaskId) {
        this.relTaskId = relTaskId;
    }

    /**
     * 获取列数
     *
     * @return TABLE_COLUMNS - 列数
     */
    public Long getTableColumns() {
        return tableColumns;
    }

    /**
     * 设置列数
     *
     * @param tableColumns 列数
     */
    public void setTableColumns(Long tableColumns) {
        this.tableColumns = tableColumns;
    }

    /**
     * 获取行数
     *
     * @return TABLE_ROWS - 行数
     */
    public Long getTableRows() {
        return tableRows;
    }

    /**
     * 设置行数
     *
     * @param tableRows 行数
     */
    public void setTableRows(Long tableRows) {
        this.tableRows = tableRows;
    }

    /**
     * 获取数据文件类型
            1：Parquet文件格式 
     *
     * @return DATA_FILE_TYPE - 数据文件类型
            1：Parquet文件格式 
     */
    public Integer getDataFileType() {
        return dataFileType;
    }

    /**
     * 设置数据文件类型
            1：Parquet文件格式 
     *
     * @param dataFileType 数据文件类型
            1：Parquet文件格式 
     */
    public void setDataFileType(Integer dataFileType) {
        this.dataFileType = dataFileType;
    }

    /**
     * 获取文件大小，单位为字节
     *
     * @return DATA_FILE_SIZE - 文件大小，单位为字节
     */
    public Long getDataFileSize() {
        return dataFileSize;
    }

    /**
     * 设置文件大小，单位为字节
     *
     * @param dataFileSize 文件大小，单位为字节
     */
    public void setDataFileSize(Long dataFileSize) {
        this.dataFileSize = dataFileSize;
    }

    /**
     * 获取数据文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下
            
            普通数据表：${DATA_DIR}/table_<table_id>.parquet
            临时数据表：${JOB_DIR}/table_<task_id>_<table_id>.parquet
     *
     * @return DATA_FILE - 数据文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下
            
            普通数据表：${DATA_DIR}/table_<table_id>.parquet
            临时数据表：${JOB_DIR}/table_<task_id>_<table_id>.parquet
     */
    public String getDataFile() {
        return dataFile;
    }

    /**
     * 设置数据文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下
            
            普通数据表：${DATA_DIR}/table_<table_id>.parquet
            临时数据表：${JOB_DIR}/table_<task_id>_<table_id>.parquet
     *
     * @param dataFile 数据文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下
            
            普通数据表：${DATA_DIR}/table_<table_id>.parquet
            临时数据表：${JOB_DIR}/table_<task_id>_<table_id>.parquet
     */
    public void setDataFile(String dataFile) {
        this.dataFile = dataFile == null ? null : dataFile.trim();
    }

    /**
     * 获取数据概要文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下
            
            普通数据表：${DATA_DIR}/table_summary_<table_id>.parquet
            临时数据表：${JOB_DIR}/table_summary_<task_id>_<table_id>.parquet
     *
     * @return DATA_SUMMARY_FILE - 数据概要文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下
            
            普通数据表：${DATA_DIR}/table_summary_<table_id>.parquet
            临时数据表：${JOB_DIR}/table_summary_<task_id>_<table_id>.parquet
     */
    public String getDataSummaryFile() {
        return dataSummaryFile;
    }

    /**
     * 设置数据概要文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下
            
            普通数据表：${DATA_DIR}/table_summary_<table_id>.parquet
            临时数据表：${JOB_DIR}/table_summary_<task_id>_<table_id>.parquet
     *
     * @param dataSummaryFile 数据概要文件名，普通数据表存放于数据目录下，临时数据表存放于作业目录下
            
            普通数据表：${DATA_DIR}/table_summary_<table_id>.parquet
            临时数据表：${JOB_DIR}/table_summary_<task_id>_<table_id>.parquet
     */
    public void setDataSummaryFile(String dataSummaryFile) {
        this.dataSummaryFile = dataSummaryFile == null ? null : dataSummaryFile.trim();
    }

    /**
     * 获取数据表状态
            0：空表
            1：正常
            2：仅概要文件
     *
     * @return TABLE_STATE - 数据表状态
            0：空表
            1：正常
            2：仅概要文件
     */
    public Integer getTableState() {
        return tableState;
    }

    /**
     * 设置数据表状态
            0：空表
            1：正常
            2：仅概要文件
     *
     * @param tableState 数据表状态
            0：空表
            1：正常
            2：仅概要文件
     */
    public void setTableState(Integer tableState) {
        this.tableState = tableState;
    }

    /**
     * 获取描述
     *
     * @return DESCRIPTION - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取状态
            0：正常
            1：失效
     *
     * @return STATUS - 状态
            0：正常
            1：失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
            0：正常
            1：失效
     *
     * @param status 状态
            0：正常
            1：失效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取最后更新时间
     *
     * @return LAST_UPDATE_TIME - 最后更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastUpdateTime 最后更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取最后更新用户
     *
     * @return LAST_UPDATE_OPER - 最后更新用户
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * 设置最后更新用户
     *
     * @param lastUpdateOper 最后更新用户
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建用户
     *
     * @return CREATE_OPER - 创建用户
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * 设置创建用户
     *
     * @param createOper 创建用户
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
    }
}