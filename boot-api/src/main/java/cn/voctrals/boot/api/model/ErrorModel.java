package cn.voctrals.boot.api.model;

import java.util.List;

/**
 * Created by liulei on 14/11/2016.
 */
public class ErrorModel {

    private int code;

    private String message;

    private String causeMessage;

    private String field;

    private List<ErrorModel> errors;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorModel> errors) {
        this.errors = errors;
    }

    public String getCauseMessage() {
        return causeMessage;
    }

    public void setCauseMessage(String causeMessage) {
        this.causeMessage = causeMessage;
    }
}
