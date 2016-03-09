package com.testing.azarkovic.testing;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by azarkovic on 7.3.2016..
 */
public class Globals
{
    static public User user;
    static public void SetupActivity(AppCompatActivity activity)
    {
        FragmentAnimations.setup(activity);
        ButterKnife.inject(activity);
    }
}
