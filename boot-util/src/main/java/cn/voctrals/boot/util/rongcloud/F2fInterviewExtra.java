package cn.voctrals.boot.util.rongcloud;

/**
 * 面对面面试专用额外信息
 */
public class F2fInterviewExtra extends BaseExtra {

    /** 类型 */
    private String type = "F2fInterview";
    /** 面试日期 */
    private String interviewDate;
    /** 面试地点 */
    private String interviewAddress;
    /** 联系人 */
    private String connectMan;
    /** 联系电话 */
    private String connectPhone;

    public F2fInterviewExtra(String id, String relId, String companyName, String companyLogo, String jobName, String interviewDate, String interviewAddress, String connectMan, String connectPhone) {
        super(id, relId, companyName, companyLogo, jobName);
        this.interviewDate = interviewDate;
        this.interviewAddress = interviewAddress;
        this.connectMan = connectMan;
        this.connectPhone = connectPhone;
    }

    public F2fInterviewExtra(String id, String relId, String companyName, String companyLogo, String jobName, String extraInfo1, String extraInfo2, String interviewDate, String interviewAddress, String connectMan, String connectPhone) {
        super(id, relId, companyName, companyLogo, jobName, extraInfo1, extraInfo2);
        this.interviewDate = interviewDate;
        this.interviewAddress = interviewAddress;
        this.connectMan = connectMan;
        this.connectPhone = connectPhone;
    }

    public String getType() {
        return type;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public String getInterviewAddress() {
        return interviewAddress;
    }

    public String getConnectMan() {
        return connectMan;
    }

    public String getConnectPhone() {
        return connectPhone;
    }

}
