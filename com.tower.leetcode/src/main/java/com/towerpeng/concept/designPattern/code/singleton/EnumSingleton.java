package com.towerpeng.concept.designPattern.code.singleton;

/**
 * 枚举单例
 * 防反射，防序列化
 * @Author: 彭涛
 * @Date: 2026/3/19 16:03
 */
public enum EnumSingleton {

    INSTANCE;

    public void doSomething(){
    }

    public static void main(String[] args) {
        //使用
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        singleton.doSomething();
    }

}