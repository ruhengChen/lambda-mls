package com.yatop.lambda.core.enums;

public enum JobTypeEnum {

    /**
     * 全部运行
     */
    RUN_ALL(0, "Run All"),

    /**
     * 从此处开始运行
     */
    RUN_START_HERE(1, "Run Start Here"),

    /**
     * 运行到此处
     */
    RUN_END_HERE(2, "Run End Here"),

    /**
     * 运行该节点
     */
    RUN_THIS_NODE(3, "Run This Node"),

    /**
     * 全部运行（试运行）
     */
    //TRIAL_RUN_ALL(10, "Trial Run All"),

    /**
     * 从此处开始运行（试运行）
     */
    //TRIAL_RUN_START_HERE(11, "Trial Run Start Here"),

    /**
     * 运行到此处（试运行）
     */
    //TRIAL_RUN_END_HERE(12, "Trial Run End Here"),

    /**
     * 运行该节点（试运行）
     */
    //TRIAL_RUN_THIS_NODE(13, "Trial Run This Node"),

    /**
     * 定时调度运行
     */
    RUN_OFFLINE_SCHEDULE(100, "Run Offline Schedule"),

    /**
     * 在线调度运行
     */
    RUN_ONLINE_SCHEDULE(101, "Run Online Schedule"),

    /**
     * 数据文件上传
     */
    RUN_DATAFILE_IMPORT(102, "Run Datafile Import");

    private int type;
    private String name;

    JobTypeEnum(int type, String name) {
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
