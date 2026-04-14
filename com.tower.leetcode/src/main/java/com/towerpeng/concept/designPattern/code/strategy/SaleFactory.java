package com.towerpeng.concept.designPattern.code.strategy;

import lombok.Getter;

import java.util.HashMap;

public class SaleFactory {

    private static HashMap<UserTypeEnum, Isale> map = new HashMap<>();
//    static {
//        map.put(UserTypeEnum.STUDENT, new StudentSale());
//        map.put(UserTypeEnum.TEACHER, new TeacherSale());
//        map.put(UserTypeEnum.OLDMAN, new OldManSale());
//    }
    public Isale getSale(UserTypeEnum type){
        return map.get(type);
    }

    @Getter
    private static SaleFactory factory = new SaleFactory();

    public void register(UserTypeEnum type, Isale sale){
        map.put(type, sale);
    }

}
