package com.testing.azarkovic.testing;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    SQLiteDatabase ldb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null)
        {
            Globals.SetupActivity(this);
            LocalDatabase.getInstance(this);
            new GetUserDataAsync().execute();



        }

    }

    public void loginPassed()
    {
        LobbyFragment lf = new LobbyFragment();
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_down_and_fade_in, R.anim.slide_down_and_fade_in, R.anim.slide_up_and_fade_out,  R.anim.slide_up_and_fade_out)
                .add(R.id.main_PRL,lf,"lobby fragment")
                .commit();
    }
    public void checkUser(String uid, String name, String surname, String arrivalDate, String language, String room)
    {
        Globals.user = new User(uid,name, surname ,arrivalDate,language,room);

    }
    class GetUserDataAsync extends AsyncTask<String, Integer, String>
    {

        @Override
        protected String doInBackground(String... params)
        {
            Cursor data = LocalDatabase.getInstance(Main.this).execRaw("select * from CurrUser;");
            //if logged in -> get data -> first activity
            if(data != null && data.getCount() > 0)
            {
                data.moveToFirst();
                final String uid = data.getString(0);
                final String name = data.getString(1);
                final String surname = data.getString(2);
                final String arrivalDate = data.getString(3);
                final String language = data.getString(4);
                final String room = data.getString(5);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        checkUser(uid,name,surname,arrivalDate,language,room);
                    }
                });
            }
            else
            {
                LoginFragment lf = new LoginFragment();
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_down_and_fade_in, R.anim.slide_down_and_fade_in, R.anim.slide_up_and_fade_out,  R.anim.slide_up_and_fade_out)
                        .add(R.id.main_PRL,lf,"login fragment")
                        .addToBackStack(null)
                        .commit();

            }
            return null;
        }
    }



}
