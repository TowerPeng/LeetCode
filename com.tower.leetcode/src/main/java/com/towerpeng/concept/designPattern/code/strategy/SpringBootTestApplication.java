package com.towerpeng.concept.designPattern.code.strategy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringBootTestApplication {

    /**
     * 工厂+策略模式
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);
        Isale sale = SaleFactory.getFactory().getSale(UserTypeEnum.OLDMAN);
        if(sale != null){
            System.out.println(sale.sale(new BigDecimal("100")));
        }
    }
}
