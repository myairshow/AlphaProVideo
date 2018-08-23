package cn.telecom.alphaprovideo.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

import cn.telecom.alphaprovideo.R;

/**
 * Created by ASUS on 2018/8/22.
 */

public class PhoneMsgActivity extends Activity {
    private TelephonyManager phone;
    private WifiManager wifi;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private static final int MY_PERMISSIONS_REQUEST_CALL_CAMERA = 2;

    @SuppressLint("WifiManagerLeak")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_msg);
        phone = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }else {
                initView();
            }
        }else {
            initView();
        }
    }

    @SuppressLint("MissingPermission")
    private void initView() {
        ConnectivityManager connectionManager = (ConnectivityManager)
                getSystemService(CONNECTIVITY_SERVICE);
        //获取网络的状态信息，有下面三种方式
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
        setEditText(R.id.phone_country, phone.getSimCountryIso());//国家
        setEditText(R.id.phone_brand, Build.BRAND);//品牌
        setEditText(R.id.phone_device, Build.DEVICE);//设备名
        setEditText(R.id.phone_imei, phone.getDeviceId());//IMEI
        setEditText(R.id.phone_imsi,phone.getSubscriberId());//IMSI
        setEditText(R.id.phone_operator,phone.getSimOperator());//运营商
        setEditText(R.id.phone_operator_name,phone.getSimOperatorName());//运营商名称
        if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
            setEditText(R.id.phone_nettype,"WIFI");//网络类型
        }else if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
            setEditText(R.id.phone_nettype,"1-4G");//网络类型
        }else if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
            setEditText(R.id.phone_nettype,"其他");//网络类型
        }
    }

    private void setEditText(int id, String str) {
        ((TextView) this.findViewById(id)).setText(str);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initView();
            } else {
                showToast("权限已拒绝");
            }
        }else if (requestCode == MY_PERMISSIONS_REQUEST_CALL_CAMERA){
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    //判断是否勾选禁止后不再询问
                    boolean showRequestPermission = ActivityCompat.shouldShowRequestPermissionRationale(PhoneMsgActivity.this, permissions[i]);
                    if (showRequestPermission) {
                        showToast("权限未申请");
                    }
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    private void showToast(String string){
        Toast.makeText(PhoneMsgActivity.this,string,Toast.LENGTH_LONG).show();
        this.finish();
    }
}
