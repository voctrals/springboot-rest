package cn.voctrals.boot.dao.entity;

import cn.voctrals.boot.core.pagination.PageModel;

import java.io.Serializable;
import java.util.Date;

public class Book extends PageModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String doubanId;
    private String title;
    private String url;
    private String description;
    private Long ownerId;
    private Date onboardDate;
    private String status;
    private Long borrowerId;
    private Date borrowDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDoubanId() {
        return doubanId;
    }
    
    public void setDoubanId(String doubanId) {
        this.doubanId = doubanId;
    }
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getOwnerId() {
        return ownerId;
    }
    
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    public Date getOnboardDate() {
        return onboardDate;
    }
    
    public void setOnboardDate(Date onboardDate) {
        this.onboardDate = onboardDate;
    }
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public Long getBorrowerId() {
        return borrowerId;
    }
    
    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }
    public Date getBorrowDate() {
        return borrowDate;
    }
    
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}