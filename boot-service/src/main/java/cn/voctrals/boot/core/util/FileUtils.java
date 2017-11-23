package cn.voctrals.boot.core.util;

import cn.voctrals.boot.util.Constants;
import cn.voctrals.boot.util.qiniu.QiniuUtils;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * Created by liulei on 2017/1/5.
 */
public class FileUtils {

    public static boolean checkFileExist(String fileName) {
        boolean ret = true;
        try {
            File f = new File(fileName);
            ret = f.exists();
        } catch (Exception e) {
            ret = false;
        }
        return ret;
    }

    public static boolean checkFileExistInTempDir(String key) {
        boolean ret = true;
        try {
            if (StringUtils.isEmpty(key)) {
                ret = false;
            } else {
                File f = new File(Constants.UPLOAD_FILE_PATH + File.separator + key);
                ret = f.exists();
            }
        } catch (Exception e) {
            ret = false;
        }
        return ret;
    }


    public static boolean qiniuUploadFile(String key) {
        boolean ret = true;
        try {
            Zone z = Zone.autoZone();
            Configuration c = new Configuration(z);
            UploadManager uploadManager = new UploadManager(c);
            //调用put方法上传
            Response res = uploadManager.put(Constants.UPLOAD_FILE_PATH + File.separator + key, key, QiniuUtils.getUploadToken());
            //打印返回的信息
            //System.out.println(res.bodyString());
            ret = res.isOK();
        } catch (QiniuException e) {
            ret = false;
//            Response r = e.response;
//            // 请求失败时打印的异常的信息
//            System.out.println(r.toString());
//            try {
//                //响应的文本信息
//                System.out.println(r.bodyString());
//            } catch (QiniuException e1) {
//                //ignore
//            }
        }
        return ret;
    }

    public static boolean deleteFile(String key) {
        return false;
    }
}
