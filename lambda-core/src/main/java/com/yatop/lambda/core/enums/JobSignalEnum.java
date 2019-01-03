package com.yatop.lambda.core.enums;

public enum JobSignalEnum {

    /**
     * 正常作业信号
     */
    SIG_NORMAL(0, "Normal Signal"),

    /**
     * 终止作业信号
     */
    SIG_KILL(1, "Kill Signal");

    /**
     * 暂停作业信号
     */
    //SIG_PAUSE(2, "Pause Signal"),

    /**
     * 继续作业信号
     */
    //SIG_CONT(3, "Continue Signal");

    private int signal;
    private String name;

    JobSignalEnum(int signal, String name) {
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

    public static JobSignalEnum valueOf(int signal) {
        switch (signal) {
            case 0: return SIG_NORMAL;
            case 1: return SIG_KILL;
//            case 2: return SIG_PAUSE;
//            case 3: return SIG_CONT;
            default: return null;
        }
    }
}
