package com.drones.business;

import com.drones.enums.State;
import com.drones.exception.InvalidStateException;
import com.drones.exception.NotFoundException;
import com.drones.model.Drone;
import com.drones.model.Medication;
import com.drones.service.DroneService;
import com.drones.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

@Component
public class ListMedicationService extends BusinessService<Request,List<Medication>> {
    @Autowired
    DroneService droneService;
    void validateRequest(Request request){
        Drone drone = droneService.listMedication(request.getSerialNumber());
        if(drone == null){
            throw new NotFoundException(MessageFormat.format(AppConstant.NOT_FOUND_MSG,request.getSerialNumber()) );
        }
        // check drone status
        if(State.LOADED.compareTo(drone.getState()) != 0){
            throw new InvalidStateException(MessageFormat.format(AppConstant.NOT_FOUND_MSG,drone.getState()) );
        }
        request.setDrone(drone);
    }
    @Override
    List<Medication> serviceLogic(Request request) {

        return request.getDrone().getMedications();
    }
}
