package com.booyue.core.app;

import android.content.Context;


/**
 * Created by Administrator on 2018/7/6.09:39
 * <p>
 * 项目初始化类
 */

public class ProjectInit {

    public ProjectInit init(Context context) {
        getConfigurator()
                .getConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return this;
    }

    private static final class ProjectInitHolder {
        private static final ProjectInit INSTANCE = new ProjectInit();
    }

    public static final ProjectInit getInstance() {
        return ProjectInitHolder.INSTANCE;
    }


    private static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    //获取配置信息
    public static synchronized <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    //保存配置信息
    public synchronized ProjectInit setConfiguration(Object key, Object value) {
        getConfigurator().getConfigs().put(key, value);
        return this;
    }

    public ProjectInit apiHost(String apiHost) {
        getConfigurator().getConfigs().put(ConfigKeys.API_HOST.name(), apiHost);
        return this;
    }
//       public ProjectInit apiCloudHost(String apiHost) {
//        getConfigurator().getConfigs().put(ConfigKeys.API_HOST_CLOUD.name(), apiHost);
//        return this;
//    }
//   public ProjectInit apiServiceHost(String apiHost) {
//        getConfigurator().getConfigs().put(ConfigKeys.API_HOST_SERVICE.name(), apiHost);
//        return this;
//    }



    //是否开启调式
    public ProjectInit debug(boolean isDebug) {
        getConfigurator().getConfigs().put(ConfigKeys.DEBUG.name(), isDebug);
        return this;
    }

    //设置数据库名称
    public ProjectInit databaseName(String dbName) {
        getConfigurator().getConfigs().put(ConfigKeys.DATABASE_NAME.name(), dbName);
        return this;
    }
    //初始化路由架构
//    public ProjectInit initARouter(Application application){
//        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
//            ARouter.openLog();     // 打印日志
//            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
//        ARouter.init(application);
//        return this;
//    }

    public static String getDatabaseName() {
        return getConfigurator().getConfiguration(ConfigKeys.DATABASE_NAME.name());
    }




    //配置host
    public static String getApiHost() {
        return getConfiguration(ConfigKeys.API_HOST.name());
    }
      //配置host
//    public static String getApiHostCloud() {
//        return getConfiguration(ConfigKeys.API_HOST_CLOUD.name());
//    }
//  public static String getApiHostService() {
//        return getConfiguration(ConfigKeys.API_HOST_SERVICE.name());
//    }



    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT.name());
    }

    public static boolean isDebug() {
        return getConfiguration(ConfigKeys.DEBUG.name());
    }
//    //数据库操作对象
//    public static DownloadDao getDao() {
//        return getConfiguration(ConfigKeys.DOWNLOAD_DAO.name());
//    }


    /**
     * 配置完成之后调用
     *
     * @return
     */
    public ProjectInit config() {
        getConfigurator().configure();
        return this;
    }
}
