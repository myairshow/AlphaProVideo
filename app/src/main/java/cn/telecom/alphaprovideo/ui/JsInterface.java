package cn.telecom.alphaprovideo.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.webkit.JavascriptInterface;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ASUS on 2018/8/22.
 */

public class JsInterface {
    private Context mContext;
    private Handler mHandler;
    private final int CHANGE_HEADIMAGE_DEFAULE = 1;

    public JsInterface(Context context) {
        this.mContext = context;
    }
    public JsInterface(Context context,Handler mHandler) {
        this.mContext = context;
        this.mHandler = mHandler;
    }

    //在js中调用window.AndroidWebView.showInfoFromJs(name)，便会触发此方法。
    @JavascriptInterface
    public void getAndroidMethod(String name) {
        //解析数据
        try {
            JSONObject json_obj = new JSONObject(name);
            String action = json_obj.getString("action");
            int type = json_obj.getInt("type");
            if("Home".equals(action)){

            }else if("userCenter".equals(action)){
                switch (type){
                    case 1:
                        //替换头像
                        mHandler.sendEmptyMessage(CHANGE_HEADIMAGE_DEFAULE);
                        break;
                    case 2:
                        //手机信息
                            toPhoneMsgActivity();
                        break;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void toPhoneMsgActivity(){
        Intent intent_phoneMsg = new Intent(mContext,PhoneMsgActivity.class);
        mContext.startActivity(intent_phoneMsg);
    }

}
