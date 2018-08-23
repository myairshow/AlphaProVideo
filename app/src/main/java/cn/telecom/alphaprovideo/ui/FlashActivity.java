package cn.telecom.alphaprovideo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import cn.telecom.alphaprovideo.R;
import cn.telecom.alphaprovideo.utils.FileCopyUtil;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FlashActivity extends AppCompatActivity {

    private final static int MAIN = 0x082202;

    private UIHandler handler = new UIHandler();

    private ImageView telecomPic;
    private View ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flash);

        findViews();

        findViewById(R.id.logo).setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        startAnimation();

        FileCopyUtil.copy(this);
    }

    private void startAnimation() {
        Animation circle_anim = AnimationUtils.loadAnimation(this, R.anim.anim_round_rotate);
        LinearInterpolator interpolator = new LinearInterpolator();  //设置匀速旋转，在xml文件中设置会出现卡顿
        circle_anim.setInterpolator(interpolator);
        circle_anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startAnimation2();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        telecomPic.startAnimation(circle_anim);  //开始动画
    }

    private void startAnimation2() {
        telecomPic.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        LinearInterpolator interpolator = new LinearInterpolator();
        animation.setInterpolator(interpolator);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                change();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        telecomPic.startAnimation(animation);  //开始动画
    }

    private void startAnimation3() {
        telecomPic.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha_out);
        LinearInterpolator interpolator = new LinearInterpolator();
        animation.setInterpolator(interpolator);
        telecomPic.startAnimation(animation);  //开始动画
    }

    private void startAnimationAd() {
        ad.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        LinearInterpolator interpolator = new LinearInterpolator();
        animation.setInterpolator(interpolator);
        ad.startAnimation(animation);  //开始动画
    }

    private void findViews() {
        telecomPic = findViewById(R.id.telecomPic);
        ad = findViewById(R.id.ad);
    }

    private void change() {
        ad.setVisibility(View.VISIBLE);
        startAnimationAd();
        startAnimation3();

        Message msg = Message.obtain();
        msg.obj = this;
        msg.what = MAIN;
        handler.sendMessageDelayed(msg,
                getResources().getInteger(R.integer.animAlphaTime) + 600L);
    }

    private void toMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private static class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.obj instanceof FlashActivity) {
                FlashActivity activity = (FlashActivity) msg.obj;
                if (activity.isFinishing()) {
                    return;
                }
                msg.obj = null;
                switch (msg.what) {
                    case MAIN:
                        activity.toMain();
                        break;
                }
            }
        }
    }

}
