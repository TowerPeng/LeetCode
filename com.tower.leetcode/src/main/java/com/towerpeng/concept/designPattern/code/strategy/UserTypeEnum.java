package com.towerpeng.concept.designPattern.code.strategy;

public enum UserTypeEnum {
    STUDENT(1),
    TEACHER(2),
    OLDMAN(3)
    ;

    private int type;
    UserTypeEnum(int type) {
        this.type = type;
    }
    public int getType() {
        return type;
    }
}
