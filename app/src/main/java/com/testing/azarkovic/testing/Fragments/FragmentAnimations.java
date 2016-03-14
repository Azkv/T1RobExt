package com.testing.azarkovic.testing.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.testing.azarkovic.testing.R;


/**
 * Created by azarkovic on 4.3.2016..
 */
public class FragmentAnimations
{
    static public Context ctx;
    static public void setup(Context ctx)
    {
        FragmentAnimations.ctx = ctx;
    }

    static private FragmentManager getFragmentManager()
    {
        if(ctx instanceof AppCompatActivity)
        {
            return ((AppCompatActivity)ctx).getSupportFragmentManager();
        }
        else return null;
    }
    public static void FadeOut(Fragment f)
    {
        if(!f.isAdded()) return;
        getFragmentManager().beginTransaction()
            .setCustomAnimations(android.R.anim.fade_out, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_in)
            .remove(f)
            .addToBackStack(null)
            .commit();
    }

    public static void FadeIn(int container, Fragment f)
    {
        getFragmentManager().beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_out)
            .add(container, f)
            .addToBackStack(null)
            .commit();
    }

    public static void SlideInFromLeft(int container, Fragment f)
    {

        getFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_out_right)
                .add(container, f)
                .addToBackStack(null)
                .commit();
    }
    public static void SlideOutToRight(Fragment f)
    {
        if(!f.isAdded()) return;
        getFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_out_right, android.R.anim.slide_in_left,android.R.anim.slide_in_left)
                .remove(f)
                .addToBackStack(null)
                .commit();
    }

    public static void SlideUpAndFadeOut(Fragment f)
    {
        if(!f.isAdded()) return;
        getFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_up_and_fade_out, R.anim.slide_up_and_fade_out, R.anim.slide_up_and_fade_in, R.anim.slide_up_and_fade_in)
                .remove(f)
                .addToBackStack(null)
                .commit();
    }
    public static void SlideUpAndFadeIn(int container,Fragment f)
    {
        if(f.isAdded()) return;
        getFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_up_and_fade_in, R.anim.slide_up_and_fade_in, R.anim.slide_up_and_fade_out, R.anim.slide_up_and_fade_out)
                .add(container, f)
                .addToBackStack(null)
                .commit();
    }


}
