package cn.voctrals.boot.util.rongcloud;

/**
 * 视频面试专用额外信息
 */
public class VideoInterviewExtra extends BaseExtra {

    /** 类型 */
    public String type = "VideoInterview";

    public VideoInterviewExtra(String id, String relId, String companyName, String companyLogo, String jobName) {
        super(id, relId, companyName, companyLogo, jobName);
    }

    public VideoInterviewExtra(String id, String relId, String companyName, String companyLogo, String jobName, String extraInfo1, String extraInfo2) {
        super(id, relId, companyName, companyLogo, jobName, extraInfo1, extraInfo2);
    }

    public String getType() {
        return type;
    }

}
