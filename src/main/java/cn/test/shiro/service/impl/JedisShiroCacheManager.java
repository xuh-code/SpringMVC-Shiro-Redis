package cn.test.shiro.service.impl;

import cn.test.shiro.cache.JedisManager;
import cn.test.shiro.cache.JedisShiroCache;
import cn.test.shiro.service.ShiroCacheManager;
import org.apache.shiro.cache.Cache;

/**
 * JRedis管理
 *
 * Created by xuh on 2017/9/19.
 */
public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisManager jedisManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisManager());
    }

    @Override
    public void destroy() {
        //如果和其他系统，或者应用在一起就不能关闭
        getJedisManager().getJedis().shutdown();
    }


    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}
