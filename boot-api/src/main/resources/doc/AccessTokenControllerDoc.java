package cn.voctrals.boot.api.doc;

/**
 * Created by liulei on 16/11/2016.
 */
public interface AccessTokenControllerDoc {
    /**
     *
     * @api {post} /accessToken?redirect_uri={redirect_uri} 获取访问token
     * @apiName 获取访问token
     * @apiGroup OAuth2
     * @apiVersion 0.1.0
     * @apiDescription 获取访问token
     * grant_type,code,client_id,client_secret等4个参数，需要通过x-www-form-urlencoded方式提交。
     *
     * @apiParam {String} redirect_uri 从定向URL
     * @apiParam {String} grant_type 授权类型(定值:"authorization_code")
     * @apiParam {String} code 权限Code
     * @apiParam {String} client_id 客户端ID(手机号)
     * @apiParam {String} client_secret 客户端密码（用户密码）
     *
     * @apiSuccess {Object} error 错误消息说明
     * @apiSuccess {Object} data 返回结果
     * @apiSuccess {int} data.accessToken 访问token
     * @apiSuccessExample Success-Response:
     *
    {
        "data": {
            "accessToken": "3d86c146238e1b1df73c593a5178e8b8"
        }
    }
     *
     */
    void authorize();

}
