package com.towerpeng.algorithm;

public class TestRun implements Runnable{
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("run");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestRun testRun = new TestRun();
        testRun.run();
        System.out.println("main");

    }
}
