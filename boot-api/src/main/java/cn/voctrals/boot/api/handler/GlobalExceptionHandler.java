package cn.voctrals.boot.api.handler;

import cn.voctrals.boot.api.model.ErrorModel;
import cn.voctrals.boot.api.model.ResultModel;
import cn.voctrals.boot.core.exception.AppException;
import cn.voctrals.boot.core.util.ErrorCode;
import cn.voctrals.boot.core.util.MessagesUtils;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulei on 11/11/2016.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    protected MessageSource messageSource;

    @ExceptionHandler(OAuthSystemException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultModel oauthSystemException(OAuthSystemException ex) {
        return createErrorResult(ErrorCode.OAUTH_SYSTEM_ERROR, ex.getMessage());
    }

    @ExceptionHandler(OAuthProblemException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultModel oauthProblemException(OAuthProblemException ex) {
        return createErrorResult(ErrorCode.OAUTH_INVALID_PARAM, ex.getMessage());
    }

    @ExceptionHandler(value = {UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultModel unauthorizedException(Exception ex) {
        return createErrorResult(ErrorCode.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultModel validationException(MethodArgumentNotValidException ex) {
        ResultModel resultModel = new ResultModel();
        ErrorModel errorModel = new ErrorModel();

        List<ErrorModel> errors = new ArrayList<>();
        BindingResult result = ex.getBindingResult();
        for (FieldError fieldError : result.getFieldErrors()) {
            ErrorModel error = new ErrorModel();
            error.setField(fieldError.getField());
            error.setMessage(fieldError.getDefaultMessage());
            errors.add(error);
        }
        errorModel.setCode(ErrorCode.INVALID_INPUT_PARAM);
        errorModel.setErrors(errors);
        resultModel.setError(errorModel);
        return resultModel;
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResultModel notAllowedMehtodException(HttpRequestMethodNotSupportedException ex) {
        return createErrorResult(ErrorCode.INVALID_REQUEST_MEHTOD, ex.getMessage() + "; Please use " + "'" + ex.getSupportedMethods()[0] + "'");
    }


    @ExceptionHandler(value = {AppException.class})
    @ResponseStatus(HttpStatus.OK)
    public ResultModel appException(AppException ex) {
        ex.printStackTrace();
        return createErrorResult(ex.getErrorCode(), ex.getMessage(), ex.getParams());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultModel unknownException(Exception ex) {
        ex.printStackTrace();
        // TODO
        return createErrorResult(ErrorCode.SYSTEM_ERROR, ex.getMessage());
    }

    private ResultModel createErrorResult(int code) {
        return createErrorResult(code, null);
    }

    private ResultModel createErrorResult(int code, String causeMessage) {
        return createErrorResult(code, causeMessage, null);
    }

    private ResultModel createErrorResult(int code, String causeMessage, Object[] params) {
        ResultModel result = new ResultModel();
        ErrorModel error = new ErrorModel();
        error.setCode(code);
        String message = MessagesUtils.get(messageSource, "error." + code, params);
        error.setMessage(message);
        error.setCauseMessage(causeMessage);
        result.setError(error);
        return result;
    }
}