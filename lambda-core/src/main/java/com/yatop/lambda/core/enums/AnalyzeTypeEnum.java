package com.yatop.lambda.core.enums;

public enum AnalyzeTypeEnum {

    /**
     * 无
     */
    NONE(0, "None"),

    /**
     * 创建节点（独占，多节点，包括创建节点和画布内节点复制创建）
     */
    CREATE_NODE(1, "Create Nodes In Canvas"),

    /**
     * 创建链接（独占，单链接）
     */
    CREATE_LINK(2, "Create Link In Canvas"),

    /**
     * 更新节点参数（独占，单节点）
     */
    UPDATE_NODE_PARAMETER(3, "Update Node Parameter"),

    /**
     * 删除节点（独占，多节点）
     */
    DELETE_NODE(4, "Delete Node In Canvas"),

    /**
     * 删除链接（除DELETE_NODE之外，多链接，同时有删除节点和链接时，设为删除节点）
     */
    DELETE_LINK(5, "Delete Link In Canvas"),

    /**
     * 刷新SCHEMA（独占，包括复制（实验、快照、模版）创建的实验，实验运行前工作流校验，工作流刷新）
     */
    REFRESH_SCHEMA(6, "Refresh Schema");

    private int type;
    private String name;

    AnalyzeTypeEnum(int type, String name) {
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
