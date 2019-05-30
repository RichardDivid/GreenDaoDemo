package com.booyue.core.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * @author: wangxinhua
 * @date: 2018/11/14
 * @description :
 */
@Entity
public class InstallBean {
    @Id(autoincrement = true)
    public Long id;//数据表查询主键
    //1 install 2 uninstall
    public int operation;
    //用户id
    public String userId;
    //appid
    public long appId;
    //包名
    public String packageName;
    @Generated(hash = 1864866759)
    public InstallBean(Long id, int operation, String userId, long appId,
                       String packageName) {
        this.id = id;
        this.operation = operation;
        this.userId = userId;
        this.appId = appId;
        this.packageName = packageName;
    }
    @Generated(hash = 1608648177)
    public InstallBean() {
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
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public long getAppId() {
        return this.appId;
    }
    public void setAppId(long appId) {
        this.appId = appId;
    }
    public String getPackageName() {
        return this.packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
