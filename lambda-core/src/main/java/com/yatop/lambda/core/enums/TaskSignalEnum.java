package com.yatop.lambda.core.enums;

public enum TaskSignalEnum {

    /**
     * 正常任务信号
     */
    SIG_NORMAL(0, "Normal Signal"),

    /**
     * 终止任务信号
     */
    SIG_KILL(1, "Kill Signal");

    private int signal;
    private String name;

    TaskSignalEnum(int signal, String name) {
        this.signal = signal;
        this.name = name;
    }

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static TaskSignalEnum valueOf(int signal) {
        switch (signal) {
            case 0: return SIG_NORMAL;
            case 1: return SIG_KILL;
            default: return null;
        }
    }
}
