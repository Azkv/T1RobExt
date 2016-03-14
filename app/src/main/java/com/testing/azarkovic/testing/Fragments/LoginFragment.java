package com.testing.azarkovic.testing.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.j256.ormlite.dao.Dao;
import com.testing.azarkovic.testing.Database.Model.User;
import com.testing.azarkovic.testing.Globals;
import com.testing.azarkovic.testing.Main;
import com.testing.azarkovic.testing.R;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by azarkovic on 7.3.2016..
 */
public class LoginFragment extends Fragment implements ZXingScannerView.ResultHandler
{
    private ZXingScannerView scannerView;
    public LoginFragment()
    {


    }

    public void SaveUser(String uid, String name, String surname, String arrivalDate, String language, String room)
    {
        Globals.user = new User(uid,name,surname,arrivalDate,language,room);
        try {
            Dao d = ((Main)getActivity()).getHelper().getDaoForClass(User.class);
            d.create(Globals.user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.login_fragment_layout,container,false);
        scannerView = (ZXingScannerView) v.findViewById(R.id.login_scanner);
        ArrayList<BarcodeFormat> formats = new ArrayList<BarcodeFormat>();
        formats.add(BarcodeFormat.QR_CODE);
        scannerView.setFormats(formats);
        scannerView.setResultHandler(this);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((Main)this.getActivity()).goToLobby();
    }

    @Override
    public void handleResult(Result result)
    {
        String rez_s = result.getText();
        rez_s = "123#Alen#Zarkovic#25.01.2016#Croatian#1132";
        String[] data = rez_s.split("#");
        SaveUser(data[0], data[1], data[2], data[3], data[4], data[5]);

        getFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_up_and_fade_out, R.anim.slide_up_and_fade_out,R.anim.slide_down_and_fade_in, R.anim.slide_down_and_fade_in)
                .remove(this)
                .commit();

    }
}
