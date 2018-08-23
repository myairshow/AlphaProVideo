package cn.telecom.alphaprovideo.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import cn.telecom.alphaprovideo.R;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link WebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String URL = "url";

    // TODO: Rename and change types of parameters
    private String url;

    private OnWebFragmentInteractionListener mListener;

    private WebView webView;
    private final int CHANGE_HEADIMAGE_DEFAULE = 1;
    private final int CHANGE_PHOTOTAKE_DEFAULE = 2;
    private PhotoPopupWindow mPhotoPopupWindow;

    private Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CHANGE_HEADIMAGE_DEFAULE:
                    //选取摄像头
                    mPhotoPopupWindow = new PhotoPopupWindow(getActivity(), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // 进入相册选择
                        }
                    }, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // 拍照
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, CHANGE_PHOTOTAKE_DEFAULE);
                        }
                    });
                    View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_web, null);
                    mPhotoPopupWindow.showAtLocation(rootView,
                            Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    public WebFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param url Parameter 1.
     * @return A new instance of fragment WebFragment.
     */
    public static WebFragment newInstance(String url) {
        WebFragment fragment = new WebFragment();
        Bundle args = new Bundle();
        args.putString(URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_web, container, false);
        webView = root.findViewById(R.id.webView);
        webView.getSettings() .setSupportZoom(false);
        //调整图片至适合webview的大小
        webView.getSettings() .setUseWideViewPort(true);
        // 缩放至屏幕的大小
        webView.getSettings() .setLoadWithOverviewMode(true);
        //设置默认编码
        webView.getSettings() .setDefaultTextEncodingName("utf-8");
        //设置自动加载图片
        webView.getSettings() .setLoadsImagesAutomatically(true);
        //设置WebView支持JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        //在js中调用本地java方法
        webView.addJavascriptInterface(new JsInterface(getActivity(),myHandler), "AndroidWebView");
        webView.getSettings().setUserAgentString("114Test");

        //添加客户端支持
        webView.setWebChromeClient(new WebChromeClient());
//        webView.loadUrl("file:///android_asset/index.html");
        if(webView != null) {
            webView.loadUrl(url);
        }
        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onWebFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnWebFragmentInteractionListener) {
            mListener = (OnWebFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnWebFragmentInteractionListener {
        // TODO: Update argument type and name
        void onWebFragmentInteraction(Uri uri);
    }


    @SuppressLint("NewApi")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == CHANGE_PHOTOTAKE_DEFAULE ) {
            //部分手机获取uri为空，则需要从bundle中获取Bitmap
            Uri uri = intent.getData();
            if(uri == null){
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    Bitmap bitmap = (Bitmap) bundle.get("data"); //get bitmap
                    Bitmap compressBitmap = compressImage(bitmap);
                    String str = bitmapToBase64(compressBitmap);
                    setPlatformType(str);
                }
            }else {
                Bitmap bitmap = BitmapFactory.decodeFile(uri.getPath());
                Bitmap compressBitmap = compressImage(bitmap);
                String str = bitmapToBase64(compressBitmap);
                setPlatformType(str);

            }
        }
    }

    /**
     * 图片压缩
     * @param image
     * @return
     */
    public Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    // bitmap转base64
    public static String bitmapToBase64(Bitmap bitmap) {
        String result = "data:image/png;base64,";//必须加上“data:image/png;base64”图片的数据格式H5才能识别出来
        ByteArrayOutputStream bos = null;
        try {
            if (null != bitmap) {
                bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);// 将bitmap放入字节数组流中
                bos.flush();// 将bos流缓存在内存中的数据全部输出，清空缓存
                bos.close();
                byte[] bitmapByte = bos.toByteArray();
                result += Base64.encodeToString(bitmapByte, Base64.DEFAULT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.d("it520", "result=" + result);
        Log.d("it520", "size=" + bos.toByteArray().length / 1024);//获取ByteArrayOutputStream的大小，单位kb，
        return result;
    }

    /**
     * base64转Bitmap
     * @param base64String
     * @return
     */
    public static Bitmap base64ToBitmap(String base64String) {
        byte[] bytes = Base64.decode(base64String, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        return bitmap;
    }

    public void setPlatformType(final String result) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //android调用H5代码
                JSONObject result_obj = new JSONObject();
                try {
                    result_obj.put("name", "123");
                    result_obj.put("imgPath",result.toString());
                    webView.loadUrl("javascript: checkAndroidCallBack('"+ result_obj + "')");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, 1000);
    }

}
