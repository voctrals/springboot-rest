package cn.voctrals.boot.api.model;

/**
 * Created by liulei on 22/11/2016.
 */
public class OAuthModel {

    private String code;

    private String accessToken;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
