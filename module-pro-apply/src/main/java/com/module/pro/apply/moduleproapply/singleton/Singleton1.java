package com.module.pro.apply.moduleproapply.singleton;

/**
 * 饿汉式（直接实例化）
 * 构造器私有化
 * 自行创建，并且用静态变量保存
 * 向外提供
 */
public class Singleton1 {

    public static Singleton1 singleton1 = new Singleton1();
    private Singleton1(){

    }
}
