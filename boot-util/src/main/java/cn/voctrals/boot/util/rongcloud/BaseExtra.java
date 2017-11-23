package cn.voctrals.boot.util.rongcloud;

import java.util.Date;

/**
 * 额外信息基础类
 */
public abstract class BaseExtra {

    /** ID */
    private String id;

    /** 求职者职位关系ID */
    private String relId;

    /** 公司名称 */
    private String companyName;

    /** 公司LOGO */
    private String companyLogo;

    /** 职位名称 */
    private String jobName;

    /** 发送时间 */
    private Date sendDate;

    /** 额外字段1 */
    private String extraInfo1;

    /** 额外字段2 */
    private String extraInfo2;

    public BaseExtra() {

    }

    public BaseExtra(String id, String relId, String companyName, String companyLogo, String jobName) {
        this.id = id;
        this.relId = relId;
        this.companyName = companyName;
        this.companyLogo = companyLogo;
        this.jobName = jobName;
        this.sendDate = new Date();
    }

    public BaseExtra(String id, String relId, String companyName, String companyLogo, String jobName, String extraInfo1, String extraInfo2) {
        this.id = id;
        this.relId = relId;
        this.companyName = companyName;
        this.companyLogo = companyLogo;
        this.jobName = jobName;
        this.sendDate = new Date();
        this.extraInfo1 = extraInfo1;
        this.extraInfo2 = extraInfo2;
    }

    public String getId() {
        return id;
    }

    public String getRelId() {
        return relId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public String getExtraInfo1() {
        return extraInfo1;
    }

    public String getExtraInfo2() {
        return extraInfo2;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public Date getSendDate() {
        return sendDate;
    }
}
