package com.booyue.core.db.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.booyue.core.app.ProjectInit;
import com.booyue.core.db.IDao;
import com.booyue.core.db.InstallBean;
import com.booyue.core.db.greendao.gen.DaoMaster;
import com.booyue.core.db.greendao.gen.InstallBeanDao;
import com.booyue.core.utils.LoggerUtils;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.10:16
 * greendao数据库框架，首先创建实体类才能使用DaoMaster
 */

public class InstallDao implements IDao<InstallBean> {
    private static final String TAG = "InstallDao";
    private static InstallDao db;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;
    private final InstallBeanDao mInstallDao;


    public InstallDao() {
        context = ProjectInit.getApplicationContext();
        openHelper = new DaoMaster.DevOpenHelper(context, ProjectInit.getDatabaseName());
        mInstallDao = DaoManager.getDaoSession(context).getInstallBeanDao();
    }

    /**
     * 获取单例
     *
     * @return
     */
    public static InstallDao getInstance() {
        if (db == null) {
            synchronized (InstallDao.class) {
                if (db == null) {
                    db = new InstallDao();
                }
            }
        }
        return db;
    }


    /**
     * 获取可读数据库
     */
    @Override
    public SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, ProjectInit.getDatabaseName());
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    @Override
    public SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, ProjectInit.getDatabaseName());
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    @Override
    public void insert(InstallBean InstallInfo) {
        mInstallDao.insert(InstallInfo);
    }

    @Override
    public void update(InstallBean InstallInfo) {
        mInstallDao.update(InstallInfo);
    }

    @Override
    public void delete(InstallBean InstallInfo) {
        LoggerUtils.d(TAG, "install delete: ");
        mInstallDao.delete(InstallInfo);
    }

    @Override
    public List<InstallBean> query() {
        QueryBuilder<InstallBean> qb = mInstallDao.queryBuilder();
        return qb.list();
    }

    private List<Property> conditionList = new ArrayList<>();

    @Override
    public List<InstallBean> query(List<WhereCondition> whereConditionList) {
        conditionList.clear();
        QueryBuilder<InstallBean> qb = mInstallDao.queryBuilder();
        //用户名
        for (WhereCondition whereCondition : whereConditionList) {
            qb.where(whereCondition);
        }
        List<InstallBean> list = qb.list();
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }

    @Override
    public InstallBean queryById(long id) {
        QueryBuilder<InstallBean> qb = mInstallDao.queryBuilder();
        qb.where(InstallBeanDao.Properties.AppId.eq(id));
        List<InstallBean> list = qb.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
