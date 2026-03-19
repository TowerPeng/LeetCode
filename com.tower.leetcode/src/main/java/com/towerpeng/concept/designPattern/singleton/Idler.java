package com.towerpeng.concept.designPattern.singleton;

/**
 * 懒汉式（线程不安全，需改进）
 * @Author: 彭涛
 * @Date: 2026/3/19 15:50
 */
public class Idler {

    private static Idler instance;
    private Idler(){
    }

//    public static Idler getInstance(){
//        if(instance == null){
//            instance = new Idler();
//        }
//        return instance;
//    }


    /**
     * 改进1：使用同步锁
     * @return
     */
    public static synchronized Idler getInstance(){
        if(instance == null){
            instance = new Idler();
        }
        return instance;
    }
}
