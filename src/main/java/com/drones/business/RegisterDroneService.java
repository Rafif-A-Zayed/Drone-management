package com.drones.business;

import com.drones.enums.State;
import com.drones.model.Drone;
import com.drones.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDroneService extends BusinessService<Drone, String> {

    @Autowired
    DroneService droneService;

    @Override
    String serviceLogic(Drone request) {
        request.setState(State.IDLE);
        droneService.save(request);
        return "";
    }
}