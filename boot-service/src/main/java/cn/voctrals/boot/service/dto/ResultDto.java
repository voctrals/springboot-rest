package cn.voctrals.boot.service.dto;

import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 * Created by liulei on 06/11/2016.
 */
public class ResultDto {

    private String errorCode;

    private String message;

    private Object items;

    private Paginator paginator;


    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    public Object getItems() {
        return items;
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
