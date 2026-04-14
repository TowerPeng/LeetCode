package com.towerpeng.concept.designPattern.code.chain;

public interface IRiskHandler {

    /**
     *  风控校验
     * @param text
     * @return
     */
    boolean handle(String text);
}
