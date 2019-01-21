package com.yatop.lambda.core.enums;

public enum WorkflowStateEnum {

    /**
     * 草稿
     */
    DRAFT(0, "Draft"),

    /**
     * 准备中
     */
    PREPARING(1, "Preparing"),

    /**
     * 运行中
     */
    RUNNING(2, "Running"),

    /**
     * 运行结束
     */
    FINISHED(3, "Finished Running");

    private int state;
    private String name;

    WorkflowStateEnum(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static WorkflowStateEnum valueOf(int state) {
        switch (state) {
            case 0: return DRAFT;
            case 1: return PREPARING;
            case 2: return RUNNING;
            case 3: return FINISHED;
            default: return null;
        }
    }
}
