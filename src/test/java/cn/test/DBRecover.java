package cn.test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuh on 2017/9/4.
 */
public class DBRecover {


    /** 访问MySQL数据库服务器所在的url */
    private String serverUrl;
    /** 访问MySQL数据库的用户名 */
    private String username;
    /** 访问MySQL数据库的密码 */
    private String password;


    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DBRecover(String serverUrl,String username, String password) {
        super();
        this.serverUrl=serverUrl;
        this.username = username;
        this.password = password;
    }

    public String backup(String backupPath, String dbName) throws IOException {

        String backupFile = backupPath+ new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".sql";

        String mysql =backupPath+"mysqldump "+"--host="+serverUrl+" --user=" + username + " --password="+ password + " --opt " + dbName + "> "+backupFile ;

        System.out.println("备份"+mysql);
        java.lang.Runtime.getRuntime().exec("cmd /c " + mysql);


        System.out.println("备份成功!");

        return backupFile;

    }

    public void restore(String restoreFile, String dbName,String path) throws Exception {

        String mysql = path+"mysql "+"-h"+serverUrl+" -u" + username + " -p"+ password + " " + dbName + " < " + restoreFile;

        System.out.println("+++++++++++++++++++++++++++"+mysql);

        java.lang.Runtime.getRuntime().exec("cmd /c " + mysql);

        System.out.println("还原成功!");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        String s = "活动旨在为全省长笛学习者提供一个学习交流的平台，使业业余学习者感受长笛的音乐学习的专业氛围，提高学习兴趣。为浙江省青少年长笛乐团选拔优秀团员，期间设置大小型重奏、乐团排练课程等，增设浙江专家、国际专家专业指导等。训...";
        System.out.println(s.length());
    }

}
