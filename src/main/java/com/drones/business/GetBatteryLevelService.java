package com.drones.business;

import com.drones.exception.NotFoundException;
import com.drones.model.Drone;
import com.drones.service.DroneService;
import com.drones.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class GetBatteryLevelService extends BusinessService<Request, Double> {
    @Autowired
    DroneService droneService;
    void validateRequest(Request request){
        Drone drone = droneService.get(request.getSerialNumber());
        if(drone == null){
            throw new NotFoundException(MessageFormat.format(AppConstant.NOT_FOUND_MSG,request.getSerialNumber()) );
        }
        request.setDrone(drone);
    }
    @Override
    Double serviceLogic(Request request) {
        return request.getDrone().getCapacity();
    }
}
