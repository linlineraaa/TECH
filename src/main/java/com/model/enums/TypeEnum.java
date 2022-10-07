package com.model.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;


public enum TypeEnum implements IEnum {
    DISABLED(0, "DISABLED"),
    NORMAL(1, "normal");

    private final int value;
    private final String desc;

    TypeEnum(final int value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
