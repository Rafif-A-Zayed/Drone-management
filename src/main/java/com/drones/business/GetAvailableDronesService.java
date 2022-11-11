package com.drones.business;

import com.drones.model.Drone;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAvailableDronesService extends BusinessService <Void, List<Drone>> {
    @Override
    List<Drone> serviceLogic(Void request) {
        return null;
    }
}
