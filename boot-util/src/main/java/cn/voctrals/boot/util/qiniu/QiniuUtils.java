package cn.voctrals.boot.util.qiniu;

import com.qiniu.util.Auth;

/**
 * Created by liulei on 04/12/2016.
 */
public class QiniuUtils {

    public static final String ACCESS_KEY = "he3D3HmTc02k_bmVWXj2JHOjKIP-iutTD88BWpxG";

    public static final String SECRET_KEY = "ZpYx0PMLTdOzIg4rxq9P0_WjomNPCH8EBPn6GzOX";

    public static final String DOMAIN = "http://ogzl05bw9.bkt.clouddn.com/";

    public static final String BUCKET_NAME = "boot";

    /** 默认求职者头像 */
    public static final String DEFAULT_APPLICANT_HEAD = "DEFAULT_APPLICANT_HEAD";
    /** 默认招聘者头像 */
    public static final String DEFAULT_RECRUITER_HEAD = "DEFAULT_RECRUITER_HEAD";
    /** 默认企业LOGO */
    public static final String DEFAULT_COMPANY_LOGO = "DEFAULT_COMPANY_LOGO";

    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    public static String getUploadToken() {
        return auth.uploadToken(BUCKET_NAME);
    }

    public static String getDownloadUrl(String key) {
        String url = DOMAIN + key;
        return auth.privateDownloadUrl(url);
    }
}
