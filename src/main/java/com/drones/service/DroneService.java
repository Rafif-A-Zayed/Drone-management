package com.drones.service;


import com.drones.model.Drone;
import com.drones.model.Medication;

import java.util.List;

public interface DroneService {

     void save(Drone drone);
     void loadMedication(String serialNumber, List<Medication> medicationList);
     List<Medication> listMedication(String serialNumber);
     Double getBattery(String serialNumber);
     List<Drone> getAvailableDrone();

}
