package cn.voctrals.boot.api.model;

import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 * Created by liulei on 14/11/2016.
 */
public class ResultModel {

    private ErrorModel error;

    private Object data;

    private Paginator paginator;

    public ErrorModel getError() {
        return error;
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }
}
