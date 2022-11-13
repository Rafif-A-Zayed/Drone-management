package com.drones.enums;

public enum Model {

    Lightweight,
    Middleweight,
    Cruiserweight,
    Heavyweight;


    public static Model getEnumByValue(String value) {

        for(Model model:Model.values()){
            if(model.name().equals(value))
                return model;
        }
        return null;

    }


}
