package com.yatop.lambda.core.enums;

public enum NodeStateEnum {

    /**
     * 未就绪
     */
    NOT_READY(0, "Not Ready"),

    /**
     * 已就绪
     */
    READY(1, "Ready"),

    /**
     * 准备中
     */
    PREPARING(2, "Preparing"),

    /**
     * 运行中
     */
    RUNNING(3, "Running"),

    /**
     * 运行成功
     */
    SUCCESS(4, "Success"),

    /**
     * 运行出错
     */
    ERROR(5, "Error");

    private int state;
    private String name;

    NodeStateEnum(int state, String name) {
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

    public static NodeStateEnum valueOf(int state) {
        switch (state) {
            case 0: return NOT_READY;
            case 1: return READY;
            case 2: return PREPARING;
            case 3: return RUNNING;
            case 4: return SUCCESS;
            case 5: return ERROR;
            default: return null;
        }
    }
}
