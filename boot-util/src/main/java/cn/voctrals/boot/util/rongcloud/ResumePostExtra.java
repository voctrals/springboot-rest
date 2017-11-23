package cn.voctrals.boot.util.rongcloud;

/**
 * 求职者投递简历专用额外信息
 */
public class ResumePostExtra {
    /** 类型 */
    private String type = "ResumePost";

    /** 求职者职位关系ID */
    private String relId;

    /** 职位ID */
    private String jobId;

    /** 求职者ID */
    private String applicantId;

    /** 求职者融云ID */
    private String accountId;

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
