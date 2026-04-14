package com.towerpeng.concept.designPattern.code.singleton;

/**
 * 双重检查锁（线程安全，推荐）
 * @Author: 彭涛
 * @Date: 2026/3/19 15:57
 */
public class DoubleCheckLock {

    /**
     * volatile 关键字，禁止指令重排序
     */
    private static volatile DoubleCheckLock instance;
    private DoubleCheckLock(){}

    public static DoubleCheckLock getInstance(){
        if(instance==null){
            synchronized (DoubleCheckLock.class){
                if(instance==null){
                    //1、分配内存，2、初始化，3、赋值引用，如果不加volatile，可能会导致指令重排序，导致instance为null，直接空指针
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }

}
