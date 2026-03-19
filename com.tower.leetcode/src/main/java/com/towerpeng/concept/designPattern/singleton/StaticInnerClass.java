package com.towerpeng.concept.designPattern.singleton;

/**
 * 静态内部类（线程安全，推荐）
 * jvm 懒加载，天然线程安全
 * @Author: 彭涛
 * @Date: 2026/3/19 16:00
 */
public class StaticInnerClass {

    private StaticInnerClass(){}

    private static class Holder{
        private static final StaticInnerClass INSTANCE = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance(){
        return Holder.INSTANCE;
    }

}
