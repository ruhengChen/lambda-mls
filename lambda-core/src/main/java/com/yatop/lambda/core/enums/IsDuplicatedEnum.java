package com.yatop.lambda.core.enums;

public enum IsDuplicatedEnum {

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

    IsDuplicatedEnum(int mark, String name) {
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
}
