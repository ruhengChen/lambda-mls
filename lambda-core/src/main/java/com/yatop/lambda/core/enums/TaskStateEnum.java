package com.yatop.lambda.core.enums;

public enum TaskStateEnum {

    /**
     * 准备中
     */
    PREPARING(0, "Preparing"),

    /**
     * 已就绪
     */
    READY(1, "Ready"),

    /**
     * 运行中
     */
    RUNNING(2, "Running"),

    /**
     * 运行成功
     */
    SUCCESS(3, "Success"),

    /**
     * 出错终止
     */
    ERROR_TERMINATED(4, "Error Terminated"),

    /**
     * 用户终止
     */
    USER_TERMINATED(5, "User Terminated");

    private int state;
    private String name;

    TaskStateEnum(int state, String name) {
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

    public static TaskStateEnum valueOf(int state) {
        switch (state) {
            case 0: return PREPARING;
            case 1: return READY;
            case 2: return RUNNING;
            case 3: return SUCCESS;
            case 4: return ERROR_TERMINATED;
            case 5: return USER_TERMINATED;
            default: return null;
        }
    }
}
