package com.drones.business.v1;

import com.drones.business.BusinessServiceImpl;
import com.drones.business.v1.request.Request;
import com.drones.enums.State;
import com.drones.exception.InvalidInputException;
import com.drones.exception.NotFoundException;
import com.drones.model.Drone;
import com.drones.model.Medication;
import com.drones.service.DroneService;
import com.drones.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

import java.util.Set;

@Component
public class ListMedicationService extends BusinessServiceImpl<Request,Set<Medication>> {
    @Autowired
    DroneService droneService;
    void validateRequest(Request request){
        Drone drone = droneService.getWithMedication(request.getSerialNumber());
        if(drone == null){
            throw new NotFoundException(MessageFormat.format(AppConstant.NOT_FOUND_MSG,request.getSerialNumber()) );
        }
        // check drone status
        if(State.LOADED.compareTo(drone.getState()) != 0){
            throw new InvalidInputException(MessageFormat.format(AppConstant.INVALID_STATE_MSG,drone.getState()
                    , AppConstant.LIST_MEDICATION_ACTION) );
        }
        request.setDrone(drone);
    }
    @Override
    public Set<Medication> serviceLogic(Request request) {

        return request.getDrone().getMedications();
    }
}
