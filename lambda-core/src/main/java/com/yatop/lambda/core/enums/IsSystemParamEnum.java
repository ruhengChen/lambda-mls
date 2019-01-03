package com.yatop.lambda.core.enums;

public enum IsSystemParamEnum {

    /**
     * 否
     */
    NO(0, "No"),

    /**
     * 是
     */
    YES(1, "Yes");

    private int mark;
    private String name;

    IsSystemParamEnum(int mark, String name) {
        this.mark = mark;
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static IsSystemParamEnum valueOf(int mark) {
        switch (mark) {
            case 0: return NO;
            case 1: return YES;
            default: return null;
        }
    }
}
