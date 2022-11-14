package com.drones.service;

import com.drones.enums.State;
import com.drones.model.Drone;
import com.drones.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {


    private final DroneRepository droneRepository;

    @Autowired
    DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public void save(Drone drone) {
        droneRepository.save(drone);
    }

    @Override
    public void saveAll(List<Drone> drone) {
        droneRepository.saveAll(drone);
    }

    @Override
    public Drone get(String serialNumber) {
        return droneRepository.findById(serialNumber).orElse(null);
    }

    @Override
    public Drone getWithMedication(String serialNumber) {
        return droneRepository.findById(serialNumber).orElse(null);
    }

    @Override
    public List<Drone> getDroneByState(State state) {
        return droneRepository.getDroneByState(state);
    }


}
