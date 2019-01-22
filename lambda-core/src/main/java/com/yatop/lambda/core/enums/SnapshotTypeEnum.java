package com.yatop.lambda.core.enums;

public enum SnapshotTypeEnum {

    /**
     * 运行快照
     */
    EXECUTION(0, "Execution"),

    /**
     * 副本快照
     */
    COPY(1, "Copy"),

    /**
     * 删除快照
     */
    DELETE(2, "Delete"),

    /**
     * 模版快照
     */
    TEMPLATE(3, "Template");

    private int type;
    private String name;

    SnapshotTypeEnum(int type, String name) {
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

    public static SnapshotTypeEnum valueOf(int type) {
        switch (type) {
            case 0: return EXECUTION;
            case 1: return COPY;
            case 2: return DELETE;
            case 3: return TEMPLATE;
            default: return null;
        }
    }
}
