package com.drones.business;

import com.drones.business.request.LoadMedicationRequest;
import com.drones.enums.State;
import com.drones.exception.InvalidInputException;
import com.drones.exception.MissingMandatoryException;
import com.drones.exception.NotFoundException;
import com.drones.model.Drone;
import com.drones.model.Medication;
import com.drones.service.DroneService;
import com.drones.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.text.MessageFormat;

@Component
public class LoadMedicationService extends BusinessServiceImpl<LoadMedicationRequest, Void> {

    @Autowired
    DroneService droneService;

    void validateRequest(LoadMedicationRequest request) {

        // validate that medication list not empty
        if (request.getMedicationList() == null || request.getMedicationList().isEmpty()) {
            throw new MissingMandatoryException(MessageFormat.format(AppConstant.MANDATORY_FIELD_MSG,
                    "Medication List"));
        }

        // check if drone exist
        Drone drone = droneService.get(request.getSerialNumber());
        if (drone == null) {
            throw new NotFoundException(MessageFormat.format(AppConstant.NOT_FOUND_MSG, request.getSerialNumber()));
        }

        // check drone state only idle drone can be loaded by medication
        if (State.IDLE.compareTo(drone.getState()) != 0) {
            throw new InvalidInputException(MessageFormat.format(AppConstant.INVALID_STATE_MSG, drone.getState(), AppConstant.LOAD_MEDICATION_ACTION));
        }

        // check drone battery status
        if (drone.getCapacity() < 25) {
            throw new InvalidInputException(AppConstant.INVALID_DRONE_CAPACITY_MSG);
        }

        //Validate provided medication wight
        double sum = request.getMedicationList().stream().map(Medication::getWight).reduce(0.0, Double::sum);
        if (sum > drone.getWight()) {
            throw new InvalidInputException(MessageFormat.format(AppConstant.INVALID_WIGHT_MSG, sum, drone.getWight()));
        }

       // drone.setState(State.LOADING);
       // droneService.save(drone);
        request.setDrone(drone);
    }

    @Override

    public Void serviceLogic(LoadMedicationRequest request) {
        request.getDrone().setState(State.LOADING);
        droneService.save(request.getDrone());
        // add drone medication
        request.getDrone().setMedications(request.getMedicationList());
        // update status
        request.getDrone().setState(State.LOADED);
        // update drone status
        droneService.save(request.getDrone());
      return null;
    }
}
