package com.drones.business;

import com.drones.enums.State;
import com.drones.exception.InvalidStateException;
import com.drones.exception.MissingMandatoryException;
import com.drones.exception.NotFoundException;
import com.drones.model.Drone;
import com.drones.service.DroneService;
import com.drones.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class LoadMedicationService extends BusinessService<LoadMedicationRequest,String> {

    @Autowired
    DroneService droneService;
    void validateRequest(LoadMedicationRequest request){

        // validate that medication list not empty
        if(request.getMedicationList() == null || request.getMedicationList().isEmpty()){
            throw new MissingMandatoryException(MessageFormat.format(AppConstant.MANDATORY_FIELD_MSG,
                    "Medication List") );
        }
        // check if drone exist
        Drone drone = droneService.get(request.getSerialNumber());
        if(drone == null){
            throw new NotFoundException(MessageFormat.format(AppConstant.NOT_FOUND_MSG,request.getSerialNumber()) );
        }
        // check drone state only idle drone can be loaded by medication
        if(State.IDLE.compareTo(drone.getState()) != 0){
            throw new InvalidStateException(MessageFormat.format(AppConstant.NOT_FOUND_MSG,drone.getState()) );
        }
        request.setDrone(drone);

        //Validate provided medication wight

    }
    @Override
    String serviceLogic(LoadMedicationRequest request) {

        // add drone medication
        request.getDrone().setMedications(request.getMedicationList());
        // update status
        request.getDrone().setState(State.LOADED);
        // update drone status
        droneService.save(request.getDrone());
        return "";
    }
}
