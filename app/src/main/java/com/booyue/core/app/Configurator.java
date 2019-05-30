package com.booyue.core.app;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/7/6.09:24
 *
 * 全局配置管理类
 */

public class Configurator {
    //将所有的配置信息保存在map集合中
    private static final HashMap<Object,Object> CONFIGS=new HashMap<>();
    //保存所有的拦截器信息
//    private static final ArrayList<Interceptor> INTERCEPTORS=new ArrayList<>();
    //使用内部类实现单例
    private static final class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }
    //获取单例
    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    //初始化判断key赋值
    private Configurator(){
        CONFIGS.put(ConfigKeys.CONFIG_READY.name(),false);
    }

    //获取配置信息
    final HashMap<Object,Object> getConfigs(){
        return CONFIGS;
    }
    //获取拦截器数组
//    final ArrayList<Interceptor> getInterceptors(){
//        return INTERCEPTORS;
//    }

    /**
     * 获取配置中保存的配置
     * @param key 配置对应的key值
     * @param <T>
     * @return
     */
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) CONFIGS.get(key);
    }


    //检查配置是否完成
    private void checkConfiguration(){
        final boolean isReady=(boolean)CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configuration is not ready,call configure()");
        }
    }

    //配置完成,在所有信息配置完成之后调用此方法
    final void configure(){
        CONFIGS.put(ConfigKeys.CONFIG_READY.name(),true);
    }

}
