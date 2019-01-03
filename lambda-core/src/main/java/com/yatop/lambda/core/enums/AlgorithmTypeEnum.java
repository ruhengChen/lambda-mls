package com.yatop.lambda.core.enums;

public enum AlgorithmTypeEnum {

    /**
     * 单分类
     */
    ONE_CLASS(1, "One Class Classification"),

    /**
     * 二分类
     */
    TWO_CLASS(2, "Two Class Classification"),

    /**
     * 多分类
     */
    MULTIPLE_CLASS(3, "Multiple Class Classification"),

    /**
     * 聚类
     */
    CLUSTERING(4, "Clustering"),

    /**
     * 回归
     */
    REGRESSION(5, "Regression"),

    /**
     * 关联规则
     */
    ASSOCIATION_RULES(6, "Association Rules"),

    /**
     * 深度学习组件
     */
    COLLABORATIVE_FILTERING(7, "Collaborative Filtering");

    private int type;
    private String name;

    AlgorithmTypeEnum(int type, String name) {
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

    public static AlgorithmTypeEnum valueOf(int type) {
        switch (type) {
            case 1: return ONE_CLASS;
            case 2: return TWO_CLASS;
            case 3: return MULTIPLE_CLASS;
            case 4: return CLUSTERING;
            case 5: return REGRESSION;
            case 6: return ASSOCIATION_RULES;
            case 7: return COLLABORATIVE_FILTERING;
            default: return null;
        }
    }
}
