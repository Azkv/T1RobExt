package com.testing.azarkovic.testing;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;


/**
 * Created by azarkovic on 8.3.2016..
 */
public class LocalDatabase
{
    private static LocalDatabase instance;
    private static SQLiteDatabase ldb;
    private static Context ctx;
    private LocalDatabase()
    {
        setupDatabase();
    }
    public static LocalDatabase getInstance(Context ctx)
    {
        LocalDatabase.ctx = ctx;
        if(instance == null) { instance = new LocalDatabase(); }
        return instance;
    }

    public Cursor execRaw(String query)
    {
       return ldb.rawQuery(query,null);
    }
    public void setupDatabase()
    {
        ldb = ctx.openOrCreateDatabase("db_localdata", ctx.MODE_PRIVATE, null);

        if(ldb != null)
        {
            ldb.execSQL("CREATE TABLE IF NOT EXISTS CurrUser(uid INTEGER, name VARCHAR, surname VARCHAR, arrivalDate VARCHAR, language VARCHAR, room VARCHAR);");
        }
    }
}
