package com.yatop.lambda.core.enums;

public enum JobStateEnum {

    /**
     * 准备中
     */
    PREPARING(0, "Preparing"),

    /**
     * 排队中
     */
    QUEUEING(1, "Queueing"),

    /**
     * 运行中
     */
    RUNNING(2, "Running"),

    /**
     * 运行完成
     */
    FINISHED(3, "Finished"),

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

    JobStateEnum(int state, String name) {
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
