package com.testing.azarkovic.testing;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.testing.azarkovic.testing.Database.Helper.DBHelper;

/**
 * Created by azarkovic on 14.3.2016..
 */
public class BaseActivity extends OrmLiteBaseActivity<DBHelper>
{
    public BaseActivity()
    {
        super();
        Globals.SetupActivity(this);
    }
}
