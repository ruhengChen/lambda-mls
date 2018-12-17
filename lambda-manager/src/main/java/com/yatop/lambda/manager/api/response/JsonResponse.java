package com.yatop.lambda.manager.api.response;

import com.yatop.lambda.core.exception.LambdaException;

import java.io.Serializable;

@SuppressWarnings("unused")
public class JsonResponse implements Serializable{

    private Boolean success;

    private Object data;

	private String errorCode;

    private String errorMessage;

    private String errorHint;

    private JsonResponse(Object data) {
        this.success = true;
        this.data = data;
    }

    private JsonResponse(LambdaException e) {
        this.success = false;
        this.errorCode = e.getCode();
        this.errorMessage = e.getMessage();
        this.errorHint = e.getHint();
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorHint() {
        return errorHint;
    }

    public void setErrorHint(String errorHint) {
        this.errorHint = errorHint;
    }

    public static JsonResponse build(Object data) {
        return new JsonResponse(data);
    }

    public static JsonResponse build(LambdaException e) {
        return new JsonResponse(e);
    }
}
