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

    private int type;
    private String name;

    JobSignalEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
