package com.yatop.lambda.core.enums;

public enum CmptTypeEnum {

    /**
     * 输入输出组件
     */
    IO_CMPT(0, "Input & Output Component"),

    /**
     * 脚本工具组件
     */
    SCRIPT_CMPT(1, "Script Tool Component"),

    /**
     * 数据预处理组件
     */
    PRERPOCESS_CMPT(2, "Data Preprocessing Component"),

    /**
     * 特征工程组件
     */
    FEATURE_CMPT(3, "Feature Engineering Component"),

    /**
     * 统计分析组件
     */
    STATISTICAL_CMPT(4, "Statistical Analysis Component"),

    /**
     * 机器学习组件
     */
    ML_CMPT(5, "Machine Learning Component"),

    /**
     * 深度学习组件
     */
    DP_CMPT(6, "Deep Learning Component"),

    /**
     * 文本分析组件
     */
    TEXT_CMPT(7, "Text Analysis Component"),

    /**
     * 网络分析组件
     */
    NETWORK_CMPT(8, "Network Analysis Component"),

    /**
     * 时间序列组件
     */
    TIME_CMPT(9, "Time Series Component"),

    /**
     * web服务组件
     */
    WEB_CMPT(10, "Web Service Component"),

    /**
     * 业务场景组件
     */
    BUSINESS_CMPT(11, "Business Scenario Component");

    private int type;
    private String name;

    CmptTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
