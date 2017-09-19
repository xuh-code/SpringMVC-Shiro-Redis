package cn.test.shiro.service;

import org.apache.shiro.cache.Cache;

/**
 * shiro cache manager 接口
 *
 * Created by xuh on 2017/9/19.
 */
public interface ShiroCacheManager {


    public <K, V> Cache<K, V> getCache(String name);

    public void destroy();

}
