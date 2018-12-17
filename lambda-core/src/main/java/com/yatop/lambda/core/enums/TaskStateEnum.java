package com.yatop.lambda.core.enums;

public enum TaskStateEnum {

    /**
     * 已就绪
     */
    READY(0, "Ready"),

    /**
     * 运行中
     */
    RUNNING(1, "Running"),

    /**
     * 运行完成
     */
    FINISHED(2, "Finished"),

    /**
     * 出错终止
     */
    ERROR_TERMINATED(3, "Error Terminated"),

    /**
     * 用户终止
     */
    USER_TERMINATED(4, "User Terminated");

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
}
