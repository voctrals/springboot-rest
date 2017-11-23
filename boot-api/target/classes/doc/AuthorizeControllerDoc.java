package cn.voctrals.boot.api.doc;

/**
 * Created by liulei on 16/11/2016.
 */
public interface AuthorizeControllerDoc {
    /**
     *
     * @api {get} /authorize?client_id={client_id}&response_type=code 获取权限Code
     * @apiName 获取权限Code
     * @apiGroup OAuth2
     * @apiVersion 0.1.0
     * @apiDescription 获取权限Code
     *
     * @apiParam {String} client_id 客户端ID(用户名)
     * @apiParam {String} response_type 响应类型（定值："code"）
     *
     * @apiSuccess {Object} error 错误消息说明
     * @apiSuccess {Object} data 返回结果
     * @apiSuccess {int} data.code 权限Code
     * @apiSuccessExample Success-Response:
     *
        {
            "data": {
                "code": "7df03f6924ee236d714463306e679391"
            }
        }
     *
     */
    void authorize();

}
