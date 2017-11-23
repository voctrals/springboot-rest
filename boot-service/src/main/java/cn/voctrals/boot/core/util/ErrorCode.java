package cn.voctrals.boot.core.util;

/**
 * Created by liulei on 26/11/2016.
 */
public class ErrorCode {
    public static final int INVALID_AUTHORIZATION_CODE = 9001;
    public static final int OAUTH_SYSTEM_ERROR = 9002;
    public static final int OAUTH_INVALID_PARAM = 9003;
    public static final int UNAUTHORIZED = 9004;
    public static final int INVALID_REQUEST_MEHTOD = 9005;
    public static final int SYSTEM_ERROR = 9999;
    /** 输入的参数不正确。 */
    public static final int INVALID_INPUT_PARAM = 2000;
    /** 该数据在DB中已经存在。 */
    public static final int DATA_EXIST = 2001;
    /** 请输入正确的{0}。 */
    public static final int INVALID_VALUE = 2002;
    /** 用户名或密码错误。 */
    public static final int INVALID_ACCOUNT = 2003;
    /** 请输入{0}-{1}位{2}。 */
    public static final int INVALID_RANGE_VALUE = 2004;
    /** 超过了最大长度。 */
    public static final int MAX_LENGTH_ERROR = 2005;
    /** 数据不存在。 */
    public static final int DATA_NOT_FOUND = 2006;
    /** {0}在DB中不存在。 */
    public static final int ITEM_NOT_EXIST = 2007;
    /** {0}在DB中已经存在。 */
    public static final int ITEM_EXIST = 2008;
    /** {0}列表中没有数据 */
    public static final int NO_DATA_IN_LIST = 2009;
    /** {0}超过了最大数量 */
    public static final int OVER_MAX = 2010;

    /** 素质试题重新测试的间隔为{0}，尚未满足条件。 */
    public static final int RETEST_DATE_NOT_REACHED = 2011;
    /** 请指定{0} */
    public static final int NOT_GIVEN = 2012;

    public static final int PASSWORD_FORMAT_ERROR = 2013;

    public static final int GIVE_UP_JOB_RE_POST = 2014;
}
