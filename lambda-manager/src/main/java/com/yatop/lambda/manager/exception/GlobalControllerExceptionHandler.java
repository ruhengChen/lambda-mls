package com.yatop.lambda.manager.exception;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.manager.api.response.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    public static Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);
/*
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody
    HashMap<String, Object> handleInvalidRequestException(LambdaException e) {
        logger.warn(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.BAD_REQUEST, e);
        return errorResp;
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    HashMap<String, Object> handleInternalServerException(LambdaException e) {
        logger.error(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.INTERNAL_SERVER_ERROR, e);
        return errorResp;
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public @ResponseBody
    HashMap<String, Object> handleInternalServerException(UnauthorizedAccessException e) {
        logger.warn(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.UNAUTHORIZED, e);
        return errorResp;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    HashMap<String, Object> handleResourceNotFoundException(LambdaException e) {
        logger.error(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.NOT_FOUND, e);
        return errorResp;
    }*/

////////////////////////////////////

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object requestParamErrorHandler(HttpServletRequest req, Exception exception) throws Exception {
        LambdaException lambdaException = new LambdaException(LambdaExceptionEnum.Y_INTERNAL_DEFAULT_ERROR, "未捕获异常", "发生未知错误，请联系技术人员", exception);
        logger.error("未捕获异常", lambdaException);
        return JsonResponse.build(lambdaException);
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object requestParamErrorHandler(HttpServletRequest req, BindException exception) throws Exception {
        LambdaException lambdaException = new LambdaException(LambdaExceptionEnum.Z_SERVICE_DEFAULT_ERROR, "请求参数错误", "请求参数错误", exception);
        logger.info("请求参数错误", lambdaException);
        return JsonResponse.build(lambdaException);
    }

    @ExceptionHandler(value = LambdaException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object requestParamErrorHandler(HttpServletRequest req, LambdaException lambdaException) throws Exception {
        logger.info("业务异常错误", lambdaException);
        return JsonResponse.build(lambdaException);
    }

/*    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object processUnauthorizedException(HttpServletRequest req, UnauthorizedException exception) {
        LambdaException lambdaException = new LambdaException("用户无访问权限", "用户无访问权限，请联系管理员", exception);
        logger.info("用户无访问权限", lambdaException);
        return JsonResponse.build(lambdaException);
    }

    @ExceptionHandler({UnauthenticatedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Object processUnauthenticatedException(HttpServletRequest req, UnauthenticatedException exception) {
        LambdaException lambdaException = new LambdaException("用户未认证或已过期", "用户认证失败，请重新登陆", exception);
        logger.info("用户未认证或已过期", lambdaException);
        return JsonResponse.build(lambdaException);
    }*/
}
