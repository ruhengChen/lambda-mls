package com.yatop.lambda.core.enums;

public enum SystemParameterEnum {

    PR_CACHE_DATA_EXPIRE_DAYS(          "PR_CACHE_DATA_EXPIRE_DAYS",        "项目管理 | 临时缓存数据表过期天数","21"),
    WK_FLOW_MAX_NODES(                  "WK_FLOW_MAX_NODES",                "工作流引擎 | 工作流正常节点最大数量","512"),
    WK_FLOW_MAX_TABLE_FIELDS(           "WK_FLOW_MAX_TABLE_FIELDS",         "工作流引擎 | 数据表最大字段数量","1024"),
    WK_FLOW_MAX_GLOBAL_PARAMETERS(      "WK_FLOW_MAX_TABLE_FIELDS",         "工作流引擎 | 工作流最大全局参数数量","16"),
    CF_HDFS_SITE_defaultFS(             "CF_HDFS_SITE_defaultFS",           "计算框架 | HDFS默认文件系统", "hdfs://127.0.0.1:9000"),
    CF_HDFS_WORK_ROOT(                  "CF_HDFS_WORK_ROOT",                "计算框架 | HDFS工作根目录","/user/lambda_mls"),
    CF_LOCAL_WORK_ROOT(                 "CF_LOCAL_WORK_ROOT",               "计算框架 | 本地工作根目录","/opt/lambda_mls"),
    CF_JOB_FILE_DIR_NAME(               "CF_JOB_FILE_DIR_NAME",             "计算框架 | 作业文件存放目录名","proc"),
    CF_DATA_FILE_DIR_NAME(              "CF_DATA_FILE_DIR_NAME",            "计算框架 | 数据文件存放目录名","dw_data"),
    CF_MODEL_FILE_DIR_NAME(             "CF_MODEL_FILE_DIR_NAME",           "计算框架 | 模型文件存放目录名","mw_data"),
    CF_FLOW_FILE_DIR_NAME(              "CF_FLOW_FILE_DIR_NAME",            "计算框架 | 工作流文件存放目录名","flow_data"),
    CF_LIB_FILE_DIR_NAME(               "CF_LIB_FILE_DIR_NAME",             "计算框架 | 库文件存放目录名","lib"),
    CF_HDFS_COMPONENT_JAR_DIR(          "CF_HDFS_COMPONENT_JAR_DIR",        "计算框架 | hdfs scala组件jar包目录","/user/lambda_mls/lib/spark"),
    CF_HDFS_COMPONENTT_JAR_FILE(        "CF_HDFS_COMPONENTT_JAR_FILE",      "计算框架 | hdfs scala组件jar包文件名","lambda-component-1.0.0.jar"),
    CF_SPARK_EXECUTOR_NUMBER(           "CF_SPARK_EXECUTOR_NUMBER",         "计算框架 | spark executor数量","2"),
    CF_SPARK_EXECUTOR_CORES(            "CF_SPARK_EXECUTOR_CORES",          "计算框架 | spark executor线程数量","8"),
    CF_SPARK_EXECUTOR_MEMORY(           "CF_SPARK_EXECUTOR_MEMORY",         "计算框架 | spark executor内存大小","2048"),
    CF_SPARK_DRIVER_CORES(              "CF_SPARK_DRIVER_CORES",            "计算框架 | spark driver线程数量","8"),
    CF_SPARK_DRIVER_MEMORY(             "CF_SPARK_DRIVER_MEMORY",           "计算框架 | spark driver内存大小","2048");

    private String paramCode;
    private String paramName;
    private String paramDefaultValue;

    public String getParamCode() {
        return paramCode;
    }

    public String getParamName() {
        return paramName;
    }

    public String getParamDefaultValue() {
        return paramDefaultValue;
    }

    SystemParameterEnum(String paramCode, String paramName, String paramDefaultValue) {
        this.paramCode = paramCode;
        this.paramName = paramName;
        this.paramDefaultValue = paramDefaultValue;
    }
}
