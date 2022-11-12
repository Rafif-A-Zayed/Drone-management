package com.drones.service;


import com.drones.enums.State;
import com.drones.model.Drone;

import java.util.List;

public interface DroneService {

     void save(Drone drone);
     Drone get(String serialNumber);
     Drone listMedication(String serialNumber);
     List<Drone> getDroneByState(State state);

}
