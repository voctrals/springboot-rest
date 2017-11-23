package cn.voctrals.boot.service.dto;

import java.io.Serializable;
import java.util.Date;

public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private Date createDate;
    /** 更新者 */
    private String updateBy;
    /** 更新时间 */
    private Date updateDate;
    /** 备注信息 */
    private String remarks;
    /** 删除标记 */
    private String delFlag;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
