package com.testing.azarkovic.testing;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.testing.azarkovic.testing.Database.Model.User;
import com.testing.azarkovic.testing.Fragments.FragmentAnimations;

import butterknife.ButterKnife;

/**
 * Created by azarkovic on 7.3.2016..
 */
public class Globals
{
    static public User user;
    static public void SetupActivity(Activity activity)
    {
        FragmentAnimations.setup(activity);
        ButterKnife.inject(activity);
    }
}
