package cn.voctrals.boot.util.rongcloud;

/**
 * 入职邀请专用额外信息
 */
public class EntryInvitationExtra extends BaseExtra {

    /** 类型 */
    public String type = "EntryInvitation";
    /** 入职日期 */
    private String entryDate;
    /** 入职地点 */
    private String entryAddress;
    /** 联系人 */
    private String connectMan;
    /** 联系电话 */
    private String connectPhone;

    private String note;

    public EntryInvitationExtra(String id, String relId, String companyName, String companyLogo, String jobName, String entryDate, String entryAddress, String connectMan, String connectPhone) {
        super(id, relId, companyName, companyLogo, jobName);
        this.entryDate = entryDate;
        this.entryAddress = entryAddress;
        this.connectMan = connectMan;
        this.connectPhone = connectPhone;
    }

    public EntryInvitationExtra(String id, String relId, String companyName, String companyLogo, String jobName, String extraInfo1, String extraInfo2, String entryDate, String entryAddress, String connectMan, String connectPhone) {
        super(id, relId, companyName, companyLogo, jobName, extraInfo1, extraInfo2);
        this.entryDate = entryDate;
        this.entryAddress = entryAddress;
        this.connectMan = connectMan;
        this.connectPhone = connectPhone;
    }

    public EntryInvitationExtra(String id, String relId, String companyName, String companyLogo, String jobName) {
        super(id, relId, companyName, companyLogo, jobName);
    }

    public EntryInvitationExtra() {

    }

    public String getType() {
        return type;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public String getEntryAddress() {
        return entryAddress;
    }

    public String getConnectMan() {
        return connectMan;
    }

    public String getConnectPhone() {
        return connectPhone;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public void setEntryAddress(String entryAddress) {
        this.entryAddress = entryAddress;
    }

    public void setConnectMan(String connectMan) {
        this.connectMan = connectMan;
    }

    public void setConnectPhone(String connectPhone) {
        this.connectPhone = connectPhone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
