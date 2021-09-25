package com.javacto.servlet.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class BaseDao {
    private static String getDriver;
    private static String getUrl;
    private static String getUser;
    private static String getPwd;

    static {
        try {
            Create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Create() throws IOException {
        //1.创建properties 对象
        Properties pr=new Properties();
        //2.取文件路径
        String path="Base.properties";
        //3.通过输入流读取路径
        InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(path);
        pr.load(is);
        //4.通过键 获取值
        getDriver=pr.getProperty("db.Driver");
        getUrl=pr.getProperty("db.url");
        getUser=pr.getProperty("db.username");
        getPwd=pr.getProperty("db.pwd");



    }

    public static Connection getConnection() throws Exception{
        Class.forName(getDriver);
        Connection connection= DriverManager.getConnection(getUrl,getUser,getPwd);
        return connection;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(BaseDao.getConnection());
    }
}
