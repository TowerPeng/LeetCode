package com.towerpeng.concept.designPattern.singleton;

/**
 * 饿汉式 (线程安全，类加载时就初始化）
 * 缺点：不懒加载，资源浪费
 * @Author: 彭涛
 * @Date: 2026/3/19 15:52
 */
public class Hungry {

    private static final Hungry instance = new Hungry();
    private Hungry(){}

    public static Hungry getInstance(){
        return instance;
    }
}
