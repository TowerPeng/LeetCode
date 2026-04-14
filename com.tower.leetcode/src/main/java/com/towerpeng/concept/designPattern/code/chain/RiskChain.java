package com.towerpeng.concept.designPattern.code.chain;

import java.util.ArrayList;
import java.util.List;

public class RiskChain {
    private final List<IRiskHandler> handlers = new ArrayList<>();

    public void addHandler(IRiskHandler handler){
        handlers.add(handler);
    }
    public boolean execute(String text){
        for (IRiskHandler handler : handlers) {
            if(!handler.handle(text)){
                return false;
            }
        }
        return true;
    }
}
