package com.towerpeng.concept.designPattern.code.chain;

public class ARiskHandler implements IRiskHandler{
    @Override
    public boolean handle(String text) {
        System.out.println("风控校验A");
        return true;
    }
}
