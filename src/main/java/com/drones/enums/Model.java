package com.drones.enums;

public enum Model {

    Lightweight,
    Middleweight,
    Cruiserweight,
    Heavyweight;


    public static Model getEnum(String value) {

       return Model.valueOf(value);

    }


}
