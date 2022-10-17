package com.example.poi.enums;

import lombok.Getter;

@Getter
public enum GoodsEnums {
    id(0),
    name(1),
    age(2);
    
    private final Integer code;
    
    GoodsEnums(Integer code) {
        this.code = code;
    }
}
