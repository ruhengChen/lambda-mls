//package com.yatop.lambda.portal.common.exception;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LambdaException extends RuntimeException {
//
//    /*
//     * 	异常代码
//     * */
//    private String code;
//
//	/*
//	* 	异常线索
//	* */
//	private String hint;
//
//    /*
//     * 	异常消息
//     * */
//    private String message;
//
//	/*
//	 * 	异常消息链
//	 * */
//	private List<String> messageChain;
//
//	//抛出异常
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message) {
//        this(exceptionEnum, message, exceptionEnum.getHint());
//    }
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, LambdaRootModel m1) {
//        this(exceptionEnum, DataUtil.format(message, m1));
//    }
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, LambdaRootModel m1, LambdaRootModel m2) {
//        this(exceptionEnum, DataUtil.format(message, m1, m2));
//    }
//
//	//抛出异常，自定义错误提示
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, String hint) {
//		super(message);
//		this.code = exceptionEnum.getCode();
//		this.hint = hint;
//		this.message = buildDetailMessage(exceptionEnum.getCode(), message, hint);
//		this.messageChain = new ArrayList<String>();
//        messageChain.add(this.message);
//	}
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, String hint, LambdaRootModel m1) {
//        this(exceptionEnum, DataUtil.format(message, m1), hint);
//    }
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, String hint, LambdaRootModel m1, LambdaRootModel m2) {
//        this(exceptionEnum, DataUtil.format(message, m1, m2), hint);
//    }
//
//	//捕获到一般异常
//	public LambdaException(LambdaExceptionEnum exceptionEnum, String message, Throwable e) {
//		this(exceptionEnum, message, exceptionEnum.getHint(), e);
//	}
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, Throwable e, LambdaRootModel m1) {
//        this(exceptionEnum, DataUtil.format(message, m1), e);
//    }
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, Throwable e, LambdaRootModel m1, LambdaRootModel m2) {
//        this(exceptionEnum, DataUtil.format(message, m1, m2), e);
//    }
//
//	//捕获到一般异常，自定义错误提示
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, String hint, Throwable e) {
//        super(message, e);
//        this.code = exceptionEnum.getCode();
//        this.hint = hint;
//        this.message = buildDetailMessage(exceptionEnum.getCode(), message, hint);
//        this.messageChain = new ArrayList<String>();
//        messageChain.add(this.message);
//	}
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, String hint, Throwable e, LambdaRootModel m1) {
//        this(exceptionEnum, DataUtil.format(message, m1), hint, e);
//    }
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, String hint, Throwable e, LambdaRootModel m1, LambdaRootModel m2) {
//        this(exceptionEnum, DataUtil.format(message, m1, m2), hint, e);
//    }
//
//	//捕获到业务异常
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, LambdaException e) {
//        this(exceptionEnum, message, exceptionEnum.getHint(), e);
//    }
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, LambdaException e, LambdaRootModel m1) {
//        this(exceptionEnum, DataUtil.format(message, m1), e);
//    }
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, LambdaException e, LambdaRootModel m1, LambdaRootModel m2) {
//        this(exceptionEnum, DataUtil.format(message, m1, m2), e);
//    }
//
//    //捕获到业务异常，自定义错误提示
//	public LambdaException(LambdaExceptionEnum exceptionEnum, String message, String hint, LambdaException e) {
//        super(message, e);
//		this.code = exceptionEnum.getCode();
//		this.hint = hint;
//        this.message = buildDetailMessage(exceptionEnum.getCode(), message, hint);
//		this.messageChain = e.getMessageChain();
//        messageChain.add(this.message);
//	}
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, String hint, LambdaException e, LambdaRootModel m1) {
//        this(exceptionEnum, DataUtil.format(message, m1), hint, e);
//    }
//    public LambdaException(LambdaExceptionEnum exceptionEnum, String message, String hint, LambdaException e, LambdaRootModel m1, LambdaRootModel m2) {
//        this(exceptionEnum, DataUtil.format(message, m1, m2), hint, e);
//    }
//
//    private static String buildDetailMessage(String code, String message, String hint) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(code).append(": ").append(hint).append(", ").append(message);
//        return sb.toString();
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public String getHint() {
//        return hint;
//    }
//
//    @Override
//    public String getMessage() {
//	    return message;
//    }
//
//    public List<String> getMessageChain() { return messageChain; }
//}
