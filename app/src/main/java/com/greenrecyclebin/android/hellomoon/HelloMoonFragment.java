package com.greenrecyclebin.android.hellomoon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by greenrecyclebin on 8/2/15.
 */
public class HelloMoonFragment extends Fragment {
    private AudioPlayer player = new AudioPlayer();
    private Button playButton;
    private Button stopButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        playButton = (Button) v.findViewById(R.id.hellomoon_playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.play(getActivity());
            }
        });

        stopButton = (Button) v.findViewById(R.id.hellomoon_stopButton);

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
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
