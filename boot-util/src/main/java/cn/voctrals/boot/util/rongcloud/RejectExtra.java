package cn.voctrals.boot.util.rongcloud;

/**
 * 面试反馈邀请专用额外信息
 */
public class RejectExtra extends BaseExtra {

    /** 类型 */
    public String type = "Reject";

    private String feedback;

    public RejectExtra(String id, String relId, String companyName, String companyLogo, String jobName) {
        super(id, relId, companyName, companyLogo, jobName);
    }

    public RejectExtra(String id, String relId, String companyName, String companyLogo, String jobName, String extraInfo1, String extraInfo2) {
        super(id, relId, companyName, companyLogo, jobName, extraInfo1, extraInfo2);
    }

    public String getType() {
        return type;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
