package cn.voctrals.boot.core.exception;

import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * Created by liulei on 26/11/2016.
 */
public class HrAppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ErrorInfo error;

    private List<ErrorInfo> errors;

    private BindingResult bindingResult;

    private String viewName;
    public HrAppException(String errorCode, BindingResult bindingResult) {
        this.error = new ErrorInfo(errorCode);
        this.bindingResult = bindingResult;
    }

    public HrAppException(String errorCode, BindingResult bindingResult, String viewName) {
        this.error = new ErrorInfo(errorCode);
        this.bindingResult = bindingResult;
        this.viewName = viewName;
    }

    public HrAppException(String errorCode, Object[] params, BindingResult bindingResult) {
        this.error = new ErrorInfo(errorCode, params);
        this.bindingResult = bindingResult;
    }

    public HrAppException(String errorCode, Object[] params, BindingResult bindingResult, String viewName) {
        this.error = new ErrorInfo(errorCode, params);
        this.bindingResult = bindingResult;
        this.viewName = viewName;
    }

    public HrAppException(ErrorInfo error, BindingResult bindingResult) {
        this.error = error;
        this.bindingResult = bindingResult;
    }

    public HrAppException(List<ErrorInfo> errors, BindingResult bindingResult) {
        this.errors = errors;
        this.bindingResult = bindingResult;
    }

    public ErrorInfo getError() {
        return error;
    }

    public void setError(ErrorInfo error) {
        this.error = error;
    }

    public List<ErrorInfo> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorInfo> errors) {
        this.errors = errors;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
}
