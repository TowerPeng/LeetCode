package com.towerpeng.concept.designPattern.code.strategy;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;


@Service
public class TeacherSale implements Isale{
    @Override
    public BigDecimal sale(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.7"));
    }
    @PostConstruct
    public void init(){
        SaleFactory.getFactory().register(UserTypeEnum.TEACHER, this);
    }
}
