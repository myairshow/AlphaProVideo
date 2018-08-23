package cn.telecom.alphaprovideo.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class FileCopyUtil {

    public static String appRoot = "/Android/data/cn.telecom.alphaprovideo/";

    public static void copy(Context context) {
        FileUtils utils = FileUtils.getInstance(context.getApplicationContext());
        utils.setFileOperateCallback(new FileUtils.FileOperateCallback() {
            @Override
            public void onSuccess() {
                Log.i("COPY WEB","success");
            }

            @Override
            public void onFailed(String error) {
                Log.i("COPY WEB","FAILED");
            }
        });
        utils.copyAssetsToSD("web", appRoot + "web");
    }
}
