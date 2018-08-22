package cn.telecom.alphaprovideo.ui;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.telecom.alphaprovideo.R;

public class DetailActivity extends AppCompatActivity implements VideoFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.videoFragment,VideoFragment.newInstance(""))
                .commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
