package com.drones.business.v1;

import com.drones.business.BusinessServiceImpl;
import com.drones.enums.State;
import com.drones.model.Drone;
import com.drones.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAvailableDronesService extends BusinessServiceImpl<Void, List<Drone>> {
    @Autowired
    DroneService droneService;
    @Override
    public List<Drone> serviceLogic(Void request) {
        return droneService.getDroneByState(State.IDLE);
    }
}
