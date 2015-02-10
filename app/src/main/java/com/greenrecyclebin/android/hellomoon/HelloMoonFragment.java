package com.greenrecyclebin.android.hellomoon;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

/**
 * Created by greenrecyclebin on 8/2/15.
 */
public class HelloMoonFragment extends Fragment {
    private AudioPlayer player = new AudioPlayer();
    private Button playButton;
    private Button pauseButton;
    private Button stopButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        final VideoView videoView = (VideoView) v.findViewById(R.id.hellomoon_videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.apollo_17_stroll));

        playButton = (Button) v.findViewById(R.id.hellomoon_playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.play(getActivity());

                videoView.start();

                playButton.setEnabled(false);
                pauseButton.setEnabled(true);
                stopButton.setEnabled(true);
            }
        });

        pauseButton = (Button) v.findViewById(R.id.hellomoon_pauseButton);
        pauseButton.setEnabled(false);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.pause();

                videoView.pause();

                playButton.setEnabled(true);
                pauseButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });

        stopButton = (Button) v.findViewById(R.id.hellomoon_stopButton);
        stopButton.setEnabled(false);

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();

                videoView.stopPlayback();
                videoView.resume();

                playButton.setEnabled(true);
                pauseButton.setEnabled(false);
                stopButton.setEnabled(false);
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }
}
