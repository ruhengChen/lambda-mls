package com.yatop.lambda.core.enums;

public enum IsLimitedEnum {

    /**
     * 否
     */
    NO(0, "No"),

    /**
     * 开区间方式限定
     */
    OPEN_INTERVAL(1, "Open Interval Limted"),

    /**
     * 闭区间方式限定
     */
    CLOSE_INTERVAL(2, "Close Interval Limited"),

    /**
     * 左开右闭方式限定
     */
    LOPEN_RCLOSE(3, "Left-Open Right-Close Limited"),

    /**
     * 左闭右开方式限定
     */
    LCOSE_ROPEN(4, "Left-Close Right-Open Limited"),

    /**
     * 枚举方式限定
     */
    ENUMERATION(4, "Enumeration Limited");

    private int mark;
    private String name;

    IsLimitedEnum(int mark, String name) {
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
