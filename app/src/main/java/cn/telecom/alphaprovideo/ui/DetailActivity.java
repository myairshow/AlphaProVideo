package cn.telecom.alphaprovideo.ui;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import cn.telecom.alphaprovideo.R;

public class DetailActivity extends AppCompatActivity implements VideoFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.videoFragment, VideoFragment.newInstance(""))
                .commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        if (uri.getPath().equals("/VIDEO")) {
            if (uri.getQueryParameter("FULL").equalsIgnoreCase("true")) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                enterImmersiveScreen(getWindow());
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                exitImmersiveScreen(getWindow());
            }
        }
    }

    /**
     * 进入沉浸模式
     */
    static void enterImmersiveScreen(Window window) {
        hideSystemUI(window);
    }

    /**
     * 退出沉浸模式
     */
    static void exitImmersiveScreen(Window window) {
        showSystemUI(window);
    }

    /**
     * 隐藏系统UI
     */
    private static void hideSystemUI(Window window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 显示系统UI
     */
    private static void showSystemUI(Window window) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
