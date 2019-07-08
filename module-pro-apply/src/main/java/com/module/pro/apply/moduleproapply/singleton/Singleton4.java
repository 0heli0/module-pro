package com.module.pro.apply.moduleproapply.singleton;

/**
 * 懒汉式
 * 构造器私有化
 * 自行创建，并且用静态变量保存
 */
public class Singleton4 {

    private static Singleton4 singleton4;
    private Singleton4(){
    }
    public static Singleton4 getInstance(){
        if(singleton4 == null){
            synchronized (Singleton4.class){
                if (singleton4 == null){
                    singleton4 = new Singleton4();
                }

            }
        }
        return singleton4;
    }
}
