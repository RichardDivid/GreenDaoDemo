package com.booyue.core.db.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.booyue.core.app.ProjectInit;
import com.booyue.core.db.DownloadBean;
import com.booyue.core.db.IDao;
import com.booyue.core.db.greendao.gen.DaoMaster;
import com.booyue.core.db.greendao.gen.DownloadBeanDao;
import com.booyue.core.db.greendao.gen.InstallBeanDao;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangxinhua
 * @date: 2019/4/23
 * @description :
 */
public class DownloadDao implements IDao<DownloadBean> {
    private Context context;
    private static DownloadDao downloadDao;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private DownloadBeanDao downloadbeanDao;
    private DownloadDao() {
        context = ProjectInit.getApplicationContext();
        devOpenHelper = new DaoMaster.DevOpenHelper(context,ProjectInit.getDatabaseName());
        downloadbeanDao = DaoManager.getDaoSession(context).getDownloadBeanDao();
    }
    public static DownloadDao getInstance(){
        if(downloadDao == null){
            synchronized (DownloadDao.class ){
                if(downloadDao == null){
                    downloadDao = new DownloadDao();
                }
            }
        }
        return downloadDao;
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return devOpenHelper.getReadableDatabase();
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return devOpenHelper.getWritableDatabase();
    }

    @Override
    public void insert(DownloadBean downloadBean) {
        downloadbeanDao.insert(downloadBean);

    }

    @Override
    public void update(DownloadBean downloadBean) {
downloadbeanDao.update(downloadBean);
    }

    @Override
    public void delete(DownloadBean downloadBean) {
downloadbeanDao.delete(downloadBean);
    }

    @Override
    public List<DownloadBean> query() {
        QueryBuilder<DownloadBean> queryBuilder = downloadbeanDao.queryBuilder();
        return queryBuilder.list();
    }

    private List<Property> conditionList = new ArrayList<>();

    @Override
    public List<DownloadBean> query(List<WhereCondition> whereConditionList) {
        conditionList.clear();
        QueryBuilder<DownloadBean> qb = downloadbeanDao.queryBuilder();
        //用户名
        for (WhereCondition whereCondition : whereConditionList) {
            qb.where(whereCondition);
        }
        List<DownloadBean> list = qb.list();
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }

    @Override
    public DownloadBean queryById(long id) {
        QueryBuilder<DownloadBean> qb = downloadbeanDao.queryBuilder();
        qb.where(InstallBeanDao.Properties.AppId.eq(id));
        List<DownloadBean> list = qb.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
