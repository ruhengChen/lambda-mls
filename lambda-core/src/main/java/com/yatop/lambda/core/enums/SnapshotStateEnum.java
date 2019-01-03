package com.yatop.lambda.core.enums;

public enum SnapshotStateEnum {

    /**
     * 快照生成中
     */
    GENERATING(0, "Generation"),

    /**
     * 快照完成
     */
    FINISHED(1, "Finished");

    private int state;
    private String name;

    SnapshotStateEnum(int state, String name) {
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

    public static SnapshotStateEnum valueOf(int state) {
        switch (state) {
            case 0: return GENERATING;
            case 1: return FINISHED;
            default: return null;
        }
    }
}
