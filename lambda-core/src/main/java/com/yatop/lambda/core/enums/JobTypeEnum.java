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
     * 数据文件导入
     */
    RUN_DATAFILE_IMPORT(200, "Run Datafile Import");

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

    public static JobTypeEnum valueOf(int type) {
        switch (type) {
            case 0: return RUN_ALL;
            case 1: return RUN_START_HERE;
            case 2: return RUN_END_HERE;
            case 3: return RUN_THIS_NODE;
//            case 10: return TRIAL_RUN_ALL;
//            case 11: return TRIAL_RUN_START_HERE;
//            case 12: return TRIAL_RUN_END_HERE;
//            case 13: return TRIAL_RUN_THIS_NODE;
            case 100: return RUN_OFFLINE_SCHEDULE;
            case 101: return RUN_ONLINE_SCHEDULE;
            case 200: return RUN_DATAFILE_IMPORT;
            default: return null;
        }
    }

    public static boolean enableFlushWorkflow(JobTypeEnum jobTypeEnum) {
        switch (jobTypeEnum) {
            case RUN_ALL:
            case RUN_START_HERE:
            case RUN_END_HERE:
            case RUN_THIS_NODE:
                return true;
            default:
                return false;
        }
    }

    public static boolean enableFlushSnapshot(JobTypeEnum jobTypeEnum) {
        switch (jobTypeEnum) {
            case RUN_ALL:
            case RUN_START_HERE:
            case RUN_END_HERE:
            case RUN_THIS_NODE:
            case RUN_DATAFILE_IMPORT:
                return true;
            default:
                return false;
        }
    }
}
