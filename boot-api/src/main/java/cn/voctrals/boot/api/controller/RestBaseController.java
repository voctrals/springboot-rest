package cn.voctrals.boot.api.controller;

import cn.voctrals.boot.api.model.ResultModel;
import cn.voctrals.boot.core.pagination.Pager;

import java.util.List;

/**
 * Created by liulei on 14/11/2016.
 */
public class RestBaseController {

    protected ResultModel makeListResult(List<?> lst, Pager pager) {
        ResultModel result = new ResultModel();
        result.setData(lst);
        if (pager != null && pager.paginator != null) {
            result.setPaginator(pager.paginator);
        }
        return result;
    }

    protected ResultModel makeListResult(List<?> lst) {
        return makeListResult(lst, null);
    }

    protected ResultModel makeOneResult(Object obj) {
        ResultModel result = new ResultModel();
        result.setData(obj);
        return result;
    }

    protected Pager preparePager(Integer page, Integer limit) {
        Pager result = null;
        // TODO 每页显示几条？
        if (page != null) {
            if (limit != null) {
                result = new Pager(page, limit);
            } else {
                result = new Pager(page, 5);
            }
        } else {
            result = new Pager(1, 5);
        }

        return result;
    }
//
//    protected ResultModel makeErrorResult(int code, String message) {
//        return ApiUtil.createErrorResult(code, message);
//    }
}
