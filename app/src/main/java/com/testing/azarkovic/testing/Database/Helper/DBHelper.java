package com.testing.azarkovic.testing.Database.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.LruCache;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by azarkovic on 14.3.2016..
 */
public class DBHelper extends OrmLiteSqliteOpenHelper
{
    private static LruCache<Class,Dao> daoLruCache;
    private static LruCache<Class,RuntimeExceptionDao> runExDaoLruCache;

    public DBHelper(Context context) {
        //TODO: sdpath -> root on release
        super(context, DBStatics.DB_NAME, null, DBStatics.DB_VERSION);
        if (daoLruCache == null) {
            daoLruCache = new LruCache<Class, Dao>(DBStatics.MAX_LRU_CACHE_SIZE);
        }

    }

    private static LruCache<Class,RuntimeExceptionDao> getRunExDaoLruCache() {
        if (runExDaoLruCache == null) {
            runExDaoLruCache = new LruCache<Class, RuntimeExceptionDao>(DBStatics.MAX_LRU_CACHE_SIZE);
        }
        return runExDaoLruCache;
    }

    private static LruCache<Class,Dao> getDaoLruCache() {
        if (daoLruCache == null) {
            daoLruCache = new LruCache<Class, Dao>(DBStatics.MAX_LRU_CACHE_SIZE);
        }
        return daoLruCache;
    }

    public <D extends com.j256.ormlite.dao.Dao<T,Integer>,T> D getDaoForClass(Class<T> clazz)
            throws SQLException {
        com.j256.ormlite.dao.Dao<T,Integer> cachedDao = getDaoLruCache().get(clazz);
        if (cachedDao == null) {
            cachedDao = getDao(clazz);
            getDaoLruCache().put(clazz, cachedDao);
        }
        return (D) cachedDao;
    }

    /**
     * Get an {link:RuntimeExceptionDao<T,Integer>} object for the specified class
     *
     * This class will throw a RuntimeException when the class is not valid or there is
     * another problem with the SQL statements
     *
     * @param clazz the Class for which to get a Dao
     * @param <D> the type of the Dao which will be returned
     * @param <T> The type of the provided class
     * @return The properly typed RuntimeExceptionDao for the given class with an Integer id
     *
     */
    public <D extends RuntimeExceptionDao<T, Integer>, T> D getRunExDaoForClass(Class<T> clazz) {
        RuntimeExceptionDao<T,Integer> cachedDao = getRunExDaoLruCache().get(clazz);
        if (cachedDao == null) {
            cachedDao = getRuntimeExceptionDao(clazz);
            getRunExDaoLruCache().put(clazz,cachedDao);
        }
        return (D) cachedDao;
    }

    private void createDatabase(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DBStatics.TAG, "Creating database");

            Log.i(DBStatics.TAG, "Creating tables");
            for(Class cl : DBStatics.tables)
            {
                TableUtils.createTable(connectionSource, cl);
                Log.i(DBStatics.TAG, "Table created: " + cl.getName());

                //cache all daos at creation
                getDaoForClass(cl);
                getRunExDaoForClass(cl);
            }

        } catch (SQLException e) {
            Log.e(DBStatics.TAG, "Database can't be created. Error: ", e);
            throw new RuntimeException(e);
        }
    }

    private void dropDatabase(SQLiteDatabase db, ConnectionSource connectionSource)
    {
        try {
            Log.i(DBStatics.TAG, "Deleting database");

            Log.i(DBStatics.TAG, "Dropping tables");
            for(Class cl : DBStatics.tables)
            {
                TableUtils.dropTable(connectionSource, cl, true);
                Log.i(DBStatics.TAG,"Table dropped: " + cl.getName());
            }
            daoLruCache.evictAll();
            runExDaoLruCache.evictAll();
        } catch (SQLException e) {
            Log.e(DBStatics.TAG, "Database can't be dropped. Error: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource)
    {
        Log.i(DBStatics.TAG, "Creating database..");
        createDatabase(database, connectionSource);
    }



    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion)
    {
        Log.i(DBStatics.TAG, "Recreating database for update..");
        dropDatabase(database, connectionSource);
        createDatabase(database, connectionSource);

    }
}
