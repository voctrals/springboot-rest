package cn.voctrals.boot.util;

/**
 * 常量类
 *
 * @author LiuLei
 * @author liulei
 *
 */
public class Constants {

    /**
     * 是否
     */
    public class YesNo {
        /** 否 */
        public static final String NO = "0";
        /** 是 */
        public static final String YES = "1";
    }

    /**
     * 人员类型
     */
    public class AccountType {
        /** 求职者 */
        public static final String APPLICANT = "0";
        /** 招聘人员 */
        public static final String RECRUITER = "1";
        /** 后台管理人员 */
        public static final String MANAGER = "2";
    }

    /**
     * 秘籍等的发布状态
     */
    public class PublishType {
        /** 未发布 */
        public static final String UNPUBLISHED = "0";
        /** 已发布 */
        public static final String PUBLISHED = "1";
    }

    /**
     * 公司级别
     */
    public class CompanyLevel {
        /** 审核中 */
        public static final String DEFAULT = "0";
    }

    /**
     * 企业申请入驻状态
     */
    public class CompanyApplyStatus {
//        /** 未提交申请 */
//        public static final String UN_POST_APPLIY = "9";
        /** 审核中 */
        public static final String REVIEWING = "0";
        /** 审核未通过 */
        public static final String DENIED = "1";
        /** 审核通过，未登录 */
        public static final String PASS_NO_LOGIN = "2";
        /** 审核通过，已登录 */
        public static final String PASS_LOGIN = "3";
        /** 已过期 */
        public static final String EXPIRED = "4";
        /** 违规 */
        public static final String ILLEGAL = "5";
    }

    /**
     * 企业HR类型
     */
    public class HRType {
        /** HR */
        public static final String HR = "0";
        /** HR MANAGER */
        public static final String HR_MANAGER = "1";
    }

    /**
     * APP意见反馈状态
     */
    public class APPFeedbackStatus {
        /** 0	未查看 */
        public static final String NOT_VIEW = "0";
        /** 1	已查看 */
        public static final String VIEWED = "1";
        /** 2	已反馈 */
        public static final String RESPONSED = "2";

    }

    /**
     * APP意见种类分类
     * */
    public class APPFeedbackType {
        /** 0 建议*/
        public static final String SUGGESTION = "0";
        /** 1 BUG反馈*/
        public static final String BUG = "1";
        /** 2 投诉*/
        public static final String COMPLAINT = "2";
    }

    /**
     * 是否删除
     */
    public class DeleteFlag {
        /** 未删除 */
        public static final String NOT_DELETED = "0";
        /** 已删除 */
        public static final String DELETED = "1";
    }

    /**
     * 意向职位是否有效
     */
    public class ExpectValidStatus {
        /** 有效 */
        public static final String VALID = "1";
        /** 无效 */
        public static final String INVALID = "2";
    }

    /**
     * 级别设定参数
     */
    public class LevelConfigType {
        /** 最多需求发布数量 */
        public static final String MAX_EXPECT_NUM = "max_expect_num";
        /** 最多投递职位数量 */
        public static final String MAX_POST_NUM = "max_post_num";
    }

    /**
     * 职位状态
     */
    public class JobStatus {
        /** 已发布 */
        public static final String PUBLISHED = "0";
        /** 未发布 */
        public static final String UNPUBLISHED = "1";
        /** 已过期 */
        public static final String EXPIRED = "2";
    }

    /**
     * 求职者和职位对应关系的状态
     */
    public class ApplicantJobStatus {
        /** 主动投递 */
        public static final String RESUME_POST = "0";

        /** 已查看 */
        public static final String VIEWED = "3";

        /** 已邀请视频面试 */
        public static final String VIDEO_INVITED = "4";

        /** 已上传视频面试资料 */
        public static final String VIDEO_UPLOADED = "5";

        /** 面对面面试(HR发送请求，求职者确认中) */
        public static final String F2F_INVITED_APPLICANT_CONFIRM = "6"; // 60??

        /** 面对面面试(求职者发送请求，HR确认中) */
        public static final String F2F_INVITED_HR_CONFIRM = "61";

        /** 面对面面试(确认完了) */
        public static final String F2F_INVITED_OK = "62";

        /** HR已反馈 */
        //public static final String HR_FEEDBACK = "7";

        /** 面试通过-同意入职 */
        public static final String PASSED = "8";

        /** 求职者已反馈 */
        public static final String APPLICANT_FEEDBACK = "9";

        /** 放弃职位 */
        public static final String GIVE_UP = "10";

        /** 被拒绝 */
        public static final String REJECTED = "1";
        /** 已过期 */
        //public static final String EXPIRED = "2";
    }

    /**
     * 标签类型
     */
    public class SysTagType {
        /** 职位能力标签 */
        public static final String JOB_ABILITY = "1";
        /** 求职者反馈标签 */
        public static final String APP_USER_FEEDBACK = "2";
        /** 公司相关标签 */
        public static final String COMPANY_ABOUT = "3";
    }

    /**
     * 标签类型
     */
    public class SysTagRelType {
        /** 企业创建标签 */
        public static final String COMPANY = "0";
        /** 求职者反馈标签 */
        public static final String APPLICANT = "1";
    }

    /**
     * 工作性质类型
     */
    public class JobNatureType {
        /** 全职 */
        public static final String FULL_TIME = "0";
    }

    /**
     * 收藏类型
     */
    public class CollectionType {
        /** 求职秘籍 */
        public static final String STRATEGY = "1";
        /** 职位 */
        public static final String JOB = "2";
    }

    /**
     * 面试类型
     */
    public class InterviewType {
        /** 视频面试 */
        public static final String VIDEO = "0";
        /** 现场面试 */
        public static final String ONSITE = "1";
    }

    /**
     * 字典类型
     */
    public class DicType {
        /** 学历类型 */
        public static final String DEGREE_TYPE = "degree_type";
        /** 素质类型 */
        public static final String QUALITY_TYPE = "quality_type";
        /** 级别类型 */
        public static final String LEVEL_TYPE = "level";
        /** 系统设置 */
        public static final String SYS_CONFIG = "sys_config";
        /** 工作性质 */
        public static final String JOB_NATURE_TYPE = "job_nature_type";
        /** 工资类型 */
        public static final String SALARY_TYPE = "salary_type";
        /** 语言级别 */
        public static final String LANGUAGE_LEVEL = "language_level";
        /**  */
        public static final String COMPANY_SCORE_TYPE = "company_score_type";
        /** 面试类型 */
        public static final String INTERVIEW_TYPE = "interview_type";
        /** 招聘者性别 */
        public static final String SEX = "sex";
        /** 视频简历类别 */
        public static final String RESUME_VIDEO_TYPE = "resume_video_type";
        /** 公司类型 */
        public static final String COMPANY_TYPE = "company_type";
        /** 公司规模类型 */
        public static final String COMPANY_SCALE_TYPE = "company_scale_type";
        /** 融资阶段 */
        public static final String FINANCING_TYPE = "financing_type";
    }

    /**
     * APP用户及企业级别权限
     *
     */
    public class Level {
        /** 0 铜牌会员*/
        public static final String COPPER = "0";
        /** 1 银牌会员*/
        public static final String SILVER = "1";
        /** 2 金牌会员*/
        public static final String GOLD = "2";
        /** 3 钻石会员*/
        public static final String DIAMOND = "3";
    }

    /**
     *
     */
    public class SysConfig {
        /** 个人素质占比 */
        public static final String JOB_QUALITY_RATE = "job_quality_rate";
        /** 个人专业占比 */
        public static final String JOB_MAJOR_RATE = "job_major_rate";
        /** 个人期望占比 */
        public static final String JOB_EXPECT_RATE = "job_expect_rate";
        /** 个人经历占比 */
        public static final String JOB_EXP_RATE = "job_exp_rate";

        /** 每种素质试题数目 */
        public static final String QUALITY_QUESTION_COUNT = "quality_question_count";
        /** 素质试题重答间隔 */
        public static final String QUALITY_RETEST_DURATION = "quality_retest_duration";
        /** 求职意向过期间隔 */
        public static final String EXPECT_EXPIRE_DURATION = "expect_expire_duration";

        /** 求职者基本信息占比 */
        public static final String RESUME_BASIC_PERCENT = "resume_basic_percent";
        /** 求职者工作经历占比 */
        public static final String RESUME_CAREER_PERCENT = "resume_career_percent";
        /** 求职者项目经验占比 */
        public static final String RESUME_EXP_PERCENT = "resume_exp_percent";
        /** 求职者校园经历占比 */
        public static final String RESUME_CAMPUS_PERCENT = "resume_campus_percent";
        /** 求职者个人简介占比 */
        public static final String RESUME_SELF_PERCENT = "resume_self_percent";

        /** 资质证明有效天数 */
        public static final String CERTIFICATE_VALID_DAYS = "certificate_valid_days";

        /** 资质证明过期提醒提前天数 */
        public static final String CERTIFICATE_INVALID_NOTICE_DAYS = "certificate_invalid_notice_days";

        /** 职位再申请间隔 */
        public static final String JOB_REAPPLY_DURATION = "job_reapply_duration";

        /** 职位过期提醒天数 */
        public static final String JOB_INVALID_NOTICE_DAYS = "job_invalid_notice_days";

    }

    /**
     * 模版类型
     */
    public class TemplateType {
        /** 系统模版 */
        public static final String SYSTEM = "0";
        /** 公司模版 */
        public static final String COMPANY = "1";
        /** HR模版 */
        public static final String HR = "2";
    }

    /**
     * 通知消息类型
     */
    public class NtfMessageType {
        /** 系统模版 */
        public static final String RESUME_POST = "0";
        /** 公司模版 */
        public static final String VIDEO_POST = "1";
    }

    /**
     * 拒绝原因
     */
    public class RecruiterRejectReason {
        /** 审核未通过 */
        public static final String AUDIT_NOT_PASS = "0";
        /** 面试未通过 */
        public static final String INTERVIEW_NOT_PASS = "1";
    }

    public class SessionKey {
        public static final String LOGIN_ACCOUNT = "login_account";

        public static final String QINIU_DOMAIN = "qiniu_domain";

        public static final String JOB_POST_EDIT_STEP_ONE_VO = "job_post_edit_step_one_vo";

        public static final String JOB_POST_EDIT_STEP_TWO_VO = "job_post_edit_step_two_vo";

        public static final String CURRENT_MENU_NAME = "current_menu_name";

        public static final String SELECTED_JOB_ID = "selected_job_id";
    }

    public class HrCacheName {
        public static final String VCODE = "vcode";

        public static final String HR_REGISTER_URL = "hr_register_url";

        public static final String EMAIL_URL = "email_url";

        public static final String APPLICANT_FORWARD_URL = "applicant_forward_url";

        public static final String WEB_DATA = "web_data";
    }

    public class ApiCacheName {
        public static final String VCODE = "vcode";

        public static final String OAUTH_TOKEN = "oauth_token";
    }

    public class UrlTokenType {
        public static final String HR_REGISTER = "0";

        public static final String FORGET_PASSWORD = "1";

        public static final String APPLICANT_FORWARD = "2";
    }

    public class Tester {
        public static final String JUST_FOR_TEST = "JUST FOR TEST";
    }

    public static final String UPLOAD_FILE_PATH = "/Users/liulei/Documents/temp";

    public static final String SYSTEM_ERROR = "SYSTEM ERROR...";

    public static final int PAGE_LIMIT = 5;

    public static final String OTHER_CITY_CODE = "xxxxxx";
    public static final String OTHER_CITY_NAME = "其他";

    /** 域名地址 **/
    public static final String DOMAIN_ADDRESS = "http://localhost:8090";

    public static final String HR_WEB_URL = "http://106.15.33.33:8090/boot-hr";

    public class PageName {
        public static final String APPLICANT_DETAIL = "applicant_detail";

        public static final String APPLICANT_MANAGER_WAITING_VIEW = "waiting_view";

        public static final String APPLICANT_MANAGER_WAITING_VIDEO_INTERVIEW = "waiting_video_interview";

        public static final String APPLICANT_MANAGER_WAITING_F2F_INTERVIEW = "waiting_f2f_interview";

        public static final String APPLICANT_MANAGER_WAITING_PASS_INTERVIEW = "pass_interview";

        public static final String APPLICANT_MANAGER_WAITING_UNSUITABLE = "unsuitable";
        // "waiting_view", "waiting_video_interview", "waiting_f2f_interview", "pass_interview", "unsuitable"

        public static final String APPLICANT_MANAGER_APPLICANT_MANAGER_COLLECTION = "applicant_manager_collection";
    }

    public class TemplateName {
        // 人才转发
        public static final String FORWARD_APPLICANT = "forward_applicant";
        // 修改密码
        public static final String MODIFY_PASSWORD = "modify_password";
        // HR注册
        public static final String HR_REGISTER = "hr_register";
        // 重置密码
        public static final String RESET_PASSWORD = "reset_password";
        // 审核通过
        public static final String AUDIT_SUCCESS = "audit_success";
        // 审核失败
        public static final String AUDIT_FAIL = "audit_fail";
        // 入职邀请
        public static final String PASS_INTERVIEW = "pass_interview";
    }
}
