package com.drones.business;

import com.drones.model.Medication;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListMedicationService extends BusinessService<String,List<Medication>> {
    void validateRequest(String request){

    }
    @Override
    List<Medication> serviceLogic(String request) {
        return null;
    }
}
