package cn.voctrals.boot.core.exception;

import org.springframework.validation.BindingResult;

/**
 * Created by liulei on 26/11/2016.
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer errorCode;
    private String errorMessage;
    private BindingResult bindingResult;

    private Object[] params;

    public AppException() {
        this(null, null, null);
    }

    public AppException(Integer errorCode) {
        this(errorCode, null, null);
    }

    public AppException(Integer errorCode, Object[] params) {
        this(errorCode, params, null);
    }

    public AppException(Integer errorCode, Object[] params, BindingResult bindingResult) {
        this.errorCode = errorCode;
        this.params = params;
        this.bindingResult = bindingResult;
    }

//    public AppException(Integer errorCode, BindingResult bindingResult) {
//        this(errorCode, null, bindingResult);
//    }
//
//    public AppException(Integer errorCode, String errorMessage) {
//        this(errorCode, errorMessage, null);
//    }

//    public AppException(Integer errorCode, String errorMessage, BindingResult bindingResult) {
//        this.errorCode = errorCode;
//        this.errorMessage = errorMessage;
//        this.bindingResult = bindingResult;
//    }

    public Integer getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public Object[] getParams() {
        return params;
    }
}
