package com.drones.service;

import com.drones.enums.State;
import com.drones.model.Drone;
import com.drones.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService{

    @Autowired
    DroneRepository droneRepository;
    @Override
    public void save(Drone drone) {
        droneRepository.save(drone);
    }

    @Override
    public Drone get(String serialNumber) {
        return droneRepository.getDroneBySerialNumber(serialNumber);
    }

    @Override
    public Drone listMedication(String serialNumber) {
        return droneRepository.getDroneBySerialNumber(serialNumber);
    }

    @Override
    public List<Drone> getDroneByState(State state) {
        return droneRepository.getDroneByState(state);
    }


}
