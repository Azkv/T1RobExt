package com.testing.azarkovic.testing.Database.Helper;

import com.testing.azarkovic.testing.Database.Model.User;

/**
 * Created by azarkovic on 14.3.2016..
 */
public class DBStatics
{
    public static final String DB_NAME = "/sdcard/Testing/DB_ROBEXT.db";
    public static int DB_VERSION = 1;
    public static final String TAG = "DBHelper";
    public static final int MAX_LRU_CACHE_SIZE = 15 * 1024 * 1024;
    public static Class[] tables = new Class[]
            {
                    //classes for tables go here
                    User.class
            };
}
