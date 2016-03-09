package com.testing.azarkovic.testing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by azarkovic on 8.3.2016..
 */
public class LobbyFragment extends Fragment
{
    TextView welcomeLabel ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.lobby_fragment_layout,container,false);
        welcomeLabel = (TextView) v.findViewById(R.id.lobby_welcomeLabel);
        welcomeLabel.setText("Welcome "+Globals.user.getName()+"! What would you like to do first?");
        return v;
    }
}
