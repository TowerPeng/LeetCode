package com.towerpeng.concept.designPattern.code.chain;

public class BRiskHandler implements IRiskHandler{
    @Override
    public boolean handle(String text) {
        System.out.println("风控校验B");
        return true;
    }
}
