package cn.telecom.alphaprovideo.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import cn.telecom.alphaprovideo.R;

public class DetailActivity extends AppCompatActivity implements VideoFragment.OnVideoFragmentInteractionListener,
        DetailFragment.OnDetailFragmentInteractionListener {

    private final static String ID = "id";

    public static void open(Context context, String id) {
        Intent intent = new Intent(context, DetailActivity.class);
        Bundle map = new Bundle();
        map.putString(ID, id);
        intent.putExtras(map);
        context.startActivity(intent);
    }

    private String id;
    private View detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            id = savedInstanceState.getString(ID);
        } else if (getIntent() != null && getIntent().getExtras() != null) {
            id = getIntent().getExtras().getString(ID);
        }

        setContentView(R.layout.activity_detail);

        detail = findViewById(R.id.detail);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.videoFragment, VideoFragment.newInstance(id))
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.detail, DetailFragment.newInstance(id))
                .commit();
    }


    @Override
    public void onVideoFragmentInteraction(Uri uri) {
        if (uri.getPath().equals("/VIDEO")) {
            if (uri.getQueryParameter("FULL").equalsIgnoreCase("true")) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                enterImmersiveScreen(getWindow());
                detail.setVisibility(View.GONE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                exitImmersiveScreen(getWindow());
                detail.setVisibility(View.VISIBLE);
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

    @Override
    public void onDetailFragmentInteraction(Uri uri) {

    }
}
