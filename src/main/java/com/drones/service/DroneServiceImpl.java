package com.drones.service;

import com.drones.enums.State;
import com.drones.model.Drone;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class DroneServiceImpl implements DroneService{
    @Override
    public void save(@Valid @RequestBody Drone drone) {

    }

    @Override
    public Drone get(String serialNumber) {
        return null;
    }

    @Override
    public Drone listMedication(String serialNumber) {
        return null;
    }

    @Override
    public List<Drone> getDroneByState(State state) {
        return null;
    }


}
