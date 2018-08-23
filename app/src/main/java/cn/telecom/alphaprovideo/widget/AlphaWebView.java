package cn.telecom.alphaprovideo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AlphaWebView extends WebView {
    public AlphaWebView(Context context) {
        super(context);
        init();
    }

    public AlphaWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AlphaWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AlphaWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    view.loadUrl(url);
                    return true;
                }
                return false;
            }

            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return shouldOverrideUrlLoading(view, request.getUrl().toString());
            }
        });
        WebSettings webSettings = getSettings();
        //支持缩放，默认为true。
        webSettings.setSupportZoom(false);
        //调整图片至适合webview的大小
        webSettings.setUseWideViewPort(true);
        // 缩放至屏幕的大小
        webSettings.setLoadWithOverviewMode(true);
        //设置默认编码
        webSettings.setDefaultTextEncodingName("utf-8");
        //设置自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        //开启javascript
        webSettings.setJavaScriptEnabled(true);
    }
}
