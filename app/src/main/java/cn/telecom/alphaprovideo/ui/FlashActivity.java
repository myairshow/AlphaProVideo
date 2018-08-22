package cn.telecom.alphaprovideo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import cn.telecom.alphaprovideo.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FlashActivity extends AppCompatActivity {

    private final static int CHANGE = 0x082201;
    private final static int MAIN = 0x082202;

    private UIHandler handler = new UIHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flash);


        findViewById(R.id.logo).setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        Message msg = Message.obtain();
        msg.obj = this;
        msg.what = CHANGE;
        handler.sendMessageDelayed(msg, 800L);

    }

    private void change() {
        ((ImageView)findViewById(R.id.telecomPic)).setImageResource(R.drawable.haobai);
        findViewById(R.id.logo).setBackgroundColor(0xFFFFEFD5);
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
                if(activity.isFinishing()){
                    return;
                }
                msg.obj = null;
                switch (msg.what) {
                    case CHANGE:
                        activity.change();
                        msg = Message.obtain();
                        msg.obj = activity;
                        msg.what = MAIN;
                        sendMessageDelayed(msg, 800L);
                        break;
                    case MAIN:
                        activity.toMain();
                        break;
                }
            }
        }
    }

}
