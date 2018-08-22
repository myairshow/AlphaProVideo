package cn.telecom.alphaprovideo.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import cn.telecom.alphaprovideo.R;
import cn.telecom.alphaprovideo.model.VideoItem;
import cn.telecom.alphaprovideo.model.VideoList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VideoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ID = "id";

    private static int SCREENWIDTH = 320;
    private static int SCREENHEIGHT = 480;

    private String id;
    private VideoItem videoItem;

    private OnFragmentInteractionListener mListener;

    private VideoView videoView;
    private View playNow;
    private ImageView pic;

    public VideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param id Parameter 1.
     * @return A new instance of fragment VideoFragment.
     */
    public static VideoFragment newInstance(String id) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putString(ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString(ID);
        }
        videoItem = VideoList.getInstance().findItemById(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_video, container, false);
        videoView = root.findViewById(R.id.videoView);
        playNow = root.findViewById(R.id.playNow);
        pic = root.findViewById(R.id.pic);
        setupViews();
        displaySize(inflater.getContext());
        return root;
    }

    public void displaySize(Context act) {
        DisplayMetrics dm = act.getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        SCREENWIDTH = Math.min(width, height);
        SCREENHEIGHT = Math.max(width, height);
    }

    private void setupViews() {

        playNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNow.setVisibility(View.GONE);
                pic.setVisibility(View.GONE);
                videoView.setVideoPath(videoItem.getUrl());
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        if (width > 0 && height > 0) {
                            resetVideoViewSize(width, height);
                        }
                    }
                });
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playNow.setVisibility(View.VISIBLE);
                pic.setVisibility(View.VISIBLE);
            }
        });

        //实例化媒体控制器
        MediaController mediaController=new MediaController(videoView.getContext());
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);

        Glide.with(this).asBitmap().load(videoItem.getPicture())
                .into(pic);
    }

    private void resetVideoViewSize(int width, int height) {
        int size = SCREENWIDTH;
        ViewGroup.LayoutParams params = videoView.getLayoutParams();
        params.width = size;
        params.height = size * height / width;
        videoView.setLayoutParams(params);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
