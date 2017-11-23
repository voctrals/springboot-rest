package cn.voctrals.boot.dao.entity;


import cn.voctrals.boot.core.pagination.PageModel;
import cn.voctrals.boot.core.pagination.Pager;

import java.io.Serializable;
import java.util.Date;

public class BaseModel extends PageModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String rowid;

	private String createBy;

	private Date createDate;

	private String updateBy;

	private Date updateDate;

	private String remarks;

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

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	public void setPager(Pager pager) {
		if (pager != null) {
			this.setPageLimit(pager.limit);
			this.setPageOffset(pager.limit * (pager.page - 1));
		}
	}
}
