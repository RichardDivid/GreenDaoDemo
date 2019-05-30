package com.booyue.core.db.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.booyue.core.db.greendao.gen.DaoMaster;
import com.booyue.core.db.greendao.gen.DownloadBeanDao;
import com.booyue.core.db.greendao.gen.InstallBeanDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Administrator on 2018/7/5.18:47
 */

public class MyOpenHelper extends DaoMaster.OpenHelper{

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 数据库升级
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //操作数据库的更新 有几个表升级都可以传入到下面
        MigrationHelper.getInstance().migrate(db,DownloadBeanDao.class,InstallBeanDao.class);
//        MigrationHelper.getInstance().migrate(db,InstallBeanDao.class);
    }
}
