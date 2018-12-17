package com.yatop.lambda.core.enums;

public enum LambdaExceptionEnum {

    /*
     *   错误代码
     *   A0000 ~ A9999：系统错误
     *   B0000 ~ B9999：项目错误
     *   C0000 ~ C9999：实验错误
     *   D0000 ~ D9999：数据错误
     *   E0000 ~ E9999：模型错误
     *   F0000 ~ F9999：工作流错误
     *   G0000 ~ G9999：计算框架错误
     *   Y0000 ~ Y9999：系统内部错误
     *   Z0000 ~ Z9999：服务请求错误（参数错误、认证失败）
     * */

    A_SYSTEM_DEFAULT_ERROR(             "A9999",    "System Error",             "系统业务发生错误"),
    B_PROJECT_DEFAULT_ERROR(            "B9999",    "Project Error",            "项目业务发生错误"),
    C_EXPERMNT_DEFAULT_ERROR(           "C9999",    "Experiment Error",         "实验业务发生错误"),
    D_DATA_DEFAULT_ERROR(               "D9999",    "Data Error",               "数据业务发生错误"),
    E_MODEL_DEFAULT_ERROR(              "E9999",    "Model Error",              "模型业务发生错误"),
    F_WORKFLOW_VERSION_EXPIRE_ERROR(    "F0000",    "Workflow Error",           "工作流版本号过期"),
    F_WORKFLOW_DEFAULT_ERROR(           "F9999",    "Workflow Error",           "工作流业务发生错误"),
    G_COMPUTE_DEFAULT_ERROR(            "G9999",    "Compute Framework Error",  "计算框架业务发生错误"),
    Y_INTERNAL_DEFAULT_ERROR(           "Y9999",    "System Internal Error",    "系统内部发生错误"),
    Z_SERVICE_DEFAULT_ERROR(            "Z9999",    "Service Request Error",    "服务请求发生错误");

    private String code;
    private String type;
    private String hint;

    LambdaExceptionEnum(String code, String type, String hint) {
        this.code = code;
        this.type = type;
        this.hint = hint;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHint() {
        return hint;
    }

    public String getType() {
        return type;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
