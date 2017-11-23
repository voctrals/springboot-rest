package cn.voctrals.boot.service;

import cn.voctrals.boot.core.util.GenUtils;
import cn.voctrals.boot.dao.entity.BaseModel;
import cn.voctrals.boot.service.dto.BaseDto;
import cn.voctrals.boot.util.Constants;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by liulei on 25/11/2016.
 */
public class BaseService<T extends BaseModel> {
    protected void setSysFieldInfo(T model) {
        model.setId(GenUtils.uuid());
        model.setCreateBy("1");
        model.setUpdateBy("1");
        Date sysdate = new Date();
        model.setCreateDate(sysdate);
        model.setUpdateDate(sysdate);
        model.setDelFlag(Constants.DeleteFlag.NOT_DELETED);
    }

    protected void setSysFieldInfo(T model, String accountId, boolean insertFlag) {
        if (insertFlag) {
            setSysFieldInfoForInsert(model, accountId);
        } else {
            setSysFieldInfoForUpdate(model, accountId);
        }
    }

    protected void setSysFieldInfoForInsert(T model, String accountId) {
        model.setId(GenUtils.uuid());
        model.setCreateBy(accountId);
        Date sysdate = new Date();
        model.setCreateDate(sysdate);
        model.setUpdateBy(accountId);
        model.setUpdateDate(sysdate);
        model.setDelFlag(Constants.DeleteFlag.NOT_DELETED);
    }

    protected void setSysFieldInfoForInsertList(List<T> modelList, String accountId) {
        Date sysdate = new Date();
        for (T model : modelList) {
            model.setId(GenUtils.uuid());
            model.setCreateBy(accountId);
            model.setCreateDate(sysdate);
            model.setUpdateDate(sysdate);
            model.setUpdateBy(accountId);
            model.setDelFlag(Constants.DeleteFlag.NOT_DELETED);
        }
    }

    protected void setSysFieldInfoForUpdate(T model, String accountId) {
        model.setUpdateBy(accountId);
        model.setUpdateDate(new Date());
        model.setDelFlag(Constants.DeleteFlag.NOT_DELETED);
    }

    protected void setSysFieldInfoForUpdateList(List<T> modelList, String accountId) {
        Date sysdate = new Date();
        for (T model : modelList) {
            model.setDelFlag(Constants.DeleteFlag.NOT_DELETED);
            model.setUpdateBy(accountId);
            model.setUpdateDate(sysdate);
        }
    }

    protected void unsetSysFieldInfo(List<T> modelList) {
        for (T model : modelList) {
            model.setId(null);
            model.setCreateBy(null);
            model.setCreateDate(null);
            model.setUpdateBy(null);
            model.setUpdateDate(null);
            model.setDelFlag(null);
            model.setRemarks(null);
        }
    }
}
