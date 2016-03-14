package com.testing.azarkovic.testing.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.testing.azarkovic.testing.Globals;
import com.testing.azarkovic.testing.R;

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
        welcomeLabel.setText("Welcome "+ Globals.user.getName()+"! What would you like to do first?");
        return v;
    }

}
