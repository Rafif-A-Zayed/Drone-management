package com.drones.business;


import com.drones.exception.NotFoundException;
import com.drones.model.Drone;
import com.drones.service.DroneService;
import com.drones.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class GetDroneService  extends BusinessServiceImpl<String, Drone> {

    @Autowired
    DroneService droneService;
    @Override
    public Drone serviceLogic(String request) {
        Drone drone =  droneService.get(request);
        if(drone == null){
            throw new NotFoundException(MessageFormat.format(AppConstant.NOT_FOUND_MSG,request) );
        }
        return drone;
    }
}
