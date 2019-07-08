package com.module.pro.apply.moduleproapply.singleton;

/**
 * 懒汉式(静态内部类)
 * 静态内部类不会随着外部类的加载而初始化，需要单独加载
 */
public class Singleton5 {

    private Singleton5(){
    }
    private static class Inner{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return Inner.INSTANCE;
    }
}
