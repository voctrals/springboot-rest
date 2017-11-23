package cn.voctrals.boot.util.rongcloud;

import io.rong.RongCloud;
import io.rong.messages.BaseMessage;
import io.rong.messages.ImgTextMessage;
import io.rong.messages.InfoNtfMessage;
import io.rong.messages.TxtMessage;
import io.rong.models.CodeSuccessResult;
import io.rong.models.TokenReslut;

/**
 * 融云相关
 * @author LiuLei
 * @version 2016-12-05
 */
public class RongCloudUtil {

    /** APPKEY 4z3hlwrv4xyxt k51hidwq1qi0b*/
    private static final String appKey = "4z3hlwrv4xyxt";

    /** APP SECRET Brh91otasCsS cS4n3kl3EJS*/
    private static final String appSecret = "Brh91otasCsS";

    /** 单刀职入小助手 */
    public static final String HELPER_ID = "boot_helper";
    public static final String HELPER_NAME = "小助手";
    public static final String HELPER_TOKEN = "AW2oDqj6YSSowh4bQ1+UBvBfXlq5js2B3ZhyGrPwbNoNTPC+wk96hfpjRnN1TbGKgjdg/GFzuNbqImtdrGgnTVf+BTOvtefOq1+ZVr7vxQA=";


    /** 融云工具 */
    private static final RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);

    /**
     * 获取Token
     * @param  userId       用户 Id，最大长度 64 字节。是用户在 App 中的唯一标识码，必须保证在同一个 App 内不重复，重复的用户 Id 将被当作是同一用户。（必传）
     * @param  name         用户名称，最大长度 128 字节。用来在 Push 推送时显示用户的名称。用户名称，最大长度 128 字节。用来在 Push 推送时显示用户的名称。（必传）
     * @param  portraitUri  用户头像 URI，最大长度 1024 字节。用来在 Push 推送时显示用户的头像。（必传）
     *
     * @return TokenReslut
     */
    public static TokenReslut getToken(String userId, String name, String portraitUri) {
        TokenReslut userGetTokenResult = null;
        try {
            userGetTokenResult = rongCloud.user.getToken(userId, name, portraitUri);
        } catch (Exception e) {
            userGetTokenResult = new TokenReslut(1001, "", null, "融云错误");
        } finally {
            return userGetTokenResult;
        }
    }

    /**
     * 获取Token
     * @param  userId       用户 Id，最大长度 64 字节
     * @param  name         用户名称，最大长度 128 字节
     *
     * @return TokenReslut
     */
    public static TokenReslut getToken(String userId, String name) {
        return getToken(userId, name, "");
    }

    /**
     * 获取Token
     * @param  userId       用户 Id，最大长度 64 字节
     *
     * @return TokenReslut
     */
    public static TokenReslut getToken(String userId) {
        return getToken(userId, "", "");
    }

    /**
     * 刷新用户
     * @param  userId       用户 Id，最大长度 64 字节
     * @param  name         用户名称，最大长度 128 字节
     *
     * @return CodeSuccessResult
     */
    public static CodeSuccessResult refreshUser(String userId, String name) {
        CodeSuccessResult result = null;
        try {
            result = rongCloud.user.refresh(userId, name, "");
        } catch (Exception e) {
            result = new CodeSuccessResult(1001, "融云错误");
        } finally {
            return result;
        }
    }

    /**
     * 发送广播消息
     *
     * @param  fromUserId   发送人用户 Id
     * @param  message      发送的内容
     * @param  pushContent  显示到状态栏中的内容
     *
     * @return CodeSuccessResult
     */
    public static CodeSuccessResult broadcast(String fromUserId, BaseMessage message, String pushContent) {
        CodeSuccessResult messageBroadcastResult = null;
        try {
            messageBroadcastResult = rongCloud.message.broadcast(fromUserId, message, pushContent, null, null);
        } catch (Exception e) {
            messageBroadcastResult = new CodeSuccessResult(1001, "融云错误");
        } finally {
            return messageBroadcastResult;
        }
    }

    /**
     * 发送系统通知
     *
     * @param  toUserIds   发送人用户 Id
     * @param  message     发送的内容
     *
     * @return CodeSuccessResult
     */
    public static CodeSuccessResult publishSystem(String[] toUserIds, BaseMessage message) {
        CodeSuccessResult messagePublishSystemResult = null;
        try {
            messagePublishSystemResult = rongCloud.message.publishSystem(HELPER_ID, toUserIds, message, null, null, 0, 0);
        } catch (Exception e) {
            messagePublishSystemResult = new CodeSuccessResult(1001, "融云错误");
        } finally {
            return messagePublishSystemResult;
        }
    }

    /**
     * 发送私聊消息
     *
     * @param fromUser    发送人用户 Id
     * @param toUser      接收者用户 Id
     * @param message     消息内容
     *
     * @return CodeSuccessResult
     */
    public static CodeSuccessResult sendPrivateMessage(String fromUser, String toUser, BaseMessage message) {
        CodeSuccessResult privateMessageResult = null;
        try {
            rongCloud.message.publishPrivate(fromUser, new String[]{toUser}, message, null, null, null, null, null, null);
        } catch (Exception e) {
            privateMessageResult = new CodeSuccessResult(1001, "融云错误");
        } finally {
            return privateMessageResult;
        }
    }

    public static void main(String[] args) {
//        System.out.println(getToken("thinkgem", "", ""));
//        ImgTextMessage msg = new ImgTextMessage("我们在测试，别离我们！", "这里是extra", "我是标题", "https://dn-st.teambition.net/teambition/images/logo.532c7f46.svg", "http://www.baidu.com");
//        System.out.println(broadcast("thinkgem", msg, "这是图片文本消息！"));
        // 广播消息构建
//        ImgTextMessage broadcastMsg = new ImgTextMessage("1234", null, "5678", null, "http://www.baidu.com");
//        RongCloudUtil.broadcast("1", broadcastMsg, "单刀职入发布了一条求职秘籍。");

        InfoNtfMessage message = new InfoNtfMessage("刘磊申请了XXX职位", "12");
        RongCloudUtil.sendPrivateMessage("cfa8f8d6df674614b3d2130c2a2c5fdc", "24d1f75521c94a68b048741a33186c83", message);
    }

}
