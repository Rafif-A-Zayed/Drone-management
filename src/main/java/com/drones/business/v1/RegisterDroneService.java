package com.drones.business.v1;


import com.drones.business.BusinessServiceImpl;
import com.drones.business.v1.request.AddUpdateDroneRequest;
import com.drones.enums.Model;
import com.drones.enums.State;

import com.drones.exception.InvalidInputException;
import com.drones.exception.InvalidOperationException;
import com.drones.model.Drone;
import com.drones.service.DroneService;

import com.drones.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;


@Component
public class RegisterDroneService extends BusinessServiceImpl<AddUpdateDroneRequest, Drone> {
    @Autowired
    DroneService droneService;

    private int count = 5;

    @Override
    protected void validateRequest(AddUpdateDroneRequest request) {
        // check if drone exist
        Drone drone = droneService.get(request.getSerialNumber());
        if (drone != null) {
            // check drone state only idle to can be updated
            if (State.IDLE.compareTo(drone.getState()) != 0) {
                throw new InvalidInputException(MessageFormat.format(AppConstant.INVALID_STATE_MSG, drone.getState(), AppConstant.UPDATE_DRONE_ACTION));
            }
        } else {
            if (count >= AppConstant.MAX_NUM_DRONE) {
                throw new InvalidOperationException(MessageFormat.format(AppConstant.INVALID_OPERATION_MSG, AppConstant.ADD_DRONE_ACTION));
            }
        }

        // validate drone model
        Model model = Model.getEnumByValue(request.getModel().name());
        if (model == null) {
            throw new InvalidInputException(AppConstant.INVALID_DRONE_MODEL_MSG);

        }


    }


    @Override
    public Drone serviceLogic(AddUpdateDroneRequest request) {

       Drone drone= droneService.save(Drone.builder().capacity(request.getCapacity())
                .state(State.IDLE)
                .serialNumber(request.getSerialNumber())
                 .wight(request.getWight())
                .model(request.getModel()).build());
        count++;
        return drone;
    }
}
