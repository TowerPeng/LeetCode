package com.towerpeng.concept.designPattern.code.chain;

public class TestDemo {
    public static void main(String[] args) {
        RiskChain riskChain = new RiskChain();
        riskChain.addHandler(new ARiskHandler());
        riskChain.addHandler(new BRiskHandler());
        riskChain.addHandler(new CRiskHandler());
        riskChain.execute("test param");
        System.out.println("end");
    }
}
