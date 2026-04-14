package com.towerpeng.concept.designPattern.code.strategy;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Service
public class OldManSale implements Isale{
    @Override
    public BigDecimal sale(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.8"));
    }

    @PostConstruct
    public void init(){
        SaleFactory.getFactory().register(UserTypeEnum.OLDMAN, this);
    }
}

