package com.yatop.lambda.core.enums;

public enum ShareLockStateEnum {

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

    ShareLockStateEnum(int state, String name) {
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

    public static ShareLockStateEnum valueOf(int state) {
        switch (state) {
            case 0: return UNLOCKED;
            case 1: return LOCKED;
            default: return null;
        }
    }
}
