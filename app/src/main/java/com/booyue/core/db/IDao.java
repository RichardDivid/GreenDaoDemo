package com.booyue.core.db;

import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.10:07
 * 数据库操作基类
 */

public interface IDao<T> {
    SQLiteDatabase getReadableDatabase();
    SQLiteDatabase getWritableDatabase();
    void insert(T t);
    void update(T t);
    void delete(T t);
    //查询全部
    List<T> query();
    //按条件查询
    List<T> query(List<WhereCondition> whereConditionList);

    T queryById(long id);
}
