package com.drones.service;

import com.drones.model.Drone;
import com.drones.model.Medication;
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
    public void loadMedication(String serialNumber, @RequestBody List<@Valid Medication> medicationList) {

    }

    @Override
    public List<Medication> listMedication(String serialNumber) {
        return null;
    }

    @Override
    public Double getBattery(String serialNumber) {
        return null;
    }

    @Override
    public List<Drone> getAvailableDrone() {
        return null;
    }
}
