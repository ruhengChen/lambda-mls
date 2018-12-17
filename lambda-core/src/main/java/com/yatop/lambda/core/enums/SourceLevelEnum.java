package com.yatop.lambda.core.enums;

public enum SourceLevelEnum {

    /**
     * 组件规格
     */
    SPECIFICATION(1, "Component Specification"),

    /**
     * 组件
     */
    COMPONENT(2, "Component"),

    /**
     * 工作流
     */
    WORKFLOW(3, "Workflow");

    private int source;
    private String name;

    SourceLevelEnum(int source, String name) {
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
