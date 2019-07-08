package com.module.pro.apply.moduleproapply.singleton;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 饿汉式（静态代码块)
 */
public class Singleton3 {

    public static Singleton3 INSTANCE;
    private String info;

    static {
        try {
            Properties pro = new Properties();
            InputStream input = Singleton3.class.getClassLoader().getResourceAsStream("application.properties");
            pro.load(input);
            INSTANCE = new Singleton3(pro.getProperty("info"));
        } catch (IOException e) {
            System.err.println("-------------");
        }

    }

    private Singleton3(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public String getProperty(String str) {
        try {
            Properties pro = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties");
            pro.load(input);
            System.err.println(pro.getProperty(str)+"---");
            return pro.getProperty(str);
        }catch (IOException e){
            System.err.println("erro");
        }
        return "";

    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
