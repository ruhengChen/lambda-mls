package com.yatop.lambda.core.enums;

public enum JsonObjectSourceEnum {

    /**
     * 作业运行
     */
    EXECUTION(0, "Execution"),

    /**
     * 实验编辑
     */
    EDITOR(1, "Edit");

    private int source;
    private String name;

    JsonObjectSourceEnum(int source, String name) {
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

    public static JsonObjectSourceEnum valueOf(int source) {
        switch (source) {
            case 0: return EXECUTION;
            case 1: return EDITOR;
            default: return null;
        }
    }
}
