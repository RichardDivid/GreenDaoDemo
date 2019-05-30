package com.booyue.core.app;

/**
 * Created by Administrator on 2018/7/6.09:23
 * 全部配置的key类
 */

public enum  ConfigKeys {
    API_HOST,
    API_HOST_CLOUD,
    API_HOST_SERVICE,
    APPLICATION_CONTEXT,
    CONFIG_READY,
    DATABASE_NAME,
    DEBUG,
    DOWNLOAD_HELPER,
    DOWNLOAD_DAO,//默认是下载dao
    INSTALL_DAO,//记录安装或卸载需要通知服务，但是未成功，需要记录，以便日后网络正常再上传
    USERINFO
}
