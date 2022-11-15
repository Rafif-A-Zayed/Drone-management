package com.drones.business;


import com.drones.enums.Model;
import com.drones.enums.State;

import com.drones.exception.InvalidInputException;
import com.drones.model.Drone;
import com.drones.service.DroneService;

import com.drones.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;


@Component
public class RegisterDroneService extends BusinessService<Drone, Drone> {
    @Autowired
    DroneService droneService;
    void validateRequest(Drone request){
        // check if drone exist
        Drone drone = droneService.get(request.getSerialNumber());
        if (drone != null) {
            // check drone state only idle to can be updated
            if (State.IDLE.compareTo(drone.getState()) != 0) {
                throw new InvalidInputException(MessageFormat.format(AppConstant.INVALID_STATE_MSG, drone.getState(), AppConstant.UPDATE_DRONE_ACTION));
            }
        }

        // validate drone model
        Model model =  Model.getEnumByValue(request.getModel().name());
        if(model == null ){
            throw new InvalidInputException(AppConstant.INVALID_DRONE_MODEL_MSG);

        }


    }


    @Override
    Drone serviceLogic(Drone request) {
        request.setState(State.IDLE);
        request = droneService.save(request);
        return request;
    }
}
