package com.drones.repository;

import com.drones.enums.State;
import com.drones.model.Drone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DroneRepository extends CrudRepository<Drone,String> {

    Drone getDroneBySerialNumber(String serialNumber);

    List<Drone> getDroneByState(State state);
}
