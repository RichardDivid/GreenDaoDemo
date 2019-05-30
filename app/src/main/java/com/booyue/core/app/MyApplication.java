package com.booyue.core.app;

import android.app.Application;

import com.booyue.core.db.greendao.DaoManager;

/**
 * @author: wangxinhua
 * @date: 2019/4/23
 * @description :
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ProjectInit.getInstance()
                //必须先调用，因为后面的链式调用可能需要用到全局context
                .init(this)
                //下面初始化路由的时候需要用到debug
                .debug(true)
                .databaseName(DaoManager.DB_NAME)
                .config();
    }
}
