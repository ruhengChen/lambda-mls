package com.yatop.lambda.core.enums;

public enum WorkflowLockStateEnum {

    /**
     * 未加锁
     */
    UNLOCKED(0, "Unlocked"),

    /**
     * 已加锁
     */
    LOCKED(1, "Locked");

    private int state;
    private String name;

    WorkflowLockStateEnum(int state, String name) {
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
