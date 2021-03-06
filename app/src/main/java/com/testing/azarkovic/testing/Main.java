package com.testing.azarkovic.testing;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.testing.azarkovic.testing.Database.Model.User;
import com.testing.azarkovic.testing.Fragments.LobbyFragment;
import com.testing.azarkovic.testing.Fragments.LoginFragment;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null)
        {
            getHelper().getWritableDatabase();
            new GetUserDataAsync().execute();


        }

    }

    public void goToLobby()
    {
        LobbyFragment lf = new LobbyFragment();
        getFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_down_and_fade_in, R.anim.slide_down_and_fade_in, R.anim.slide_up_and_fade_out,  R.anim.slide_up_and_fade_out)
                .add(R.id.main_PRL,lf,"lobby fragment")
                .commit();
    }
    public void checkUser(String uid, String name, String surname, String arrivalDate, String language, String room)
    {
        Globals.user = new User(uid,name, surname ,arrivalDate,language,room);
        goToLobby();
    }
    class GetUserDataAsync extends AsyncTask<String, Integer, String>
    {

        @Override
        protected String doInBackground(String... params)
        {
            try {
                Dao userDao = getHelper().getDaoForClass(User.class);
                List<User> users = (userDao.queryForAll());
                if(users.size() > 0)
                {
                    Globals.user = users.get(0);
                    goToLobby();
                }
                else
                {
                    LoginFragment lf = new LoginFragment();
                    getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_down_and_fade_in, R.anim.slide_down_and_fade_in, R.anim.slide_up_and_fade_out,  R.anim.slide_up_and_fade_out)
                            .add(R.id.main_PRL,lf,"login fragment")
                            .addToBackStack(null)
                            .commit();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }
    }



}
