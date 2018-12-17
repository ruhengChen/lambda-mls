package com.yatop.lambda.core.enums;

public enum SnapshotSourceEnum {

    /**
     * 工作流运行
     */
    EXECUTION(0, "Execution"),

    /**
     * 工作流副本
     */
    COPY(1, "Copy");

    private int source;
    private String name;

    SnapshotSourceEnum(int source, String name) {
        this.source = source;
        this.name = name;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
