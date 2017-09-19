package cn.test.shiro.cache;

import cn.test.utils.LoggerUtils;
import cn.test.utils.SerializeUtil;
import org.apache.shiro.session.Session;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Redis管理类
 *
 * Redis Manager Utils
 *
 * Created by xuh on 2017/9/19.
 */
public class JedisManager {

    private JedisPool jedisPool;

    /**
     * 获取 jedis 资源
     * @return
     */
    public Jedis getJedis(){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (JedisConnectionException e) {
            String message = e.getMessage().trim();
            if("Could not get a resource from the pool".equalsIgnoreCase(message)) {
                System.out.println("----------- redis服务未启动 ----------");
                System.out.println("|1.如果没安装，请先安装后再启动项目");
                System.out.println("|2.请检查redis 服务是否启动。");
                System.exit(0);//停止项目
            }
            throw new JedisConnectionException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jedis;
    }

    public void returnResource(Jedis jedis, boolean isBroken) {
        if (jedis == null)
            return;
        jedis.close();
    }


    /**
     * 通过 key - value 的形式,获取缓存数据
     * @param dbIndex
     * @param key
     * @return
     * @throws Exception
     */
    public byte[] getValueByKey(int dbIndex, byte[] key) throws Exception {
        Jedis jedis = null;
        byte[] result = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            result = jedis.get(key);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
        return result;
    }

    /**
     * 删除缓存
     * @param dbIndex
     * @param key
     * @throws Exception
     */
    public void deleteByKey(int dbIndex, byte[] key) throws Exception {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            Long result = jedis.del(key);
            LoggerUtils.fmtDebug(getClass(), "删除Session结果：%s" , result);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
    }

    /**
     * 添加数据到缓存中
     * @param dbIndex
     * @param key
     * @param value
     * @param expireTime
     * @throws Exception
     */
    public void saveValueByKey(int dbIndex, byte[] key, byte[] value, int expireTime)
            throws Exception {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            jedis.set(key, value);
            if (expireTime > 0)
                jedis.expire(key, expireTime);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
    }

    /**
     * 获取所有Session
     * @param dbIndex
     * @param redisShiroSession
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Collection<Session> AllSession(int dbIndex, String redisShiroSession) throws Exception {
        Jedis jedis = null;
        boolean isBroken = false;
        Set<Session> sessions = new HashSet<Session>();
        try {
            jedis = getJedis();
            jedis.select(dbIndex);

            Set<byte[]> byteKeys = jedis.keys((JedisShiroSessionRepository.REDIS_SHIRO_ALL).getBytes());
            if (byteKeys != null && byteKeys.size() > 0) {
                for (byte[] bs : byteKeys) {
                    Session obj = SerializeUtil.deserialize(jedis.get(bs),
                            Session.class);
                    if(obj instanceof Session){
                        sessions.add(obj);
                    }
                }
            }
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
        return sessions;
    }



    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

}
