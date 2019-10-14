package com.quyunshuo.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.quyunshuo.greendaodemo.greendao.DaoMaster;
import com.quyunshuo.greendaodemo.greendao.DaoSession;

/**
 * @Author: MiYan
 * @Time: 2019/9/12 15:58
 * @Description: 描述：
 */
public class GreenDAOApplication extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDAO();
    }

    private void initGreenDAO() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "aserbao.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
