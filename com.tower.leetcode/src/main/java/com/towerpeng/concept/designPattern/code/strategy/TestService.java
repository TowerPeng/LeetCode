package com.towerpeng.concept.designPattern.code.strategy;

import java.math.BigDecimal;

public class TestService {

    public BigDecimal getDiscount(UserTypeEnum type, BigDecimal amount){
//        if(type == UserTypeEnum.STUDENT){
//            amount = amount.multiply(new BigDecimal("0.9"));
//        }else if(type == UserTypeEnum.TEACHER){
//            amount = amount.multiply(new BigDecimal("0.7"));
//        }else if(type == UserTypeEnum.OLDMAN){
//            amount = amount.multiply(new BigDecimal("0.8"));
//        }
        return amount;
    }

    public static void main(String[] args) {
//        System.out.println(new TestService().getDiscount(UserTypeEnum.STUDENT, new BigDecimal("100")));
        System.out.println(SaleFactory.getFactory().getSale(UserTypeEnum.STUDENT).sale(new BigDecimal("100")));

    }

}
