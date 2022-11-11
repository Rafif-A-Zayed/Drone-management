package com.drones.business;

import org.springframework.stereotype.Component;

@Component
public class LoadMedicationService extends BusinessService<LoadMedicationRequest,String> {

    void validateRequest(LoadMedicationRequest request){

    }
    @Override
    String serviceLogic(LoadMedicationRequest request) {
        return null;
    }
}
