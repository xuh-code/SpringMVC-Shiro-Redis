package cn.test.shiro.service.impl;

import cn.test.shiro.service.ShiroCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

/**
 * shiro Custom Cache
 *
 * Created by xuh on 2017/9/19.
 */
public class AdminShiroCacheManager implements CacheManager,Destroyable {

    private ShiroCacheManager shiroCacheManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return shiroCacheManager.getCache(name);
    }

    @Override
    public void destroy() throws Exception {
    }

    public ShiroCacheManager getShiroCacheManager() {
        return shiroCacheManager;
    }

    public void setShiroCacheManager(ShiroCacheManager shiroCacheManager) {
        this.shiroCacheManager = shiroCacheManager;
    }

}
