package com.drones.business;

import org.springframework.stereotype.Component;



@Component
public class GetBatteryLevelService extends BusinessService<String, Double> {

    void validateRequest(String request){

    }
    @Override
    Double serviceLogic(String request) {
        return null;
    }
}
