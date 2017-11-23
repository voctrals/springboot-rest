package cn.voctrals.boot.core.exception;

/**
 * Created by liulei on 29/12/2016.
 */
public class ErrorInfo {

    private String errorCode;

    private String errorMessage;

    private Object[] params;

    public ErrorInfo() {

    }

    public ErrorInfo(String errorCode) {
        this(errorCode, null);
    }

    public ErrorInfo(String errorCode, Object[] params) {
        this(errorCode, null, params);
    }

    public ErrorInfo(String errorCode, String errorMessage, Object[] params) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.params = params;
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

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
