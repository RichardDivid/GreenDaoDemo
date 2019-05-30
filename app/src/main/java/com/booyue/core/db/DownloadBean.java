package com.booyue.core.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author: wangxinhua
 * @date: 2018/11/14
 * @description :
 */
@Entity(nameInDb = "downloadbean")
public class DownloadBean {
    @Id(autoincrement = true)
    public Long id;//数据表查询主键
    //1 install 2 uninstall
    public int operation;
    //用户id
    public long userId;
    //appid
    public long appId;
    @Generated(hash = 1860818970)
    public DownloadBean(Long id, int operation, long userId, long appId) {
        this.id = id;
        this.operation = operation;
        this.userId = userId;
        this.appId = appId;
    }
    @Generated(hash = 2040406903)
    public DownloadBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getOperation() {
        return this.operation;
    }
    public void setOperation(int operation) {
        this.operation = operation;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getAppId() {
        return this.appId;
    }
    public void setAppId(long appId) {
        this.appId = appId;
    }


}
