package cn.test.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 明文进行谜面进行加密
 * Created by xuh on 2017/8/16.
 */
public class ShiroMd5 {
    /**
     * 对用户密码进行 加盐加密
     * @param password
     * @param uuid
     * @return
     */
    public static String MD5(String password, String uuid){
        int hashIterations = 1024;    //加密的次数
        Object salt = uuid; //盐值
        Object credentials = password;   //密码
        String hashAlgorithmName = "MD5";   //加密方式
        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials,
                salt, hashIterations);
        return String.valueOf(simpleHash);
    }


}
